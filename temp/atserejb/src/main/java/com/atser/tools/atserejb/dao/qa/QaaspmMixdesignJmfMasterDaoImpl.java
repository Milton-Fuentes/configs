/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaaspmMixdesignJmfMasterDaoImpl extends GenericDao<BigDecimal, QaaspmMixdesignJmfMaster> implements QaaspmMixdesignJmfMasterDao {

    @Override
    public Boolean exists(BigInteger mixId, BigInteger jmfno) {
        String query = "SELECT t.id FROM QAASPM_MIXDESIGN_JMF_MASTER t WHERE t.jmf_no = :jmfno AND t.mix_id = :mixId AND t.deleted='N'";
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
    public List<QaaspmMixdesignJmfMaster> filterJmfByProject(BigInteger projectId, BigInteger mixId) {
        String query = "SELECT jmfm.* FROM qaaspm_mixdesign_master mixm,qaaspm_mixdesign_jmf_master jmfm, qaaspm_mixdesigns mix WHERE mixm.id = mix.masterrefid AND mixm.id = jmfm.mix_id AND mix.project_id = :projectId AND mix.id = :mixId \n"
                + "AND jmfm.active = 'Y' AND jmfm.deleted = 'N' AND jmfm.jmf_no NOT IN (SELECT jmf.jmf_no FROM qaaspm_mixdesigns mix,qaaspm_mixdesigns_jmf jmf WHERE mix.id = jmf.mix_design_id AND mix.project_id = :projectId AND mix.id = :mixId) ORDER BY jmfm.jmf_no ASC";
        Query q = getEntityManager().createNativeQuery(query, QaaspmMixdesignJmfMaster.class).setParameter("projectId", projectId).setParameter("mixId", mixId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void deactiveMain(BigInteger mixId) {
        if (mixId != null) {
            String query = "UPDATE QAASPM_MIXDESIGN_JMF_MASTER SET main='N' WHERE mix_id=:mixId";
            Query q = getEntityManager().createNativeQuery(query).setParameter("mixId", mixId);
            q.executeUpdate();
        }
    }

    @Override
    public BigInteger getNextJMFNo(BigInteger mixId) {
        String query = "SELECT MAX(jmf_no) + 1 jmfno FROM qaaspm_mixdesign_jmf_master WHERE mix_id = :mixId";
        Query q = getEntityManager().createNativeQuery(query);
        q.setParameter("mixId", mixId);
        BigDecimal jno = (BigDecimal) q.getSingleResult();
        if (jno == null) {
            jno = BigDecimal.ONE;
        }
        return jno.toBigInteger();
    }

}
