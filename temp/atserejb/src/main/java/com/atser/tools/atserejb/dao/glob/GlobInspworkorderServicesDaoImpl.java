/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobInspworkorderServices;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobInspworkorderServicesDaoImpl extends GenericDao<BigDecimal, GlobInspworkorderServices> implements GlobInspworkorderServicesDao {

    @Override
    public List<GlobInspworkorderServices> findByWOId(BigInteger id) {
        if (id == null) {
            return null;
        }
        try {
            List<GlobInspworkorderServices> array = getEntityManager().createNamedQuery("GlobInspworkorderServices.findByIwoId")
                    .setParameter("iwoId", id)
                    .getResultList();
            return array;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void deleteAllByWOId(BigInteger id) {
        if (id != null) {
            Query query = getEntityManager().createQuery("DELETE FROM GlobInspworkorderServices t WHERE t.iwoId = :iwoId");
            query.setParameter("iwoId", id);
            query.executeUpdate();
        }
    }

    @Override
    public Integer getCountWORecords(BigInteger id) {
        if (id != null) {
            Query query = getEntityManager().createQuery("SELECT COUNT(t) FROM GlobInspworkorderServices t WHERE t.iwoId = :iwoId");
            query.setParameter("iwoId", id);
            Integer value = Integer.valueOf(query.getSingleResult().toString());
            return value;
        }
        return 0;
    }

}
