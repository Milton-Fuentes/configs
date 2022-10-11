/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTestPlan;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaTestPlanDaoImpl extends GenericDao<BigDecimal, QaTestPlan> implements QaTestPlanDao {
    
    @Override
    public QaTestPlan batchGetTestPlan(BigInteger projectId) {
        String query = "SELECT ID, RMS_APPV FROM QA_TEST_PLAN WHERE project_id = :projectId AND active = 'Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId);
        try {
            QaTestPlan rp = new QaTestPlan();
            Object[] dto = (Object[]) q.getSingleResult();
            rp.setId(NumberSupport.getBigDecimal(dto[0]));
            rp.setRmsAppv(NumberSupport.getBigInteger(dto[1]));
            return rp;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getInitApproverEmail(BigInteger testplanid) {
        String query = "SELECT distinct gc.email FROM qa_test_plan qatp, glob_users gu, glob_contact gc where qatp.init_appv = gu.id AND gu.contactid = gc.id AND qatp.id = :testplanid";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testplanid", testplanid);
        try {
            return (String) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
