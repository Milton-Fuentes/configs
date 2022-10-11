/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmBiditSigninfoDao;
import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.service.glob.GlobContactService;
import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.qm.QmClientRoleMatrixService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserejb.model.GlobSystemSimpleCat;
import com.atser.tools.atserejb.service.glob.GlobSystemSimpleCatService;
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

/**
 *
 * @author mdelabat
 */
@Stateless
@Slf4j
public class CmBiditSigninfoServiceImpl implements CmBiditSigninfoService, IBaseEJBException {

    @Inject
    private CmBiditSigninfoDao dao;

    @Inject
    private CmBiditPrjCatgService cmBiditPrjCatgService;

    @Resource(mappedName = "java:jboss/mail/Atser")
    private Session mailSession;

    @Inject
    private GlobNotificationTrackService ntfTrackService;

    @Inject
    private GlobProjectService projectService;

    @Inject
    private GlobContactService contactService;

    @Inject
    private QmClientRoleMatrixService qmClientRoleMatrixService;

    @Inject
    private GlobUserService globUserService;

    @Inject
    private GlobSystemSimpleCatService globSystemSimpleCatService;

    @Override
    public CmBiditSigninfo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public CmBiditSigninfo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, CmBiditSigninfo elem) {
        if (elem != null) {
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, CmBiditSigninfo elem) {
        if (elem != null) {
            CmBiditSigninfo model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private CmBiditSigninfo populate(CmBiditSigninfo model, CmBiditSigninfo elem) {
        model.setSignOrder(elem.getSignOrder());
        return model;
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
    public List<CmBiditSigninfo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataTableWrapper<CmBiditSigninfo> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmBiditSigninfo> finalList = list(request);
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
    public DataGridWrapper<CmBiditSigninfo> dataGridList(ManageITBodyRequest request) {
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
    public void sign(ManageITHeader header, ManageITBodyRequest request, String serverPath, String tplbasePath, String docpathsegment, String server_domain, TemplateEngine engine) {
        if (StringSupport.isNullOrEmpty(header.getClientid(), request.getParams().get("id"), request.getParams().get("status"), request.getParams().get("code"), request.getParams().get("shortName"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        CmBiditSigninfo model = findById(StringSupport.getString(request.getParams().get("id")));
        Boolean isLastSign = StringSupport.getBoolean(StringSupport.getString(request.getParams().get("islastsign")));
        List<String> userList = (List) request.getParams().get("usersList");
        if (model != null) {
            String code = StringSupport.getString(request.getParams().get("code"));
            String shortName = StringSupport.getString(request.getParams().get("shortName"));
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
                // Update Current Bid Status
                updateBidCurrentStatus(header, NumberSupport.getBigDecimal(model.getRefId()), code, shortName);
                /*if (isLastSign && signStatus.equals('Y')) {
                    cmBiditPrjCatgService.generateReportAndUploadToTrackIT(model.getBidPrjId(), serverPath, tplbasePath, docpathsegment, header);
                }*/
                if (userList != null && !userList.isEmpty()) {
                    // Send Users Notifications
                    sendSignEmailNotification(model, server_domain, engine, userList, StringSupport.getBoolean(request.getParams().get("status")), StringSupport.emptyOnNull(request.getParams().get("comments")), code, shortName);
                }
            } catch (Exception ex) {
                throwBaseException(Response.Status.BAD_REQUEST, "An error occurred while signing.");
            }
        }
    }

    private void updateBidCurrentStatus(ManageITHeader header, BigDecimal id, String code, String shortName) {
        if (id != null) {
            List<CmBiditSigninfo> ds = list(new ManageITBodyRequest(0, 0)
                    .filter("clientId", NumberSupport.getBigInteger(header.getClientid()))
                    .filter("refId", id)
                    .filter("typeId.code", code)
                    .filter("typeId.shortName", shortName)
                    .sorted("signOrder", "asc"));
            if (ds != null && !ds.isEmpty()) {
                BigInteger currentId = new BigInteger("-1");
                for (CmBiditSigninfo it : ds) {
                    if (it.getSigned() != null && it.getSigned() == 'Y') {
                        currentId = it.getSignflowId().getSimplecatId().getId().toBigInteger();
                    }
                }

                switch (shortName) {
                    case "bidsigndesignerwf": {
                        cmBiditPrjCatgService.updateBidSignStatus(id, currentId);
                        break;
                    }
                    case "bidsignbidderwf": {
                        // Update status for Bidder Profile Table
                        break;
                    }
                }
            }
        }
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
    private void sendSignEmailNotification(CmBiditSigninfo signInfo, String server_domain, TemplateEngine engine, List<String> userList, Boolean status, String comments, String code, String shortName) {
        GlobProject project = null;
        String functionality = StringSupport.STRING_EMPTY;
        // Variable Map
        Map<String, Object> map = new HashMap<>();
        BpmMailMessage msg = new BpmMailMessage();
        String contractNo = StringSupport.STRING_EMPTY, bidNo = StringSupport.STRING_EMPTY;
        StringBuilder subject = new StringBuilder();
        switch (shortName) {
            case "bidsigndesignerwf": {
                functionality = "bidit_sign_flow";
                CmBiditPrjCatg bidId = cmBiditPrjCatgService.findById(signInfo.getRefId().toString());
                if (bidId != null) {
                    project = projectService.findById(StringSupport.getString(bidId.getProjectId()));
                    if (project != null) {
                        contractNo = project.getPNumber();
                    }
                    bidNo = bidId.getBidNo();
                    map.put("vContractNo", contractNo);
                }
                break;
            }
            case "bidsignbidderwf": {
                // Configure Email's variables for Bidder
                functionality = "bidit_bidder_sign_flow";
                break;
            }
        }
        String currentSignFlow = signInfo.getSignflowId().getSimplecatId().getName().replace("By", "");
        // Build Subject
        subject.append("BidIT").append(" Signature Flow - [ ").append(" No: ").append(bidNo).append(", Action: ");
        if (!status) {
            subject.append("Unapprove");
        } else {
            subject.append("Sign");
        }
        subject.append(", Flow: ").append(currentSignFlow).append("]");
        msg.setSubject(subject.toString());
        msg.setStatus("SENDED");
        msg.setRefId(StringSupport.getString(signInfo.getRefId()));

        List<String> ntfEmail = new ArrayList<>();
        userList.forEach(it -> {
            GlobContact userContact = contactService.findById(it);
            if (userContact != null && StringSupport.isNotNullAndNotEmpty(userContact.getEmail())) {
                ntfEmail.add(userContact.getEmail());
            }
        });

        if (!ntfEmail.isEmpty()) {
            msg.setTo(ntfEmail.stream().toArray(String[]::new));
            map.put("vHeader", "BidIT signature flow details.");
            map.put("vBidNo", bidNo);
            map.put("vSignBy", signInfo.getSignedByName());
            map.put("vSignDate", DateSupport.formatDate(signInfo.getSignedDate(), DateSupport.FORMAT_MMDDYY_HHMMSS));
            map.put("vJobTitle", signInfo.getSignedByJobtitle());
            map.put("vComments", comments);
            map.put("vFooter", "");

            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);

            final String emailBody = engine.process("cm/BidIt/generic-signatureflow.html", ctx);
            if (emailBody != null && !emailBody.isEmpty()) {
                msg.setMessageText(emailBody);
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Email Template not Found.");
                return;
            }

            Boolean emailStatus = MailSender.sendEmailDefault(mailSession, msg);

            if (emailStatus) {
                ntfTrackService.save("cm", functionality, msg);
            }
        }
    }

    @Override
    public List<CmBiditSigninfo> buildSignList(ManageITHeader header, ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(header.getClientid(), request.getParams().get("rowId"), request.getParams().get("isAdmin"), request.getParams().get("code"), request.getParams().get("shortName"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        List<CmBiditSigninfo> ds = list(new ManageITBodyRequest(0, 0)
                .filter("clientId", NumberSupport.getBigInteger(header.getClientid()))
                .filter("refId", NumberSupport.getBigDecimal(request.getParams().get("rowId")))
                .filter("typeId.code", StringSupport.getString(request.getParams().get("code")))
                .filter("typeId.shortName", StringSupport.getString(request.getParams().get("shortName")))
                .sorted("signOrder", "asc"));
        if (ds != null && !ds.isEmpty()) {
            ds = brToValidateAllowed(ds, header, StringSupport.getBoolean(request.getParams().get("isAdmin")));
            ds = brToValidateEnable(ds);
        }
        return ds;
    }

    private List<CmBiditSigninfo> brToValidateAllowed(List<CmBiditSigninfo> ds, ManageITHeader header, Boolean isAdmin) {
        ds.forEach(it -> {
            it.setAllowToSign(qmClientRoleMatrixService.hasRoleRigth(header, isAdmin, it.getSignflowId().getSignRuleName()));
        });
        return ds;
    }

    private List<CmBiditSigninfo> brToValidateEnable(List<CmBiditSigninfo> ds) {
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
    public Boolean isSignedOff(BigInteger clientId, BigInteger refId, String code, String shortName) {
        if (clientId == null || refId == null || StringSupport.isNullOrEmpty(code, shortName)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        List<GlobSystemSimpleCat> typeList = globSystemSimpleCatService.list(new ManageITBodyRequest(0, 2).filter("clientId", clientId).filter("code", code).filter("shortName", shortName).filter("active", 'Y'));
        if (typeList == null || typeList.isEmpty() || typeList.size() > 1) {
            log.error(String.format("Wrong database configuration for GlobSystemSimpleCat for code : '%s' and shortName: '%s' with client: '%s'", code, shortName, clientId));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            return false;
        }
        return dao.isSignedOff(clientId, refId, typeList.get(0).getId().toBigInteger());
    }
}
