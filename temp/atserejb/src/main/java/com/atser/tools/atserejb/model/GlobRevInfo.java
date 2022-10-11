/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserejb.common.envers.GlobRevisionListener;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_REVINFO", catalog = "", schema = "ORACLE")
@RevisionEntity(GlobRevisionListener.class)
public class GlobRevInfo extends DefaultRevisionEntity {
    
    private String username;
    private String role;
    private String modip;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getModip() {
        return modip;
    }

    public void setModip(String modip) {
        this.modip = modip;
    }
}
