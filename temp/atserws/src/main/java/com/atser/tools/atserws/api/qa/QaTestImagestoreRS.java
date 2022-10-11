/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QaTestImagestore;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.qa.QaTestImagestoreService;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
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
import java.math.BigDecimal;
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
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/qa/testimagestore")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaTestImagestoreRS implements IBaseWSException {

    @EJB
    private QaTestImagestoreService qaTestImagestoreService;

    @EJB
    StorageService storageService;

    @EJB
    private InitializeEnv env;

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaTestImagestoreService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaTestImagestoreService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<QaTestImagestore> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qaTestImagestoreService.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaTestImagestoreService.delete(request.getBody().getParams().get("id").toString(), StringSupport.getString(request.getBody().getParams().get("reportpath")));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaTestImagestoreService.save(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qaTestImagestoreService.update(request.getHeader(), request.getBody().getData());
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
    @Path("/download/image")
    public Response downloadServerImage(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws IOException, Exception {
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        String paramFileId = (queryParams.get("fid") != null && queryParams.get("fid").size() >= 1) ? queryParams.get("fid").get(0) : null;
        QaTestImagestore filedb = qaTestImagestoreService.findById(paramFileId);
        if (filedb != null) {
            File file = new File(filedb.getServerPath());
            Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
            rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
            return rpb.build();
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/import/images")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object importImagesTest(MultipartFormDataInput content) throws IOException {
        UploadModel model = storageService.process(content, env.getDefaultUploadPath());
        qaTestImagestoreService.saveFileToDb(model.getMetaDataFile(), model.getParams());
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("update/reportstatus")
    public Object updateReportStatus(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            if (request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "reportStatus", "reportPath"})) {
                qaTestImagestoreService.updateReportStatus(String.valueOf(request.getBody().getParams().get("id").toString()),
                        String.valueOf(request.getBody().getParams().get("reportStatus")),
                        String.valueOf(request.getBody().getParams().get("reportPath")));
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/rotate/images")
    public Object importImagesTest(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            if (request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id", "side"}) && NumberSupport.isNumeric(request.getBody().getParams().get("id").toString())) {
                qaTestImagestoreService.rotateImage(new BigDecimal(request.getBody().getParams().get("id").toString()), request.getBody().getParams().get("side").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
        }
        return Response.status(Response.Status.OK).build();
    }
}
