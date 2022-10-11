/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    , @NamedQuery(name = "InReport.findByReportTitle", query = "SELECT i FROM InReport i WHERE i.reportTitle = :reportTitle")
    , @NamedQuery(name = "InReport.findByReportDate", query = "SELECT i FROM InReport i WHERE i.reportDate = :reportDate")
    , @NamedQuery(name = "InReport.findByReportTime", query = "SELECT i FROM InReport i WHERE i.reportTime = :reportTime")
    , @NamedQuery(name = "InReport.findByActive", query = "SELECT i FROM InReport i WHERE i.active = :active")
    , @NamedQuery(name = "InReport.findByLastMod", query = "SELECT i FROM InReport i WHERE i.lastMod = :lastMod")
    , @NamedQuery(name = "InReport.findByLastModBy", query = "SELECT i FROM InReport i WHERE i.lastModBy = :lastModBy")
    , @NamedQuery(name = "InReport.findByLastModIp", query = "SELECT i FROM InReport i WHERE i.lastModIp = :lastModIp")
    , @NamedQuery(name = "InReport.findByTemp", query = "SELECT i FROM InReport i WHERE i.temp = :temp")
    , @NamedQuery(name = "InReport.findByCreateBy", query = "SELECT i FROM InReport i WHERE i.createBy = :createBy")
    , @NamedQuery(name = "InReport.findByCreateByIp", query = "SELECT i FROM InReport i WHERE i.createByIp = :createByIp")
    , @NamedQuery(name = "InReport.findByCreateDate", query = "SELECT i FROM InReport i WHERE i.createDate = :createDate")
    , @NamedQuery(name = "InReport.findByReportNo", query = "SELECT i FROM InReport i WHERE i.reportNo = :reportNo")
    , @NamedQuery(name = "InReport.findByVersion", query = "SELECT i FROM InReport i WHERE i.version = :version")
    , @NamedQuery(name = "InReport.findByFunctionId", query = "SELECT i FROM InReport i WHERE i.functionId = :functionId")
    , @NamedQuery(name = "InReport.findByApprovedBy", query = "SELECT i FROM InReport i WHERE i.approvedBy = :approvedBy")
    , @NamedQuery(name = "InReport.findByInfoId", query = "SELECT i FROM InReport i WHERE i.infoId = :infoId")
    , @NamedQuery(name = "InReport.findByUnapproved", query = "SELECT i FROM InReport i WHERE i.unapproved = :unapproved")
    , @NamedQuery(name = "InReport.findByUnapprovedBy", query = "SELECT i FROM InReport i WHERE i.unapprovedBy = :unapprovedBy")
    , @NamedQuery(name = "InReport.findByReason", query = "SELECT i FROM InReport i WHERE i.reason = :reason")
    , @NamedQuery(name = "InReport.findByApprovedDateTmp", query = "SELECT i FROM InReport i WHERE i.approvedDateTmp = :approvedDateTmp")
    , @NamedQuery(name = "InReport.findByReportDateTmp", query = "SELECT i FROM InReport i WHERE i.reportDateTmp = :reportDateTmp")
    , @NamedQuery(name = "InReport.findByLastModTmp", query = "SELECT i FROM InReport i WHERE i.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "InReport.findByTempTmp", query = "SELECT i FROM InReport i WHERE i.tempTmp = :tempTmp")
    , @NamedQuery(name = "InReport.findByCreateDateTmp", query = "SELECT i FROM InReport i WHERE i.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "InReport.findByApprovedDate", query = "SELECT i FROM InReport i WHERE i.approvedDate = :approvedDate")
    , @NamedQuery(name = "InReport.findByStatus", query = "SELECT i FROM InReport i WHERE i.status = :status")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "IN_REPORT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InReport.findAll", query = "SELECT i FROM InReport i")
    , @NamedQuery(name = "InReport.findById", query = "SELECT i FROM InReport i WHERE i.id = :id")})
public class InReport implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "REPORT_TITLE")
    private String reportTitle;
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @Column(name = "REPORT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportTime;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Column(name = "TEMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date temp;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "REPORT_NO")
    private BigInteger reportNo;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Size(max = 255)
    @Column(name = "APPROVED_BY")
    private String approvedBy;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "UNAPPROVED")
    private Character unapproved;
    @Size(max = 255)
    @Column(name = "UNAPPROVED_BY")
    private String unapprovedBy;
    @Size(max = 4000)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 4000)
    @Column(name = "APPROVED_DATE_TMP")
    private String approvedDateTmp;
    @Size(max = 4000)
    @Column(name = "REPORT_DATE_TMP")
    private String reportDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "TEMP_TMP")
    private String tempTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @OneToMany(mappedBy = "inReportId")
    private List<GlobActivityInspection> globActivityInspectionList;
    @JoinColumn(name = "CONTRACTOR_CONTRACT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobContractorContract contractorContractId;
    @JoinColumn(name = "REPORT_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private InReportType reportTypeId;

    public InReport() {
    }

    public InReport(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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

    public Date getTemp() {
        return temp;
    }

    public void setTemp(Date temp) {
        this.temp = temp;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigInteger getReportNo() {
        return reportNo;
    }

    public void setReportNo(BigInteger reportNo) {
        this.reportNo = reportNo;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public Character getUnapproved() {
        return unapproved;
    }

    public void setUnapproved(Character unapproved) {
        this.unapproved = unapproved;
    }

    public String getUnapprovedBy() {
        return unapprovedBy;
    }

    public void setUnapprovedBy(String unapprovedBy) {
        this.unapprovedBy = unapprovedBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApprovedDateTmp() {
        return approvedDateTmp;
    }

    public void setApprovedDateTmp(String approvedDateTmp) {
        this.approvedDateTmp = approvedDateTmp;
    }

    public String getReportDateTmp() {
        return reportDateTmp;
    }

    public void setReportDateTmp(String reportDateTmp) {
        this.reportDateTmp = reportDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getTempTmp() {
        return tempTmp;
    }

    public void setTempTmp(String tempTmp) {
        this.tempTmp = tempTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<GlobActivityInspection> getGlobActivityInspectionList() {
        return globActivityInspectionList;
    }

    public void setGlobActivityInspectionList(List<GlobActivityInspection> globActivityInspectionList) {
        this.globActivityInspectionList = globActivityInspectionList;
    }

    public GlobContractorContract getContractorContractId() {
        return contractorContractId;
    }

    public void setContractorContractId(GlobContractorContract contractorContractId) {
        this.contractorContractId = contractorContractId;
    }

    public InReportType getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(InReportType reportTypeId) {
        this.reportTypeId = reportTypeId;
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
        if (!(object instanceof InReport)) {
            return false;
        }
        InReport other = (InReport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.InReport[ id=" + id + " ]";
    }
    
}
