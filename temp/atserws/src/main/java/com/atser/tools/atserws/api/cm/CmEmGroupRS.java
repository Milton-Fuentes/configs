/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.cm;

import com.atser.tools.atserejb.service.cm.CmEmGroupService;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.POST;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("cm/em/group")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SyncFusionSegmentRest
@Slf4j
public class CmEmGroupRS implements IBaseWSException {

    @EJB
    CmEmGroupService groupService;

    @POST
    @GET
    @Path("/list")
    public Object getGroupList() throws JsonParseException, JsonMappingException, IOException {
        return groupService.findAll();
    }
    
}
