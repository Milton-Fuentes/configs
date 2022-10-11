/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobRequirementLog;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobRequirementLogService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.pojo.glob.GlobRequirementLogSearchDefParam;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/glob/requirementlog")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobRequirementLogRS implements IBaseWSException {

    @EJB
    private GlobRequirementLogService globRequirementLogService;

    @EJB
    StorageService storageService;

    @EJB
    protected InitializeEnv env;

    @EJB
    GlobFileService fileService;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globRequirementLogService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globRequirementLogService.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globRequirementLogService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return globRequirementLogService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<GlobRequirementLog> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return globRequirementLogService.findById(request.getHeader(), request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        globRequirementLogService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        globRequirementLogService.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        globRequirementLogService.update(request.getHeader(), request.getBody().getData());
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
    @Path("/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            globRequirementLogService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadFiles(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Issue Management");
        notify();
    }

    @POST
    @Path("/files/delete")
    public Object deleteFile(ManageITRequest<Object> request) throws IOException {
        if (request.getBody().getParams() == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
        }
        fileService.delete(request.getBody());
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/version")
    public Object getVersion(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return globRequirementLogService.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/version/list")
    public Object getVersionList(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return globRequirementLogService.getRevisions(id);
    }

    @POST
    @Path("/search")
    public Object search(ManageITRequest<GlobRequirementLogSearchDefParam> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                log.error("Wrong Request.");
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            return globRequirementLogService.getFrontEndSearch(request.getHeader(), request.getBody().getData());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generatePostReport(ManageITRequest<GlobRequirementLogSearchDefParam> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getData().reportId)) {
                String tplbasePath = env.getDefaultTplPath() + "/jasper/";
                String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
                String filePath = globRequirementLogService.generateReport(tplbasePath, docpathsegment, request.getHeader(), request.getBody().getData());
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
}
