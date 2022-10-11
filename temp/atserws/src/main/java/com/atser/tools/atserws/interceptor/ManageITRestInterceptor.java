/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.interceptor;

import com.atser.tools.atserejb.common.envers.CurrentUser;
import com.atser.tools.atserutil.rest.interceptor.manageit.response.ManageITBodyResponse;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITMsg;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.response.ManageITResponse;
import com.atser.tools.atserutil.exception.BaseException;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITRequest;
import com.atser.tools.atserutil.string.StringSupport;
import com.atser.tools.atserws.interceptor.annotation.ManageITSegmentRest;
import java.lang.reflect.Method;
import javax.ejb.EJBException;
import javax.enterprise.util.Nonbinding;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Interceptor
@ManageITSegmentRest
@Slf4j
public class ManageITRestInterceptor {

    private static final String CODE_OK = "200";
    private static final String DESCRIPTION_OK = "OK";

    public ManageITRestInterceptor() {
    }

    @AroundInvoke
    public Object detectFailure(InvocationContext ic) throws BaseException, Exception {
        Method method = ic.getMethod();
        if (method.isAnnotationPresent(Nonbinding.class)) {
            return ic.proceed();
        }

        ResponseBuilder builder = null;
        Object returnValue = null;
        ManageITResponse response = new ManageITResponse();
        ManageITHeader header = new ManageITHeader();
        ManageITBodyResponse body = new ManageITBodyResponse();
        ManageITMsg msg = new ManageITMsg();

        try {
            header = verifyParams(ic);
            returnValue = ic.proceed();
            body.setData(returnValue);
            msg.setCode(CODE_OK);
            msg.setDescription(DESCRIPTION_OK);
            body.setMsg(msg);
            response.setBody(body);
            builder = Response.ok(response);
        } catch (BaseException be) {
            body.setData(null);
            body.setMsg(new ManageITMsg(be.getCode(), be.getError()));
            response.setBody(body);
            builder = Response.status(Status.fromStatusCode(Integer.valueOf(be.getCode()))).entity(response);
        } catch (IllegalArgumentException | IllegalStateException | EJBException excepcion) {
            body.setData(null);
            body.setMsg(new ManageITMsg(String.valueOf(Status.CONFLICT.getStatusCode()), excepcion.getMessage()));
            response.setBody(body);
            builder = Response.status(Status.CONFLICT).entity(response);
        } catch (Exception excepcion) {
            body.setData(null);
            body.setMsg(new ManageITMsg(String.valueOf(Status.INTERNAL_SERVER_ERROR.getStatusCode()), excepcion.getMessage()));
            response.setBody(body);
            builder = Response.status(Status.INTERNAL_SERVER_ERROR).entity(response);
        } finally {
            response.setHeader(header);
        }

        return builder.build();
    }

    private ManageITHeader verifyParams(InvocationContext context) {
        BaseException baseException;
        Method icMethod = context.getMethod();
        Boolean isGet = icMethod.isAnnotationPresent(GET.class);
        Boolean isPost = icMethod.isAnnotationPresent(POST.class);
        ManageITHeader header = new ManageITHeader();
        if (context.getParameters().length > 0) {
            for (Object obj : context.getParameters()) {
                if (obj == null || obj.equals("")) {
                    baseException = newException();
                    baseException.setCode(String.valueOf(Status.BAD_REQUEST.getStatusCode()));
                    baseException.setError(Status.BAD_REQUEST.name());
                    throw baseException;
                } else {
                    if (isPost) {
                        if (obj instanceof ManageITRequest) {
                            if (!((ManageITRequest) obj).validate()) {
                                baseException = newException();
                                baseException.setCode(String.valueOf(Status.BAD_REQUEST.getStatusCode()));
                                baseException.setError(Status.BAD_REQUEST.name());
                                throw baseException;
                            }
                            header = ((ManageITRequest) obj).getHeader();
                            String clientid = header.getClientid();
                            String module = header.getModule();
                            String user = header.getUser();
                            String userid = header.getUserid();
                            if (StringSupport.isNullOrEmpty(module, user)) {
                                baseException = newException();
                                baseException.setCode(String.valueOf(Status.UNAUTHORIZED.getStatusCode()));
                                baseException.setError(Status.UNAUTHORIZED.name());
                                throw baseException;
                            }
                            CurrentUser.INSTANCE.logIn(((ManageITRequest) obj).getHeader());
                        }
                    } else if (isGet) {
                        return header;
                    }
                }
            }
        } else {
            if (isPost) {
                baseException = newException();
                baseException.setCode(String.valueOf(Status.UNAUTHORIZED.getStatusCode()));
                baseException.setError(Status.UNAUTHORIZED.name());
                throw baseException;
            }
        }
        return header;
    }

    private BaseException newException() {
        return new BaseException();
    }
}
