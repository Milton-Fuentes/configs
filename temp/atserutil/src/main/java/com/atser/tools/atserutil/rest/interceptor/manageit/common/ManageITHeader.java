/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.manageit.common;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ManageITHeader implements Serializable{

    private String module;
    private String functionality;
    private String role;
    private String user;
    private String clientid;
    private String userid;
    private String modIp;

    public ManageITHeader() {
        this.functionality = null;
        this.role = null;
    }

    public ManageITHeader(String user, String clientid, String userid, String modIp) {
        this.user = user;
        this.clientid = clientid;
        this.userid = userid;
        this.modIp = modIp;
    }

    public ManageITHeader(String module, String user, String clientid, String userid, String modIp) {
        this.module = module;
        this.user = user;
        this.clientid = clientid;
        this.userid = userid;
        this.modIp = modIp;
    }

    public ManageITHeader(String module, String functionality, String role, String user, String clientid, String userid, String modIp) {
        this.module = module;
        this.functionality = functionality;
        this.role = role;
        this.user = user;
        this.clientid = clientid;
        this.userid = userid;
        this.modIp = modIp;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getModIp() {
        return modIp;
    }

    public void setModIp(String modIp) {
        this.modIp = modIp;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public void initHeaderByGet(List<String> list) {
        if (list != null && list.size() > 0) {
            list.forEach(it -> {
                String[] split = it.split("=");
                switch (split[0]) {
                    case "module": {
                        this.module = split[1];
                        break;
                    }
                    case "functionality": {
                        this.functionality = split[1];
                        break;
                    }
                    case "role": {
                        this.role = split[1];
                        break;
                    }
                    case "user": {
                        this.user = split[1];
                        break;
                    }
                    case "clientid": {
                        this.clientid = split[1];
                        break;
                    }
                    case "userid": {
                        this.userid = split[1];
                        break;
                    }
                    case "modIp": {
                        this.modIp = split[1];
                        break;
                    }
                }
            });
        }
    }
}
