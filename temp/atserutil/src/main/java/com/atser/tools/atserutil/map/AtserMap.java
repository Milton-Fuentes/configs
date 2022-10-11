/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.map;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author droldan
 * @param <K>
 * @param <V>
 */
public class AtserMap<K, V> extends HashMap<K, V> {

    public Boolean isContainsAllKeys(String[] keys) {
        for (String key : keys) {
            if (!this.containsKey(key)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
    
    public static <T> Map<String, Object> parseClassToMap(T cls) {
        if (cls != null) {
            ObjectMapper oMapper = new ObjectMapper();
            Map<String, Object> map = oMapper.convertValue(cls, Map.class);
            return map;
        }
        return null;
    }
}
