/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobLabsMaster;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobLabsMasterDaoImpl extends GenericDao<BigDecimal, GlobLabsMaster> implements GlobLabsMasterDao {

    @Override
    public Boolean exists(BigInteger clientId, String name) {
        String query = "SELECT t.id FROM GLOB_LABS_MASTER t WHERE UPPER(t.lab_name) = UPPER(:name) AND t.client_id = :clientId AND t.deleted='N'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("name", name).setParameter("clientId", clientId);
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
