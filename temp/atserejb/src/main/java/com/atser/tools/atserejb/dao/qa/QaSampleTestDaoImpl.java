/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.dao.glob.GlobProjectDao;
import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.common.jpa.ISearchDao;
import com.atser.tools.atserejb.dao.glob.GlobLabsDao;
import com.atser.tools.atserejb.dao.glob.GlobSystemPropertiesDao;
import com.atser.tools.atserejb.model.QaSampleTest;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.qa.QaSampleTestSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaSampleTestSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Stateless
public class QaSampleTestDaoImpl extends GenericDao<BigDecimal, QaSampleTest> implements QaSampleTestDao, ISearchDao<QaSampleTestSearchDefParam> {
    
    @Inject
    private GlobProjectDao globProjectDao;
    
    @Inject
    private GlobLabsDao globLabsDao;
    
    @Inject
    private GlobSystemPropertiesDao globSystemPropertiesDao;
    
    @Override
    public List<QaSampleTest> findAll() {
        List<QaSampleTest> array = getEntityManager().createNamedQuery("QaSampleTest.findAll").getResultList();
        return array;
    }
    
    @Override
    public String getTestNameListByWorkOrder(BigInteger clientId, BigInteger woId) {
        String query = "SELECT DISTINCT decode(gct.report_title,null,tm.name,gct.report_title) || case when tm.test_table='qaother_dailyreport' then (select nvl2(report_name,'-' || report_name,'') as dname "
                + "FROM qaother_dailyreport where sampletest_id=qst.id) ELSE '' END AS name FROM qa_sample_test qst "
                + "INNER JOIN qa_test_methods tm ON (tm.id = qst.test_id) LEFT JOIN glob_client_test gct ON (tm.id = gct.test_id AND gct.client_id = :clientId) WHERE qst.workorder_id = :woId";
        try {
            List<String> objects = getEntityManager().createNativeQuery(query)
                    .setParameter("clientId", clientId)
                    .setParameter("woId", woId)
                    .getResultList();
            return objects.stream().map((s) -> StringSupport.emptyOnNull(s)).collect(Collectors.joining(","));
        } catch (NoResultException ex) {
            return StringSupport.STRING_EMPTY;
        }
    }
    
