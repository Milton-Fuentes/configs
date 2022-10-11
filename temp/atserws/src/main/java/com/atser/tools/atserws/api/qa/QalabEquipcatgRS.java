/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
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
import com.atser.tools.atserws.common.ApiCommon;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import javax.ws.rs.QueryParam;
import com.atser.tools.atserejb.service.qa.QalabEquipcatgV1Service;
import com.atser.tools.atserejb.service.qa.QalabEquipcatgV2Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/qa/labequipcatg")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QalabEquipcatgRS implements IBaseWSException {

    @EJB
    private QalabEquipcatgV1Service qaLabEqCatV1Service;
    
    @EJB
    private QalabEquipcatgV2Service qaLabEqCatV2Service;

    /*----------------- VERSION 2 --------------------------------------------*/
    
    @GET
    @Path("/v2/list")
    public Object filterListByGetv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV2Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v2/list")
    public Object filterListByPostv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaLabEqCatV2Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/v2/version")
    public Object getVersionv2(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV2Service.getVersion(Integer.valueOf(number));
    }
    
    @GET
    @Path("/v2/version/list")
    public Object getVersionListv2(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV2Service.getRevisions(id);
    }
    
    /*----------------- VERSION 1 --------------------------------------------*/
    
    @GET
    @Path("/v1/list")
    public Object filterListByGetv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV1Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object filterListByPostv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qaLabEqCatV1Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/v1/version")
    public Object getVersionv1(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV1Service.getVersion(Integer.valueOf(number));
    }
    
    @GET
    @Path("/v1/version/list")
    public Object getVersionListv1(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qaLabEqCatV1Service.getRevisions(id);
    }
}
