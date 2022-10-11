/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSievelist;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

@Stateless
public class GlobSievelistDaoImpl extends GenericDao<BigDecimal, GlobSievelist> implements GlobSievelistDao {

    @Override
    public BigDecimal findIdByCommonName(String commonname) {
        String query = "SELECT ID FROM GLOB_SIEVELIST WHERE common_name = :name";
        Query q = getEntityManager().createNativeQuery(query).setParameter("name", commonname);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {
            return null;
        }
    }
}
