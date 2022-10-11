/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.service.glob.GlobProjectService;
import com.atser.tools.atserutil.enumerator.eEntryPoint;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/glob/project")
@WsSecured(entrypoint = eEntryPoint.any)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobProjectRS implements IBaseWSException {

    @EJB
    GlobProjectService projectService;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return projectService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/list")
    public Object projectFilter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return projectService.list(ApiCommon.buildFilter(uriInfo));
    }
    
    @POST
    @Path("/list")
    public Object projectList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return projectService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return projectService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/getdetailsbyid")
    public Object getDetailsById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                return projectService.getProjectDetails(StringSupport.getString(request.getBody().getParams().get("id")));
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            projectService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Path("/listinlab")
    public Object projectListInLab(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"clientId"})
                    || StringSupport.isNullOrEmpty(request.getBody().getParams().get("clientId"))) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return projectService.getProjectListInLabForSelect(NumberSupport.getBigInteger(request.getBody().getParams().get("clientId")));
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/byprofile")
    public Object projectListByProfile(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"status", "isAdmin", "multiproject", "useMultipleLocation", "useGlobalProfiles", "projectSetup", "useAllowReadOnlyLabs"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return projectService.getFrontEndProjectListByCurrentProfile(request.getHeader(), request.getBody());
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/byfunctionprofile")
    public Object projectListByFunctionProfile(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"functionId", "isAdmin", "useGlobalProfiles"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return projectService.getFrontEndProjectListByFunctionProfile(request.getHeader(), request.getBody());
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/list/forselect")
    public Object projectFilterForSelect(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return projectService.getAllProjectsForSelect(ApiCommon.buildFilter(uriInfo));
    }
}
