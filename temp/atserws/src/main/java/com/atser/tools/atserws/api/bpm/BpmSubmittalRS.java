/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.bpm;

import com.atser.tools.atserejb.model.Bpmsubmittalbo;
import com.atser.tools.atserejb.model.Bpmsubmittalmetadata;
import com.atser.tools.atserejb.service.bpm.BpmSubmittalMetaDataService;
import com.atser.tools.atserejb.service.bpm.BpmSubmittalService;
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
@Path("/bpm/submittal")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class BpmSubmittalRS implements IBaseWSException {

    @EJB
    BpmSubmittalService bpmSubmittalService;

    @EJB
    GlobFolderService folderService;

    @EJB
    GlobFileService fileService;

    @EJB
    BpmSubmittalMetaDataService bpmSubMetaDataService;

    @EJB
    protected InitializeEnv env;

    @EJB
    StorageService storageService;

    @POST
    @Path("/crud")
    public Object submittalBoCrud(ManageITRequest<Bpmsubmittalbo> request) throws JsonParseException, JsonMappingException, IOException, ProcessActivationException, ProcessExecutionException, ContractViolationException, BonitaException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        if (request.getBody().getParams().containsKey("id")) {
                            return bpmSubmittalService.findById(request.getBody().getParams().get("id").toString());
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
                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFSubmittal);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }
                        // save subMetadata
                        Bpmsubmittalmetadata submetadata = new Bpmsubmittalmetadata();
                        submetadata.setPersistenceversion(BigInteger.ZERO);
                        submetadata.setRevision("00");
                        bpmSubMetaDataService.save(submetadata);

                        // save submittal
                        request.getBody().getParams().put("subnumber", response.get("nextStep"));
                        BigInteger subId = bpmSubmittalService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody(), submetadata);

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("persistenceId", subId.toString());
                        result.put("dcDataPid", submetadata.getPersistenceid().toString());
                        result.put("subNumber", response.get("nextStep"));
                        return result;
                    }
                    case "update": {
                        if (request.getBody().getData() == null && request.getBody().getParams() == null && request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        if (request.getBody().getParams() != null && request.getBody().getParams().get("nativeBpm") != null) {
                            bpmSubmittalService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), Objects.toString(request.getBody().getParams().get("submitOrig"), null), null);
                        } else if (env.getBonitaBpmSession() != null && env.getBonitaBpmSession().isSessionActive()) {
                            bpmSubmittalService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), env.getBonitaBpmSession());
                        } else {
                            bpmSubmittalService.update(request.getBody().getData());
                        }
                        /*if (env.getBonitaBpmSession() != null && env.getBonitaBpmSession().isSessionActive()) {
                            bpmSubmittalService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), env.getBonitaBpmSession());
                        } else if (request.getBody().getParams() != null && request.getBody().getParams().get("nativeBpm") != null) {
                            bpmSubmittalService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData(), request.getBody().getParams().get("submitOrig").toString(), null);
                        } else {
                            bpmSubmittalService.update(request.getBody().getData());
                        }*/
                        return Response.status(Response.Status.CREATED).build();
                    }
                    case "list": {
                        return bpmSubmittalService.list(request.getBody());
                    }
                    case "revision": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        request.getBody().getParams().put("revision", null);
                        Map<String, String> response = folderService.createBPMFolderTrackIt(request.getHeader().getUserid(), request.getBody(), eManageITFolder.eFSubmittal);
                        if (response.get("rootFolderId") == null) {
                            throwBaseException(Response.Status.INTERNAL_SERVER_ERROR, "Wrong results of the query.");
                        }

                        String nextStep = response.get("nextStep");

                        // save subMetadata
                        Bpmsubmittalmetadata submetadata = new Bpmsubmittalmetadata();
                        submetadata.setPersistenceversion(BigInteger.ZERO);
                        submetadata.setRevision(nextStep.substring(nextStep.length() - 2, nextStep.length()));
                        bpmSubMetaDataService.save(submetadata);

                        // save submittal
                        request.getBody().getParams().put("subnumber", response.get("nextStep"));
                        BigInteger subId = bpmSubmittalService.save(NumberSupport.getBigInteger(response.get("rootFolderId")), request.getBody(), submetadata);

                        Map<String, String> result = new HashMap<>();
                        result.put("folderId", response.get("rootFolderId"));
                        result.put("subNumber", nextStep);
                        result.put("persistenceId", subId.toString());
                        result.put("dcDataPid", submetadata.getPersistenceid().toString());
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
    public Object submittalCaseCrud(ManageITRequest<Bpmsubmittalbo> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "cancel": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }

                        // Must be reimplement to connect to BPM Engine
                        return bpmSubmittalService.cancel(request.getBody());
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
    public synchronized void uploadSubmittal(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Submittals");
        notify();
    }

    @POST
    @Path("/files/delete")
    public Object deleteSubmittal(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (bpmSubmittalService.isDraft(request.getBody())) {
                fileService.delete(request.getBody());
            }
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/generate/transmittal")
    public Object generateTransmittal(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null && !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "subnumber", "contractId", "finalRemark", "finalStatus", "clientId", "userId", "folderId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            AtserLinkedHashMap<String, Object> params = request.getBody().getParams();
            String tplpath = env.getDefaultTplPath() + "/jasper/" + "SubmittalTransmittal.jasper";
            String pdfpath = env.getDefaultUploadPath() + "/" + params.get("clientId") + "/" + params.get("projectId") + "/" + params.get("contractId") + "/";
            Map<String, Object> metaDataFile = FileSupport.getMetaDataServerFilename("Transmittal_Letter.pdf", pdfpath);
            String targetPath = bpmSubmittalService.generateTransmittal(env.getBonitaBpmSession(), tplpath, StringSupport.emptyOnNull(metaDataFile.get("filename")), request.getBody());
            metaDataFile = FileSupport.getFileMetaData(targetPath, metaDataFile);
            fileService.saveFileToDb(metaDataFile, params, "Submittals");
        }

        return Response.status(Response.Status.OK).build();
    }

    // -------------------------------------------------------------------------
    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return bpmSubmittalService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/totalbystatus")
    public Object getTotalByStatus(@QueryParam("c") String clientId, @QueryParam("p") String projectId) throws JsonParseException, JsonMappingException, IOException {
        return bpmSubmittalService.getTotalByStatus(new BigDecimal(clientId), new BigDecimal(projectId));
    }

    // -------------------------------------------------------------------------
    @POST
    @Path("/metadata/crud")
    public Object metaDataCrud(ManageITRequest<Bpmsubmittalmetadata> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
                        }
                        if (request.getBody().getParams().containsKey("id")) {
                            return bpmSubMetaDataService.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
                        }
                        break;
                    }
                    case "update": {
                        if (request.getBody().getData() == null && request.getBody().getParams() == null && request.getBody().getParams().isContainsAllKeys(new String[]{"submitOrig"})) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        bpmSubMetaDataService.update(request.getBody().getData());
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
            String filePath = bpmSubmittalService.generateReport(paramReportId, paramFunctId, tplbasePath, docpathsegment, paramDocType, request.getHeader(), request.getBody());
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
