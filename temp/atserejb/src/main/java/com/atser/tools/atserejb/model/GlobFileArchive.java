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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

/*
, @NamedQuery(name = "GlobFileArchive.findByZipName", query = "SELECT g FROM GlobFileArchive g WHERE g.zipName = :zipName")
    , @NamedQuery(name = "GlobFileArchive.findByProjectId", query = "SELECT g FROM GlobFileArchive g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobFileArchive.findByContractId", query = "SELECT g FROM GlobFileArchive g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobFileArchive.findByRequested", query = "SELECT g FROM GlobFileArchive g WHERE g.requested = :requested")
    , @NamedQuery(name = "GlobFileArchive.findByCompleted", query = "SELECT g FROM GlobFileArchive g WHERE g.completed = :completed")
    , @NamedQuery(name = "GlobFileArchive.findByTrackingNo", query = "SELECT g FROM GlobFileArchive g WHERE g.trackingNo = :trackingNo")
    , @NamedQuery(name = "GlobFileArchive.findByStatus", query = "SELECT g FROM GlobFileArchive g WHERE g.status = :status")
    , @NamedQuery(name = "GlobFileArchive.findByNoFiles", query = "SELECT g FROM GlobFileArchive g WHERE g.noFiles = :noFiles")
    , @NamedQuery(name = "GlobFileArchive.findByFileSize", query = "SELECT g FROM GlobFileArchive g WHERE g.fileSize = :fileSize")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_ARCHIVE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileArchive.findAll", query = "SELECT g FROM GlobFileArchive g")
    , @NamedQuery(name = "GlobFileArchive.findById", query = "SELECT g FROM GlobFileArchive g WHERE g.id = :id")})
public class GlobFileArchive implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "ZIP_NAME")
    private String zipName;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "REQUESTED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requested;
    @Column(name = "COMPLETED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completed;
    @Size(max = 6)
    @Column(name = "TRACKING_NO")
    private String trackingNo;
    @Size(max = 10)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NO_FILES")
    private BigInteger noFiles;
    @Column(name = "FILE_SIZE")
    private BigInteger fileSize;
    @OneToMany(mappedBy = "archiveId")
    private List<GlobFileArchiveEntry> globFileArchiveEntryList;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient clientId;

    public GlobFileArchive() {
    }

    public GlobFileArchive(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getZipName() {
        return zipName;
    }

    public void setZipName(String zipName) {
        this.zipName = zipName;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public Date getRequested() {
        return requested;
    }

    public void setRequested(Date requested) {
        this.requested = requested;
    }

    public Date getCompleted() {
        return completed;
    }

    public void setCompleted(Date completed) {
        this.completed = completed;
    }

    public String getTrackingNo() {
        return trackingNo;
    }

    public void setTrackingNo(String trackingNo) {
        this.trackingNo = trackingNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getNoFiles() {
        return noFiles;
    }

    public void setNoFiles(BigInteger noFiles) {
        this.noFiles = noFiles;
    }

    public BigInteger getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigInteger fileSize) {
        this.fileSize = fileSize;
    }

    @XmlTransient
    public List<GlobFileArchiveEntry> getGlobFileArchiveEntryList() {
        return globFileArchiveEntryList;
    }

    public void setGlobFileArchiveEntryList(List<GlobFileArchiveEntry> globFileArchiveEntryList) {
        this.globFileArchiveEntryList = globFileArchiveEntryList;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobFileArchive)) {
            return false;
        }
        GlobFileArchive other = (GlobFileArchive) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileArchive[ id=" + id + " ]";
    }
    
}
