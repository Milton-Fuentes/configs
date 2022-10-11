/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpminspectordispatchbo;
import com.atser.tools.atserejb.service.cm.CmContractActivityService;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobServicesFieldService;
import com.atser.tools.atserejb.service.glob.GlobServicesLabService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.glob.GlobUserSignatureService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.dispatch.InspWorkOrderTO;
import com.atser.tools.atserutil.objects.to.reports.IReportSyncfusion;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.mail.Session;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.identity.ContactData;
import org.thymeleaf.TemplateEngine;
import com.atser.tools.atserejb.dao.bpm.BpmInspectorDispatchDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobInspworkorder;
import com.atser.tools.atserejb.model.GlobInspworkorderServices;
import com.atser.tools.atserejb.model.GlobNotificationTrack;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobServicesLab;
import com.atser.tools.atserejb.model.GlobUserSignature;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.cm.CmDailyLocationService;
import com.atser.tools.atserejb.service.glob.GlobInspworkorderService;
import com.atser.tools.atserejb.service.glob.GlobInspworkorderServicesService;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eServiceType;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.objects.pojo.jasper.InspDispatchPrintWOPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.InspDispatchWOPojo;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.EngServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.FieldServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.LabServiceTO;
import com.atser.tools.atserutil.objects.to.reports.ReportColumsTO;
import com.atser.tools.atserutil.objects.to.reports.ReportPieDoughnutTO;
import com.atser.tools.atserutil.objects.to.reports.ReportPointsTO;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.thymeleaf.context.Context;

/**
 * BPM Inspector Dispatch Implementation
 *
 * @author droldan
 */
@Stateless
public class BpmInspectorDispatchServiceImpl implements BpmInspectorDispatchService, IBaseEJBException {

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private BpmInspectorDispatchDao dao;

    @Inject
    private GlobInspworkorderService inspWoService;

    @Inject
    private GlobInspworkorderServicesService inspWoServiceServices;

    @Inject
    private BpmOperatorService bpmOperatorService;

    @Inject
    GlobUserService userService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GlobUserSignatureService userSignService;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobServicesLabService labService;

    @Inject
    private GlobServicesFieldService fieldService;

    @Inject
    private GlobContactService contactService;

    @Inject
    private GlobFileService fileService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private CmContractActivityService cmContractActivity;

    @Inject
    private CmDailyLocationService cmDailyLocationService;

    /**
     * Find by Id
     *
     * @param id
     * @return Bpminspectordispatchbo
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Bpminspectordispatchbo findById(String id) {
        return findById(id, null);
    }

    /**
     * Find by Id
     *
     * @param id
     * @param session
     * @return Bpminspectordispatchbo
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Bpminspectordispatchbo findById(String id, BonitaBpmSupport session) {
        Bpminspectordispatchbo response = dao.findById(NumberSupport.getBigDecimal(id));
        if (session == null) {
            return response;
        }

        if (response.getEmailToNotify() == null || response.getEmailToNotify().isEmpty()) {
            try {
                ContactData proUser = session.getProfessionalDataById(response.getRequestorId().longValue());
                response.setEmailToNotify(proUser.getEmail());
            } catch (BonitaException ex) {
                Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return response;
    }

    /**
     * Find by Id
     *
     * @param id
     * @return Bpminspectordispatchbo
     */
    @Override
    public Bpminspectordispatchbo findById(BigDecimal id) {
        return dao.findById(id);
    }

    /**
     * Find by Folder Id
     *
     * @param id
     * @return Bpminspectordispatchbo
     */
    @Override
    public Bpminspectordispatchbo findByFolderId(String id) {
        return dao.findByFolderId(NumberSupport.getBigInteger(id));
    }

    /**
     * Save
     *
     * @param folderId
     * @param request
     * @return BigInteger[] {0-> ParentID, 1-> PersistenceId}
     */
    @Override
    public BigInteger[] save(BigInteger folderId, ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"requestnumber"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        BigInteger[] rArray = new BigInteger[2];

        String nextStep = request.getParams().get("requestnumber").toString();
        Bpminspectordispatchbo elem = new Bpminspectordispatchbo();
        elem.setActivityId(request.getParams().get("activityId") == null ? "-1" : request.getParams().get("activityId").toString());
        elem.setCancreaterevision((short) 0);
        elem.setCaseId(null);
        elem.setClientId(request.getParams().get("clientId").toString());
        elem.setContractId(request.getParams().get("contractId").toString());
        elem.setCreated(request.getParams().get("created").toString());
        elem.setFolderId(folderId);
        elem.setPersistenceversion(BigInteger.ZERO);
        elem.setProjectId(request.getParams().get("projectId").toString());
        elem.setRequestServicedate(request.getParams().get("requestServicedate").toString());
        elem.setRequestSource(request.getParams().get("reqSource").toString());
        elem.setRequestnumber(nextStep);
        elem.setRequestorId(NumberSupport.getBigInteger(request.getParams().get("requestorId").toString()));
        elem.setStatus(request.getParams().get("status").toString());

        if (request.getParams().containsKey("revision")) {
            elem.setRequestName(request.getParams().get("title").toString());
            elem.setRequestDescription(request.getParams().get("description").toString());
            String rev = nextStep.substring(nextStep.length() - 2, nextStep.length());
            // Modify canRevision
            Bpminspectordispatchbo temp = findById(request.getParams().get("persistenceId").toString());
            if (rev.equals("01")) {
                elem.setParentId(NumberSupport.getBigInteger(request.getParams().get("persistenceId").toString()));
                rArray[0] = NumberSupport.getBigInteger(request.getParams().get("persistenceId").toString());
            } else {
                elem.setParentId(temp.getParentId());
                rArray[0] = temp.getParentId();
            }
            temp.setCancreaterevision((short) 0);
        }

        rArray[1] = dao.save(elem).getPersistenceid().toBigInteger();
        return rArray;
    }

    /**
     * Update Data (Bpminspectordispatchbo)
     *
     * @param elem
     */
    @Override
    public void updateData(Bpminspectordispatchbo elem) {
        if (elem != null) {
            dao.update(elem);
        }
    }

