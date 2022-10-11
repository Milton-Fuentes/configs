/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.ws;

import com.atser.tools.atserejb.service.ws.WsDocTemplateService;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
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
@Path("/ws/doctemplate")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class WsDocTemplateRS implements IBaseWSException {

    @EJB
    WsDocTemplateService wsDocTemplateService;

    @GET
    @Path("/list")
    public Object list(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return wsDocTemplateService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object list(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return wsDocTemplateService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return wsDocTemplateService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
