/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.mgmt;

import com.atser.tools.atserejb.model.MgmtGanttResource;
import com.atser.tools.atserejb.service.glob.GlobUserLogService;
import com.atser.tools.atserejb.service.mgmt.MgmtGanttResourceService;
import com.atser.tools.atserutil.objects.bo.support.syncfusion.SectionRsBo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionRequest;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.List;
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
@Path("/mgmt/gantt/resource")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SyncFusionSegmentRest
@Slf4j
public class GanttResourceRS implements IBaseWSException {

    @EJB
    MgmtGanttResourceService ganttService;

    @EJB
    GlobUserLogService userLogService;

    @POST
    @Path("/crud")
    public Object excelOptions(SyncFusionRequest<MgmtGanttResource> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getAction() != null && !params.getAction().isEmpty()) {
                if (params.getAction().equals("remove")) {
                    ganttService.delete(params.getKey());
                }

                if (params.getAction().equals("insert")) {
                    ganttService.save(params.getValue());
                }

                if (params.getAction().equals("update")) {
                    ganttService.update(params.getValue());
                }
            } else { // List
                List<MgmtGanttResource> list = ganttService.findAll(params.getSorted(), params.getProjectId());
                SectionRsBo response = new SectionRsBo(list, Integer.valueOf(list.size()).longValue());
                if (list.isEmpty()) {
                    return null;
                }
                return response;
            }
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @POST
    @Path("/getjson")
    public Object getResourceAsJson(SyncFusionRequest<Object> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getProjectId() != null) {
                String data = ganttService.getListResourceAsJson(params.getProjectId());
                return data;
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
