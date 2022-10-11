/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobNotificationTrack;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class GlobNotificationTrackDaoImpl extends GenericDao<BigDecimal, GlobNotificationTrack> implements GlobNotificationTrackDao {

    @Override
    public GlobNotificationTrack findByToken(String token) {
        try {
            GlobNotificationTrack elem = (GlobNotificationTrack) getEntityManager()
                    .createNamedQuery("GlobNotificationTrack.findByUniqueToken")
                    .setParameter("uniqueToken", token)
                    .getSingleResult();
            return elem;
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefIdAndNotSended(String functionality, String refid) {
        try {
            return getEntityManager()
                    .createNamedQuery("GlobNotificationTrack.findByRefidAndNotSended")
                    .setParameter("refid", NumberSupport.getBigInteger(refid))
                    .setParameter("status", "SENDED")
                    .setParameter("functionality", functionality)
                    .getResultList();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefId(String functionality, String refid) {
        try {
            return getEntityManager()
                    .createNamedQuery("GlobNotificationTrack.findByRefid")
                    .setParameter("refid", NumberSupport.getBigInteger(refid))
                    .setParameter("functionality", functionality)
                    .getResultList();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobNotificationTrack> findAllByRefIdAndStatus(String functionality, String refid, String status) {
        try {
            return getEntityManager()
                    .createNamedQuery("GlobNotificationTrack.findByRefidAndStatus")
                    .setParameter("refid", NumberSupport.getBigInteger(refid))
                    .setParameter("status", status)
                    .setParameter("functionality", functionality)
                    .getResultList();
        } catch (javax.persistence.NoResultException ex) {
            return null;
        }
    }

}
