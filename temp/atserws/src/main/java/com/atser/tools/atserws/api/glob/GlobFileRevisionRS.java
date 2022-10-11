/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.service.glob.GlobFileRevisionService;
import com.atser.tools.atserejb.service.helper.GenericHelperService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import java.math.BigDecimal;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/glob/filerevision")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobFileRevisionRS implements IBaseWSException {

    @EJB
    private GlobFileRevisionService fileRevisionService;

    @Context
    SecurityContext securityContext;

    @EJB
    private GenericHelperService genericHelperService;

    @EJB
    private InitializeEnv env;

    @EJB
    StorageService storageService;

    @POST
    @Path("/lock")
    public Object lockFileRevision(ManageITRequest<Object> request) throws IOException {
        // Validate exist request.
        if (request != null && request.validate()) {
            // Validate exist parameters.
            if (request.getBody().getParams().containsKey("userId") && request.getBody().getParams().containsKey("revisionId")) {
                // Validate parameter type.
                if (NumberSupport.isNumeric(request.getBody().getParams().get("revisionId").toString()) && NumberSupport.isNumeric(request.getBody().getParams().get("userId").toString())) {
                    // Call service.
                    fileRevisionService.lockFile(new BigDecimal(request.getBody().getParams().get("revisionId").toString()), new BigDecimal(request.getBody().getParams().get("userId").toString()));
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
    public Object unlockFileRevision(ManageITRequest<Object> request) throws IOException {
        if (request != null && request.validate()) {
            if (request.getBody().getParams().containsKey("fileId")) {
                if (NumberSupport.isNumeric(request.getBody().getParams().get("fileId").toString())) {
                    fileRevisionService.unlockFile(new BigDecimal(request.getBody().getParams().get("fileId").toString()));
                    return Response.status(Response.Status.OK).build();
                }
            } else {
                fileRevisionService.unlockFile(null);
                return Response.status(Response.Status.OK).build();
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @GET
    @Path("/islocked")
    public Object isFileRevisionLocked(@QueryParam("r") String fileId, @QueryParam("u") String userId) throws IOException {
        if (!StringSupport.isNullOrEmpty(fileId) && !StringSupport.isNullOrEmpty(userId)) {
            if (NumberSupport.isNumeric(fileId) && NumberSupport.isNumeric(userId)) {
                return fileRevisionService.isFileLocked(new BigDecimal(fileId), new BigDecimal(userId));
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
