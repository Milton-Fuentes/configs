/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobCostmgmtLog;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.costmgmt.GlobCostmgmtLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobCostmgmtLogSearchDefParam;
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
public class GlobCostmgmtLogDaoImpl extends GenericDao<BigDecimal, GlobCostmgmtLog> implements GlobCostmgmtLogDao, ISearchDao<GlobCostmgmtLogSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_COSTMGMT_LOG WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(cmpcn)),0) + 1 as icn FROM GLOB_COSTMGMT_LOG WHERE client_id=:clientId AND project_id=:projectId";
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
    public DataTableWrapper<GlobCostmgmtLogBO> getFrontEndSearch(GlobCostmgmtLogSearchDefParam filters) {
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
            List<GlobCostmgmtLogBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private List<GlobCostmgmtLogBO> populateBO(List<Object[]> objects) {
        List<GlobCostmgmtLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobCostmgmtLogBO p = new GlobCostmgmtLogBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProgramId(NumberSupport.getBigInteger(it[2]));
            p.setProgramName(StringSupport.emptyOnNull(it[3]));
            p.setProjectId(NumberSupport.getBigInteger(it[4]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[5]));
            p.setProjectCode(StringSupport.emptyOnNull(it[6]));
            p.setSpattern(StringSupport.emptyOnNull(it[7]));
            p.setSno(NumberSupport.getBigInteger(it[8]));
            p.setCmpcn(StringSupport.emptyOnNull(it[9]));
            p.setReqNo(StringSupport.emptyOnNull(it[10]));
            p.setWorkPackage(StringSupport.emptyOnNull(it[11]));
            p.setApprovedControlBudget(NumberSupport.getBigDecimal(it[12]));
            p.setPlanedValue(NumberSupport.getBigDecimal(it[13]));
            p.setForecastFinalCost(NumberSupport.getBigDecimal(it[14]));
            p.setCommittedCost(NumberSupport.getBigDecimal(it[15]));
            p.setEarned(NumberSupport.getBigDecimal(it[16]));
            p.setActualCost(NumberSupport.getBigDecimal(it[17]));
            p.setInvoiced(NumberSupport.getBigDecimal(it[18]));
            p.setPaid(NumberSupport.getBigDecimal(it[19]));
            p.setRemaining(NumberSupport.getBigDecimal(it[20]));
            p.setRemark(StringSupport.emptyOnNull(it[21]));
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
    public String buildCountQuery(GlobCostmgmtLogSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_COSTMGMT_LOG bpc INNER JOIN GLOB_PROJECT_PROGRAM gpp ON (bpc.program_id = gpp.id) "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) ";
        String whereLine = " WHERE gpp.active='Y' AND gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobCostmgmtLogSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.program_id, gpp.sub_caption as programName, bpc.project_id, gp.p_number AS project_number, "
                + "gp.project_code, bpc.spattern, bpc.sno,bpc.cmpcn, bpc.req_no,bpc.work_package, bpc.approved_control_budget, bpc.planed_value, "
                + "bpc.forecast_final_cost, bpc.committed_cost, bpc.earned, bpc.actual_cost, bpc.invoiced, bpc.paid, bpc.remaining, bpc.remark, "
                + "bpc.folder_id, bpc.created, bpc.created_by, bpc.version ";
        String fromLine = " FROM GLOB_COSTMGMT_LOG bpc "
                + "INNER JOIN GLOB_PROJECT_PROGRAM gpp ON (bpc.program_id = gpp.id) "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) ";
        String whereLine = " WHERE gpp.active='Y' AND gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobCostmgmtLogSearchDefParam filters) {
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
        
        // Filter Program
        if (StringSupport.isNotNullAndNotEmpty(filters.programId) && !filters.programId.equals("-1")) {
            tailLineBuilder.append("AND (bpc.program_id = ").append(filters.programId).append(") ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Req No
            if (filters.dtMapSearch.containsKey("reqNo")) {
                tailLineBuilder.append(" (bpc.req_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("reqNo"))).append("%') ");
            }

            // Filter workPackage
            if (filters.dtMapSearch.containsKey("workPackage")) {
                tailLineBuilder.append("or (bpc.work_package like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("workPackage"))).append("%') ");
            }
            
            // Filter Program Name
            if (filters.dtMapSearch.containsKey("programName")) {
                tailLineBuilder.append("or (gpp.sub_caption like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("programName"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobCostmgmtLogSearchDefParam filters, Integer level) {
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
            case "programName": {
                if (level == 1) {
                    orderBuilder.append(" order by gpp.sub_caption ");
                } else {
                    orderBuilder.append(" order by programName ");
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
            case "workPackage": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.work_package ");
                } else {
                    orderBuilder.append(" order by work_package ");
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
