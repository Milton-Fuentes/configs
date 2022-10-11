/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.dao.cm.CmContractActivityDao;
import com.atser.tools.atserejb.dao.cm.CmDailyLocationDao;
import com.atser.tools.atserejb.dao.qa.QaSampleTestDao;
import com.atser.tools.atserejb.common.jpa.GenericDao;
import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import com.atser.tools.atserejb.model.GlobServicesLab;
import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.enumerator.eServiceType;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.dispatch.EngServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.FieldServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.LabServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.ws.rs.core.Response;

@Stateless
public class GlobWorkorderDaoImpl extends GenericDao<BigDecimal, GlobWorkorder> implements GlobWorkorderDao, IBaseEJBException {

    @Inject
    private CmContractActivityDao cmContractActivityDao;

    @Inject
    private CmDailyLocationDao cmDailyLocationDao;

    @Inject
    private GlobDispatchcallServicesDao globDispatchcallServicesDao;

    @Inject
    private GlobServicesLabDao globServicesLabDao;

    @Inject
    private QaSampleTestDao qaSampleTestDao;

    @Override
    public GlobWorkorder findByWoToken(String tk) {
        if (tk == null || tk.isEmpty()) {
            return null;
        }
        try {
            GlobWorkorder elem = (GlobWorkorder) getEntityManager()
                    .createNamedQuery("GlobWorkorder.findByWOToken")
                    .setParameter("woToken", tk)
                    .getSingleResult();
            return elem;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public String getNextWorkOrderNumber(BigInteger projectId) {
        NumberFormat formatter = new DecimalFormat("#0000");
        String query = "SELECT MAX(TO_NUMBER(WO_NO, '99999.99')) MaxWON FROM GLOB_WORKORDER t WHERE t.PROJECT_ID = :projectId";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("projectId", projectId);
        BigDecimal maxwon = (BigDecimal) q.getSingleResult();
        BigInteger result = (maxwon == null) ? BigInteger.ZERO : maxwon.toBigInteger();
        result = result.add(BigInteger.ONE);
        return formatter.format(result);
    }

    @Override
    public List<String> getListActivityNo(BigInteger projectId) {
        List<String> list = new ArrayList<>();

        @SuppressWarnings("unchecked")
        List<Object> objs = getEntityManager().createNamedQuery("GlobWorkorder.getDistinctByActivityId")
                .setParameter("projectId", projectId)
                .getResultList();
        objs.forEach((obj) -> {
            list.add(obj.toString());
        });
        return list;
    }

    @Override
    public List<WorkOrderTO> filterAndGetWorkOrderTO(GlobSheduleSearchDefParam filters) {
        try {
            // TailLine Definition
            String tailLine = buildFilters(filters);
            // OrderLine Definition
            String query = buildQuery(filters, tailLine);
            List<Object[]> objects = getEntityManager().createNativeQuery(query).getResultList();
            List<WorkOrderTO> data = populateBO(objects, filters);
            return data;
        } catch (NoResultException ex) {
            return null;
        }
    }

    private List<WorkOrderTO> populateBO(List<Object[]> objects, GlobSheduleSearchDefParam filters) {
        List<WorkOrderTO> list = new ArrayList<>();
        objects.stream().map((it) -> {
            WorkOrderTO woTo = new WorkOrderTO();
            woTo.setLogId(NumberSupport.getBigInteger(it[0]));
            woTo.setWoId(NumberSupport.getBigInteger(it[1]));
            woTo.setHours(NumberSupport.getBigDecimal(it[2]));
            woTo.setSpecialinstruction(StringSupport.emptyOnNull(it[3]));
            woTo.setTechRefId(NumberSupport.getBigInteger(it[4]));
            woTo.setTechFullName(StringSupport.emptyOnNull(it[5]));
            woTo.setDecisionFlag(it[6] != null ? Long.valueOf(StringSupport.getString(it[6])) : null);
            woTo.setServiceDate(it[7] != null ? DateSupport.formatUS((Date) it[7]) : null);
            woTo.setPaperworkReceived(StringSupport.emptyOnNull(it[8]));
            woTo.setAssigment(StringSupport.emptyOnNull(it[9]));
            woTo.setInfo_id(NumberSupport.getBigInteger(it[10]));
            woTo.setWonumber(StringSupport.emptyOnNull(it[11]));
            woTo.setCertification(StringSupport.emptyOnNull(it[12]));
            woTo.setContactperson(StringSupport.emptyOnNull(it[13]));
            woTo.setContacttelephone(StringSupport.emptyOnNull(it[14]));
            woTo.setTimeatoffice(StringSupport.getString(it[15]));
            woTo.setTimeatsite(StringSupport.getString(it[16]));
            if (StringSupport.isNotNullAndNotEmpty(it[17])) {
                woTo.setIscancel(StringSupport.getString(it[17]).toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
            }
            woTo.setServiceList(StringSupport.getString(it[18]));
            if (it[19] != null) {
                woTo.setTraceDescription(cmContractActivityDao.getActivityName(NumberSupport.getBigDecimal(it[19]), "nd"));
            }
            if (StringSupport.isNotNullAndNotEmpty(it[20])) {
                woTo.setRlocation(cmDailyLocationDao.getDailyLocation(StringSupport.getString(it[20])));
            }
            woTo.setProjectId(NumberSupport.getBigInteger(it[21]));
            woTo.setProjectNumber(StringSupport.getString(it[22]));
            woTo.setFunctionName(StringSupport.getString(it[23]));
            woTo.setLabName(StringSupport.getString(it[24]));
            woTo.setLabId(NumberSupport.getBigInteger(it[25]));
            woTo.setRequestedBy(StringSupport.getString(it[26]));
            woTo.setRegionId(NumberSupport.getBigInteger(it[27]));
            woTo.setTravelTime(StringSupport.getString(it[28]));
            woTo.setEmailStatus(StringSupport.getString(it[29]));
            woTo.setProjectName(StringSupport.getString(it[30]));
            woTo.setRegionCatgColorId(NumberSupport.getBigInteger(it[31]));
            if (StringSupport.isNotNullAndNotEmpty(it[32])) {
                woTo.setIsWoCompleted(StringSupport.getString(it[32]));
            }
            woTo.setUnanswcount(NumberSupport.getInteger(it[33]));
            woTo.setAnswcount(NumberSupport.getInteger(it[34]));
            woTo.setSubmReport(NumberSupport.getInteger(it[35]));
            woTo.setMaterialUseId(NumberSupport.getBigInteger(it[36]));
            woTo.setStatus(StringSupport.emptyOnNull(it[37]));
            woTo.setCancelledReason(StringSupport.emptyOnNull(it[38]));

            // Populate Services
            List<GlobDispatchcallServices> servList = globDispatchcallServicesDao.findByCallLogId(woTo.getLogId());
            servList.forEach((svList) -> {
                if (svList.getType().equals(eServiceType.eEng.getValue())) {
                    woTo.addEngService(new EngServiceTO(svList.getServiceDesc()));
                } else if (svList.getType().equals(eServiceType.eField.getValue())) {
                    woTo.addFieldService(new FieldServiceTO(NumberSupport.getBigInteger(svList.getService())));
                } else if (svList.getType().equals(eServiceType.eLab.getValue())) {
                    GlobServicesLab lbsrv = globServicesLabDao.findById(NumberSupport.getBigDecimal(svList.getService()));
                    woTo.addLabService(new LabServiceTO(NumberSupport.getBigInteger(svList.getService()), lbsrv.getLabCategoryId()));
                }
            });

            // Populate Test Name List
            if (woTo.getSubmReport() > 0) {
                woTo.setTestNameList(qaSampleTestDao.getTestNameListByWorkOrder(NumberSupport.getBigInteger(filters.clientId), woTo.getWoId()));
            }

            return woTo;
        }).forEachOrdered((to) -> {
            list.add(to);
        });
        return list;
    }
    
    private String buildQuery00(GlobSheduleSearchDefParam filters, String tailLine) {
        String fieldLine = "calllog.id, gw.id wo_id, calllog.hours, calllog.spec_instr, calllog.techrefid, calllog.technician,calllog.decisionflag, gw.service_date, calllog.paperwork_received, calllog.assignment, "
                + "calllog.info_id, gw.wo_no, gw.certification, gw.contact, gw.contact_telephone, gw.arrive_lab_time, calllog.time_site, gw.cancelled, calllog.services_requested, gw.activity_id, calllog.reqlocation, "
                + "gp.id as project_id, gp.p_number as project_number, ginfod.function as function_name, ginfod.lab as lab_name, ginfod.lab_id, calllog.requested_by, gp.region_id, gw.travel_time, calllog.email_status,"
                + "gp.p_name AS project_name, gcr.catg_color_id as region_catg_color_id, gw.wo_completed as wo_completed, "
                + "(SELECT COUNT(gnt.id) FROM glob_notification_track gnt WHERE gnt.refid = calllog.id AND gnt.status = 'WAITING' AND gnt.module= 'qm' AND gnt.functionality = 'basic_dispatch' AND gnt.ntf_type = 'EMAIL') AS unanswcount, "
                + "(SELECT COUNT(gnt.id) FROM glob_notification_track gnt WHERE gnt.refid = calllog.id AND gnt.status = 'ANSWERED' AND gnt.module= 'qm' AND gnt.functionality = 'basic_dispatch' AND gnt.ntf_type = 'EMAIL') AS answcount, "
                + "(SELECT count(qst.id) FROM qa_sample_test qst WHERE gw.id = qst.workorder_id AND qst.from_mobile = 'Y' AND qst.active = 'Y') AS submreport, gw.material_use_id, calllog.status, calllog.cancelled_reason ";
        String fromLine = " FROM glob_dispatchcall_log calllog "
                + "INNER JOIN glob_project gp ON calllog.project_id = gp.id "
                + "LEFT JOIN glob_project_client gpc ON gp.project_client_id = gpc.id "
                + "LEFT JOIN glob_client_regions gcr ON gp.region_id = gcr.id "
                + "LEFT JOIN glob_workorder gw ON calllog.wo_id = gw.id "
                //+ "LEFT JOIN dispatchlogtechhours dlto ON (to_char(calllog.service_date,'ww/yy') = dlto.weekyear) AND (calllog.technician = dlto.technician) " --08/30/2021
                + "LEFT JOIN glob_billing_code gbc ON calllog.cert_billing_code_id=gbc.id "
                + "LEFT JOIN project_billing_invoice_todate pbitd ON gp.id=pbitd.project_id "
                + "LEFT JOIN project_billing_detail pbd ON calllog.cert_billing_code_id=pbd.billing_code_id and calllog.project_id=pbd.project_id "
                + "LEFT JOIN glob_pdausers gpdau on calllog.technician=gpdau.long_name "
                + "LEFT JOIN glob_employee gep on gpdau.employee_no=gep.employee_no "
                + "LEFT JOIN glob_info_detail ginfod on calllog.info_id=ginfod.id ";
        String whereLine = " WHERE gp.active='Y' AND gw.active = 'Y' AND gw.cancelled IS NOT NULL AND gw.wo_no IS NOT NULL AND gp.client_id = " + filters.clientId + " ";
        return "SELECT " + fieldLine + fromLine + whereLine + tailLine;
    }
    

    private String buildQuery(GlobSheduleSearchDefParam filters, String tailLine) {
        String fieldLine = 
                  " calllog.id,  "
                + " gw.id wo_id,  "
                + " calllog.hours,  "
                + " calllog.spec_instr,  "
                + " calllog.techrefid,  "
                + " calllog.technician,  "
                + " calllog.decisionflag,  "
                + " gw.service_date,  "
                + " calllog.paperwork_received,  "
                + " calllog.assignment,  "
                + " calllog.info_id,  "
                + " gw.wo_no,  "
                + " gw.certification,  "
                + " gw.contact,  "
                + " gw.contact_telephone,  "
                + " gw.arrive_lab_time,  "
                + " calllog.time_site,  " 
                + " gw.cancelled,  " 
                + " calllog.services_requested,  "
                + " gw.activity_id,  "
                + " calllog.reqlocation,  "
                + " gp.id as project_id,  "
                + " gp.p_number as project_number,  " 
                + " fn.f_name as function_name,  "
                + " lab.name as lab_name,  "
                + " ginfod.lab_id,  " 
                + " calllog.requested_by,  " 
                + " gp.region_id,  "
                + " gw.travel_time,  "
                + " calllog.email_status,  "
                + " gp.p_name AS project_name,  " 
                + " gcr.catg_color_id as region_catg_color_id,  "
                + " gw.wo_completed as wo_completed,  " 
                + " (SELECT COUNT(gnt.id) FROM glob_notification_track gnt  " 
                + " WHERE gnt.refid = calllog.id  "
                + " AND gnt.status = 'WAITING'  "
                + " AND gnt.module= 'qm'  "
                + " AND gnt.functionality = 'basic_dispatch'  "
                + " AND gnt.ntf_type = 'EMAIL') AS unanswcount,  "
                + " (SELECT COUNT(gnt.id) FROM glob_notification_track gnt WHERE gnt.refid = calllog.id  "
                + " AND gnt.status = 'ANSWERED' AND gnt.module= 'qm'  "
                + " AND gnt.functionality = 'basic_dispatch'  "
                + " AND gnt.ntf_type = 'EMAIL') AS answcount,  "
                + " (SELECT count(qst.id) FROM qa_sample_test qst WHERE gw.id = qst.workorder_id  " 
                + " AND qst.from_mobile = 'Y' AND qst.active = 'Y') AS submreport,  "
                + " gw.material_use_id,  " 
                + " calllog.status,  " 
                + " calllog.cancelled_reason ";
        String fromLine =  
                " FROM  "
                + " glob_dispatchcall_log calllog,  "
                + " glob_project gp,  "
                + " glob_client_regions gcr,  "
                + " glob_workorder gw,  " 
                + " glob_info ginfod,  " 
                + " glob_labs lab,  "
                + " glob_functions fn  " ;
        
         String whereLine = 
                " WHERE calllog.project_id = gp.id  "
                + " AND gp.region_id = gcr.id  "
                + " AND calllog.wo_id = gw.id  "
                + " AND calllog.info_id=ginfod.id  "
                + " AND ginfod.lab_id=lab.id  "
                + " AND ginfod.function_id=fn.id  "
                + " AND gp.active='Y'  "
                + " AND gw.active = 'Y'  "
                + " AND gw.cancelled IS NOT NULL  "
                + " AND gw.wo_no IS NOT NULL "
                + " AND gp.client_id = " + filters.clientId + " ";
        //System.err.println("******************* " +"SELECT " + fieldLine + fromLine + whereLine + tailLine ); 
        return "SELECT " + fieldLine + fromLine + whereLine + tailLine;
    }

    private String buildFilters(GlobSheduleSearchDefParam filters) {
        StringBuilder tailLineBuilder = new StringBuilder();
        // Filter Project Id
        if ((StringSupport.isNotNullAndNotEmpty(filters.projectId) && !filters.projectId.equals("-1"))) {
            tailLineBuilder.append(" AND (gw.project_id = ").append(filters.projectId).append(") ");
        }

        // Filter Region Id
        if ((StringSupport.isNotNullAndNotEmpty(filters.regionId) && !filters.regionId.equals("-1"))) {
            tailLineBuilder.append(" AND (gp.region_id = ").append(filters.regionId).append(") ");
        }

        // Filter Wo Cancelled
        if (filters.isEnableCancelWo == null || !filters.isEnableCancelWo) {
            tailLineBuilder.append(" AND (gw.cancelled = 'No') ");
        }

        // Filter Wo Completed
        if ((StringSupport.isNotNullAndNotEmpty(filters.isWoCompleted) && !filters.isWoCompleted.equals("-1"))) {
            tailLineBuilder.append(" AND (gw.wo_completed = '").append(filters.isWoCompleted).append("') ");
        }

        // Filter By Status
        if ((StringSupport.isNotNullAndNotEmpty(filters.reqStatus) && !filters.reqStatus.equals("-1"))) {
            tailLineBuilder.append(" AND (calllog.status = '").append(filters.reqStatus).append("') ");
        }

        // Filter Email Status
        if ((StringSupport.isNotNullAndNotEmpty(filters.trackEmailStatus) && !filters.trackEmailStatus.equals("-1"))) {
            switch (filters.trackEmailStatus) {
                case "accepted": {
                    tailLineBuilder.append(" AND calllog.id IN (SELECT gnt.refid FROM glob_notification_track gnt WHERE gnt.module= 'qm' AND gnt.functionality = 'basic_dispatch' AND gnt.ntf_type = 'EMAIL' AND gnt.status = 'ANSWERED' AND gnt.answer = 'Y' GROUP BY gnt.refid) ");
                    break;
                }
                case "rejected": {
                    tailLineBuilder.append(" AND calllog.id IN (SELECT gnt.refid FROM glob_notification_track gnt WHERE gnt.module= 'qm' AND gnt.functionality = 'basic_dispatch' AND gnt.ntf_type = 'EMAIL' AND gnt.status = 'ANSWERED' AND gnt.answer = 'N' GROUP BY gnt.refid) ");
                    break;
                }
                case "unanswered": {
                    tailLineBuilder.append(" AND calllog.id IN (SELECT gnt.refid FROM glob_notification_track gnt WHERE gnt.module= 'qm' AND gnt.functionality = 'basic_dispatch' AND gnt.ntf_type = 'EMAIL' AND gnt.status = 'WAITING' GROUP BY gnt.refid) ");
                    break;
                }
            }
        }

        // Filter by Services
        if ((StringSupport.isNotNullAndNotEmpty(filters.serviceList) && !filters.serviceList.equals("-1") && !filters.serviceList.equals("null"))) {
            tailLineBuilder.append(" AND calllog.id IN (SELECT gdcls.call_log_id FROM glob_dispatchcall_services gdcls INNER JOIN glob_services gserv ON (gdcls.type = gserv.id) WHERE gserv.service_name = 'Field' AND gdcls.service IS NOT NULL AND gdcls.service IN ( ").append(filters.serviceList).append(" )) ");
        }

        // Filter by Pending Reports
        if (filters.isEnablePendingWoReports != null && filters.isEnablePendingWoReports) {
            tailLineBuilder.append(" AND calllog.id NOT IN ( SELECT DISTINCT gdc.id FROM glob_dispatchcall_log gdc LEFT JOIN qa_sample_test qst ON (gdc.wo_id = qst.workorder_id) WHERE qst.active = 'Y' AND qst.from_mobile = 'Y') ");
        }

        // Filter Calendar
        if (StringSupport.isNotNullAndNotEmpty(filters.CurrentDate)) {
            switch (filters.CurrentView) {
                case "agenda": {
                    try {
                        String initDate = DateSupport.formatString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"), DateSupport.FORMAT_US_DASH);
                        String endDate = DateSupport.formatDate(DateSupport.addChronoUnitToDate(DateSupport.parseString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'")), ChronoUnit.DAYS, 7), DateSupport.FORMAT_US_DASH);
                        tailLineBuilder.append(" AND gw.service_date BETWEEN TO_DATE('").append(initDate).append("','mm-dd-yyyy') AND TO_DATE('").append(endDate).append("','mm-dd-yyyy') ");
                    } catch (ParseException ex) {
                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                    }
                    break;
                }
                case "month": {
                    try {
                        String initDate = DateSupport.formatDate(DateSupport.getFirstDayOfMonth(DateSupport.parseString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                        String endDate = DateSupport.formatDate(DateSupport.getLastDayOfMonth(DateSupport.parseString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                        tailLineBuilder.append(" AND gw.service_date BETWEEN TO_DATE('").append(initDate).append("','mm-dd-yyyy') AND TO_DATE('").append(endDate).append("','mm-dd-yyyy') ");
                    } catch (ParseException ex) {
                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                    }
                    break;
                }
                case "week": {
                    try {
                        String initDate = DateSupport.formatDate(DateSupport.getFirstDayOfWeek(DateSupport.parseString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                        String endDate = DateSupport.formatDate(DateSupport.getLastDayOfWeek(DateSupport.parseString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                        tailLineBuilder.append(" AND gw.service_date BETWEEN TO_DATE('").append(initDate).append("','mm-dd-yyyy') AND TO_DATE('").append(endDate).append("','mm-dd-yyyy') ");
                    } catch (ParseException ex) {
                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                    }
                    break;
                }
                case "day": {
                    try {
                        String initDate = DateSupport.formatString(filters.CurrentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"), DateSupport.FORMAT_US_DASH);
                        tailLineBuilder.append(" AND gw.service_date = TO_DATE('").append(initDate).append("','mm-dd-yyyy') ");
                    } catch (ParseException ex) {
                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                    }
                    break;
                }
            }
        }

        return tailLineBuilder.toString();
    }

    @Override
    public Boolean validateWoToken(String token) {
        String query = "SELECT (TRUNC((EXTRACT (DAY FROM (SYSTIMESTAMP - t.create_date)))) - 30) as DAYS FROM glob_workorder t WHERE t.wotoken = :token ";
        Query q = getEntityManager().createNativeQuery(query)
                .setParameter("token", token);
        try {
            BigDecimal days = NumberSupport.getBigDecimal(q.getSingleResult());
            if (days != null && days.intValue() <= 0) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (NoResultException | NonUniqueResultException ex) {
            return Boolean.FALSE;
        }
    }
}
