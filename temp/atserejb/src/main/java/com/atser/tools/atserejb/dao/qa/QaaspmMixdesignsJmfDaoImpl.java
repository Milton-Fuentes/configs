/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaaspmMixdesignsJmf;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaaspmMixdesignsJmfDaoImpl extends GenericDao<BigDecimal, QaaspmMixdesignsJmf> implements QaaspmMixdesignsJmfDao {

    @Override
    public Boolean exists(BigInteger mixId, BigInteger jmfno) {
        String query = "SELECT t.id FROM QAASPM_MIXDESIGNS_JMF t WHERE t.jmf_no = :jmfno AND t.mix_design_id = :mixId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("jmfno", jmfno).setParameter("mixId", mixId);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }
    
    @Override
    public void deactiveMain(BigInteger mixId) {
        if (mixId != null) {
            String query = "UPDATE QAASPM_MIXDESIGNS_JMF SET main='N' WHERE mix_design_id=:mixId";
            Query q = getEntityManager().createNativeQuery(query).setParameter("mixId", mixId);
            q.executeUpdate();
        }
    }

}
