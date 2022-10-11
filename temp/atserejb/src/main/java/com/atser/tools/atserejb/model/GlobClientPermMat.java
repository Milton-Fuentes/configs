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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_PERM_MAT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientPermMat.findAll", query = "SELECT g FROM GlobClientPermMat g")
    , @NamedQuery(name = "GlobClientPermMat.findById", query = "SELECT g FROM GlobClientPermMat g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientPermMat.findByClientId", query = "SELECT g FROM GlobClientPermMat g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientPermMat.findByPermMatId", query = "SELECT g FROM GlobClientPermMat g WHERE g.permMatId = :permMatId")
    , @NamedQuery(name = "GlobClientPermMat.findByPermMatTitle", query = "SELECT g FROM GlobClientPermMat g WHERE g.permMatTitle = :permMatTitle")})
public class GlobClientPermMat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PERM_MAT_ID")
    private BigInteger permMatId;
    @Size(max = 255)
    @Column(name = "PERM_MAT_TITLE")
    private String permMatTitle;

    public GlobClientPermMat() {
    }

    public GlobClientPermMat(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getPermMatId() {
        return permMatId;
    }

    public void setPermMatId(BigInteger permMatId) {
        this.permMatId = permMatId;
    }

    public String getPermMatTitle() {
        return permMatTitle;
    }

    public void setPermMatTitle(String permMatTitle) {
        this.permMatTitle = permMatTitle;
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
        if (!(object instanceof GlobClientPermMat)) {
            return false;
        }
        GlobClientPermMat other = (GlobClientPermMat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientPermMat[ id=" + id + " ]";
    }
    
}
