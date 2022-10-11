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
@Table(name = "GLOB_SIEVELIST_CLIENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSieveListClient.findAll", query = "SELECT g FROM GlobSieveListClient g"),
    @NamedQuery(name = "GlobSieveListClient.findById", query = "SELECT g FROM GlobSieveListClient g WHERE g.id = :id"),
    @NamedQuery(name = "GlobSieveListClient.findByClientId", query = "SELECT g FROM GlobSieveListClient g WHERE g.clientId = :clientId")})
public class GlobSieveListClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @JoinColumn(name = "SIEVE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSievelist sieveId;
    /*@NotNull
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;*/
    @Size(max = 50)
    @Column(name = "COMMON_NAME")
    private String commonName;

    public GlobSieveListClient() {
    }

    public GlobSieveListClient(BigDecimal id) {
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

    public GlobSievelist getSieveId() {
        return sieveId;
    }

    public void setSieveId(GlobSievelist sieveId) {
        this.sieveId = sieveId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
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
        if (!(object instanceof GlobSieveListClient)) {
            return false;
        }
        GlobSieveListClient other = (GlobSieveListClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSieveListClient[ id=" + id + " ]";
    }
}
