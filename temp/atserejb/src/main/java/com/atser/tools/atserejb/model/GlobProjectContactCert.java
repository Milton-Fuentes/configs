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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_CONTACT_CERT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectContactCert.findAll", query = "SELECT g FROM GlobProjectContactCert g")
    , @NamedQuery(name = "GlobProjectContactCert.findById", query = "SELECT g FROM GlobProjectContactCert g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectContactCert.findByProjectId", query = "SELECT g FROM GlobProjectContactCert g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectContactCert.findByContactId", query = "SELECT g FROM GlobProjectContactCert g WHERE g.contactId = :contactId")
    , @NamedQuery(name = "GlobProjectContactCert.findByCertificationId", query = "SELECT g FROM GlobProjectContactCert g WHERE g.certificationId = :certificationId")})
public class GlobProjectContactCert implements Serializable {

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
    @Column(name = "CONTACT_ID")
    private BigInteger contactId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CERTIFICATION_ID")
    private BigInteger certificationId;

    public GlobProjectContactCert() {
    }

    public GlobProjectContactCert(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectContactCert(BigDecimal id, BigInteger projectId, BigInteger contactId, BigInteger certificationId) {
        this.id = id;
        this.projectId = projectId;
        this.contactId = contactId;
        this.certificationId = certificationId;
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

    public BigInteger getContactId() {
        return contactId;
    }

    public void setContactId(BigInteger contactId) {
        this.contactId = contactId;
    }

    public BigInteger getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(BigInteger certificationId) {
        this.certificationId = certificationId;
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
        if (!(object instanceof GlobProjectContactCert)) {
            return false;
        }
        GlobProjectContactCert other = (GlobProjectContactCert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectContactCert[ id=" + id + " ]";
    }
    
}
