/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.dao.bpm.BpmDispatchDao;
import com.atser.tools.atserejb.model.Bpmdispatchbo;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobDispatchcallLog;
import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import com.atser.tools.atserejb.model.GlobNotificationTrack;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobProjectPersonnel;
import com.atser.tools.atserejb.model.GlobServicesLab;
import com.atser.tools.atserejb.model.GlobUserSignature;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserejb.model.QaconcMixdesigns;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.cm.CmContractActivityService;
import com.atser.tools.atserejb.service.cm.CmDailyLocationService;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobDispatchcallLogService;
import com.atser.tools.atserejb.service.glob.GlobDispatchcallServicesService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobInspworkorderService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProjectPersonnelService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobServicesFieldService;
import com.atser.tools.atserejb.service.glob.GlobServicesLabService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.glob.GlobUserSignatureService;
import com.atser.tools.atserejb.service.glob.GlobWorkorderService;
import com.atser.tools.atserejb.service.qa.QaconcMixdesignsService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.enumerator.eServiceType;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.image.ImageSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.calendar.report.CalendarResourcesTO;
import com.atser.tools.atserutil.objects.pojo.jasper.DispatchPrintWOPojo;
import com.atser.tools.atserutil.objects.pojo.jasper.DispatchWOPojo;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.dispatch.EngServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.FieldServiceTO;
import com.atser.tools.atserutil.objects.to.dispatch.LabServiceTO;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourceTO;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.objects.to.dispatch.InspWorkOrderTO;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.objects.to.reports.IReportSyncfusion;
import com.atser.tools.atserutil.objects.to.reports.ReportColumsTO;
import com.atser.tools.atserutil.objects.to.reports.ReportPieDoughnutTO;
import com.atser.tools.atserutil.objects.to.reports.ReportPointsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.mail.Session;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.bonitasoft.engine.identity.ContactData;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * BPM Dispatch Service Implementation
 *
 * @author droldan
 */
@Stateless
@Slf4j
public class BpmDispatchServiceImpl implements BpmDispatchService, IBaseEJBException {

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private BpmDispatchDao dao;

    @Inject
    private BpmOperatorService bpmOperatorService;

    @Inject
    private GlobUserService userService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GlobUserSignatureService userSignService;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobDispatchcallLogService dispatchCallLogService;

    @Inject
    private GlobServicesLabService labService;

    @Inject
    private GlobServicesFieldService fieldService;

    @Inject
    private GlobProjectPersonnelService projPersonnelService;

    @Inject
    private GlobContactService contactService;

    @Inject
    private GlobWorkorderService workorderService;

    @Inject
    private GlobDispatchcallServicesService dispatchServicesService;

    @Inject
    private GlobFileService fileService;

    @Inject
    private GenericHelperService genericHelperService;

    @Inject
    private QaconcMixdesignsService qaconcMixdesignsService;

    @Inject
    private CmContractActivityService cmContractActivity;

    @Inject
    private GlobInspworkorderService inspWoService;

    @Inject
    private CmDailyLocationService cmDailyLocationService;

