/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobQacomplianceLog;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.qacompliance.GlobQacomplianceLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobQacomplianceLogSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class GlobQacomplianceLogDaoImpl extends GenericDao<BigDecimal, GlobQacomplianceLog> implements GlobQacomplianceLogDao, ISearchDao<GlobQacomplianceLogSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_QACOMPLIANCE_LOG WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(qcpcn)),0) + 1 as icn FROM GLOB_QACOMPLIANCE_LOG WHERE client_id=:clientId AND project_id=:projectId";
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
    public DataTableWrapper<GlobQacomplianceLogBO> getFrontEndSearch(GlobQacomplianceLogSearchDefParam filters) {
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
            List<GlobQacomplianceLogBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private List<GlobQacomplianceLogBO> populateBO(List<Object[]> objects) {
        List<GlobQacomplianceLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobQacomplianceLogBO p = new GlobQacomplianceLogBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setProjectCode(StringSupport.emptyOnNull(it[4]));
            p.setSpattern(StringSupport.emptyOnNull(it[5]));
            p.setSno(NumberSupport.getBigInteger(it[6]));
            p.setQcpcn(StringSupport.emptyOnNull(it[7]));
            p.setReqNo(StringSupport.emptyOnNull(it[8]));
            p.setRefId(StringSupport.emptyOnNull(it[9]));
            p.setDescription(StringSupport.emptyOnNull(it[10]));
            p.setMeetRequirement(StringSupport.getActiveAsCharacter(StringSupport.emptyOnNull(it[11])));
            p.setResponse(StringSupport.emptyOnNull(it[12]));
            p.setQcTypeId(NumberSupport.getBigInteger(it[13]));
            p.setQcTypeName(StringSupport.emptyOnNull(it[14]));
            p.setScorecard(NumberSupport.getBigDecimal(it[15]));
            p.setObjective(StringSupport.emptyOnNull(it[16]));
            p.setQcPeriodId(NumberSupport.getBigInteger(it[17]));
            p.setQcPeriodName(StringSupport.emptyOnNull(it[18]));
            p.setThreshold(StringSupport.emptyOnNull(it[19]));
            p.setRange(StringSupport.emptyOnNull(it[20]));
            p.setWarning(NumberSupport.getBigDecimal(it[21]));
            p.setFolderId(NumberSupport.getBigInteger(it[22]));
            p.setCreated(it[23] != null ? DateSupport.formatUS((Date) it[23]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[24]));
            p.setVersion(StringSupport.emptyOnNull(it[25]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobQacomplianceLogSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_QACOMPLIANCE_LOG bpc INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlqctype ON (bpc.qc_type_id = cvlqctype.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlsysperiod ON (bpc.qc_period_id = cvlsysperiod.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobQacomplianceLogSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, gp.p_number AS project_number, gp.project_code, bpc.spattern, bpc.sno, "
                + "bpc.qcpcn, bpc.req_no, bpc.ref_id, bpc.description,bpc.meet_requirement, bpc.response, bpc.qc_type_id, cvlqctype.value as qc_type_name, "
                + "bpc.scorecard, bpc.objective, bpc.qc_period_id, cvlsysperiod.value as qc_period_name, bpc.threshold, bpc.range, bpc.warning, "
                + "bpc.folder_id, bpc.created, bpc.created_by, bpc.version ";
        String fromLine = " FROM GLOB_QACOMPLIANCE_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlqctype ON (bpc.qc_type_id = cvlqctype.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlsysperiod ON (bpc.qc_period_id = cvlsysperiod.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobQacomplianceLogSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" AND (bpc.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" bpc_project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }

        // Filter Created
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND bpc.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter Type
        if (StringSupport.isNotNullAndNotEmpty(filters.qcTypeId) && !filters.qcTypeId.equals("-1")) {
            tailLineBuilder.append("AND (bpc.qc_type_id = ").append(filters.qcTypeId).append(") ");
        }

        // Filter Period
        if (StringSupport.isNotNullAndNotEmpty(filters.qcPeriodId) && !filters.qcPeriodId.equals("-1")) {
            tailLineBuilder.append("AND (bpc.qc_period_id = ").append(filters.qcPeriodId).append(") ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Req No
            if (filters.dtMapSearch.containsKey("reqNo")) {
                tailLineBuilder.append(" (bpc.req_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("reqNo"))).append("%') ");
            }

            // Filter Ref ID
            if (filters.dtMapSearch.containsKey("refId")) {
                tailLineBuilder.append("or (bpc.ref_id like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("refId"))).append("%') ");
            }

            // Filter Description
            if (filters.dtMapSearch.containsKey("description")) {
                tailLineBuilder.append(" or (bpc.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("description"))).append("%') ");
            }

            // Filter response
            if (filters.dtMapSearch.containsKey("response")) {
                tailLineBuilder.append(" or (bpc.response like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("response"))).append("%') ");
            }
            
            // Filter objective
            if (filters.dtMapSearch.containsKey("objective")) {
                tailLineBuilder.append(" or (bpc.objective like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("objective"))).append("%') ");
            }

            // Filter threshold
            if (filters.dtMapSearch.containsKey("threshold")) {
                tailLineBuilder.append(" or (bpc.threshold like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("threshold"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobQacomplianceLogSearchDefParam filters, Integer level) {
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
            case "reqNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.req_no ");
                } else {
                    orderBuilder.append(" order by req_no ");
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
            case "refId": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.ref_id ");
                } else {
                    orderBuilder.append(" order by ref_id ");
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
            case "meetRequirement": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.meet_requirement ");
                } else {
                    orderBuilder.append(" order by meet_requirement ");
                }
                break;
            }
            case "qcTypeName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlqctype.value ");
                } else {
                    orderBuilder.append(" order by qc_type_name ");
                }
                break;
            }
            case "qcPeriodName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlsysperiod.value ");
                } else {
                    orderBuilder.append(" order by qc_period_name ");
                }
                break;
            }
            case "threshold": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.threshold ");
                } else {
                    orderBuilder.append(" order by threshold ");
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

}
