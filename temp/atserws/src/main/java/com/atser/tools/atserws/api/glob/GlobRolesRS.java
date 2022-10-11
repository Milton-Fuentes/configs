/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobRoles;
import com.atser.tools.atserejb.service.glob.GlobRolesService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author dperez
 */
@Path("/glob/roles")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobRolesRS implements IBaseWSException {

    @EJB
    GlobRolesService rolesService;

    @POST
    @Path("/crud")
    public Object rolesCrud(ManageITRequest<GlobRoles> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "remove": {
                        break;
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [data] param.");
                        }
                        return rolesService.save(request.getBody().getData());
                    }
                    case "update": {
                        break;
                    }
                    case "list": {
                        return rolesService.list(request.getBody());
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/listroles")
    public Object getRoleList() throws JsonParseException, JsonMappingException, IOException {
        return null;
    }
    
    @GET
    @Path("/list/staticroles")
    public Object getRoleList(@QueryParam("cId") String cId) throws JsonParseException, JsonMappingException, IOException {
        if(StringSupport.isNullOrEmpty(cId)) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
        }
        return rolesService.getModuleRolesForSelect(NumberSupport.getBigInteger(cId));
    }

}
