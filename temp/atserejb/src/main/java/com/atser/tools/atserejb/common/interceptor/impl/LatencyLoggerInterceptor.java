/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.interceptor.impl;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import java.io.Serializable;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author droldan
 */
@Interceptor
@LatencyLogger
@Slf4j
public class LatencyLoggerInterceptor implements Serializable {
    
    @AroundInvoke
    public Object computeLatency(InvocationContext invocationCtx) throws Exception {
        long startTime = System.currentTimeMillis();
        //execute the intercepted method and store the return value
        Object returnValue = invocationCtx.proceed();
        long endTime = System.currentTimeMillis();
        log.info("Latency of " + invocationCtx.getMethod().getName() + ": " + (endTime - startTime) + "ms");
        return returnValue;

    }
}
