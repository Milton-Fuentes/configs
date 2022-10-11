/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.service.glob.GlobUserService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserutil.enumerator.parser.eUserInformation;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.objects.to.glob.ImportUserTO;
import com.atser.tools.atserutil.parser.excel.plugin.globuser.GlobUserPluginDirector;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonParseException;
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
@Path("glob/users")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobUserRS implements IBaseWSException {

    @EJB
    protected GlobUserService globUserService;

    @EJB
    StorageService storageService;

    @EJB
    protected WsDocTemplateService wsDocTemplateService;

    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/list")
    public Object clientFilter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws com.fasterxml.jackson.core.JsonParseException, JsonMappingException, IOException {
        return globUserService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object clientList(ManageITRequest<Object> request) throws com.fasterxml.jackson.core.JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return globUserService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws com.fasterxml.jackson.core.JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return globUserService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/to/save")
    public Object crud(ManageITRequest<ImportUserTO> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() != null) {
                return globUserService.saveFromTo(request.getHeader(), request.getBody().getData(), env.getBonitaBpmSession());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/import")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object importUsers(MultipartFormDataInput content) throws IOException {
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

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/template")
    public Response generateExcelTemplate(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramClientId = (queryParams.get("cId") != null && queryParams.get("cId").size() >= 1) ? queryParams.get("cId").get(0) : null;
        ZipSecureFile.setMinInflateRatio(0L);
        if (StringSupport.isNotNullAndNotEmpty(paramClientId)) {
            String tplbasePath = env.getDefaultTplPath() + "/excel/";
            String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
            String filePath = globUserService.generateExcelTemplate(paramClientId, tplbasePath, docpathsegment);
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

    private Object parserAndGetJson(String pPath, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException, IOException, EmptyDocumentException {
        WsDocTemplate rp = wsDocTemplateService.findDocTemplate(NumberSupport.getBigInteger(params.get("clientId")), "fc_importuser", "excel");
        if (rp == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Document Template configuration for this client.");
        }
        ZipSecureFile.setMinInflateRatio(0);
        ZipSecureFile.setMaxTextSize(512);
        GlobUserPluginDirector director = new GlobUserPluginDirector(new File(pPath), eUserInformation.valueOf(rp.getDocCode()));
        return director.getUserInformationModel();
    }

    /*@GET
    @Path("/reader")
    public Object getEndPoint() throws JsonParseException, JsonMappingException, IOException {
        String user = "SP_Data_Xfer";
        String pwd = "9ygDCX2r";
        String domain = "hctrasp";
        String urlService = "https://portal.hctrasp.org/sites/shipchannel/data/_vti_bin/Service.svc/getcorrespondences?startdate=1/1/2018&enddate=2/1/2018";
        return reader.CorrespondenceEndPointReader(urlService, user, pwd, domain);
    }*/
}
