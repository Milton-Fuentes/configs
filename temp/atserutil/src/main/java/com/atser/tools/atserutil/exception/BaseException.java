/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.exception;

import com.atser.tools.atserutil.exception.base.ErrorInformation;
import com.atser.tools.atserutil.exception.types.ErrorSeverity;
import com.atser.tools.atserutil.exception.types.ErrorType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author droldan
 */
@ApplicationException(rollback = true, inherited = true)
@JsonIgnoreProperties({"stackTrace", "cause"})
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 7805393878607788241L;
    private static final Logger logger = LoggerFactory.getLogger(BaseException.class);

    protected String id;
    protected String error;
    protected boolean logged;
    protected String username;
    protected String code;
    protected ErrorSeverity severity = ErrorSeverity.WARNING;
    protected ErrorType type = ErrorType.INTERNAL;

    protected List<ErrorInformation> errorInfoList = new ArrayList<>();

    public BaseException() {
        super();
        prepare();
    }

    public BaseException(String msg, Object... params) {
        super((msg == null) ? null : String.format(msg, params));
        prepare();
    }

    public BaseException(Exception e, String msg, Object... params) {
        super((msg == null) ? null : String.format(msg, params), e);
        prepare();
    }

    public BaseException(Exception e, String code) {
        super(e.getMessage(), e);
        prepare();
        this.code = code;
    }

    public BaseException(String code) {
        prepare();
        this.code = code;
    }

    public BaseException(Exception e) {
        super(e.getMessage(), e);
        prepare();
    }

    public BaseException(String msg, String argument) {
        super(String.format(msg, argument));
        prepare();
    }

    public static String getExceptionID() {
        StringBuilder exceptionId = new StringBuilder();
        try {
            exceptionId.append(InetAddress.getLocalHost().getHostName());
        } catch (UnknownHostException ue) {
            exceptionId.append(".....");
        }

        return exceptionId.append(System.currentTimeMillis()).toString();
    }

    public void log() {
        if (!isLogged()) {
            logger.error("Error:", this);
            this.setLogged(true);
        }
    }

    public BaseException addErrorInformation(ErrorInformation errorInfo, BaseException e) {
        addErrorInformation(errorInfo);
        return this;
    }

    public BaseException addErrorInformation(ErrorInformation info) {
        if (info.getType() != this.type) {
            this.type = info.getType();
        }

        if (info.getSeverity() != this.severity) {
            this.severity = info.getSeverity();
        }

        if (info.getCode() != null) {
            setCode(info.getCode());
        }

        this.errorInfoList.add(info);

        return this;
    }

    private void prepare() {
        id = getExceptionID();
        username = "User";

        if (errorInfoList.isEmpty()) {
            addErrorInformation(new ErrorInformation(this.getMessage(), this.getCause()));
        }

        if (this.error == null) {
            this.error = this.getMessage();
        }
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ErrorSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(ErrorSeverity severity) {
        this.severity = severity;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public List<ErrorInformation> getErrorInfoList() {
        return errorInfoList;
    }

    public void setErrorInfoList(List<ErrorInformation> errorInfoList) {
        this.errorInfoList = errorInfoList;
    }

}
