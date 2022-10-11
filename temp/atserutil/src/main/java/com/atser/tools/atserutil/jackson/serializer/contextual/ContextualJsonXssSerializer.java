/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.jackson.serializer.contextual;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;
import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author droldan
 */
public class ContextualJsonXssSerializer extends JsonSerializer<String>
        implements ContextualSerializer {

    private ObjectMapper mapper;
    private boolean skipXss;

    public ContextualJsonXssSerializer(ObjectMapper mapper) {
        this(mapper, false);
    }

    public ContextualJsonXssSerializer(ObjectMapper mapper, boolean skipXss) {
        this.mapper = mapper;
        this.skipXss = skipXss;
    }

    @Override
    public void serialize(String t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        if (!skipXss) {
            jg.writeString(StringEscapeUtils.escapeHtml(t));
        } else {
            jg.writeString(t);
        }
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider sp, BeanProperty bp) throws JsonMappingException {
        if (bp == null) {
            return new ContextualJsonXssSerializer(mapper, false);
        }
        JsonSkipXssSerialization ann = bp.getAnnotation(JsonSkipXssSerialization.class);
        if (ann == null) { // but if missing, default one from class
            ann = bp.getContextAnnotation(JsonSkipXssSerialization.class);
        }
        if (ann == null) {
            return this;
        }
        return new ContextualJsonXssSerializer(mapper, true);
    }

}
