/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.mgmt;

import com.atser.tools.atserejb.model.MgmtExcel;
import com.atser.tools.atserejb.service.glob.GlobUserLogService;
import com.atser.tools.atserejb.service.mgmt.MgmtExcelService;
import com.atser.tools.atserutil.objects.bo.mgmt.MetaDataExcelBo;
import com.atser.tools.atserutil.objects.bo.support.syncfusion.SectionRsBo;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionRequest;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
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
 * as
 *
 * @author droldan
 */
@Path("/mgmt/excel")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SyncFusionSegmentRest
@Slf4j
public class ExcelRS implements IBaseWSException {

    @EJB
    MgmtExcelService excelService;

    @EJB
    GlobUserLogService userLogService;

    @POST
    @Path("/savemetadata")
    public Object saveExcel(SyncFusionRequest<MetaDataExcelBo> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getAction() != null && !params.getAction().isEmpty()) {
                if (params.getAction().equals("update")) {
                    if (params.getTable() != null && !params.getTable().isEmpty() && params.getTable().equals("saveExcel")) {
                        excelService.saveMetaDataExcel(params.getValue().getId(), params.getValue().getData(), params.getValue().getEnvinfo());
                    } else if (params.getTable() != null && !params.getTable().isEmpty() && params.getTable().equals("setOpen")) {
                        excelService.setOpenExcel(params.getValue().getId(), params.getValue().getData(), params.getValue().getEnvinfo());
                    }
                }
            }
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/crud")
    public Object excelOptions(SyncFusionRequest<MgmtExcel> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getAction() != null && !params.getAction().isEmpty()) {
                if (params.getAction().equals("remove")) {
                    excelService.delete(params.getKey());
                }

                if (params.getAction().equals("insert")) {
                    excelService.save(params.getValue());
                }

                if (params.getAction().equals("update")) {
                    excelService.update(params.getValue());
                }
            } else { // List
                List<MgmtExcel> list = excelService.findAll(params.getSorted(), params.getProjectId());
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
    @Path("/getmetadata")
    public Object getMetadata(SyncFusionRequest<Object> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getId() != null) {
                String data = excelService.getMetaData(params.getId());
                return data;
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/isopen")
    public Object isOpen(SyncFusionRequest<Object> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getId() != null) {
                return excelService.isOpen(params.getId());
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
