/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.service.qa.QaInspectionSigninfoService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
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
import javax.ws.rs.QueryParam;
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
@Path("/qa/inspectionsigninfo")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaInspectionSigninfoRS implements IBaseWSException {
    
    @EJB
    private QaInspectionSigninfoService qaInspectionSigninfoService;
    
    @EJB
    protected InitializeEnv env;
    
    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaInspectionSigninfoService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaInspectionSigninfoService.dataGridList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/list")
    public Object filter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaInspectionSigninfoService.list(ApiCommon.buildFilter(uriInfo));
    }
    
    @POST
    @Path("/list")
    public Object list(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaInspectionSigninfoService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return qaInspectionSigninfoService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }
        
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @POST
    @Path("/sign")
    public Object signInspection(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                log.error("@ATSER: signInspection - Wrong parameters");
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            String serverPath = env.getDefaultUploadPath() + "/";
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String serverdomain = env.getPropertiesMap().get("server_domain");
            qaInspectionSigninfoService.signInspection(request.getHeader(), request.getBody(), serverPath, tplbasePath, docpathsegment, serverdomain, env.getEmailTplEngine());
        }
        
        return Response.status(Response.Status.OK).build();
    }
    
    @POST
    @Path("/signbr/list")
    public Object signBRuleList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"inspectionId", "isAdmin"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return qaInspectionSigninfoService.buildSignList(request.getHeader(), request.getBody());
        }
        
        return Response.status(Response.Status.OK).build();
    }
    
    @GET
    @Path("/issignedoff")
    public Object isInspectionSignedOff(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        if (StringSupport.isNullOrEmpty(id)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        return qaInspectionSigninfoService.isInspectionSignedOff(NumberSupport.getBigInteger(id));
    }
    
    @GET
    @Path("/version")
    public Object getVersion(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qaInspectionSigninfoService.getVersion(Integer.valueOf(number));
    }
    
    @GET
    @Path("/version/list")
    public Object getVersionList(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qaInspectionSigninfoService.getRevisions(id);
    }
}
