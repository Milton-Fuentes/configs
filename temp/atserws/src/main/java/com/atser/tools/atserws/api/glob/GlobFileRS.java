/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.bo.glob.document.DocumentSearchDefParam;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
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
import com.atser.tools.atserws.filters.annotation.WsSecured;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.PermitAll;
import javax.enterprise.util.Nonbinding;
import javax.ws.rs.CookieParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/glob/file")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobFileRS implements IBaseWSException {

    @EJB
    private GlobFileService fileService;

    @Context
    SecurityContext securityContext;

    @EJB
    private GenericHelperService genericHelperService;

    @EJB
    private InitializeEnv env;

    @EJB
    StorageService storageService;

    @POST
    @Path("/crud")
    public Object folderCrud(ManageITRequest<GlobFile> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return fileService.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id"))) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        fileService.delete(request.getHeader(), env.getEmailTplEngine(), new BigDecimal(request.getBody().getParams().get("id").toString()));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        fileService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "list": {
                        return fileService.list(request.getBody());
                    }
                }
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [action] param.");
            }
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/delete")
    public Object deleteFile(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id"}) && !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"ids"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (request.getBody().getParams().containsKey("id")) {
                fileService.delete(request.getHeader(), env.getEmailTplEngine(), new BigDecimal(request.getBody().getParams().get("id").toString()));
            } else {
                fileService.delete(request.getHeader(), env.getEmailTplEngine(), (List<BigInteger>) request.getBody().getParams().get("ids"));
            }
        }
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/list")
    public Object filterListByGet(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return fileService.list(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @Path("/datatable/list")
    public Object datatableList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return fileService.dataTableList(ApiCommon.buildFilter(uriInfo));
    }

    @GET
    @PermitAll
    @Path("/datagrid/list")
    public Object datatableGridList(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        ManageITBodyRequest request = ApiCommon.buildFilter(uriInfo);
        if (securityContext.isSecure()) {
            return fileService.dataGridList(request);
        } else {
            if (request != null && request.containsToken()) {
                if (genericHelperService.isTokenValid(request.getToken())) {
                    return fileService.dataGridList(request);
                }
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Object fileList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return fileService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/listbyfolder")
    public Object fileListByFolder(@QueryParam("f") String folderId) throws JsonParseException, JsonMappingException, IOException {
        if ((folderId != null && !folderId.isEmpty())) {
            return fileService.listByFolder(folderId);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return fileService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/copy/to/folder")
    public Object copyFilesToFolder(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate() && request.getBody().getParams() != null
                && request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"folderId", "fileList"})) {
            fileService.copyFilesToFolder(request.getHeader(), StringSupport.toList(request.getBody().getParams().get("fileList")), NumberSupport.getBigDecimal(request.getBody().getParams().get("folderId")));
            return Response.status(Response.Status.CREATED).build();
        } else {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/search")
    public Object search(ManageITRequest<DocumentSearchDefParam> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            return fileService.getFrontEndSearch(request.getHeader(), request.getBody().getData(), true);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/searchAdvance")
    public Object searchAdvance(ManageITRequest<DocumentSearchDefParam> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            return fileService.getFrontEndSearchAdvance(request.getHeader(), request.getBody().getData(), request.getBody().getParams(), true);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/lock")
    public Object lockFile(ManageITRequest<Object> request) throws IOException {
        // Validate exist request.
        if (request != null && request.validate()) {
            // Validate exist parameters.
            if (request.getBody().getParams().containsKey("userId") && request.getBody().getParams().containsKey("fileId")) {
                // Validate parameter type.
                if (NumberSupport.isNumeric(request.getBody().getParams().get("fileId").toString()) && NumberSupport.isNumeric(request.getBody().getParams().get("userId").toString())) {
                    // Call service.
                    fileService.lockFile(new BigDecimal(request.getBody().getParams().get("fileId").toString()), new BigDecimal(request.getBody().getParams().get("userId").toString()));
                    // Return good response.
                    return Response.status(Response.Status.OK).build();
                }
            }
        }
        // Return bad response.
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/unlock")
    public Object unlockFile(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("fileId")) {
                if (NumberSupport.isNumeric(request.getBody().getParams().get("fileId").toString())) {
                    fileService.unlockFile(new BigDecimal(request.getBody().getParams().get("fileId").toString()));
                    return Response.status(Response.Status.OK).build();
                }
            } else {
                fileService.unlockFile(null);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/islocked")
    public Object isFileLocked(@QueryParam("f") String fileId, @QueryParam("u") String userId) throws IOException {
        if (!StringSupport.isNullOrEmpty(fileId) && !StringSupport.isNullOrEmpty(userId)) {
            if (NumberSupport.isNumeric(fileId) && NumberSupport.isNumeric(userId)) {
                return fileService.isFileLocked(new BigDecimal(fileId), new BigDecimal(userId));
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/upload")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object upload(MultipartFormDataInput content) throws IOException {
        return storageService.process(content, env.getDefaultUploadPath());
    }

    @POST
    @Path("/save")
    public Object upload(ManageITRequest<List<UploadModel>> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getData() != null) {
                return fileService.saveFileToDb(request.getHeader(), env.getEmailTplEngine(), request.getBody(), null, "GlobFileRS");
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/notifyupload")
    public Object notifyUpload(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"projectType", "projectId", "folderId", "userIds"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            fileService.notifyUpload(request.getHeader(), request.getBody(), env.getEmailTplEngine());
            return Response.status(Response.Status.OK).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/generate/report")
    public Response generatePostReport(ManageITRequest<DocumentSearchDefParam> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getData() == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
            }
            Boolean advanceSearch = false;
            if (request.getBody().getParams() != null && request.getBody().getParams().containsKey("searchAdvance") && (Boolean) request.getBody().getParams().get("searchAdvance") == true) {
                advanceSearch = true;
            }

            if (StringSupport.isNotNullAndNotEmpty(request.getBody().getData().reportId)) {
                String tplbasePath = env.getDefaultTplPath() + "/jasper/";
                String docpathsegment = env.getDefaultUploadPath() + "/temporal/";
                String filePath = fileService.generateFileReport(request.getHeader(), request.getBody(), request.getBody().getData(), advanceSearch, tplbasePath, docpathsegment);
                if (filePath != null) {
                    File file = new File(filePath);
                    Response.ResponseBuilder rpb = Response.ok(file, FileSupport.getFileTypeMime(file));
                    if (request.getBody().getData().printType != null && request.getBody().getData().printType.equals("1")) {
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

    @GET
    @Nonbinding
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/download/file")
    public Response downloadFile(@QueryParam("f") String id) throws IOException {
        if (StringSupport.isNotNullAndNotEmpty(id) && NumberSupport.isNumeric(id)) {
            GlobFile gf = fileService.findById(id);
            File file = new File(gf.getServerPath());
            return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + gf.getFTitle() + "\"")
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/download/files")
    public Response downloadFiles(@QueryParam("f") String ids) throws IOException {
        if (StringSupport.isNotNullAndNotEmpty(ids)) {
            List<String> list = Arrays.asList(ids.split(","));
            List<BigDecimal> bdList = list.stream().map(s -> new BigDecimal(s)).collect(Collectors.toList());
            String zipPath = env.getDefaultUploadPath() + "/temporal/";
            File file = new File(fileService.zipFiles(bdList, zipPath));
            return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + file.getName() + ".zip\"")
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

//    @POST
//    @Nonbinding
//    @PermitAll
//    @Produces(MediaType.APPLICATION_OCTET_STREAM)
//    @Path("/download/files2")
//    public Object downloadFiles(ManageITRequest<List<BigDecimal>> request) throws IOException {
//        if (request != null && request.validate()) {
//            if (request.getBody().getData() != null) {
//                String zipPath = env.getDefaultUploadPath() + "/temporal/";
//                File file = new File(fileService.zipFiles(request.getBody().getData(), zipPath));
//                return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
//                        .header("Content-Disposition", "attachment; filename=\"" + file.getName() + ".zip\"")
//                        .build();
//            } else {
//                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
//            }
//        }
//        return Response.status(Response.Status.BAD_REQUEST).build();
//    }

}
