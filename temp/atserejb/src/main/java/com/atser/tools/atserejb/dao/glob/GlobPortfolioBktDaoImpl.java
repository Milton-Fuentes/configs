/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobPortfolioBkt;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobPortfolioBktDaoImpl extends GenericDao<BigDecimal, GlobPortfolioBkt> implements GlobPortfolioBktDao {

    @Override
    public Boolean exists(BigInteger portfolioId, BigInteger projectId, String projectType) {
        String query = "SELECT t.id FROM GLOB_PORTFOLIO_BKT t WHERE t.portfolio_id = :portfolioId AND t.project_id = :projectId AND t.project_type = :projectType AND t.deleted = 'N' AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("portfolioId", portfolioId)
                .setParameter("projectId", projectId)
                .setParameter("projectType", projectType);
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
        }
    }

}
