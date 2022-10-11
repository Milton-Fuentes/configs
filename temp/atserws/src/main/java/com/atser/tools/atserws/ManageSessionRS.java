/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws;

import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.WsOauth;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserejb.service.glob.GlobProfilesService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.ws.WsAppOauthService;
import com.atser.tools.atserejb.service.ws.WsOauthService;
import com.atser.tools.atserejb.service.ws.WsUsersService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.eWsUserCategory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.atser.tools.atserutil.objects.pojo.security.Credentials;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.common.JwtTokenProvider;
import com.atser.tools.atserws.filters.AuthUser;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.security.PermitAll;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.time.temporal.ChronoUnit;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/auth")
@WsSecured
@Slf4j
public class ManageSessionRS implements IBaseWSException {

    @EJB
    private WsUsersService wsUsersService;

    @EJB
    private WsOauthService wsOauthService;

    @EJB
    private GlobUserService globUserService;

    @EJB
    private WsAppOauthService wsAppOauthService;

    @EJB
    private GlobProfilesService globProfilesService;

    @Inject
    private JwtTokenProvider jwtTokenProvider;

    @Context
    SecurityContext securityContext;

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response doLogin(Credentials auth, @CookieParam("ATSER-WS-TOKEN") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        try {
            if (StringSupport.isNullOrEmpty(auth.getUsername(), auth.getPassword())) {
                return Response.status(UNAUTHORIZED).build();
            }
            
            if (cookie != null && cookie.getValue() != null && !cookie.getValue().isEmpty()) {
                WsOauth activeRecord = wsOauthService.isTokenValid(cookie.getValue());
                if (activeRecord != null) {
                    ResponseBuilder builder = Response.ok();
                    builder.cookie(new NewCookie("ATSER-WS-TOKEN", cookie.getValue(), "/ws", null, 1, "no-comment", activeRecord.getUserid().getCookie_xtime(), new Date(System.currentTimeMillis() + (activeRecord.getUserid().getCookie_xtime() * 1000)), true, true));
                    activeRecord.setExpiryDate(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (activeRecord.getUserid().getCookie_xtime() / 60)));
                    wsOauthService.refreshToken(activeRecord);
                    return builder.status(Response.Status.OK).build();
                }
            }

            String username = auth.getUsername();
            // Password will be send encrypted using Base64
            String pwd = new String(Base64.getDecoder().decode(auth.getPassword().getBytes()));
            WsUsers authuser = wsUsersService.authUser(username, pwd, eWsUserCategory.INTERNAL);

            if (authuser != null) {
                String authToken = StringSupport.generateUUID();
                ResponseBuilder builder = Response.ok();
                builder.cookie(new NewCookie("ATSER-WS-TOKEN", authToken, "/ws", null, 1, "no-comment", authuser.getCookie_xtime(), new Date(System.currentTimeMillis() + (authuser.getCookie_xtime() * 1000)), true, true));
                wsOauthService.registerOauthRecord(authuser, authToken, DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (authuser.getCookie_xtime() / 60)));
                return builder.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

        return Response.status(UNAUTHORIZED).build();
    }

