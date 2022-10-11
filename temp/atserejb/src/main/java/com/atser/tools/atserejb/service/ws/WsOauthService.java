/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.model.WsOauth;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface WsOauthService {

    WsOauth findById(String id);

    void save(WsOauth elem);

    void update(WsOauth elem);
    
    void refreshToken(WsOauth elem);
    
    void extendTokenTime(String accesstoken);

    void delete(String id);

    List<WsOauth> list(ManageITBodyRequest request);

    void registerOauthRecord(WsUsers userId, String token, Date expireDate);

    String validateAccessToken(String accesstoken);
    
    WsUsers validateAccessTokenAndGetUser(String accesstoken);

    WsOauth isTokenValid(String accesstoken);

    void disabledPreviousRecords(BigDecimal id);

    void disabledRecordByToken(String token);

    void verifyAccessToken();
}
