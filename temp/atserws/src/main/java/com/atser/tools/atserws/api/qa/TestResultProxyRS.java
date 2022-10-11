/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.qa;

import com.atser.tools.atserejb.service.helper.StorageService;
import com.atser.tools.atserejb.service.qa.test.LabTestContextService;
import com.atser.tools.atserutil.objects.pojo.UploadModel;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import java.io.IOException;
import javax.annotation.security.PermitAll;
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
@Path("/qa/testresultproxy")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class TestResultProxyRS implements IBaseWSException {

    @EJB
    protected InitializeEnv env;

    @EJB
    LabTestContextService contextService;

    @EJB
    StorageService storageService;

    @POST
    @Path("/import")
    @PermitAll
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Object importTest(MultipartFormDataInput content) throws IOException {
        UploadModel fileModel = storageService.process(content, env.getDefaultUploadPath());
        contextService.saveCsv(StringSupport.emptyOnNull(fileModel.getMetaDataFile().get("filename")), fileModel.getParams());
        return Response.status(Response.Status.OK).build();
    }

}
