/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.jackson.deserializer;

import com.atser.tools.atserutil.date.DateSupport;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;


/**
 *
 * @author droldan
 */
public class JsonDateTimeDeserialize extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(com.fasterxml.jackson.core.JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String str = jp.getText().trim();
        try {
            return DateSupport.FORMAT_FULL.parse(str);
        } catch (ParseException e) {

        }
        return dc.parseDate(str);
    }
}
