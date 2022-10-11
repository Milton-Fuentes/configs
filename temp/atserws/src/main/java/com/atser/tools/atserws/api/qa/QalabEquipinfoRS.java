/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QalabEquipinfoV1;
import com.atser.tools.atserejb.model.QalabEquipinfoV2;
import com.atser.tools.atserejb.service.qa.QalabEquipinfoV1Service;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.atser.tools.atserejb.service.qa.QalabEquipinfoV2Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 * Query Parameters
 * f: filter ("!=", "=", ">", "<", "%=", ":=")
 * o: order (value+asc)
 * l: length
 * s: start
 * t: type
 */
@Path("/qa/labequipinfo")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QalabEquipinfoRS implements IBaseWSException {

    @EJB
    QalabEquipinfoV2Service qalabEqinfoV2Service;
    
    @EJB
    QalabEquipinfoV1Service qalabEqinfoV1Service;

    @EJB
    protected InitializeEnv env;
    
    /*----------------- VERSION 2 --------------------------------------------*/

    @GET
    @Path("/v2/datatable/list")
    public Object datatableListv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV2Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/v2/datagrid/list")
    public Object datatableGridListv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV2Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v2/list")
    public Object filterListByGetv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV2Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v2/list")
    public Object filterListByPostv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabEqinfoV2Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v2/crud")
    public Object crudv2(ManageITRequest<QalabEquipinfoV2> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qalabEqinfoV2Service.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabEqinfoV2Service.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabEqinfoV2Service.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qalabEqinfoV2Service.update(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v2/active")
    public Object changeStatusv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qalabEqinfoV2Service.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/v2/list/maintduedate")
    public Object getMaintDueDateListv2(@QueryParam("pid") String rowId) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(rowId)) {
            return qalabEqinfoV2Service.listMaintDueDate(rowId);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v2/generate/equiplog")
    public Response generateEquipLogReportv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = qalabEqinfoV2Service.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
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
    
    @POST
    @Path("/v2/assigntoproject")
    public Object assignToProjectv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "equipId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qalabEqinfoV2Service.assignToProject(request.getHeader(), request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("equipId").toString());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/v2/version")
    public Object getVersionv2(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV2Service.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/v2/version/list")
    public Object getVersionListv2(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV2Service.getRevisions(id);
    }
    
    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v2/generate/barcodes")
    public Response generateEquipBarcodeReportv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;
        String paramReqId = (queryParams.get("reqId") != null && queryParams.get("reqId").size() >= 1) ? queryParams.get("reqId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = qalabEqinfoV2Service.generateEquipBarcode(tplbasePath, docpathsegment, paramReportId, paramDocType, request.getHeader().getClientid(), request.getBody(), paramReqId);
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
    
    /*----------------- VERSION 1 --------------------------------------------*/
    
    @GET
    @Path("/v1/datatable/list")
    public Object datatableListv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV1Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/v1/datagrid/list")
    public Object datatableGridListv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV1Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/list")
    public Object filterListByGetv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV1Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object filterListByPostv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabEqinfoV1Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/crud")
    public Object crudv1(ManageITRequest<QalabEquipinfoV1> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qalabEqinfoV1Service.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabEqinfoV1Service.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabEqinfoV1Service.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qalabEqinfoV1Service.update(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/active")
    public Object changeStatusv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qalabEqinfoV1Service.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/v1/list/maintduedate")
    public Object getMaintDueDateListv1(@QueryParam("pid") String rowId) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(rowId)) {
            return qalabEqinfoV1Service.listMaintDueDate(rowId);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v1/generate/equiplog")
    public Response generateEquipLogReportv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = qalabEqinfoV1Service.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
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
    
    @POST
    @Path("/v1/assigntoproject")
    public Object assignToProjectv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "equipId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qalabEqinfoV1Service.assignToProject(request.getHeader(), request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("equipId").toString());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/v1/version")
    public Object getVersionv1(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV1Service.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/v1/version/list")
    public Object getVersionListv1(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qalabEqinfoV1Service.getRevisions(id);
    }
    
    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v1/generate/barcodes")
    public Response generateEquipBarcodeReportv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;
        String paramReqId = (queryParams.get("reqId") != null && queryParams.get("reqId").size() >= 1) ? queryParams.get("reqId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = qalabEqinfoV1Service.generateEquipBarcode(tplbasePath, docpathsegment, paramReportId, paramDocType, request.getHeader().getClientid(), request.getBody(), paramReqId);
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
