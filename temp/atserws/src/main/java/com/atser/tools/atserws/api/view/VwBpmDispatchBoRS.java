/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.view;

import com.atser.tools.atserejb.service.view.VwBpmDispatchBoService;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserws.InitializeEnv;
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
import org.bonitasoft.engine.exception.BonitaException;

/**
 *
 * @author droldan
 */
@Path("/view/vwbpmdispatchbo")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class VwBpmDispatchBoRS implements IBaseWSException {

    @EJB
    VwBpmDispatchBoService vwBpmDispatchBoService;

    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return vwBpmDispatchBoService.dataTableList(ApiCommon.buildFilter(uriInfo), env.getBonitaBpmSession());
    }

    @GET
    @Path("/datagrid/list")
    public Object datagridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return vwBpmDispatchBoService.dataGridList(ApiCommon.buildFilter(uriInfo), env.getBonitaBpmSession());
    }

    @GET
    @Path("/list")
    public Object filterByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        return vwBpmDispatchBoService.list(ApiCommon.buildFilter(uriInfo), env.getBonitaBpmSession());
    }

    @POST
    @Path("/list")
    public Object filterByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException, BonitaException {
        if (request != null && request.validate()) {
            return vwBpmDispatchBoService.list(request.getBody(), env.getBonitaBpmSession());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