    /**
     * Find by Id
     *
     * @param id
     * @return Bpmdispatchbo
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Bpmdispatchbo findById(String id) {
        return findById(id, null);
    }

    /**
     * Find by Id
     *
     * @param id
     * @param session
     * @return Bpmdispatchbo
     */
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public Bpmdispatchbo findById(String id, BonitaBpmSupport session) {
        Bpmdispatchbo response = dao.findById(NumberSupport.getBigDecimal(id));
        if (session == null) {
            return response;
        }

        if (response.getEmailToNotify() == null || response.getEmailToNotify().isEmpty()) {
            try {
                ContactData proUser = session.getProfessionalDataById(response.getRequestorId().longValue());
                response.setEmailToNotify(proUser.getEmail());
            } catch (BonitaException ex) {
                Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return response;
    }

    /**
     * Find by Id
     *
     * @param id
     * @return Bpmdispatchbo
     */
    @Override
    public Bpmdispatchbo findById(BigDecimal id) {
        return dao.findById(id);
    }

    /**
     * Find by Folder Id
     *
     * @param id
     * @return Bpmdispatchbo
     */
    @Override
    public Bpmdispatchbo findByFolderId(String id) {
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
        Bpmdispatchbo elem = new Bpmdispatchbo();
        elem.setRequestnumber(nextStep);
        elem.setFolderId(folderId);
        elem.setRequestSource(request.getParams().get("reqSource").toString());
        elem.setCreated(request.getParams().get("created").toString());
        elem.setDatetimereqOnjobsite(request.getParams().get("datetimereqOnjobsite").toString());
        elem.setStatus(request.getParams().get("status").toString());
        elem.setProjectId(request.getParams().get("projectId").toString());
        elem.setClientId(request.getParams().get("clientId").toString());
        elem.setContractId(request.getParams().get("contractId").toString());
        elem.setActivityId(request.getParams().get("activityId") == null ? "-1" : request.getParams().get("activityId").toString());
        elem.setPersistenceversion(BigInteger.ZERO);
        elem.setRequestorId(NumberSupport.getBigInteger(request.getParams().get("requestorId").toString()));
        elem.setReqQty(request.getParams().get("reqQty") == null ? null : request.getParams().get("reqQty").toString());
        elem.setMixDesign(request.getParams().get("mixDesign") == null ? null : request.getParams().get("mixDesign").toString());
        elem.setBatchPlant(request.getParams().get("batchPlant") == null ? null : request.getParams().get("batchPlant").toString());
        elem.setCaseId(null);
        elem.setCancreaterevision((short) 0);
        if (request.getParams().containsKey("revision")) {
            elem.setRequestName(request.getParams().get("title").toString());
            elem.setRequestDescription(request.getParams().get("description").toString());
            String rev = nextStep.substring(nextStep.length() - 2, nextStep.length());
            // Modify canRevision
            Bpmdispatchbo temp = findById(request.getParams().get("persistenceId").toString());
            if (rev.equals("01")) {
                elem.setParentId(NumberSupport.getBigInteger(request.getParams().get("persistenceId").toString()));
                rArray[0] = NumberSupport.getBigInteger(request.getParams().get("persistenceId").toString());
            } else {
                elem.setParentId(temp.getParentId());
                rArray[0] = temp.getParentId();
            }
            temp.setCancreaterevision((short) 0);
            //dao.save(temp); We dont need to save it, it will update automatically.
        }

        rArray[1] = dao.save(elem).getPersistenceid().toBigInteger();
        return rArray;
    }

    /**
     * Update Data (Bpmdispatchbo)
     *
     * @param elem
     */
    @Override
    public void updateData(Bpmdispatchbo elem) {
        if (elem != null) {
            Bpmdispatchbo model = findById(elem.getPersistenceid());
            model.setMixDesign(elem.getMixDesign());
            model.setRequestDescription(elem.getRequestDescription());
            model.setRequestedBy(elem.getRequestedBy());
            model.setRequestSource(elem.getRequestSource());
            model.setEmailToNotify(elem.getEmailToNotify());
            model.setRequestLocation(elem.getRequestLocation());
            model.setReqQty(elem.getReqQty());
            model.setBatchPlant(elem.getBatchPlant());
            model.setActivityId((elem.getActivityId() == null || elem.getActivityId().isEmpty() || elem.getActivityId().toLowerCase().equals("n/a")) ? "-1" : elem.getActivityId());

            List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(elem.getPersistenceid().toBigInteger());
            reqLogList.forEach((dcl) -> {
                GlobWorkorder wo = dcl.getWoId();
                wo.setActivityId((elem.getActivityId() != null && !elem.getActivityId().isEmpty() && elem.getActivityId().equals("-1")) ? null : NumberSupport.getBigInteger(elem.getActivityId()));
            });
            dao.update(model);
        }
    }

    /**
     * Update Data (Bpmdispatchbo)
     *
     * @param elem
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    @Override
    public void update(Bpmdispatchbo elem) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (elem != null) {
            update(elem, null, null);
        }
    }

    /**
     * Update Data (Bpmdispatchbo)
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
    public void update(Bpmdispatchbo elem, String action, BonitaBpmSupport session) throws ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (elem != null) {
            Bpmdispatchbo model = findById(elem.getPersistenceid());

            if (session != null) {
                Long caseId;
                if (action != null && action.equals("btnCreate")) {
                    caseId = startBPMProcess(elem.getPersistenceid().longValue(), "bpmPoolBOInput", "Dispatch Process", model.getRequestorId().longValue(), session);
                    model.setCaseId(BigInteger.valueOf(caseId));
                }
            }

            model.setRequestName(elem.getRequestName());
            model.setRequestDescription(elem.getRequestDescription());
            model.setDatetimereqOnjobsite(elem.getDatetimereqOnjobsite());
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
            model.setReqQty(elem.getReqQty());
            model.setMixDesign(elem.getMixDesign());
            model.setBatchPlant(elem.getBatchPlant());
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
    public DataTableWrapper<Bpmdispatchbo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<Bpmdispatchbo> finalList = list(request, session);
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
    public List<Bpmdispatchbo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        List<Bpmdispatchbo> returnList;
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
            Bpmdispatchbo obj = findById(subid);
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
    private String checkIfIsPossibleCancelRequest(Bpmdispatchbo item, BonitaBpmSupport session) throws BonitaException {
        if (item != null && item.getCaseId() != null && session != null) {
            if (session.isHumanTaskAlreadyAssigned("ready", item.getCaseId().longValue())) {
                return "assigned";
            }

            List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(item.getPersistenceid().toBigInteger());
            int size = reqLogList.size();

            if (size > 0) {
                return "wo";
            }
        }
        return null;
    }

    /**
     * Reassign Technician
     *
     * @param request
     * @param session
     * @return Boolean
     */
    @Override
    public Boolean reAssignTech(ManageITBodyRequest<Bpmdispatchbo> request, BonitaBpmSupport session) {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        Bpmdispatchbo obj = findById(id);
        try {
            List<GlobNotificationTrack> listNtf = ntfTrackService.findAllByRefIdAndStatus("dispatch", id, "WAITING");

            listNtf.forEach((ntf) -> {
                ntf.setUniqueToken("-1");
                ntf.setStatus("CANCELLED");
                ntf.setAnswer(null);
                ntfTrackService.update(ntf);
            });

            List<GlobDispatchcallLog> listdCallLog = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(id));
            listdCallLog.forEach((dcl) -> {
                if (dcl.getDecisionFlag() != 1L) {
                    dcl.setDecisionFlag(3L);
                    dispatchCallLogService.updateDecisionFlag(dcl);
                }
            });

            obj.setInternalstatus("Technician Cancellation in Progress");
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
     * @return BigInteger (CaseId)
     * @throws BonitaException
     */
    @Override
    public BigInteger cancelRequest(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException {
        if (!request.getParams().isContainsAllKeys(new String[]{"id"}) || request.getParams().get("id").toString().isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String id = request.getParams().get("id").toString();
        Bpmdispatchbo obj = findById(id);

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
        Bpmdispatchbo dbo = findById(persistenceId);
        if (Objects.nonNull(dbo)) {
            String targetPath = null;
            String finalDisposition;
            String finalRemark;
            String projectId = StringSupport.emptyOnNull(dbo.getProjectId());
            String clientId = StringSupport.emptyOnNull(dbo.getClientId());
            String contractId = StringSupport.emptyOnNull(dbo.getContractId());
            String pdfpatharea = pdfpathsegment + clientId + "/" + projectId + "/" + contractId + "/";
            Map<String, Object> metaDataFile = FileSupport.getMetaDataServerFilename("Transmittal_Letter_" + DateSupport.getNowToFormat("MMddyyyy") + "_" + dbo.getPersistenceversion().toString() + ".pdf", pdfpatharea);
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
                        Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                List<DispatchWOPojo> dwo = new ArrayList<>();

                List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(persistenceId));

                reqLogList.forEach((dcl) -> {
                    GlobWorkorder wo = dcl.getWoId();
                    if (wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("no")) {
                        GlobContact techcontact = contactService.findById(dcl.getTechRefId().toString());
                        String techPhone = techcontact.getPhone();
                        String techCell = techcontact.getCell();
                        String techContactNumber;
                        if (techCell != null && !techCell.isEmpty()) {
                            techContactNumber = techCell;
                        } else if (techPhone != null && !techPhone.isEmpty()) {
                            techContactNumber = techPhone;
                        } else {
                            techContactNumber = "281-999-9961";
                        }

                        dwo.add(new DispatchWOPojo(wo.getWoNo(), dcl.getServicesRequested(), DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US), dcl.getTimeSite(), dcl.getTechnician(), techContactNumber));
                    }
                });

                paramsJasper.put("listWo", dwo);

                BuildJasper pdf = new BuildJasper();
                try {
                    targetPath = pdf.exportDocument(tplpath, paramsJasper, StringSupport.emptyOnNull(metaDataFile.get("filename")), "pdf");
                } catch (Exception ex) {
                    Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }

                metaDataFile = FileSupport.getFileMetaData(targetPath, metaDataFile);
                params.put("clientId", clientId);
                params.put("projectId", projectId);
                params.put("contractId", contractId);
                params.put("folderId", dbo.getFolderId().toString());
                params.put("from", RequestorUserName);
                params.put("userId", customRequestorId);
                fileService.saveFileToDb(metaDataFile, params, "Dispatch");
            }
        }
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
        Bpmdispatchbo obj = findById(id);
        obj.setIsrollback((short) 1);
        obj.setRestorepoint(restorePoint);
        dao.save(obj);

        Bpmdispatchbo model = findById(id);
        if (session != null) {
            Long caseId;
            if (action != null && action.equals("btnRollBack")) {
                caseId = startBPMProcess(model.getPersistenceid().longValue(), "bpmPoolBOInput", "Dispatch Process", model.getRequestorId().longValue(), session);
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
    public WorkOrderTO findRequestLogById(String logId) {
        GlobDispatchcallLog reqLog = dispatchCallLogService.findById(logId);
        if (reqLog != null) {
            GlobWorkorder wo = reqLog.getWoId();
            List<GlobDispatchcallServices> servList = dispatchServicesService.findByCallLogId(reqLog.getId().toBigInteger());
            try {
                return toWorkOrderTO(reqLog, wo, servList);
            } catch (ParseException ex) {
                Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public List<WorkOrderTO> wolist(String id) {
        List<WorkOrderTO> woList = new ArrayList<>();
        List<GlobDispatchcallLog> listdCallLog = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(id));
        listdCallLog.forEach((dcl) -> {
            GlobWorkorder wo = dcl.getWoId();
            List<GlobDispatchcallServices> servList = dispatchServicesService.findByCallLogId(dcl.getId().toBigInteger());
            try {
                woList.add(toWorkOrderTO(dcl, wo, servList));
            } catch (ParseException ex) {
                Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        WorkOrderTO wo = (WorkOrderTO) request.getData();
        if (wo != null) {
            GlobDispatchcallLog reqLog = dispatchCallLogService.findById(wo.getLogId().toString());
            if (reqLog != null) {
                reqLog.setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_US_DASH));
                reqLog.getWoId().setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_US_DASH));
                reqLog.setTimeSite(wo.getTimeatsite());
                reqLog.getWoId().setArriveLabTime(wo.getTimeatoffice());
                reqLog.setHours(wo.getHours());
                reqLog.setAssignment(wo.getAssigment());
                reqLog.setPaperworkReceived(wo.getPaperworkReceived() == null ? 'N' : wo.getPaperworkReceived().charAt(0));
                reqLog.setSpecInstr(wo.getSpecialinstruction());
                dispatchCallLogService.update(reqLog);
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
    public void manageRequestLog(ManageITBodyRequest request, BonitaBpmSupport session, String headerUser) throws BonitaException {
        log.info("Receiving BPM Request Log");
        if (!request.getParams().isContainsAllKeys(new String[]{"dispatchid"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        String dispatchid = request.getParams().get("dispatchid").toString();
        List<WorkOrderTO> woList = (List<WorkOrderTO>) request.getData();
        if (dispatchid == null || dispatchid.isEmpty() || woList.isEmpty()) {
            log.error("Dispatch Id null or empty or woList empty.");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        Bpmdispatchbo dbo = findById(dispatchid);
        String createBy = getUserNameByRequestorId(dbo.getRequestorId(), session);
        BigInteger woId;
        BigInteger dispatchId = null;
        log.info(String.format("BPM Request Log contains '%s' of workorders", woList.size()));
        try {
            for (WorkOrderTO woIt : woList) {
                if (woIt.getLogId() != null && woIt.getLogId().longValue() == 0) {
                    woId = workorderService.save(toGlobWorkorder(dbo, woIt, headerUser, "insert"));
                    if (woId != null) {
                        log.info("Creating GlobDispatchcallLog");
                        dispatchId = dispatchCallLogService.save(toGlobDispatchcallLog(dbo, woIt, createBy, headerUser, woId, "insert"));
                    }
                } else if (woIt.getLogId() != null && woIt.getLogId().longValue() > 0) {
                    GlobWorkorder woDb = toGlobWorkorder(dbo, woIt, headerUser, "update");
                    GlobDispatchcallLog gdcl = toGlobDispatchcallLog(dbo, woIt, createBy, headerUser, null, "update");
                    workorderService.update(woDb);
                    dispatchCallLogService.update(gdcl);
                    dispatchId = gdcl.getId().toBigInteger();
                }
                if (dispatchServicesService.getCountCallLogRecords(dispatchId) > 0) {
                    dispatchServicesService.deleteAllByCallLogId(dispatchId);
                }
                List<GlobDispatchcallServices> lserv = toGlobDispatchcallServices(woIt, headerUser, dispatchId);
                dispatchServicesService.saveAll(lserv);
            }
        } catch (ParseException ex) {
            Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Convert to WorkOrderTO
     *
     * @param calllog
     * @param wo
     * @param servList
     * @return WorkOrderTO
     * @throws ParseException
     */
    private WorkOrderTO toWorkOrderTO(GlobDispatchcallLog calllog, GlobWorkorder wo, List<GlobDispatchcallServices> servList) throws ParseException {
        WorkOrderTO woTo = new WorkOrderTO();
        woTo.setLogId(calllog.getId().toBigInteger());
        woTo.setWoId(wo.getId().toBigInteger());
        woTo.setHours(calllog.getHours());
        woTo.setSpecialinstruction(calllog.getSpecInstr());
        woTo.setTechRefId(calllog.getTechRefId());
        woTo.setTechFullName(calllog.getTechnician());
        woTo.setDecisionFlag(calllog.getDecisionFlag());
        woTo.setServiceDate(DateSupport.formatDate(calllog.getServiceDate(), DateSupport.FORMAT_REVERSE_MD));
        woTo.setPaperworkReceived(String.valueOf(calllog.getPaperworkReceived()));
        woTo.setAssigment(calllog.getAssignment());
        woTo.setInfo_id(calllog.getInfoId());
        woTo.setWonumber(wo.getWoNo());
        woTo.setContactperson(wo.getContact());
        woTo.setContactrefId(wo.getContactRefId());
        woTo.setContacttelephone(wo.getContactTelephone());
        woTo.setTimeatoffice(DateSupport.formatString(wo.getArriveLabTime(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
        woTo.setTimeatsite(DateSupport.formatString(calllog.getTimeSite(), DateSupport.factorySimpleDateFormat("HH:mm"), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")));
        woTo.setIscancel(wo.getCancelled().toLowerCase().equals("yes") ? Boolean.TRUE : Boolean.FALSE);
        woTo.setCertification(wo.getCertification());

        servList.forEach((svList) -> {
            if (svList.getType().equals(eServiceType.eEng.getValue())) {
                woTo.addEngService(new EngServiceTO(svList.getServiceDesc()));
            } else if (svList.getType().equals(eServiceType.eField.getValue())) {
                woTo.addFieldService(new FieldServiceTO(NumberSupport.getBigInteger(svList.getService())));
            } else if (svList.getType().equals(eServiceType.eLab.getValue())) {
                GlobServicesLab lbsrv = labService.findById(svList.getService());
                woTo.addLabService(new LabServiceTO(NumberSupport.getBigInteger(svList.getService()), lbsrv.getLabCategoryId()));
            }
        });
        woTo.setServiceList(calllog.getServicesRequested());
        woTo.setTraceDescription(cmContractActivity.getActivityName(wo.getActivityId(), "nd"));
        woTo.setRlocation(cmDailyLocationService.getDailyLocation(calllog.getReqLocation()));

        return woTo;
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
    private GlobWorkorder toGlobWorkorder(Bpmdispatchbo dbo, WorkOrderTO wo, String headerUser, String action) throws ParseException {
        log.info("Parsing from WorkOrderTO to GlobWorkorder");
        GlobWorkorder rp = new GlobWorkorder();
        BigInteger projectId = NumberSupport.getBigInteger(dbo.getProjectId());
        String won;
        if (action.equals("insert")) {
            won = workorderService.getNextWorkOrderNumber(projectId);

            if (won == null || won.isEmpty()) {
                log.error("We could not get the next wo number.");
                return null;
            }

            rp.setWoNo(won);
            rp.setWoShort(NumberSupport.getBigInteger(won));
            rp.setWoLong(won);
            rp.setCreateDate(new Date());
            rp.setCreateByIp("127.0.0.1");
            rp.setCreateBy(headerUser);
        } else if (action.equals("update")) {
            rp.setId(new BigDecimal(wo.getWoId()));
        }

        rp.setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_REVERSE_MD));
        if (wo.getContactrefId() != null) {
            rp.setContact(contactService.findById(wo.getContactrefId().toString()).getFullName());
            rp.setContactRefId(wo.getContactrefId());
        }

        rp.setArriveLabTime(DateSupport.formatString(wo.getTimeatoffice(), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), DateSupport.factorySimpleDateFormat("HH:mm")));
        rp.setActive('Y');
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setCertification(wo.getCertification());

        if (dbo.getIscancel() == 1) {
            rp.setCancelled("Yes");
        } else {
            if (wo.getIscancel()) {
                rp.setCancelled("Yes");
            } else {
                rp.setCancelled("No");
            }
        }
        rp.setContactTelephone(wo.getContacttelephone());
        rp.setProjectId(projectId);
        // ERROR PARSE to BIGINTIGER N/A
        rp.setActivityId((dbo.getActivityId() != null && !dbo.getActivityId().isEmpty() && dbo.getActivityId().equals("-1")) ? null : NumberSupport.getBigInteger(dbo.getActivityId()));
        rp.setLastModBy(headerUser);
        rp.setLastModIp("127.0.0.1");
        rp.setVersion("1");
        rp.setWoToken(UUID.randomUUID().toString());
        log.info("GlobWorkorder Generated");
        return rp;
    }

    /**
     * Convert
     *
     * @param dbo
     * @param wo
     * @param createBy
     * @param headerUser
     * @param woId
     * @param action
     * @return GlobDispatchcallLog
     * @throws ParseException
     */
    private GlobDispatchcallLog toGlobDispatchcallLog(Bpmdispatchbo dbo, WorkOrderTO wo, String createBy, String headerUser, BigInteger woId, String action) throws ParseException {
        log.info("Generating GlobDispatchcallLog");
        GlobDispatchcallLog rp = new GlobDispatchcallLog();
        BigInteger projectId = NumberSupport.getBigInteger(dbo.getProjectId());
        if (action.equals("update")) {
            rp.setId(new BigDecimal(wo.getLogId()));
        }
        rp.setServiceDate(DateSupport.parseString(wo.getServiceDate(), DateSupport.FORMAT_REVERSE_MD));
        rp.setProjectId(projectId);
        rp.setServicesRequested(buildStringServicesRequested(wo));
        rp.setTimeSite(DateSupport.formatString(wo.getTimeatsite(), DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"), DateSupport.factorySimpleDateFormat("HH:mm")));
        rp.setHours(wo.getHours());
        rp.setTechnician(contactService.findById(wo.getTechRefId().toString()).getFullName());
        if (woId != null) {
            GlobWorkorder bwoId = workorderService.findById(woId.toString());
            rp.setWoId(bwoId);
        }
        if (wo.getIscancel()) {
            rp.setCancelled("Yes");
        } else {
            rp.setCancelled("No");
        }
        rp.setSpecInstr(wo.getSpecialinstruction());
        rp.setRequestedBy(dbo.getRequestedBy());
        rp.setRequestedTime(DateSupport.formatString(dbo.getCreated(), DateSupport.FORMAT_MMDDYY_HHMMA, DateSupport.factorySimpleDateFormat("HH:mm")));
        rp.setActive('Y');
        rp.setCreateBy(createBy);
        rp.setCreateByIp("127.0.0.1");
        rp.setLastModIp("127.0.0.1");
        rp.setLastModBy(headerUser);
        rp.setVersion("1");
        rp.setRequestedDate(DateSupport.formatString(dbo.getDatetimereqOnjobsite(), DateSupport.FORMAT_MMDDYY_HHMMA, DateSupport.FORMAT_US_DASH));
        rp.setLastMod(DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
        rp.setCreateDate(DateSupport.parseString(dbo.getDatetimereqOnjobsite(), DateSupport.FORMAT_MMDDYY_HHMMA));
        rp.setPaperworkReceived(wo.getPaperworkReceived() == null ? 'N' : wo.getPaperworkReceived().charAt(0));
        rp.setAssignment(wo.getAssigment());
        rp.setInfoId(wo.getInfo_id());
        rp.setTechRefId(wo.getTechRefId());
        rp.setDecisionFlag(wo.getDecisionFlag());
        rp.setRequestOrigId(dbo.getPersistenceid().toBigInteger());
        rp.setReqLocation(dbo.getRequestLocation());
        log.info("Generated GlobDispatchcallLog");
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
    private List<GlobDispatchcallServices> toGlobDispatchcallServices(WorkOrderTO wo, String headerUser, BigInteger dispatchId) {
        List<GlobDispatchcallServices> rpl = new ArrayList<>();
        BigInteger counter = BigInteger.ZERO;

        for (EngServiceTO it : wo.getEngService()) {
            if (it != null && StringSupport.isNotNullAndNotEmpty(it.getTypeofservice())) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, null, it.getTypeofservice(), eServiceType.eEng.getValue(), headerUser, "127.0.0.1", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (FieldServiceTO it : wo.getFieldService()) {
            if (it != null && it.getServiceId() != null) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, it.getServiceId().toString(), null, eServiceType.eField.getValue(), headerUser, "127.0.0.1", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        for (LabServiceTO it : wo.getLabService()) {
            if (it != null && it.getTestTypeId() != null) {
                rpl.add(new GlobDispatchcallServices(dispatchId, counter, it.getTestTypeId().toString(), null, eServiceType.eLab.getValue(), headerUser, "127.0.0.1", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS)));
                counter = counter.add(BigInteger.ONE);
            }
        }

        return rpl;
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
     * Build String Services Requested
     *
     * @param wo
     * @return String
     */
    private String buildStringServicesRequested(WorkOrderTO wo) {
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
     * Get Technicians Answered Status
     *
     * @param persistenceId
     * @return Integer
     */
    @Override
    public Integer getTechniciansAnsweredStatus(String persistenceId) {
        int approved = 0;
        if (persistenceId != null && !persistenceId.isEmpty()) {
            Bpmdispatchbo dbo = findById(persistenceId);
            if (dbo != null) {
                List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(persistenceId));
                int size = reqLogList.size();
                if (size == 0) {
                    return 2;
                }

                for (GlobDispatchcallLog dcl : reqLogList) {
                    if (dcl.getCancelled().equals("No")) {
                        if (dcl.getDecisionFlag() == 1L) {
                            approved++;
                        }
                        if (dcl.getDecisionFlag() == 0L) {
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
     * Notify Technicians
     *
     * @param persistenceId
     * @param server_domain
     * @param engine
     */
    @Override
    public void notifyTechnicians(String persistenceId, String server_domain, TemplateEngine engine) {
        if (persistenceId != null && !persistenceId.isEmpty()) {
            Bpmdispatchbo dbo = findById(persistenceId);
            if (dbo != null) {
                GlobProject project = projectService.findById(dbo.getProjectId());
                List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(persistenceId));
                reqLogList.forEach((dcl) -> {
                    //GlobWorkorder wo = workorderService.findById(dcl.getWoId().toString());
                    GlobWorkorder wo = dcl.getWoId();
                    notifyTechnician(persistenceId, server_domain, engine, dbo, dcl, wo, project);
                    notifyCcContactPerson(persistenceId, server_domain, engine, dbo, dcl, wo, project);
                });
            }
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
    private void notifyCcContactPerson(String persistenceId, String server_domain, TemplateEngine engine, Bpmdispatchbo dbo, GlobDispatchcallLog dcl, GlobWorkorder wo, GlobProject project) {
        Boolean isCancel = (dbo.getIscancel() == 0 && wo.getCancelled().equals("Yes"));

        if (!isCancel && dcl.getDecisionFlag() > 0L) {
            return;
        }
        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom("wwwmail@atser.com");
        String contactEmail = null;
        if (wo.getContactRefId() != null) {
            contactEmail = contactService.findById(wo.getContactRefId().toString()).getEmail();
        }
        if (contactEmail == null || contactEmail.isEmpty()) {
            return;
        }

        // Variable Map
        Map<String, Object> map = new HashMap<>();
        if (!isCancel) {
            msg.setSubject("Dispatch Request - Work Assignment");
        } else {
            msg.setSubject("Dispatch Request - Work Assignment was cancelled");
        }

        msg.setStatus("SENDED");
        msg.setToken(null);
        msg.setRefId(persistenceId);
        msg.setTo(new String[]{contactEmail});

        map.put("vTechName", dcl.getTechnician());
        map.put("showButtons", Boolean.FALSE);
        map.put("isCancel", isCancel);
        map.put("vTitle", dbo.getRequestName());
        map.put("vProjectName", project.getPName());
        map.put("vWoNo", wo.getWoNo());
        map.put("vRequestedBy", dbo.getRequestedBy());
        map.put("vServicesRequested", dcl.getServicesRequested());
        map.put("vServiceDate", DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US));
        map.put("vArriveLabTime", wo.getArriveLabTime());
        map.put("vTimeSite", dcl.getTimeSite());
        map.put("vQuantity", (dbo.getReqQty() == null || dbo.getReqQty().isEmpty()) ? "N/A" : dbo.getReqQty());
        map.put("vBatchPlant", (dbo.getBatchPlant() == null || dbo.getBatchPlant().isEmpty()) ? "N/A" : dbo.getBatchPlant());
        map.put("vRequestDescription", dbo.getRequestDescription());
        map.put("vSpecialInstructions", dcl.getSpecInstr());
        map.put("vURLDownloadWO", "https://" + server_domain + "/ws/rs/bpm/dispatch/generate/workorder/external?t=" + wo.getWoToken());

        final Context ctx = new Context(Locale.ENGLISH);
        ctx.setVariables(map);

        final String emailBody = engine.process("Dispatch/email-techNotification.html", ctx);
        if (emailBody != null && !emailBody.isEmpty()) {
            msg.setMessageText(emailBody);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
            return;
        }

        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

        if (status) {
            ntfTrackService.save("bpm", "dispatch", msg);
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
    private void notifyTechnician(String persistenceId, String server_domain, TemplateEngine engine, Bpmdispatchbo dbo, GlobDispatchcallLog dcl, GlobWorkorder wo, GlobProject project) {
        Boolean isCancel = (dbo.getIscancel() == 0 && wo.getCancelled().equals("Yes"));

        if (!isCancel && dcl.getDecisionFlag() > 0L) {
            return;
        }

        BpmMailMessage msg = new BpmMailMessage();
        msg.setFrom("wwwmail@atser.com");
        String techEmail = contactService.findById(dcl.getTechRefId().toString()).getEmail();
        if (techEmail == null || techEmail.isEmpty()) {
            return;
        }

        // Variable Map
        Map<String, Object> map = new HashMap<>();
        String token = UUID.randomUUID().toString().replace("-", "");
        if (!isCancel) {
            msg.setSubject("Dispatch Request - Work Assignment");
            msg.setStatus("WAITING");
            msg.setToken(token);
        } else {
            msg.setSubject("Dispatch Request - Work Assignment was cancelled");
            msg.setStatus("SENDED");
            msg.setToken(null);
        }

        msg.setRefId(persistenceId);
        msg.setTo(new String[]{techEmail});

        map.put("vTechName", dcl.getTechnician());
        map.put("showButtons", !isCancel);
        map.put("isCancel", isCancel);
        map.put("vTitle", dbo.getRequestName());
        map.put("vProjectName", project.getPName());
        map.put("vWoNo", wo.getWoNo());
        map.put("vRequestedBy", dbo.getRequestedBy());
        map.put("vServicesRequested", dcl.getServicesRequested());
        map.put("vServiceDate", DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US));
        map.put("vQuantity", (dbo.getReqQty() == null || dbo.getReqQty().isEmpty()) ? "N/A" : dbo.getReqQty());
        map.put("vBatchPlant", (dbo.getBatchPlant() == null || dbo.getBatchPlant().isEmpty()) ? "N/A" : dbo.getBatchPlant());
        map.put("vArriveLabTime", wo.getArriveLabTime());
        map.put("vTimeSite", dcl.getTimeSite());
        map.put("vRequestDescription", dbo.getRequestDescription());
        map.put("vSpecialInstructions", dcl.getSpecInstr());
        map.put("vURLYes", "https://" + server_domain + "/ws/rs/form/dispatch/technician?t=" + token + "&r=Y&k=" + dcl.getId());
        map.put("vURLNo", "https://" + server_domain + "/ws/rs/form/dispatch/technician?t=" + token + "&r=N&k=" + dcl.getId());
        map.put("vURLDownloadWO", "https://" + server_domain + "/ws/rs/bpm/dispatch/generate/workorder/external?t=" + wo.getWoToken());

        final Context ctx = new Context(Locale.ENGLISH);
        ctx.setVariables(map);

        final String emailBody = engine.process("Dispatch/email-techNotification.html", ctx);
        if (emailBody != null && !emailBody.isEmpty()) {
            msg.setMessageText(emailBody);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
            return;
        }

        Boolean status = MailSender.sendEmailDefault(mailSession, msg);

        if (status) {
            ntfTrackService.save("bpm", "dispatch", msg);
        }
    }

    @Override
    public String generateCalendarReport(String tplbasePath, String tplpath, String docpathsegment, ManageITBodyRequest<Object> request) {
        AtserLinkedHashMap<String, Object> params = request.getParams();
        Map<String, Object> paramsJasper = new HashMap<>();
        paramsJasper.put("SUB_RPT_DATES", FileSupport.FicheroAByteArrayIS(tplbasePath + "calendar/dispatch_agenda_dates.jasper"));
        paramsJasper.put("SUB_RPT_WO", FileSupport.FicheroAByteArrayIS(tplbasePath + "calendar/dispatch_agenda_workorders.jasper"));

        String docType = params.get("docType").toString();

        GlobProject project = projectService.findById(StringSupport.emptyOnNull(request.getParams().get("projectId")));
        paramsJasper.put("PROJECT_LOGO", genericHelperService.getClientLogo(project));

        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }

        // Get Data for Build the TO
        List<CalendarResourceTO> rList = buildDispatchCalendarResources(request);
        List<CalendarResourcesDataTO> rData = buildDispatchCalendar(request);

        // Fill Calendar WO TO
        List<CalendarResourcesTO> rListResource = new ArrayList<>();

        rList.forEach(rIt -> {
            List<CalendarResourcesDataTO> tmpData = rData.stream().filter((robj) -> (robj.getOwnerId().equals(rIt.getId()))).collect(Collectors.toList());
            if (!tmpData.isEmpty()) {
                CalendarResourcesTO crTo = new CalendarResourcesTO(rIt.getId(), rIt.getText());
                crTo.buildCalendarDates(tmpData);
                rListResource.add(crTo);
            }
        });

        String targetPath = docpathsegment + "CalendarReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, rListResource, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            Logger.getLogger(BpmDispatchServiceImpl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Calendar Resources
     *
     * @param request
     * @return List<CalendarResourceTO>
     */
    @Override
    public List<CalendarResourceTO> buildDispatchCalendarResources(ManageITBodyRequest<Object> request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "resourceFilter", "roleFilter"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        BigInteger projectId = NumberSupport.getBigInteger(request.getParams().get("projectId").toString());
        String rFilter = StringSupport.emptyOnNull(request.getParams().get("resourceFilter"));

        List<String> pWithWO = projPersonnelService.getPersonnelIdWithWO(projectId);

        ManageITBodyRequest searchBuilderTeamRoster = new ManageITBodyRequest(0, 0);
        searchBuilderTeamRoster.filter("projectId", projectId).filter("showdispatch", "Y").filter("active", "Y").filter("contactId.id", pWithWO, ":=");

        if (rFilter != null && !rFilter.isEmpty() && !rFilter.equals("null")) {
            searchBuilderTeamRoster.filter("contactId.id", rFilter, ":=");
        }

        searchBuilderTeamRoster.sorted("id", "asc");

        List<GlobProjectPersonnel> teamRoster = projPersonnelService.list(searchBuilderTeamRoster);
        List<CalendarResourceTO> rsList = teamRoster.stream().map(p -> new CalendarResourceTO(p.getContactId().getId().toString(), p.getContactId().getFullName())).collect(Collectors.toList());

        return rsList;
    }

    /**
     * Dispatch Calendar Parameters: projectId : Is the Project Selected.
     * CurrentAction: [Load, Previous, ViewChange,DateNavigation]. CurrentDate:
     * Selected date. CurrentView: [agenda, month,week, day]
     *
     * @param request
     * @return List<CalendarResourcesDataTO>
     */
    @Override
    public List<CalendarResourcesDataTO> buildDispatchCalendar(ManageITBodyRequest<Object> request) {
        if (!request.getParams().isContainsAllKeys(new String[]{"projectId", "CurrentDate", "CurrentView"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        Boolean activeInspector = true;
        Boolean activeTechnician = true;

        BigInteger projectId = NumberSupport.getBigInteger(request.getParams().get("projectId").toString());
        String currentAction = request.getParams().get("CurrentAction").toString();
        String currentDate = request.getParams().get("CurrentDate").toString();
        String currentView = request.getParams().get("CurrentView").toString();
        String locationFilter = StringSupport.emptyOnNull(request.getParams().get("locationFilter"));
        String traceFilter = StringSupport.emptyOnNull(request.getParams().get("traceFilter"));
        String poFilter = StringSupport.emptyOnNull(request.getParams().get("roleFilter"));
        List<String> oFilter = null;

        if (poFilter != null && !poFilter.isEmpty() && !poFilter.equals("null")) {
            oFilter = Arrays.asList(poFilter.split(","));
        }

        if (oFilter != null && oFilter.size() == 1) {
            if (oFilter.contains("inspector")) {
                activeInspector = true;
                activeTechnician = false;
            } else if (oFilter.contains("technician")) {
                activeInspector = false;
                activeTechnician = true;
            }
        } else {
            activeInspector = true;
            activeTechnician = true;
        }

        List<CalendarResourcesDataTO> calData = new ArrayList<>();
        List<CalendarResourceTO> rsList = buildDispatchCalendarResources(request);
        ManageITBodyRequest searchBuilderWO = buildCalendarFilter(projectId, currentDate, currentView);
        ManageITBodyRequest searchBuilderInspWO = buildCalendarFilter(projectId, currentDate, currentView);

        if (activeTechnician) {
            if (locationFilter != null && !locationFilter.isEmpty() && !locationFilter.equals("null")) {
                searchBuilderWO.filter("reqLocation", locationFilter, ":=");
            }
            if (traceFilter != null && !traceFilter.isEmpty() && !traceFilter.equals("null")) {
                searchBuilderWO.filter("woId.activityId", traceFilter, ":=");
            }
            List<WorkOrderTO> woList = dispatchCallLogService.listTo(searchBuilderWO);
            rsList.stream().filter((it) -> (it.getId() != null && !it.getId().isEmpty())).forEachOrdered((it) -> {
                List<CalendarResourcesDataTO> prtCalData = woList.stream()
                        .filter(p -> (p.getTechRefId() != null && p.getTechRefId().compareTo(NumberSupport.getBigInteger(it.getId())) == 0))
                        .map(p -> new CalendarResourcesDataTO(p.getWonumber(), "WO # " + p.getWonumber(), buildCalendarDescription(p.getServiceList(), p.getSpecialinstruction()), p.getServiceDate(), p.getTimeatsite(), p.getHours().toString(), it.getId(), "1", p.getTraceDescription(), p.getRlocation(), p.getSpecialinstruction()))
                        .collect(Collectors.toList());
                calData.addAll(prtCalData);
            });
        }
        if (activeInspector) {
            if (locationFilter != null && !locationFilter.isEmpty() && !locationFilter.equals("null")) {
                searchBuilderInspWO.filter("inspdispatchid.requestLocation", locationFilter, ":=");
            }
            if (traceFilter != null && !traceFilter.isEmpty() && !traceFilter.equals("null")) {
                searchBuilderInspWO.filter("activityId", traceFilter, ":=");
            }
            List<InspWorkOrderTO> inspwoList = inspWoService.listTo(searchBuilderInspWO);
            rsList.stream().filter((it) -> (it.getId() != null && !it.getId().isEmpty())).forEachOrdered((it) -> {
                List<CalendarResourcesDataTO> prtInspCalData = inspwoList.stream()
                        .filter(p -> (p.getInspRefId() != null && p.getInspRefId().compareTo(NumberSupport.getBigInteger(it.getId())) == 0))
                        .map(p -> new CalendarResourcesDataTO(p.getWonumber(), "WO # " + p.getWonumber(), buildCalendarDescription(p.getServiceList(), p.getSpecialinstruction()), p.getServiceDate(), p.getTimeatsite(), p.getHours().toString(), it.getId(), "2", p.getTraceDescription(), p.getRlocation(), p.getSpecialinstruction()))
                        .collect(Collectors.toList());
                calData.addAll(prtInspCalData);
            });
        }
        return calData;
    }

    public String buildCalendarDescription(String services, String instructions) {
        StringBuilder result = new StringBuilder();
        result.append("Services Requested:\n");
        result.append(services);
        result.append("\n\nSpecial Instructions:\n");
        result.append(instructions);
        return result.toString();
    }

    public ManageITBodyRequest buildCalendarFilter(BigInteger projectId, String currentDate, String currentView) {
        ManageITBodyRequest searchBuilderWO = new ManageITBodyRequest(0, 0);
        searchBuilderWO.filter("projectId", projectId).filter("active", "Y").filter("cancelled", "No").sorted("id", "asc");
        // Format: MM-dd-YYYY
        switch (currentView) {
            case "agenda": {
                try {
                    String initDate = DateSupport.formatString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"), DateSupport.FORMAT_US_DASH);
                    String endDate = DateSupport.formatDate(DateSupport.addChronoUnitToDate(DateSupport.parseString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'")), ChronoUnit.DAYS, 7), DateSupport.FORMAT_US_DASH);
                    searchBuilderWO.filter("serviceDate", initDate, ">");
                    searchBuilderWO.filter("serviceDate", endDate, "<");
                } catch (ParseException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                }
                break;
            }
            case "month": {
                try {
                    String initDate = DateSupport.formatDate(DateSupport.getFirstDayOfMonth(DateSupport.parseString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                    String endDate = DateSupport.formatDate(DateSupport.getLastDayOfMonth(DateSupport.parseString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                    searchBuilderWO.filter("serviceDate", initDate, ">");
                    searchBuilderWO.filter("serviceDate", endDate, "<");
                } catch (ParseException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                }
                break;
            }
            case "week": {
                try {
                    String initDate = DateSupport.formatDate(DateSupport.getFirstDayOfWeek(DateSupport.parseString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                    String endDate = DateSupport.formatDate(DateSupport.getLastDayOfWeek(DateSupport.parseString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"))), DateSupport.FORMAT_US_DASH);
                    searchBuilderWO.filter("serviceDate", initDate, ">");
                    searchBuilderWO.filter("serviceDate", endDate, "<");
                } catch (ParseException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                }
                break;
            }
            case "day": {
                try {
                    String initDate = DateSupport.formatString(currentDate, DateSupport.factorySimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'"), DateSupport.FORMAT_US_DASH);
                    searchBuilderWO.filter("serviceDate", initDate, "=");
                } catch (ParseException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong Date Format.");
                }
                break;
            }
        }

        return searchBuilderWO;
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
        List<Bpmdispatchbo> dlist = dao.findAll();
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
    private List<IReportSyncfusion> buildReportPieByStatus(List<Bpmdispatchbo> dlist) {
        List<IReportSyncfusion> report = new ArrayList<>();
        if (dlist.isEmpty()) {
            return report;
        }
        Predicate<Bpmdispatchbo> predicateDraft = s -> s.getStatus().equals("Draft");
        Predicate<Bpmdispatchbo> predicateClosed = s -> (s.getStatus().equals("Closed") && s.getIscancel() != 1 && (s.getFinaldisposition() != null && !s.getFinaldisposition().equals("DISPATCH REJECTED")));
        Predicate<Bpmdispatchbo> predicateRevision = s -> s.getStatus().equals("In Progress");
        Predicate<Bpmdispatchbo> predicateCancel = s -> (s.getStatus().equals("Closed") && s.getIscancel() == 1);
        Predicate<Bpmdispatchbo> predicateRejected = s -> (s.getStatus().equals("Closed") && (s.getFinaldisposition() != null && s.getFinaldisposition().equals("DISPATCH REJECTED")));
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
    private List<IReportSyncfusion> buildReportColumTaskSource(List<Bpmdispatchbo> dlist, Map<String, String> paramsMap) {
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
    private List<ReportPointsTO> buildColumsPointsTaskSource(List<Bpmdispatchbo> dlist, Integer year, String filter) {
        List<ReportPointsTO> points = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);
        int month = date.getMonthValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm a");

        for (int currentMonth = month; currentMonth <= 12; currentMonth++) {
            date = date.withMonth(currentMonth);
            LocalDate firstDay = date.withDayOfMonth(1);
            LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
            Predicate<Bpmdispatchbo> predicateSystem = (s -> s.getRequestSource().equals(filter) && (LocalDate.parse(s.getCreated(), formatter).compareTo(lastDay) <= 0 && LocalDate.parse(s.getCreated(), formatter).compareTo(firstDay) >= 0));
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
    private List<IReportSyncfusion> buildReportChartLineEfficiency(List<Bpmdispatchbo> dlist, Map<String, String> paramsMap) {
        List<IReportSyncfusion> report = new ArrayList<>();
        if (dlist.isEmpty()) {
            return report;
        }
        String sdate = DateSupport.getNowToFormat("yyyy-MM");
        if (paramsMap != null) {
            sdate = paramsMap.get("date");
        }

        if (sdate != null && !sdate.isEmpty() && sdate.contains("-")) {
            report.add(new ReportColumsTO(buildLinePointsEfficiency(dlist, sdate), "Dispatch Process"));
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
    private List<ReportPointsTO> buildLinePointsEfficiency(List<Bpmdispatchbo> dlist, String sdate) {
        List<ReportPointsTO> points = new ArrayList<>();
        Integer year = Integer.valueOf(sdate.split("-")[0]);
        Integer month = Integer.valueOf(sdate.split("-")[1]);
        LocalDate date = LocalDate.of(year, month, 1);
        DateTimeFormatter formatterDoneDate = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        List<Bpmdispatchbo> dlistClosed = dlist.stream().filter(d -> d.getStatus().equals("Closed") && d.getIscancel() != 1 && (d.getFinaldisposition() != null && !d.getFinaldisposition().isEmpty()) && (LocalDate.parse(d.getDoneDate(), formatterDoneDate).format(DateTimeFormatter.ofPattern("yyyy-MM")).equals(sdate))).collect(Collectors.toList());
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());

        for (int currentDay = 1; currentDay <= Integer.valueOf(lastDay.format(DateTimeFormatter.ofPattern("d"))); currentDay++) {
            LocalDate localdate = date.withDayOfMonth(currentDay);
            Predicate<Bpmdispatchbo> predicateDay = (s -> LocalDate.parse(s.getDoneDate(), formatterDoneDate).isEqual(localdate));
            Long count = dlistClosed.stream().filter(predicateDay).count();
            points.add(new ReportPointsTO(localdate.format(DateTimeFormatter.ofPattern("yyyy-M-d")), count));
        }

        return points;
    }

    /**
     * Get Mix Design Name
     *
     * @param id
     * @return String
     */
    private String getMixDesignName(String id) {
        String mixDesignText = "N/A";
        if (id != null && !id.isEmpty() && !id.equals("-1")) {
            QaconcMixdesigns qaCMixObj = qaconcMixdesignsService.findById(id);
            if (qaCMixObj != null) {
                mixDesignText = qaCMixObj.getMixDesign();
            }
        }
        return mixDesignText;
    }

    /**
     * Generate Wo Report By Filter
     *
     * @param session
     * @param tplpath
     * @param docpathsegment
     * @param type
     * @param idArray
     * @return String
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    @Override
    public String generateWoReportByFilter(BonitaBpmSupport session, String tplpath, String docpathsegment, String type, String[] idArray) throws IOException, BonitaException, Exception {
        Map<String, Object> paramsJasper = new HashMap<>();

        eDocExtension extension;
        if (type == null || type.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(type);
        }

        List<DispatchPrintWOPojo> dwo = new ArrayList<>();

        for (String string : idArray) {
            DispatchPrintWOPojo response = generateWOPojo(string);
            if (Objects.nonNull(response)) {
                dwo.add(response);
            }
        }

        if (!dwo.isEmpty()) {
            String targetPath = docpathsegment + "WorkOrderReport_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
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

    /**
     * Generate External Wo Report
     *
     * @param session
     * @param tplpath
     * @param docpathsegment
     * @param woToken
     * @param docType
     * @return String
     * @throws IOException
     * @throws BonitaException
     * @throws Exception
     */
    @Override
    public String generateExternalWoReport(BonitaBpmSupport session, String tplpath, String docpathsegment, String woToken, String docType) throws IOException, BonitaException, Exception {
        GlobWorkorder wo = workorderService.findByWoToken(woToken);
        if (wo == null) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }

        GlobDispatchcallLog reqLog = dispatchCallLogService.findByWOID(wo.getId().toBigInteger());

        return generateWO(session, tplpath, docpathsegment, reqLog.getId().toString(), docType);
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

        List<DispatchPrintWOPojo> dwo = new ArrayList<>();

        DispatchPrintWOPojo response = generateWOPojo(logId);

        if (Objects.nonNull(response)) {
            dwo.add(response);
            String targetPath = docpathsegment + "WorkOrderReport_" + response.getWoNo() + "_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
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

    /**
     * Generate WO Pojo
     *
     * @param logId
     * @return DispatchPrintWOPojo
     */
    private DispatchPrintWOPojo generateWOPojo(String logId) {
        DispatchPrintWOPojo response = null;
        if (logId == null || logId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        GlobDispatchcallLog reqLog = dispatchCallLogService.findById(logId);
        GlobProject project = projectService.findById(StringSupport.emptyOnNull(reqLog.getProjectId()));
        String PMFullName = "";
        if (project.getPersonProjectManager() != null) {
            GlobContact projectManager = contactService.findById(project.getPersonProjectManager().toString());
            PMFullName = projectManager.getFullName();
        }

        String clientId, reqQty, mixDesigId, batchPlant, rlocation;

        if (reqLog.getRequestOrigId() != null) {
            Bpmdispatchbo dbo = findById(reqLog.getRequestOrigId().toString());
            clientId = dbo.getClientId();
            reqQty = dbo.getReqQty();
            mixDesigId = getMixDesignName(dbo.getMixDesign());
            batchPlant = dbo.getBatchPlant();
            rlocation = cmDailyLocationService.getDailyLocation(dbo.getRequestLocation());
        } else {
            clientId = project.getClientId().getId().toString();
            reqQty = "";
            mixDesigId = "";
            batchPlant = "";
            rlocation = "N/A";
        }

        BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
        if (Objects.nonNull(project)) {
            //GlobWorkorder wo = workorderService.findById(reqLog.getWoId().toString());
            GlobWorkorder wo = reqLog.getWoId();
            Boolean isCancel = wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("yes");
            response = new DispatchPrintWOPojo(reqLog.getTechnician(), DateSupport.formatDate(reqLog.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")),
                    wo.getArriveLabTime(), reqLog.getTimeSite(), reqLog.getRequestedBy(), DateSupport.formatDate(reqLog.getCreateDate(), DateSupport.FORMAT_MMDDYY_HHMMA), PMFullName, project.getName(), wo.getWoNo(), wo.getContact(),
                    wo.getContactTelephone(), project.getPName(), reqLog.getServicesRequested(), reqLog.getSpecInstr(), reqQty, mixDesigId, batchPlant, projectLogoImage, cmContractActivity.getActivityName(wo.getActivityId(), "n"), isCancel, wo.getCertification(),
                    rlocation);
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

        Bpmdispatchbo dbo = findById(persistenceId);
        if (Objects.nonNull(dbo)) {
            String targetPath = docpathsegment + "WorkOrderReport_" + dbo.getRequestnumber() + "_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
            String projectId = StringSupport.emptyOnNull(dbo.getProjectId());
            GlobProject project = projectService.findById(projectId);
            String PMFullName = "";
            if (project.getPersonProjectManager() != null) {
                GlobContact projectManager = contactService.findById(project.getPersonProjectManager().toString());
                PMFullName = projectManager.getFullName();
            }
            BufferedImage projectLogoImage = genericHelperService.getClientLogo(project);
            if (Objects.nonNull(project)) {
                List<DispatchPrintWOPojo> dwo = new ArrayList<>();
                List<GlobDispatchcallLog> reqLogList = dispatchCallLogService.findByRequestOrigID(NumberSupport.getBigInteger(persistenceId));

                for (GlobDispatchcallLog dcl : reqLogList) {
                    //GlobWorkorder wo = workorderService.findById(dcl.getWoId().toString());
                    GlobWorkorder wo = dcl.getWoId();
                    Boolean isCancel = wo.getCancelled() != null && wo.getCancelled().toLowerCase().equals("yes");
                    dwo.add(new DispatchPrintWOPojo(dcl.getTechnician(), DateSupport.formatDate(dcl.getServiceDate(), DateSupport.factorySimpleDateFormat("EEE, MMM d, yyyy")),
                            wo.getArriveLabTime(), dcl.getTimeSite(), dbo.getRequestedBy(), dbo.getCreated(), PMFullName, project.getName(), wo.getWoNo(), wo.getContact(),
                            wo.getContactTelephone(), project.getPName(), dcl.getServicesRequested(), dcl.getSpecInstr(), dbo.getReqQty(), getMixDesignName(dbo.getMixDesign()), dbo.getBatchPlant(), projectLogoImage,
                            cmContractActivity.getActivityName(dbo.getActivityId(), "n"), isCancel, wo.getCertification(), cmDailyLocationService.getDailyLocation(dbo.getRequestLocation())));
                }

                paramsJasper.put("listWo", dwo);

                BuildJasper pdf = new BuildJasper();
                try {
                    targetPath = pdf.exportDocument(tplpath, paramsJasper, targetPath, extension.getValue());
                    return targetPath;

                } catch (Exception ex) {
                    Logger.getLogger(BpmDispatchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    /**
     * Send Email
     *
     * @param engine
     * @param request
     * @param cc
     * @param isbpmTrackEnable
     */
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

    /**
     * Factory Email Helper
     *
     * @param engine
     * @param action
     * @param pmsg
     * @param params
     * @return
     */
    private BpmMailMessage factoryEmailByTask(TemplateEngine engine, String action, BpmMailMessage pmsg, AtserLinkedHashMap<String, Object> params) {
        Bpmdispatchbo dbo = findById(pmsg.getRefId());
        BpmMailMessage rmsg = new BpmMailMessage();
        Map<String, Object> map = new HashMap<>();
        rmsg.setRefId(pmsg.getRefId());
        rmsg.setFrom("wwwmail@atser.com");
        rmsg.setTo(pmsg.getTo());
        if (dbo != null) {
            map.put("vReqObject", dbo);
            switch (action) {
                case "Task1.ReviewRequest": {
                    rmsg.setSubject("Dispatch Request - Pending Task Notification");
                    map.put("vEmailTo", "Dispatchers");
                    map.put("vFooter", "This email is to notify you that there are pending tasks that should be addressed, please review them.");
                    map.put("vEmailTask", "Review Dispatch Request");
                    break;
                }
                case "Task2.CompleteRequest": {
                    rmsg.setSubject("Dispatch Request - Pending Task Notification");
                    map.put("vEmailTo", "QA Managers");
                    map.put("vFooter", "This email is to notify you that there are pending tasks that should be addressed, please review them.");
                    map.put("vEmailTask", "Complete Dispatch Request");
                    break;
                }
                case "QATaskCancelled": {
                    rmsg.setSubject("Dispatch Request - Task Cancelled");
                    map.put("vEmailTo", "QA Managers");
                    map.put("vFooter", "This email is to notify you that the task described above was cancelled.");
                    map.put("vEmailTask", "Task Cancelled");
                    break;
                }
                case "NotifyContractorCompleted": {
                    rmsg.setSubject("Dispatch Request has been Completed");
                    map.put("vFooter", "This email is to notify you that the request has been completed.");
                    map.put("vEmailTo", "Contractor");
                    if (params != null && !params.isEmpty() && params.containsKey("task")) {
                        map.put("vEmailTask", params.get("task"));
                    } else {
                        map.put("vEmailTask", "Notify Contractor - Completed");
                    }
                    break;
                }
                case "NotifyContractorRejected": {
                    rmsg.setSubject("Dispatch Request has been Rejected");
                    map.put("vFooter", "This email is to notify you that the request has been rejected.");
                    map.put("vEmailTo", "Contractor");
                    if (params != null && !params.isEmpty() && params.containsKey("task")) {
                        map.put("vEmailTask", params.get("task"));
                    } else {
                        map.put("vEmailTask", "Notify Contractor - Rejected");
                    }
                    break;
                }
            }
            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);
            final String emailBody = engine.process("Dispatch/email-DefaultNotification.html", ctx);
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
