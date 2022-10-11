/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.dao.bpm.BpmRFIDao;
import com.atser.tools.atserejb.model.Bpmrfibo;
import com.atser.tools.atserejb.model.Bpmrfimetadata;
import com.atser.tools.atserejb.model.GlobContract;
import com.atser.tools.atserejb.model.GlobContractor;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobUserSignature;
import com.atser.tools.atserejb.service.glob.GlobContractService;
import com.atser.tools.atserejb.service.glob.GlobContractorService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobUserSignatureService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.BpmTaskInstance;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.jasper.bpm.BpmRfiPojo;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.chart.ChartColumnPointTO;
import com.atser.tools.atserutil.objects.to.chart.ChartColumnSeriesTO;
import com.atser.tools.atserutil.objects.to.jasper.bpm.BpmProcessReportTO;
import com.atser.tools.atserutil.objects.to.jasper.bpm.BpmTaskReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.thymeleaf.TemplateEngine;

@Stateless
public class BpmRFIServiceImpl implements BpmRFIService, IBaseEJBException {

    @Inject
    private BpmRFIDao dao;

    @Inject
    private BpmOperatorService bpmOperatorService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GlobContractService contractService;

    @Inject
    private GlobContractorService contractorService;

    @Inject
    private GlobUserSignatureService userSignService;

    @Inject
    private BpmProcessInstanceService processInstanceService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private BpmTaskInstanceService bpmTaskInstanceService;

    @Override
    public Bpmrfibo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public Bpmrfibo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public Bpmrfibo findByFolderId(String id) {
        return dao.findByFolderId(NumberSupport.getBigInteger(id));
    }

    @Override
    public BigInteger saveRevision(BigInteger parentId, BigInteger folderId, ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"rfinumber", "responseDueDate", "companyFrom", "personFrom", "created", "status", "requestorId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        Bpmrfibo elem = new Bpmrfibo();
        elem.setRfinumber(request.getParams().get("rfinumber").toString());
        elem.setFolderId(folderId);
        elem.setCreated(request.getParams().get("created").toString());
        elem.setResponseDueDate(request.getParams().get("responseDueDate").toString());
        elem.setCompanyFrom(request.getParams().get("companyFrom").toString());
        elem.setPersonFrom(request.getParams().get("personFrom").toString());
        elem.setStatus(request.getParams().get("status").toString());
        elem.setPersistenceversion(BigInteger.ZERO);
        elem.setRequestorid(NumberSupport.getBigInteger(request.getParams().get("requestorId").toString()));
        return dao.save(elem).getPersistenceid().toBigInteger();
    }

