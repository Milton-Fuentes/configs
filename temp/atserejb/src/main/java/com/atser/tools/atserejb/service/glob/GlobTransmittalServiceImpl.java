/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobTransmittalDao;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobStakeholder;
import com.atser.tools.atserejb.model.GlobTransmittal;
import com.atser.tools.atserejb.model.GlobTransmittalDtn;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.qm.QmCvlFieldDataService;
import com.atser.tools.atserejb.service.ws.WsReportService;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.document.write.jasper.BuildJasper;
import com.atser.tools.atserutil.enumerator.eDocExtension;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionPrecaststressTO;
import com.atser.tools.atserutil.objects.to.jasper.qa.inspection.QaInspectionReportTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Session;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Stateless
@Slf4j
public class GlobTransmittalServiceImpl implements GlobTransmittalService, IBaseEJBException {

    private final String rootFolderName = "Transmittal Management";

    @Inject
    private GlobTransmittalDao dao;

    @Inject
    GlobTransmittalDtnService globTransmittalDtnService;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobFolderService folderService;

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private GlobStakeholderService globStakeholderService;

    @Inject
    private QmCvlFieldDataService qmCvlFieldDataService;

    @Inject
    private WsReportService wsReportService;

    @Inject
    private GenericHelperService genericHelperService;

