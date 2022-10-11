/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.concurrent;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author droldan
 */
public class LogSupport {

    /**
     * Log Information for the current Thread
     *
     * @param start
     * @param msg
     */
    public static void Log(Instant start, Object msg) {
        System.out.println(String.format("%s [%s] %s", Duration.between(start, Instant.now()), Thread.currentThread().getName(), msg.toString()));
    }

    /**
     * Get Available Processors
     * @return 
     */
    public static int getAvailableProcessors() {
        return Runtime.getRuntime().availableProcessors();
    }
    
    /**
     * Get Parallelism Level
     * @return 
     */
    public static int getParallelismLevel() {
        return ForkJoinPool.commonPool().getParallelism();
    }
}
