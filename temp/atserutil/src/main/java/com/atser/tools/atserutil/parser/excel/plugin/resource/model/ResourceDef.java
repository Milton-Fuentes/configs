/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.model;

import com.google.gson.annotations.Expose;
import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class ResourceDef implements Serializable{
    @Expose
    private String code;
    @Expose
    private String firstname;
    @Expose
    private String lastname;
    @Expose
    private String title;

    public ResourceDef() {
        this.code = null;
        this.firstname = null;
        this.lastname = null;
        this.title = null;
    }

    public ResourceDef(String code, String firstname, String lastname, String title) {
        this.code = code;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }   
}
