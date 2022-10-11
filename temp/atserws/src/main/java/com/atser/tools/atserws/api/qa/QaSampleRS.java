/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.service.qa.QaSampleService;
import com.atser.tools.atserutil.enumerator.eEntryPoint;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import javax.ejb.EJB;
import javax.enterprise.util.Nonbinding;
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
@Path("/qa/sample")
@WsSecured(entrypoint = eEntryPoint.any)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaSampleRS implements IBaseWSException {

    @EJB
    QaSampleService qaSampleService;

    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/list")
    public Object projectFilter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaSampleService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object projectList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaSampleService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return qaSampleService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/searchsamples")
    public Object searchSamples(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{
                "dtSearchUrl",// By Default
                "startIndex",// By Default
                "maxResults",// By Default
                "sortBy",// By Default
                "sortDir", // By Default
                "clientName",
                "projectId",
                "functionId",
                "startDate",
                "endDate",
                //"labLocationId",
                "sampleRegionId",
                "labId",
                "category",
                "isAdmin",
                "multiproject",
                "usesWorkorder",
                "isAllDateActive",
                "showInactive",
                "usesPayItem",
                "usesRoleMatrix",
                "useGlobalProfiles"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return qaSampleService.getFrontEndSearchSample(request.getHeader(), request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qaSampleService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generatePostReport(ManageITRequest<ReportGridWrapper> request) throws IOException, Exception {
        if (request.getBody().getData() == null || request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{
            "dtSearchUrl",// By Default
            "startIndex",// By Default
            "maxResults",// By Default
            "sortBy",// By Default
            "sortDir", // By Default
            "clientName",
            "projectId",
            "functionId",
            "startDate",
            "endDate",
            "sampleRegionId",
            "labId",
            "category",
            "isAdmin",
            "multiproject",
            "usesWorkorder",
            "isAllDateActive",
            "showInactive",
            "usesPayItem",
            "usesRoleMatrix",
            "useGlobalProfiles"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
        String filePath = qaSampleService.generateReport(request.getHeader(), request.getBody(), docpathsegment);
        if (filePath != null) {
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            if (request.getBody().getData().getTypePrint() != null && request.getBody().getData().getTypePrint().equals("1")) {
                rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            } else {
                rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            }

            return rpb.build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
