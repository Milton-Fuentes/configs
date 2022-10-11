/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaInspectionSigninfoDao;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.QaInspectionSigninfo;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.qm.QmClientRoleMatrixService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
public class QaInspectionSigninfoServiceImpl implements QaInspectionSigninfoService, IBaseEJBException {

    @Inject
    private QaInspectionSigninfoDao dao;

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private QaInspectionService qaInspectionService;

    @Inject
    private GlobUserService globUserService;

    @Inject
    private GlobContactService contactService;

    @Inject
    private QmClientRoleMatrixService qmClientRoleMatrixService;

    @Override
    public QaInspectionSigninfo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspectionSigninfo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaInspectionSigninfo elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaInspectionSigninfo elem) {
        if (elem != null) {
            QaInspectionSigninfo model = findById(elem.getId());
            if (!model.equals(elem)) {
                model = populate(model, elem);
                if (model != null) {
                    dao.update(model);
                }
            }
        }
    }

    /**
     * Populate Parent
     *
     * @param model
     * @param elem
     * @return
     */
    private QaInspectionSigninfo populate(QaInspectionSigninfo model, QaInspectionSigninfo elem) {
        model.setSignOrder(elem.getSignOrder());
        return null;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }
    
    @Override
    public void delete(BigDecimal id) {
        delete(StringSupport.getString(id));
    }

    @Override
    public List<QaInspectionSigninfo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaInspectionSigninfo> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaInspectionSigninfo> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaInspectionSigninfo> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

    /**
     * Send Email Notification
     *
     * @param signInfo
     * @param server_domain
     * @param engine
     * @param userList
     * @param status
     * @param comments
     */
    private void sendSignEmailNotification(QaInspectionSigninfo signInfo, String server_domain, TemplateEngine engine, List<String> userList, Boolean status, String comments) {
        GlobProject project = projectService.findById(StringSupport.getString(signInfo.getInspectionId().getProjectId()));
        if (project != null) {
            BpmMailMessage msg = new BpmMailMessage();
            // Variable Map
            Map<String, Object> map = new HashMap<>();
            // Build Subject
            String contractNo = project.getPNumber();
            String inspType = signInfo.getInspectionId().getInspectionTypeId().getName();
            String currentSignFlow = signInfo.getSignflowId().getSimplecatId().getName().replace("By", "");
            String inspNo = signInfo.getInspectionId().getInspNo();
            StringBuilder subject = new StringBuilder();
            subject.append(inspType).append(" Signature Flow - [ ").append(" No: ").append(inspNo).append(", Action: ");
            if (!status) {
                subject.append("Unapprove");
            } else {
                subject.append("Sign");
            }
            subject.append(", Flow: ").append(currentSignFlow).append("]");
            msg.setSubject(subject.toString());
            msg.setStatus("SENDED");
            msg.setRefId(StringSupport.getString(signInfo.getInspectionId().getId()));

            List<String> ntfEmail = new ArrayList<>();
            userList.forEach(it -> {
                GlobContact userContact = contactService.findById(it);
                if (userContact != null && StringSupport.isNotNullAndNotEmpty(userContact.getEmail())) {
                    ntfEmail.add(userContact.getEmail());
                }
            });

            if (!ntfEmail.isEmpty()) {
                msg.setTo(ntfEmail.stream().toArray(String[]::new));
                map.put("vHeader", inspType + " signature flow details.");
                map.put("vContractNo", contractNo);
                map.put("vInspNo", inspNo);
                map.put("vSignBy", signInfo.getSignedByName());
                map.put("vSignDate", DateSupport.formatDate(signInfo.getSignedDate(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                map.put("vJobTitle", signInfo.getSignedByJobtitle());
                map.put("vComments", comments);
                map.put("vFooter", "");

                final Context ctx = new Context(Locale.ENGLISH);
                ctx.setVariables(map);

                final String emailBody = engine.process("qm/InspectionTestLog/generic-signatureflow.html", ctx);
                if (emailBody != null && !emailBody.isEmpty()) {
                    msg.setMessageText(emailBody);
                } else {
                    throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                    return;
                }

                Boolean emailStatus = MailSender.sendEmailDefault(mailSession, msg);

                if (emailStatus) {
                    ntfTrackService.save("qm", "inspection_test_log", msg);
                }
            }
        }
    }

    @Override
    public void signInspection(ManageITHeader header, ManageITBodyRequest request, String serverPath, String tplbasePath, String docpathsegment, String server_domain, TemplateEngine engine) {
        if (StringSupport.isNullOrEmpty(header.getClientid(), request.getParams().get("id"), request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaInspectionSigninfo model = findById(StringSupport.getString(request.getParams().get("id")));
        Boolean isLastSign = StringSupport.getBoolean(StringSupport.getString(request.getParams().get("islastsign")));
        List<String> userList = (List) request.getParams().get("usersList");
        if (model != null) {
            Character signStatus = StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status")));
            model.setSigned(signStatus);
            model.setSignedBy(NumberSupport.getBigInteger(header.getUserid()));
            GlobUsers userId = globUserService.findById(header.getUserid());
            if (userId != null) {
                model.setSignedByName(userId.getContactid().getFullName());
                model.setSignedByJobtitle(userId.getContactid().getTitle());
            } else {
                model.setSignedByName(header.getUser());
            }
            model.setSignedDate(new Date());
            model.setSignedFromIp(header.getModIp());
            try {
                dao.update(model);
                // Update Current Inspection Test Status
                updateInspectionCurrentStatus(header, model.getInspectionId().getId());
                if (isLastSign && signStatus.equals('Y')) {
                    qaInspectionService.generateReportAndUploadToTrackIT(model.getInspectionId(), serverPath, tplbasePath, docpathsegment, header);
                }
                if (userList != null && !userList.isEmpty()) {
                    // Send Users Notifications
                    sendSignEmailNotification(model, server_domain, engine, userList, StringSupport.getBoolean(request.getParams().get("status")), StringSupport.emptyOnNull(request.getParams().get("comments")));
                }
            } catch (Exception ex) {
                log.error(ex.getMessage() + " - model: " + model);
                throwBaseException(Response.Status.BAD_REQUEST, "An error occurred while signing.");
            }
        }
    }

    private void updateInspectionCurrentStatus(ManageITHeader header, BigDecimal id) {
        if (id != null) {
            List<QaInspectionSigninfo> ds = list(new ManageITBodyRequest(0, 0)
                    .filter("clientId", NumberSupport.getBigInteger(header.getClientid()))
                    .filter("inspectionId.id", id)
                    .sorted("signOrder", "asc"));
            if (ds != null && !ds.isEmpty()) {
                BigInteger currentId = new BigInteger("-1");
                for (QaInspectionSigninfo it : ds) {
                    if (it.getSigned() != null && it.getSigned() == 'Y') {
                        currentId = it.getSignflowId().getSimplecatId().getId().toBigInteger();
                    }
                }
                qaInspectionService.updateTestStatus(id, currentId);
            }
        }
    }

    @Override
    public List<QaInspectionSigninfo> buildSignList(ManageITHeader header, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(header.getClientid(), request.getParams().get("inspectionId"), request.getParams().get("isAdmin"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<QaInspectionSigninfo> ds = list(new ManageITBodyRequest(0, 0)
                .filter("clientId", NumberSupport.getBigInteger(header.getClientid()))
                .filter("inspectionId.id", NumberSupport.getBigDecimal(request.getParams().get("inspectionId")))
                .sorted("signOrder", "asc"));
        if (ds != null && !ds.isEmpty()) {
            ds = brToValidateAllowed(ds, header, StringSupport.getBoolean(request.getParams().get("isAdmin")));
            ds = brToValidateEnable(ds);
        }
        return ds;
    }

    private List<QaInspectionSigninfo> brToValidateAllowed(List<QaInspectionSigninfo> ds, ManageITHeader header, Boolean isAdmin) {
        ds.forEach(it -> {
            it.setAllowToSign(qmClientRoleMatrixService.hasRoleRigth(header, isAdmin, it.getSignflowId().getSignRuleName()));
        });
        return ds;
    }

    private List<QaInspectionSigninfo> brToValidateEnable(List<QaInspectionSigninfo> ds) {
        if (ds.get(0).getSigned() == 'N') {
            ds.get(0).setEnabledToSign(true);
            ds.get(0).setEnabledToUnapprove(false);
            return ds;
        } else {
            ds.get(0).setEnabledToSign(false);
            ds.get(0).setEnabledToUnapprove(true);
        }
        for (int i = 1; i < ds.size(); i++) {
            if (ds.get(i).getSigned() == 'N') {
                ds.get(i).setEnabledToSign(true);
                ds.get(i).setEnabledToUnapprove(false);
                break;
            } else if (ds.get(i).getSigned() == 'Y') {
                ds.get(i).setEnabledToSign(false);
                ds.get(i).setEnabledToUnapprove(true);
                ds.get(i - 1).setEnabledToUnapprove(false);
            }
        }
        if (!ds.isEmpty()) {
            ds.get(ds.size() - 1).setIsLastSign(Boolean.TRUE);
        }
        return ds;
    }

    @Override
    public Boolean isInspectionSignedOff(BigInteger inspectionId) {
        if(inspectionId == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return dao.isInspectionSignedOff(inspectionId);
    }

}