    @GET
    @Path("/logout")
    public Response doLogout(@CookieParam("ATSER-WS-TOKEN") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        if (cookie != null && cookie.getValue() != null && !cookie.getValue().isEmpty()) {
            wsOauthService.disabledRecordByToken(cookie.getValue());
        }
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/external/app/login")
    public Response doExternalAppLogin(Credentials auth) throws JsonParseException, JsonMappingException, IOException {
        if (auth == null || StringSupport.isNullOrEmpty(auth.getUsername(), auth.getPassword())) {
            return Response.status(UNAUTHORIZED).build();
        }

        Map<String, Object> respMap = new HashMap<>();
        String username = auth.getUsername();
        // Password will be send encrypted using Base64
        try {
            String pwd = new String(Base64.getDecoder().decode(auth.getPassword().getBytes()));
            GlobUsers userId = globUserService.authUser(username, pwd);
            if (userId != null) {
                String authToken = StringSupport.generateUUID();
                respMap.put("ATSER-WS-TOKEN", new NewCookie("ATSER-WS-TOKEN", authToken, "/ws", null, 1, "no-comment", 3600, new Date(System.currentTimeMillis() + (3600 * 1000)), true, true));
                wsAppOauthService.registerOauthRecord(userId, authToken, DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (3600 / 60)));
                if (userId.getDefaultProfile() != null) {
                    respMap.put("USER_PROFILE", globProfilesService.findById(userId.getDefaultProfile().toString()));
                }
                ResponseBuilder builder = Response.ok(respMap);
                return builder.build();
            }
        } catch (Exception ex) {
            return Response.status(UNAUTHORIZED).build();
        }

        return Response.status(UNAUTHORIZED).build();
    }

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/external/login")
    public Response doExternalLogin(Credentials auth) throws JsonParseException, JsonMappingException, IOException {
        if (auth == null || StringSupport.isNullOrEmpty(auth.getUsername(), auth.getPassword())) {
            return Response.status(UNAUTHORIZED).build();
        }

        Map<String, Object> respMap = new HashMap<>();
        String username = auth.getUsername();
        // Password will be send encrypted using Base64
        try {
            String pwd = new String(Base64.getDecoder().decode(auth.getPassword().getBytes()));
            WsUsers userId = wsUsersService.authUser(username, pwd, eWsUserCategory.INTERNAL);

            if (userId != null) {
                String authToken = StringSupport.generateUUID();
                respMap.put("ATSER-WS-TOKEN", new NewCookie("ATSER-WS-TOKEN", authToken, "/ws", null, 1, "no-comment", userId.getCookie_xtime(), new Date(System.currentTimeMillis() + (userId.getCookie_xtime() * 1000)), false, false));
                wsOauthService.registerOauthRecord(userId, authToken, DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (userId.getCookie_xtime() / 60)));
                ResponseBuilder builder = Response.ok(respMap);
                return builder.build();
            }
        } catch (Exception ex) {
            return Response.status(UNAUTHORIZED).build();
        }

        return Response.status(UNAUTHORIZED).build();
    }

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/jwt/login")
    public Response doJwtLogin(Credentials auth) throws JsonParseException, JsonMappingException, IOException {
        if (auth == null || StringSupport.isNullOrEmpty(auth.getUsername(), auth.getPassword())) {
            return Response.status(UNAUTHORIZED).build();
        }
        //logger.info("#### login/password : " + auth.getUsername() + "/" + auth.getPassword());
        String username = auth.getUsername();
        try {
            // Password will be send encrypted using Base64
            String pwd = new String(Base64.getDecoder().decode(auth.getPassword().getBytes()));
            WsUsers authuser = wsUsersService.authUser(username, pwd, eWsUserCategory.EXTERNAL);
            if (authuser != null) {
                ResponseBuilder builder = Response.ok();
                builder.header(AUTHORIZATION, "Bearer " + jwtTokenProvider.generateJwtToken(authuser));
                builder.header("Authorization-RefreshToken", "Bearer " + jwtTokenProvider.generateRefreshJwtToken(authuser));
                return builder.status(Response.Status.OK).build();
            }
        } catch (Exception ex) {
            return Response.status(UNAUTHORIZED).build();
        }
        return Response.status(UNAUTHORIZED).build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/jwt/refresh")
    public Response doJwtRefreshLogin() {
        WsUsers authuser = ((AuthUser) securityContext.getUserPrincipal()).getWsUser();
        if (authuser != null) {
            log.info(authuser.toString());
            ResponseBuilder builder = Response.ok();
            return builder.header(AUTHORIZATION, "Bearer " + jwtTokenProvider.generateJwtToken(authuser)).status(Response.Status.OK).build();
        }
        return Response.status(UNAUTHORIZED).build();
    }
}
