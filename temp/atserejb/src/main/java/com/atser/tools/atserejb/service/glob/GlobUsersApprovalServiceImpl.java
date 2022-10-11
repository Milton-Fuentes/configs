/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserejb.common.interceptor.annotation.UpdateMethod;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.glob.GlobUsersApprovalDao;
import com.atser.tools.atserejb.model.GlobClient;
import com.atser.tools.atserejb.model.GlobClientModules;
import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserejb.model.GlobProfiles;
import com.atser.tools.atserejb.model.GlobRoles;
import com.atser.tools.atserejb.model.GlobUsers;
import com.atser.tools.atserejb.model.GlobUsersApproval;
import com.atser.tools.atserejb.service.helper.SystemNotificationHelperService;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.mail.SystemMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.thymeleaf.TemplateEngine;

@Stateless
@Slf4j
public class GlobUsersApprovalServiceImpl implements GlobUsersApprovalService, IBaseEJBException {

    @Inject
    private GlobUsersApprovalDao dao;

    @Inject
    private GlobClientService globClientService;

    @Inject
    private GlobUserService globUserService;

    @Inject
    private GlobContactService globContactService;

    @Inject
    private GlobProfilesService globProfilesService;

    @Inject
    private GlobRolesService globRolesService;

    @Inject
    private GlobClientModulesService globClientModulesService;

    @Inject
    private SystemNotificationHelperService systemNotificationHelperService;

