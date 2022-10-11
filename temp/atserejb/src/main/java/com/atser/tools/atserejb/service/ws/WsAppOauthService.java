/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.model.WsAppOauth;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface WsAppOauthService {

    WsAppOauth findById(String id);

    void save(WsAppOauth elem);

    void update(WsAppOauth elem);

    void refreshToken(WsAppOauth elem);

    void delete(String id);

    List<WsAppOauth> list(ManageITBodyRequest request);

    void registerOauthRecord(GlobUsers userId, String token, Date expireDate);

    String validateAccessToken(String accesstoken);

    WsAppOauth isTokenValid(String accesstoken, Boolean loadUserInfo);

    void disabledPreviousRecords(BigDecimal id);

    void disabledRecordByToken(String token);

    void verifyAccessToken();

    void extendTokenTime(String access_token);

    void extendTokenTime(WsAppOauth access_token);
}
