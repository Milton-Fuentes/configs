/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.common;

import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.objects.pojo.security.UserAuthorities;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;

@NoArgsConstructor
@Slf4j
@Named
public class JwtTokenProvider implements IBaseWSException {

    @Inject
    protected InitializeEnv env;

    private final Integer REFRESH_TOKEN_EXPIRATION = 1440; // In minutes

    private String getSecretKey() {
        String jwtGuid = env.getPropertiesMap().get("jwt_guid");
        return (StringSupport.isNullOrEmpty(jwtGuid)) ? "9108875c-0310-48f4-b761-f011f61b6e5f" : jwtGuid;
    }

    public String generateJwtToken(WsUsers user) {
        if (StringSupport.isNullOrEmpty(user.getUsername())) {
            log.error("Cannot create JWT Token without username");
            throwBaseException(Response.Status.BAD_REQUEST, "Cannot create JWT Token without username");
        }
        String jwtToken = JWT.create()
                .withHeader(buildHeaderClaims(user))
                //.withClaim("refreshToken", generateRefreshJwtToken(user))
                .withJWTId(StringSupport.generateUUID())
                .withIssuer("ATSER LP.")
                .withAudience("ATSER LP. Portal")
                .withIssuedAt(new Date())
                .withSubject(user.getUsername())
                .withExpiresAt(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, user.getCookie_xtime() / 60))
                .sign(Algorithm.HMAC512(getSecretKey()));
        log.info(String.format("#### generating token '%s' for '%s': ", jwtToken, user.getUsername()));
        return jwtToken;
    }

    public String generateRefreshJwtToken(WsUsers user) {
        if (StringSupport.isNullOrEmpty(user.getUsername())) {
            log.error("Cannot create JWT Token without username");
            throwBaseException(Response.Status.BAD_REQUEST, "Cannot create JWT Token without username");
        }
        String jwtToken = JWT.create()
                .withClaim("scope", "REFRESH_TOKEN")
                .withJWTId(StringSupport.generateUUID())
                .withIssuer("ATSER LP.")
                .withAudience("ATSER LP. Portal")
                .withIssuedAt(new Date())
                .withSubject(user.getUsername())
                .withExpiresAt(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, REFRESH_TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC512(getSecretKey()));
        log.info(String.format("#### generating refresh token '%s' for '%s': ", jwtToken, user.getUsername()));
        return jwtToken;
    }

    private Map<String, Object> buildHeaderClaims(WsUsers user) {
        List<UserAuthorities> userAuthorities = new ArrayList();
        Map<String, Object> headerClaims = new HashMap();
        headerClaims.put("isSuperUser", Boolean.FALSE);
        headerClaims.put("isAdmin", Boolean.FALSE);
        headerClaims.put("isUser", Boolean.TRUE);
        headerClaims.put("clientId", user.getClientId());
        headerClaims.put("authorities", userAuthorities);
        return headerClaims;
    }

    public JWTVerifier getJwtVerifier() {
        JWTVerifier verifier;
        try {
            Algorithm algorithm = Algorithm.HMAC512(getSecretKey());
            verifier = JWT.require(algorithm).withIssuer("ATSER LP.").build();
        } catch (JWTVerificationException ex) {
            throw new JWTVerificationException("Token cannot be verified");
        }
        return verifier;
    }

    public String getJwtId(String token) {
        JWTVerifier verifier = getJwtVerifier();
        return verifier.verify(token).getId();
    }

    public String getSubject(String token) {
        JWTVerifier verifier = getJwtVerifier();
        return verifier.verify(token).getSubject();
    }

    public boolean isTokenValid(String token) {
        JWTVerifier verifier = getJwtVerifier();
        return StringSupport.isNotNullAndNotEmpty(token) && !isTokenExpired(verifier, token);
    }

    private Boolean isTokenExpired(JWTVerifier verifier, String token) {
        Date expiration = verifier.verify(token).getExpiresAt();
        return expiration.before(new Date());
    }
}
