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
@Table(name = "GLOB_PROJECT_CM_ALERTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectCmAlerts.findAll", query = "SELECT g FROM GlobProjectCmAlerts g")
    , @NamedQuery(name = "GlobProjectCmAlerts.findById", query = "SELECT g FROM GlobProjectCmAlerts g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectCmAlerts.findByProjectId", query = "SELECT g FROM GlobProjectCmAlerts g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectCmAlerts.findByAlertTypeId", query = "SELECT g FROM GlobProjectCmAlerts g WHERE g.alertTypeId = :alertTypeId")
    , @NamedQuery(name = "GlobProjectCmAlerts.findByAlertDays", query = "SELECT g FROM GlobProjectCmAlerts g WHERE g.alertDays = :alertDays")})
public class GlobProjectCmAlerts implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "ALERT_TYPE_ID")
    private BigInteger alertTypeId;
    @Column(name = "ALERT_DAYS")
    private BigInteger alertDays;

    public GlobProjectCmAlerts() {
    }

    public GlobProjectCmAlerts(BigDecimal id) {
        this.id = id;
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
        if (!(object instanceof GlobProjectCmAlerts)) {
            return false;
        }
        GlobProjectCmAlerts other = (GlobProjectCmAlerts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectCmAlerts[ id=" + id + " ]";
    }
    
}
