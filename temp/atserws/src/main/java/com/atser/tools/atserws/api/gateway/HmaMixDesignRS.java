/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.gateway;

import com.atser.tools.atserejb.service.view.VwqaaspmMixdesgExpService;
import com.atser.tools.atserejb.service.view.VwqaaspmMixdesgMasterExpService;
import com.atser.tools.atserutil.enumerator.eEntryPoint;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserws.common.ApiCommon;
import com.atser.tools.atserws.common.IBaseWSException;
import com.atser.tools.atserws.filters.AuthUser;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Path("/gateway/hmamixdesign")
@WsSecured(entrypoint = eEntryPoint.external)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ManageITSegmentRest
@Slf4j
public class HmaMixDesignRS implements IBaseWSException {

    @Context
    SecurityContext securityContext;
    
    @EJB
    VwqaaspmMixdesgMasterExpService vwqaaspmMixdesgMasterExpService;
    
    @EJB
    VwqaaspmMixdesgExpService vwqaaspmMixdesgExpService;
    
    @GET
    @Path("/v1/global/list")
    public Object filterByGetGlobal(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        Optional<BigInteger> clientId = ((AuthUser) securityContext.getUserPrincipal()).getClientId();
        ManageITBodyRequest bodyReq = ApiCommon.buildFilter(uriInfo);
        bodyReq.filter("clientId", clientId.orElse(new BigInteger("-1")));
        return vwqaaspmMixdesgMasterExpService.list(bodyReq);
    }
    
    @GET
    @Path("/v1/project/list")
    public Object filterByGetProject(@Context UriInfo uriInfo, @CookieParam("JSESSIONID") Cookie cookie) throws JsonParseException, JsonMappingException, IOException {
        Optional<BigInteger> clientId = ((AuthUser) securityContext.getUserPrincipal()).getClientId();
        ManageITBodyRequest bodyReq = ApiCommon.buildFilter(uriInfo);
        bodyReq.filter("clientId", clientId.orElse(new BigInteger("-1")));
        return vwqaaspmMixdesgExpService.list(bodyReq);
    }
}
