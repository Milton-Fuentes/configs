/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.service.glob.GlobProjectInsptestItemService;
import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserutil.exception.EmptyDocumentException;
import com.atser.tools.atserutil.exception.ExcelParsingException;
import com.atser.tools.atserutil.exception.FormatDocumentNotAllowedException;
import com.atser.tools.atserutil.exception.NotFoundMimeTypeException;
import com.atser.tools.atserutil.exception.TemplateDifferentException;
import com.atser.tools.atserutil.file.FileSupport;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
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
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

/**
 *
 * @author droldan
 */
@Path("/glob/projectinsptestitem")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobProjectInsptestItemRS implements IBaseWSException {

    @EJB
    protected InitializeEnv env;

    @EJB
    StorageService storageService;

    @EJB
    GlobProjectInsptestItemService globProjectInsptestItemService;

    @GET
    @Path("/list")
    public Object clientFilter(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        return globProjectInsptestItemService.list(ApiCommon.buildFilter(uriInfo));
    }

    @POST
    @Path("/list")
    public Object clientList(ManageITRequest<Object> request) throws JsonParseException, JsonMappingException, IOException {
        if (request != null && request.validate()) {
            return globProjectInsptestItemService.list(request.getBody());
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Path("/v1/import")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object importConcreteSamplev1(MultipartFormDataInput content) throws IOException {
        UploadModel fileModel = storageService.process(content, env.getDefaultUploadPath());
        try {
            return globProjectInsptestItemService.processData(fileModel.getMetaDataFile(), fileModel.getParams());
        } catch (FormatDocumentNotAllowedException | NotFoundMimeTypeException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "Document format is not allowed.");
        } catch (FileNotFoundException e) {
            throwBaseException(Response.Status.BAD_REQUEST, "File not found.");
        } catch (TemplateDifferentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, "Invalid document.");
        } catch (ExcelParsingException | EmptyDocumentException ex) {
            throwBaseException(Response.Status.BAD_REQUEST, ex.getMessage());
        } finally {
            try {
                FileSupport.removeFile(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")));
            } catch (IOException e) {
                throwBaseException(Response.Status.BAD_REQUEST, e.getMessage());
            }
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
