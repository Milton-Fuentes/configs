/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobIssueLog;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.issuelog.GlobIssueLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobIssueLogSearchDefParam;
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
public class GlobIssueLogDaoImpl extends GenericDao<BigDecimal, GlobIssueLog> implements GlobIssueLogDao, ISearchDao<GlobIssueLogSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_ISSUE_LOG WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(ilpcn)),0) + 1 as icn FROM GLOB_ISSUE_LOG WHERE client_id=:clientId AND project_id=:projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("clientId", clientId).setParameter("projectId", projectId);
        try {
            BigDecimal result = (BigDecimal) q.getSingleResult();
            return (result != null) ? StringSupport.getString(result) : "1";
        } catch (NoResultException ex) {
            return "1";
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public DataTableWrapper<GlobIssueLogBO> getFrontEndSearch(GlobIssueLogSearchDefParam filters) {
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
            List<GlobIssueLogBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobIssueLogBO> populateBO(List<Object[]> objects) {
        List<GlobIssueLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobIssueLogBO p = new GlobIssueLogBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setProjectCode(StringSupport.emptyOnNull(it[4]));
            p.setSpattern(StringSupport.emptyOnNull(it[5]));
            p.setSno(NumberSupport.getBigInteger(it[6]));
            p.setIlpcn(StringSupport.emptyOnNull(it[7]));
            p.setIssueNo(StringSupport.emptyOnNull(it[8]));
            p.setRefId(StringSupport.emptyOnNull(it[9]));
            p.setIdentifiedBy(NumberSupport.getBigInteger(it[10]));
            p.setIdentifiedByName(StringSupport.emptyOnNull(it[11]));
            p.setIssueType(NumberSupport.getBigInteger(it[12]));
            p.setIssueTypeName(StringSupport.emptyOnNull(it[13]));
            p.setDateFound(it[14] != null ? DateSupport.formatUS((Date) it[14]) : null);
            p.setDateSubmitted(it[15] != null ? DateSupport.formatUS((Date) it[15]) : null);
            p.setDateResolved(it[16] != null ? DateSupport.formatUS((Date) it[16]) : null);
            p.setDescription(StringSupport.emptyOnNull(it[17]));
            p.setRemarks(StringSupport.emptyOnNull(it[18]));
            p.setAssignedTo(StringSupport.emptyOnNull(it[19]));
            p.setStatusId(NumberSupport.getBigInteger(it[20]));
            p.setStatusName(StringSupport.emptyOnNull(it[21]));
            p.setProjectPhase(NumberSupport.getBigInteger(it[22]));
            p.setProjectPhaseName(StringSupport.emptyOnNull(it[23]));
            p.setFolderId(NumberSupport.getBigInteger(it[24]));
            p.setCreated(it[25] != null ? DateSupport.formatUS((Date) it[25]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[26]));
            p.setVersion(StringSupport.emptyOnNull(it[27]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobIssueLogSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_ISSUE_LOG bpc INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) INNER JOIN GLOB_CONTACT gct ON (bpc.identified_by = gct.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobIssueLogSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, gp.p_number AS project_number, gp.project_code, bpc.spattern, bpc.sno, bpc.ilpcn, bpc.issue_no, "
                + "bpc.ref_id, bpc.identified_by,gct.firstname || ' ' || trim(gct.lastname) as identified_by_name, bpc.issue_type, cvlissuetype.value as issue_type_name, "
                + "bpc.date_found, bpc.date_submitted, bpc.date_resolved,bpc.description,bpc.remarks,bpc.assigned_to,bpc.status_id,cvlstatus.value as status_name, "
                + "bpc.project_phase, cvlpjphase.value as project_phase_name,bpc.folder_id, bpc.created,bpc.created_by, bpc.version ";
        String fromLine = " FROM GLOB_ISSUE_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "INNER JOIN GLOB_CONTACT gct ON (bpc.identified_by = gct.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlstatus ON (bpc.status_id = cvlstatus.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlissuetype ON (bpc.issue_type = cvlissuetype.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlpjphase ON (bpc.project_phase = cvlpjphase.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobIssueLogSearchDefParam filters) {
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
        // Filter Created
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND bpc.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }
        
        // Filter Date Submitted
        if (filters.isAllDateSubmittedActive != null && !filters.isAllDateSubmittedActive && StringSupport.isNotNullAndNotEmpty(filters.startDateSubmitted, filters.endDateSubmitted)) {
            tailLineBuilder.append("AND bpc.date_submitted between to_date('").append(filters.startDateSubmitted).append("','mm-dd-yyyy') and to_date('").append(filters.endDateSubmitted).append("','mm-dd-yyyy')  ");
        }
        
        // Filter Date Found
        if (filters.isAllDateFoundActive != null && !filters.isAllDateFoundActive && StringSupport.isNotNullAndNotEmpty(filters.startDateFound, filters.endDateFound)) {
            tailLineBuilder.append("AND bpc.date_found between to_date('").append(filters.startDateFound).append("','mm-dd-yyyy') and to_date('").append(filters.endDateFound).append("','mm-dd-yyyy')  ");
        }
        
        // Filter Date Resolved
        if (filters.isAllDateResolvedActive != null && !filters.isAllDateResolvedActive && StringSupport.isNotNullAndNotEmpty(filters.startDateResolved, filters.endDateResolved)) {
            tailLineBuilder.append("AND bpc.date_resolved between to_date('").append(filters.startDateResolved).append("','mm-dd-yyyy') and to_date('").append(filters.endDateResolved).append("','mm-dd-yyyy')  ");
        }

        // Filter Status
        if (filters.statusMap != null && !filters.statusMap.isEmpty()) {
            tailLineBuilder.append(buildStatusPartQuery(filters.statusMap));
        }
        
        // Filter Identify By
        if (StringSupport.isNotNullAndNotEmpty(filters.identifiedBy) && !filters.identifiedBy.equals("-1")) {
            tailLineBuilder.append("AND (bpc.identified_by = ").append(filters.identifiedBy).append(") ");
        }
        
        // Filter Issue Type
        if (StringSupport.isNotNullAndNotEmpty(filters.issueType) && !filters.issueType.equals("-1")) {
            tailLineBuilder.append("AND (bpc.issue_type = ").append(filters.issueType).append(") ");
        }
        
        // Filter Project Phase
        if (StringSupport.isNotNullAndNotEmpty(filters.projectPhase) && !filters.projectPhase.equals("-1")) {
            tailLineBuilder.append("AND (bpc.project_phase = ").append(filters.projectPhase).append(") ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Issue No
            if (filters.dtMapSearch.containsKey("issueNo")) {
                tailLineBuilder.append(" (bpc.issue_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("issueNo"))).append("%') ");
            }
            
            // Filter Ref ID
            if (filters.dtMapSearch.containsKey("refId")) {
                tailLineBuilder.append("or (bpc.ref_id like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("refId"))).append("%') ");
            }

            // Filter Description
            if (filters.dtMapSearch.containsKey("description")) {
                tailLineBuilder.append(" or (bpc.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("description"))).append("%') ");
            }
            
            // Filter assigned To
            if (filters.dtMapSearch.containsKey("assignedTo")) {
                tailLineBuilder.append(" or (bpc.assigned_to like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("assignedTo"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobIssueLogSearchDefParam filters, Integer level) {
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
            case "issueNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.issue_no ");
                } else {
                    orderBuilder.append(" order by issue_no ");
                }
                break;
            }
            case "statusName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlstatus.value ");
                } else {
                    orderBuilder.append(" order by status_name ");
                }
                break;
            }
            case "issueTypeName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlissuetype.value ");
                } else {
                    orderBuilder.append(" order by issue_type_name ");
                }
                break;
            }
            case "projectPhaseName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlpjphase.value ");
                } else {
                    orderBuilder.append(" order by project_phase_name ");
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
            case "assignedTo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.assigned_to ");
                } else {
                    orderBuilder.append(" order by assigned_to ");
                }
                break;
            }
            case "identifiedByName": {
                if (level == 1) {
                    orderBuilder.append(" order by (gct.firstname || ' ' || trim(gct.lastname)) ");
                } else {
                    orderBuilder.append(" order by identified_by_name ");
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
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            case "dateFound": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.date_found ");
                } else {
                    orderBuilder.append(" order by date_found ");
                }
                break;
            }
            case "dateSubmitted": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.date_submitted ");
                } else {
                    orderBuilder.append(" order by date_submitted ");
                }
                break;
            }
            case "dateResolved": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.date_resolved ");
                } else {
                    orderBuilder.append(" order by date_resolved ");
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

}
