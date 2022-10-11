/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobClientTest;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobClientTestDaoImpl extends GenericDao<BigDecimal, GlobClientTest> implements GlobClientTestDao {

    @Override
    public GlobClientTest findByTestId(BigInteger clientId, BigInteger testId) {
        String query = "SELECT t.* FROM GLOB_CLIENT_TEST t WHERE  t.test_id = :testId AND t.client_id = :clientId";
        Query q = getEntityManager().createNativeQuery(query, GlobClientTest.class).setParameter("clientId", clientId).setParameter("testId", testId);
        try {
            if (q.getSingleResult() != null) {
                return (GlobClientTest) q.getSingleResult();
            }
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public GlobClientTest findBySampleTestId(BigInteger clientId, BigInteger testId) {
        String query = "SELECT t.* FROM GLOB_CLIENT_TEST t, qa_sample_test st WHERE st.TEST_ID= t.test_id and st.id= :testId AND t.client_id = :clientId";
        Query q = getEntityManager().createNativeQuery(query, GlobClientTest.class).setParameter("clientId", clientId).setParameter("testId", testId);
        try {
            if (q.getSingleResult() != null) {
                return (GlobClientTest) q.getSingleResult();
            }
            return null;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
