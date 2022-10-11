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

/*
, @NamedQuery(name = "GlobClientRegions.findByClientId", query = "SELECT g FROM GlobClientRegions g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientRegions.findByShortName", query = "SELECT g FROM GlobClientRegions g WHERE g.shortName = :shortName")
    , @NamedQuery(name = "GlobClientRegions.findByName", query = "SELECT g FROM GlobClientRegions g WHERE g.name = :name")
    , @NamedQuery(name = "GlobClientRegions.findByDivisionId", query = "SELECT g FROM GlobClientRegions g WHERE g.divisionId = :divisionId")
    , @NamedQuery(name = "GlobClientRegions.findByRegionNo", query = "SELECT g FROM GlobClientRegions g WHERE g.regionNo = :regionNo")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_REGIONS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientRegions.findAll", query = "SELECT g FROM GlobClientRegions g")
    , @NamedQuery(name = "GlobClientRegions.findById", query = "SELECT g FROM GlobClientRegions g WHERE g.id = :id")})
public class GlobClientRegions implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 50)
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @JoinColumn(name = "DIVISION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = true)
    private GlobClientDivisions divisionId;
    /*@Column(name = "DIVISION_ID")
    private BigInteger divisionId;*/
    @Size(max = 50)
    @Column(name = "REGION_NO")
    private String regionNo;
    @Column(name = "CATG_COLOR_ID")
    private BigInteger catgColorId;

    public GlobClientRegions() {
    }

    public GlobClientRegions(BigDecimal id) {
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GlobClientDivisions getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(GlobClientDivisions divisionId) {
        this.divisionId = divisionId;
    }

    public String getRegionNo() {
        return regionNo;
    }

    public void setRegionNo(String regionNo) {
        this.regionNo = regionNo;
    }

    public BigInteger getCatgColorId() {
        return catgColorId;
    }

    public void setCatgColorId(BigInteger catgColorId) {
        this.catgColorId = catgColorId;
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
        if (!(object instanceof GlobClientRegions)) {
            return false;
        }
        GlobClientRegions other = (GlobClientRegions) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientRegions[ id=" + id + " ]";
    }
    
}
