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

/*
@NamedQuery(name = "GlobClientOfficeLocation.findByClientId", query = "SELECT g FROM GlobClientOfficeLocation g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobClientOfficeLocation.findByRegionId", query = "SELECT g FROM GlobClientOfficeLocation g WHERE g.regionId = :regionId"),
    @NamedQuery(name = "GlobClientOfficeLocation.findByLocation", query = "SELECT g FROM GlobClientOfficeLocation g WHERE g.location = :location"),
    @NamedQuery(name = "GlobClientOfficeLocation.findByLocationNo", query = "SELECT g FROM GlobClientOfficeLocation g WHERE g.locationNo = :locationNo")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_OFFICE_LOCATION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientOfficeLocation.findAll", query = "SELECT g FROM GlobClientOfficeLocation g"),
    @NamedQuery(name = "GlobClientOfficeLocation.findById", query = "SELECT g FROM GlobClientOfficeLocation g WHERE g.id = :id")})
public class GlobClientOfficeLocation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "REGION_ID")
    private BigInteger regionId;
    @Size(max = 50)
    @Column(name = "LOCATION")
    private String location;
    @Size(max = 50)
    @Column(name = "LOCATION_NO")
    private String locationNo;

    public GlobClientOfficeLocation() {
    }

    public GlobClientOfficeLocation(BigDecimal id) {
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

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationNo() {
        return locationNo;
    }

    public void setLocationNo(String locationNo) {
        this.locationNo = locationNo;
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
        if (!(object instanceof GlobClientOfficeLocation)) {
            return false;
        }
        GlobClientOfficeLocation other = (GlobClientOfficeLocation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientOfficeLocation[ id=" + id + " ]";
    }
    
}
