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
@Table(name = "QM_FLAGS_CLIENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QmFlagsClient.findAll", query = "SELECT q FROM QmFlagsClient q"),
    @NamedQuery(name = "QmFlagsClient.findById", query = "SELECT q FROM QmFlagsClient q WHERE q.id = :id"),
    @NamedQuery(name = "QmFlagsClient.findByFlagId", query = "SELECT q FROM QmFlagsClient q WHERE q.flagId = :flagId"),
    @NamedQuery(name = "QmFlagsClient.findByClientId", query = "SELECT q FROM QmFlagsClient q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QmFlagsClient.findByFlagValue", query = "SELECT q FROM QmFlagsClient q WHERE q.flagValue = :flagValue")})
public class QmFlagsClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLAG_ID")
    private BigInteger flagId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "FLAG_VALUE")
    private Character flagValue;

    public QmFlagsClient() {
    }

    public QmFlagsClient(BigDecimal id) {
        this.id = id;
    }

    public QmFlagsClient(BigDecimal id, BigInteger flagId, BigInteger clientId) {
        this.id = id;
        this.flagId = flagId;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFlagId() {
        return flagId;
    }

    public void setFlagId(BigInteger flagId) {
        this.flagId = flagId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Character getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(Character flagValue) {
        this.flagValue = flagValue;
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
        if (!(object instanceof QmFlagsClient)) {
            return false;
        }
        QmFlagsClient other = (QmFlagsClient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QmFlagsClient[ id=" + id + " ]";
    }
    
}
