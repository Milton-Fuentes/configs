/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaSampleConcInfo;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleConcInfoDaoImpl extends GenericDao<BigDecimal, QaSampleConcInfo> implements QaSampleConcInfoDao {

    @Override
    public Boolean exists(BigDecimal sampleId) {
        String query = "SELECT t.sample_id FROM QA_SAMPLE_CONC_INFO t WHERE t.sample_id = :sampleId ";
        Query q = getEntityManager().createNativeQuery(query).setParameter("sampleId", sampleId);
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
