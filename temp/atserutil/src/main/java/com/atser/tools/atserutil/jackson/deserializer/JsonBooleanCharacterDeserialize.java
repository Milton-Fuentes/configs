/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.jackson.deserializer;

import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

/**
 *
 * @author droldan
 */
public class JsonBooleanCharacterDeserialize extends JsonDeserializer<Character> {

    @Override
    public Character deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        String str = jp.getText();
        return StringSupport.getActiveAsCharacter(str);
    }

}
