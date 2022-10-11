/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.model.QalabMainttypeV1;
import com.atser.tools.atserejb.model.QalabMainttypeV2;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.atser.tools.atserejb.service.qa.QalabMainttypeV1Service;
import com.atser.tools.atserejb.service.qa.QalabMainttypeV2Service;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/qa/labmainttype")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class QalabMainttypeRS implements IBaseWSException {

    @EJB
    private QalabMainttypeV1Service qalabMainttypeV1Service;

    @EJB
    private QalabMainttypeV2Service qalabMainttypeV2Service;

    /*----------------- VERSION 2 --------------------------------------------*/
    @GET
    @Path("/v2/datatable/list")
    public Object datatableListv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV2Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v2/list")
    public Object filterListByGetv2(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV2Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v2/list")
    public Object filterListByPostv2(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabMainttypeV2Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v2/crud")
    public Object crudv2(ManageITRequest<QalabMainttypeV2> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qalabMainttypeV2Service.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabMainttypeV2Service.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabMainttypeV2Service.save(request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qalabMainttypeV2Service.update(request.getBody().getData());
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
    @Path("/v2/version")
    public Object getVersionv2(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV2Service.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/v2/version/list")
    public Object getVersionListv2(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV2Service.getRevisions(id);
    }

    /*----------------- VERSION 1 --------------------------------------------*/
    @GET
    @Path("/v1/datatable/list")
    public Object datatableListv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV1Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/v1/list")
    public Object filterListByGetv1(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV1Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/v1/list")
    public Object filterListByPostv1(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return qalabMainttypeV1Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/crud")
    public Object crudv1(ManageITRequest<QalabMainttypeV1> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getAction())) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return qalabMainttypeV1Service.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabMainttypeV1Service.delete(request.getBody().getParams().get("id").toString());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        qalabMainttypeV1Service.save(request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        qalabMainttypeV1Service.update(request.getBody().getData());
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
    @Path("/v1/version")
    public Object getVersionv1(@QueryParam("n") String number) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV1Service.getVersion(Integer.valueOf(number));
    }

    @GET
    @Path("/v1/version/list")
    public Object getVersionListv1(@QueryParam("id") String id) throws JsonParseException, JsonMappingException, IOException {
        return qalabMainttypeV1Service.getRevisions(id);
    }
}
