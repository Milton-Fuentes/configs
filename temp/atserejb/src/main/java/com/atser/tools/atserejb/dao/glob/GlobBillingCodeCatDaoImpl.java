/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobBillingCodeCat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobBillingCodeCatDaoImpl extends GenericDao<BigDecimal, GlobBillingCodeCat> implements GlobBillingCodeCatDao {

    @Override
    public List<GlobBillingCodeCat> listByProjectId(BigInteger clientId, BigInteger projectId) {
        //String query = "select * from glob_billing_code_cat where client_id=? and id in ( select distinct billing_category_id from billing_project_fee_schedule where project_id=?) order by list_order";
        String query = "select * from glob_billing_code_cat where "
                + " client_id=:clientId "
                + "and id in ( select distinct billing_category_id from billing_project_fee_schedule where "
                + "project_id=:projectId) "
                + "order by list_order";

        Query q = getEntityManager().createNativeQuery(query, GlobBillingCodeCat.class).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
