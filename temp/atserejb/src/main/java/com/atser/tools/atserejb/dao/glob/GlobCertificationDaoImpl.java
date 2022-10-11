/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobCertification;
import com.atser.tools.atserejb.model.VwClientTests;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobCertificationDaoImpl extends GenericDao<BigDecimal, GlobCertification> implements GlobCertificationDao {

    @Override
    public List<VwClientTests> findAllPendingTest(BigInteger clientId, BigInteger certificationId) {
        String query = "SELECT * FROM vw_client_tests t WHERE t.client_id = :clientId AND t.test_id not in (SELECT ct.test_id FROM glob_certification_test ct WHERE ct.qualification_id = :certId)";
        Query q = getEntityManager().createNativeQuery(query, VwClientTests.class).setParameter("clientId", clientId).setParameter("certId", certificationId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return new ArrayList<>();
        }
    }

}
