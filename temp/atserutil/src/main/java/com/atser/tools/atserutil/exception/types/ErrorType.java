/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception.types;

import com.atser.tools.atserutil.enumerator.BaseEnum;

/**
 *
 * @author droldan
 */
public enum ErrorType implements BaseEnum {

    INTERNAL("Internal Error"),
    SERVICE("Service Error"),
    CLIENT("Client Error");

    private final String value;

    private ErrorType(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        if (value == null) {
            getValue();
        }
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name();
    }

}
