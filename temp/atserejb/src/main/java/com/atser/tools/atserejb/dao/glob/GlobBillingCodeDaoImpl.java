/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobBillingCode;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobBillingCodeDaoImpl extends GenericDao<BigDecimal, GlobBillingCode> implements GlobBillingCodeDao {

    @Override
    public List<GlobBillingCode> listByCustomParams(BigInteger projectId, BigInteger billingCategoryId, Date testDate, BigInteger materialUseId) {
        String query = "SELECT bc.*, rtd.unitprice"
                + " FROM glob_project_fee_schedule pfs INNER JOIN glob_billing_rate_table rt ON pfs.rate_table_id=rt.id and :testDate between pfs.start_date and pfs.end_date"
                + " INNER JOIN glob_billing_rate_table_detail rtd ON rt.id=rtd.rate_table_id"
                + " INNER JOIN glob_billing_code bc ON rtd.billing_code_id=bc.id"
                + " WHERE bc.billing_category_id = :billingCategoryId AND pfs.project_id = :projectId"
                + " AND material_use_id=:materialUseId"
                + " ORDER BY bc.description";

        Query q = getEntityManager().createNativeQuery(query, GlobBillingCode.class)
                .setParameter("projectId", projectId)
                .setParameter("billingCategoryId", billingCategoryId)
                .setParameter("testDate", testDate)
                .setParameter("materialUseId", materialUseId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<GlobBillingCode> listByCustomParams(BigInteger projectId, BigInteger billingCategoryId, Date testDate) {

        String query = "SELECT bc.*, rtd.unitprice"
                + " FROM glob_project_fee_schedule pfs INNER JOIN glob_billing_rate_table rt ON pfs.rate_table_id=rt.id and :testDate, between pfs.start_date and pfs.end_date"
                + " INNER JOIN glob_billing_rate_table_detail rtd ON rt.id=rtd.rate_table_id"
                + " INNER JOIN glob_billing_code bc ON rtd.billing_code_id=bc.id"
                + " WHERE bc.billing_category_id = :billingCategoryId AND pfs.project_id = :projectId"
                + " ORDER BY bc.description";

        Query q = getEntityManager().createNativeQuery(query, GlobBillingCode.class)
                .setParameter("projectId", projectId)
                .setParameter("billingCategoryId", billingCategoryId)
                .setParameter("testDate", testDate);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }
}
