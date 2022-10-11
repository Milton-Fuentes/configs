/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.util;

import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.helper.SystemNotificationHelperService;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.mail.MailMessage;
import com.atser.tools.atserutil.mail.MailSender;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.mail.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author droldan
 */
@Path("/util/mail")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
public class MailSenderRS implements IBaseWSException {

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @EJB
    private InitializeEnv env;

    @EJB
    private SystemNotificationHelperService systemNotificationHelperService;

    @EJB
    private GlobNotificationTrackService ntfTrackService;

    /**
     * @param request Json Request { "subject":"Wildfly 10",
     * "to":["droldan@atser.com", "elias@atser.com"],
     * "from":"droldan@atser.com", "messageText":"Jboss Server Test." }
     */
    @POST
    @Path("/send")
    @Asynchronous
    public void sendMail(ManageITRequest<MailMessage> request) {
        if (request != null && request.validate() && request.getBody().getData() != null) {
            MailSender.sendEmailDefault(mailSession, request.getBody().getData());
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
    }

    @POST
    @Path("/bpm/send")
    @Asynchronous
    public void bpmSendMail(ManageITRequest<BpmMailMessage> request) {
        if (request != null && request.validate() && request.getBody().getData() != null) {
            String ncc = env.getPropertiesMap().get("notification_bpm_cc");
            Boolean status;
            BpmMailMessage msg = request.getBody().getData();
            if (ncc != null && !ncc.isEmpty()) {
                String[] ccarray = ncc.split(",");
                msg.setCc(ccarray);
            }
            status = MailSender.sendEmailDefault(mailSession, msg);
            if (status) {
                if (env.isNotification_bpm_track_enable()) {
                    ntfTrackService.save(request.getHeader().getModule(), request.getHeader().getFunctionality(), msg);
                }
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
    }

    @POST
    @Path("/v1/notify")
    @Asynchronous
    public Response systemNotify(ManageITRequest<SystemMessage> request) {
        if (request != null && request.validate() && request.getBody().getData() != null) {
            systemNotificationHelperService.notify(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData());
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
        return Response.status(Response.Status.OK).build();
    }

}
