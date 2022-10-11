/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.view;

import com.atser.tools.atserejb.model.VwCmBiditPrjItemsCo;
import com.atser.tools.atserejb.service.view.VwCmBiditPrjItemsCoService;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionRequest;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
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
@Path("/view/vwcmbiditprjitemsco")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class VwCmBiditPrjItemsCoRS implements IBaseWSException {

    @EJB
    VwCmBiditPrjItemsCoService vwCmBiditPrjItemsCoService;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwCmBiditPrjItemsCoService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwCmBiditPrjItemsCoService.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datatreegrid/list")
    public Object dataTreeGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwCmBiditPrjItemsCoService.dataTreeGridList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/list")
    public Object filterByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return vwCmBiditPrjItemsCoService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return vwCmBiditPrjItemsCoService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @SyncFusionSegmentRest
    @Path("/updatebid")
    public Object updateItemBid(SyncFusionRequest<VwCmBiditPrjItemsCo> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getAction() != null && !params.getAction().isEmpty()) {
                if (params.getAction().equals("update")) {
                    vwCmBiditPrjItemsCoService.updateItemBid(params.getValue());
                }
            }
        }
        return Response.status(Response.Status.ACCEPTED).build();
    }

}
