/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest;

import com.atser.tools.atserutil.jackson.deserializer.XssJacksonDeserializer;
import com.atser.tools.atserutil.jackson.serializer.XssJacksonSerializer;
import com.atser.tools.atserutil.jackson.serializer.contextual.ContextualJsonXssSerializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.DeserializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

/**
 *
 * @author droldan
 */
@Provider
@Produces("application/json")
@Consumes("application/json")
public class JsonContext extends ResteasyJackson2Provider implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public JsonContext() {
        mapper = new ObjectMapper();
        // Enable Filters
        // Xss Filter to Skip Fields
        //SimpleFilterProvider filterSkipXss = new SimpleFilterProvider()
        //        .addFilter("skipXss", filter);
        //mapper.setFilterProvider(filterProvider);
        // Enable Features
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        /*mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper.enable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES);*/
        // Disabled Features
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        //mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // Register a Module
        //mapper.setDateFormat(DateSupport.FORMAT_FULLSYNC);
        // Register Hibernate 5 Module
        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        mapper.registerModule(hibernate5Module);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        mapper.registerModule(new ParameterNamesModule());
        // Register Custom Module XSS
        //SimpleModule moduleXss = new SimpleModule("XssModule");
        //moduleXss.addSerializer(String.class, new ContextualJsonXssSerializer(mapper));
        //moduleXss.addSerializer(String.class, new XssJacksonSerializer());
        //moduleXss.addDeserializer(String.class, new XssJacksonDeserializer());
        //mapper.registerModule(moduleXss);
    }

    @Override
    public ObjectMapper getContext(Class<?> cls) {
        return mapper;
    }

}
