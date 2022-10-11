/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.service.glob.GlobClientTestService;
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
import javax.ws.rs.QueryParam;
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
@Path("/glob/clienttest")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobClientTestRS implements IBaseWSException {

    @EJB
    GlobClientTestService globClientTestService;

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globClientTestService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterListByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return globClientTestService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/list/select")
    public Object filterListByGetForSelect(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globClientTestService.listForSelect(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return globClientTestService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbytestid")
    public Object findByPostTestId(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"clientId", "testId"})) {
            throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
        }
        return globClientTestService.findByTestId(request.getHeader().getClientid(), request.getBody().getParams().get("testId").toString());

    }

    @GET
    @Path("/findbytestid")
    public Object findByGetTestId(@QueryParam("clientId") String clientId, @QueryParam("testId") String testId) throws JsonParseException, JsonMappingException, IOException {
        return globClientTestService.findByTestId(clientId, testId);
    }

    @GET
    @Path("/findbysampletestid")
    public Object findByGetSampleTestId(@QueryParam("clientId") String clientId, @QueryParam("sampleTestId") String testId) throws JsonParseException, JsonMappingException, IOException {
        return globClientTestService.findBySampleTestId(clientId, testId);
    }
}
