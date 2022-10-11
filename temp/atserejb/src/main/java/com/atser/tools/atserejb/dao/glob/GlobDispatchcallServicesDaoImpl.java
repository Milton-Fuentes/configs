/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobDispatchcallServicesDaoImpl extends GenericDao<BigDecimal, GlobDispatchcallServices> implements GlobDispatchcallServicesDao {

    @Override
    public List<GlobDispatchcallServices> findByCallLogId(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobDispatchcallServices> array = getEntityManager().createNamedQuery("GlobDispatchcallServices.findByCallLogId")
                    .setParameter("callLogId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void deleteAllByCallLogId(BigInteger id) {
        if (id != null) {
            Query query = getEntityManager().createQuery("DELETE FROM GlobDispatchcallServices t WHERE t.callLogId = :callLogId");
            query.setParameter("callLogId", id);
            query.executeUpdate();
        }
    }

    @Override
    public Integer getCountCallLogRecords(BigInteger id) {
        if (id != null) {
            Query query = getEntityManager().createQuery("SELECT COUNT(t) FROM GlobDispatchcallServices t WHERE t.callLogId = :callLogId");
            query.setParameter("callLogId", id);
            Integer value = Integer.valueOf(query.getSingleResult().toString());
            return value;
        }
        return 0;
    }

}
