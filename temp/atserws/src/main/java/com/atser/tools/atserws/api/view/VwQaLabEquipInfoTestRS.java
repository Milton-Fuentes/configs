/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.view;

import com.atser.tools.atserejb.service.view.VwQaLabEquipInfoTestV1Service;
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
import com.atser.tools.atserejb.service.view.VwQaLabEquipInfoTestV2Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/view/vwqalabequipinfotest")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class VwQaLabEquipInfoTestRS implements IBaseWSException {

    @EJB
    VwQaLabEquipInfoTestV2Service vwQaLabEquipInfoTestV2Service;
    
    @EJB
    VwQaLabEquipInfoTestV1Service vwQaLabEquipInfoTestV1Service;

    @GET
    @Path("/datagrid/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwQaLabEquipInfoTestV2Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwQaLabEquipInfoTestV2Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return vwQaLabEquipInfoTestV2Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    @GET
    @Path("/v1/datagrid/list")
    public Object datatableListV1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwQaLabEquipInfoTestV1Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/list")
    public Object filterByGetV1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwQaLabEquipInfoTestV1Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object filterByPostV1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return vwQaLabEquipInfoTestV1Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
