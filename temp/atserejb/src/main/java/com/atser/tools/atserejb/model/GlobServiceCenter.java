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
@Table(name = "GLOB_SERVICE_CENTER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobServiceCenter.findAll", query = "SELECT g FROM GlobServiceCenter g")
    , @NamedQuery(name = "GlobServiceCenter.findById", query = "SELECT g FROM GlobServiceCenter g WHERE g.id = :id")
    , @NamedQuery(name = "GlobServiceCenter.findByClientId", query = "SELECT g FROM GlobServiceCenter g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobServiceCenter.findByServiceCenter", query = "SELECT g FROM GlobServiceCenter g WHERE g.serviceCenter = :serviceCenter")})
public class GlobServiceCenter implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 100)
    @Column(name = "SERVICE_CENTER")
    private String serviceCenter;

    public GlobServiceCenter() {
    }

    public GlobServiceCenter(BigDecimal id) {
        this.id = id;
    }

    public GlobServiceCenter(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
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

    public String getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(String serviceCenter) {
        this.serviceCenter = serviceCenter;
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
        if (!(object instanceof GlobServiceCenter)) {
            return false;
        }
        GlobServiceCenter other = (GlobServiceCenter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobServiceCenter[ id=" + id + " ]";
    }
    
}
