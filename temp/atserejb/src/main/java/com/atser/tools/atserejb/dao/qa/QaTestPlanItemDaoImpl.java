/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.QaTestPlanItem;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringJoiner;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import lombok.extern.slf4j.Slf4j;

@Stateless
@Slf4j
public class QaTestPlanItemDaoImpl extends GenericDao<BigDecimal, QaTestPlanItem> implements QaTestPlanItemDao {

    @Override
    public BigDecimal existItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId) {
        String query = "SELECT t.ID FROM qa_test_plan_item t WHERE t.test_plan_id = :testplanId and t.item_id = :itemId AND t.sub_item_id = 0 AND active='Y' AND wbs_type=1";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testplanId", testplanId).setParameter("itemId", itemId);
        try {
            return NumberSupport.getBigDecimal(q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal existItemByTestplanIdAndItemIdUnderStandardItemNo(BigInteger testplanId, BigInteger itemId, String itemNo) {
        String query = "SELECT t.ID FROM qa_test_plan_item t WHERE t.test_plan_id = :testplanId and t.item_id = :itemId AND t.sub_item_id = 0 AND active='Y' AND wbs_type=1 AND wbs_id = (SELECT ID FROM qa_test_plan_item WHERE item_no='1000' AND wbs_type=0 AND test_plan_id=:testplanId)";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testplanId", testplanId).setParameter("itemId", itemId);
        try {
            return NumberSupport.getBigDecimal(q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal existWbsItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId) {
        String query = "SELECT t.ID FROM qa_test_plan_item t WHERE t.test_plan_id = :testplanId and t.id = :itemId AND t.sub_item_id = 0 AND active='Y' AND wbs_type=0";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testplanId", testplanId).setParameter("itemId", itemId);
        try {
            return NumberSupport.getBigDecimal(q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigDecimal existWbsItemByTestplanIdAndItemNo(BigInteger testplanId, String itemNo) {
        String query = "SELECT t.ID FROM qa_test_plan_item t WHERE t.test_plan_id = :testplanId and t.item_no = :itemNo AND t.sub_item_id = 0 AND active='Y' AND wbs_type=0";
        Query q = getEntityManager().createNativeQuery(query).setParameter("testplanId", testplanId).setParameter("itemNo", itemNo);
        try {
            return NumberSupport.getBigDecimal(q.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public void batchSaveItemFromBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId) {
        String query = "INSERT INTO qa_test_plan_item(test_plan_id,parent_id,item_id,sub_item_id,item_no,item_type,item_descript, sr_type,unit,acc_freq, rms_1,rms_2,rms_3,rms_d, certc,other_note,mat_spec, const_sect, mat_catg, sample_size, point_sample, acc_lot_size, acc_sublot_size, qc_lot_size, qc_sublot_size, qc_freq, sample_prep_method, spec_prep_method, test_method, inspection, source_verf, test_method_1, test_method_2, test_method_3, ia_type,ia_catg_id,create_by, last_mod , last_mod_by, version, field1, field2, wbs_id) "
                + "SELECT :testplanId test_plan_id,0 parent_id,t.id item_id, 0 sub_item_id,item_no,item_type,item_descript, (case when t.spec_pid>0 then '*' else '' end) sr_type,unit,acc_freq,rms_1,rms_2,rms_3,rms_d, certc,other_note, mat_spec, const_sect, mat_catg, sample_size, point_sample, acc_lot_size, acc_sublot_size, qc_lot_size, qc_sublot_size, qc_freq, sample_prep_method, spec_prep_method, test_method, inspection, source_verf, test_method_1, test_method_2, test_method_3, ia_type,ia_catg_id, "
                + ":createdBy create_by, sysdate last_mod, :lastmodBy last_mod_by, 1 version, :createdBy field1, :itemStatusType field2, :wbsId wbs_id "
                + "FROM glob_biditem_master t WHERE client_id= :clientId  and id = :itemId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("testplanId", testplanId)
                .setParameter("createdBy", createdBy)
                .setParameter("lastmodBy", lastmodBy)
                .setParameter("clientId", clientId)
                .setParameter("itemId", itemId)
                .setParameter("wbsId", wbsId)
                .setParameter("itemStatusType", itemStatusType);
        q.executeUpdate();
    }

    @Override
    public void batchSaveSubItemFromSubBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId) {
        String query = "INSERT INTO qa_test_plan_item(test_plan_id,parent_id,item_id,sub_item_id,item_no,item_type,item_descript, sr_type,unit,acc_freq, rms_1,rms_2,rms_3,rms_d, certc,other_note, mat_spec, const_sect, mat_catg, sample_size, point_sample, acc_lot_size, acc_sublot_size, qc_lot_size, qc_sublot_size, qc_freq, sample_prep_method, spec_prep_method, test_method, inspection, source_verf, test_method_1, test_method_2, test_method_3, ia_type,ia_catg_id, create_by,last_mod ,last_mod_by,version, field1, field2, wbs_id) "
                + "SELECT :testplanId test_plan_id, (SELECT MAX(id) FROM qa_test_plan_item WHERE item_id = :itemId  AND sub_item_id=0 AND test_plan_id = :testplanId ) parent_id ,a.item_id, s.id sub_item_id, (SELECT item_no||'(Sub)' FROM glob_biditem_master WHERE id=a.item_id) item_no,item_type, s.sub_item_descript item_descript, (case when s.spec_pid>0 then '*' else '' end) sr_type,unit,acc_freq,rms_1,rms_2,rms_3,rms_d, certc,other_note, mat_spec, const_sect, mat_catg, sample_size, point_sample, "
                + "acc_lot_size, acc_sublot_size, qc_lot_size, qc_sublot_size, qc_freq, sample_prep_method, spec_prep_method, test_method, inspection, source_verf, test_method_1, test_method_2, test_method_3, ia_type,ia_catg_id, :createdBy create_by, sysdate last_mod , :lastmodBy last_mod_by, 1 version, :createdBy field1, :itemStatusType field2, :wbsId wbs_id "
                + "FROM glob_biditemsub_master s, glob_biditemsub_com a where s.id=a.sub_item_id and s.client_id = :clientId and a.spec_pid=0  and a.item_id = :itemId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("testplanId", testplanId)
                .setParameter("createdBy", createdBy)
                .setParameter("lastmodBy", lastmodBy)
                .setParameter("clientId", clientId)
                .setParameter("itemId", itemId)
                .setParameter("wbsId", wbsId)
                .setParameter("itemStatusType", itemStatusType);
        q.executeUpdate();
    }

    @Override
    public void batchUpdateItem(QaTestPlanItem elem) {
        try {
            StringBuilder query = new StringBuilder();
            StringJoiner updateList = new StringJoiner(",");
            query.append("UPDATE qa_test_plan_item SET ");
            updateList.add("last_mod = :lastmod");
            updateList.add("last_mod_by = :lastmodby");
            updateList.add("item_descript = :itemDescription");
            if (elem.getItemType() != null) {
                updateList.add("item_type = :itemType");
            }
            updateList.add("unit = :unit");
            if (elem.getPlanQty() != null) {
                updateList.add("plan_qty = :itemBidQty");
            }
            if (elem.getEstmQty() != null) {
                updateList.add("estm_qty = :itemProjectQty");
            }
            if (elem.getTodateQty() != null) {
                updateList.add("todate_qty = :toDateQty");
            }

            query.append(updateList.toString());
            query.append(" WHERE test_plan_id = :testplanId and item_id = :itemId AND sub_item_id = 0 AND active='Y' AND wbs_type=1");
            Query q = getEntityManager().createNativeQuery(query.toString());
            q.setParameter("testplanId", elem.getTestPlanId());
            q.setParameter("itemId", elem.getItemId());
            q.setParameter("itemDescription", elem.getItemDescript());
            if (elem.getItemType() != null) {
                q.setParameter("itemType", elem.getItemType());
            }
            q.setParameter("unit", elem.getUnit());
            if (elem.getPlanQty() != null) {
                q.setParameter("itemBidQty", elem.getPlanQty());
            }
            if (elem.getEstmQty() != null) {
                q.setParameter("itemProjectQty", elem.getEstmQty());
            }
            if (elem.getTodateQty() != null) {
                q.setParameter("toDateQty", elem.getTodateQty());
            }

            q.setParameter("lastmod", elem.getLastMod());
            q.setParameter("lastmodby", elem.getLastModBy());
            q.executeUpdate();
        } catch (Exception e) {
            log.error("Error: [batchUpdateItem] " + elem.toString());
        }
    }

    @Override
    public void batchUpdateWbsItem(QaTestPlanItem elem) {
        try {
            StringBuilder query = new StringBuilder();
            StringJoiner updateList = new StringJoiner(",");
            query.append("UPDATE qa_test_plan_item SET ");
            updateList.add("last_mod = :lastmod");
            updateList.add("last_mod_by = :lastmodby");
            if (elem.getPlanQty() != null) {
                updateList.add("plan_qty = :itemBidQty");
            }
            if (elem.getEstmQty() != null) {
                updateList.add("estm_qty = :itemProjectQty");
            }
            if (elem.getTodateQty() != null) {
                updateList.add("todate_qty = :toDateQty");
            }

            query.append(updateList.toString());
            query.append(" WHERE test_plan_id = :testplanId and id = :itemId AND sub_item_id = 0 AND active='Y' AND wbs_type=0");
            Query q = getEntityManager().createNativeQuery(query.toString());
            q.setParameter("testplanId", elem.getTestPlanId());
            q.setParameter("itemId", elem.getId());
            if (elem.getPlanQty() != null) {
                q.setParameter("itemBidQty", elem.getPlanQty());
            }
            if (elem.getEstmQty() != null) {
                q.setParameter("itemProjectQty", elem.getEstmQty());
            }
            if (elem.getTodateQty() != null) {
                q.setParameter("toDateQty", elem.getTodateQty());
            }

            q.setParameter("lastmod", elem.getLastMod());
            q.setParameter("lastmodby", elem.getLastModBy());
            q.executeUpdate();
        } catch (Exception e) {
            log.error("Error: [batchUpdateWbsItem] " + elem.toString());
        }
    }

    @Override
    public void updateWbsId(BigInteger itemId) {
        String query = "UPDATE qa_test_plan_item SET wbs_id = :wbsId WHERE id = :itemId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("itemId", itemId)
                .setParameter("wbsId", itemId);
        try {
            q.executeUpdate();
        } catch (Exception ex) {
            log.error("@ATSER [updateWbsId] " + ex.getMessage(), itemId);
        }
    }

}
