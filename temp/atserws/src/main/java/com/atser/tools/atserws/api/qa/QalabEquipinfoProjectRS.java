/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.service.qa.QalabEquipinfoProjectV1Service;
import com.atser.tools.atserutil.file.FileSupport;
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
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.atser.tools.atserejb.service.qa.QalabEquipinfoProjectV2Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/qa/labequipinfoproject")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QalabEquipinfoProjectRS implements IBaseWSException {

    @EJB
    private QalabEquipinfoProjectV2Service qalabEquipinfoProjectV2Service;
    
    @EJB
    private QalabEquipinfoProjectV1Service qalabEquipinfoProjectV1Service;
    
    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/v2/datatable/list")
    public Object datatableListv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV2Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v2/datagrid/list")
    public Object datatableGridListv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV2Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v2/list")
    public Object filterv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV2Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v2/list")
    public Object listv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabEquipinfoProjectV2Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v2/findbyid")
    public Object findByIdv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return qalabEquipinfoProjectV2Service.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v2/generate/report")
    public Response generateEquipLogReportv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = qalabEquipinfoProjectV2Service.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
            if (filePath != null) {
                File file = new File(filePath);
                Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                if (paramTypePrint != null && paramTypePrint.equals("1")) {
                    rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
                } else {
                    rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                }

                return rpb.build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    /*------------------- Version 1 ----------------------------------------- */
    
    @GET
    @Path("/v1/datatable/list")
    public Object datatableListv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV1Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/datagrid/list")
    public Object datatableGridListv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV1Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/list")
    public Object filterv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEquipinfoProjectV1Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object listv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabEquipinfoProjectV1Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/findbyid")
    public Object findByIdv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return qalabEquipinfoProjectV1Service.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v1/generate/report")
    public Response generateEquipLogReportv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = qalabEquipinfoProjectV1Service.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
            if (filePath != null) {
                File file = new File(filePath);
                Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                if (paramTypePrint != null && paramTypePrint.equals("1")) {
                    rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
                } else {
                    rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                }

                return rpb.build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
