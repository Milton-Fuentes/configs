/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.bpm;

import com.atser.tools.atserejb.model.BpmClientProcessCatg;
import com.atser.tools.atserejb.service.bpm.BpmClientProcessCatgService;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import java.io.IOException;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import com.atser.tools.atserejb.service.bpm.BpmOperatorService;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.PermitAll;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/bpm")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class BpmOperatorRS implements IBaseWSException {

    @EJB
    BpmOperatorService bpmOperatorService;

    @EJB
    BpmClientProcessCatgService bpmClientProcessCatgService;

    @EJB
    private InitializeEnv env;

    /**
     * Get timeline
     *
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     * @throws BonitaException
     */
    @POST
    @Path("/request/timeline")
    public Object getRequestTimeline(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (request.getBody().getParams().isContainsAllKeys(new String[]{"id"})) {
                try {
                    return bpmOperatorService.getRequestTimeLine(env.getBonitaBpmSession(), Long.valueOf(request.getBody().getParams().get("id").toString()));
                } catch (BonitaException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                }

            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    /**
     * To do tasks
     *
     * @param request
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     * @throws BonitaException
     */
    @POST
    @Path("/v1/tasks/pending")
    public Object getPendingHumanTaskInstances(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            return bpmOperatorService.getPendingHumanTaskInstances(env.getBonitaBpmSession(),
                    request.getHeader().getUser(), request.getHeader().getClientid());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/tasks/assigned")
    public Object getAssignedHumanTaskInstances(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            return bpmOperatorService.getAssignedHumanTaskInstances(env.getBonitaBpmSession(),
                    request.getHeader().getUser(), request.getHeader().getClientid());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/v1/humantask/datagrid/list")
    public Object searchHumanTasks(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return bpmOperatorService.searchHumanTasks(env.getBonitaBpmSession(), ApiCommon.buildBonitaSearchOptionsBuilder(uriInfo));
    }
    
    @GET
    @Path("/v1/archivedhumantask/datagrid/list")
    public Object getArchivedHumanTasks(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return bpmOperatorService.searchMyArchivedHumanTasks(env.getBonitaBpmSession(), ApiCommon.buildBonitaSearchOptionsBuilder(uriInfo));
    }

    /**
     * Process Operator
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ProcessActivationException
     * @throws ProcessExecutionException
     * @throws ContractViolationException
     * @throws BonitaException
     */
    @POST
    @Path("/v1/process/operator")
    public Object bpmProcessOperator(ManageITRequest<Object> request) throws IOException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (env.getBonitaBpmSession().isSessionActive()) {
            if (request != null && request.validate()) {
                if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                    String action = request.getBody().getAction();
                    switch (action) {
                        case "start": {
                            if (request.getBody().getParams() == null) {
                                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                            }
                            if (request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"entityId"})) {
                                Map<String, Serializable> map = new HashMap<>();
                                map.put("entityId", Long.valueOf(StringSupport.getString(request.getBody().getParams().get("entityId"))));
                                String processName = null;
                                if (StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("pCatgId"))) {
                                    BpmClientProcessCatg process = bpmClientProcessCatgService.findById(StringSupport.getString(request.getBody().getParams().get("pCatgId")));
                                    if (process == null) {
                                        throwBaseException(Response.Status.BAD_REQUEST, "Wrong process Information.");
                                    }
                                    processName = process.getProcessName();
                                } else if (StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("pName"))) {
                                    processName = StringSupport.getString(request.getBody().getParams().get("pName"));
                                } else {
                                    throwBaseException(Response.Status.BAD_REQUEST, "Missing process parameter.");
                                }
                                // Start Process
                                bpmOperatorService.StartProcess(env.getBonitaBpmSession(), request.getHeader(), processName, map);
                                return Response.status(Response.Status.OK).build();
                            } else {
                                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Contract Information.");
                            }
                            break;
                        }

                        case "cancel": {
                            if (request.getBody().getParams() == null) {
                                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                            }
                            if (!request.getBody().getParams().isContainsAllKeys(new String[]{"caseId"})) {
                                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
                            }
                            bpmOperatorService.CancelProcessInstance(env.getBonitaBpmSession(), Long.valueOf(request.getBody().getParams().get("caseId").toString()));
                            return Response.status(Response.Status.OK).build();
                        }
                        case "status": {
                            break;
                        }
                    }
                } else {
                    throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
                }
            }

            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }
    }

    @GET
    @Path("/disable/user")
    public Object disableUser(@QueryParam("u") String userId, @QueryParam("s") String status) throws IOException {
        if (StringSupport.isNullOrEmpty(userId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        try {
            bpmOperatorService.DisableUser(env.getBonitaBpmSession(), userId, status);
        } catch (BonitaException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @PermitAll
    @Path("/insert/user")
    public Object insertUser(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (request.getBody().getParams().isContainsAllKeys(new String[]{"id"})) {
                try {
                    bpmOperatorService.InsertUserInformation(env.getBonitaBpmSession(), request.getBody().getParams().get("id").toString());
                } catch (BonitaException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                }

            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @PermitAll
    @Path("/update/user")
    public Object updateUser(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (request.getBody().getParams().isContainsAllKeys(new String[]{"id"})) {
                try {
                    bpmOperatorService.UpdateUserInformation(env.getBonitaBpmSession(), request.getBody().getParams().get("id").toString());
                } catch (BonitaException ex) {
                    throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                }

            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/humanTask")
    public Object getHumanTask(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> paramFilter = queryParams.get("f");
        List<String> paramCount = queryParams.get("c");

        if (paramFilter == null || paramFilter.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Integer count = 5;
        if (paramCount != null && !paramCount.isEmpty()) {
            try {
                count = Integer.valueOf(paramCount.get(0));
            } catch (NumberFormatException e) {
                count = 5;
            }
        }
        Map<String, Object> paramsFilterMap = paramFilter.stream().map(s -> s.split("=", 2)).collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));

        return env.getBonitaBpmSession().filterHumanTaskDefinition(paramsFilterMap, count);
    }
}
