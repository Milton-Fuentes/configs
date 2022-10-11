/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobTransmittal;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.glob.GlobTransmittalService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
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
 * @author mfuentes
 */
@Path("/glob/transmittal")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobTransmittalRS implements IBaseWSException {

    @EJB
    private GlobTransmittalService globTransmittalService;
    @EJB
    GlobFileService fileService;

    @EJB
    protected InitializeEnv env;

    @EJB
    StorageService storageService;

    @GET
    @Path("/v1/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globTransmittalService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globTransmittalService.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globTransmittalService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return globTransmittalService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/crud")
    public Object crud(ManageITRequest<GlobTransmittal> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.NO_CONTENT, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return Response.status(Response.Status.OK).entity(globTransmittalService.findById(request.getHeader(), request.getBody().getParams().get("id").toString())).build();
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.NO_CONTENT, "Wrong request.");
                        } else if (!request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        globTransmittalService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.NO_CONTENT, "Wrong request.");
                        }

                        return Response.status(Response.Status.CREATED).entity(globTransmittalService.save(request.getHeader(), request.getBody().getData())).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.NO_CONTENT, "Wrong Request.");
                        }
                        globTransmittalService.update(request.getHeader(), request.getBody().getData());
                        return Response.status(Response.Status.ACCEPTED).entity(request.getBody().getData().getId()).build();
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/transmitt")
    public Object transmitt(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"})) {
                //|| !request.getBody().getParams().isContainsAllKeys(new String[]{"callIdList"})) //check multiples
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            globTransmittalService.transmitt(request.getBody(), env.getPropertiesMap().get("server_domain"), env.getEmailTplEngine());

            //taked from  dispatchCallLogService.notifyTechnicians(request.getBody(), env.getPropertiesMap().get("server_domain"), env.getEmailTplEngine());
        }

        return Response.status(Response.Status.OK).build();

    }

    @POST
    @Path("/v1/active")
    public Object changeStatus(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id", "status"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            globTransmittalService.changeStatus(request.getBody());
        }

        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/v1/version")
    public Object getVersion(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return globTransmittalService.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/v1/version/list")
    public Object getVersionList(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return globTransmittalService.getRevisions(id);
    }

    @POST
    @Path("/files/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public synchronized void uploadFiles(MultipartFormDataInput content) throws IOException {
        storageService.store(content, env.getDefaultUploadPath(), "Transmittal Management");
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

}
