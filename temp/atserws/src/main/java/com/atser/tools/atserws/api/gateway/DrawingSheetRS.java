/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.gateway;

import com.atser.tools.atserejb.service.sp.DrawingSheetService;
import com.atser.tools.atserutil.enumerator.eEntryPoint;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/gateway/drawingsheet")
@WsSecured(entrypoint = eEntryPoint.external)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class DrawingSheetRS implements IBaseWSException {

    @EJB
    private DrawingSheetService eDrawSheetService;

    @EJB
    protected InitializeEnv env;

    @POST
    @Path("/list")
    public Object filter(ManageITRequest<Object> request) {
        if (request != null && request.validate()) {
            return eDrawSheetService.filter(request.getBody(), "https://" + env.getPropertiesMap().get("server_domain"));
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
