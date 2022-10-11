/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobProjectSupplier;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobProjectSupplierDaoImpl extends GenericDao<BigDecimal, GlobProjectSupplier> implements GlobProjectSupplierDao {
    
    @Override
    public Boolean exists(BigInteger projectId, BigInteger supplierId) {
        String query = "SELECT t.id FROM GLOB_PROJECT_SUPPLIER t WHERE t.project_id = :projectId AND t.supplier_id = :supplierId AND t.active='Y'";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId).setParameter("supplierId", supplierId);
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