    @Override
    public BigInteger save(BigInteger folderId, ManageITBodyRequest request, Bpmrfimetadata metaId) {
        if (!request.getParams().isContainsAllKeys(new String[]{"rfinumber", "responseDueDate", "companyFrom", "personFrom", "created", "status", "requestorId", "prioritycode", "drwnumber"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        String nextStep = request.getParams().get("rfinumber").toString();
        Bpmrfibo elem = new Bpmrfibo();
        elem.setRfinumber(nextStep);
        elem.setFolderId(folderId);
        elem.setCreated(request.getParams().get("created").toString());
        elem.setResponseDueDate(request.getParams().get("responseDueDate").toString());
        elem.setCompanyFrom(request.getParams().get("companyFrom").toString());
        elem.setPersonFrom(request.getParams().get("personFrom").toString());
        elem.setStatus(request.getParams().get("status").toString());
        elem.setProjectId(request.getParams().get("projectId").toString());
        elem.setClientId(request.getParams().get("clientId").toString());
        elem.setContractId(request.getParams().get("contractId").toString());
        elem.setPersistenceversion(BigInteger.ZERO);
        elem.setRequestorid(NumberSupport.getBigInteger(request.getParams().get("requestorId").toString()));
        elem.setDcDataPid(metaId);
        elem.setPrioritycode(request.getParams().get("prioritycode").toString());
        elem.setCaseId(null);
        elem.setDrwnumber(request.getParams().get("drwnumber").toString());
        elem.setCanCreateRevision((short) 0);
        if (request.getParams().containsKey("revision")) {
            elem.setRfiname(request.getParams().get("name").toString());
            elem.setContractorNumber(request.getParams().get("contractorNumber").toString());
            String rev = nextStep.substring(nextStep.length() - 2, nextStep.length());
            // Modify canRevision
            Bpmrfibo temp = findById(request.getParams().get("persistenceId").toString());
            if (rev.equals("01")) {
                elem.setParentId(NumberSupport.getBigInteger(request.getParams().get("persistenceId").toString()));
            } else {
                elem.setParentId(temp.getParentId());
            }
            temp.setCanCreateRevision((short) 0);
            dao.save(temp);
        }
        return dao.save(elem).getPersistenceid().toBigInteger();
    }

    @Override
    public void update(Bpmrfibo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        update(null, null, elem, null, null);
    }

    // @Override
    public void update(ManageITHeader header, TemplateEngine engine, Bpmrfibo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (elem != null) {
            Bpmrfibo model = findById(elem.getPersistenceid());

            if (session != null && action != null && action.equals("btnCreate")) {
                Map<String, Serializable> instantiationInputs = new HashMap<>();
                HashMap<String, Long> values = new HashMap<>();
                values.put("persistenceId", elem.getPersistenceid().longValue());
                instantiationInputs.put("bpmPoolBOInput", values);
                Long caseId = bpmOperatorService.StartProcess(session, "RFI Process", model.getRequestorid().longValue(), instantiationInputs);
                if (caseId == -1) {
                    throwBaseException(Response.Status.SERVICE_UNAVAILABLE, "The process could't be created.");
                }
                model.setCaseId(BigInteger.valueOf(caseId));
            }

            model.setCompanyFrom(elem.getCompanyFrom());
            model.setContractorNumber(elem.getContractorNumber());
            model.setRfiname(elem.getRfiname());
            model.setQuestion(elem.getQuestion());
            model.setResponseDueDate(elem.getResponseDueDate());
            model.setStatus(elem.getStatus());
            model.setParentId(elem.getParentId());
            model.setDcDataPid(elem.getDcDataPid());
            model.setPrioritycode(elem.getPrioritycode());
            model.setDrwnumber(elem.getDrwnumber());

            model.setReferenceDocs(elem.getReferenceDocs());
            model.setIssue(elem.getIssue());
            model.setProposedSolution(elem.getProposedSolution());
            model.setCheckWorkImpact(elem.getCheckWorkImpact());
            model.setCheckScheduleImpact(elem.getCheckScheduleImpact());
            model.setCheckCostImpact(elem.getCheckCostImpact());

            model.setIsInitialReviewAccepted(elem.getIsInitialReviewAccepted());
            model.setIsInitialInformationAccepted(elem.getIsInitialInformationAccepted());
            model.setIsResponseAccepted(elem.getIsResponseAccepted());
            model.setIsNeededReviewEor(elem.getIsNeededReviewEor());
            model.setEmIds(elem.getEmIds());
            model.setReIds(elem.getReIds());
            model.setEorIds(elem.getEorIds());
            model.setStkhIds(elem.getStkhIds());
            model.setStkhGrpIds(elem.getStkhGrpIds());

            model.setRejectreason(elem.getRejectreason());
            model.setReply(elem.getReply());
            model.setFinaldisposition(elem.getFinaldisposition());

            dao.update(model);

            if (action != null && action.equals("btnCreate")) {
                processInstanceService.startProcess(header, engine, "BPM_RFI", elem.getPersistenceid(), new BigDecimal(elem.getProjectId()), new BigDecimal(elem.getClientId()));
            }
        }
    }

    @Override
    public void delete(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        if (!id.isEmpty()) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<Bpmrfibo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Boolean isDraft(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"subid"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String subid = request.getParams().get("subid").toString();
        if (!subid.isEmpty()) {
            Bpmrfibo obj = findById(subid);
            if (obj.getStatus().equals("Draft")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public BigInteger cancel(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        Bpmrfibo obj = findById(id);
        obj.setStatus("Canceled");
        dao.save(obj);
        return obj.getCaseId();
    }

    // @Override
    public void close(BigDecimal id) {
        Bpmrfibo obj = findById(id);
        obj.setCanCreateRevision((short) 1);
        obj.setDoneDate(DateSupport.getNowToFormat(DateSupport.PATTERN_US_DASH));
        obj.setStatus("Closed");
        dao.save(obj);
    }

    @Override
    public String generateTransmittal(BonitaBpmSupport session, String tplpath, String pdfpath, ManageITBodyRequest request) throws BonitaException {
        AtserLinkedHashMap<String, Object> params = request.getParams();
        String projectId = StringSupport.emptyOnNull(params.get("projectId"));
        String subnumber = StringSupport.emptyOnNull(params.get("rfinumber"));
        String finalRemark = StringSupport.emptyOnNull(params.get("finalReply"));
        String finalStatus = StringSupport.emptyOnNull(params.get("finalStatus"));
        String userId = StringSupport.emptyOnNull(params.get("userId"));
        String contractId = StringSupport.emptyOnNull(params.get("contractId"));
        String description = StringSupport.emptyOnNull(params.get("subdescription"));

        Map<String, Object> paramsJasper = new HashMap<>();
        GlobProject project = projectService.findById(projectId);
        GlobContract contract = contractService.findById(contractId);
        GlobContractor contractor = contractorService.findById(contract.getContractorId().toString());
        String customUserId = session.getCustomInformationFromUserId(Long.valueOf(userId), "userId");
        GlobUserSignature usersign = userSignService.findByUserId(customUserId);

        if (Objects.nonNull(project) && Objects.nonNull(contractor) && Objects.nonNull(usersign)) {
            paramsJasper.put("sbprojectNo", project.getPNumber());
            paramsJasper.put("sbprojectname", project.getPName());
            paramsJasper.put("sbcontractor", contractor.getName());
            paramsJasper.put("sbnumber", subnumber);
            paramsJasper.put("sbdate", DateSupport.getNowToFormat("MM/dd/YYYY"));
            paramsJasper.put("sbreply", finalRemark);
            paramsJasper.put("sbstatus", finalStatus);
            paramsJasper.put("sbdescription", description);
            try {
                paramsJasper.put("sbsign", ImageSupport.makeImageTransparence(ImageSupport.convertByteArrayToBufferedImage(usersign.getImageData())));
            } catch (IOException ex) {
                paramsJasper.put("sbsign", null);
                Logger.getLogger(BpmSubmittalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            BuildJasper pdf = new BuildJasper();
            try {
                return pdf.exportDocument(tplpath, paramsJasper, pdfpath, "pdf");
            } catch (Exception ex) {
                Logger.getLogger(BpmSubmittalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return null;
    }

    // -------------------------------------------------------------------------
    @Override
    public DataTableWrapper<Bpmrfibo> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<Bpmrfibo> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public List<ChartColumnSeriesTO> getChartDataByStatus(BigDecimal clientId) {
        List<ChartColumnSeriesTO> chartSerieList = new ArrayList<>();

        // Find [Draft] RFIs
        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("clientId", clientId);
        search.filter("status", "Draft");
        List<Bpmrfibo> draftList = list(search);
        ChartColumnSeriesTO serie = new ChartColumnSeriesTO("Draft", new ChartColumnPointTO("Draft", draftList.isEmpty() ? "0" : String.valueOf(draftList.size())));
        chartSerieList.add(serie);

        // Find [Closed] RFIs
        search = new ManageITBodyRequest(0, 0);
        search.filter("clientId", clientId);
        search.filter("status", "In Review");
        List<Bpmrfibo> closedList = list(search);
        serie = new ChartColumnSeriesTO("Draft", new ChartColumnPointTO("Draft", draftList.isEmpty() ? "0" : String.valueOf(closedList.size())));

        // Find [In Review] RFIs
        search = new ManageITBodyRequest(0, 0);
        search.filter("clientId", clientId);
        search.filter("status", "Closed");
        List<Bpmrfibo> onRevisionList = list(search);
        serie = new ChartColumnSeriesTO("Draft", new ChartColumnPointTO("Draft", draftList.isEmpty() ? "0" : String.valueOf(onRevisionList.size())));

        return chartSerieList;
    }

    /**
     * Generate Report
     *
     * @param reportId
     * @param funcId
     * @param tplbasePath
     * @param docpathsegment
     * @param docType
     * @param header
     * @param request
     * @return
     */
    @Override
    public String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(reportId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), funcId, reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);

            BufferedImage clientLogoImage = genericHelperService.getClientLogo(header.getClientid());
            paramsJasper.put("CLIENT_LOGO", clientLogoImage);

            if (request.getParams() != null && StringSupport.isNotNullAndNotEmpty(request.getParams().get("projectId"))) {
                GlobProject project = projectService.findById(request.getParams().get("projectId").toString());
                paramsJasper.put("PROJECT_NAME", project.getPName());
                paramsJasper.put("PROJECT_NUMBER", project.getPNumber());
            }
            return buildReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper, funcId);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Database Configuration for this Report.");
        }
        return null;
    }

    /**
     * Build Generic Report
     *
     * @param tplbasePath
     * @param tplpath
     * @param docpathsegment
     * @param docType
     * @param request
     * @param paramsJasper
     * @param funcId
     * @return
     */
    private String buildReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<BpmRfiPojo> pResult = generateReportData(request);
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private List<BpmRfiPojo> generateReportData(ManageITBodyRequest request) {
        // Load process list.
        List<Bpmrfibo> rfiList = list(request);

        List<BpmRfiPojo> list = new ArrayList<>();
        for (Bpmrfibo rfi : rfiList) {
            BpmRfiPojo pojo = new BpmRfiPojo();

            pojo.setNumber(rfi.getRfinumber());
            pojo.setRevision(rfi.getDcDataPid().getRevision());
            pojo.setTitle(rfi.getRfiname());
            pojo.setPriority(rfi.getPrioritycode());
            pojo.setStatus(rfi.getStatus());
            pojo.setFinalDisposition(rfi.getFinaldisposition());

            // Dates
            pojo.setCreatedDate(rfi.getCreated());
            pojo.setResponseRequiredDate(rfi.getResponseDueDate());
            pojo.setCompletedDate(rfi.getDoneDate());

            // Impact
            pojo.setImpact("");
            if (rfi.getCheckWorkImpact() != null && "Y".equals(rfi.getCheckWorkImpact().toString())) {
                pojo.setImpact("Work");
            }
            if (rfi.getCheckScheduleImpact() != null && "Y".equals(rfi.getCheckScheduleImpact().toString())) {
                pojo.setImpact(pojo.getImpact().isEmpty() ? "Schedule" : ", Schedule");
            }
            if (rfi.getCheckCostImpact() != null && "Y".equals(rfi.getCheckCostImpact().toString())) {
                pojo.setImpact(pojo.getImpact().isEmpty() ? "Cost" : ", Cost");
            }

            // Current Task, Responsable, Date
            ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
            search.filter("refId", rfi.getPersistenceid());
            search.filter("taskId.processId.code", "BPM_RFI");
            List<BpmTaskInstance> taskInstanceList = bpmTaskInstanceService.list(search);
            if (!taskInstanceList.isEmpty()) {
                BpmTaskInstance taskInstance = taskInstanceList.get(taskInstanceList.size() - 1);
                pojo.setCurrentTask(taskInstance.getTaskId().getName());
                pojo.setReceivedDate(DateSupport.formatDate(taskInstance.getCreated(), DateSupport.FORMAT_US));

                if (!"Closed".equals(rfi.getStatus())) {
                    if (taskInstance.getUserId() != null) {
                        pojo.setCurrentResponsable(taskInstance.getUserId().getContactid().getFullName());
                    } else {
                        pojo.setCurrentResponsable(taskInstance.getTaskId().getActorId().getShortdesc());
                    }
                }
            }
            list.add(pojo);
        }
        return list;
    }

    private String buildGenericReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<BpmProcessReportTO> pResult = generateReportData2();
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<BpmProcessReportTO> generateReportData2() {
        // Load correspondence process list.
        List<Bpmrfibo> rfiList = dao.findAll();

        List<BpmProcessReportTO> rProcessToList = new ArrayList<>();
        for (Bpmrfibo rfi : rfiList) {
            BpmProcessReportTO rProcessTo = new BpmProcessReportTO();
            rProcessTo.setNumber(rfi.getRfinumber());
            rProcessTo.setSubject(rfi.getRfiname());
            rProcessTo.setRevision(rfi.getDcDataPid().getRevision());

            // Load correspondence process task list.
            ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
            search.filter("refId", rfi.getPersistenceid());
            List<BpmTaskInstance> taskList = bpmTaskInstanceService.list(search);

            if (!taskList.isEmpty()) {
                rProcessTo.setTasks(new ArrayList<>());
                for (BpmTaskInstance task : taskList) {
                    BpmTaskReportTO taskTO = new BpmTaskReportTO();
                    taskTO.setActions(task.getTaskId().getName());
                    if (task.getUserId() != null) {
                        taskTO.setResponsability(task.getUserId().getContactid().getFullName());
                    }
                    taskTO.setCreationDate(task.getCreated());
                    taskTO.setActionStatus(task.getState());
                    // item.setResolvedTargetDate();
                    // item.setReslvedActualDate();
                    // item.setActionStatusNotes();
                    rProcessTo.getTasks().add(taskTO);
                }
            }
            rProcessToList.add(rProcessTo);
        }

        return rProcessToList;
    }

    @Override
    public Map<String, Integer> getTotalByStatus(BigDecimal clientId, BigDecimal projectId) {
        Map<String, Integer> result = new HashMap<>();
        List<Bpmrfibo> process;

        ManageITBodyRequest search = new ManageITBodyRequest(0, 0);
        search.filter("clientId", clientId);
        search.filter("projectId", projectId);

        // Find [Draft] Submittals
        process = list(search.filter("status", "Draft"));
        result.put("Draft", process.isEmpty() ? 0 : process.size());

        // Find [Closed] Submittals
        search.getFilter().remove(2);
        process = list(search.filter("status", "In Review"));
        result.put("In Review", process.isEmpty() ? 0 : process.size());

        // Find [In Review] Submittals
        search.getFilter().remove(2);
        process = list(search.filter("status", "Closed"));
        result.put("Closed", process.isEmpty() ? 0 : process.size());

        return result;
    }
    // -------------------------------------------------------------------------
}
