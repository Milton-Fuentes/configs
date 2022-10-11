/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaconcMixdesignMaster;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless
public class QaconcMixdesignMasterDaoImpl extends GenericDao<BigDecimal, QaconcMixdesignMaster> implements QaconcMixdesignMasterDao {
    
    @Override
    public QaconcMixdesignMaster findByMixdesignNo(String mixdesignNo, BigInteger clientId) {
        Query q = getEntityManager()
                .createNamedQuery("QaconcMixdesignMaster.findByMixDesignNo")
                .setParameter("mixdesignNo", mixdesignNo)
                .setParameter("clientId", clientId);
        try {
            return (QaconcMixdesignMaster) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch(NonUniqueResultException ex) {
            System.out.println("@ERROR NonUniqueResultException.  QaconcMixdesignMasterDaoImpl: " + mixdesignNo);
            return (QaconcMixdesignMaster) q.getResultList().get(0);
        }
    }

    @Override
    public Boolean exists(BigInteger clientId, String name) {
        String query = "SELECT t.id FROM QACONC_MIXDESIGN_MASTER t WHERE UPPER(t.mixdesign_no) = UPPER(:name) AND t.client_id = :clientId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("name", name).setParameter("clientId", clientId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

}