    @Override
    public GlobUsersApproval findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public GlobUsersApproval findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    @SaveMethod
    public BigDecimal save(ManageITHeader header, GlobUsersApproval elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(elem.getEmail(), elem.getUsername())) {
                log.error("Missing required parameters.");
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Missing required parameters.");
            }
            if (dao.existsGlobalByEmail(elem.getEmail()) || dao.existsGlobalByUsername(elem.getUsername())) {
                log.error("Username/Email already exists.");
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Username/Email already exists.");
            }
            elem.setUniqueToken(StringSupport.generateUUID());
            Optional<GlobClient> client = globClientService.findByCompanyName(elem.getClientName());
            if (!client.isPresent()) {
                log.error(String.format("The client name: '%s' was not found in the database", elem.getClientName()));
                throwBaseException(Response.Status.EXPECTATION_FAILED, "Wrong Request !");
            }
            elem.setRequestedClientId(client.get().getId().toBigInteger());
            elem.setApproved('N');
            return dao.save(elem).getId();
        }
        return BigDecimal.ZERO;
    }

    @Override
    @UpdateMethod
    public void update(ManageITHeader header, GlobUsersApproval elem) {
        if (elem != null) {
            GlobUsersApproval model = findById(elem.getId());
            if (!model.equals(elem)) {
                dao.update(populate(model, elem));
            }
        }
    }

    private GlobUsersApproval populate(GlobUsersApproval model, GlobUsersApproval elem) {
        model.setUsername(elem.getUsername());
        model.setFirstName(elem.getFirstName());
        model.setLastName(elem.getLastName());
        model.setCompanyName(elem.getCompanyName());
        model.setEmail(elem.getEmail());
        model.setLastMod(elem.getLastMod());
        model.setLastModBy(elem.getLastModBy());
        model.setLastModIp(elem.getLastModIp());
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
    public DataTableWrapper<GlobUsersApproval> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobUsersApproval> finalList = list(request);
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
    public DataGridWrapper<GlobUsersApproval> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public List<GlobUsersApproval> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
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
    public void approveUser(ManageITHeader header, ManageITBodyRequest<Object> request, TemplateEngine engine) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        GlobUsersApproval model = findById(request.getParams().get("id").toString());
        if (model != null && model.getApproved() == 'N') {
            try {
                if (StringSupport.getActiveAsCharacter(StringSupport.getString(request.getParams().get("status")).toUpperCase()) == 'Y') {
                    Optional<GlobClient> parentClientId = globClientService.findByCompanyName(model.getClientName());
                    if (!parentClientId.isPresent()) {
                        log.error(String.format("Parent Client '%s' not found !", model.getClientName()));
                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                    }
                    log.info(String.format("Approving User: %s", model.getUsername()));
                    model.setApproved('Y');
                    model.setApprovedBy(header.getUser());
                    model.setApprovedByClientId(NumberSupport.getBigInteger(header.getClientid()));
                    model.setApprovedDate(new Date());
                    dao.update(model);
                    log.info(String.format("User : %s have been approved.", model.getUsername()));
                    // Generating Password
                    String generatedPassword = RandomStringUtils.randomAlphanumeric(12);
                    String subject, messageText, moduleName, roleName;
                    Optional<GlobClient> clientId;
                    // Customize variables by Module
                    log.info("Customizing User Variables by Module");
                    switch (model.getModuleName()) {
                        case "bidit": {
                            subject = "Welcome to ATSER Bid-IT";
                            messageText = "BidIT";
                            moduleName = "BIDIT";
                            roleName = "bidit_bidder";
                            clientId = globClientService.findByCompanyName("atser_bidit");
                            if (!clientId.isPresent()) {
                                log.error(String.format("Client '%s' not found !", "atser_bidit"));
                                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                            }
                            break;
                        }
                        default: {
                            log.error(String.format("Module '%s' not found !", model.getModuleName()));
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                            return;
                        }
                    }

                    log.info("Creating GlobContact Information");
                    // Add Contact
                    GlobContact contactId = createContactInformation(clientId.get(), model);
                    log.info("Creating GlobUser Information");
                    // Add User
                    GlobUsers userId = addUserInformation(header, contactId, model, generatedPassword);
                    // Add Default Profile
                    log.info("Creating Default Profile");
                    GlobProfiles profileId = addDefaultProfile(clientId.get(), userId.getId(), moduleName, roleName);
                    // Update User Default Profile
                    userId.setDefaultProfile(profileId.getId().toBigInteger());
                    globUserService.update(header, userId);
                    // Send Email
                    notifyUserApproval(header, engine, model, generatedPassword, messageText, subject);
                }
            } catch (BaseException ex) {
                log.error(ex.getError());
                throwBaseException(Response.Status.BAD_REQUEST, ex.getError());
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
    }

    private void notifyUserApproval(ManageITHeader header, TemplateEngine engine, GlobUsersApproval model, String generatedPassword, String messageText, String subject) {
        SystemMessage msg = new SystemMessage();
        msg.setMessageText(messageText);
        msg.setRefId(model.getId().toString());
        msg.setIsSmsActive(Boolean.FALSE);
        msg.setFunctionality("user_approval_notification");
        msg.setTo(new String[]{model.getEmail()});
        msg.setSubject(subject);
        LinkedHashMap senderInfo = new AtserLinkedHashMap();
        senderInfo.put("username", model.getUsername());
        senderInfo.put("password", generatedPassword);
        msg.setSenderInfo(senderInfo);
        systemNotificationHelperService.notify(header, engine, msg, "UserApprovalNotificationTpl");
    }

    private GlobContact createContactInformation(GlobClient clientId, GlobUsersApproval model) {
        GlobContact ct = new GlobContact();
        ct.setFirstname(model.getFirstName());
        ct.setLastname(model.getLastName());
        ct.setEmail(model.getEmail());
        ct.setCompanyName(model.getCompanyName());
        StringBuilder sign = new StringBuilder();
        sign.append(model.getFirstName()).append(" ").append(model.getLastName());
        ct.setPrintedSign(sign.toString());
        ct.setClientId(clientId.getId().toBigInteger());
        ct.setActive('Y');
        globContactService.save(ct);
        return ct;
    }

    private GlobUsers addUserInformation(ManageITHeader header, GlobContact contactId, GlobUsersApproval model, String generatedPassword) {
        GlobUsers user = new GlobUsers();
        user.setStation("na");
        user.setPassValidDays((short) 180);
        user.setUserFilter("NO");
        user.setBookmark("dashboard.jsp");
        user.setResetPass('N');
        user.setStatus((short) 0);
        user.setUserid(model.getUsername());
        user.setPass(generatedPassword);
        user.setPersoninfoId(null);
        user.setContactid(contactId);
        globUserService.save(header, user);
        return user;
    }

    private GlobProfiles addDefaultProfile(GlobClient clientId, BigDecimal userId, String moduleName, String roleName) {
        GlobProfiles p = new GlobProfiles();
        // Get Module
        Optional<GlobClientModules> moduleId = globClientModulesService.findByClientAndModuleName(clientId.getId(), moduleName);
        if (!moduleId.isPresent()) {
            log.error(String.format("'%s' Module not found !", moduleName));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong System Module Configuration.");
        }
        // Get Role Id
        Optional<GlobRoles> roleId = globRolesService.findByRoleName(roleName);
        if (!roleId.isPresent()) {
            log.error(String.format("'%s' Role not found !", roleName));
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong System Role Configuration.");
        }
        p.setClientId(clientId);
        p.setReadonly('N');
        p.setIsPreferred("Y");
        p.setModuleId(moduleId.get().getModuleId().getId().toBigInteger());
        p.setRoleId(roleId.get());
        p.setProjectId(BigInteger.ZERO);
        p.setUserId(userId.toBigInteger());
        globProfilesService.save(p);
        return p;
    }

    @Override
    public Optional<GlobUsersApproval> findByUsername(String username) {
        if(StringSupport.isNullOrEmpty(username)) {
            log.error("Null/Empty username variable");
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request !");
        }
        return dao.findByUsername(username);
    }

}
