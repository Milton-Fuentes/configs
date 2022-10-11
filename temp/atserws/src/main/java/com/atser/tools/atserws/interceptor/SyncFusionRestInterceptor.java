/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.interceptor;

import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionBody;
import com.atser.tools.atserutil.rest.interceptor.syncfusion.SyncFusionMsg;
import com.atser.tools.atserws.interceptor.annotation.SyncFusionSegmentRest;
import javax.ejb.EJBException;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response.Status;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Interceptor
@SyncFusionSegmentRest
@Slf4j
public class SyncFusionRestInterceptor {

    private static final String CODE_OK = "200";
    private static final String DESCRIPTION_OK = "OK";

    public SyncFusionRestInterceptor() {
    }

    @AroundInvoke
    public Object detectFailure(InvocationContext ic) throws BaseException {
        Object returnValue = null;
        SyncFusionBody response = new SyncFusionBody();
        SyncFusionMsg msg = new SyncFusionMsg();

        //log.info("DETECT SYNCFUSION START");

        try {
            verifyParams(ic);
            returnValue = ic.proceed();
            response.setData(returnValue);
            msg.setCode(CODE_OK);
            msg.setDescription(DESCRIPTION_OK);
            response.setMsg(msg);
        } catch (BaseException be) {
            response.setData(null);
            response.setMsg(new SyncFusionMsg(be.getCode(), be.getError()));
        } catch (IllegalArgumentException | IllegalStateException | EJBException excepcion) {
            response.setData(null);
            response.setMsg(new SyncFusionMsg(String.valueOf(Status.CONFLICT.getStatusCode()), excepcion.getMessage()));
        } catch (Exception excepcion) {
            response.setData(null);
            response.setMsg(new SyncFusionMsg(String.valueOf(Status.INTERNAL_SERVER_ERROR.getStatusCode()), excepcion.getMessage()));
        } 
        /*finally {
            log.info("DETECT SYNCFUSION FINISH");
        }*/

        return response;
    }

    private void verifyParams(InvocationContext context) {
        BaseException baseException;

        for (Object obj : context.getParameters()) {

            if (obj == null || obj.equals("")) {
                baseException = newException();
                baseException.setCode(String.valueOf(Status.BAD_REQUEST.getStatusCode()));
                baseException.setError(Status.BAD_REQUEST.name());
                throw baseException;
            }
        }
    }

    private BaseException newException() {
        return new BaseException();
    }
}
