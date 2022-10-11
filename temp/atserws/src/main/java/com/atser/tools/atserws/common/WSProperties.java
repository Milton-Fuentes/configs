/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws.common;

import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author droldan
 */
public class WSProperties {
    
    public static String getWSProperty(String key) throws IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ws.properties"));
        return properties.getProperty(key);
    }
    
    public static Properties getWSProperty() throws IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("ws.properties"));
        return properties;
    }
    
}
