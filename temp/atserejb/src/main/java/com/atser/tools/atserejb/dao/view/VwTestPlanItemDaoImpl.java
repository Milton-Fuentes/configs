/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class VwTestPlanItemDaoImpl extends GenericDao<BigDecimal, VwTestPlanItem> implements VwTestPlanItemDao {

    @Override
    public List<VwTestPlanItem> getItemsNotAddedInspection(BigInteger inspectionId, BigInteger wbsId, Boolean excludeAdded) {
        /* To replace the main view.
        SELECT qtpi.* FROM qa_test_plan_item qtpi 
        INNER JOIN qa_test_plan qtp ON (qtpi.test_plan_id = qtp.id) 
        INNER JOIN qa_inspection insp ON (qtp.project_id = insp.project_id) 
        WHERE insp.deleted = 'N' AND qtpi.parent_id = 0 AND insp.id = 61 AND qtpi.active = 'Y' 
        AND qtpi.wbs_id = 0 AND qtpi.wbs_type = 1 AND qtpi.id NOT IN (SELECT i.biditem_id FROM qa_inspection_notuitem i 
        WHERE i.INSPECTION_ID=61 AND i.deleted = 'N') ORDER BY qtpi.item_no ASC; */
        String query = "SELECT * FROM VW_TEST_PLAN_ITEM t, qa_inspection qi WHERE t.project_id = qi.project_id AND qi.id = :inspectionId AND qi.deleted = 'N' "
                + "AND t.PARENT_ID=0 AND t.ACTIVE='Y' AND t.wbs_id = :wbsId AND t.wbs_type = 1";
        if (excludeAdded) {
            query += " AND t.id NOT IN (SELECT i.biditem_id FROM qa_inspection_notuitem i WHERE i.INSPECTION_ID=:inspectionId AND i.deleted = 'N') ";
        }
        query += " ORDER BY t.item_no ASC";
        Query hquery = getEntityManager().createNativeQuery(query, VwTestPlanItem.class)
                .setParameter("wbsId", wbsId)
                .setParameter("inspectionId", inspectionId);
        try {
            return hquery.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<VwTestPlanItem> getRootWbsItems(BigInteger projectId, String clientName, String itemFilter) {
        /* To replace the main view
        SELECT * FROM qa_test_plan_item qtpi  
        INNER JOIN qa_test_plan qtp ON (qtpi.test_plan_id = qtp.id) 
        WHERE qtp.project_id = 17 AND qtpi.wbs_type = 0  ORDER BY qtpi.item_no;
         */
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM vw_test_plan_item m WHERE project_id = :projectId AND wbs_type = 0 AND m.id IN ( ");
        query.append("SELECT mm.wbs_id FROM vw_test_plan_item mm WHERE mm.project_id = :projectId AND mm.wbs_id = m.id "
                + "AND mm.wbs_type = 1 AND mm.sub_item_id = 0 AND mm.item_id in ( SELECT item_id FROM vw_test_plan_item t WHERE t.project_id = :projectId ");
        query.append(buildRmsFilterQuery(itemFilter));
        query.append(" )) ORDER BY m.item_no");
        Query hquery = getEntityManager().createNativeQuery(query.toString(), VwTestPlanItem.class)
                .setParameter("projectId", projectId);
        try {
            return hquery.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    private String buildRmsFilterQuery(String itemFilter) {
        StringBuilder query = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(itemFilter)) {
            String[] filters = itemFilter.trim().split(",");
            if (filters.length > 0) {
                query.append("AND ( ");
                query.append("(t.rms_1 = '").append(StringSupport.sanitizeStringForSql(filters[0])).append("' OR t.rms_2 = '").append(filters[0]).append("' OR t.rms_3 = '").append(filters[0]).append("')");
                for (int i = 1; i < filters.length; i++) {
                    String ssql = StringSupport.sanitizeStringForSql(filters[i]);
                    query.append(" OR (t.rms_1 = '").append(ssql).append("' OR t.rms_2 = '").append(ssql).append("' OR t.rms_3 = '").append(ssql).append("')");
                }
                query.append(" ) ");
            }
        }
        return query.toString();
    }

    @Override
    public List<VwTestPlanItem> getItemsByRms(BigInteger projectId, String clientName, String itemFilter, BigInteger wbsId) {
        //wbs_id = 0 and wbs_type = 1 (Contractual/NonContractual)
        // if not filtyer by wbs_id = ? and wbs_type = 1
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM vw_test_plan_item m WHERE project_id = :projectId AND wbs_id = :wbsId AND wbs_type = 1 AND sub_item_id = 0 AND m.item_id in ( SELECT item_id FROM vw_test_plan_item t WHERE t.project_id = :projectId ");
        query.append(buildRmsFilterQuery(itemFilter));
        query.append(" ) ORDER BY m.item_no ");
        Query hquery = getEntityManager().createNativeQuery(query.toString(), VwTestPlanItem.class)
                .setParameter("wbsId", wbsId)
                .setParameter("projectId", projectId);
        try {
            return hquery.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public List<VwTestPlanItem> getSubItemsByRms(BigInteger projectId, BigInteger itemId, String clientName, String itemFilter, BigInteger wbsId) {
        String[] filters = itemFilter.trim().split(",");
        StringBuilder query = new StringBuilder();
        query.append("SELECT * FROM vw_test_plan_item t where t.project_id = :projectId AND wbs_id = :wbsId AND wbs_type = 1 AND t.sub_item_id != 0 AND t.item_id = :itemId ");
        if (filters.length > 0) {
            query.append("AND ( ");
            query.append("(t.rms_1 = '").append(StringSupport.sanitizeStringForSql(filters[0])).append("' OR t.rms_2 = '").append(filters[0]).append("' OR t.rms_3 = '").append(filters[0]).append("')");
            for (int i = 1; i < filters.length; i++) {
                String ssql = StringSupport.sanitizeStringForSql(filters[i]);
                query.append(" OR (t.rms_1 = '").append(ssql).append("' OR t.rms_2 = '").append(ssql).append("' OR t.rms_3 = '").append(ssql).append("')");
            }
            query.append(" ) ");
        }
        query.append(" ORDER BY replace(t.item_no,'(Sub)','')");
        Query hquery = getEntityManager().createNativeQuery(query.toString(), VwTestPlanItem.class)
                .setParameter("projectId", projectId)
                .setParameter("wbsId", wbsId)
                .setParameter("itemId", itemId);
        try {
            return hquery.getResultList();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public BigInteger countTotalItemByRMSNumber(BigInteger projectId, String rmsItem) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT count(qtpi.id) as TOTAL FROM qa_test_plan_item qtpi INNER JOIN qa_test_plan qtp ON (qtpi.test_plan_id = qtp.id) WHERE qtpi.active = 'Y' "
                + "AND qtp.project_id = :projectId AND qtpi.wbs_type = 1 AND (lower(qtpi.rms_1) like lower(:rmsItem) "
                + "OR lower(qtpi.rms_2) like lower(:rmsItem) "
                + "OR lower(qtpi.rms_3) like lower(:rmsItem))");
        Query hquery = getEntityManager().createNativeQuery(query.toString())
                .setParameter("rmsItem", "%" + rmsItem + "%")
                .setParameter("projectId", projectId);
        try {
            return NumberSupport.getBigInteger(hquery.getSingleResult());
        } catch (NoResultException ex) {
            return null;
        }
    }

}
