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
@Table(name = "GLOB_FOLDER_SHOW", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderShow.findAll", query = "SELECT g FROM GlobFolderShow g")
    , @NamedQuery(name = "GlobFolderShow.findById", query = "SELECT g FROM GlobFolderShow g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFolderShow.findByFolderId", query = "SELECT g FROM GlobFolderShow g WHERE g.folderId = :folderId")
    , @NamedQuery(name = "GlobFolderShow.findByTrusteeType", query = "SELECT g FROM GlobFolderShow g WHERE g.trusteeType = :trusteeType")
    , @NamedQuery(name = "GlobFolderShow.findByTrusteeId", query = "SELECT g FROM GlobFolderShow g WHERE g.trusteeId = :trusteeId")
    , @NamedQuery(name = "GlobFolderShow.findBySCount", query = "SELECT g FROM GlobFolderShow g WHERE g.sCount = :sCount")})
public class GlobFolderShow implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "TRUSTEE_TYPE")
    private BigInteger trusteeType;
    @Column(name = "TRUSTEE_ID")
    private BigInteger trusteeId;
    @Column(name = "S_COUNT")
    private BigInteger sCount;

    public GlobFolderShow() {
    }

    public GlobFolderShow(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public BigInteger getTrusteeType() {
        return trusteeType;
    }

    public void setTrusteeType(BigInteger trusteeType) {
        this.trusteeType = trusteeType;
    }

    public BigInteger getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(BigInteger trusteeId) {
        this.trusteeId = trusteeId;
    }

    public BigInteger getSCount() {
        return sCount;
    }

    public void setSCount(BigInteger sCount) {
        this.sCount = sCount;
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
        if (!(object instanceof GlobFolderShow)) {
            return false;
        }
        GlobFolderShow other = (GlobFolderShow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderShow[ id=" + id + " ]";
    }
    
}
