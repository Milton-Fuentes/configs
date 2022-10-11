/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.dao.ws.WsOauthDao;
import com.atser.tools.atserejb.model.WsOauth;
import com.atser.tools.atserejb.model.WsUsers;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WsOauthServiceImpl implements WsOauthService, IBaseEJBException {

    @Inject
    private WsOauthDao dao;

    @Override
    public WsOauth findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public WsOauth findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(WsOauth elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(WsOauth elem) {
        if (elem != null) {
            WsOauth model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void refreshToken(WsOauth elem) {
        if (elem != null) {
            dao.update(elem);
        }
    }

    @Override
    public void extendTokenTime(String accesstoken) {
        WsOauth activeRecord = dao.isTokenValid(accesstoken);
        if (activeRecord != null) {
            if (DateSupport.minutesBeetwenDates(new Date(), activeRecord.getExpiryDate()) <= 5) {
                activeRecord.setExpiryDate(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (activeRecord.getUserid().getCookie_xtime() / 60)));
                dao.update(activeRecord);
            }
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<WsOauth> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void registerOauthRecord(WsUsers userId, String token, Date expireDate) {
        //dao.disabledPreviousRecords(userId.getId());
        WsOauth oauth = new WsOauth();
        oauth.setUserid(userId);
        oauth.setExpiryDate(expireDate);
        oauth.setAccessToken(token);
        oauth.setActive('Y');
        dao.save(oauth);
    }

    @Override
    public String validateAccessToken(String accesstoken) {
        return dao.validateAccessToken(accesstoken);
    }

    @Override
    public WsUsers validateAccessTokenAndGetUser(String accesstoken) {
        return dao.validateAccessTokenAndGetUser(accesstoken);
    }

    @Override
    public WsOauth isTokenValid(String accesstoken) {
        return dao.isTokenValid(accesstoken);
    }

    @Override
    public void disabledPreviousRecords(BigDecimal id) {
        dao.disabledPreviousRecords(id);
    }

    @Override
    public void disabledRecordByToken(String token) {
        dao.disabledRecordByToken(token);
    }

    @Override
    public void verifyAccessToken() {
        dao.verifyAccessToken();
    }
}
