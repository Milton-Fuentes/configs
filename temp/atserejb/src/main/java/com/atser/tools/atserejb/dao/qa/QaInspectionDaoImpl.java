/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.dao.glob.GlobProjectDao;
import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaInspectionSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaInspectionSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaInspectionDaoImpl extends GenericDao<BigDecimal, QaInspection> implements QaInspectionDao, ISearchDao<QaInspectionSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    /*@Override
    public List getRevisions(QaInspection id, Class entity) {
        List revisions = getAuditReader().createQuery().forRevisionsOfEntity(entity, false, true)
                .add(AuditEntity.id().eq(id))
                .addOrder(AuditEntity.revisionNumber().asc())
                .getResultList();
        return revisions;
    }*/
    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM QA_INSPECTION WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(icn)),0) + 1 as icn FROM QA_INSPECTION WHERE client_id=:clientId AND project_id=:projectId";
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
     * Search Inspection Test
     *
     * @param filters
     * @return DataTableWrapper
     */
    @Override
    public DataTableWrapper<QaInspectionSearchBO> getFrontEndInspectionSearch(QaInspectionSearchDefParam filters) {
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
            List<QaInspectionSearchBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<QaInspectionSearchBO> populateBO(List<Object[]> objects) {
        List<QaInspectionSearchBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            QaInspectionSearchBO p = new QaInspectionSearchBO();
            p.setId(NumberSupport.getBigInteger(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setLabId(NumberSupport.getBigInteger(it[3]));
            p.setSno(NumberSupport.getBigInteger(it[4]));
            p.setInspNo(StringSupport.emptyOnNull(it[5]));
            p.setIcn(StringSupport.emptyOnNull(it[6]));
            p.setRemarks(StringSupport.emptyOnNull(it[7]));
            p.setFolderId(NumberSupport.getBigInteger(it[8]));
            p.setCreated(it[9] != null ? DateSupport.formatUS((Date) it[9]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[10]));
            p.setVersion(StringSupport.emptyOnNull(it[11]));
            p.setTypeId(NumberSupport.getBigInteger(it[12]));
            p.setTypeName(StringSupport.emptyOnNull(it[13]));
            p.setTypeShortName(StringSupport.emptyOnNull(it[14]));
            p.setCatCode(StringSupport.emptyOnNull(it[15]));
            p.setCatName(StringSupport.emptyOnNull(it[16]));
            p.setCatShortName(StringSupport.emptyOnNull(it[17]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[18]));
            p.setRegionId(NumberSupport.getBigInteger(it[19]));
            p.setRegionName(StringSupport.emptyOnNull(it[20]));
            p.setOfficeLocation(StringSupport.emptyOnNull(it[21]));
            p.setDepartmentId(StringSupport.emptyOnNull(it[22]));
            p.setProjectCode(StringSupport.emptyOnNull(it[23]));
            p.setStatus(StringSupport.emptyOnNull(it[24]));
            p.setSignTotal(NumberSupport.getInteger(it[25]));
            p.setFinalSignTotal(NumberSupport.getInteger(it[26]));
            p.setBidItemNo(StringSupport.emptyOnNull(it[27]));
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
    public String buildCountQuery(QaInspectionSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM QA_INSPECTION t "
                + "LEFT JOIN QA_INSPECTION_VISUAL v on v.id = t.id "
                + "INNER JOIN QA_INSPECTION_TYPE m ON (t.inspection_type_id = m.id) "
                + "LEFT OUTER JOIN QA_INSPECTION_SIMPLE_CAT c ON(t.simplecat_id = c.id) "
                + "INNER JOIN GLOB_PROJECT gp ON (t.project_id = gp.id) "
                + "LEFT OUTER JOIN QA_INSPECTION_SIMPLE_CAT d ON (t.status_id = d.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND t.active='N' " : " AND t.active='Y' ";
        whereLine += " AND t.deleted = 'N' AND gp.client_id = " + filters.clientId +" AND t.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(QaInspectionSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = "t.ID,t.CLIENT_ID,t.PROJECT_ID,t.LAB_ID,t.SNO,t.INSP_NO,t.ICN,t.REMARKS,t.FOLDER_ID,t.CREATED,t.CREATED_BY,t.VERSION, m.id as type_id, "
                + "m.name as type_name, m.short_name as type_short_name, c.code as cat_code, c.name as cat_name, c.short_name as cat_short_name,"
                + "gp.p_number AS project_number,gp.region_id,(SELECT gcr.name FROM glob_client_regions gcr WHERE gcr.id = gp.region_id) AS region_name,"
                + "gp.office_location, gp.department_id, gp.project_code, CASE t.status_id WHEN -1 THEN 'Pending' ELSE REPLACE(d.name, ' By', '') END as status,"
                + "(SELECT COUNT(*) FROM QA_INSPECTION_SIGNINFO qsi WHERE qsi.inspection_id = t.id) AS sign_total,"
                + "(SELECT COUNT(*) FROM QA_INSPECTION_SIGNINFO qsi WHERE qsi.inspection_id = t.id AND qsi.signed = 'Y') AS final_sign_total, "
                + "(select item_no from vw_test_plan_item pi where pi.id =" +
                    " (CASE m.short_name" +
                    " WHEN 'certificate_of_source' THEN (select biditem_id from qa_inspection_certofsrc i where i.id = t.id)" +
                    " WHEN 'qualified_construction_materials_list' THEN (select biditem_id from QA_INSPECTION_QCML i where i.id = t.id)" +
                    " WHEN 'visual_inspection' THEN (select biditem_id from qa_inspection_visual i where i.id = t.id)" +
                    " WHEN 'precast_prestress' THEN (select biditem_id from qa_inspection_precaststress i where i.id = t.id)" +
                    " END)" +
                    ") as bid_item_no";
        String fromLine = " FROM QA_INSPECTION t "                
                + "INNER JOIN QA_INSPECTION_TYPE m ON (t.inspection_type_id = m.id) "
                + "LEFT OUTER JOIN QA_INSPECTION_SIMPLE_CAT c ON(t.simplecat_id = c.id) "
                + "INNER JOIN GLOB_PROJECT gp ON (t.project_id = gp.id) "
                + "LEFT OUTER JOIN QA_INSPECTION_SIMPLE_CAT d ON (t.status_id = d.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND t.active='N' " : " AND t.active='Y' ";
        whereLine += " AND t.deleted = 'N' AND gp.client_id = " + filters.clientId +" AND t.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        String tailLineSearch = buildFiltersSearch(filters);
        if(!tailLineSearch.isEmpty()) {
            query = "SELECT * FROM (" + query + ") WHERE " + tailLineSearch;
        }
        return wrapToServerSide(query, orderLine2, filters);
    }
    
    @Override
    public String buildFilters(QaInspectionSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" AND (t.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" t.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }
        // Filter
        if (!filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND t.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.regionId) && !filters.regionId.equals("-1")) {
            tailLineBuilder.append("AND (gp.region_id = ").append(filters.regionId).append(") ");
        }

        // Filter
        if (filters.statusMap != null && !filters.statusMap.isEmpty()) {
            tailLineBuilder.append(buildStatusPartQuery(filters.statusMap));
        }

        // Filters By Search
        /*if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("inspNo")) {
                tailLineBuilder.append("(t.insp_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("inspNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("typeName")) {
                tailLineBuilder.append(" or (m.name like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("typeName"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }*/

        return tailLineBuilder.toString();
    }
    
    public String buildFiltersSearch(QaInspectionSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("inspNo")) {
                tailLineBuilder.append("(insp_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("inspNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("typeName")) {
                tailLineBuilder.append(" or (type_name like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("typeName"))).append("%') ");
            }
            // Filter
            if (filters.dtMapSearch.containsKey("bidItemNo")) {
                tailLineBuilder.append(" or (bid_item_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("bidItemNo"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(QaInspectionSearchDefParam filters, Integer level) {
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
            case "inspNo": {
                if (level == 1) {
                    orderBuilder.append(" order by t.insp_no ");
                } else {
                    orderBuilder.append(" order by insp_no ");
                }
                break;
            }
            case "typeName": {
                if (level == 1) {
                    orderBuilder.append(" order by m.name ");
                } else {
                    orderBuilder.append(" order by type_name ");
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
            case "bidItemNo": {
                    orderBuilder.append(" order by bid_item_no ");
                break;
            }
            case "regionName": {
                orderBuilder.append(" order by region_name ");
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
            case "status": {
                orderBuilder.append(" order by status ");
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
