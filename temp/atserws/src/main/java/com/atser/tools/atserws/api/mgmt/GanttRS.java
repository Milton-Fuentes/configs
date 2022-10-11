/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.mgmt;

import com.atser.tools.atserejb.model.MgmtGantt;
import com.atser.tools.atserejb.service.glob.GlobUserLogService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.mgmt.MgmtGanttResourceService;
import com.atser.tools.atserejb.service.mgmt.MgmtGanttService;
import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttResource;
import com.atser.tools.atserutil.enumerator.parser.eTemplateGanttTask;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.bo.mgmt.MetaDataGanttBo;
import com.atser.tools.atserutil.objects.bo.support.syncfusion.SectionRsBo;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.parser.excel.plugin.resource.ResourcePluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.resource.model.ResourceModel;
import com.atser.tools.atserutil.parser.excel.plugin.task.TaskPluginDirector;
import com.atser.tools.atserutil.parser.excel.plugin.task.model.GModel;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/mgmt/gantt")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SyncFusionSegmentRest
@Slf4j
public class GanttRS {

    @EJB
    MgmtGanttResourceService ganttResourceService;

    @EJB
    MgmtGanttService ganttService;

    @EJB
    StorageService storageService;

    @EJB
    GlobUserLogService userLogService;

    @EJB
    private InitializeEnv env;

    private TaskPluginDirector directorTask;
    private ResourcePluginDirector directorResource;

    @POST
    @Path("/savemetadata")
    public Object saveExcel(SyncFusionRequest<MetaDataGanttBo> params) throws JsonParseException, JsonMappingException, IOException {
        if (params != null) {
            if (params.getAction() != null && !params.getAction().isEmpty()) {
                if (params.getAction().equals("update")) {
                    if (params.getTable() != null && !params.getTable().isEmpty() && params.getTable().equals("saveGantt")) {
                        ganttService.saveMetaDataGantt(params.getValue().getId(), params.getValue().getData(), params.getValue().getEnvinfo());
                    } else if (params.getTable() != null && !params.getTable().isEmpty() && params.getTable().equals("setOpen")) {
                        ganttService.setOpenGantt(params.getValue().getId(), params.getValue().getData(), params.getValue().getEnvinfo());
                    }
                }
            }
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/crud")
    public Object excelOptions(SyncFusionRequest<MgmtGantt> params) throws JsonParseException, JsonMappingException, IOException {
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
                List<MgmtGantt> list = ganttService.findAll(params.getSorted(), params.getProjectId());
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
                String data = ganttService.getMetaData(params.getId());
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
                return ganttService.isOpen(params.getId());
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/upload/tasks")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object uploadGanttTaskFile(MultipartFormDataInput content) throws IOException {
        UploadModel fileModel = storageService.process(content, env.getDefaultUploadPath());
        try {
            List<GModel> model = getJsonFromExcelTask(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")), "AtserTaskTpl");
            String json = ganttService.fillMetaDataFromImportFile(model, fileModel.getParams());
            return json;
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException e) {
            return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity("Document format is not allowed.").build();
        } catch (FileNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("File not found.").build();
        } catch (TemplateDifferentException ex) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Invalid document.").build();
        } catch (ExcelParsingException ex) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(ex.getMessage()).build();
        } finally {
            try {
                FileSupport.removeFile(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")));
            } catch (IOException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }
    }

    @POST
    @Path("/upload/resources")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object uploadGanttResourceFile(MultipartFormDataInput content) throws IOException {
        UploadModel fileModel = storageService.process(content, env.getDefaultUploadPath());
        try {
            batchCreateToDb(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")), "AtserResourceTpl", fileModel.getParams());
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException e) {
            return Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).entity("Document format is not allowed.").build();
        } catch (FileNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("File not found.").build();
        } catch (TemplateDifferentException ex) {
            return Response.status(Response.Status.NOT_ACCEPTABLE).entity("Invalid document.").build();
        } catch (ExcelParsingException ex) {
            return Response.status(Response.Status.EXPECTATION_FAILED).entity(ex.getMessage()).build();
        } finally {
            try {
                FileSupport.removeFile(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")));
            } catch (IOException e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }
        return Response.status(Response.Status.OK).build();
    }

    public List<GModel> getJsonFromExcelTask(String pPath, String pTemplate) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException {
        directorTask = new TaskPluginDirector(new File(pPath), eTemplateGanttTask.valueOf(pTemplate));
        return directorTask.getGanttModel();
    }

    public void batchCreateToDb(String pPath, String pTemplate, Map<String, Object> params) throws FormatDocumentNotAllowedException, NotFoundMimeTypeException, FileNotFoundException, TemplateDifferentException, ExcelParsingException {
        directorResource = new ResourcePluginDirector(new File(pPath), eTemplateGanttResource.valueOf(pTemplate));
        List<ResourceModel> list = directorResource.getGanttResourceModel();
        ganttResourceService.save(list, params);
    }

}
