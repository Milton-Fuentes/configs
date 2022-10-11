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
public class RoleMappingBO {
    
    private String bpm_role_name;
    private String manageit_role_name;
    private String bpm_group_name;
    private Long client_id;
    private String isAdmin;

    public RoleMappingBO(String bpm_role_name, String manageit_role_name, String bpm_group_name, Long client_id, String isAdmin) {
        this.bpm_role_name = bpm_role_name;
        this.manageit_role_name = manageit_role_name;
        this.bpm_group_name = bpm_group_name;
        this.client_id = client_id;
        this.isAdmin = isAdmin;
    }

    public RoleMappingBO() {
        this.bpm_role_name = StringSupport.STRING_EMPTY;
        this.bpm_group_name = StringSupport.STRING_EMPTY;
        this.manageit_role_name = StringSupport.STRING_EMPTY;
        this.client_id = -1L;
        this.isAdmin = "N";
    }

    public String getBpm_role_name() {
        return bpm_role_name;
    }

    public void setBpm_role_name(String bpm_role_name) {
        this.bpm_role_name = bpm_role_name;
    }

    public String getManageit_role_name() {
        return manageit_role_name;
    }

    public void setManageit_role_name(String manageit_role_name) {
        this.manageit_role_name = manageit_role_name;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    } 

    public String getBpm_group_name() {
        return bpm_group_name;
    }

    public void setBpm_group_name(String bpm_group_name) {
        this.bpm_group_name = bpm_group_name;
    }
     
}
