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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_ARCHIVE_ENTRY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileArchiveEntry.findAll", query = "SELECT g FROM GlobFileArchiveEntry g")
    , @NamedQuery(name = "GlobFileArchiveEntry.findById", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByVName", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.vName = :vName")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByFileSize", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.fileSize = :fileSize")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByLastModified", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.lastModified = :lastModified")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByUploaded", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.uploaded = :uploaded")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByPName", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.pName = :pName")
    , @NamedQuery(name = "GlobFileArchiveEntry.findByStatus", query = "SELECT g FROM GlobFileArchiveEntry g WHERE g.status = :status")})
public class GlobFileArchiveEntry implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 1024)
    @Column(name = "V_NAME")
    private String vName;
    @Column(name = "FILE_SIZE")
    private BigInteger fileSize;
    @Column(name = "LAST_MODIFIED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "UPLOADED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;
    @Size(max = 512)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 20)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "ARCHIVE_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFileArchive archiveId;

    public GlobFileArchiveEntry() {
    }

    public GlobFileArchiveEntry(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public BigInteger getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigInteger fileSize) {
        this.fileSize = fileSize;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public String getPName() {
        return pName;
    }

    public void setPName(String pName) {
        this.pName = pName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GlobFileArchive getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(GlobFileArchive archiveId) {
        this.archiveId = archiveId;
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
        if (!(object instanceof GlobFileArchiveEntry)) {
            return false;
        }
        GlobFileArchiveEntry other = (GlobFileArchiveEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileArchiveEntry[ id=" + id + " ]";
    }
    
}
