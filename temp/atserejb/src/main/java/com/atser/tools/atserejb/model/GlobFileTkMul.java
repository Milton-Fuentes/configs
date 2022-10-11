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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_TK_MUL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileTkMul.findAll", query = "SELECT g FROM GlobFileTkMul g")
    , @NamedQuery(name = "GlobFileTkMul.findById", query = "SELECT g FROM GlobFileTkMul g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileTkMul.findByFileId", query = "SELECT g FROM GlobFileTkMul g WHERE g.fileId = :fileId")
    , @NamedQuery(name = "GlobFileTkMul.findByStatus", query = "SELECT g FROM GlobFileTkMul g WHERE g.status = :status")})
public class GlobFileTkMul implements Serializable {

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
    @Column(name = "STATUS")
    private BigInteger status;
    @JoinColumn(name = "FILE_TK_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobFileTk fileTkId;

    public GlobFileTkMul() {
    }

    public GlobFileTkMul(BigDecimal id) {
        this.id = id;
    }

    public GlobFileTkMul(BigDecimal id, BigInteger fileId) {
        this.id = id;
        this.fileId = fileId;
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

    public BigInteger getStatus() {
        return status;
    }

    public void setStatus(BigInteger status) {
        this.status = status;
    }

    public GlobFileTk getFileTkId() {
        return fileTkId;
    }

    public void setFileTkId(GlobFileTk fileTkId) {
        this.fileTkId = fileTkId;
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
        if (!(object instanceof GlobFileTkMul)) {
            return false;
        }
        GlobFileTkMul other = (GlobFileTkMul) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileTkMul[ id=" + id + " ]";
    }
    
}