    /**
     * Update Data (Bpminspectordispatchbo)
     *
     * @param elem
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    @Override
    public void update(Bpminspectordispatchbo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (elem != null) {
            update(elem, null, null);
        }
    }

    /**
     * Update Data (Bpminspectordispatchbo)
     *
     * @param elem
     * @param action
     * @param session
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    @Override
    public void update(Bpminspectordispatchbo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (elem != null) {
            Bpminspectordispatchbo model = findById(elem.getPersistenceid());

            if (session != null) {
                Long caseId;
                if (action != null && action.equals("btnCreate")) {
                    caseId = startBPMProcess(elem.getPersistenceid().longValue(), "bpmPoolBOInput", "Inspector Dispatch Process", model.getRequestorId().longValue(), session);
                    model.setCaseId(BigInteger.valueOf(caseId));
                }
            }

            model.setRequestName(elem.getRequestName());
            model.setRequestDescription(elem.getRequestDescription());
            model.setRequestServicedate(elem.getRequestServicedate());
            model.setRequestedBy(elem.getRequestedBy());
            model.setStatus(elem.getStatus());
            model.setParentId(elem.getParentId());
            model.setRequestSource(elem.getRequestSource());
            model.setActivityId((elem.getActivityId() == null || elem.getActivityId().isEmpty() || elem.getActivityId().toLowerCase().equals("n/a")) ? "-1" : elem.getActivityId());
            model.setIsrollback((short) 0);
            model.setEmailToNotify(elem.getEmailToNotify());
            model.setClientId(elem.getClientId());
            model.setProjectId(elem.getProjectId());
            model.setRequestLocation(elem.getRequestLocation());
            model.setRestorepoint("");
            dao.update(model);
        }
    }

    /**
     * Start BPM Process
     *
     * @param persistenceId
     * @param contractName
     * @param processName
     * @param requestorId
     * @param session
     * @return Long (CaseId)
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    private Long startBPMProcess(Long persistenceId, String contractName, String processName, Long requestorId, BonitaBpmSupport session) throws ProcessExecutionException, ContractViolationException, BonitaException {
        Map<String, Serializable> instantiationInputs = new HashMap<>();
        HashMap<String, Long> values = new HashMap<>();
        values.put("persistenceId", persistenceId);
        instantiationInputs.put(contractName, values);
        Long caseId = bpmOperatorService.StartProcess(session, processName, requestorId, instantiationInputs);
        if (caseId == -1) {
            throwBaseException(Response.Status.SERVICE_UNAVAILABLE, "The process could't be created.");
        }
        return caseId;
    }

    /**
     * Delete
     *
     * @param request
     */
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
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<Bpminspectordispatchbo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<Bpminspectordispatchbo> finalList = list(request, session);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    /**
     * List Dispatch Rows
     *
     * @param request
     * @param session
     * @return List<Bpmdispatchbo>
     * @throws BonitaException
     */
    @Override
    public List<Bpminspectordispatchbo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        List<Bpminspectordispatchbo> returnList;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            returnList = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            returnList = dao.findAll();
        }

        if (returnList != null && !returnList.isEmpty()) {
            for (int i = 0; i < returnList.size(); i++) {
                String decision = checkIfIsPossibleCancelRequest(returnList.get(i), session);
                returnList.get(i).setCanbeCancelled(decision);
            }
        }

        return returnList;
    }

    /**
     * Is the request in Draft?
     *
     * @param request
     * @return Boolean
     */
    @Override
    public Boolean isDraft(ManageITBodyRequest request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"subid"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String subid = request.getParams().get("subid").toString();
        if (!subid.isEmpty()) {
            Bpminspectordispatchbo obj = findById(subid);
            if (obj.getStatus().equals("Draft")) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /**
     * Check If is Possible Cancel the Request
     *
     * @param item
     * @param session
     * @return String (wo -> false, null -> true)
     * @throws BonitaException
     */
    private String checkIfIsPossibleCancelRequest(Bpminspectordispatchbo item, BonitaBpmSupport session) throws BonitaException {
        if (item != null && item.getCaseId() != null && session != null) {
            if (session.isHumanTaskAlreadyAssigned("ready", item.getCaseId().longValue())) {
                return "assigned";
            }

            int size = item.getGlobInspworkorderList().size();

            if (size > 0) {
                return "wo";
            }
        }
        return null;
    }

    /**
     * Reassign Inspector
     *
     * @param request
     * @param session
     * @return
     */
    @Override
    public Boolean reAssignInspector(ManageITBodyRequest<Bpminspectordispatchbo> request, BonitaBpmSupport session) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        Bpminspectordispatchbo obj = findById(id);
        try {
            List<GlobNotificationTrack> listNtf = ntfTrackService.findAllByRefIdAndStatus("inspectordispatch", id, "WAITING");

            listNtf.forEach((ntf) -> {
                ntf.setUniqueToken("-1");
                ntf.setStatus("CANCELLED");
                ntf.setAnswer(null);
                ntfTrackService.update(ntf);
            });

            List<GlobInspworkorder> listdCallLog = obj.getGlobInspworkorderList();
            listdCallLog.forEach((dcl) -> {
                if (dcl.getDecisionflag().longValue() != 1L) {
                    dcl.setDecisionflag(new BigInteger("3"));
                    inspWoService.updateDecisionFlag(dcl);
                }
            });

            obj.setInternalstatus("Inspector Cancellation in Progress");
            dao.save(obj);

        } catch (Exception ex) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    /**
     * Cancel Request
     *
     * @param request
     * @param session
     * @return
     * @throws BonitaException
     */
    @Override
    public BigInteger cancelRequest(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        Bpminspectordispatchbo obj = findById(id);

        String decision = checkIfIsPossibleCancelRequest(obj, session);

        if (decision != null && decision.equals("assigned")) {
            throwBaseException(Response.Status.CONFLICT, "assigned");
            return BigInteger.ZERO;
        }

        if (decision != null && decision.equals("wo")) {
            throwBaseException(Response.Status.CONFLICT, "wo");
            return BigInteger.ZERO;
        }

        obj.setStatus("Closed");
        obj.setInternalstatus("REQUEST CANCELLED");
        obj.setFinaldisposition("REQUEST CANCELLED");
        obj.setIscancel((short) 1);
        obj.setDoneDate(DateSupport.getNowToFormat("MM-dd-yyyy"));
        dao.save(obj);
        bpmOperatorService.CancelProcessInstance(session, obj.getCaseId().longValue());
        return obj.getCaseId();
    }

    /**
     * Generate Transmittal
     *
     * @param session
     * @param tplpath
     * @param pdfpathsegment
     * @param request
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    @Override
    public void generateTransmittal(BonitaBpmSupport session, String tplpath, String pdfpathsegment, ManageITBodyRequest request) throws IOException, BonitaException, Exception {
        AtserLinkedHashMap<String, Object> params = request.getParams();
        Map<String, Object> paramsJasper = new HashMap<>();
        String persistenceId = params.get("persistenceId").toString();
        if (persistenceId == null || persistenceId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        Bpminspectordispatchbo dbo = findById(persistenceId);
        if (Objects.nonNull(dbo)) {
            String targetPath = null;
            String finalDisposition;
            String finalRemark;
            String projectId = StringSupport.emptyOnNull(dbo.getProjectId());
            String clientId = StringSupport.emptyOnNull(dbo.getClientId());
            String contractId = StringSupport.emptyOnNull(dbo.getContractId());
            String pdfpatharea = pdfpathsegment + clientId + "/" + projectId + "/" + contractId + "/";
            Map<String, Object> metaDataFile = FileSupport.getMetaDataServerFilename("Transmittal_Letter_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "_" + dbo.getPersistenceversion().toString() + ".pdf", pdfpatharea);
            String reqNumber = StringSupport.emptyOnNull(dbo.getRequestnumber());
            if (dbo.getStatus().equals("Rejected")) {
                finalDisposition = "DISPATCH REJECTED - SEE REMARKS";
                finalRemark = StringSupport.emptyOnNull(dbo.getRejectreason());
            } else {
                finalDisposition = StringSupport.emptyOnNull(dbo.getFinaldisposition());
                finalRemark = StringSupport.emptyOnNull(dbo.getFinalremark());
            }

            Boolean isCancel = (dbo.getIscancel() == 0) ? Boolean.FALSE : Boolean.TRUE;
            String decisionId = StringSupport.emptyOnNull(dbo.getDecisionid());
            String customDecisionUserId = session.getCustomInformationFromUserId(Long.valueOf(decisionId), "userId");
            String customRequestorId = session.getCustomInformationFromUserId(dbo.getRequestorId().longValue(), "userId");
            String RequestorUserName = getUserNameByRequestorId(dbo.getRequestorId(), session);
            GlobProject project = projectService.findById(projectId);
            GlobUserSignature usersign = userSignService.findByUserId(customDecisionUserId);

            if (Objects.nonNull(project)) {
                paramsJasper.put("pReqNumber", reqNumber);
                paramsJasper.put("pProjectNo", project.getPNumber());
                paramsJasper.put("pProjectName", project.getPName());
                paramsJasper.put("pCompleteDate", DateSupport.getNowToFormat("MM/dd/YYYY"));
                paramsJasper.put("pRemarks", finalRemark);
                paramsJasper.put("pFinalDisposition", finalDisposition);
                paramsJasper.put("isCancel", isCancel);
                if (Objects.nonNull(usersign)) {
                    try {
                        paramsJasper.put("pSign", ImageSupport.makeImageTransparence(ImageSupport.convertByteArrayToBufferedImage(usersign.getImageData())));
                    } catch (IOException ex) {
                        paramsJasper.put("pSign", null);
                        Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                List<InspDispatchWOPojo> dwo = new ArrayList<>();

                List<GlobInspworkorder> reqLogList = dbo.getGlobInspworkorderList();

                reqLogList.forEach((wo) -> {
                    if (wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("no")) {
                        GlobContact techcontact = contactService.findById(wo.getInspRefid().toString());
                        String techPhone = techcontact.getPhone();
                        String techCell = techcontact.getCell();
                        String inspContactNumber;
                        if (techCell != null && !techCell.isEmpty()) {
                            inspContactNumber = techCell;
                        } else if (techPhone != null && !techPhone.isEmpty()) {
                            inspContactNumber = techPhone;
                        } else {
                            inspContactNumber = "281-999-9961";
                        }

                        dwo.add(new InspDispatchWOPojo(wo.getWonumber(), wo.getServicesRequested(), DateSupport.formatDate(wo.getServiceDate(), DateSupport.FORMAT_US), wo.getTimeatsite(), wo.getInspector(), inspContactNumber));
                    }
                });

                paramsJasper.put("listWo", dwo);

                BuildJasper pdf = new BuildJasper();
                try {
                    targetPath = pdf.exportDocument(tplpath, paramsJasper, StringSupport.emptyOnNull(metaDataFile.get("filename")), "pdf");
                } catch (Exception ex) {
                    Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                metaDataFile = FileSupport.getFileMetaData(targetPath, metaDataFile);
                params.put("clientId", clientId);
                params.put("projectId", projectId);
                params.put("contractId", contractId);
                params.put("folderId", dbo.getFolderId().toString());
                params.put("from", RequestorUserName);
                params.put("userId", customRequestorId);
                fileService.saveFileToDb(metaDataFile, params, "Inspector Dispatch");
            }
        }
    }

    /**
     * Get UserName By RequestorId
     *
     * @param id
     * @param session
     * @return
     * @throws BonitaException
     */
    private String getUserNameByRequestorId(BigInteger id, BonitaBpmSupport session) throws BonitaException {
        String customUserId = session.getCustomInformationFromUserId(id.longValue(), "userId");
        GlobUsers user = userService.findById(customUserId);
        if (user != null) {
            return user.getUserid();
        }
        return null;
    }

    /**
     * Create Rollback
     *
     * @param request
     * @param session
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    @Override
    public void createRollback(ManageITBodyRequest request, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (!request.getParams().isContainsAllKeys(new String[]{"id", "restorePoint"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        String action = request.getParams().get("submitOrig").toString();
        String restorePoint = request.getParams().get("restorePoint").toString();
        Bpminspectordispatchbo obj = findById(id);
        obj.setIsrollback((short) 1);
        obj.setRestorepoint(restorePoint);
        dao.save(obj);

        Bpminspectordispatchbo model = findById(id);
        if (session != null) {
            Long caseId;
            if (action != null && action.equals("btnRollBack")) {
                caseId = startBPMProcess(model.getPersistenceid().longValue(), "bpmPoolBOInput", "Inspector Dispatch Process", model.getRequestorId().longValue(), session);
                model.setCaseId(BigInteger.valueOf(caseId));
                model.setStatus("In Progress");
                model.setCancreaterevision((short) 0);
                model.setFinaldisposition("");
                model.setFinalremark("");
            }
        }

        dao.save(model);
    }

    /**
     * Init lazy list
     *
     * @param lazyList
     */
    private void initializeList(List<?> lazyList) {
        if (lazyList == null) {
            return;
        }
        lazyList.size();
    }

    /**
     * Find Request Log By Id
     *
     * @param logId
     * @return WorkOrderTO
     */
    @Override
    public InspWorkOrderTO findRequestLogById(String logId) {
        GlobInspworkorder wo = inspWoService.findById(logId);
        if (wo != null) {
            List<GlobInspworkorderServices> servList = inspWoServiceServices.findByWOId(wo.getId().toBigInteger());
            try {
                return toInspWorkOrderTO(wo, servList);
            } catch (ParseException ex) {
                Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    /**
     * WO List
     *
     * @param id
     * @return List<WorkOrderTO>
     */
    @Override
    public List<InspWorkOrderTO> wolist(String id) {
        List<InspWorkOrderTO> woList = new ArrayList<>();
        List<GlobInspworkorder> listdWO = inspWoService.findByInspDispatchID(NumberSupport.getBigDecimal(id));
        listdWO.forEach((wo) -> {
            List<GlobInspworkorderServices> servList = inspWoServiceServices.findByWOId(wo.getId().toBigInteger());
            try {
                woList.add(toInspWorkOrderTO(wo, servList));
            } catch (ParseException ex) {
                Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return woList;
    }

    /**
     * Update Request Log Hours
     *
     * @param request
     */
    @Override
    public void updateRequestLogHours(ManageITBodyRequest request) throws ParseException {
        InspWorkOrderTO wo = (InspWorkOrderTO) request.getData();
        if (wo != null) {
            GlobInspworkorder woobj = inspWoService.findById(wo.getWoId().toString());
            if (woobj != null) {
                woobj.setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_US_DASH));
                woobj.setTimeatoffice(wo.getTimeatoffice());
                woobj.setTimeatsite(wo.getTimeatsite());
                woobj.setHours(wo.getHours());
                woobj.setAssignment(wo.getAssigment());
                woobj.setPaperworkReceived(wo.getPaperworkReceived() == null ? 'N' : wo.getPaperworkReceived().charAt(0));
                woobj.setSpecInstr(wo.getSpecialinstruction());
                inspWoService.update(woobj);
            }
        }
    }

    /**
     * Manage Request Log
     *
     * @param request
     * @param session
     * @param headerUser
     * @throws BonitaException
     */
    @Override
    public void manageRequestLog(ManageITRequest<List<InspWorkOrderTO>> request, BonitaBpmSupport session, String headerUser) throws BonitaException {
        if (!request.getBody().getParams().isContainsAllKeys(new String[]{"dispatchid"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String dispatchid = request.getBody().getParams().get("dispatchid").toString();
        List<InspWorkOrderTO> woList = (List<InspWorkOrderTO>) request.getBody().getData();
        if (dispatchid == null || dispatchid.isEmpty() || woList.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        Bpminspectordispatchbo dbo = findById(dispatchid);
        String createBy = getUserNameByRequestorId(dbo.getRequestorId(), session);
        BigInteger woId = null;
        try {
            for (InspWorkOrderTO woIt : woList) {
                if (woIt.getWoId() != null && woIt.getWoId().longValue() == 0) {
                    woId = inspWoService.save(toInspGlobWorkorder(dbo, woIt, createBy, headerUser, request.getHeader().getModIp(), "insert"));
                } else if (woIt.getWoId() != null && woIt.getWoId().longValue() > 0) {
                    GlobInspworkorder woDb = toInspGlobWorkorder(dbo, woIt, createBy, headerUser, request.getHeader().getModIp(), "update");
                    inspWoService.update(woDb);
                    woId = woDb.getId().toBigInteger();
                }
                if (inspWoServiceServices.getCountWORecords(woId) > 0) {
                    inspWoServiceServices.deleteAllByWOId(woId);
                }
                List<GlobInspworkorderServices> lserv = toGlobInspWoServices(woIt, headerUser, woId);
                inspWoServiceServices.saveAll(lserv);
            }
        } catch (ParseException ex) {
            Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Convert to InspWorkOrderTO
     *
     * @param wo
     * @param servList
     * @return WorkOrderTO
     * @throws ParseException
     */
    private InspWorkOrderTO toInspWorkOrderTO(GlobInspworkorder wo, List<GlobInspworkorderServices> servList) throws ParseException {
        InspWorkOrderTO woTo = new InspWorkOrderTO();
        woTo.setWoId(wo.getId().toBigInteger());
        woTo.setWonumber(wo.getWonumber());
        woTo.setServiceDate(DateSupport.formatDate(wo.getServiceDate(), DateSupport.FORMAT_REVERSE_MD));
        woTo.setInspectorFullName(wo.getInspector());
        woTo.setTimeatoffice(DateSupport.formatString(wo.getTimeatoffice(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
        woTo.setTimeatsite(DateSupport.formatString(wo.getTimeatsite(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
        woTo.setHours(wo.getHours());
        woTo.setContactrefId(wo.getContactrefid());
        woTo.setContactperson(wo.getContactPerson());
        woTo.setContacttelephone(wo.getContactTelephone());
        woTo.setSpecialinstruction(wo.getSpecInstr());
        woTo.setPaperworkReceived(String.valueOf(wo.getPaperworkReceived()));
        woTo.setAssigment(wo.getAssignment());
        woTo.setIscancel(wo.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
        woTo.setInspRefId(wo.getInspRefid());
        woTo.setInspFuncId(wo.getInspectionFuncid());
        woTo.setDecisionFlag(wo.getDecisionflag());

        servList.forEach((svList) -> {
            if (svList.getType().equals(eServiceType.eEng.getValue())) {
                woTo.addEngService(new EngServiceTO(svList.getServiceDescription()));
            } else if (svList.getType().equals(eServiceType.eField.getValue())) {
                woTo.addFieldService(new FieldServiceTO(NumberSupport.getBigInteger(svList.getService())));
            } else if (svList.getType().equals(eServiceType.eLab.getValue())) {
                GlobServicesLab lbsrv = labService.findById(svList.getService());
                woTo.addLabService(new LabServiceTO(NumberSupport.getBigInteger(svList.getService()), lbsrv.getLabCategoryId()));
            }
            woTo.setServiceList(wo.getServicesRequested());
        });
        woTo.setTraceDescription(cmContractActivity.getActivityName(wo.getActivityId(), "n"));
        woTo.setRlocation(cmDailyLocationService.getDailyLocation(wo.getInspdispatchid().getRequestLocation()));

        return woTo;
    }

    /**
     * get Project Manager Name
     *
     * @param pmId
     * @return ProjectManagerName as String
     */
    private String getProjectManagerName(String pmId) {
        String pm = "N/A";

        if (pmId != null) {
            GlobContact projectManager = contactService.findById(pmId);
            pm = projectManager.getFullName();
        }
        return pm;
    }

    /**
     * Convert to GlobWorkorder
     *
     * @param dbo
     * @param wo
     * @param headerUser
     * @param action
     * @return GlobWorkorder
     * @throws ParseException
     */
    private GlobInspworkorder toInspGlobWorkorder(Bpminspectordispatchbo dbo, InspWorkOrderTO wo, String createBy, String headerUser, String ip, String action) throws ParseException {
        GlobInspworkorder rp = new GlobInspworkorder();
        BigInteger projectId = NumberSupport.getBigInteger(dbo.getProjectId());
        String won;

        if (action.equals("insert")) {
            won = inspWoService.getNextWorkOrderNumber(projectId);
            if (won == null || won.isEmpty()) {
                return null;
            }
            rp.setWonumber(won);
            rp.setCreateDate(new Date());
            rp.setCreateBy(createBy);
            rp.setCreateByIp(ip);
        } else if (action.equals("update")) {
            rp.setId(new BigDecimal(wo.getWoId()));
        }
        rp.setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_REVERSE_MD));
        rp.setServicesRequested(buildStringServicesRequested(wo));
        rp.setInspector(contactService.findById(wo.getInspRefId().toString()).getFullName());
        rp.setTimeatoffice(DateSupport.formatString(wo.getTimeatoffice(), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), DateSupport.factorySimpleDateFormat("HH:mm")));
        rp.setTimeatsite(DateSupport.formatString(wo.getTimeatsite(), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), DateSupport.factorySimpleDateFormat("HH:mm")));
        rp.setHours(wo.getHours());
        if (wo.getContactrefId() != null) {
            rp.setContactPerson(contactService.findById(wo.getContactrefId().toString()).getFullName());
            rp.setContactrefid(wo.getContactrefId());
        }
        rp.setContactTelephone(wo.getContacttelephone());
        rp.setSpecInstr(wo.getSpecialinstruction());
        rp.setPaperworkReceived(wo.getPaperworkReceived() == null ? 'N' : wo.getPaperworkReceived().charAt(0));
        rp.setAssignment(wo.getAssigment());
        if (wo.getIscancel()) {
            rp.setCancelled("Yes");
        } else {
            rp.setCancelled("No");
        }
        rp.setActivityId((dbo.getActivityId() != null && !dbo.getActivityId().isEmpty() && dbo.getActivityId().equals("-1")) ? null : NumberSupport.getBigInteger(dbo.getActivityId()));
        rp.setInspRefid(wo.getInspRefId());
        rp.setInspectionFuncid(wo.getInspFuncId());
        rp.setDecisionflag(wo.getDecisionFlag());
        rp.setProjectId(projectId);
        rp.setInspdispatchid(dbo);
        rp.setWotoken(UUID.randomUUID().toString());
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setLastModBy(headerUser);
        rp.setLastModIp(ip);
        rp.setActive('Y');
        rp.setVersion("1");
        return rp;
    }

    /**
     * Convert To GlobDispatchcall Services
     *
     * @param wo
     * @param headerUser
     * @param dispatchId
     * @return List<GlobDispatchcallServices>
     */
    private List<GlobInspworkorderServices> toGlobInspWoServices(InspWorkOrderTO wo, String headerUser, BigInteger woId) {
        List<GlobInspworkorderServices> rpl = new ArrayList<>();
        BigInteger counter = BigInteger.ZERO;

        for (EngServiceTO it : wo.getEngService()) {
            if (it != null && StringSupport.isNotNullAndNotEmpty(it.getTypeofservice())) {
                rpl.add(new GlobInspworkorderServices(woId, counter, null, it.getTypeofservice(), eServiceType.eEng.getValue(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS), headerUser, "127.0.0.1"));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (FieldServiceTO it : wo.getFieldService()) {
            if (it != null && it.getServiceId() != null) {
                rpl.add(new GlobInspworkorderServices(woId, counter, it.getServiceId().toString(), null, eServiceType.eField.getValue(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS), headerUser, "127.0.0.1"));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (LabServiceTO it : wo.getLabService()) {
            if (it != null && it.getTestTypeId() != null) {
                rpl.add(new GlobInspworkorderServices(woId, counter, it.getTestTypeId().toString(), null, eServiceType.eLab.getValue(), DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS), headerUser, "127.0.0.1"));
                counter = counter.add(BigInteger.ONE);
            }
        }

        return rpl;
    }

    /**
     * Build String Services Requested
     *
     * @param wo
     * @return String
     */
    private String buildStringServicesRequested(InspWorkOrderTO wo) {
        List<String> services = new ArrayList<>();

        wo.getEngService().forEach((it) -> {
            if (it != null && StringSupport.isNotNullAndNotEmpty(it.getTypeofservice())) {
                services.add(it.getTypeofservice());
            }
        });

        wo.getFieldService().forEach((it) -> {
            if (it != null && it.getServiceId() != null) {
                services.add(fieldService.findById(it.getServiceId().toString()).getServiceFullName());
            }
        });

        wo.getLabService().forEach((it) -> {
            if (it != null && it.getTestTypeId() != null) {
                services.add(labService.findById(it.getTestTypeId().toString()).getLabServiceFullName());
            }
        });

        return String.join(",", services);
    }

    /**
     * Get Inspectors Answered Status
     *
     * @param persistenceId
     * @return Integer
     */
    @Override
    public Integer getInspectorsAnsweredStatus(String persistenceId) {
        int approved = 0;
        if (persistenceId != null && !persistenceId.isEmpty()) {
            Bpminspectordispatchbo dbo = findById(persistenceId);
            if (dbo != null) {
                List<GlobInspworkorder> reqLogList = dbo.getGlobInspworkorderList();
                int size = reqLogList.size();
                if (size == 0) {
                    return 2;
                }

                for (GlobInspworkorder dcl : reqLogList) {
                    if (dcl.getCancelled().equals("No")) {
                        if (dcl.getDecisionflag().equals(BigInteger.ONE)) {
                            approved++;
                        }
                        if (dcl.getDecisionflag().equals(BigInteger.ZERO)) {
                            return 0;
                        }
                    } else {
                        approved++;
                    }
                }

                if (approved == size) {
                    return 1;
                }

                if (approved < size) {
                    return 2;
                }
            }
        }
        return 0;
    }

    /**
     * Notify Inspectors
     *
     * @param persistenceId
     * @param server_domain
     * @param engine
     */
    @Override
    public void notifyInspectors(String persistenceId, String server_domain, TemplateEngine engine) {
        if (persistenceId != null && !persistenceId.isEmpty()) {
            Bpminspectordispatchbo dbo = findById(persistenceId);
            if (dbo != null) {
                GlobProject project = projectService.findById(dbo.getProjectId());
                List<GlobInspworkorder> reqLogList = dbo.getGlobInspworkorderList();
                reqLogList.forEach((wo) -> {
                    notifyInspector(persistenceId, server_domain, engine, dbo, wo, project);
                    notifyCcContactPerson(persistenceId, server_domain, engine, dbo, wo, project);
                });
            }
        }
    }

    /**
     * Notify Technician
     *
     * @param persistenceId
     * @param server_domain
     * @param engine
     * @param dbo
     * @param dcl
     * @param wo
     * @param project
     */
    private void notifyInspector(String persistenceId, String server_domain, TemplateEngine engine, Bpminspectordispatchbo dbo, GlobInspworkorder wo, GlobProject project) {
        Boolean isCancel = (dbo.getIscancel() == 0 && wo.getCancelled().equals("Yes"));

        if (!isCancel && wo.getDecisionflag().longValue() > 0L) {
            return;
        }

        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom("wwwmail@atser.com");
        String inspEmail = contactService.findById(wo.getInspRefid().toString()).getEmail();
        if (inspEmail == null || inspEmail.isEmpty()) {
            return;
        }

        // Variable Map
        Map<String, Object> map = new HashMap<>();
        String token = UUID.randomUUID().toString().replace("-", "");
        if (!isCancel) {
            msg.setSubject("Inspector Dispatch Request - Work Assignment");
            msg.setStatus("WAITING");
            msg.setToken(token);
        } else {
            msg.setSubject("Inspector Dispatch Request - Work Assignment was cancelled");
            msg.setStatus("SENDED");
            msg.setToken(null);
        }

        msg.setRefId(persistenceId);
        msg.setTo(new String[]{inspEmail});

        map.put("vInspName", wo.getInspector());
        map.put("showButtons", !isCancel);
        map.put("isCancel", isCancel);
        map.put("vTitle", dbo.getRequestName());
        map.put("vProjectName", project.getPName());
        map.put("vWoNo", wo.getWonumber());
        map.put("vRequestedBy", dbo.getRequestedBy());
        map.put("vServicesRequested", wo.getServicesRequested());
        map.put("vServiceDate", DateSupport.formatDate(wo.getServiceDate(), DateSupport.FORMAT_US));
        map.put("vArriveLabTime", wo.getTimeatoffice());
        map.put("vTimeSite", wo.getTimeatsite());
        map.put("vRequestDescription", dbo.getRequestDescription());
        map.put("vSpecialInstructions", wo.getSpecInstr());
        map.put("vURLYes", "https://" + server_domain + "/ws/rs/form/dispatch/inspector?t=" + token + "&r=Y&k=" + wo.getId());
        map.put("vURLNo", "https://" + server_domain + "/ws/rs/form/dispatch/inspector?t=" + token + "&r=N&k=" + wo.getId());
        map.put("vURLDownloadWO", "https://" + server_domain + "/ws/rs/bpm/dispatch/inspector/generate/workorder/external?t=" + wo.getWotoken());

        final Context ctx = new Context(Locale.ENGLISH);
        ctx.setVariables(map);

        final String emailBody = engine.process("InspectorDispatch/email-InspNotification.html", ctx);
        if (emailBody != null && !emailBody.isEmpty()) {
            msg.setMessageText(emailBody);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
            return;
        }

        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

        if (status) {
            ntfTrackService.save("bpm", "inspectordispatch", msg);
        }
    }

    /**
     * Notify Cc ContactPerson
     *
     * @param persistenceId
     * @param server_domain
     * @param engine
     * @param dbo
     * @param dcl
     * @param wo
     * @param project
     */
    private void notifyCcContactPerson(String persistenceId, String server_domain, TemplateEngine engine, Bpminspectordispatchbo dbo, GlobInspworkorder wo, GlobProject project) {
        Boolean isCancel = (dbo.getIscancel() == 0 && wo.getCancelled().equals("Yes"));

        if (!isCancel && wo.getDecisionflag().longValue() > 0L) {
            return;
        }
        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom("wwwmail@atser.com");
        String contactEmail = null;
        if (wo.getContactrefid() != null) {
            contactEmail = contactService.findById(wo.getContactrefid().toString()).getEmail();
        }
        if (contactEmail == null || contactEmail.isEmpty()) {
            return;
        }

        // Variable Map
        Map<String, Object> map = new HashMap<>();
        if (!isCancel) {
            msg.setSubject("Inspector Dispatch Request - Work Assignment");
        } else {
            msg.setSubject("Inspector Dispatch Request - Work Assignment was cancelled");
        }

        msg.setStatus("SENDED");
        msg.setToken(null);
        msg.setRefId(persistenceId);
        msg.setTo(new String[]{contactEmail});

        map.put("vInspName", wo.getInspector());
        map.put("showButtons", Boolean.FALSE);
        map.put("isCancel", isCancel);
        map.put("vTitle", dbo.getRequestName());
        map.put("vProjectName", project.getPName());
        map.put("vWoNo", wo.getWonumber());
        map.put("vRequestedBy", dbo.getRequestedBy());
        map.put("vServicesRequested", wo.getServicesRequested());
        map.put("vServiceDate", DateSupport.formatDate(wo.getServiceDate(), DateSupport.FORMAT_US));
        map.put("vArriveLabTime", wo.getTimeatoffice());
        map.put("vTimeSite", wo.getTimeatsite());
        map.put("vRequestDescription", dbo.getRequestDescription());
        map.put("vSpecialInstructions", wo.getSpecInstr());
        map.put("vURLDownloadWO", "https://" + server_domain + "/ws/rs/bpm/dispatch/inspector/generate/workorder/external?t=" + wo.getWotoken());

        final Context ctx = new Context(Locale.ENGLISH);
        ctx.setVariables(map);

        final String emailBody = engine.process("InspectorDispatch/email-InspNotification.html", ctx);
        if (emailBody != null && !emailBody.isEmpty()) {
            msg.setMessageText(emailBody);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
            return;
        }

        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

        if (status) {
            ntfTrackService.save("bpm", "inspectordispatch", msg);
        }
    }

    /**
     * Build Report
     *
     * @param reportId
     * @param paramsMap
     * @return List<IReportSyncfusion>
     */
    @Override
    public List<IReportSyncfusion> buildReport(String reportId, Map<String, String> paramsMap) {
        List<Bpminspectordispatchbo> dlist = dao.findAll();
        switch (reportId) {
            case "rPieByStatus": {
                return buildReportPieByStatus(dlist);
            }
            case "rChartLineEfficiency": {
                return buildReportChartLineEfficiency(dlist, paramsMap);
            }
            case "rColumTaskSource": {
                return buildReportColumTaskSource(dlist, paramsMap);
            }
        }
        return null;
    }

    /**
     * Build Report Pie By Status
     *
     * @param dlist
     * @return List<IReportSyncfusion>
     */
    private List<IReportSyncfusion> buildReportPieByStatus(List<Bpminspectordispatchbo> dlist) {
        List<IReportSyncfusion> report = new ArrayList<>();
        if (dlist.isEmpty()) {
            return report;
        }
        Predicate<Bpminspectordispatchbo> predicateDraft = s -> s.getStatus().equals("Draft");
        Predicate<Bpminspectordispatchbo> predicateClosed = s -> (s.getStatus().equals("Closed") && s.getIscancel() != 1 && (s.getFinaldisposition() != null && !s.getFinaldisposition().equals("DISPATCH REJECTED")));
        Predicate<Bpminspectordispatchbo> predicateRevision = s -> s.getStatus().equals("In Progress");
        Predicate<Bpminspectordispatchbo> predicateCancel = s -> (s.getStatus().equals("Closed") && s.getIscancel() == 1);
        Predicate<Bpminspectordispatchbo> predicateRejected = s -> (s.getStatus().equals("Closed") && (s.getFinaldisposition() != null && s.getFinaldisposition().equals("DISPATCH REJECTED")));
        Long ldraft = dlist.stream().filter(predicateDraft).count();
        Long lrevision = dlist.stream().filter(predicateRevision).count();
        Long lcancel = dlist.stream().filter(predicateCancel).count();
        Long lrejected = dlist.stream().filter(predicateRejected).count();
        Long lclosed = dlist.stream().filter(predicateClosed).count();
        report.add(new ReportPieDoughnutTO("Draft", "Draft (" + ldraft + ")", ((ldraft * 100) / dlist.size())));
        report.add(new ReportPieDoughnutTO("In Progress", "In Progress (" + lrevision + ")", ((lrevision * 100) / dlist.size())));
        report.add(new ReportPieDoughnutTO("Cancelled", "Cancelled (" + lcancel + ")", ((lcancel * 100) / dlist.size())));
        report.add(new ReportPieDoughnutTO("Rejected", "Rejected (" + lrejected + ")", ((lrejected * 100) / dlist.size())));
        report.add(new ReportPieDoughnutTO("Closed", "Closed (" + lclosed + ")", ((lclosed * 100) / dlist.size())));
        Comparator<IReportSyncfusion> byY = (IReportSyncfusion o1, IReportSyncfusion o2) -> ((ReportPieDoughnutTO) o1).getY().compareTo(((ReportPieDoughnutTO) o2).getY());
        report = report.stream().sorted(byY.reversed()).collect(Collectors.toList());
        return report;
    }

    /**
     * Build Report Colum Task Source
     *
     * @param dlist
     * @param paramsMap
     * @return List<IReportSyncfusion>
     */
    private List<IReportSyncfusion> buildReportColumTaskSource(List<Bpminspectordispatchbo> dlist, Map<String, String> paramsMap) {
        List<IReportSyncfusion> report = new ArrayList<>();
        if (dlist.isEmpty()) {
            return report;
        }
        String year = DateSupport.getNowToFormat("yyyy");
        if (paramsMap != null) {
            year = paramsMap.get("date");
        }

        report.add(new ReportColumsTO(buildColumsPointsTaskSource(dlist, Integer.valueOf(year), "system"), "SYSTEM"));
        report.add(new ReportColumsTO(buildColumsPointsTaskSource(dlist, Integer.valueOf(year), "call"), "CALL"));
        report.add(new ReportColumsTO(buildColumsPointsTaskSource(dlist, Integer.valueOf(year), "email"), "EMAIL"));

        return report;
    }

    /**
     * Build Columns Points Task Source
     *
     * @param dlist
     * @param year
     * @param filter
     * @return List<ReportPointsTO>
     */
    private List<ReportPointsTO> buildColumsPointsTaskSource(List<Bpminspectordispatchbo> dlist, Integer year, String filter) {
        List<ReportPointsTO> points = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);
        int month = date.getMonthValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm a");

        for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
            date = date.withMonth(currentMonth);
            LocalDate firstDay = date.withDayOfMonth(1);
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            Predicate<Bpminspectordispatchbo> predicateSystem = (s -> s.getRequestSource().equals(filter) && (LocalDate.parse(s.getCreated(), formatter).compareTo(lastDay) <= 0 && LocalDate.parse(s.getCreated(), formatter).compareTo(firstDay) >= 0));
            Long lsystem = dlist.stream().filter(predicateSystem).count();
            points.add(new ReportPointsTO(firstDay.format(DateTimeFormatter.ofPattern("yyyy-M-d")), lsystem));
        }
        return points;
    }

    /**
     * Build Report Chart Line Efficiency
     *
     * @param dlist
     * @param paramsMap
     * @return List<IReportSyncfusion>
     */
    private List<IReportSyncfusion> buildReportChartLineEfficiency(List<Bpminspectordispatchbo> dlist, Map<String, String> paramsMap) {
        List<IReportSyncfusion> report = new ArrayList<>();
        if (dlist.isEmpty()) {
            return report;
        }
        String sdate = DateSupport.getNowToFormat("yyyy-MM");
        if (paramsMap != null) {
            sdate = paramsMap.get("date");
        }

        if (sdate != null && !sdate.isEmpty() && sdate.contains("-")) {
            report.add(new ReportColumsTO(buildLinePointsEfficiency(dlist, sdate), "Inspector Dispatch Process"));
        }

        return report;
    }

    /**
     * Build Line Points Efficiency
     *
     * @param dlist
     * @param sdate
     * @return List<ReportPointsTO>
     */
    private List<ReportPointsTO> buildLinePointsEfficiency(List<Bpminspectordispatchbo> dlist, String sdate) {
        List<ReportPointsTO> points = new ArrayList<>();
        Integer year = Integer.valueOf(sdate.split("-")[0]);
        Integer month = Integer.valueOf(sdate.split("-")[1]);
        LocalDate date = LocalDate.of(year, month, 1);
        DateTimeFormatter formatterDoneDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        List<Bpminspectordispatchbo> dlistClosed = dlist.stream().filter(d -> d.getStatus().equals("Closed") && d.getIscancel() != 1 && (d.getFinaldisposition() != null && !d.getFinaldisposition().isEmpty()) && (LocalDate.parse(d.getDoneDate(), formatterDoneDate).format(DateTimeFormatter.ofPattern("yyyy-MM")).equals(sdate))).collect(Collectors.toList());
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());

        for (int currentDay = 1; currentDay <= Integer.valueOf(lastDay.format(DateTimeFormatter.ofPattern("d"))); currentDay++) {
            LocalDate localdate = date.withDayOfMonth(currentDay);
            Predicate<Bpminspectordispatchbo> predicateDay = (s -> LocalDate.parse(s.getDoneDate(), formatterDoneDate).isEqual(localdate));
            Long count = dlistClosed.stream().filter(predicateDay).count();
            points.add(new ReportPointsTO(localdate.format(DateTimeFormatter.ofPattern("yyyy-M-d")), count));
        }

        return points;
    }

    @Override
    public String generateWoReportByFilter(BonitaBpmSupport session, String tplpath, String docpathsegment, String type, String[] idArray) throws IOException, BonitaException, Exception {
        Map<String, Object> paramsJasper = new HashMap<>();

        eDocExtension extension;
        if (type == null || type.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(type);
        }

        List<InspDispatchPrintWOPojo> dwo = new ArrayList<>();

        for (String string : idArray) {
            InspDispatchPrintWOPojo response = generateWOPojo(string);
            if (Objects.nonNull(response)) {
                dwo.add(response);
            }
        }

        if (!dwo.isEmpty()) {
            String targetPath = docpathsegment + "InspWorkOrderReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
            paramsJasper.put("listWo", dwo);
            BuildJasper pdf = new BuildJasper();
            try {
                targetPath = pdf.exportDocument(tplpath, paramsJasper, targetPath, extension.getValue());
                return targetPath;

            } catch (Exception ex) {
                Logger.getLogger(BpmDispatchServiceImpl.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    @Override
    public String generateExternalWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String woToken, String docType) throws IOException, BonitaException, Exception {
        GlobInspworkorder wo = inspWoService.findByWoToken(woToken);
        if (wo == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }

        return generateWO(session, tplpath, docpathsegment, wo.getId().toString(), docType);
    }

    /**
     * Generate Wo Report
     *
     * @param session
     * @param tplpath
     * @param docpathsegment
     * @param persistenceId
     * @param docType
     * @param isWO
     * @return String
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    @Override
    public String generateWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String persistenceId, String docType, Boolean isWO) throws IOException, BonitaException, Exception {
        if (isWO) {
            return generateWO(session, tplpath, docpathsegment, persistenceId, docType);
        }
        return generateAllWO(session, tplpath, docpathsegment, persistenceId, docType);
    }

    /**
     * Generate WO
     *
     * @param session
     * @param tplpath
     * @param docpathsegment
     * @param logId
     * @param docType
     * @return String
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    private String generateWO(BonitaBpmSupport session, String tplpath, String docpathsegment, String logId, String docType) throws IOException, BonitaException, Exception {
        Map<String, Object> paramsJasper = new HashMap<>();
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        List<InspDispatchPrintWOPojo> dwo = new ArrayList<>();

        InspDispatchPrintWOPojo response = generateWOPojo(logId);

        if (Objects.nonNull(response)) {
            dwo.add(response);
            String targetPath = docpathsegment + "InspWorkOrderReport_" + response.getWoNo() + "_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
            paramsJasper.put("listWo", dwo);
            BuildJasper pdf = new BuildJasper();
            try {
                targetPath = pdf.exportDocument(tplpath, paramsJasper, targetPath, extension.getValue());
                return targetPath;

            } catch (Exception ex) {
                Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }

    /**
     * Generate WO Pojo
     *
     * @param logId
     * @return InspDispatchPrintWOPojo
     */
    private InspDispatchPrintWOPojo generateWOPojo(String logId) {
        InspDispatchPrintWOPojo response = null;
        if (logId == null || logId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        GlobInspworkorder wo = inspWoService.findById(logId);
        GlobProject project = projectService.findById(StringSupport.emptyOnNull(wo.getProjectId()));

        Bpminspectordispatchbo dbo = wo.getInspdispatchid();
        String clientId = dbo.getClientId();

        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        if (Objects.nonNull(project)) {
            Boolean isCancel = wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("yes");
            response = new InspDispatchPrintWOPojo(wo.getInspector(), DateSupport.formatDate(wo.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")),
                    wo.getTimeatoffice(), wo.getTimeatsite(), dbo.getRequestedBy(), DateSupport.formatDate(wo.getCreateDate(), DateSupport.FORMAT_MMDDYY_HHMMA), getProjectManagerName(project.getPersonProjectManager().toString()), project.getName(), wo.getWonumber(), wo.getContactPerson(),
                    wo.getContactTelephone(), project.getPName(), wo.getServicesRequested(), wo.getSpecInstr(), projectLogoImage, cmContractActivity.getActivityName(wo.getActivityId(), "n"), isCancel, cmDailyLocationService.getDailyLocation(dbo.getRequestLocation()));
        }

        return response;
    }

    /**
     * Generate All WO
     *
     * @param session
     * @param tplpath
     * @param docpathsegment
     * @param persistenceId
     * @param docType
     * @return String
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    private String generateAllWO(BonitaBpmSupport session, String tplpath, String docpathsegment, String persistenceId, String docType) throws IOException, BonitaException, Exception {
        Map<String, Object> paramsJasper = new HashMap<>();
        if (persistenceId == null || persistenceId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        Bpminspectordispatchbo dbo = findById(persistenceId);
        if (Objects.nonNull(dbo)) {
            String targetPath = docpathsegment + "InspWorkOrderReport_" + dbo.getRequestnumber() + "_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
            String projectId = StringSupport.emptyOnNull(dbo.getProjectId());
            GlobProject project = projectService.findById(projectId);

            BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
            if (Objects.nonNull(project)) {
                List<InspDispatchPrintWOPojo> dwo = new ArrayList<>();
                List<GlobInspworkorder> woList = dbo.getGlobInspworkorderList();

                for (GlobInspworkorder wo : woList) {
                    Boolean isCancel = wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("yes");
                    dwo.add(new InspDispatchPrintWOPojo(wo.getInspector(), DateSupport.formatDate(wo.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")),
                            wo.getTimeatoffice(), wo.getTimeatsite(), dbo.getRequestedBy(), DateSupport.formatDate(wo.getCreateDate(), DateSupport.FORMAT_MMDDYY_HHMMA), getProjectManagerName(project.getPersonProjectManager().toString()), project.getName(), wo.getWonumber(), wo.getContactPerson(),
                            wo.getContactTelephone(), project.getPName(), wo.getServicesRequested(), wo.getSpecInstr(), projectLogoImage, cmContractActivity.getActivityName(wo.getActivityId(), "n"), isCancel, cmDailyLocationService.getDailyLocation(dbo.getRequestLocation())));
                }

                paramsJasper.put("listWo", dwo);

                BuildJasper pdf = new BuildJasper();
                try {
                    targetPath = pdf.exportDocument(tplpath, paramsJasper, targetPath, extension.getValue());
                    return targetPath;

                } catch (Exception ex) {
                    Logger.getLogger(BpmInspectorDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    @Override
    public void sendEmail(TemplateEngine engine, ManageITRequest<BpmMailMessage> request, String cc, Boolean isbpmTrackEnable) {
        if (request.getBody().getData().getTo() == null && request.getBody().getData().getRefId() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
            return;
        }
        String action = request.getBody().getAction();
        BpmMailMessage msg = factoryEmailByTask(engine, action, request.getBody().getData(), request.getBody().getParams());
        Boolean status;
        if (cc != null && !cc.isEmpty()) {
            String[] ccarray = cc.split(",");
            msg.setCc(ccarray);
        }
        status = MailSender.sendEmailDefault(mailSession, msg);
        if (status) {
            if (isbpmTrackEnable) {
                ntfTrackService.save(request.getHeader().getModule(), request.getHeader().getFunctionality(), msg);
            }
        }
    }

    private BpmMailMessage factoryEmailByTask(TemplateEngine engine, String action, BpmMailMessage pmsg, AtserLinkedHashMap<String, Object> params) {
        Bpminspectordispatchbo dbo = findById(pmsg.getRefId());
        BpmMailMessage rmsg = new BpmMailMessage();
        Map<String, Object> map = new HashMap<>();
        rmsg.setRefId(pmsg.getRefId());
        rmsg.setFrom("wwwmail@atser.com");
        rmsg.setTo(pmsg.getTo());
        if (dbo != null) {
            map.put("vReqObject", dbo);
            switch (action) {
                case "Task1.ReviewRequest": {
                    rmsg.setSubject("Inspector Dispatch Request - Pending Task Notification");
                    map.put("vEmailTo", "Resident Engineers");
                    map.put("vFooter", "This email is to notify you that there are pending tasks that should be addressed, please review them.");
                    map.put("vEmailTask", "Review Inspector Dispatch Request");
                    break;
                }
                case "NotifyRequestorCompleted": {
                    rmsg.setSubject("Inspector Dispatch Request has been Completed");
                    map.put("vFooter", "This email is to notify you that the request has been completed.");
                    map.put("vEmailTo", "Requestor");
                    if (params != null && !params.isEmpty() && params.containsKey("task")) {
                        map.put("vEmailTask", params.get("task"));
                    } else {
                        map.put("vEmailTask", "Notify Requestor - Completed");
                    }
                    break;
                }
                case "NotifyRequestorRejected": {
                    rmsg.setSubject("Inspector Dispatch Request has been Rejected");
                    map.put("vFooter", "This email is to notify you that the request has been rejected.");
                    map.put("vEmailTo", "Requestor");
                    if (params != null && !params.isEmpty() && params.containsKey("task")) {
                        map.put("vEmailTask", params.get("task"));
                    } else {
                        map.put("vEmailTask", "Notify Requestor - Rejected");
                    }
                    break;
                }
            }
            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);
            final String emailBody = engine.process("InspectorDispatch/email-InspDefaultNotification.html", ctx);
            if (emailBody != null && !emailBody.isEmpty()) {
                rmsg.setMessageText(emailBody);
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                return null;
            }
        }
        return rmsg;
    }

}
