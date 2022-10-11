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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobBatchPrintLog.findByTrackNo", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.trackNo = :trackNo")
    , @NamedQuery(name = "GlobBatchPrintLog.findByRequestedBy", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.requestedBy = :requestedBy")
    , @NamedQuery(name = "GlobBatchPrintLog.findByStarting", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.starting = :starting")
    , @NamedQuery(name = "GlobBatchPrintLog.findByEnding", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.ending = :ending")
    , @NamedQuery(name = "GlobBatchPrintLog.findBySearchCriteria", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.searchCriteria = :searchCriteria")
    , @NamedQuery(name = "GlobBatchPrintLog.findByRecordCount", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.recordCount = :recordCount")
    , @NamedQuery(name = "GlobBatchPrintLog.findByStatus", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.status = :status")
    , @NamedQuery(name = "GlobBatchPrintLog.findByDownloadLink", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.downloadLink = :downloadLink")
    , @NamedQuery(name = "GlobBatchPrintLog.findByClientId", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobBatchPrintLog.findByBatchTitle", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.batchTitle = :batchTitle")
    , @NamedQuery(name = "GlobBatchPrintLog.findByBatchType", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.batchType = :batchType")
    , @NamedQuery(name = "GlobBatchPrintLog.findByLabId", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.labId = :labId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_BATCH_PRINT_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobBatchPrintLog.findAll", query = "SELECT g FROM GlobBatchPrintLog g"),
    @NamedQuery(name = "GlobBatchPrintLog.findById", query = "SELECT g FROM GlobBatchPrintLog g WHERE g.id = :id")})
public class GlobBatchPrintLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TRACK_NO")
    private String trackNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUESTED_BY")
    private BigInteger requestedBy;
    @Column(name = "STARTING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starting;
    @Column(name = "ENDING")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ending;
    @Size(max = 2000)
    @Column(name = "SEARCH_CRITERIA")
    private String searchCriteria;
    @Column(name = "RECORD_COUNT")
    private BigInteger recordCount;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 500)
    @Column(name = "DOWNLOAD_LINK")
    private String downloadLink;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 500)
    @Column(name = "BATCH_TITLE")
    private String batchTitle;
    @Size(max = 20)
    @Column(name = "BATCH_TYPE")
    private String batchType;
    @Column(name = "LAB_ID")
    private BigInteger labId;

    public GlobBatchPrintLog() {
    }

    public GlobBatchPrintLog(BigDecimal id) {
        this.id = id;
    }

    public GlobBatchPrintLog(BigDecimal id, String trackNo, BigInteger requestedBy, BigInteger clientId) {
        this.id = id;
        this.trackNo = trackNo;
        this.requestedBy = requestedBy;
        this.clientId = clientId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(String trackNo) {
        this.trackNo = trackNo;
    }

    public BigInteger getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(BigInteger requestedBy) {
        this.requestedBy = requestedBy;
    }

    public Date getStarting() {
        return starting;
    }

    public void setStarting(Date starting) {
        this.starting = starting;
    }

    public Date getEnding() {
        return ending;
    }

    public void setEnding(Date ending) {
        this.ending = ending;
    }

    public String getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(String searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public BigInteger getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(BigInteger recordCount) {
        this.recordCount = recordCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getBatchTitle() {
        return batchTitle;
    }

    public void setBatchTitle(String batchTitle) {
        this.batchTitle = batchTitle;
    }

    public String getBatchType() {
        return batchType;
    }

    public void setBatchType(String batchType) {
        this.batchType = batchType;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
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
        if (!(object instanceof GlobBatchPrintLog)) {
            return false;
        }
        GlobBatchPrintLog other = (GlobBatchPrintLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobBatchPrintLog[ id=" + id + " ]";
    }

}
