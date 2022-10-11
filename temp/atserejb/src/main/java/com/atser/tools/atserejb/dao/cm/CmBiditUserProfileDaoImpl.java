/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.CmBiditUserProfile;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.cm.CmBiditUserProfileSearchBO;
import com.atser.tools.atserutil.objects.pojo.cm.CmBiditUserProfileSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class CmBiditUserProfileDaoImpl extends GenericDao<BigDecimal, CmBiditUserProfile> implements CmBiditUserProfileDao, ISearchDao<CmBiditUserProfileSearchDefParam> {

    @Override
    public boolean exists(CmBiditUserProfile elem) {
        String query = "SELECT t.id FROM cm_bidit_user_profile t WHERE t.company_id = :companyId AND t.prj_catg_id = :bidId AND t.user_id = :userId AND t.deleted = 'N'";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("companyId", elem.getCompanyId())
                .setParameter("bidId", elem.getPrjCatgId())
                .setParameter("userId", elem.getUserId());
        try {
            if (q.getSingleResult() != null) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException ex) {
            return Boolean.FALSE;
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
    public DataTableWrapper<CmBiditUserProfileSearchBO> getFrontEndSearch(CmBiditUserProfileSearchDefParam filters) {
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
            List<CmBiditUserProfileSearchBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<CmBiditUserProfileSearchBO> populateBO(List<Object[]> objects) {
        List<CmBiditUserProfileSearchBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            CmBiditUserProfileSearchBO p = new CmBiditUserProfileSearchBO();
            p.setId(NumberSupport.getBigInteger(it[0]));
            p.setUserId(NumberSupport.getBigInteger(it[1]));
            p.setPrjCatgId(NumberSupport.getBigInteger(it[2]));
            p.setBidNo(StringSupport.emptyOnNull(it[3]));
            p.setBidDescription(StringSupport.emptyOnNull(it[4]));
            p.setBidIssueDate(it[5] != null ? DateSupport.formatUS((Date) it[5]) : null);
            p.setBidClosingDate(it[6] != null ? DateSupport.formatDate((Date) it[6], DateSupport.FORMAT_MMDDYY_HHMMSS_24SLASH) : null);
            p.setBidPublishDate(it[7] != null ? DateSupport.formatDate((Date) it[7], DateSupport.FORMAT_MMDDYY_HHMMSS_24SLASH) : null);
            p.setCompanyId(NumberSupport.getBigInteger(it[8]));
            p.setCompanyTin(StringSupport.emptyOnNull(it[9]));
            p.setCompanyName(StringSupport.emptyOnNull(it[10]));
            p.setIsEngineerEstimate(StringSupport.getBoolean(it[11]));
            p.setFolderId(NumberSupport.getBigInteger(it[12]));
            p.setStatusId(NumberSupport.getBigInteger(it[13]));
            p.setStatus(StringSupport.emptyOnNull(it[14]));
            p.setCreated(it[15] != null ? DateSupport.formatUS((Date) it[15]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[16]));
            p.setVersion(StringSupport.emptyOnNull(it[17]));
            p.setContactClientId(NumberSupport.getBigInteger(it[18]));
            p.setBidAddendumRev(NumberSupport.getInteger(it[19]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(CmBiditUserProfileSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM cm_bidit_user_profile t "
                + "INNER JOIN cm_bidit_prj_catg prjcatg ON (t.prj_catg_id = prjcatg.id) "
                + "INNER JOIN cm_bidit_company comp ON (t.company_id = comp.id) "
                + "LEFT OUTER JOIN GLOB_SYSTEM_SIMPLE_CAT bscs ON (t.status_id = bscs.id) "
                + "INNER JOIN GLOB_USERS usr ON (t.user_id = usr.id) "
                + "INNER JOIN GLOB_CONTACT contact ON (usr.contactid = contact.id) ";
        String whereLine = " WHERE ";
        whereLine += (!filters.showInactive) ? " t.active='N' " : " t.active='Y' ";
        whereLine += " AND t.deleted = 'N' AND t.user_id = " + filters.userId + " AND usr.active = 'Y' AND comp.deleted = 'N' AND prjcatg.deleted = 'N' ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(CmBiditUserProfileSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " t.id, t.user_id, t.prj_catg_id, prjcatg.bid_no, prjcatg.description as bid_description, "
                + "prjcatg.bid_issue_date, prjcatg.bid_closing_date, prjcatg.bid_publish_date, t.company_id, "
                + "comp.company_tin, comp.company_name, comp.engineer_estimate, t.folder_id, t.status_id, "
                + "CASE t.status_id WHEN -1 THEN 'Pending' ELSE REPLACE(bscs.name, ' By', '') END as status, "
                + "t.created, t.created_by, t.version, contact.client_id as contact_client_id, prjcatg.bid_addendum_rev ";
        String fromLine = " FROM cm_bidit_user_profile t "
                + "INNER JOIN cm_bidit_prj_catg prjcatg ON (t.prj_catg_id = prjcatg.id) "
                + "INNER JOIN cm_bidit_company comp ON (t.company_id = comp.id) "
                + "LEFT OUTER JOIN GLOB_SYSTEM_SIMPLE_CAT bscs ON (t.status_id = bscs.id) "
                + "INNER JOIN GLOB_USERS usr ON (t.user_id = usr.id) "
                + "INNER JOIN GLOB_CONTACT contact ON (usr.contactid = contact.id) ";
        String whereLine = " WHERE ";
        whereLine += (!filters.showInactive) ? " t.active='N' " : " t.active='Y' ";
        whereLine += " AND t.deleted = 'N' AND t.user_id = " + filters.userId + " AND usr.active = 'Y' AND comp.deleted = 'N' AND prjcatg.deleted = 'N' ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(CmBiditUserProfileSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (!filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND t.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (!filters.isAllBidIssueDateActive && StringSupport.isNotNullAndNotEmpty(filters.bidStartIssueDate, filters.bidEndIssueDate)) {
            tailLineBuilder.append("AND prjcatg.BID_ISSUE_DATE between to_date('").append(filters.bidStartIssueDate).append("','mm-dd-yyyy') and to_date('").append(filters.bidEndIssueDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (!filters.isAllBidClosingDate && StringSupport.isNotNullAndNotEmpty(filters.bidStartClosingDate, filters.bidEndClosingDate)) {
            tailLineBuilder.append("AND prjcatg.BID_CLOSING_DATE between to_date('").append(filters.bidStartClosingDate).append("','mm-dd-yyyy HH24:MI:SS') and to_date('").append(filters.bidEndClosingDate).append("','mm-dd-yyyy HH24:MI:SS')  ");
        }

        // Filter
        if (!filters.isAllBidPublishDate && StringSupport.isNotNullAndNotEmpty(filters.bidStartPublishDate, filters.bidEndPublishDate)) {
            tailLineBuilder.append("AND prjcatg.BID_PUBLISH_DATE between to_date('").append(filters.bidStartPublishDate).append("','mm-dd-yyyy HH24:MI:SS') and to_date('").append(filters.bidEndPublishDate).append("','mm-dd-yyyy HH24:MI:SS')  ");
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
                tailLineBuilder.append("(prjcatg.bid_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("bidNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("bidDescription")) {
                tailLineBuilder.append(" or (prjcatg.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("bidDescription"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("companyTin")) {
                tailLineBuilder.append(" or (comp.company_tin like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("companyTin"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("companyName")) {
                tailLineBuilder.append(" or (comp.company_name like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("companyName"))).append("%') ");
            }

            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(CmBiditUserProfileSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by t.created ");
            } else {
                orderBuilder.append(" order by created ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "bidNo": {
                if (level == 1) {
                    orderBuilder.append(" order by prjcatg.bid_no ");
                } else {
                    orderBuilder.append(" order by bid_no ");
                }
                break;
            }
            case "bidDescription": {
                if (level == 1) {
                    orderBuilder.append(" order by prjcatg.description ");
                } else {
                    orderBuilder.append(" order by bid_description ");
                }
                break;
            }
            case "bidIssueDate": {
                if (level == 1) {
                    orderBuilder.append(" order by prjcatg.BID_ISSUE_DATE ");
                } else {
                    orderBuilder.append(" order by BID_ISSUE_DATE ");
                }
                break;
            }
            case "bidClosingDate": {
                if (level == 1) {
                    orderBuilder.append(" order by prjcatg.BID_CLOSING_DATE ");
                } else {
                    orderBuilder.append(" order by BID_CLOSING_DATE ");
                }
                break;
            }
            case "bidPublishDate": {
                if (level == 1) {
                    orderBuilder.append(" order by prjcatg.BID_PUBLISH_DATE ");
                } else {
                    orderBuilder.append(" order by BID_PUBLISH_DATE ");
                }
                break;
            }
            case "companyTin": {
                if (level == 1) {
                    orderBuilder.append(" order by comp.COMPANY_TIN ");
                } else {
                    orderBuilder.append(" order by COMPANY_TIN ");
                }
                break;
            }
            case "companyName": {
                if (level == 1) {
                    orderBuilder.append(" order by comp.COMPANY_NAME ");
                } else {
                    orderBuilder.append(" order by COMPANY_NAME ");
                }
                break;
            }
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by t.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by t.created ");
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
            String segment = " t.status_id = " + key + " ";
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

}
