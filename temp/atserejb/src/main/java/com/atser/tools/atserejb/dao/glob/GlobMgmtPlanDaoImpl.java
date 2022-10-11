/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobMgmtPlan;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.mgmtplan.GlobMgmtPlanBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobMgmtPlanSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

@Stateless
public class GlobMgmtPlanDaoImpl extends GenericDao<BigDecimal, GlobMgmtPlan> implements GlobMgmtPlanDao, ISearchDao<GlobMgmtPlanSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;
    
    @Override
    public DataTableWrapper<GlobMgmtPlanBO> getFrontEndSearch(GlobMgmtPlanSearchDefParam filters) {
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
            List<GlobMgmtPlanBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private List<GlobMgmtPlanBO> populateBO(List<Object[]> objects) {
        List<GlobMgmtPlanBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobMgmtPlanBO p = new GlobMgmtPlanBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProgramId(NumberSupport.getBigInteger(it[2]));
            p.setProgramName(StringSupport.emptyOnNull(it[3]));
            p.setProjectId(NumberSupport.getBigInteger(it[4]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[5]));
            p.setProjectCode(StringSupport.emptyOnNull(it[6]));
            p.setPlanCatgId(NumberSupport.getBigInteger(it[7]));
            p.setPlanCatgName(StringSupport.emptyOnNull(it[8]));
            p.setDescription(StringSupport.emptyOnNull(it[9]));
            p.setFolderId(NumberSupport.getBigInteger(it[10]));
            p.setCreated(it[11] != null ? DateSupport.formatUS((Date) it[11]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[12]));
            p.setVersion(StringSupport.emptyOnNull(it[13]));
            p.setTotalofDoc(NumberSupport.getBigInteger(it[14]));
            return p;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }

    @Override
    public String buildCountQuery(GlobMgmtPlanSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_MGMT_PLAN gmp INNER JOIN GLOB_PROJECT_PROGRAM gpp ON (gmp.program_id = gpp.id) "
                + "LEFT JOIN GLOB_PROJECT gp ON (gmp.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcatg ON (gmp.plan_catg_id = cvlcatg.id) ";
        String whereLine = " WHERE gpp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND gmp.active='N' " : " AND gmp.active='Y' ";
        whereLine += " AND gmp.deleted = 'N' AND gmp.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobMgmtPlanSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
         String fieldLine = " gmp.id, gmp.client_id, gmp.program_id, gpp.sub_caption as programName, gmp.project_id, gp.p_number AS PROJECT_NUMBER, "
                 + "gp.project_code, gmp.plan_catg_id, cvlcatg.value as planCatgName, gmp.description, gmp.folder_id, gmp.created, "
                 + "gmp.created_by, gmp.version, (SELECT count(id) FROM GLOB_MGMT_PLAN_DOC gmpd WHERE gmpd.plan_id = gmp.id AND gmpd.deleted = 'N' AND gmpd.active = 'Y') as totalofdoc ";
        String fromLine = " FROM GLOB_MGMT_PLAN gmp "
                + "INNER JOIN GLOB_PROJECT_PROGRAM gpp ON (gmp.program_id = gpp.id) "
                + "LEFT JOIN GLOB_PROJECT gp ON (gmp.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlcatg ON (gmp.plan_catg_id = cvlcatg.id) ";
        String whereLine = " WHERE gpp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND gmp.active='N' " : " AND gmp.active='Y' ";
        whereLine += " AND gmp.deleted = 'N' AND gmp.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobMgmtPlanSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" AND (gmp.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" gmp.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }
        // Filter Created
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND gmp.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') AND to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }
        
        // Filter Program
        if (StringSupport.isNotNullAndNotEmpty(filters.programId) && !filters.programId.equals("-1")) {
            tailLineBuilder.append("AND (gmp.program_id = ").append(filters.programId).append(") ");
        }
        
        // Filter Category Plan
        if (StringSupport.isNotNullAndNotEmpty(filters.planCatgId) && !filters.planCatgId.equals("-1")) {
            tailLineBuilder.append("AND (gmp.plan_catg_id = ").append(filters.planCatgId).append(") ");
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter Program Name
            if (filters.dtMapSearch.containsKey("programName")) {
                tailLineBuilder.append(" (gpp.sub_caption like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("programName"))).append("%') ");
            }
            
            // Filter Category Plan
            if (filters.dtMapSearch.containsKey("planCatgName")) {
                tailLineBuilder.append("or (cvlcatg.value like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("planCatgName"))).append("%') ");
            }

            // Filter Description
            if (filters.dtMapSearch.containsKey("description")) {
                tailLineBuilder.append(" or (gmp.description like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("description"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobMgmtPlanSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by gmp.created ");
            } else {
                orderBuilder.append(" order by created ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "programName": {
                if (level == 1) {
                    orderBuilder.append(" order by gpp.sub_caption ");
                } else {
                    orderBuilder.append(" order by programName ");
                }
                break;
            }
            case "planCatgName": {
                if (level == 1) {
                    orderBuilder.append(" order by cvlcatg.value ");
                } else {
                    orderBuilder.append(" order by planCatgName ");
                }
                break;
            }
            case "description": {
                if (level == 1) {
                    orderBuilder.append(" order by gmp.description ");
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
            case "created": {
                if (level == 1) {
                    orderBuilder.append(" order by gmp.created ");
                } else {
                    orderBuilder.append(" order by created ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by gmp.created ");
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
