/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.map;

import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 *
 * @author droldan
 * @param <K>
 * @param <V>
 */
public class AtserLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    public Boolean isContainsAllKeys(String[] keys) {
        for (String key : keys) {
            if (!this.containsKey(key)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    public Boolean isContainsAllKeysAndNotNull(String[] keys) {
        for (String key : keys) {
            if (!this.containsKey(key) || StringSupport.isNullOrEmpty(this.get(key))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    /**
     * Convert Json String to Map
     *
     * @param json
     * @return null if the json String is null or empty
     */
    public static AtserLinkedHashMap<String, Object> parseJsonString(String json) {
        if (StringSupport.isNotNullAndNotEmpty(json)) {
            try {
                Gson gson = new Gson();
                Type type = new TypeToken<AtserLinkedHashMap<String, Object>>() {
                }.getType();
                AtserLinkedHashMap<String, Object> result = gson.fromJson(json, type);
                return result;
            } catch (JsonParseException e) {
                return null;
            }
        }
        return null;
    }

    public static String toJsonString(LinkedHashMap map) throws JsonProcessingException {
        if (map != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(map);
        }
        return null;
    }

}
