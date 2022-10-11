/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.util;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author droldan
 */
public class EJBProperties {
    
    public static String getProperty(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ejb.properties"));
        return properties.getProperty(key);
    }
}
