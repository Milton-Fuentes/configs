/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.api.resource;

import com.atser.tools.atserejb.model.GlobFile;
import com.atser.tools.atserejb.service.glob.GlobFileService;
import com.atser.tools.atserws.filters.annotation.WsSecured;
import java.io.File;
import java.io.IOException;
import javax.ejb.EJB;
import javax.ws.rs.GET;
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
@Path("/resources/files")
@WsSecured
@Slf4j
public class FileResourceRS {
    
    @EJB
    GlobFileService fileService;

    
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/download")
    public Response downloadFile(@QueryParam("f") String fileId) throws IOException {
        if (fileId != null && !fileId.isEmpty()) {
            GlobFile dbfile = fileService.findById(fileId);
            File file = new File(dbfile.getServerPath());
            return Response.ok(file, MediaType.APPLICATION_OCTET_STREAM)
                    .header("Content-Disposition", "attachment; filename=\"" + dbfile.getFTitle() + "\"").build();
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }
    
    
}
