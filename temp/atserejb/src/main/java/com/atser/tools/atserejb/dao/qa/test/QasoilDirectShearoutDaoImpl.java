/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasoilDirectShearout;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QasoilDirectShearoutDaoImpl extends GenericDao<BigDecimal, QasoilDirectShearout> implements QasoilDirectShearoutDao {

    @Override
    public QasoilDirectShearout findBySampleAndSampleTestId(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
         String query = "SELECT d.* FROM qa_sample a, qa_sample_test b, qasoil_direct_shear c, qasoil_direct_shearout d WHERE a.id=b.sample_id AND b.id=c.sampletest_id AND c.id=d.test_id AND a.id = :sampleId AND b.id = :sampletestId AND d.id = :specNo";
        Query q = getEntityManager().createNativeQuery(query, QasoilDirectShearout.class).setParameter("sampleId", sampleId).setParameter("sampletestId", sampletestId).setParameter("specNo", specNo);
        try {
            return (QasoilDirectShearout) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Boolean existsQasoilDirectShearout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo) {
        String query = "SELECT d.id FROM qa_sample a, qa_sample_test b, qasoil_direct_shear c,qasoil_direct_shearout d WHERE a.id=b.sample_id AND b.id=c.sampletest_id AND c.id=d.test_id AND a.id = :sampleId AND b.id = :sampletestId AND d.id = :specNo";
        Query q = getEntityManager().createNativeQuery(query).setParameter("sampleId", sampleId).setParameter("sampletestId", sampletestId).setParameter("specNo", specNo);
        try {
            if (q.getResultList() != null && q.getResultList().size() > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
    
}
