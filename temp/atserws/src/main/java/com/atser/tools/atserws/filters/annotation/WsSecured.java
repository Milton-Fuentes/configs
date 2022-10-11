/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.filters.annotation;

import com.atser.tools.atserutil.enumerator.eEntryPoint;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import javax.ws.rs.NameBinding;
import java.lang.annotation.Target;

/**
 *
 * @author droldan
 */
@NameBinding
@Retention(RUNTIME)
@Target({TYPE, METHOD})
public @interface WsSecured {
    public eEntryPoint entrypoint() default eEntryPoint.web;
    //public eApplicationSupport[] application() default {};
}

