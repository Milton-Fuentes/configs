/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.ws;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.WsAppOauth;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.core.Response;
import org.hibernate.exception.ConstraintViolationException;

@Stateless
public class WsAppOauthDaoImpl extends GenericDao<BigDecimal, WsAppOauth> implements WsAppOauthDao, IBaseEJBException {

    @Override
    public WsAppOauth save(WsAppOauth entity) {
        try {
            return super.save(entity);
        } catch (Exception ex) {
            Throwable t = ex.getCause();
            while ((t != null) && !(t instanceof ConstraintViolationException)) {
                t = t.getCause();
            }
            if (t instanceof ConstraintViolationException) {
                throwBaseException(Response.Status.CONFLICT, "Token already exists.");
            }
            throwBaseException(Response.Status.BAD_REQUEST, "Bad request.");
        }
        return null;
    }

    @Override
    public void disabledPreviousRecords(BigDecimal id) {
        if (id != null) {
            Query query = getEntityManager().createQuery("UPDATE WsAppOauth t SET t.active = :active WHERE t.userid.id = :userid");
            query.setParameter("active", 'N');
            query.setParameter("userid", id);
            query.executeUpdate();
        }
    }

    @Override
    public void disabledRecordByToken(String token) {
        if (token != null && !token.isEmpty()) {
            Query query = getEntityManager().createQuery("UPDATE WsAppOauth t SET t.active = :active WHERE t.accessToken = :token");
            query.setParameter("active", 'N');
            query.setParameter("token", token);
            query.executeUpdate();
        }
    }

    @Override
    public void verifyAccessToken() {
        List<WsAppOauth> list = findAll();
        Date today = new Date();
        list.forEach((record) -> {
            Date expire = record.getExpiryDate();
            if (DateSupport.minutesBeetwenDates(today, expire) <= 0) {
                disabledRecordByToken(record.getAccessToken());
            }
        });
    }

    @Override
    public String validateAccessToken(String accesstoken) {
        try {
            WsAppOauth record = (WsAppOauth) getEntityManager()
                    .createNamedQuery("WsAppOauth.findByAccessToken")
                    .setParameter("accessToken", accesstoken)
                    .getSingleResult();
            Date today = new Date();
            Date expire = record.getExpiryDate();

            if (DateSupport.minutesBeetwenDates(today, expire) <= 0) {
                disabledRecordByToken(record.getAccessToken());
                return null;
            }

            return record.getUserid().getId().toString();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public WsAppOauth isTokenValid(String accesstoken, Boolean loadUserInfo) {
        try {
            WsAppOauth record = (WsAppOauth) getEntityManager()
                    .createNamedQuery("WsAppOauth.findByAccessToken")
                    .setParameter("accessToken", accesstoken)
                    .getSingleResult();
            Date today = new Date();
            Date expire = record.getExpiryDate();

            if (DateSupport.minutesBeetwenDates(today, expire) <= 0) {
                return null;
            }
            if (loadUserInfo) {
                record.getUserid().getId().toString();
            }
            return record;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
