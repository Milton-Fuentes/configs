/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobSpecBookProj;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobSpecBookProjDaoImpl extends GenericDao<BigDecimal, GlobSpecBookProj> implements GlobSpecBookProjDao {

    @Override
    public List<GlobSpecBookProj> findByProjectId(BigInteger pId) {
        String query = "SELECT * FROM GLOB_SPEC_BOOK_PROJ WHERE PROJECT_ID = :pId";
        Query q = getEntityManager().createNativeQuery(query, GlobSpecBookProj.class).setParameter("pId", pId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
