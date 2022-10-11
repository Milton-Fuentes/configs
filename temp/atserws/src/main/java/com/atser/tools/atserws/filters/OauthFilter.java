/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.filters;

import com.atser.tools.atserejb.model.WsAppOauth;
import com.atser.tools.atserejb.model.WsRigths;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserejb.service.ws.WsAppOauthService;
import com.atser.tools.atserejb.service.ws.WsOauthService;
import com.atser.tools.atserejb.service.ws.WsUsersService;
import com.atser.tools.atserutil.enumerator.eEntryPoint;
import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import com.atser.tools.atserutil.network.NetworkSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.security.UserTokenInformation;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.JwtTokenProvider;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import java.security.Principal;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@WsSecured
@Provider
@Priority(Priorities.AUTHENTICATION)
@Slf4j
public class OauthFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @EJB
    private WsOauthService wsOauthService;

    @EJB
    private WsAppOauthService wsAppOauthService;

    @EJB
    private WsUsersService wsUsersService;

    @EJB
    private InitializeEnv env;

    @Inject
    private JwtTokenProvider jwtTokenProvider;

    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
            .entity("You cannot access this resource").build();
    private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
            .entity("Access blocked for all users !!").build();

    @Override
    public void filter(ContainerRequestContext requestContext) {
        if (!env.getPropertiesMap().get("ws_env").equals("dev")) {
            Class<?> resourceClass = resourceInfo.getResourceClass();
            WsSecured classAnnot = resourceClass.getAnnotation(WsSecured.class);
            eEntryPoint entryPoint = classAnnot.entrypoint();
            Method method = resourceInfo.getResourceMethod();
            if (!method.isAnnotationPresent(PermitAll.class)) {
                //Access denied for all
                if (method.isAnnotationPresent(DenyAll.class)) {
                    requestContext.abortWith(ACCESS_FORBIDDEN);
                    return;
                }

                //Get request headers and cookies
                final MultivaluedMap<String, String> headers = requestContext.getHeaders();
                final UriInfo uriInfo = requestContext.getUriInfo();
                final List<String> XIp = headers.get("X-Real-IP");

                //If no IP information present; block access
                if (XIp == null || XIp.isEmpty()) {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
                // Get Http Method Info
                String httpMethod = getRequestMethod(method);
                if (httpMethod == null) {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
                // Get the access Token
                UserTokenInformation tokenInfo = getUserTokenInformation(requestContext, uriInfo.getPath());
                if (tokenInfo == null) {
                    requestContext.abortWith(ACCESS_DENIED);
                    return;
                }
                if (tokenInfo.getUserCategory().equals(eWsUserCategory.INTERNAL)) {
                    String userId;
                    // This is for internal auth users.
                    WsAppOauth globUserAuth = null;
                    // Validate token
                    userId = validateInternalAccessToken(headers, tokenInfo.getToken());
                    if (StringSupport.isNullOrEmpty(userId)) {
                        globUserAuth = wsAppOauthService.isTokenValid(tokenInfo.getToken(), false);
                    }

                    if (StringSupport.isNullOrEmpty(userId) && globUserAuth == null) {
                        requestContext.abortWith(ACCESS_DENIED);
                        return;
                    }

                    if (StringSupport.isNotNullAndNotEmpty(userId)) {
                        tokenInfo.setUserId(userId);
                        //Is allowed?
                        if (!isUserAllowed(userId, XIp.get(0), httpMethod, uriInfo.getPath())) {
                            requestContext.abortWith(ACCESS_DENIED);
                            return;
                        } else {
                            wsOauthService.extendTokenTime(tokenInfo.getToken());
                        }
                    } else if (globUserAuth != null) {
                        wsAppOauthService.extendTokenTime(globUserAuth);
                    }
                }
                requestContext.setSecurityContext(new SecurityContext() {
                    @Override
                    public Principal getUserPrincipal() {
                        WsUsers user;
                        if (entryPoint.equals(eEntryPoint.external)) {
                            user = wsUsersService.findById(tokenInfo.getUserId());
                        } else {
                            user = wsUsersService.findBySSO(tokenInfo.getUserId(), tokenInfo.getUserCategory());
                        }
                        return new AuthUser(user);
                    }

                    @Override
                    public boolean isUserInRole(String role) {
                        return true;
                    }

                    @Override
                    public boolean isSecure() {
                        return true;
                    }

                    @Override
                    public String getAuthenticationScheme() {
                        return null;
                    }
                });
            }
        } else {
            buildDefaultSecurityContext(requestContext);
        }
    }

    public void buildDefaultSecurityContext(ContainerRequestContext requestContext) {
        requestContext.setSecurityContext(new SecurityContext() {
            @Override
            public Principal getUserPrincipal() {
                return new AuthUser(wsUsersService.list(null).get(0));
            }

            @Override
            public boolean isUserInRole(String role) {
                return true;
            }

            @Override
            public boolean isSecure() {
                return true;
            }

            @Override
            public String getAuthenticationScheme() {
                return null;
            }
        });
    }

    private boolean isUserAllowed(final String userId, String ipaddress, String httpMethod, String path) {
        //List<WsRigths> rigthList = env.getOauthRigthsCache().get(userId);
        List<WsRigths> rigthList = wsUsersService.getRigthsByUserId(NumberSupport.getBigInteger(userId));
        for (WsRigths wsRigths : rigthList) {
            if (NetworkSupport.isIPAddressAllowed(wsRigths.getCidr(), ipaddress)) {
                if (NetworkSupport.isRESTPathAllowed(wsRigths.getServiceid().getPath(), path)) {
                    if (isHttpMethodAllowed(wsRigths.getRmode(), httpMethod)) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    private boolean isHttpMethodAllowed(String rmode, String requestMethod) {
        String[] arrayMode = rmode.trim().replaceAll("\\s+", "").split(",");
        for (String sm : arrayMode) {
            if (sm.equals(requestMethod)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    private String getRequestMethod(Method method) {
        if (method.isAnnotationPresent(POST.class)) {
            return "POST";
        } else if (method.isAnnotationPresent(GET.class)) {
            return "GET";
        }
        return null;
    }

    private String validateInternalAccessToken(MultivaluedMap<String, String> headers, String access_token) {
        if (StringSupport.isNullOrEmpty(access_token)) {
            return null;
        }
        // Validate BPM Access
        if (access_token.equals("UTH2929jdmKa82HTavDJ2jdma82-PQoda28-2847JHMN") && headers.containsKey("BPM-User")) {
            final List<String> bpmUser = headers.get("BPM-User");
            if (bpmUser == null || bpmUser.isEmpty()) {
                return null;
            }
            WsUsers userBpm = wsUsersService.findBySSO(bpmUser.get(0), eWsUserCategory.INTERNAL);
            if (userBpm == null) {
                return null;
            }
            return userBpm.getId().toString();
        } else {
            return wsOauthService.validateAccessToken(access_token);
        }
    }

    private UserTokenInformation getUserTokenInformation(ContainerRequestContext requestContext, String requestPath) {
        final String authorizationHeader = requestContext.getHeaderString(AUTHORIZATION);
        final String authorizationRefreshHeader = requestContext.getHeaderString("Authorization-RefreshToken");
        final Map<String, Cookie> cookies = requestContext.getCookies();
        UserTokenInformation tokenInfo = new UserTokenInformation();
        try {
            if (StringSupport.isNotNullAndNotEmpty(authorizationRefreshHeader) && requestPath.contains("/jwt/refresh")) {
                String refresh_access_token = authorizationRefreshHeader.substring("Bearer".length()).trim();
                if (!jwtTokenProvider.isTokenValid(refresh_access_token)) {
                    return null;
                }
                tokenInfo.setUserCategory(eWsUserCategory.EXTERNAL);
                tokenInfo.setToken(jwtTokenProvider.getJwtId(refresh_access_token));
                tokenInfo.setUserId(jwtTokenProvider.getSubject(refresh_access_token));
                return tokenInfo;
            }

            if (cookies != null && !cookies.isEmpty() && cookies.containsKey("ATSER-WS-TOKEN")) {
                tokenInfo.setUserCategory(eWsUserCategory.INTERNAL);
                tokenInfo.setToken(cookies.get("ATSER-WS-TOKEN").getValue());
                return tokenInfo;
            }
            if (StringSupport.isNotNullAndNotEmpty(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
                String access_token = authorizationHeader.substring("Bearer".length()).trim();
                if (access_token.length() > 36) {
                    if (!jwtTokenProvider.isTokenValid(access_token)) {
                        return null;
                    }
                    tokenInfo.setUserCategory(eWsUserCategory.EXTERNAL);
                    tokenInfo.setToken(jwtTokenProvider.getJwtId(access_token));
                    tokenInfo.setUserId(jwtTokenProvider.getSubject(access_token));
                    return tokenInfo;
                }
                tokenInfo.setUserCategory(eWsUserCategory.INTERNAL);
                tokenInfo.setToken(access_token);
                return tokenInfo;
            }
        } catch (com.auth0.jwt.exceptions.TokenExpiredException expireException) {
            return null;
        }
        return null;
    }
}
