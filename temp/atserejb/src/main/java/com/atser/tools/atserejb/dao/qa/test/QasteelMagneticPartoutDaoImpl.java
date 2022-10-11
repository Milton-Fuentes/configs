/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasteelMagneticPartout;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class QasteelMagneticPartoutDaoImpl extends GenericDao<BigDecimal, QasteelMagneticPartout> implements QasteelMagneticPartoutDao {

    @Override
    public Integer getNextTestNo(BigInteger testId) {
        String query = "SELECT NVL(MAX(no),0)+1 as no FROM qasteel_magnetic_partout WHERE test_id=:testId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testId", testId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getInteger(result) : 1;
        } catch (NoResultException ex) {
            return 1;
        }
    }

    @Override
    public QasteelMagneticPartout findByTestId(BigInteger testId) {
        Query query = getEntityManager()
                .createNamedQuery("QasteelMagneticPartout.findByTestId")
                .setParameter("testId", testId);
        try {
            return (QasteelMagneticPartout) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }

    }
}
