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
@Table(name = "GLOB_CLIENT_PROJECT_DATA", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientProjectData.findAll", query = "SELECT g FROM GlobClientProjectData g")
    , @NamedQuery(name = "GlobClientProjectData.findById", query = "SELECT g FROM GlobClientProjectData g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientProjectData.findByClientId", query = "SELECT g FROM GlobClientProjectData g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientProjectData.findByDescription", query = "SELECT g FROM GlobClientProjectData g WHERE g.description = :description")
    , @NamedQuery(name = "GlobClientProjectData.findByProjectCount", query = "SELECT g FROM GlobClientProjectData g WHERE g.projectCount = :projectCount")
    , @NamedQuery(name = "GlobClientProjectData.findByCurrentAmount", query = "SELECT g FROM GlobClientProjectData g WHERE g.currentAmount = :currentAmount")
    , @NamedQuery(name = "GlobClientProjectData.findByPhase", query = "SELECT g FROM GlobClientProjectData g WHERE g.phase = :phase")})
public class GlobClientProjectData implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PROJECT_COUNT")
    private BigInteger projectCount;
    @Column(name = "CURRENT_AMOUNT")
    private Double currentAmount;
    @Size(max = 255)
    @Column(name = "PHASE")
    private String phase;

    public GlobClientProjectData() {
    }

    public GlobClientProjectData(BigDecimal id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getProjectCount() {
        return projectCount;
    }

    public void setProjectCount(BigInteger projectCount) {
        this.projectCount = projectCount;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
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
        if (!(object instanceof GlobClientProjectData)) {
            return false;
        }
        GlobClientProjectData other = (GlobClientProjectData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientProjectData[ id=" + id + " ]";
    }
    
}
