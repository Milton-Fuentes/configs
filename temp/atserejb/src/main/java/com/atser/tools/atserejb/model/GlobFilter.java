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
, @NamedQuery(name = "GlobFilter.findByEntryId", query = "SELECT g FROM GlobFilter g WHERE g.entryId = :entryId")
    , @NamedQuery(name = "GlobFilter.findByEntryType", query = "SELECT g FROM GlobFilter g WHERE g.entryType = :entryType")
    , @NamedQuery(name = "GlobFilter.findByFDelete", query = "SELECT g FROM GlobFilter g WHERE g.fDelete = :fDelete")
    , @NamedQuery(name = "GlobFilter.findByFUpload", query = "SELECT g FROM GlobFilter g WHERE g.fUpload = :fUpload")
    , @NamedQuery(name = "GlobFilter.findByFBrowse", query = "SELECT g FROM GlobFilter g WHERE g.fBrowse = :fBrowse")
    , @NamedQuery(name = "GlobFilter.findByFDnload", query = "SELECT g FROM GlobFilter g WHERE g.fDnload = :fDnload")
    , @NamedQuery(name = "GlobFilter.findByFCreate", query = "SELECT g FROM GlobFilter g WHERE g.fCreate = :fCreate")
    , @NamedQuery(name = "GlobFilter.findByFModify", query = "SELECT g FROM GlobFilter g WHERE g.fModify = :fModify")
    , @NamedQuery(name = "GlobFilter.findByFOwner", query = "SELECT g FROM GlobFilter g WHERE g.fOwner = :fOwner")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILTER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFilter.findAll", query = "SELECT g FROM GlobFilter g")
    , @NamedQuery(name = "GlobFilter.findById", query = "SELECT g FROM GlobFilter g WHERE g.id = :id")})
public class GlobFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENTRY_ID")
    private BigInteger entryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "ENTRY_TYPE")
    private String entryType;
    @Column(name = "F_DELETE")
    private Character fDelete;
    @Column(name = "F_UPLOAD")
    private Character fUpload;
    @Column(name = "F_BROWSE")
    private Character fBrowse;
    @Column(name = "F_DNLOAD")
    private Character fDnload;
    @Column(name = "F_CREATE")
    private Character fCreate;
    @Column(name = "F_MODIFY")
    private Character fModify;
    @Column(name = "F_OWNER")
    private Character fOwner;

    public GlobFilter() {
    }

    public GlobFilter(BigDecimal id) {
        this.id = id;
    }

    public GlobFilter(BigDecimal id, BigInteger entryId, String entryType) {
        this.id = id;
        this.entryId = entryId;
        this.entryType = entryType;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEntryId() {
        return entryId;
    }

    public void setEntryId(BigInteger entryId) {
        this.entryId = entryId;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public Character getFDelete() {
        return fDelete;
    }

    public void setFDelete(Character fDelete) {
        this.fDelete = fDelete;
    }

    public Character getFUpload() {
        return fUpload;
    }

    public void setFUpload(Character fUpload) {
        this.fUpload = fUpload;
    }

    public Character getFBrowse() {
        return fBrowse;
    }

    public void setFBrowse(Character fBrowse) {
        this.fBrowse = fBrowse;
    }

    public Character getFDnload() {
        return fDnload;
    }

    public void setFDnload(Character fDnload) {
        this.fDnload = fDnload;
    }

    public Character getFCreate() {
        return fCreate;
    }

    public void setFCreate(Character fCreate) {
        this.fCreate = fCreate;
    }

    public Character getFModify() {
        return fModify;
    }

    public void setFModify(Character fModify) {
        this.fModify = fModify;
    }

    public Character getFOwner() {
        return fOwner;
    }

    public void setFOwner(Character fOwner) {
        this.fOwner = fOwner;
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
        if (!(object instanceof GlobFilter)) {
            return false;
        }
        GlobFilter other = (GlobFilter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFilter[ id=" + id + " ]";
    }
    
}
