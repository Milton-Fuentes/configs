/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobPortfolio;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobPortfolioDaoImpl extends GenericDao<BigDecimal, GlobPortfolio> implements GlobPortfolioDao {

    @Override
    public Boolean exists(BigInteger clientId, String code) {
        String query = "SELECT t.id FROM GLOB_PORTFOLIO t WHERE t.client_id = :clientId AND t.code = :code AND t.deleted = 'N' AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("clientId", clientId)
                .setParameter("code", code);
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
