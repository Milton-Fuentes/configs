/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobFunctions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobFunctionsDaoImpl extends GenericDao<BigDecimal, GlobFunctions> implements GlobFunctionsDao {

    @Override
    public List<GlobFunctions> filterByProject(BigInteger projectId, BigInteger labId) {
        String query = "SELECT gf.* FROM glob_functions gf, glob_project_functions gpf WHERE gpf.project_id = :projectId AND gf.id = gpf.function_id AND gpf.function_id not in (SELECT gl.function_id FROM glob_labs_master lm, glob_labs gl, GLOB_CONTRACTOR_CONTRACT gcc WHERE lm.id = gl.masterlabid AND gl.ID = gcc.LAB_ID AND lm.id = :labId AND gcc.PROJECT_ID = :projectId) ORDER BY gf.f_name ASC";
        Query q = getEntityManager().createNativeQuery(query, GlobFunctions.class).setParameter("projectId", projectId).setParameter("labId", labId);
        try {
            return q.getResultList();            
        } catch (NoResultException ex) {
           return null;
        }
    }
}
