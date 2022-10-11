/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobContractmgmtLog;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.contractmgmt.GlobContractmgmtLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobContractmgmtLogSearchDefParam;
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
public class GlobContractmgmtLogDaoImpl extends GenericDao<BigDecimal, GlobContractmgmtLog> implements GlobContractmgmtLogDao, ISearchDao<GlobContractmgmtLogSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;
    
    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_CONTRACTMGMT_LOG WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(cmpcn)),0) + 1 as icn FROM GLOB_CONTRACTMGMT_LOG WHERE client_id=:clientId AND project_id=:projectId";
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
    public DataTableWrapper<GlobContractmgmtLogBO> getFrontEndSearch(GlobContractmgmtLogSearchDefParam filters) {
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
            List<GlobContractmgmtLogBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private List<GlobContractmgmtLogBO> populateBO(List<Object[]> objects) {
        List<GlobContractmgmtLogBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobContractmgmtLogBO p = new GlobContractmgmtLogBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setProjectCode(StringSupport.emptyOnNull(it[4]));
            p.setSpattern(StringSupport.emptyOnNull(it[5]));
            p.setSno(NumberSupport.getBigInteger(it[6]));
            p.setCmpcn(StringSupport.emptyOnNull(it[7]));
            p.setReqNo(StringSupport.emptyOnNull(it[8]));
            p.setRefId(StringSupport.emptyOnNull(it[9]));
            p.setCategoryId(NumberSupport.getBigInteger(it[10]));
            p.setCategoryName(StringSupport.emptyOnNull(it[11]));
            p.setDescription(StringSupport.emptyOnNull(it[12]));
            p.setVersionNo(StringSupport.emptyOnNull(it[13]));
            p.setFolderId(NumberSupport.getBigInteger(it[14]));
            p.setCreated(it[15] != null ? DateSupport.formatUS((Date) it[15]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[16]));
            p.setVersion(StringSupport.emptyOnNull(it[17]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobContractmgmtLogSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_CONTRACTMGMT_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcat ON (bpc.category_id = cvlcat.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobContractmgmtLogSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, gp.p_number AS project_number, gp.project_code, bpc.spattern, "
                + "bpc.sno, bpc.cmpcn, bpc.req_no, bpc.ref_id, bpc.category_id, cvlcat.value as category_name,bpc.description,bpc.version_no, "
                + "bpc.folder_id, bpc.created, bpc.created_by, bpc.version ";
        String fromLine = " FROM GLOB_CONTRACTMGMT_LOG bpc "
                + "INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcat ON (bpc.category_id = cvlcat.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobContractmgmtLogSearchDefParam filters) {
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

        // Filter Category
        if (StringSupport.isNotNullAndNotEmpty(filters.categoryId) && !filters.categoryId.equals("-1")) {
            tailLineBuilder.append("AND (bpc.category_id = ").append(filters.categoryId).append(") ");
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
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobContractmgmtLogSearchDefParam filters, Integer level) {
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
            case "categoryName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlcat.value ");
                } else {
                    orderBuilder.append(" order by category_name ");
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
