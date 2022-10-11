/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author droldan
 */
@Converter(autoApply = true)
public class BooleanCharacterConverter implements AttributeConverter<Boolean, Character> {

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        if (attribute != null && attribute) {
            return 'Y';
        }
        return 'N';
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        if (dbData != null) {
            return dbData.equals('Y');
        }
        return Boolean.FALSE;
    }
}
