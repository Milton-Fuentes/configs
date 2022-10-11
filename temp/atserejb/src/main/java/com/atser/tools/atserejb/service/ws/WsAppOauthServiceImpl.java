/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.dao.ws.WsAppOauthDao;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.WsAppOauth;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WsAppOauthServiceImpl implements WsAppOauthService, IBaseEJBException {

    @Inject
    private WsAppOauthDao dao;

    @Override
    public WsAppOauth findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public WsAppOauth findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(WsAppOauth elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(WsAppOauth elem) {
        if (elem != null) {
            WsAppOauth model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void refreshToken(WsAppOauth elem) {
        if (elem != null) {
            dao.update(elem);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<WsAppOauth> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public void registerOauthRecord(GlobUsers userId, String token, Date expireDate) {
        //dao.disabledPreviousRecords(userId.getId());
        WsAppOauth oauth = new WsAppOauth();
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
    public WsAppOauth isTokenValid(String accesstoken, Boolean loadUserInfo) {
        return dao.isTokenValid(accesstoken, loadUserInfo);
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

    @Override
    public void extendTokenTime(String access_token) {
        if (StringSupport.isNotNullAndNotEmpty(access_token)) {
            WsAppOauth activeRecord = dao.isTokenValid(access_token, false);
            if (activeRecord != null) {
                if (DateSupport.minutesBeetwenDates(new Date(), activeRecord.getExpiryDate()) <= 5) {
                    activeRecord.setExpiryDate(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (3600 / 60)));
                    dao.update(activeRecord);
                }
            }
        }
    }

    @Override
    public void extendTokenTime(WsAppOauth access_token) {
        if (access_token != null) {
            if (DateSupport.minutesBeetwenDates(new Date(), access_token.getExpiryDate()) <= 5) {
                access_token.setExpiryDate(DateSupport.addChronoUnitToDate(new Date(), ChronoUnit.MINUTES, (3600 / 60)));
                dao.update(access_token);
            }
        }
    }

}
