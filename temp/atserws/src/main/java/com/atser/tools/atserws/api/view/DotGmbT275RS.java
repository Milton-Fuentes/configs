package com.atser.tools.atserws.api.view;

import com.atser.tools.atserejb.service.view.DotGmbT275Service;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.to.ReportGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import javax.ejb.EJB;
import javax.enterprise.util.Nonbinding;
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

/*
 * @author mfuentes
 */
@Path("/view/dotgmbt275")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class DotGmbT275RS implements IBaseWSException {

    @EJB
    DotGmbT275Service dotGmbT275Service;
    @EJB
    protected InitializeEnv env;

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dotGmbT275Service.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dotGmbT275Service.dataGridList(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/datagrid/list")
    public Object dataGridList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return dotGmbT275Service.dataGridList(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/list")
    public Object filterByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return dotGmbT275Service.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object filterByPost(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return dotGmbT275Service.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generatePostReport(ManageITRequest<ReportGridWrapper> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            ManageITRequest queryRequest = ApiCommon.buildAdvanceFilter(request.getBody().getData().getTableFilter(), request.getHeader());
            if (queryRequest == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            String paramDocType = request.getBody().getData().getDocType();
            String paramTypePrint = request.getBody().getData().getTypePrint();
            String paramReportId = request.getBody().getData().getReportId();
            if (StringSupport.isNotNullAndNotEmpty(paramReportId)) {
                String docpathsegment = env.getPropertiesMap().get("upload_drive") + env.getPropertiesMap().get("upload_folder") + "/temporal/";
                String filePath = dotGmbT275Service.generateReport(docpathsegment, paramDocType, request.getBody().getData().getColumns(), request.getHeader().getClientid(), queryRequest.getBody());
                if (filePath != null) {
                    File file = new File(filePath);
                    Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                    if (paramTypePrint != null && paramTypePrint.equals("1")) {
                        rpb.header("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
                    } else {
                        rpb.header("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                    }
                    return rpb.build();
                }
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
