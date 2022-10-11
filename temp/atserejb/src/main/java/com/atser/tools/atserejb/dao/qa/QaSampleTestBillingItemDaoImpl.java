/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobBillingCodeCat;
import com.atser.tools.atserejb.model.QaSampleTestBillingItem;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleTestBillingItemDaoImpl extends GenericDao<BigDecimal, QaSampleTestBillingItem> implements QaSampleTestBillingItemDao {

    @Override
    public List<QaSampleTestBillingItem> listBySampleTestId(BigInteger sampleTestId) {
        String query = "select i.*, bc.billing_category_id, bc.standarditem, bc.unitofmeasure, bc.description, bc.cost_plus, bc.by_quotation, bc.material_use_id,"
                + " (select unitprice from billing_project_fee_schedule pfs, qa_sample_test t, glob_info ii where pfs.billing_code_id=i.billing_code_id and t.id=i.sample_test_id and t.info_id=ii.id and ii.project_id=pfs.project_id and t.test_date between pfs.start_date and pfs.end_date ) as unitprice"
                + " from qa_sample_test_billing_item i, glob_billing_code bc where i.billing_code_id=bc.id and sample_test_id = :sampleTestId AND active='Y' order by item_id";

        Query q = getEntityManager().createNativeQuery(query, GlobBillingCodeCat.class).setParameter("sampleTestId", sampleTestId);
        try {
            return q.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

}
