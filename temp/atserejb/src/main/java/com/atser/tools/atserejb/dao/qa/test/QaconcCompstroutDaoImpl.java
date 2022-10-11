/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaconcCompstrout;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaconcCompstroutDaoImpl extends GenericDao<BigDecimal, QaconcCompstrout> implements QaconcCompstroutDao {

    @Override
    public QaconcCompstrout findByTestIdAndNo(BigInteger testId, String no) {
        Query query = getEntityManager().createNamedQuery("QaconcCompstrout.findByTestIdAndNo")
                .setParameter("testId", testId)
                .setParameter("no", no);
        try {
            return (QaconcCompstrout) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    /*public Boolean existsQaconcCompstrout(BigInteger sampleId, BigInteger sampletestId, Integer cNo) {
        String query = "SELECT d.id FROM qa_sample a, qa_sample_test b, qaconc_resistivity c,qaconc_resistivityout d WHERE a.id=b.sample_id AND b.id=c.sampletest_id AND c.id=d.test_id AND a.id = :sampleId AND b.id = :sampletestId AND d.cylinder_no = :cNo";
        Query q = getEntityManager().createNativeQuery(query).setParameter("sampleId", sampleId).setParameter("sampletestId", sampletestId).setParameter("cNo", cNo);
        try {
            if (q.getResultList() != null && q.getResultList().size() > 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }*/
}
