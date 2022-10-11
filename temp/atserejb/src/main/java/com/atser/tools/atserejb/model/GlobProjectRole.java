/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "GLOB_PROJECT_ROLE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectRole.findAll", query = "SELECT g FROM GlobProjectRole g")
    , @NamedQuery(name = "GlobProjectRole.findById", query = "SELECT g FROM GlobProjectRole g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectRole.findByProjectId", query = "SELECT g FROM GlobProjectRole g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectRole.findByRoleName", query = "SELECT g FROM GlobProjectRole g WHERE g.roleName = :roleName")})
public class GlobProjectRole implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "ROLE_NAME")
    private String roleName;
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobContact contactId;

    public GlobProjectRole() {
    }

    public GlobProjectRole(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectRole(BigDecimal id, BigInteger projectId, String roleName) {
        this.id = id;
        this.projectId = projectId;
        this.roleName = roleName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public GlobContact getContactId() {
        return contactId;
    }

    public void setContactId(GlobContact contactId) {
        this.contactId = contactId;
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
        if (!(object instanceof GlobProjectRole)) {
            return false;
        }
        GlobProjectRole other = (GlobProjectRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectRole[ id=" + id + " ]";
    }
    
}
