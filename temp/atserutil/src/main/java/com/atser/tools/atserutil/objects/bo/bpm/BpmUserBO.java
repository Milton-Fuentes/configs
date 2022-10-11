/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.bpm;

import com.atser.tools.atserutil.string.StringSupport;

/**
 *
 * @author droldan
 */
public class BpmUserBO {

    private String id;
    private String email;
    private String firstname;
    private String lastname;
    private String title;
    private String username;
    private String pwd;
    private String clientId;

    public BpmUserBO(String id, String email, String firstname, String lastname, String title) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.clientId = StringSupport.STRING_EMPTY;
    }

    public BpmUserBO(String id, String email, String firstname, String lastname, String title, String clientId) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.clientId = clientId;
    }

    public BpmUserBO() {
        this.id = StringSupport.STRING_EMPTY;
        this.email = StringSupport.STRING_EMPTY;
        this.firstname = StringSupport.STRING_EMPTY;
        this.lastname = StringSupport.STRING_EMPTY;
        this.title = StringSupport.STRING_EMPTY;
        this.username = StringSupport.STRING_EMPTY;
        this.pwd = StringSupport.STRING_EMPTY;
        this.clientId = StringSupport.STRING_EMPTY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
