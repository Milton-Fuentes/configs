/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.converter;

import com.atser.tools.atserutil.objects.to.qa.QaTestLogModelTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author droldan
 */
@Converter
public class QaTestLogModelToConverter implements AttributeConverter<QaTestLogModelTO, String> {

    @Override
    public String convertToDatabaseColumn(QaTestLogModelTO attribute) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException ex) {
            return null;
        }
    }

    @Override
    public QaTestLogModelTO convertToEntityAttribute(String dbData) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(dbData, QaTestLogModelTO.class);
        } catch (IOException ex) {
            return null;
        }
    }

}
