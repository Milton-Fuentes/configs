/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_FEE_SCHEDULE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectFeeSchedule.findAll", query = "SELECT g FROM GlobProjectFeeSchedule g")
    , @NamedQuery(name = "GlobProjectFeeSchedule.findById", query = "SELECT g FROM GlobProjectFeeSchedule g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectFeeSchedule.findByProjectId", query = "SELECT g FROM GlobProjectFeeSchedule g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectFeeSchedule.findByRateTableId", query = "SELECT g FROM GlobProjectFeeSchedule g WHERE g.rateTableId = :rateTableId")
    , @NamedQuery(name = "GlobProjectFeeSchedule.findByStartDate", query = "SELECT g FROM GlobProjectFeeSchedule g WHERE g.startDate = :startDate")
    , @NamedQuery(name = "GlobProjectFeeSchedule.findByEndDate", query = "SELECT g FROM GlobProjectFeeSchedule g WHERE g.endDate = :endDate")})
public class GlobProjectFeeSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "RATE_TABLE_ID")
    private BigInteger rateTableId;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    public GlobProjectFeeSchedule() {
    }

    public GlobProjectFeeSchedule(BigDecimal id) {
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

    public BigInteger getRateTableId() {
        return rateTableId;
    }

    public void setRateTableId(BigInteger rateTableId) {
        this.rateTableId = rateTableId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        if (!(object instanceof GlobProjectFeeSchedule)) {
            return false;
        }
        GlobProjectFeeSchedule other = (GlobProjectFeeSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectFeeSchedule[ id=" + id + " ]";
    }
    
}
