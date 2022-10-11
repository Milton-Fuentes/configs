/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaaspmMixdesignsDaoImpl extends GenericDao<BigDecimal, QaaspmMixdesigns> implements QaaspmMixdesignsDao {

    @Override
    public Boolean exists(BigInteger projectId, String name) {
        String query = "SELECT t.id FROM QAASPM_MIXDESIGNS t WHERE UPPER(t.mixdesign) = UPPER(:name) AND t.project_id = :projectId AND t.deleted = 'N' AND t.active = 'Y'";
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
        String query = "UPDATE qaaspm_mixdesigns SET active = :status WHERE masterrefid = :masterId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("status", status).setParameter("masterId", masterId);
        q.executeUpdate();
    }

}
