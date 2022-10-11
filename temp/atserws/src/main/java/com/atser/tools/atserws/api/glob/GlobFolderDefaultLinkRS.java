/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.glob;

import com.atser.tools.atserejb.model.GlobFolder;
import com.atser.tools.atserejb.service.glob.GlobFolderDefaultLinkService;
import com.atser.tools.atserejb.service.glob.GlobFolderService;
import com.atser.tools.atserutil.enumerator.eManageITFolder;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.InitializeEnv;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.EJB;
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
@Path("/glob/folderdefaultlink")
@WsSecured
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class GlobFolderDefaultLinkRS implements IBaseWSException {

    @EJB
    GlobFolderDefaultLinkService service;

    
    @GET
    @Path("/findby/folderidandgroup")
    public Object getByFolderIdAndGroup(@QueryParam("fId") String folderId, @QueryParam("fGroup") String folderGroup) throws IOException, Exception {
        if (StringSupport.isNotNullAndNotEmpty(folderId) && NumberSupport.isNumeric(folderGroup)) {
            return service.getByFolderIdAndGroup(new BigInteger(folderId), new BigInteger(folderGroup));
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

}
