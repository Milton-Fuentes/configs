/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest;

import com.atser.tools.atserutil.exception.BaseException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 *
 * @author droldan
 */
@Provider
public class HandlerJsonErrorProvider implements ExceptionMapper<BaseException>{
    
    @Override
    public Response toResponse(BaseException exception) {
        exception.log();
    	return Response.status(Status.INTERNAL_SERVER_ERROR).entity(exception).build();
    }
    
}
