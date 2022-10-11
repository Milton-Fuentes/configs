/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.service.glob.GlobDispatchcallLogService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.view.VwWorkOrderService;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.calendar.CalendarResourcesDataTO;
import com.atser.tools.atserutil.objects.to.dispatch.DispatchRequestTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
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
import javax.annotation.security.PermitAll;
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
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan Query Parameters f: filter ("!=", "=", ">", "<", "%=", ":=")
 * o: order (value+asc) l: length s: start t: type
 */
@Path("/glob/dispatchcalllog")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobDispatchcallLogRS implements IBaseWSException {

    @EJB
    GlobDispatchcallLogService dispatchCallLogService;

    @EJB
    protected InitializeEnv env;

    @EJB
    GlobFileService fileService;

    @EJB
    StorageService storageService;
    
    @EJB
    VwWorkOrderService vwWorkOrderService;

    @GET
    @Path("/datatable/list/to")
    public Object woGetServiceListToForDatatable(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dispatchCallLogService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }
    
    @GET
    @Path("/datatable/vwworkorderlist")
    public Object woGetServiceListandallToForDatatable(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwWorkOrderService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list/to")
    public Object woGetServiceListTo(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dispatchCallLogService.listTo(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object woGetServiceList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dispatchCallLogService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object woServiceList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return dispatchCallLogService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return dispatchCallLogService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<DispatchRequestTO> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "generateWo": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            dispatchCallLogService.createWoWithNumbers(request.getBody().getParams().get("id").toString());
                            return dispatchCallLogService.findDispatchRequestTOById(request.getHeader(), request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return dispatchCallLogService.findDispatchRequestTOById(request.getHeader(), request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        dispatchCallLogService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        dispatchCallLogService.saveDispatchRequestTO(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.updateDispatchRequestTO(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "updateWo": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.updateWoFromDispatchRequestTO(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "cancelCall": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "value"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.cancelCallLog(request.getHeader(), StringSupport.getString(request.getBody().getParams().get("id")), StringSupport.getString(request.getBody().getParams().get("value")));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "cancelWo": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "value"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.cancelWo(request.getHeader(), StringSupport.getString(request.getBody().getParams().get("id")), StringSupport.getString(request.getBody().getParams().get("value")),
                                StringSupport.getString(request.getBody().getParams().get("reason")));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "woCompleted": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "value"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.woCompleted(request.getHeader(), StringSupport.getString(request.getBody().getParams().get("id")), StringSupport.getString(request.getBody().getParams().get("value")));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "copy": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        return dispatchCallLogService.copyRequest(request.getHeader(), request.getBody().getParams().get("id").toString());
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/workorder/external")
    public Response generateWOReportFromExternalSource(@QueryParam("t") String wotoken, @QueryParam("rId") String rId, @QueryParam("h") String clientId) throws IOException, Exception {
        if (StringSupport.isNullOrEmpty(wotoken) || StringSupport.isNullOrEmpty(rId) || StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        String tplbasePath = env.getDefaultTplPath() + "/jasper/";
        String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
        String filePath = dispatchCallLogService.generateExternalWoReport(rId, tplbasePath, docpathsegment, wotoken, "pdf", clientId);
        if (filePath != null) {
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            return rpb.build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generateReport(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = dispatchCallLogService.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
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
    @Path("/ntf/technician")
    public Object notifyTechnician(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"callIdList"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            dispatchCallLogService.notifyTechnicians(request.getBody(), env.getPropertiesMap().get("server_domain"), env.getEmailTplEngine());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/ntf/discard")
    public Object notificationDiscard(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"callIdList"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            dispatchCallLogService.discardNotification(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/calendar")
    public Object dispatchCalendar(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate() && request.getBody().getParams() != null && request.getBody().getParams().containsKey("projectId")
                && StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {

            String action = request.getBody().getAction();
            switch (action) {
                case "data": {
                    return dispatchCallLogService.buildDispatchCalendar(request.getHeader(), request.getBody());
                }

                case "resource": {
                    return dispatchCallLogService.buildDispatchCalendarResources(request.getHeader(), request.getBody());
                }
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/calendar")
    public Response generateCalendarReport(@QueryParam("dt") String docType, @QueryParam("pId") String projectId, @QueryParam("rsfilter") String resourceFilter,
            @QueryParam("cdate") String CurrentDate, @QueryParam("cview") String CurrentView, @QueryParam("caction") String CurrentAction, @QueryParam("cid") String clientId) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(docType) && StringSupport.isNotNullAndNotEmpty(projectId) && StringSupport.isNotNullAndNotEmpty(CurrentDate)
                && StringSupport.isNotNullAndNotEmpty(CurrentView)) {
            ManageITRequest<Object> request = new ManageITRequest<>();
            ManageITBodyRequest<Object> body = new ManageITBodyRequest<>();
            ManageITHeader header = new ManageITHeader();
            header.setClientid(clientId);
            AtserLinkedHashMap<String, Object> params = new AtserLinkedHashMap<>();
            params.put("docType", docType);
            params.put("projectId", projectId);
            params.put("resourceFilter", resourceFilter);
            params.put("CurrentDate", CurrentDate);
            params.put("CurrentView", CurrentView);
            params.put("CurrentAction", CurrentAction);
            body.setParams(params);
            request.setBody(body);
            request.setHeader(header);
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String tplpath = tplbasePath + "calendar/dispatch_agenda.jasper";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = dispatchCallLogService.generateCalendarReport(tplbasePath, tplpath, docpathsegment, request.getBody(), request.getHeader());
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            return rpb.build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadFiles(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Dispatch");
        notify();
    }

    @POST
    @Path("/v1/schedule")
    public Object dispatchSchedule(ManageITRequest<GlobSheduleSearchDefParam> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate() && StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {

            String action = request.getBody().getAction();
            switch (action) {
                case "data": {
                    return dispatchCallLogService.buildDispatchSchedule(request.getHeader(), request.getBody().getData());
                }

                case "resource": {
                    return dispatchCallLogService.buildAllDispatchCalendarResources(request.getHeader(), request.getBody().getData());
                }
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/schedule/crud")
    public Object scheduleCrud(ManageITRequest<CalendarResourcesDataTO> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        dispatchCallLogService.saveCalendarResourcesDataTO(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.updateCalendarResourcesDataTO(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "moveTo": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "startTime", "hours", "event"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        dispatchCallLogService.moveWOSchedule(request.getHeader(), StringSupport.getString(request.getBody().getParams().get("id")),
                                StringSupport.getString(request.getBody().getParams().get("startTime")),
                                NumberSupport.getBigDecimal(request.getBody().getParams().get("hours")), NumberSupport.getBigInteger(request.getBody().getParams().get("ownerId")),
                                StringSupport.getString(request.getBody().getParams().get("event")));
                        return Response.status(Response.Status.OK).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v1/schedule/generate/barcodes")
    public Response generateScheduleBarcodeReport(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        ManageITRequest request = ApiCommon.buildAdvanceFilter(uriInfo);
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramDocType = (queryParams.get("t") != null && queryParams.get("t").size() >= 1) ? queryParams.get("t").get(0) : null;
        String paramTypePrint = (queryParams.get("p") != null && queryParams.get("p").size() >= 1) ? queryParams.get("p").get(0) : null;
        String paramReportId = (queryParams.get("rId") != null && queryParams.get("rId").size() >= 1) ? queryParams.get("rId").get(0) : null;
        String paramReqId = (queryParams.get("reqId") != null && queryParams.get("reqId").size() >= 1) ? queryParams.get("reqId").get(0) : null;
        String paramSetNo = (queryParams.get("setNo") != null && queryParams.get("setNo").size() >= 1) ? queryParams.get("setNo").get(0) : null;
        String paramSpecNo = (queryParams.get("specNo") != null && queryParams.get("specNo").size() >= 1) ? queryParams.get("specNo").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = dispatchCallLogService.generateScheduleBarcodeReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody(), paramReqId, paramSetNo, paramSpecNo);
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
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/v1/generate/barcodes")
    public Response generatePostBarcodes(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{
                "docType",
                "printType",
                "reportId",
                "functionId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            String tplbasePath = env.getDefaultTplPath() + "/jasper/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = dispatchCallLogService.generateGlobalBarcodes(tplbasePath, docpathsegment, request.getHeader(), request.getBody());
            if (filePath != null) {
                File file = new File(filePath);
                Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                if (StringSupport.getString(request.getBody().getParams().get("printType")).equals("1")) {
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
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/schedule/report")
    public Response generatePostScheduleReport(ManageITRequest<GlobSheduleSearchDefParam> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getData().reportId)) {
                String tplbasePath = env.getDefaultTplPath() + "/jasper/";
                String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
                String filePath = dispatchCallLogService.generateScheduleReport(tplbasePath, docpathsegment, request.getHeader(), request.getBody().getData());
                if (filePath != null) {
                    File file = new File(filePath);
                    Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                    if (request.getBody().getData().printType != null && request.getBody().getData().printType.equals("1")) {
                        rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
                    } else {
                        rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                    }

                    return rpb.build();
                }
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @PermitAll
    @Path("/images/list/bywoid")
    public Object getImagesListByWOId(@QueryParam("t") String wotoken) throws IOException, Exception {
        if (StringSupport.isNullOrEmpty(wotoken)) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }
        return dispatchCallLogService.getImageListByWoToken(wotoken);
    }

    @GET
    @Path("/v1/select/list")
    public Object getDispatchSelectList(@QueryParam("clientId") String clientId) throws JsonParseException, JsonMappingException, IOException {
        if (StringSupport.isNullOrEmpty(clientId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        return dispatchCallLogService.getDispatchSelectList(NumberSupport.getBigInteger(clientId));
    }
}
