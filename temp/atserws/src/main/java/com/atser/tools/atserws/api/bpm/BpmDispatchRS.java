/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.bpm;

import com.atser.tools.atserejb.model.Bpmdispatchbo;
import com.atser.tools.atserejb.service.bpm.BpmDispatchService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.mail.BpmMailMessage;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.PermitAll;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.enterprise.util.Nonbinding;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.CookieParam;
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
@Path("/bpm/dispatch")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class BpmDispatchRS implements IBaseWSException {

    @EJB
    BpmDispatchService bpmDispatchService;

    @EJB
    GlobFolderService folderService;

    @EJB
    GlobUserService userService;

    @EJB
    GlobFileService fileService;

    @EJB
    StorageService storageService;
    
    @EJB
    protected InitializeEnv env;

    @POST
    @Path("/mail/send")
    @Asynchronous
    public void bpmSendMail(ManageITRequest<BpmMailMessage> request) {
        if (request != null && request.validate() && request.getBody().getData() != null
                && StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
            String ncc = env.getPropertiesMap().get("notification_bpm_cc");
            bpmDispatchService.sendEmail(env.getEmailTplEngine(), request, ncc, env.isNotification_bpm_track_enable());
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
    }

    @POST
    @Path("/calendar")
    public Object dispatchCalendar(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate() && request.getBody().getParams() != null && request.getBody().getParams().containsKey("projectId")
                && StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {

            String action = request.getBody().getAction();
            switch (action) {
                case "data": {
                    return bpmDispatchService.buildDispatchCalendar(request.getBody());
                }

                case "resource": {
                    return bpmDispatchService.buildDispatchCalendarResources(request.getBody());
                }
            }
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Malformed Request.");
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/bdm/report")
    public Object DispatchBdmReports(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        List<String> reportFilter = queryParams.get("r");
        List<String> paramFilter = queryParams.get("p");

        Map<String, String> paramsMap = null;

        if (paramFilter != null && !paramFilter.isEmpty()) {
            paramsMap = paramFilter.stream().map(s -> s.split("=", 2)).collect(Collectors.toMap(a -> a[0], a -> a.length > 1 ? a[1] : ""));
        }

        if (reportFilter == null || reportFilter.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return bpmDispatchService.buildReport(reportFilter.get(0), paramsMap);
    }

    @GET
    @Path("/bdm/list")
    public Object DispatchBdmList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return bpmDispatchService.list(ApiCommon.buildFilter(uriInfo), env.getBonitaBpmSession());
    }

    @GET
    @Path("/bdm/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return bpmDispatchService.dataTableList(ApiCommon.buildFilter(uriInfo), env.getBonitaBpmSession());
    }

    @GET
    @Path("/bdm/workorder/list")
    public Object DispatchRequestList(@QueryParam("id") String persistenceId, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        if ((persistenceId != null && !persistenceId.isEmpty())) {
            return bpmDispatchService.wolist(persistenceId);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/bdm/workorder/log")
    public Object updateLogData(ManageITRequest<WorkOrderTO> request) throws JsonParseException, ParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        bpmDispatchService.updateRequestLogHours(request.getBody());
                        return Response.status(Response.Status.OK).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/bdm/workorder")
    public Object manageWO(ManageITRequest<List<WorkOrderTO>> request) throws JsonParseException, ParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "update": {
                        if (request.getBody().getParams() == null || request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        bpmDispatchService.manageRequestLog(request.getBody(), env.getBonitaBpmSession(), request.getHeader().getUser());
                        return Response.status(Response.Status.OK).build();
                    }

                    case "update_hours": {
                        if (request.getBody().getParams() == null || request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        bpmDispatchService.manageRequestLog(request.getBody(), env.getBonitaBpmSession(), request.getHeader().getUser());
                        return Response.status(Response.Status.OK).build();
                    }

                    case "cancel": {
                        if (request.getBody().getParams() == null || request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        //bpmDispatchService.manageRequestLog(request.getBody());
                        return Response.status(Response.Status.OK).build();
                    }

                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        if (request.getBody().getParams().containsKey("logId")) {
                            return bpmDispatchService.findRequestLogById(request.getBody().getParams().get("logId").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
                        }
                        break;
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object dispatchBoCrud(ManageITRequest<Bpmdispatchbo> request) throws JsonParseException, JsonMappingException, IOException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id")) {
                            return bpmDispatchService.findById(request.getBody().getParams().get("id").toString(), env.getBonitaBpmSession());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
                        }
                        break;
                    }

                    case "remove": {
                        break;
                    }
                    case "insert": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }

                        if (!request.getBody().getParams().isContainsAllKeys(new String[]{"datetimereqOnjobsite", "created", "status", "requestorId", "reqSource"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
                        }

                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFDispatch);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }

                        // save
                        request.getBody().getParams().put("requestnumber", response.get("nextStep"));
                        BigInteger[] rArray = bpmDispatchService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody());

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("persistenceId", rArray[1].toString());
                        result.put("requestnumber", response.get("nextStep"));
                        return result;
                    }
                    case "update": {
                        if (request.getBody().getData() == null && request.getBody().getParams() == null && request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        if (env.getBonitaBpmSession().isSessionActive()) {
                            bpmDispatchService.update(request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), env.getBonitaBpmSession());
                        } else {
                            bpmDispatchService.update(request.getBody().getData());
                        }
                        return Response.status(Response.Status.CREATED).build();
                    }
                    case "updatepartial": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        bpmDispatchService.updateData(request.getBody().getData());
                        return Response.status(Response.Status.CREATED).build();
                    }
                    case "rollback": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        if (env.getBonitaBpmSession().isSessionActive()) {
                            bpmDispatchService.createRollback(request.getBody(), env.getBonitaBpmSession());
                        }
                        return Response.status(Response.Status.CREATED).build();
                    }
                    case "list": {
                        return bpmDispatchService.list(request.getBody(), env.getBonitaBpmSession());
                    }
                    case "revision": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        request.getBody().getParams().put("revision", null);
                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFDispatch);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }

                        String nextStep = response.get("nextStep");

                        // save
                        request.getBody().getParams().put("requestnumber", response.get("nextStep"));
                        BigInteger[] rArray = bpmDispatchService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody());

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("requestnumber", nextStep);
                        result.put("parentId", rArray[0].toString());
                        result.put("persistenceId", rArray[1].toString());
                        return result;
                    }
                    case "reassign": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        return bpmDispatchService.reAssignTech(request.getBody(), env.getBonitaBpmSession());
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/case")
    public Object dispatchCaseCrud(ManageITRequest<Bpmdispatchbo> request) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "cancel": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        return bpmDispatchService.cancelRequest(request.getBody(), env.getBonitaBpmSession());
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadDispatchDocs(MultipartFormDataInput content) throws IOException, BonitaException {
        storageService.store(content, env.getDefaultUploadPath(), "Dispatch");
        notify();
    }

    @POST
    @Path("/files/delete")
    public Object deleteDispatchDocs(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (bpmDispatchService.isDraft(request.getBody())) {
                fileService.delete(request.getBody());
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/generate/transmittal")
    public Object generateTransmittal(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"persistenceId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            String tplpath = env.getDefaultTplPath() + "/jasper/" + "DispatchTransmittal.jasper";
            String pdfpathsegment = env.getDefaultUploadPath() + "/";
            bpmDispatchService.generateTransmittal(env.getBonitaBpmSession(), tplpath, pdfpathsegment, request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/workorder/external")
    public Response generateWOReportFromExternalSource(@QueryParam("t") String wotoken) throws IOException, Exception {
        if (wotoken == null || wotoken.isEmpty()) {
            throwBaseException(Response.Status.UNAUTHORIZED, "Wrong Request.");
        }

        String tplpath = env.getDefaultTplPath() + "/jasper/" + "DispatchWO.jasper";
        String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
        String filePath = bpmDispatchService.generateExternalWoReport(env.getBonitaBpmSession(), tplpath, docpathsegment, wotoken, "pdf");
        File file = new File(filePath);
        Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
        rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        return rpb.build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/workorder")
    public Response generateWOReport(@QueryParam("f") String persistenceId, @QueryParam("t") String doctype, @QueryParam("p") String isprint, @QueryParam("w") String iswo) throws IOException, Exception {
        if (persistenceId == null || persistenceId.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }

        String tplpath = env.getDefaultTplPath() + "/jasper/" + "DispatchWO.jasper";
        String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
        Boolean isWo = (iswo != null && iswo.equals("1"));
        String filePath = bpmDispatchService.generateWoReport(env.getBonitaBpmSession(), tplpath, docpathsegment, persistenceId, doctype, isWo);
        File file = new File(filePath);
        Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
        if (isprint != null && isprint.equals("1")) {
            rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        } else {
            rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        }

        return rpb.build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/workorder/filter")
    public Response generateWOReportByID(@QueryParam("f") String paramFilter, @QueryParam("t") String doctype, @QueryParam("p") String isprint) throws IOException, Exception {
        if (paramFilter == null || paramFilter.isEmpty()) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }

        String[] map = paramFilter.split(",");

        String tplpath = env.getDefaultTplPath() + "/jasper/" + "DispatchWO.jasper";
        String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
        String filePath = bpmDispatchService.generateWoReportByFilter(env.getBonitaBpmSession(), tplpath, docpathsegment, doctype, map);
        File file = new File(filePath);
        Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
        if (isprint != null && isprint.equals("1")) {
            rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        } else {
            rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
        }

        return rpb.build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/calendar")
    public Response generateCalendarReport(@QueryParam("dt") String docType, @QueryParam("pId") String projectId, @QueryParam("rsfilter") String resourceFilter,
            @QueryParam("rfilter") String roleFilter, @QueryParam("cdate") String CurrentDate, @QueryParam("cview") String CurrentView,
            @QueryParam("caction") String CurrentAction, @QueryParam("locfilter") String locFilter, @QueryParam("tracefilter") String traceFilter) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(docType) && StringSupport.isNotNullAndNotEmpty(projectId) && StringSupport.isNotNullAndNotEmpty(CurrentDate)
                && StringSupport.isNotNullAndNotEmpty(CurrentView)) {
            ManageITRequest<Object> request = new ManageITRequest<>();
            ManageITBodyRequest<Object> body = new ManageITBodyRequest<>();
            AtserLinkedHashMap<String, Object> params = new AtserLinkedHashMap<>();
            params.put("docType", docType);
            params.put("projectId", projectId);
            params.put("resourceFilter", resourceFilter);
            params.put("roleFilter", roleFilter);
            params.put("CurrentDate", CurrentDate);
            params.put("CurrentView", CurrentView);
            params.put("CurrentAction", CurrentAction);
            params.put("locationFilter", locFilter);
            params.put("traceFilter", traceFilter);
            body.setParams(params);
            request.setBody(body);
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/jasper/";
            String tplpath = tplbasePath + "calendar/dispatch_agenda.jasper";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = bpmDispatchService.generateCalendarReport(tplbasePath, tplpath, docpathsegment, request.getBody());
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            return rpb.build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/ntf/technicians")
    public Object notifyTechnicians(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"persistenceId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            bpmDispatchService.notifyTechnicians(request.getBody().getParams().get("persistenceId").toString(), env.getPropertiesMap().get("server_domain"), env.getEmailTplEngine());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/br/checktechanswer")
    public Object brCheckTechniciansAnswer(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"persistenceId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }

            return bpmDispatchService.getTechniciansAnsweredStatus(request.getBody().getParams().get("persistenceId").toString());
        }

        return Response.status(Response.Status.OK).build();
    }

}
