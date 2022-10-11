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
@Table(name = "CM_PERSONINFO_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmPersoninfoType.findAll", query = "SELECT c FROM CmPersoninfoType c")
    , @NamedQuery(name = "CmPersoninfoType.findById", query = "SELECT c FROM CmPersoninfoType c WHERE c.id = :id")
    , @NamedQuery(name = "CmPersoninfoType.findByRoleName", query = "SELECT c FROM CmPersoninfoType c WHERE c.roleName = :roleName")
    , @NamedQuery(name = "CmPersoninfoType.findByShortdesc", query = "SELECT c FROM CmPersoninfoType c WHERE c.shortdesc = :shortdesc")
    , @NamedQuery(name = "CmPersoninfoType.findByDescription", query = "SELECT c FROM CmPersoninfoType c WHERE c.description = :description")
    , @NamedQuery(name = "CmPersoninfoType.findByActive", query = "SELECT c FROM CmPersoninfoType c WHERE c.active = :active")
    , @NamedQuery(name = "CmPersoninfoType.findByIsAdmin", query = "SELECT c FROM CmPersoninfoType c WHERE c.isAdmin = :isAdmin")})
public class CmPersoninfoType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Size(max = 50)
    @Column(name = "SHORTDESC")
    private String shortdesc;
    @Size(max = 200)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "IS_ADMIN")
    private Character isAdmin;

    public CmPersoninfoType() {
    }

    public CmPersoninfoType(BigDecimal id) {
        this.id = id;
    }

    public CmPersoninfoType(BigDecimal id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Character isAdmin) {
        this.isAdmin = isAdmin;
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
        if (!(object instanceof CmPersoninfoType)) {
            return false;
        }
        CmPersoninfoType other = (CmPersoninfoType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmPersoninfoType[ id=" + id + " ]";
    }
    
}
