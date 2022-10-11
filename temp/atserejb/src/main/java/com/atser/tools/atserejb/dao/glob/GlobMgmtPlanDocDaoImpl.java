/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobMgmtPlanDoc;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobMgmtPlanDocDaoImpl extends GenericDao<BigDecimal, GlobMgmtPlanDoc> implements GlobMgmtPlanDocDao {

    @Override
    public void deactiveMain(BigInteger planId) {
        if (planId != null) {
            String query = "UPDATE GLOB_MGMT_PLAN_DOC SET main='N' WHERE plan_id=:planId AND main = 'Y' AND DELETED = 'N'";
            Query q = getEntityManager().createNativeQuery(query).setParameter("planId", planId);
            q.executeUpdate();
        }
    }

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger planId) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_MGMT_PLAN_DOC WHERE plan_id=:planId AND deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("planId", planId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getBigInteger(result) : BigInteger.ONE;
        } catch (NoResultException ex) {
            return BigInteger.ONE;
        }
    }
}
