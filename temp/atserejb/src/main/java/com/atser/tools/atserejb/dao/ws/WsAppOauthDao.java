/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.WsAppOauth;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface WsAppOauthDao extends ICrudDao<BigDecimal, WsAppOauth> {

    void disabledPreviousRecords(BigDecimal id);

    void disabledRecordByToken(String token);

    String validateAccessToken(String accesstoken);

    WsAppOauth isTokenValid(String accesstoken, Boolean loadUserInfo);

    void verifyAccessToken();
}
