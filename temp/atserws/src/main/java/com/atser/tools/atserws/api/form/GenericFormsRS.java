/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.form;


import com.atser.tools.atserejb.service.glob.GlobNotificationTrackService;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author droldan
 */
@Path("/form")
@WsSecured
public class GenericFormsRS {
    
    @EJB
    GlobNotificationTrackService ntfTrackService;
    
    @GET
    @PermitAll
    @Produces(value = MediaType.TEXT_HTML)
    @Path("/dispatch/technician")
    public String confirmTechnicianDispatch(@QueryParam("t") String token, @QueryParam("r") String techresponse, @QueryParam("k") String techid) throws JsonParseException, JsonMappingException, IOException {
        Boolean status = Boolean.FALSE;
        if ((token != null && !token.isEmpty()) && (techresponse != null && !techresponse.isEmpty())) {
            status = ntfTrackService.updateTechAnswer(token, techresponse, techid);
        }
        
        if(status) {
            return "<script>window.close()</script>";
        } else {
            return "<div style=\"padding: 20px; background-color: #f44336; color: white; margin-bottom: 15px;\"> Sorry, you already informed your decision. </div>";
        }
    }
    
    @GET
    @PermitAll
    @Produces(value = MediaType.TEXT_HTML)
    @Path("/bdispatch/technician")
    public String confirmTechnicianBasicDispatch(@QueryParam("t") String token, @QueryParam("r") String techresponse, @QueryParam("k") String techid) throws JsonParseException, JsonMappingException, IOException {
        Boolean status = Boolean.FALSE;
        if ((token != null && !token.isEmpty()) && (techresponse != null && !techresponse.isEmpty())) {
            status = ntfTrackService.updateBasicTechAnswer(token, techresponse, techid);
        }
        
        if(status) {
            return "<script>window.close()</script>";
        } else {
            return "<div style=\"padding: 20px; background-color: #f44336; color: white; margin-bottom: 15px;\"> Sorry, you already informed your decision. </div>";
        }
    }
    
    @GET
    @PermitAll
    @Produces(value = MediaType.TEXT_HTML)
    @Path("/dispatch/inspector")
    public String confirmInspectorDispatch(@QueryParam("t") String token, @QueryParam("r") String techresponse, @QueryParam("k") String inspid) throws JsonParseException, JsonMappingException, IOException {
        Boolean status = Boolean.FALSE;
        if ((token != null && !token.isEmpty()) && (techresponse != null && !techresponse.isEmpty())) {
            status = ntfTrackService.updateInspAnswer(token, techresponse, inspid);
        }
        
        if(status) {
            return "<script>window.close()</script>";
        } else {
            return "<div style=\"padding: 20px; background-color: #f44336; color: white; margin-bottom: 15px;\"> Sorry, you already informed your decision. </div>";
        }
    }
}
