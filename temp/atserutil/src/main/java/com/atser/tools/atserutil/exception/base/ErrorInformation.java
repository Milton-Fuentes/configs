/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception.base;

import com.atser.tools.atserutil.exception.types.ErrorSeverity;
import com.atser.tools.atserutil.exception.types.ErrorType;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author droldan
 */
public class ErrorInformation implements Serializable {

    protected Throwable cause;
    protected String code;
    protected ErrorType type = ErrorType.INTERNAL;
    protected ErrorSeverity severity = ErrorSeverity.SERIOUS;
    protected String userErrorDescription;
    protected String errorDescription;
    protected String errorCorrection;

    protected Map<String, Object> parameters = new HashMap<>();

    public ErrorInformation(String code, String errorDescription, Throwable cause) {
        this.cause = cause;
        this.code = code;
        this.errorDescription = errorDescription;
    }

    public ErrorInformation(String errorDescription, Throwable cause) {
        this.cause = cause;
        this.code = "Raised Error Base";
        this.errorDescription = errorDescription;

    }

    public ErrorInformation(String errorCode) {
        this.code = errorCode;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ErrorSeverity severity) {
        this.severity = severity;
    }

    public String getUserErrorDescription() {
        return userErrorDescription;
    }

    public void setUserErrorDescription(String userErrorDescription) {
        this.userErrorDescription = userErrorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorCorrection() {
        return errorCorrection;
    }

    public void setErrorCorrection(String errorCorrection) {
        this.errorCorrection = errorCorrection;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
