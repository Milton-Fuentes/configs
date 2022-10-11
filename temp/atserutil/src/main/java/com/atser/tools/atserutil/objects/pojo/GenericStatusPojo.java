/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo;

/**
 *
 * @author droldan
 */
public class GenericStatusPojo {

    private String id;
    private String status;
    private String errorDescription;
    private Object data;
    private Object err;

    public GenericStatusPojo(String id, String status, Object data, Object err, String errorDescription) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.err = err;
        this.errorDescription = errorDescription;
    }

    public GenericStatusPojo(String id, String status, Object data) {
        this.id = id;
        this.status = status;
        this.data = data;
        this.err = null;
        this.errorDescription = null;
    }

    public GenericStatusPojo(String id, String status) {
        this.id = id;
        this.status = status;
        this.data = null;
        this.err = null;
        this.errorDescription = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getErr() {
        return err;
    }

    public void setErr(Object err) {
        this.err = err;
    }
}
