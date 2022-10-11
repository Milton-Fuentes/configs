/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSampleTestDaysSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleTestDaysSpecDaoImpl extends GenericDao<BigDecimal, QaSampleTestDaysSpec> implements QaSampleTestDaysSpecDao {
    
    @Override
    public QaSampleTestDaysSpec findBySampleTestIdAndTestAge(BigInteger sampleTestId, String testAge, Boolean isHours) {
        StringBuilder query = new StringBuilder("SELECT t.* FROM qa_sample_test_days_spec t WHERE t.sample_test_id = :sampleTestId AND t.active = 'Y'");
        if (isHours) {
            query.append(" AND t.testage_hours = :testAge");
        } else {
            query.append(" AND t.testage = :testAge");
        }
        Query q = getEntityManager().createNativeQuery(query.toString(), QaSampleTestDaysSpec.class)
                .setParameter("sampleTestId", sampleTestId)
                .setParameter("testAge", testAge);
        try {
            return (QaSampleTestDaysSpec) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
