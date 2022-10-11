/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.view;

import com.atser.tools.atserejb.service.view.VwBpmSubmittalAllService;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.enterprise.util.Nonbinding;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author dperez
 */
@Path("/vm/bpm/submittalall")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class VwBpmSubmittalAllRS implements IBaseWSException {

    @EJB
    VwBpmSubmittalAllService service;

    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return service.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/totalbystatus")
    public Object getTotalByStatus(@QueryParam("c") String clientId, @QueryParam("p") String projectId) throws JsonParseException, JsonMappingException, IOException {
        return service.getTotalByStatus(new BigDecimal(clientId), new BigDecimal(projectId));
    }

    @GET
    @Path("/totaloverdue")
    public Object getTotalOverdue(@QueryParam("c") String clientId, @QueryParam("p") String projectId) throws JsonParseException, JsonMappingException, IOException {
        return service.getTotalOverdue(new BigDecimal(clientId), new BigDecimal(projectId));
    }

    @POST
    @Path("/daysbyprocess")
    public Object getDaysByProcess(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return service.getDaysByProcess(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generateReport(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;
        String paramFunctId = (queryParams.get("fId") != null && queryParams.get("fId").size() >= 1) ? queryParams.get("fId").get(0) : null;
        String paramProjectId = (queryParams.get("pId") != null && queryParams.get("pId").size() >= 1) ? queryParams.get("pId").get(0) : null;

        if (paramProjectId != null) {
            request.getBody().setParams(new AtserLinkedHashMap<>());
            request.getBody().getParams().put("projectId", paramProjectId);
        }
        if (StringSupport.isNotNullAndNotEmpty(paramReportId, paramFunctId)) {
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = service.generateReport(paramReportId, paramFunctId, tplbasePath, docpathsegment, paramDocType, request.getHeader(), request.getBody());
            if (StringSupport.isNullOrEmpty(filePath)) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            if (paramTypePrint != null && paramTypePrint.equals("1")) {
                rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            } else {
                rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            }

            return rpb.build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
