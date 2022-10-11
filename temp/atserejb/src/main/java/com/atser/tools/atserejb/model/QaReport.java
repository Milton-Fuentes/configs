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
@NamedQuery(name = "QaReport.findByTestReportId", query = "SELECT q FROM QaReport q WHERE q.testReportId = :testReportId"),
    @NamedQuery(name = "QaReport.findByInfoId", query = "SELECT q FROM QaReport q WHERE q.infoId = :infoId"),
    @NamedQuery(name = "QaReport.findBySampleId", query = "SELECT q FROM QaReport q WHERE q.sampleId = :sampleId"),
    @NamedQuery(name = "QaReport.findByReportNo", query = "SELECT q FROM QaReport q WHERE q.reportNo = :reportNo"),
    @NamedQuery(name = "QaReport.findByActive", query = "SELECT q FROM QaReport q WHERE q.active = :active"),
    @NamedQuery(name = "QaReport.findByLastMod", query = "SELECT q FROM QaReport q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaReport.findByLastModBy", query = "SELECT q FROM QaReport q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaReport.findByLastModIp", query = "SELECT q FROM QaReport q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaReport.findByCreateDate", query = "SELECT q FROM QaReport q WHERE q.createDate = :createDate"),
    @NamedQuery(name = "QaReport.findByCreateBy", query = "SELECT q FROM QaReport q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaReport.findByCreateByIp", query = "SELECT q FROM QaReport q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaReport.findByVersion", query = "SELECT q FROM QaReport q WHERE q.version = :version"),
    @NamedQuery(name = "QaReport.findByReportDate", query = "SELECT q FROM QaReport q WHERE q.reportDate = :reportDate"),
    @NamedQuery(name = "QaReport.findByRemarks", query = "SELECT q FROM QaReport q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaReport.findByItemId", query = "SELECT q FROM QaReport q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaReport.findBySubItemId", query = "SELECT q FROM QaReport q WHERE q.subItemId = :subItemId"),
    @NamedQuery(name = "QaReport.findBySampleTestId", query = "SELECT q FROM QaReport q WHERE q.sampleTestId = :sampleTestId"),
    @NamedQuery(name = "QaReport.findByRmsNo", query = "SELECT q FROM QaReport q WHERE q.rmsNo = :rmsNo")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_REPORT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaReport.findAll", query = "SELECT q FROM QaReport q"),
    @NamedQuery(name = "QaReport.findById", query = "SELECT q FROM QaReport q WHERE q.id = :id")})
public class QaReport implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_REPORT_ID")
    private BigInteger testReportId;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "SAMPLE_ID")
    private BigInteger sampleId;
    @Size(max = 50)
    @Column(name = "REPORT_NO")
    private String reportNo;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "SUB_ITEM_ID")
    private BigInteger subItemId;
    @Column(name = "SAMPLE_TEST_ID")
    private BigInteger sampleTestId;
    @Size(max = 200)
    @Column(name = "RMS_NO")
    private String rmsNo;

    public QaReport() {
    }

    public QaReport(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getTestReportId() {
        return testReportId;
    }

    public void setTestReportId(BigInteger testReportId) {
        this.testReportId = testReportId;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public BigInteger getSampleId() {
        return sampleId;
    }

    public void setSampleId(BigInteger sampleId) {
        this.sampleId = sampleId;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public BigInteger getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(BigInteger subItemId) {
        this.subItemId = subItemId;
    }

    public BigInteger getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(BigInteger sampleTestId) {
        this.sampleTestId = sampleTestId;
    }

    public String getRmsNo() {
        return rmsNo;
    }

    public void setRmsNo(String rmsNo) {
        this.rmsNo = rmsNo;
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
        if (!(object instanceof QaReport)) {
            return false;
        }
        QaReport other = (QaReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaReport[ id=" + id + " ]";
    }
    
}
