/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSampleTestEquip;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleTestEquipDaoImpl extends GenericDao<BigDecimal, QaSampleTestEquip> implements QaSampleTestEquipDao {

    @Override
    public Boolean exists(BigInteger sampleTestId, BigInteger equipId) {
        String query = "SELECT t.id FROM QA_SAMPLE_TEST_EQUIP t WHERE t.sample_test_id = :sampleTestId AND t.equip_id = :equipId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("sampleTestId", sampleTestId)
                .setParameter("equipId", equipId);
        try {
            return (q.getResultList() != null && q.getResultList().size() > 0);
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

}
