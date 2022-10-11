/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.model.GlobRiskRegister;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.risk.GlobRiskRegisterBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobRiskRegisterSearchDefParam;
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
public class GlobRiskRegisterDaoImpl extends GenericDao<BigDecimal, GlobRiskRegister> implements GlobRiskRegisterDao, ISearchDao<GlobRiskRegisterSearchDefParam> {

    @Inject
    private GlobProjectDao globProjectDao;

    @Override
    public BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern) {
        String query = "SELECT NVL(MAX(to_number(sno)),0) + 1 as sno FROM GLOB_RISK_REGISTER WHERE client_id=:clientId AND spattern = :spattern";
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
        String query = "SELECT NVL(MAX(to_number(rpcn)),0) + 1 as icn FROM GLOB_RISK_REGISTER WHERE client_id=:clientId AND project_id=:projectId";
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
    public DataTableWrapper<GlobRiskRegisterBO> getFrontEndSearch(GlobRiskRegisterSearchDefParam filters) {
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
            List<GlobRiskRegisterBO> data = populateBO(objects);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<GlobRiskRegisterBO> populateBO(List<Object[]> objects) {
        List<GlobRiskRegisterBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            GlobRiskRegisterBO p = new GlobRiskRegisterBO();
            p.setId(NumberSupport.getBigDecimal(it[0]));
            p.setClientId(NumberSupport.getBigInteger(it[1]));
            p.setProjectId(NumberSupport.getBigInteger(it[2]));
            p.setSpattern(StringSupport.emptyOnNull(it[3]));
            p.setSno(NumberSupport.getBigInteger(it[4]));
            p.setRpcn(StringSupport.emptyOnNull(it[5]));
            p.setRiskNo(StringSupport.emptyOnNull(it[6]));
            p.setRefId(StringSupport.emptyOnNull(it[7]));
            p.setRisk(StringSupport.emptyOnNull(it[8]));
            p.setRiskOwner(StringSupport.emptyOnNull(it[9]));
            p.setRiskTrigger(StringSupport.emptyOnNull(it[10]));
            p.setRiskCatg(NumberSupport.getBigInteger(it[11]));
            p.setRiskCatgName(StringSupport.emptyOnNull(it[12]));
            p.setProbability(NumberSupport.getBigInteger(it[13]));
            p.setProbabilityName(StringSupport.emptyOnNull(it[14]));
            p.setImpact(NumberSupport.getBigInteger(it[15]));
            p.setImpactName(StringSupport.emptyOnNull(it[16]));
            p.setExpectedResult(StringSupport.emptyOnNull(it[17]));
            p.setPositiveRiskResp(NumberSupport.getBigInteger(it[18]));
            p.setPositiveRiskRespName(StringSupport.emptyOnNull(it[19]));
            p.setNegativeRiskResp(NumberSupport.getBigInteger(it[20]));
            p.setNegativeRiskRespName(StringSupport.emptyOnNull(it[21]));
            p.setRespTrigger(StringSupport.emptyOnNull(it[22]));
            p.setRespOwner(StringSupport.emptyOnNull(it[23]));
            p.setRespDescription(StringSupport.emptyOnNull(it[24]));
            p.setExpectedRespImpact(StringSupport.emptyOnNull(it[25]));
            p.setStatusId(NumberSupport.getBigInteger(it[26]));
            p.setStatusName(StringSupport.emptyOnNull(it[27]));
            p.setFolderId(NumberSupport.getBigInteger(it[28]));
            p.setCreated(it[29] != null ? DateSupport.formatUS((Date) it[29]) : null);
            p.setCreatedBy(StringSupport.emptyOnNull(it[30]));
            p.setVersion(StringSupport.emptyOnNull(it[31]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[32]));
            p.setProjectCode(StringSupport.emptyOnNull(it[33]));
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
    public String buildCountQuery(GlobRiskRegisterSearchDefParam filters, String tailLine) {
        String query = "SELECT ";
        String countOnly = "COUNT(*) AS cnt ";
        String fromLine = " FROM GLOB_RISK_REGISTER bpc INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }

    @Override
    public String buildQuery(GlobRiskRegisterSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        String fieldLine = " bpc.id, bpc.client_id, bpc.project_id, bpc.spattern, bpc.sno, bpc.rpcn, bpc.risk_no, bpc.ref_id, bpc.risk, bpc.risk_owner, bpc.risk_trigger, bpc.risk_catg, cvlrcatg.value as risk_catg_name, "
                + "bpc.probability, cvlprob.value as probability_name,bpc.impact, cvlimpact.value as impact_name, bpc.expected_result, bpc.positive_risk_resp, cvlprr.value as positive_risk_resp_name, bpc.negative_risk_resp, "
                + "cvlnrr.value as negative_risk_resp_name, bpc.resp_trigger, bpc.resp_owner, bpc.resp_description, bpc.expected_resp_impact, bpc.status_id,cvlstatus.value as status_name , bpc.folder_id, bpc.created, "
                + "bpc.created_by, bpc.version, gp.p_number AS project_number, gp.project_code ";
        String fromLine = " FROM GLOB_RISK_REGISTER bpc INNER JOIN GLOB_PROJECT gp ON (bpc.project_id = gp.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlrcatg ON (bpc.risk_catg = cvlrcatg.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlprob ON (bpc.probability = cvlprob.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlimpact ON (bpc.impact = cvlimpact.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlprr ON (bpc.positive_risk_resp = cvlprr.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlnrr ON (bpc.negative_risk_resp = cvlnrr.id) "
                + "LEFT OUTER JOIN QM_CVL_FIELD_DATA cvlstatus ON (bpc.status_id = cvlstatus.id) ";
        String whereLine = " WHERE gp.active='Y' ";
        whereLine += (!filters.showInactive) ? " AND bpc.active='N' " : " AND bpc.active='Y' ";
        whereLine += " AND bpc.deleted = 'N' AND bpc.client_id = " + filters.clientId + " ";
        String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        return wrapToServerSide(query, orderLine2, filters);
    }

    @Override
    public String buildFilters(GlobRiskRegisterSearchDefParam filters) {
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
        if (filters.isAllDateActive != null && !filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            tailLineBuilder.append("AND bpc.created between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
        }

        // Filter
        if (filters.statusMap != null && !filters.statusMap.isEmpty()) {
            tailLineBuilder.append(buildStatusPartQuery(filters.statusMap));
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" AND ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("riskNo")) {
                tailLineBuilder.append("(bpc.risk_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("riskNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("risk")) {
                tailLineBuilder.append(" or (bpc.risk like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("risk"))).append("%') ");
            }
            tailLineBuilder.append(" ) ");
        }

        return tailLineBuilder.toString();
    }

    @Override
    public String buildSort(GlobRiskRegisterSearchDefParam filters, Integer level) {
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
            case "riskNo": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.risk_no ");
                } else {
                    orderBuilder.append(" order by risk_no ");
                }
                break;
            }
            case "risk": {
                if (level == 1) {
                    orderBuilder.append(" order by bpc.risk ");
                } else {
                    orderBuilder.append(" order by risk ");
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
