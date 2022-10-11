/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTestPlanTests;
import com.atser.tools.atserutil.date.DateSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class QaTestPlanTestsDaoImpl extends GenericDao<BigDecimal, QaTestPlanTests> implements QaTestPlanTestsDao {

    @Override
    public void batchSaveItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId) {
        String query = "INSERT INTO qa_test_plan_tests(item_test_id,test_method_id,rms_no,rms_col, field1, last_mod_by, last_mod) \n"
                + "SELECT t.id item_test_id,test_method_id,rms_no,rms_col, :createdBy field1, :createdBy last_mod_by, :lastmod last_mod FROM qa_test_plan_item t, glob_biditem_tests p \n"
                + "WHERE t.item_id = p.item_test_id AND parent_id = 0 AND t.test_plan_id = :testplanId AND t.item_id = :itemId AND t.wbs_id=:wbsId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("testplanId", testplanId)
                .setParameter("createdBy", createdBy)
                .setParameter("itemId", itemId)
                .setParameter("wbsId", wbsId)
                .setParameter("lastmod", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        q.executeUpdate();
    }

    @Override
    public void batchSaveSubItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId) {
        String query = "INSERT INTO qa_test_plan_tests(item_test_id,test_method_id,rms_no,rms_col, field1, last_mod_by, last_mod) \n"
                + "SELECT t.id item_test_id,test_method_id,rms_no,rms_col, :createdBy field1, :createdBy last_mod_by, :lastmod last_mod FROM qa_test_plan_item t, glob_biditemsub_tests p, glob_biditemsub_com a \n"
                + "WHERE t.item_id=a.item_id AND t.sub_item_id=a.sub_item_id AND p.subitem_test_id=a.sub_item_id AND t.test_plan_id = :testplanId AND a.item_id = :itemId AND a.spec_pid=0 AND t.wbs_id=:wbsId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("testplanId", testplanId)
                .setParameter("createdBy", createdBy)
                .setParameter("itemId", itemId)
                .setParameter("wbsId", wbsId)
                .setParameter("lastmod", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        q.executeUpdate();
    }

}
