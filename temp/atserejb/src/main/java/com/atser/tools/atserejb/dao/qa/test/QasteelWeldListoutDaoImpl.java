/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QasteelWeldListout;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QasteelWeldListoutDaoImpl extends GenericDao<BigDecimal, QasteelWeldListout> implements QasteelWeldListoutDao {

    @Override
    public Integer getNextTestNo(BigInteger testId) {
        String query = "SELECT NVL(MAX(no),0)+1 as no FROM qasteel_weld_listout WHERE test_id=:testId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testId", testId);
        try {
            Integer result = (Integer) q.getSingleResult();
            return (result != null) ? result : 1;
        } catch (NoResultException ex) {
            return 1;
        }
    }

    @Override
    public QasteelWeldListout findByTestId(BigInteger testId) {
        Query query = getEntityManager()
                .createNamedQuery("QasteelWeldListout.findByTestId")
                .setParameter("testId", testId);
        try {
            return (QasteelWeldListout) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
