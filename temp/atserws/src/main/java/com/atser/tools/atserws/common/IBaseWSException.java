/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.common;

import com.atser.tools.atserutil.exception.BaseException;
import javax.ws.rs.core.Response;

/**
 *
 * @author droldan
 */
public interface IBaseWSException {

    /**
     *
     * @param status
     * @param name
     * @throws BaseException
     */
    default void throwBaseException(Response.Status status, String name) {
        BaseException baseException;
        baseException = new BaseException();
        baseException.setCode(String.valueOf(status.getStatusCode()));
        baseException.setError(name);
        throw baseException;
    }

    default void throwBaseException(Response.Status status) {
        throwBaseException(status, status.name());
    }
}
