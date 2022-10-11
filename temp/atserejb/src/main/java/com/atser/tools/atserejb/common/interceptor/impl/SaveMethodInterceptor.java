/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.interceptor.impl;

import com.atser.tools.atserejb.common.interceptor.annotation.SaveMethod;
import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.lang.reflect.Field;
import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Interceptor
@SaveMethod
@Slf4j
public class SaveMethodInterceptor {

    @AroundInvoke
    public Object populateSaveMetadata(InvocationContext ic) throws Exception {
        final Object[] params = ic.getParameters();
        if (params != null) {
            switch (params.length) {
                case 1: {
                    final Object elem = params[0];
                    if (elem != null) {
                        setEntityValue(elem, "created", new Date());
                        setEntityValue(elem, "lastMod", new Date());
                        ic.setParameters(params);
                    }
                    break;
                }
                case 2: {
                    final ManageITHeader header = (ManageITHeader) params[0];
                    final Object elem = params[1];
                    if (elem != null) {
                        setEntityValue(elem, "created", new Date());
                        setEntityValue(elem, "createDate", DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS));
                        setEntityValue(elem, "createdBy", header.getUser());
                        setEntityValue(elem, "createBy", header.getUser());
                        setEntityValue(elem, "createdByIp", header.getModIp());
                        setEntityValue(elem, "createByIp", header.getModIp());
                        setEntityValue(elem, "lastMod", new Date());
                        setEntityValue(elem, "lastModByIp", header.getModIp());
                        setEntityValue(elem, "lastModIp", header.getModIp());
                        setEntityValue(elem, "lastModBy", header.getUser());
                        setEntityValue(elem, "active", 'Y');
                        setEntityValue(elem, "deleted", 'N');
                        ic.setParameters(params);
                    }
                    break;
                }
            }
        }
        Object returnValue = ic.proceed();
        return returnValue;
    }

    private void setEntityValue(Object elem, String fieldName, Object value) {
        Field obj = getFieldByFieldName(elem.getClass(), fieldName);
        if (obj != null) {
            obj.setAccessible(true);
            try {
                String fieldType = obj.getType().getTypeName();
                switch (fieldName) {
                    case "lastMod": {
                        if (fieldType.equals("java.lang.String")) {
                            value = DateSupport.formatDate(new Date(), DateSupport.FORMAT_MMDDYY_HHMMSS);
                        }
                        break;
                    }
                    case "active": {
                        if (fieldType.equals("java.lang.String")) {
                            value = "Y";
                        }
                        break;
                    }
                }
                obj.set(elem, value);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                log.error("SaveMethodInterceptor -> IllegalArgumentException");
            }
        }
    }

    private Field getFieldByFieldName(Class<?> persistentClass, String fieldName) {
        if (persistentClass == null) {
            return null;
        }
        Field field;
        try {
            field = persistentClass.getDeclaredField(fieldName);
            if (field != null) {
                return field;
            }
        } catch (NoSuchFieldException | SecurityException ex) {
            return null;
        }
        return null;
    }
}
