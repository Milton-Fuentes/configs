/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.bpm;

import com.atser.tools.atserejb.model.Bpmrfibo;
import com.atser.tools.atserejb.model.Bpmrfimetadata;
import com.atser.tools.atserejb.service.bpm.BpmRFIMetaDataService;
import com.atser.tools.atserejb.service.bpm.BpmRFIService;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.atser.tools.atserutil.number.NumberSupport;
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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
import org.bonitasoft.engine.bpm.contract.ContractViolationException;
import org.bonitasoft.engine.bpm.process.ProcessActivationException;
import org.bonitasoft.engine.bpm.process.ProcessExecutionException;
import org.bonitasoft.engine.exception.BonitaException;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/bpm/rfi")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class BpmRFIRS implements IBaseWSException {

    @EJB
    BpmRFIService bpmRFIService;

    @EJB
    GlobFolderService folderService;

    @EJB
    GlobFileService fileService;

    @EJB
    StorageService storageService;

    @EJB
    BpmRFIMetaDataService bpmRFIMetaDataService;

    @EJB
    protected InitializeEnv env;

    @POST
    @Path("/crud")
    public Object rfiBoCrud(ManageITRequest<Bpmrfibo> request) throws JsonParseException, JsonMappingException, IOException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        if (request.getBody().getParams().containsKey("id")) {
                            return bpmRFIService.findById(request.getBody().getParams().get("id").toString());
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
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFRFI);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }
                        // save rfiMetadata
                        Bpmrfimetadata rmetadata = new Bpmrfimetadata();
                        rmetadata.setPersistenceversion(BigInteger.ZERO);
                        rmetadata.setRevision("00");
                        bpmRFIMetaDataService.save(rmetadata);

                        // save submittal
                        request.getBody().getParams().put("rfinumber", response.get("nextStep"));
                        BigInteger subId = bpmRFIService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody(), rmetadata);

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("persistenceId", subId.toString());
                        result.put("dcDataPid", rmetadata.getPersistenceid().toString());
                        result.put("rfiNumber", response.get("nextStep"));
                        return result;
                    }
                    case "update": {
                        if (request.getBody().getData() == null && request.getBody().getParams() == null && request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        if (request.getBody().getParams() != null && request.getBody().getParams().get("nativeBpm") != null) {
                            bpmRFIService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), Objects.toString(request.getBody().getParams().get("submitOrig"), null), null);
                        } else if (env.getBonitaBpmSession() != null && env.getBonitaBpmSession().isSessionActive()) {
                            bpmRFIService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), env.getBonitaBpmSession());
                        } else {
                            bpmRFIService.update(request.getBody().getData());
                        }
                        /* if (env.getBonitaBpmSession() != null && env.getBonitaBpmSession().isSessionActive()) {
                            bpmRFIService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), env.getBonitaBpmSession());
                        } else if (request.getBody().getParams() != null && request.getBody().getParams().get("nativeBpm") != null) {
                            bpmRFIService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), null);
                        } else {
                            bpmRFIService.update(request.getBody().getData());
                        }*/
                        return Response.status(Response.Status.CREATED).build();
                    }
                    case "list": {
                        return bpmRFIService.list(request.getBody());
                    }
                    case "revision": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        request.getBody().getParams().put("revision", null);
                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFRFI);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }

                        String nextStep = response.get("nextStep");

                        // save subMetadata
                        Bpmrfimetadata rmetadata = new Bpmrfimetadata();
                        rmetadata.setPersistenceversion(BigInteger.ZERO);
                        rmetadata.setRevision(nextStep.substring(nextStep.length() - 2, nextStep.length()));
                        bpmRFIMetaDataService.save(rmetadata);

                        // save submittal
                        request.getBody().getParams().put("rfinumber", response.get("nextStep"));
                        BigInteger subId = bpmRFIService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody(), rmetadata);

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("rfiNumber", nextStep);
                        result.put("persistenceId", subId.toString());
                        result.put("dcDataPid", rmetadata.getPersistenceid().toString());
                        return result;
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
    public Object rfisubmittalCaseCrud(ManageITRequest<Bpmrfibo> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "cancel": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }

                        // Must be reimplement to connect to BPM Engine
                        return bpmRFIService.cancel(request.getBody());
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
    public synchronized void uploadRFI(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "RFI");
        notify();
    }

    @POST
    @Path("/files/delete")
    public Object deleteRFI(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (bpmRFIService.isDraft(request.getBody())) {
                fileService.delete(request.getBody());
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/generate/transmittal")
    public Object generateRFITransmittal(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "subnumber", "contractId", "finalRemark", "finalStatus", "clientId", "userId", "folderId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            AtserLinkedHashMap<String, Object> params = request.getBody().getParams();
            String tplpath = env.getDefaultTplPath() + "/jasper/" + "RFITransmittal.jasper";
            String pdfpath = env.getDefaultUploadPath() + "/" + params.get("clientId") + "/" + params.get("projectId") + "/" + params.get("contractId") + "/";
            Map<String, Object> metaDataFile = FileSupport.getMetaDataServerFilename("Transmittal_Letter.pdf", pdfpath);
            String targetPath = bpmRFIService.generateTransmittal(env.getBonitaBpmSession(), tplpath, StringSupport.emptyOnNull(metaDataFile.get("filename")), request.getBody());
            metaDataFile = FileSupport.getFileMetaData(targetPath, metaDataFile);
            fileService.saveFileToDb(metaDataFile, params, "RFI");
        }

        return Response.status(Response.Status.OK).build();
    }

    // -------------------------------------------------------------------------
    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return bpmRFIService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/totalbystatus")
    public Object getTotalByStatus(@QueryParam("c") String clientId, @QueryParam("p") String projectId) throws JsonParseException, JsonMappingException, IOException {
        return bpmRFIService.getTotalByStatus(new BigDecimal(clientId), new BigDecimal(projectId));
    }

    @GET
    @Path("/chart/bystatus")
    public Object chartColumns(@QueryParam("c") String clientId) throws JsonParseException, JsonMappingException, IOException {
        return bpmRFIService.getChartDataByStatus(new BigDecimal(clientId));
    }

    // -------------------------------------------------------------------------
    @POST
    @Path("/metadata/crud")
    public Object metaDataCrud(ManageITRequest<Bpmrfimetadata> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        if (request.getBody().getParams().containsKey("id")) {
                            return bpmRFIMetaDataService.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
                        }
                        break;
                    }
                    case "update": {
                        if (request.getBody().getData() == null && request.getBody().getParams() == null && request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        bpmRFIMetaDataService.update(request.getBody().getData());
                        return Response.status(Response.Status.CREATED).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
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
            String filePath = bpmRFIService.generateReport(paramReportId, paramFunctId, tplbasePath, docpathsegment, paramDocType, request.getHeader(), request.getBody());
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
