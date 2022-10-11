/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless
public class QaconcMixdesignsDaoImpl extends GenericDao<BigDecimal, QaconcMixdesigns> implements QaconcMixdesignsDao {

    @Override
    public Boolean exists(BigInteger projectId, String name) {
        String query = "SELECT t.id FROM QACONC_MIXDESIGNS t WHERE UPPER(t.mix_design) = UPPER(:name) AND t.project_id = :projectId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("name", name).setParameter("projectId", projectId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

    @Override
    public void changeStatusByMasterId(Character status, BigInteger masterId) {
        String query = "UPDATE qaconc_mixdesigns SET active = :status WHERE masterrefid = :masterId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("status", status).setParameter("masterId", masterId);
        q.executeUpdate();
    }

    @Override
    public QaconcMixdesigns findByMasterRefAndProject(BigInteger projectId, BigInteger masterRefId) {
        Query q = getEntityManager().createNamedQuery("QaconcMixdesigns.findByMasterRefAndProject")
                .setParameter("masterRefId", masterRefId)
                .setParameter("projectId", projectId);
        try {
            return (QaconcMixdesigns) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public QaconcMixdesigns findByMixdesignNo(BigInteger projectId, String mixdesignNo) {
        Query q = getEntityManager()
                .createNamedQuery("QaconcMixdesigns.findByMixDesignNo")
                .setParameter("mixDesign", mixdesignNo)
                .setParameter("projectId", projectId);
        try {
            return (QaconcMixdesigns) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch(NonUniqueResultException ex) {
            System.out.println("@ERROR NonUniqueResultException.  QaconcMixdesignsDaoImpl: " + mixdesignNo);
            return (QaconcMixdesigns) q.getResultList().get(0);
        }
    }

}
