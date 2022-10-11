/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSieveListClient;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless
public class GlobSieveListClientDaoImpl extends GenericDao<BigDecimal, GlobSieveListClient> implements GlobSieveListClientDao {

    @Override
    public GlobSieveListClient findIdByCommonName(String commonname) {
        String query = "SELECT m.* FROM GLOB_SIEVELIST_CLIENT m WHERE m.common_name = :name";
        Query q = getEntityManager().createNativeQuery(query, GlobSieveListClient.class).setParameter("name", commonname);
        try {
            return (GlobSieveListClient) q.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }

}
