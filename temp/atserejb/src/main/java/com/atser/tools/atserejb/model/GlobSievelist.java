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
@NamedQuery(name = "GlobSievelist.findByCommonName", query = "SELECT g FROM GlobSievelist g WHERE g.commonName = :commonName"),
    @NamedQuery(name = "GlobSievelist.findByNameMeasureType", query = "SELECT g FROM GlobSievelist g WHERE g.nameMeasureType = :nameMeasureType"),
    @NamedQuery(name = "GlobSievelist.findByMmSize", query = "SELECT g FROM GlobSievelist g WHERE g.mmSize = :mmSize"),
    @NamedQuery(name = "GlobSievelist.findByInchHoles", query = "SELECT g FROM GlobSievelist g WHERE g.inchHoles = :inchHoles"),
    @NamedQuery(name = "GlobSievelist.findByTrackfld", query = "SELECT g FROM GlobSievelist g WHERE g.trackfld = :trackfld"),
    @NamedQuery(name = "GlobSievelist.findByOrdering", query = "SELECT g FROM GlobSievelist g WHERE g.ordering = :ordering")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SIEVELIST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSievelist.findAll", query = "SELECT g FROM GlobSievelist g"),
    @NamedQuery(name = "GlobSievelist.findById", query = "SELECT g FROM GlobSievelist g WHERE g.id = :id")})
public class GlobSievelist implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "COMMON_NAME")
    private String commonName;
    @Column(name = "NAME_MEASURE_TYPE")
    private Character nameMeasureType;
    @Column(name = "MM_SIZE")
    private Double mmSize;
    @Size(max = 50)
    @Column(name = "INCH_HOLES")
    private String inchHoles;
    @Size(max = 50)
    @Column(name = "TRACKFLD")
    private String trackfld;
    @Column(name = "ORDERING")
    private BigInteger ordering;

    public GlobSievelist() {
    }

    public GlobSievelist(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Character getNameMeasureType() {
        return nameMeasureType;
    }

    public void setNameMeasureType(Character nameMeasureType) {
        this.nameMeasureType = nameMeasureType;
    }

    public Double getMmSize() {
        return mmSize;
    }

    public void setMmSize(Double mmSize) {
        this.mmSize = mmSize;
    }

    public String getInchHoles() {
        return inchHoles;
    }

    public void setInchHoles(String inchHoles) {
        this.inchHoles = inchHoles;
    }

    public String getTrackfld() {
        return trackfld;
    }

    public void setTrackfld(String trackfld) {
        this.trackfld = trackfld;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
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
        if (!(object instanceof GlobSievelist)) {
            return false;
        }
        GlobSievelist other = (GlobSievelist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSievelist[ id=" + id + " ]";
    }
    
}
