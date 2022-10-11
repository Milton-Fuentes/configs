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
@Table(name = "GLOB_PROJECT_LOCATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectLocation.findAll", query = "SELECT g FROM GlobProjectLocation g")
    , @NamedQuery(name = "GlobProjectLocation.findById", query = "SELECT g FROM GlobProjectLocation g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectLocation.findByProjectId", query = "SELECT g FROM GlobProjectLocation g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectLocation.findByRegionId", query = "SELECT g FROM GlobProjectLocation g WHERE g.regionId = :regionId")
    , @NamedQuery(name = "GlobProjectLocation.findByOfficeLocationId", query = "SELECT g FROM GlobProjectLocation g WHERE g.officeLocationId = :officeLocationId")})
public class GlobProjectLocation implements Serializable {

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
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OFFICE_LOCATION_ID")
    private BigInteger officeLocationId;

    public GlobProjectLocation() {
    }

    public GlobProjectLocation(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectLocation(BigDecimal id, BigInteger projectId, BigInteger regionId, BigInteger officeLocationId) {
        this.id = id;
        this.projectId = projectId;
        this.regionId = regionId;
        this.officeLocationId = officeLocationId;
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

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public BigInteger getOfficeLocationId() {
        return officeLocationId;
    }

    public void setOfficeLocationId(BigInteger officeLocationId) {
        this.officeLocationId = officeLocationId;
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
        if (!(object instanceof GlobProjectLocation)) {
            return false;
        }
        GlobProjectLocation other = (GlobProjectLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectLocation[ id=" + id + " ]";
    }
    
}
