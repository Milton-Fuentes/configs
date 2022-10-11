/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.enterprise.util.Nonbinding;
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
 * @author droldan
 */
@Path("/glob/folder")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobFolderRS implements IBaseWSException {

    @EJB
    GlobFolderService folderService;

    @EJB
    private InitializeEnv env;

    @POST
    @Path("/crud")
    public Object folderCrud(ManageITRequest<GlobFolder> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "get": {
                        if (request.getBody().getParams() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        if (request.getBody().getParams().containsKey("id") && StringSupport.isNotNullAndNotEmpty(request.getBody().getParams().get("id"))) {
                            return folderService.findById(request.getBody().getParams().get("id").toString());
                        } else {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
                        }
                        break;
                    }
                    case "remove": {
                        if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeys(new String[]{"id"}) || StringSupport.isNullOrEmpty(request.getBody().getParams().get("id")) || !NumberSupport.isNumeric(request.getBody().getParams().get("id").toString())) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong request.");
                        }
                        folderService.delete(request.getHeader(), env.getEmailTplEngine(), new BigDecimal(request.getBody().getParams().get("id").toString()));
                        return Response.status(Response.Status.OK).build();
                    }
                    case "insert": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Missing [data] param.");
                        }
                        return folderService.save(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData());
                    }
                    case "update": {
                        if (request.getBody().getData() == null) {
                            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Request.");
                        }
                        folderService.update(request.getHeader(), env.getEmailTplEngine(), request.getBody().getData());
                        return Response.status(Response.Status.OK).build();
                    }
                    case "list": {
                        return folderService.list(request.getBody());
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
    public Object deleteFolders(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"id"}) && !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"ids"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [params] param.");
            }
            if (request.getBody().getParams().containsKey("id")) {
                folderService.delete(request.getHeader(), env.getEmailTplEngine(), new BigDecimal(request.getBody().getParams().get("id").toString()));
            } else {
                folderService.delete(request.getHeader(), env.getEmailTplEngine(), (List<BigInteger>) request.getBody().getParams().get("ids"));
            }
        }
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("/list")
    public Object folderList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().containsKey("folder")) {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }

            return folderService.folderList(request.getBody(), eManageITFolder.valueOf(request.getBody().getParams().get("folder").toString()), request.getHeader().getModule());
        }
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @POST
    @Path("/submittal/step")
    public Object getNextSubmittalStep(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getAction() != null && !request.getBody().getAction().isEmpty()) {
                String action = request.getBody().getAction();
                switch (action) {
                    case "step": {
                        return folderService.getNextSpecFolderNameStep(request.getBody(), 1, eManageITFolder.eFSubmittal);
                    }
                    case "substep": {
                        return folderService.getNextSpecFolderNameStep(request.getBody(), 2, eManageITFolder.eFSubmittal);
                    }
                }
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/findbyid")
    public Object findById(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("id")) {
                return folderService.findById(request.getBody().getParams().get("id").toString());
            } else {
                throwBaseException(Response.Status.BAD_REQUEST, "Missing [id] param.");
            }
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/v1/find/client/folder")
    public Object findClientFolder(@QueryParam("cId") String clientId) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(clientId) && NumberSupport.isNumeric(clientId)) {
            return folderService.getRootFolderByClientId(new BigInteger(clientId));
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/v1/find/project/folder")
    public Object findProjectFolder(@QueryParam("pId") String projectId, @QueryParam("pType") String projectType) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(projectId) && NumberSupport.isNumeric(projectId)) {
            return folderService.getRootFolderByProjectId(new BigInteger(projectId), projectType);
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/list/byparentid/withrights")
    public Object listByParentIdWithRights(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"parentId", "isAdmin"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return folderService.listFolderByParentIdWithRights(NumberSupport.getBigInteger(request.getBody().getParams().get("parentId")),
                    NumberSupport.getBigInteger(request.getHeader().getUserid()), StringSupport.getString(request.getHeader().getRole()), StringSupport.getBoolean(request.getBody().getParams().get("isAdmin")));
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/list/foldertree")
    public Object listFolderTree(ManageITRequest<Object> request) throws IOException, Exception {
        if (request != null && request.validate()) {
            if (request.getBody().getParams() == null || !request.getBody().getParams().isContainsAllKeysAndNotNull(new String[]{"parentId", "isAdmin"})) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong parameters.");
            }
            return folderService.getFolderTree(
                    NumberSupport.getBigInteger(request.getBody().getParams().get("id")),
                    NumberSupport.getBigInteger(request.getBody().getParams().get("parentId")),
                    NumberSupport.getBigInteger(request.getBody().getParams().get("projectId")),
                    NumberSupport.getBigInteger(request.getHeader().getUserid()),
                    StringSupport.getString(request.getHeader().getRole()),
                    StringSupport.getBoolean(request.getBody().getParams().get("isAdmin")));
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Nonbinding // No Binding for the Interceptor. We need to return No Json
    @PermitAll
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/download")
    public Response downloadFolder(@QueryParam("f") String folderId, @QueryParam("n") String folderName) throws IOException {
        if (StringSupport.isNotNullAndNotEmpty(folderId) && NumberSupport.isNumeric(folderId)) {
            String zipPath = env.getDefaultUploadPath() + "/temporal/";
            String fileServerPath = folderService.listDocumentToZip(new BigDecimal(folderId), zipPath);
            File file = new File(fileServerPath);
            return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + folderName + ".zip\"").build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
