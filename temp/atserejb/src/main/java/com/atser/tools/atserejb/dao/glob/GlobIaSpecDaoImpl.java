/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobIaSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobIaSpecDaoImpl extends GenericDao<BigDecimal, GlobIaSpec> implements GlobIaSpecDao {

    @Override
    public BigDecimal getMaxSpecIdByTypeAndClient(String specType, BigInteger clientId) {
        String query = "SELECT MAX(id) maxid FROM glob_ia_spec WHERE spec_type=:specType and client_id=:clientId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("specType", specType).setParameter("clientId", clientId);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
