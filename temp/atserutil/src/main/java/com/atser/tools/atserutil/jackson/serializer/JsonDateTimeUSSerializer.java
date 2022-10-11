/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.jackson.serializer;

import com.atser.tools.atserutil.date.DateSupport;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author droldan
 */
public class JsonDateTimeUSSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        String formattedDate = DateSupport.formatDate(t, DateSupport.FORMAT_MMDDYY_HHMMA);
        jg.writeString(formattedDate);
    }

}

