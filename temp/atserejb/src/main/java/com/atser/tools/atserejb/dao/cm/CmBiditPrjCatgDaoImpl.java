/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.dao.glob.GlobProjectDao;
import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.cm.CmBidITPrjCatgSearchBO;
import com.atser.tools.atserutil.objects.pojo.cm.CmBidITPrjCatgSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidCompanySummary;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidItemSummary;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author mdelabat
 */
@Stateless
public class CmBiditPrjCatgDaoImpl extends GenericDao<BigDecimal, CmBiditPrjCatg> implements CmBiditPrjCatgDao, ISearchDao<CmBidITPrjCatgSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM CM_BIDIT_PRJ_CATG WHERE client_id=:clientId AND spattern = :spattern";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("spattern", spattern);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? NumberSupport.getBigInteger(result) : BigInteger.ONE;
        } catch (NoResultException ex) {
            return BigInteger.ONE;
        }
    }

    @Override
    public String getNextProjectSequenceNo(BigInteger clientId, BigInteger projectId) {
        String query = "SELECT NVL(MAX(to_number(bpcn)),0) + 1 as icn FROM CM_BIDIT_PRJ_CATG WHERE client_id=:clientId AND project_id=:projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? StringSupport.getString(result) : "1";
        } catch (NoResultException ex) {
            return "1";
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Search
     *
     * @param filters
     * @return
     */
    @Override
    public DataTableWrapper<CmBidITPrjCatgSearchBO> getFrontEndSearch(CmBidITPrjCatgSearchDefParam filters) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String countQuery = buildCountQuery(filters, tailLine);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            List<CmBidITPrjCatgSearchBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<CmBidITPrjCatgSearchBO> populateBO(List<Object[]> objects) {
        List<CmBidITPrjCatgSearchBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            CmBidITPrjCatgSearchBO p = new CmBidITPrjCatgSearchBO();
            p.setId(NumberSupport.getBigInteger(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setSpattern(StringSupport.emptyOnNull(it[3]));
            p.setSno(NumberSupport.getBigInteger(it[4]));
            p.setBpcn(StringSupport.emptyOnNull(it[5]));
            p.setBidNo(StringSupport.emptyOnNull(it[6]));
            p.setDescription(StringSupport.emptyOnNull(it[7]));
            p.setBidIssueDate(it[8] != null ? DateSupport.formatUS((Date) it[8]) : null);
            p.setBidClosingDate(it[9] != null ? DateSupport.formatDate((Date) it[9], DateSupport.FORMAT_MMDDYY_HHMMSS_24SLASH) : null);
            p.setBidClosed(StringSupport.getBoolean(it[10]));
            p.setBidAddendumRev(NumberSupport.getBigInteger(it[11]));
            p.setFolderId(NumberSupport.getBigInteger(it[12]));
            p.setStatus(StringSupport.emptyOnNull(it[13]));
            p.setCreated(it[14] != null ? DateSupport.formatUS((Date) it[14]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[15]));
            p.setCreatedById(NumberSupport.getBigInteger(it[16]));
            p.setVersion(StringSupport.emptyOnNull(it[17]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[18]));
            p.setProjectCode(StringSupport.emptyOnNull(it[19]));
            p.setSignTotal(NumberSupport.getInteger(it[20]));
            p.setFinalSignTotal(NumberSupport.getInteger(it[21]));
            p.setBidPublishDate(it[22] != null ? DateSupport.formatDate((Date) it[22], DateSupport.FORMAT_MMDDYY_HHMMSS_24SLASH) : null);
            p.setBidPublished(StringSupport.getBoolean(it[23]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    /**
     * Build Count Query
     *
     * @param filters
     * @param tailLine
     * @return
     */
    @Override
    public String buildCountQuery(CmBidITPrjCatgSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM CM_BIDIT_PRJ_CATG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN GLOB_SYSTEM_SIMPLE_CAT bscs ON (bpc.status_id = bscs.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(CmBidITPrjCatgSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, bpc.spattern, bpc.sno, bpc.bpcn, bpc.bid_no, bpc.description, "
                + "bpc.bid_issue_date, bpc.bid_closing_date, bpc.bid_closed, bpc.bid_addendum_rev, bpc.folder_id, "
                + "CASE bpc.status_id WHEN -1 THEN 'Pending' ELSE REPLACE(bscs.name, ' By', '') END as status, "
                + "bpc.created, bpc.created_by, bpc.created_by_id, bpc.version, gp.p_number AS project_number, "
                + "gp.project_code, (SELECT COUNT(*) FROM cm_bidit_signinfo bsi INNER JOIN glob_system_simple_cat gsct ON (bsi.type_id = gsct.id) WHERE bsi.ref_id = bpc.id AND gsct.code = 'code_bidit_sign_workflow' AND gsct.short_name = 'bidsigndesignerwf') AS sign_total,"
                + "(SELECT COUNT(*) FROM cm_bidit_signinfo bsi INNER JOIN glob_system_simple_cat gsct ON (bsi.type_id = gsct.id) WHERE bsi.ref_id = bpc.id AND gsct.code = 'code_bidit_sign_workflow' AND gsct.short_name = 'bidsigndesignerwf' AND bsi.signed = 'Y') AS final_sign_total, "
                + "bpc.BID_PUBLISH_DATE, bpc.BID_PUBLISHED";
        String fromLine = " FROM CM_BIDIT_PRJ_CATG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN GLOB_SYSTEM_SIMPLE_CAT bscs ON (bpc.status_id = bscs.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(CmBidITPrjCatgSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" AND (bpc.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" bpc.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }
        // Filter
        if (!filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND bpc.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (!filters.isAllBidIssueDateActive && StringSupport.isNotNullAndNotEmpty(filters.bidStartIssueDate, filters.bidEndIssueDate)) {
            tailLineBuilder.append("AND bpc.BID_ISSUE_DATE between to_date('").append(filters.bidStartIssueDate).append("','mm-dd-yyyy') and to_date('").append(filters.bidEndIssueDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (!filters.isAllBidClosingDate && StringSupport.isNotNullAndNotEmpty(filters.bidStartClosingDate, filters.bidEndClosingDate)) {
            tailLineBuilder.append("AND bpc.BID_CLOSING_DATE between to_date('").append(filters.bidStartClosingDate).append("','mm-dd-yyyy HH24:MI:SS') and to_date('").append(filters.bidEndClosingDate).append("','mm-dd-yyyy HH24:MI:SS')  ");
        }

        // Filter
        if (!filters.isAllBidPublishDate && StringSupport.isNotNullAndNotEmpty(filters.bidStartPublishDate, filters.bidEndPublishDate)) {
            tailLineBuilder.append("AND bpc.BID_PUBLISH_DATE between to_date('").append(filters.bidStartPublishDate).append("','mm-dd-yyyy HH24:MI:SS') and to_date('").append(filters.bidEndPublishDate).append("','mm-dd-yyyy HH24:MI:SS')  ");
        }

        // Filter
        if (filters.statusMap != null && !filters.statusMap.isEmpty()) {
            tailLineBuilder.append(buildStatusPartQuery(filters.statusMap));
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("bidNo")) {
                tailLineBuilder.append("(bpc.bid_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("bidNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("description")) {
                tailLineBuilder.append(" or (bpc.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("description"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(CmBidITPrjCatgSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by bpc.created ");
            } else {
                orderBuilder.append(" order by created ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "bidNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.bid_no ");
                } else {
                    orderBuilder.append(" order by bid_no ");
                }
                break;
            }
            case "description": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.description ");
                } else {
                    orderBuilder.append(" order by description ");
                }
                break;
            }
            case "projectNumber": {
                if (level == 1) {
                    orderBuilder.append(" order by gp.p_number ");
                } else {
                    orderBuilder.append(" order by project_number ");
                }
                break;
            }
            case "bidIssueDate": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.BID_ISSUE_DATE ");
                } else {
                    orderBuilder.append(" order by BID_ISSUE_DATE ");
                }
                break;
            }
            case "bidClosingDate": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.BID_CLOSING_DATE ");
                } else {
                    orderBuilder.append(" order by BID_CLOSING_DATE ");
                }
                break;
            }
            case "bidPublishDate": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.BID_PUBLISH_DATE ");
                } else {
                    orderBuilder.append(" order by BID_PUBLISH_DATE ");
                }
                break;
            }
            case "bidPublished": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.BID_PUBLISHED ");
                } else {
                    orderBuilder.append(" order by BID_PUBLISHED ");
                }
                break;
            }
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
        }
        orderBuilder.append(filters.sortDir);
        return orderBuilder.toString();
    }

    private String buildStatusPartQuery(AtserLinkedHashMap<String, Object> map) {
        StringBuilder query = new StringBuilder();
        query.append(" and ( ");
        int index = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String segment = " bpc.status_id = " + key + " ";
            if (segment != null) {
                if (index == 0) {
                    query.append(segment);
                } else {
                    query.append(" or ").append(segment);
                }
            }
            index++;
        }
        query.append(" ) ");
        return query.toString();
    }

    @Override
    public List<CmBidCompanySummary> getCompanySummary(BigInteger prjCatgId) {
        String query = "SELECT DISTINCT co.id, co.company_name, co.engineer_estimate, SUM(t.total_price) as bid_total "
                + "FROM cm_bidit_prj_items_co t INNER JOIN cm_bidit_prj_items it ON (t.prj_item_id = it.id) "
                + "INNER JOIN cm_bidit_user_profile uprof ON (t.profile_id = uprof.id) "
                + "INNER JOIN cm_bidit_company co ON (uprof.company_id = co.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlunit ON (it.unit = cvlunit.id) "
                + "WHERE t.deleted = 'N' AND it.deleted = 'N' AND uprof.deleted = 'N' AND it.prj_catg_id = :prjCatgId AND it.active = 'Y' "
                + "GROUP BY co.id, co.company_name, co.engineer_estimate ORDER BY SUM(t.total_price) ASC";
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query).setParameter("prjCatgId", prjCatgId).getResultList();
            List<CmBidCompanySummary> list = new ArrayList<>();
            objects.stream().map((it) -> {
                CmBidCompanySummary p = new CmBidCompanySummary();
                p.setId(NumberSupport.getBigInteger(it[0]));
                p.setContractorName(StringSupport.emptyOnNull(it[1]));
                p.setIsEngineerEstimation(StringSupport.getBoolean(it[2]));
                p.setBidTotal(NumberSupport.getBigDecimal(it[3]));
                return p;
            }).forEachOrdered((to) -> {
                list.add(to);
            });
            return list;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public Map<BigInteger, CmBidItemSummary> getBidItemSummary(BigInteger prjCatgId, Boolean isEngineerEstimation) {
        return getBidItemSummary(prjCatgId, isEngineerEstimation, null);
    }

    @Override
    public Map<BigInteger, CmBidItemSummary> getBidItemSummary(BigInteger prjCatgId, Boolean isEngineerEstimation, BigInteger companyId) {
        String query = "SELECT it.id, co.company_name, it.item_no, it.description, cvlunit.value as unit, "
                + "CASE WHEN it.is_qty_editable = 'N' THEN it.default_qty ELSE t.qty END AS qty, t.unit_price, "
                + "t.total_price, co.engineer_estimate FROM cm_bidit_prj_items_co t "
                + "INNER JOIN cm_bidit_prj_items it ON (t.prj_item_id = it.id) "
                + "INNER JOIN cm_bidit_user_profile uprof ON (t.profile_id = uprof.id) "
                + "INNER JOIN cm_bidit_company co ON (uprof.company_id = co.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlunit ON (it.unit = cvlunit.id) "
                + "WHERE t.deleted = 'N' AND it.deleted = 'N' AND uprof.deleted = 'N' "
                + "AND it.prj_catg_id = :prjCatgId AND it.active = 'Y' AND co.engineer_estimate = :isengestm ";
        if (companyId != null) {
            query += " AND co.id = :coId ";
        }
        query += "ORDER BY it.id ASC, co.engineer_estimate DESC";
        try {
            Query q = getEntityManager().createNativeQuery(query)
                    .setParameter("prjCatgId", prjCatgId)
                    .setParameter("isengestm", isEngineerEstimation ? 'Y': 'N');
            if (companyId != null) {
                q.setParameter("coId", companyId);
            }
            List<Object[]> objects = q.getResultList();
            Map<BigInteger, CmBidItemSummary> itemMap = new HashMap<>();
            objects.stream().map((it) -> {
                CmBidItemSummary p = new CmBidItemSummary();
                p.setId(NumberSupport.getBigInteger(it[0]));
                p.setItemNo(StringSupport.emptyOnNull(it[2]));
                p.setDescription(StringSupport.emptyOnNull(it[3]));
                p.setUnit(StringSupport.emptyOnNull(it[4]));
                p.setQty(NumberSupport.getBigDecimal(it[5]));
                p.setUnitPrice(NumberSupport.getBigDecimal(it[6]));
                p.setUnitPriceDisplay(CurrencySupport.formatBigDecimalToString(p.getUnitPrice(), 2));
                p.setTotalPrice(NumberSupport.getBigDecimal(it[7]));
                p.setTotalPriceDisplay(CurrencySupport.formatBigDecimalToString(p.getTotalPrice(), 2));
                return p;
            }).forEachOrdered((to) -> {
                itemMap.put(to.getId(), to);
            });
            return itemMap;
        } catch (NoResultException ex) {
            return null;
        }
    }
}
