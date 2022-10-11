/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QaconcMixdesignMaster;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.qa.QaconcMixdesignMasterService;
import com.atser.tools.atserutil.enumerator.parser.eConcMixDesign;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.objects.to.qa.ImportConcMixDesignTO;
import com.atser.tools.atserutil.parser.excel.plugin.mixdesign.concrete.ConcMixDesignPluginDirector;
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
@Path("/qa/concmixdesignmaster")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaconcMixdesignMasterRS implements IBaseWSException {

    @EJB
    private QaconcMixdesignMasterService qaconcMixdesignMasterService;

    @EJB
    StorageService storageService;
    
    @EJB
    GlobFileService fileService;

    @EJB
    private InitializeEnv env;
    
    @POST
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadFiles(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Global Concrete Mix Design");
        notify();
    }

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixdesignMasterService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixdesignMasterService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaconcMixdesignMasterService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<QaconcMixdesignMaster> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qaconcMixdesignMasterService.findById(request.getHeader(), request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaconcMixdesignMasterService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaconcMixdesignMasterService.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qaconcMixdesignMasterService.update(request.getHeader(), request.getBody().getData());
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
        return qaconcMixdesignMasterService.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/version/list")
    public Object getVersionList(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixdesignMasterService.getRevisions(id);
    }

    @POST
    @Path("/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qaconcMixdesignMasterService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/filterbyproject")
    public Object listFilterByProject(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"projectId", "supplierLocId"})
                    || StringSupport.isNullOrEmpty(request.getBody().getParams().get("projectId"))
                    || StringSupport.isNullOrEmpty(request.getBody().getParams().get("supplierLocId"))) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return qaconcMixdesignMasterService.filterByProject(request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("supplierId").toString(), request.getBody().getParams().get("supplierLocId").toString());
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
            qaconcMixdesignMasterService.assignToProject(request.getHeader(), request.getBody().getParams().get("projectId").toString(), request.getBody().getParams().get("mixId").toString());
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
            String filePath = qaconcMixdesignMasterService.generateReport(paramReportId, tplbasePath, docpathsegment, paramDocType, request.getHeader().getClientid(), request.getBody());
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

    @POST
    @Path("/to/save")
    public Object saveTo(ManageITRequest<ImportConcMixDesignTO> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() != null) {
                return qaconcMixdesignMasterService.saveFromTo(request.getHeader(), request.getBody().getData());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
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

        if (StringSupport.isNotNullAndNotEmpty(paramClientId)) {
            String tplbasePath = env.getPropertiesMap().get("tpl_drive") + env.getPropertiesMap().get("tpl_folder") + "/excel/";
            String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
            String filePath = qaconcMixdesignMasterService.generateExcelTemplate(paramClientId, tplbasePath, docpathsegment);
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
    public Object importConcMixDesign(MultipartFormDataInput content) throws IOException {
        UploadModel model = storageService.process(content, env.getDefaultUploadPath());;
        try {
            return parserAndGetJson(StringSupport.emptyOnNull(model.getMetaDataFile().get("filename")), "AtserConcMixDesignTpl", model.getParams());
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
                FileSupport.removeFile(StringSupport.emptyOnNull(model.getMetaDataFile().get("filename")));
            } catch (IOException e) {
                throwBaseException(Response.Status.BAD_REQUEST, e.getMessage());
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Object parserAndGetJson(String pPath, String pTemplate, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        ConcMixDesignPluginDirector director = new ConcMixDesignPluginDirector(new File(pPath), eConcMixDesign.valueOf(pTemplate));
        return director.getModel();
    }
}
