/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QaaspmMixdesignMaster;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.qa.QaaspmMixdesignMasterService;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserutil.enumerator.parser.eAspmMixDesign;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.objects.to.qa.ImportAspmMixDesignTO;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.AspmMixDesignPluginDirector;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
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
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/qa/aspmmixdesignmaster")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaaspmMixdesignMasterRS implements IBaseWSException {

    @EJB
    private QaaspmMixdesignMasterService qaaspmMixdesignMasterService;

    @EJB
    GlobFileService fileService;

    @EJB
    protected WsDocTemplateService wsDocTemplateService;

    @EJB
    protected InitializeEnv env;

    @EJB
    StorageService storageService;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaaspmMixdesignMasterService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaaspmMixdesignMasterService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaaspmMixdesignMasterService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<QaaspmMixdesignMaster> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qaaspmMixdesignMasterService.findById(request.getHeader(), request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaaspmMixdesignMasterService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaaspmMixdesignMasterService.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qaaspmMixdesignMasterService.update(request.getHeader(), request.getBody().getData());
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
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadFiles(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Global Asphalt Mix Design");
        notify();
    }

    @POST
    @Path("/files/delete")
    public Object deleteFile(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            fileService.delete(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/version")
    public Object getVersion(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qaaspmMixdesignMasterService.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/version/list")
    public Object getVersionList(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qaaspmMixdesignMasterService.getRevisions(id);
    }

    @POST
    @Path("/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qaaspmMixdesignMasterService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/filterbyproject")
    public Object listFilterByProject(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"projectId", "prodId", "prodLocId", "nmasId", "gyrationId", "pMixTypeId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return qaaspmMixdesignMasterService.filterByProject(request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("prodId").toString(), request.getBody().getParams().get("prodLocId").toString(),
                    request.getBody().getParams().get("nmasId").toString(), request.getBody().getParams().get("gyrationId").toString(), request.getBody().getParams().get("pMixTypeId").toString());
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/assigntoproject")
    public Object assignToProject(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "mixId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qaaspmMixdesignMasterService.assignToProject(request.getHeader(), request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("mixId").toString());
        }

        return Response.status(Response.Status.OK).build();
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
            String filePath = qaaspmMixdesignMasterService.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
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

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/template")
    public Response generateExcelTemplate(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramClientId = (queryParams.get("cId") != null && queryParams.get("cId").size() >= 1) ? queryParams.get("cId").get(0) : null;
        String paramSetId = (queryParams.get("stId") != null && queryParams.get("stId").size() >= 1) ? queryParams.get("stId").get(0) : null;

        if (StringSupport.isNotNullAndNotEmpty(paramClientId) && StringSupport.isNotNullAndNotEmpty(paramSetId)) {
            String tplbasePath = env.getDefaultTplPath() + "/excel/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = qaaspmMixdesignMasterService.generateExcelTemplate(paramClientId, paramSetId, tplbasePath, docpathsegment);
            if (StringSupport.isNullOrEmpty(filePath)) {
                return Response.status(Response.Status.NO_CONTENT).build();
            }
            File file = new File(filePath);
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
            return rpb.build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/import")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object importAspmMixDesign(MultipartFormDataInput content) throws IOException {
        UploadModel fileModel = storageService.process(content, env.getDefaultUploadPath());
        try {
            return parserAndGetJson(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")), fileModel.getParams());
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
        } catch (FileNotFoundException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "File not found.");
        } catch (TemplateDifferentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, "Invalid document.");
        } catch (ExcelParsingException | EmptyDocumentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, ex.getMessage());
        } finally {
            try {
                FileSupport.removeFile(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")));
            } catch (IOException e) {
                throwBaseException(Response.Status.BAD_REQUEST, e.getMessage());
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Object parserAndGetJson(String pPath, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        WsDocTemplate rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(params.get("clientId")), "fc_importaspmmixdesign", "excel");
        if (rp == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
        }
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        AspmMixDesignPluginDirector director = new AspmMixDesignPluginDirector(new File(pPath), eAspmMixDesign.valueOf(rp.getDocCode()));
        return director.getModel();
    }

    @POST
    @Path("/to/save")
    public Object saveTo(ManageITRequest<ImportAspmMixDesignTO> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() != null) {
                return qaaspmMixdesignMasterService.saveFromTo(request.getHeader(), request.getBody().getData());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
