/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobNotfUserDao;
import com.atser.tools.atserejb.model.GlobNotfUser;
import com.atser.tools.atserejb.model.GlobNotfUserModel;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Stateless
@Slf4j
public class GlobNotfUserServiceImpl implements GlobNotfUserService, IBaseEJBException {

    @Inject
    private GlobNotfUserDao dao;

    @Inject
    private WsDocTemplateService wsDocTemplateService;

    @Override
    public GlobNotfUser findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobNotfUser findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobNotfUser elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobNotfUser elem) {
        if (elem != null) {
            GlobNotfUser model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<GlobNotfUser> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<GlobNotfUserModel> findAllUserModelInPendingStatus(String module, String functionality, BigInteger clientId, BigInteger userId) {
        if (clientId != null && userId != null && StringSupport.isNotNullAndNotEmpty(module) && StringSupport.isNotNullAndNotEmpty(functionality)) {
            return dao.findAllUserModelInPendingStatus(module, functionality, clientId, userId);
        }
        return null;
    }

    @Override
    public void updateUserModelStatus(String module, String functionality, BigInteger clientId, BigInteger userId) {
        if (clientId != null && userId != null && StringSupport.isNotNullAndNotEmpty(module) && StringSupport.isNotNullAndNotEmpty(functionality)) {
            dao.updateUserModelStatus(module, functionality, clientId, userId);
        }
    }

    private List<Map<String, String>> getModelList(String module, String functionality, BigInteger clientId, BigInteger userId) {
        List<GlobNotfUserModel> list = findAllUserModelInPendingStatus(module, functionality, clientId, userId);
        List<Map<String, String>> rpList = new ArrayList<>();
        list.forEach(it -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                Map<String, String> readmap = mapper.readValue(it.getModelId().getContent(), Map.class);
                rpList.add(readmap);
            } catch (IOException ex) {
                Logger.getLogger(GlobNotfUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        // Sort By Test Name
        rpList.sort(Comparator.comparing(m -> m.get("test_name"),Comparator.nullsLast(Comparator.naturalOrder())));
        return rpList;
    }

    @Override
    public BpmMailMessage getPackMailMessageByUser(TemplateEngine engine, String module, String functionality, BigInteger clientId, BigInteger userId, String email, String subject, String emailFrom) {
        List<Map<String, String>> list = getModelList(module, functionality, clientId, userId);
        if (list != null && !list.isEmpty()) {
            WsDocTemplate rp = wsDocTemplateService.findDocTemplate(clientId, module + "_" + functionality, "html");
            if (rp == null || StringSupport.isNullOrEmpty(rp.getDocPath())) {
                log.error(String.format("Wrong Document Template configuration for client '%s'.", clientId));
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
            }
            BpmMailMessage response = new BpmMailMessage();
            response.setSubject(subject);
            response.setFrom(emailFrom);
            response.setRefId(StringSupport.getString(userId));
            response.setTo(new String[]{email});
            Map<String, Object> map = new HashMap<>();
            map.put("testList", list);
            final Context ctx = new Context(Locale.ENGLISH);
            ctx.setVariables(map);
            final String emailBody = engine.process(rp.getDocPath(), ctx);
            if (emailBody != null && !emailBody.isEmpty()) {
                response.setMessageText(emailBody);
            } else {
                log.error(String.format("Procesor: Email Template not Found for client '%s'.", clientId));
                throwBaseException(Response.Status.BAD_REQUEST, "Procesor: Email Template not Found.");
            }

            return response;
        }
        return null;
    }

}
