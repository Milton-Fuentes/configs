/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_ROLES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientRoles.findAll", query = "SELECT g FROM GlobClientRoles g")
    , @NamedQuery(name = "GlobClientRoles.findById", query = "SELECT g FROM GlobClientRoles g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientRoles.findByRolesTitle", query = "SELECT g FROM GlobClientRoles g WHERE g.rolesTitle = :rolesTitle")
    , @NamedQuery(name = "GlobClientRoles.findByProjectType", query = "SELECT g FROM GlobClientRoles g WHERE g.projectType = :projectType")})
public class GlobClientRoles implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "ROLES_TITLE")
    private String rolesTitle;
    @Size(max = 50)
    @Column(name = "PROJECT_TYPE")
    private String projectType;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobClient clientId;
    @JoinColumn(name = "MODULE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobModule moduleId;
    @JoinColumn(name = "ROLES_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobRoles rolesId;

    public GlobClientRoles() {
    }

    public GlobClientRoles(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRolesTitle() {
        return rolesTitle;
    }

    public void setRolesTitle(String rolesTitle) {
        this.rolesTitle = rolesTitle;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    public GlobModule getModuleId() {
        return moduleId;
    }

    public void setModuleId(GlobModule moduleId) {
        this.moduleId = moduleId;
    }

    public GlobRoles getRolesId() {
        return rolesId;
    }

    public void setRolesId(GlobRoles rolesId) {
        this.rolesId = rolesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobClientRoles)) {
            return false;
        }
        GlobClientRoles other = (GlobClientRoles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientRoles[ id=" + id + " ]";
    }
    
}
