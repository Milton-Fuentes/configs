/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QaconcMixDesignMcode;
import com.atser.tools.atserejb.service.qa.QaconcMixDesignMcodeService;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/qa/concmixdesignmcode")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QaconcMixDesignMcodeRS implements IBaseWSException {

    @EJB
    private QaconcMixDesignMcodeService qaconcMixDesignMcodeService;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixDesignMcodeService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixDesignMcodeService.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaconcMixDesignMcodeService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object list(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaconcMixDesignMcodeService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return qaconcMixDesignMcodeService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/crud")
    public Object crud(ManageITRequest<QaconcMixDesignMcode> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qaconcMixDesignMcodeService.findById(StringSupport.getString(request.getBody().getParams().get("id")));
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qaconcMixDesignMcodeService.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        return qaconcMixDesignMcodeService.save(request.getHeader(), request.getBody().getData());
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qaconcMixDesignMcodeService.update(request.getHeader(), request.getBody().getData());
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
    @Path("/v1/copyfrom")
    public Object copyMaterialCodeFromMix(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"fromMixId", "targetMixId"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            qaconcMixDesignMcodeService.copyFromMix(request.getHeader(), StringSupport.getString(request.getBody().getParams().get("fromMixId")), 
                    StringSupport.getString(request.getBody().getParams().get("targetMixId")));
        }

        return Response.status(Response.Status.OK).build();
    }
}