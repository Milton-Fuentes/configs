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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_TK", catalog = "", schema = "ORACLE")
@Where(clause = "status = 1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileTk.findAll", query = "SELECT g FROM GlobFileTk g")
    , @NamedQuery(name = "GlobFileTk.findById", query = "SELECT g FROM GlobFileTk g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileTk.findByFileId", query = "SELECT g FROM GlobFileTk g WHERE g.fileId = :fileId")
    , @NamedQuery(name = "GlobFileTk.findByToken", query = "SELECT g FROM GlobFileTk g WHERE g.token = :token")
    , @NamedQuery(name = "GlobFileTk.findByCreated", query = "SELECT g FROM GlobFileTk g WHERE g.created = :created")
    , @NamedQuery(name = "GlobFileTk.findByExpireDays", query = "SELECT g FROM GlobFileTk g WHERE g.expireDays = :expireDays")
    , @NamedQuery(name = "GlobFileTk.findByStatus", query = "SELECT g FROM GlobFileTk g WHERE g.status = :status")
    , @NamedQuery(name = "GlobFileTk.findByAccessTime", query = "SELECT g FROM GlobFileTk g WHERE g.accessTime = :accessTime")
    , @NamedQuery(name = "GlobFileTk.findByClientId", query = "SELECT g FROM GlobFileTk g WHERE g.clientId = :clientId")})
public class GlobFileTk implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileTkId", fetch = FetchType.LAZY)
    private List<GlobFileTkMul> globFileTkMulList;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILE_ID")
    private BigInteger fileId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "EXPIRE_DAYS")
    private BigInteger expireDays;
    @Column(name = "STATUS")
    private BigInteger status;
    @Column(name = "ACCESS_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @OneToMany(mappedBy = "fileTkId", fetch = FetchType.LAZY)
    private List<GlobFileTkShare> globFileTkShareList;

    public GlobFileTk() {
    }

    public GlobFileTk(BigDecimal id) {
        this.id = id;
    }

    public GlobFileTk(BigDecimal id, BigInteger fileId, String token, BigInteger clientId) {
        this.id = id;
        this.fileId = fileId;
        this.token = token;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigInteger getExpireDays() {
        return expireDays;
    }

    public void setExpireDays(BigInteger expireDays) {
        this.expireDays = expireDays;
    }

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<GlobFileTkShare> getGlobFileTkShareList() {
        return globFileTkShareList;
    }

    public void setGlobFileTkShareList(List<GlobFileTkShare> globFileTkShareList) {
        this.globFileTkShareList = globFileTkShareList;
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
        if (!(object instanceof GlobFileTk)) {
            return false;
        }
        GlobFileTk other = (GlobFileTk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileTk[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobFileTkMul> getGlobFileTkMulList() {
        return globFileTkMulList;
    }

    public void setGlobFileTkMulList(List<GlobFileTkMul> globFileTkMulList) {
        this.globFileTkMulList = globFileTkMulList;
    }
    
}
