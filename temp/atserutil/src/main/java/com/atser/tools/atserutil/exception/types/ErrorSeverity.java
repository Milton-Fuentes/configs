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
public enum ErrorSeverity implements BaseEnum {

    WARNING("Warning"),
    SERIOUS("Serious"),
    FATAL("Fatal");

    private final String value;

    private ErrorSeverity(final String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String toString() {
        if (value == null) {
            getValue();
        }
        return name();
    }
}