    @Override
    public BigDecimal getDynamicTestTableId(String tableName, BigInteger sampleTestId) {
        String query = "SELECT TT.ID  FROM " + StringSupport.sanitizeStringForSql(tableName) + " TT, QA_SAMPLE_TEST ST WHERE TT.SAMPLETEST_ID=ST.ID AND ST.ID= :sampleTestId AND ROWNUM = 1";
        Query q = getEntityManager().createNativeQuery(query).setParameter("sampleTestId", sampleTestId);
        try {
            return (BigDecimal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    /**
     * Search Samples Test
     *
     * @param filters
     * @return List
     */
    @Override
    public List<QaSampleTestSearchBO> getFrontEndSearchAllTestInbox(QaSampleTestSearchDefParam filters) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2);
        try {
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            Map<String, String> systemProp = globSystemPropertiesDao.getSystemPropertiesByClient(NumberSupport.getBigInteger(filters.clientId));
            if (systemProp.isEmpty()) {
                return null;
            }
            return populateBO(objects, systemProp);
        } catch (NoResultException ex) {
            return null;
        }
    }

    /**
     * Search Samples Test
     *
     * @param filters
     * @return DataTableWrapper
     */
    @Override
    //@LatencyLogger
    public DataTableWrapper<QaSampleTestSearchBO> getFrontEndSearchTestInbox(QaSampleTestSearchDefParam filters) {
        // TailLine Definition
        String tailLine = buildFilters(filters);
        // OrderLine Definition
        String orderLine = buildSort(filters, 1);
        String orderLine2 = buildSort(filters, 2);
        String countQuery = buildCountQuery(filters, tailLine);
        String query = buildQuery(filters, tailLine, orderLine, orderLine2, true);
        try {
            Long count = getTotal(countQuery);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            Map<String, String> systemProp = globSystemPropertiesDao.getSystemPropertiesByClient(NumberSupport.getBigInteger(filters.clientId));
            if (systemProp.isEmpty()) {
                return null;
            }
            List<QaSampleTestSearchBO> data = populateBO(objects, systemProp);
            //Long filtered = count(countQuery);
            return new DataTableWrapper<>(count, count, data);
        } catch (NoResultException ex) {
            return null;
        }
    }
    
    private List<QaSampleTestSearchBO> populateBO(List<Object[]> objects, Map<String, String> systemProp) {
        List<QaSampleTestSearchBO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            QaSampleTestSearchBO p = new QaSampleTestSearchBO();
            p.setId(NumberSupport.getBigInteger(it[0]));
            p.setTestName(StringSupport.emptyOnNull(it[1]));
            p.setJspPage(StringSupport.emptyOnNull(it[2]));
            p.setProjectNumber(StringSupport.emptyOnNull(it[3]));
            p.setWoNo(StringSupport.emptyOnNull(it[4]));
            p.setWoShort(NumberSupport.getBigInteger(it[5]));
            p.setSampleNumber(StringSupport.emptyOnNull(it[6]));
            p.setTestNo(NumberSupport.getInteger(it[7]));
            p.setServiceDate(StringSupport.emptyOnNull(it[8]));
            p.setApprovedby(StringSupport.emptyOnNull(it[9]));
            p.setApprovedDate(it[10] != null ? DateSupport.formatUS((Date) it[10]) : null);
            p.setVersion(StringSupport.emptyOnNull(it[11]));
            p.setUnapproved(StringSupport.emptyOnNull(it[12]));
            p.setUnapprovedBy(StringSupport.emptyOnNull(it[13]));
            p.setPendingapproved(StringSupport.emptyOnNull(it[14]));
            p.setPendingapprovedBy(StringSupport.emptyOnNull(it[15]));
            p.setAcknowledgedby(StringSupport.emptyOnNull(it[16]));
            p.setReviewed(StringSupport.emptyOnNull(it[17]));
            p.setReviewedBy(StringSupport.emptyOnNull(it[18]));
            p.setAlerted(StringSupport.emptyOnNull(it[19]));
            p.setAlertedBy(StringSupport.emptyOnNull(it[20]));
            p.setRejected(StringSupport.emptyOnNull(it[21]));
            p.setRejectedBy(StringSupport.emptyOnNull(it[22]));
            p.setSampleId(StringSupport.emptyOnNull(it[23]));
            p.setActive(StringSupport.emptyOnNull(it[24]));
            p.setTestTable(StringSupport.emptyOnNull(it[25]));
            p.setTestId(NumberSupport.getBigInteger(it[26]));
            p.setTestDate(it[27] != null ? DateSupport.formatUS((Date) it[27]) : null);
            p.setDateCompleted(it[28] != null ? DateSupport.formatUS((Date) it[28]) : null);
            p.setOfficeLocation(StringSupport.emptyOnNull(it[29]));
            p.setDeparmentId(NumberSupport.getBigInteger(it[30]));
            p.setProjectCode(StringSupport.emptyOnNull(it[31]));
            p.setHasTestData(StringSupport.emptyOnNull(it[32]));
            p.setReportNo(StringSupport.emptyOnNull(it[33]));
            p.setContractorReportNo(StringSupport.emptyOnNull(it[34]));
            p.setTestResultDeterm(StringSupport.emptyOnNull(it[35]));
            p.setEngApprovedby(StringSupport.emptyOnNull(it[36]));
            p.setEngApprovedDate(it[37] != null ? DateSupport.formatUS((Date) it[37]) : null);
            p.setMaterialUse(StringSupport.emptyOnNull(it[38]));
            //p.setTableId(NumberSupport.getBigInteger(it[39]));
            p.populateExtraVariables(systemProp);
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
    public String buildCountQuery(QaSampleTestSearchDefParam filters, String tailLine) {
        String query = "select ";
        String countOnly = "count(*) AS cnt ";
        String fromLine = " from qa_sample_test t LEFT JOIN qa_sample_test_add_info ai on t.id=ai.sample_test_id LEFT JOIN glob_workorder wo ON t.workorder_id = wo.id INNER JOIN qa_test_methods tm ON tm.id = t.test_id LEFT JOIN qa_sample s ON t.sample_id = s.id inner join glob_info i on t.info_id=i.id INNER JOIN glob_project p ON i.project_id = p.id ";
        String whereLine = " where ";
        whereLine += (!filters.showInactive) ? " p.active='Y' and t.active='Y' and tm.active='Y' " : " (t.active='N' or t.active='Y') and p.active='Y' and tm.active='Y' ";
        whereLine += " and t.test_no is not null and p.client_id = " + filters.clientId + " ";
        fromLine += "LEFT JOIN glob_client_test ct ON tm.id = ct.test_id AND ct.client_id = " + filters.clientId + " ";
        query = query + countOnly + fromLine + whereLine + tailLine;
        return query;
    }
    
    @Override
    public String buildQuery(QaSampleTestSearchDefParam filters, String tailLine, String orderLine, String orderLine2) {
        return buildQuery(filters, tailLine, orderLine, orderLine2, false);
    }
    
    private String buildQuery(QaSampleTestSearchDefParam filters, String tailLine, String orderLine, String orderLine2, Boolean pagination) {
        String fieldLine = "t.id, decode(ct.report_title,null,tm.name,ct.report_title) || case "
                + "when tm.test_table='qaother_dailyreport' then (select nvl2(report_name,'-' || report_name,'') as dname from qaother_dailyreport where sampletest_id=t.id) "
                + "when tm.test_table='qaother_drilledpier' then (select nvl2(pier_type,'-' || pier_type,'') as dname from qaother_drilledpier where sampletest_id=t.id) "
                + "else '' end as test_name, tm.jsp_page, p.p_number AS project_number, wo.wo_no, wo.wo_short, s.sample_no, t.test_no, to_char(wo.service_date,'mm-dd-yyyy') AS service_date, "
                + "t.approvedby, t.approve_date, t.version, t.unapproved, t.unapproved_by, t.pendingapproved, t.pendingapproved_by, t.acknowledgedby, t.reviewed, t.reviewed_by, t.alerted, "
                + "t.alerted_by, t.rejected, t.rejected_by, t.sample_id, t.active, tm.test_table, t.test_id, t.test_date, t.date_completed, p.office_location, p.department_id, p.project_code, t.has_test_data ";
        String fromLine = " from qa_sample_test t LEFT JOIN qa_sample_test_add_info ai on t.id=ai.sample_test_id LEFT JOIN glob_workorder wo ON t.workorder_id = wo.id "
                + "INNER JOIN qa_test_methods tm ON tm.id = t.test_id LEFT JOIN qa_sample s ON t.sample_id = s.id inner join glob_info i on t.info_id=i.id INNER JOIN glob_project p ON i.project_id = p.id ";
        String whereLine = " where ";
        whereLine += (!filters.showInactive) ? " p.active='Y' and t.active='Y' and tm.active='Y' " : " (t.active='N' or t.active='Y') and p.active='Y' and tm.active='Y' ";
        whereLine += " and t.test_no is not null and p.client_id = " + filters.clientId + " ";
        fromLine += "LEFT JOIN glob_client_test ct ON tm.id = ct.test_id AND ct.client_id = " + filters.clientId + " ";
        
        if (filters.showLabReportno) {
            fieldLine += ", test_info.get_test_field(t.id, tm.test_table, 'test_report_no') as test_report_no ";
        } else {
            fieldLine += ", '0' as test_report_no ";
        }
        
        if (filters.usesContractorReportSequence) {
            fieldLine += ", rs.report_no as contractor_report_no ";
            fromLine += " LEFT JOIN glob_report_sequence rs on t.id=rs.report_id and rs.table_name='qa_sample_test' ";
        } else {
            fieldLine += ", 0 as contractor_report_no ";
        }
        
        fieldLine += ", ai.report_stamp_type as determ_status";
        if (filters.testlogShowstateengineer) {
            fieldLine += ", t.engineer_appv_by as engapprvby, t.engineer_appv_date as engapprvdate";
        } else {
            fieldLine += ", null as engapprvby, null as engapprvdate";
        }
        
        if (filters.showMaterialuse) {
            fieldLine += ", cmu.material_use";
            fromLine += " LEFT JOIN glob_client_material_use cmu ON wo.material_use_id=cmu.id ";
        } else {
            fieldLine += ", null as material_use";
        }
        
        if (pagination) {
            //String[] extraFieldLine = new String[]{"(SELECT FN_GET_DYNAMIC_TESTTABLE_ID(tbr_7017.test_table, tbr_7017.id) FROM DUAL) AS TABLE_ID"};
            String query = "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
            return wrapToServerSide(query, orderLine2, filters);
        } else {
            //fieldLine += " ,(SELECT FN_GET_DYNAMIC_TESTTABLE_ID(tm.test_table, t.id) FROM DUAL) AS TABLE_ID ";
            return "SELECT DISTINCT " + fieldLine + fromLine + whereLine + tailLine + orderLine;
        }
    }

    /**
     * Build Filters
     *
     * @param filters
     * @return
     */
    @Override
    public String buildFilters(QaSampleTestSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter 
        if (StringSupport.isNotNullAndNotEmpty(filters.functionId) && !filters.functionId.equals("-1")) {
            tailLineBuilder.append(" and t.info_id in (select id from glob_info where function_id=").append(filters.functionId).append(") ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1")) {
            tailLineBuilder.append(" and (i.project_id = ").append(filters.projectId).append(") ");
        } else {
            if (filters.multiproject) {
                String filter_by_profile = globProjectDao.filterByProfile(" i.project_id", filters.isAdmin, filters.useGlobalProfiles, filters.clientId, filters.userId);
                if (!filter_by_profile.isEmpty()) {
                    tailLineBuilder.append(" AND ( ").append(filter_by_profile).append(" ) ");
                }
            }
        }
        // Filter
        if (!filters.isAllDateActive && StringSupport.isNotNullAndNotEmpty(filters.startDate, filters.endDate)) {
            if (filters.usesWorkorder) {
                tailLineBuilder.append("and wo.service_date between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
            } else {
                tailLineBuilder.append("and t.test_date between to_date('").append(filters.startDate).append("','mm-dd-yyyy') and to_date('").append(filters.endDate).append("','mm-dd-yyyy')  ");
            }
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.testId) && !filters.testId.equals("-1")) {
            tailLineBuilder.append("and (t.test_id = ").append(filters.testId).append(") ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.category) && !filters.category.equals("-1")) {
            tailLineBuilder.append("and (tm.catg_id='").append(filters.category).append("') ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.sampleMatCodeId) && !filters.sampleMatCodeId.equals("-1")) {
            tailLineBuilder.append(" and ( s.material_description = '").append(filters.sampleMatCodeId).append("' OR ai.MATERIAL_DESCRIPTION = '").append(filters.sampleMatCodeId).append("') ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.sampleRandomCode) && !filters.sampleRandomCode.equals("-1")) {
            tailLineBuilder.append(" and ( s.random_sample = '").append(filters.sampleRandomCode).append("' OR ai.random_sample = '").append(filters.sampleRandomCode).append("') ");
        }

        // Filter
        if (filters.showMaterialuse && StringSupport.isNotNullAndNotEmpty(filters.sampleMaterialUseId) && !filters.sampleMaterialUseId.equals("-1")) {
            tailLineBuilder.append(" and ( wo.material_use_id = '").append(filters.sampleMaterialUseId).append("') ");
        }

        // Filter
        if (filters.useDistributionHold && !filters.showDistributionHold) {
            tailLineBuilder.append(" and ( t.NOTIFY_AFTER_SIGN = 'N' ) ");
        }

        // Filter
        if (StringSupport.isNotNullAndNotEmpty(filters.labLocationId)) {
            if (!filters.labLocationId.equals("-1")) {
                tailLineBuilder.append(" and (i.lab_id = '").append(filters.labLocationId).append("') ");
            } else {
                String filter_by_lab = globLabsDao.getLabFunctionFilterByUser(filters.userId, filters.clientId, filters.isAdmin, filters.projectId);
                tailLineBuilder.append(" and i.lab_id in ").append(filter_by_lab);
            }
        }

        // Filter
        if (filters.statusMap != null && !filters.statusMap.isEmpty()) {
            tailLineBuilder.append(buildStatusPartQuery(filters.statusMap));
        }

        // Filter
        if (filters.usesRoleMatrix) {
            if (filters.testViewUnacknowledged) {
                if (filters.testlogShowacknowledgeByproject) {
                    tailLineBuilder.append("and ((p.testlog_showacknowledge='Y' and t.acknowledgedby is not null) or (p.testlog_showacknowledge='N' and t.approvedby is not null)) ");
                } else {
                    if (filters.testlogShowacknowledge) {
                        tailLineBuilder.append("and (t.acknowledgedby is not null) ");
                    } else {
                        tailLineBuilder.append("and (t.approvedby is not null) ");
                    }
                }
            }
        } else {
            if ((filters.currentRole.equals("reviewer") && !filters.usesReviewerShowUnapproved) || filters.currentRole.equals("district_admin")) {
                tailLineBuilder.append("and (t.approvedby is not null) ");
            }
        }

        // Filters By Search
        if (!filters.dtMapSearch.isEmpty()) {
            tailLineBuilder.append(" and ( ");
            // Filter
            if (filters.dtMapSearch.containsKey("testNo")) {
                tailLineBuilder.append("(t.test_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("testNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("sampleNumber")) {
                tailLineBuilder.append(" or (s.sample_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("sampleNumber"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("specimenNo")) {
                tailLineBuilder.append(" or s.id in (select sample_id from qa_sample_specimens where specimen_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("specimenNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("assetNo")) {
                tailLineBuilder.append(" or s.id in (select sample_id from qa_sample_assets where asset_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("assetNo"))).append("%') ");
            }

            // Filter
            if (filters.usesWorkorder && filters.dtMapSearch.containsKey("woNo")) {
                tailLineBuilder.append(" or (wo.wo_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("woNo"))).append("%') ");
            }

            // Filter
            if (filters.dtMapSearch.containsKey("contractorReportNo")) {
                tailLineBuilder.append(" or (rs.report_no like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("contractorReportNo"))).append("%') ");
            }
            
            if (filters.dtMapSearch.containsKey("testResultDeterm")) {
                if (StringSupport.isNotNullAndNotEmpty(filters.dtMapSearch.get("testResultDeterm")) && !StringSupport.getString(filters.dtMapSearch.get("testResultDeterm")).toLowerCase().equals("none")) {
                    tailLineBuilder.append(" or (ai.report_stamp_type like '%").append(StringSupport.sanitizeStringForSql(filters.dtMapSearch.get("testResultDeterm"))).append("%') ");
                } else if (StringSupport.getString(filters.dtMapSearch.get("testResultDeterm")).toLowerCase().equals("none")) {
                    tailLineBuilder.append(" or (ai.report_stamp_type is null) ");
                }
            }

            /*if (StringSupport.isNotNullAndNotEmpty(filters.contractorReportNo)) {
                tailLineBuilder.append("and (rs.report_no='").append(StringSupport.sanitizeStringForSql(filters.contractorReportNo)).append("') ");
            }
            if (filters.usesWorkorder && StringSupport.isNotNullAndNotEmpty(filters.woNo)) {
                tailLineBuilder.append("and (wo.wo_no = '").append(filters.woNo).append("') ");
            }

            if (StringSupport.isNotNullAndNotEmpty(filters.assetNo)) {
                tailLineBuilder.append("and s.id in (select sample_id from qa_sample_assets where asset_no like '%").append(StringSupport.sanitizeStringForSql(filters.assetNo)).append("%') ");
            }

            if (StringSupport.isNotNullAndNotEmpty(filters.specimenNo)) {
                tailLineBuilder.append("and s.id in (select sample_id from qa_sample_specimens where specimen_no like '%").append(StringSupport.sanitizeStringForSql(filters.specimenNo)).append("%') ");
            }*/
            tailLineBuilder.append(" ) ");
        }
        
        return tailLineBuilder.toString();
    }
    
    private String buildStatusPartQuery(AtserLinkedHashMap<String, Object> map) {
        StringBuilder query = new StringBuilder();
        query.append(" and ( ");
        int index = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String segment = getStatusQueryByValue(key);
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
    
    private String getStatusQueryByValue(String key) {
        switch (key) {
            case "yes": {
                return " (t.approvedby is not null and t.acknowledgedby is null and t.engineer_appv_by is null and t.rejected='N') ";
            }
            case "no": {
                return " (t.unapproved='Y' and alerted='N') ";
            }
            case "alerted": {
                return " (t.unapproved='Y' and alerted='Y') ";
            }
            case "completed": {
                return " (t.date_completed is not null and t.reviewed='N' and unapproved='N' and t.approvedby is null) ";
            }
            case "approvedpending": {
                return " (t.pendingapproved_by is not null and t.pendingapproved = 'Y' and unapproved='N' and t.approvedby is null) ";
            }
            case "reviewed": {
                return " (t.reviewed='Y' and unapproved='N' and t.approvedby is null) ";
            }
            case "reviewed_edited": {
                return " ((t.reviewed='Y' or unapproved='Y') and t.approvedby is null) ";
            }
            case "rejected": {
                return " (t.rejected='Y') ";
            }
            case "acknowledged": {
                return " (t.acknowledgedby is not null and t.rejected='N' and t.unapproved='N') ";
            }
            case "new": {
                return " (t.approvedby is null and t.unapproved='N' and t.reviewed='N' and t.date_completed is null) ";
            }
            case "open": {
                return " (t.unapproved='Y' and t.approvedby is null) ";
            }
            case "inactive": {
                return " (t.active='N') ";
            }
            case "state_engineer": {
                return " (t.engineer_appv_by is not null and t.rejected='N') ";
            }
            default:
                return null;
        }
    }

    /**
     * Build Sorts
     *
     * @param filters
     * @param level
     * @return
     */
    @Override
    public String buildSort(QaSampleTestSearchDefParam filters, Integer level) {
        StringBuilder orderBuilder = new StringBuilder();
        if (StringSupport.isNullOrEmpty(filters.sortBy)) {
            if (level == 1) {
                orderBuilder.append(" order by t.test_date ");
            } else {
                orderBuilder.append(" order by test_date ");
            }
            return orderBuilder.toString();
        }
        switch (filters.sortBy) {
            case "testNo": {
                if (level == 1) {
                    orderBuilder.append(" order by to_number(t.test_no) ");
                } else {
                    orderBuilder.append(" order by to_number(test_no) ");
                }
                break;
            }
            case "testName": {
                orderBuilder.append(" order by test_name ");
                break;
            }
            case "projectNumber": {
                if (level == 1) {
                    orderBuilder.append(" order by p.p_number ").append(filters.sortDir);
                    orderBuilder.append(" ,p.office_location,p.department_id,p.project_code,test_name ");
                } else {
                    orderBuilder.append(" order by project_number ").append(filters.sortDir);
                    orderBuilder.append(" ,office_location,department_id,project_code,test_name ");
                }
                break;
            }
            case "woNo": {
                if (level == 1) {
                    orderBuilder.append(" order by p.office_location,p.department_id,p.project_code,wo.wo_short ");
                } else {
                    orderBuilder.append(" order by office_location,department_id,project_code,wo_short ");
                }
                break;
            }
            case "sampleNumber": {
                if (level == 1) {
                    orderBuilder.append(" order by s.sample_no ");
                } else {
                    orderBuilder.append(" order by sample_no ");
                }
                break;
            }
            case "serviceDate": {
                if (level == 1) {
                    orderBuilder.append(" order by t.test_date ");
                } else {
                    orderBuilder.append(" order by test_date ");
                }
                break;
            }
            case "approvedDate": {
                if (level == 1) {
                    orderBuilder.append(" order by t.approve_date ");
                } else {
                    orderBuilder.append(" order by approve_date ");
                }
                break;
            }
            case "reportNo": {
                if (filters.showLabReportno) {
                    orderBuilder.append(" order by lower(test_report_no) ");
                }
                break;
            }
            case "materialUse": {
                if (filters.showMaterialuse) {
                    orderBuilder.append(" order by material_use ");
                }
                break;
            }
            
            case "testResultDeterm": {
                if (level == 1) {
                    orderBuilder.append(" order by ai.report_stamp_type ");
                } else {
                    orderBuilder.append(" order by determ_status ");
                }
                break;
            }
            default: {
                if (level == 1) {
                    orderBuilder.append(" order by t.test_date ");
                } else {
                    orderBuilder.append(" order by test_date ");
                }
                break;
            }
        }
        orderBuilder.append(filters.sortDir);
        return orderBuilder.toString();
    }
    
    @Override
    public BigInteger getNextTestNoByProject(BigInteger projectId) {
        String query = "SELECT max(to_number(test_no)) AS MaxTestNo FROM glob_info, qa_sample_test WHERE glob_info.id = qa_sample_test.info_id AND glob_info.project_id = :projectId";
        Query q = getEntityManager().createNativeQuery(query).setParameter("projectId", projectId);
        BigDecimal maxwon = (BigDecimal) q.getSingleResult();
        BigInteger result = (maxwon == null) ? BigInteger.ZERO : maxwon.toBigInteger();
        return result.add(BigInteger.ONE);
    }
    
}
