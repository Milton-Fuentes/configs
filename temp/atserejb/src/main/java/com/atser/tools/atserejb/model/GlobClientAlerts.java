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
@Table(name = "GLOB_CLIENT_ALERTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientAlerts.findAll", query = "SELECT g FROM GlobClientAlerts g")
    , @NamedQuery(name = "GlobClientAlerts.findById", query = "SELECT g FROM GlobClientAlerts g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientAlerts.findByClientId", query = "SELECT g FROM GlobClientAlerts g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientAlerts.findByAlertTypeId", query = "SELECT g FROM GlobClientAlerts g WHERE g.alertTypeId = :alertTypeId")
    , @NamedQuery(name = "GlobClientAlerts.findByAlertDays", query = "SELECT g FROM GlobClientAlerts g WHERE g.alertDays = :alertDays")})
public class GlobClientAlerts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "ALERT_TYPE_ID")
    private BigInteger alertTypeId;
    @Column(name = "ALERT_DAYS")
    private BigInteger alertDays;

    public GlobClientAlerts() {
    }

    public GlobClientAlerts(BigDecimal id) {
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

    public BigInteger getAlertTypeId() {
        return alertTypeId;
    }

    public void setAlertTypeId(BigInteger alertTypeId) {
        this.alertTypeId = alertTypeId;
    }

    public BigInteger getAlertDays() {
        return alertDays;
    }

    public void setAlertDays(BigInteger alertDays) {
        this.alertDays = alertDays;
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
        if (!(object instanceof GlobClientAlerts)) {
            return false;
        }
        GlobClientAlerts other = (GlobClientAlerts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientAlerts[ id=" + id + " ]";
    }
    
}
