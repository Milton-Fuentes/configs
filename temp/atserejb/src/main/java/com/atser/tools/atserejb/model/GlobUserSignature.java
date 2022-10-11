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
import javax.persistence.Lob;
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
@Table(name = "GLOB_USER_SIGNATURE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobUserSignature.findAll", query = "SELECT g FROM GlobUserSignature g")
    , @NamedQuery(name = "GlobUserSignature.findById", query = "SELECT g FROM GlobUserSignature g WHERE g.id = :id")
    , @NamedQuery(name = "GlobUserSignature.findByUserId", query = "SELECT g FROM GlobUserSignature g WHERE g.userId = :userId")
    , @NamedQuery(name = "GlobUserSignature.findByImageTimestamp", query = "SELECT g FROM GlobUserSignature g WHERE g.imageTimestamp = :imageTimestamp")})
public class GlobUserSignature implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Lob
    @Column(name = "IMAGE_DATA")
    private byte[] imageData;

    public GlobUserSignature() {
    }

    public GlobUserSignature(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public Date getImageTimestamp() {
        return imageTimestamp;
    }

    public void setImageTimestamp(Date imageTimestamp) {
        this.imageTimestamp = imageTimestamp;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
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
        if (!(object instanceof GlobUserSignature)) {
            return false;
        }
        GlobUserSignature other = (GlobUserSignature) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobUserSignature[ id=" + id + " ]";
    }
    
}
