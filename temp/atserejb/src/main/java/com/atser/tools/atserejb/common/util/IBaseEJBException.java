/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.util;

import com.atser.tools.atserutil.exception.BaseException;
import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author droldan
 */
public interface IBaseEJBException {

    default void throwBaseException(Response.Status status, String error) throws BaseException {
        BaseException baseException;
        baseException = new BaseException();
        baseException.setCode(String.valueOf(status.getStatusCode()));
        baseException.setError(error);
        throw baseException;
    }

    default void initializeServiceList(List<?> lazyList) {
        if (lazyList == null) {
            return;
        }
        lazyList.size();
    }
}
