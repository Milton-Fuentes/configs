/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.helper;

import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.service.plan.PlanProjectsService;
import com.atser.tools.atserutil.mail.SystemMailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.project.ProjectBO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
public class SystemNotificationHelperServiceImpl implements SystemNotificationHelperService, IBaseEJBException {

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private WsDocTemplateService wsDocTemplateService;

    @Inject
    private GlobNotificationTrackService globNotificationTrackService;

    @Inject
    private GlobUserService globUserService;

    @Inject
    private GlobProjectService globProjectService;

    @Inject
    private PlanProjectsService globPlanProjectsService;

    @Override
    public void notify(ManageITHeader header, TemplateEngine engine, SystemMessage notf) {
        notify(header, engine, notf, null);
    }

    @Override
    public void notify(ManageITHeader header, TemplateEngine engine, SystemMessage notf, String templateCode) {
        if (StringSupport.isNullOrEmpty(header.getClientid(), header.getModule(), notf.getFunctionality())) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        // Getting email template
        WsDocTemplate rp;
        if (StringSupport.isNotNullAndNotEmpty(templateCode)) {
            rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(header.getClientid()), notf.getFunctionality(), "html", templateCode);
        } else {
            rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(header.getClientid()), notf.getFunctionality(), "html");
        }
        if (rp == null) {
            log.error("Wrong Document Template configuration for this client.");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
        }
        // Getting Project Information
        ProjectBO project = null;
        if (StringSupport.isNotNullAndNotEmpty(notf.getProjectId()) && notf.getProjectId().signum() == 1) {
            if ("Planning".equals(notf.getProjectType())) {
                project = globPlanProjectsService.toProjectBO(globPlanProjectsService.findById(StringSupport.getString(notf.getProjectId())));
            } else {
                project = globProjectService.toProjectBO(globProjectService.findById(StringSupport.getString(notf.getProjectId())));
            }
        }

        // Sending Email Notf
        if (StringSupport.isNotNullAndNotEmpty(notf.getRefId())) {
            sendEmail(notf, project, rp.getDocPath(), header.getModule(), notf.getFunctionality(), engine, NumberSupport.getBigInteger(header.getClientid()));
            // Sending MMS Notf
            if (notf.getIsSmsActive() != null && notf.getIsSmsActive()) {
                sendMms(notf, project, header.getModule(), notf.getFunctionality(), NumberSupport.getBigInteger(header.getClientid()));
            }
        } else {
            // Getting Sender Information
            GlobUsers senderContact = globUserService.findById(header.getUserid());
            if (senderContact != null) {
                sendEmail(notf, project, StringSupport.getString(senderContact.getContactid().getId()), rp.getDocPath(), header.getModule(), notf.getFunctionality(), engine, NumberSupport.getBigInteger(header.getClientid()));
                // Sending MMS Notf
                if (notf.getIsSmsActive() != null && notf.getIsSmsActive()) {
                    sendMms(notf, project, StringSupport.getString(senderContact.getContactid().getId()), header.getModule(), notf.getFunctionality(), NumberSupport.getBigInteger(header.getClientid()));
                }
            }
        }
    }

    private void sendMms(SystemMessage notf, ProjectBO project, String module, String functionality, BigInteger clientId) {
        sendMms(notf, project, notf.getRefId(), module, functionality, clientId);
    }

    private void sendMms(SystemMessage notf, ProjectBO project, String senderId, String module, String functionality, BigInteger clientId) {
        if (notf.getUserList() != null && !notf.getUserList().isEmpty()) {
            notf.getUserList().forEach((userId) -> {
                GlobUsers recv = globUserService.findById(userId.toString());
                if (recv != null && StringSupport.getBoolean(recv.getContactid().getNotfSmsActive())) {
                    notifyByMMS(notf.getSubject(), "wwwmail@atser.com", senderId, recv.getContactid(), project, module, functionality, clientId);
                }
            });
        }
    }

    // FixMe (We need to add an standard body)
    private void notifyByMMS(String subject, String from, String senderId, GlobContact recv, ProjectBO project, String module, String functionality, BigInteger clientId) {
        SystemMailMessage msg = new SystemMailMessage();
        msg.setFrom(from);
        String mmsEmail = MailSender.getSmsEmail(recv.getNotfPhone(), recv.getNotfMCarrier());
        List<String> ntfEmail = new ArrayList<>();
        StringBuilder smsbody = new StringBuilder();
        if (StringSupport.isNotNullAndNotEmpty(mmsEmail)) {
            ntfEmail.add(mmsEmail);
            msg.setSubject(subject);
            msg.setStatus("SENDED");
            msg.setToken(null);
            msg.setClientId(clientId);
            msg.setRefId(senderId);
            msg.setTo(ntfEmail.stream().toArray(String[]::new));
            if (project != null) {
                smsbody.append("Project No: ").append(project.getNumber()).append("\n");
            }
            smsbody.append("Please review your email for details.");
            msg.setMessageText(smsbody.toString());
            Boolean status = MailSender.sendEmailDefault(mailSession, msg);
            if (status) {
                globNotificationTrackService.save(module, functionality, msg, "MMS");
            }
        }
    }

    private void sendEmail(SystemMessage notf, ProjectBO project, String tplPath, String module, String functionality, TemplateEngine engine, BigInteger clientId) {
        sendEmail(notf, project, notf.getRefId(), tplPath, module, functionality, engine, clientId);
    }

    private void sendEmail(SystemMessage notf, ProjectBO project, String senderId, String tplPath, String module, String functionality, TemplateEngine engine, BigInteger clientId) {
        List<String> ntfEmail = new ArrayList<>();
        if (notf.getUserList() != null && !notf.getUserList().isEmpty()) {
            notf.getUserList().forEach((userId) -> {
                GlobUsers recv = globUserService.findById(userId.toString());
                if (recv != null && StringSupport.isNotNullAndNotEmpty(recv.getContactid().getEmail())) {
                    ntfEmail.add(recv.getContactid().getEmail());
                }
            });
        }

        if (notf.getTo() != null && notf.getTo().length > 0) {
            ntfEmail.addAll(Arrays.asList(notf.getTo()));
        }

        if (!ntfEmail.isEmpty()) {
            notifyByEmail(notf, "wwwmail@atser.com", senderId, ntfEmail.stream().toArray(String[]::new), engine, project, module, functionality, tplPath, clientId);
        }

        // notifyByEmail
    }

    private void notifyByEmail(SystemMessage notf, String from, String senderId, String[] to, TemplateEngine engine, ProjectBO project, String module, String functionality, String tplPath, BigInteger clientId) {
        SystemMailMessage msg = new SystemMailMessage();
        msg.setFrom(from);
        // Variable Map
        Map<String, Object> map = new HashMap<>();
        msg.setSubject(notf.getSubject());
        msg.setStatus("SENDED");
        msg.setToken(null);
        msg.setRefId(senderId);
        msg.setClientId(clientId);
        if (project != null) {
            msg.setProjectId(project.getId());
            map.put("vProjectName", project.getName());
        }
        msg.setCategoryId(notf.getCatgId());
        msg.setSenderInfo(notf.getSenderInfo());
        if (StringSupport.isNotNullAndNotEmpty(msg.getSenderInfo())) {
            AtserLinkedHashMap<String, Object> senderInfo = AtserLinkedHashMap.parseJsonString(StringSupport.getString(notf.getSenderInfo()));
            map.put("senderInfo", senderInfo);
        }
        msg.setTo(to);
        if (notf.getCc() != null && notf.getCc().length > 0) {
            msg.setCc(notf.getCc());
        }
        // Populate Parameters Map
        map.put("vNotf", notf);
        final Context ctx = new Context(Locale.ENGLISH);
        ctx.setVariables(map);

        final String emailBody = engine.process(tplPath, ctx);
        if (emailBody != null && !emailBody.isEmpty()) {
            msg.setMessageText(emailBody);
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
            return;
        }
        Boolean emailstatus = MailSender.sendEmailDefault(mailSession, msg);
        if (emailstatus) {
            globNotificationTrackService.save(module, functionality, msg);
        }
    }
}
