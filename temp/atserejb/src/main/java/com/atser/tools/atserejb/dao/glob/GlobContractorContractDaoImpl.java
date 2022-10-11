/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobContractorContract;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class GlobContractorContractDaoImpl extends GenericDao<BigDecimal, GlobContractorContract> implements GlobContractorContractDao {

    @Override
    public Boolean exists(BigInteger clientId, BigInteger projectId, BigInteger labId, BigInteger functionId) {
        String query = "SELECT t.id FROM GLOB_LABS t, GLOB_CONTRACTOR_CONTRACT ct WHERE t.id = ct.lab_id AND t.client_id = :clientId AND t.masterlabid = :masterlabId AND ct.function_id = :functionId AND ct.project_id = :projectId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("masterlabId", labId).setParameter("clientId", clientId).setParameter("functionId", functionId).setParameter("projectId", projectId);
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
    public BigDecimal findInfoId(BigInteger projectId, String functionName) {
        String query = "SELECT id FROM glob_info_detail WHERE project_id=:projectId AND lab_id IS NOT NULL AND function = :functionName";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId).setParameter("functionName", functionName);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            log.error("@Batch GlobContractorContractDaoImpl-findInfoId Duplicate: " + projectId + "-" + functionName);
            return null;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public GlobContractorContract findByIdAndExtend(BigDecimal id, String extend) {
        EntityGraph eg = getEntityManager().getEntityGraph(extend);
        try {
            GlobContractorContract model = (GlobContractorContract) getEntityManager().createNamedQuery("GlobContractorContract.findById")
                    .setParameter("id", id)
                    .setHint("javax.persistence.fetchgraph", eg)
                    .getSingleResult();
            return model;
        } catch (NoResultException ex) {
            return null;
        }
    }

}