    @Override
    public GlobTransmittal findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobTransmittal findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public GlobTransmittal findById(ManageITHeader header, String id) {
        return findById(header, NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobTransmittal findById(ManageITHeader header, BigDecimal id) {
        if (header == null) {
            return dao.findById(id);
        } else {
            GlobTransmittal elem = dao.findById(id);
            if (elem.getFolderId() == null) {
                BigDecimal fId = createFolderStruct(header, elem);
                if (fId != null) {
                    elem.setFolderId(fId);
                    dao.update(elem);
                }
            }
            return elem;
        }
    }

    // Review This Method
    private BigDecimal createFolderStruct(ManageITHeader header, GlobTransmittal elem) {
        if (StringSupport.isNullOrEmpty(header.getClientid())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger owner = NumberSupport.getBigInteger(header.getUserid());
        // Get Risk Master Folder
        BigDecimal rootFolderId = BigDecimal.ZERO;
        if (elem.getContractId() != null) {
            rootFolderId = folderService.getFolderIdByFolderNameByProject(StringSupport.getString(elem.getProjectId()), StringSupport.getString(elem.getContractId()), rootFolderName);

        } else {
            rootFolderId = folderService.getFolderIdByFolderNameByProject(elem.getProjectId().toBigInteger(), rootFolderName);

        }
        if (rootFolderId != null) {
            // Create Risk No Folder
            return folderService.createTrackITFolder(rootFolderId, elem.getProjectId().toBigInteger(), owner, BigInteger.ZERO, 'Y', "Y", 'N', elem.getTransmittalNo(), new BigInteger("2"));
        }
        return null;
    }

    private void getNextProjectSequenceNoPattern(ManageITHeader header, GlobTransmittal elem) {

        //Default format GlobSystemPropertiesService
        String formatSample = "000";

        // if ("000".equals(formatSample)) {
        Integer nextNo = dao.getNextProjectSequenceNo(header.getClientid(), elem.getProjectId());//Error Here
        elem.setSpno(nextNo);
        DecimalFormat df = new DecimalFormat("000");
        String numberAsString = df.format(nextNo);
        elem.setTransmittalNo(numberAsString);
        //}

    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobTransmittal elem) {
        if (elem != null) {
            getNextProjectSequenceNoPattern(header, elem);
            return dao.save(elem).getId();

        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobTransmittal elem) {
        if (elem != null) {
            GlobTransmittal model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobTransmittal populate(GlobTransmittal model, GlobTransmittal elem) {

        populateDistribution(model, elem);
        model.setTransmittalNo(elem.getTransmittalNo());
        model.setTransmittedBy(elem.getTransmittedBy());
        model.setTransmittedByCompany(elem.getTransmittedByCompany());
        model.setTransmittedAddress(elem.getTransmittedAddress());
        model.setContractId(elem.getContractId());

        model.setAttention(elem.getAttention());
        model.setAttentionCompany(elem.getAttentionCompany());
        model.setTransmittedFor(elem.getTransmittedFor());
        model.setTransmittedForOther(elem.getTransmittedForOther());
        model.setAttentionAddress(elem.getAttentionAddress());
        model.setTrackingNo(elem.getTrackingNo());
        model.setStatus(elem.getStatus());
        model.setDeliveredVia(elem.getDeliveredVia());

        //model.setLastMod(elem.getLastMod());
        //model.setLastModBy(elem.getLastModBy());
        //model.setLastModIp(elem.getLastModIp());
        return model;
    }

    public void populateDistribution(GlobTransmittal model, GlobTransmittal elem) {
        elem.getDistributions().stream().forEach(e -> {
            e.setDtTransmittal(model);
            model.getDistributions().add(e);
        });
    }

    @Override
    public void delete(String id) {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void delete(BigDecimal id) {
        if (id == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        dao.delete(id);
    }

    @Override
    public List<GlobTransmittal> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<GlobTransmittal> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobTransmittal> finalList = list(request);
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
    public DataGridWrapper<GlobTransmittal> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    @Override
    public void transmitt(ManageITBodyRequest body, String server_domain, TemplateEngine engine) {
        if (body == null || StringSupport.isNullOrEmpty(body.getParams().get("id"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }

        GlobTransmittal model = findById(body.getParams().get("id").toString());
        GlobProject project = globProjectService.findById(model.getProjectId().toString());
        if (model != null && model.getDistributions() != null) {
            model.getDistributions().stream().map(item -> {
                if (StringSupport.isNullOrEmpty(item.getTrtoken())) {
                    item.setTrtoken(UUID.randomUUID().toString());
                }
                return item;
            });
            model.getDistributions().stream().forEach(item -> {
                // Map<String, Boolean> clientFlags = globClientService.getMapFlags(StringSupport.getString(project.getClientId().getId()));
                // notifyTechnician(callId, status, server_domain, engine, dcl, wo, project, clientFlags);
                transmittContacts(item, model, project, server_domain, engine);

            });
            model.setActive(StringSupport.getActiveAsCharacter("N"));
            dao.update(model);

        }

    }

    private void transmittContacts(GlobTransmittalDtn transmitedTo, GlobTransmittal model, GlobProject project, String server_domain, TemplateEngine engine) {
        log.info("@ATSER - Execution Notification Email Method.");
        if (StringSupport.isNullOrEmpty(model.getAttentionCompany())) {
            throwBaseException(Response.Status.EXPECTATION_FAILED, "To send emails you must assign a contact first.");
        }
        // validate contacts email
        // Notify by Email
        notifyByEmail(transmitedTo, model, project, server_domain, engine);
        // Notify by MMS 
        //Todo

    }

    private void notifyByEmail(GlobTransmittalDtn transmitedTo, GlobTransmittal model, GlobProject project, String server_domain, TemplateEngine engine) {
        log.info("@ATSER - Notifying by Email.");

        BpmMailMessage msg = new BpmMailMessage();

        String emailTo = globStakeholderService.findById(StringSupport.getString(transmitedTo.getIdStk())).getEmail();

        GlobStakeholder transmitedBy = globStakeholderService.findById(model.getTransmittedBy());

        msg.setFrom(transmitedBy.getEmail());
        log.info(String.format("@ATSER - Using '%s' email as Sent From.", transmitedBy.getFirstname()));
        // Variable Map
        Map<String, Object> map = new HashMap<>();
        String token = UUID.randomUUID().toString().replace("-", "");
        msg.setSubject("Transmittal Request");
        msg.setStatus("SENDED");
        msg.setToken(token);

        // Tranmittal RefId
        msg.setRefId(model.getId().toString());
        // Tranmitted to one email , but can be many 
        List<String> ntfEmail = new ArrayList<>();
        if (StringSupport.isNotNullAndNotEmpty(emailTo)) {
            ntfEmail.add(emailTo);
            msg.setTo(ntfEmail.stream().toArray(String[]::new));
            map.put("vProjectName", project.getPName());
            map.put("vProjectAddress", project.getFullProjectAddress());
            map.put("vTransmittalNo", model.getTransmittalNo());

            map.put("vTransmittedBy", transmitedBy.getFirstname() + transmitedBy.getLastname());

            //map.put("vServiceDate", DateSupport.formatDate(dcl.getServiceDate(), DateSupport.FORMAT_US));
            //calling updateBasicTechAnswer
            map.put("vURLYes", "https://" + server_domain + "/ws/rs/form/bdispatch/technician?t=" + token + "&r=Y&k=" + model.getId());
            map.put("vURLNo", "https://" + server_domain + "/ws/rs/form/bdispatch/technician?t=" + token + "&r=N&k=" + model.getId());
            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);

            final String emailBody = engine.process("Transmittal/default/email-techBasicNotification.html", ctx);
            //todo by client

            if (emailBody != null && !emailBody.isEmpty()) {
                msg.setMessageText(emailBody);
            } else {
                log.error("@ATSER - Email Template not Found.");
                throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                return;
            }

            Boolean emailstatus = MailSender.sendEmailDefault(mailSession, msg);
            log.info("@ATSER - Email Status: " + emailstatus);
            if (emailstatus) {
                ntfTrackService.save("TRACKIT", "basic_transmittal", msg);
                transmitedTo.setEmailStatus(StringSupport.getActiveAsCharacter("Y"));
                globTransmittalDtnService.update(transmitedTo);
            } else {
                log.error(String.format("@ATSER - The Email could not be sended. BpmMailMsg: '%s'", msg.toString()));
                log.error(String.format("@ATSER - The Email could not be sended. MailMessage: '%s'", ((MailMessage) msg).toString()));
            }
        } else {
            log.error(String.format("@ATSER - The technician's email '%s' could not be found.", emailTo));
            throwBaseException(Response.Status.EXPECTATION_FAILED, "The technician's email could not be found.");
        }

    }

    @Override
    public void changeStatus(ManageITBodyRequest body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("id")) || StringSupport.isNullOrEmpty(body.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobTransmittal model = findById(body.getParams().get("id").toString());
        model.setActive(StringSupport.getActiveAsCharacter(body.getParams().get("status").toString()));
        dao.update(model);
    }

    // -------------------------- GENERATE REPORTS -----------------------------
    /*
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
 /*   @Override
    public String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(header.getClientid()) || StringSupport.isNullOrEmpty(reportId)) {
            log.error("@ATSER: generateReport - Wrong parameters");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        WsReport rp = wsReportService.findReport(NumberSupport.getBigInteger(header.getClientid()), funcId, reportId);
        if (rp != null) {
            String tplpath = tplbasePath + rp.getReportPath();
            Map<String, Object> paramsJasper = rp.generateSubReportsForJasper(tplbasePath);
            return buildGenericReport(tplbasePath, tplpath, docpathsegment, docType, request, paramsJasper, funcId);
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
 /*  private String buildGenericReport(String tplbasePath, String tplpath, String docpathsegment, String docType, ManageITBodyRequest request, Map<String, Object> paramsJasper, String funcId) {
        eDocExtension extension;
        if (docType == null || docType.isEmpty()) {
            extension = eDocExtension.pdf;
        } else {
            extension = eDocExtension.valueOf(docType);
        }
        List<QaInspectionReportTO> pResult = generateReportData(request, funcId);
        String targetPath = docpathsegment + "Inspection_" + DateSupport.getNowToFormat("MMddyyyyHHmm") + "." + extension.getValue();
        BuildJasper pdf = new BuildJasper();
        try {
            targetPath = pdf.exportDocument(tplpath, paramsJasper, pResult, targetPath, extension.getValue());
            return targetPath;

        } catch (Exception ex) {
            log.error(ex.getMessage());
        }
        return null;
    }
    public List<QaInspectionReportTO> generateReportData(List<QaInspection> ds, BufferedImage clientLogoImage) {
        List<QaInspectionReportTO> rList = new ArrayList<>();
        ds.forEach(it -> {
            //Get Project
            if (it.getProjectId() != null) {
                GlobProject currentproject = globProjectService.findById(it.getProjectId().toString());
                if (currentproject != null) {
                    QaInspectionPrecaststressTO obj = new QaInspectionPrecaststressTO(qaInspectionHelperService.populateInspectionHeader(TEST_TITLE, TEST_RMS_INFO, it, currentproject, clientLogoImage), qaInspectionHelperService.populateInspectionContractInfo(currentproject));
                    // Precast Info
                    obj.setPrecastInfo(generateInspectionPrecastPojo(it));
                    // Determination
                    if (it.getSimplecatId() != null && StringSupport.isNotNullAndNotEmpty(it.getSimplecatId().getName())) {
                        obj.setItemDetermination(it.getSimplecatId().getName().toUpperCase());
                    }
                    // Populate Signture Map
                    obj.setSignatureList(qaInspectionHelperService.populateSignatureMap(it));
                    // Add to List
                    rList.add(obj);
                }
            }
        });
        return rList;
    }*/
}
