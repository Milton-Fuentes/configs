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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobDispatchcallLog.findByServiceDate", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.serviceDate = :serviceDate")
    , @NamedQuery(name = "GlobDispatchcallLog.findByProjectId", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobDispatchcallLog.findByServicesRequested", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.servicesRequested = :servicesRequested")
    , @NamedQuery(name = "GlobDispatchcallLog.findByTimeSite", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.timeSite = :timeSite")
    , @NamedQuery(name = "GlobDispatchcallLog.findByHours", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.hours = :hours")
    , @NamedQuery(name = "GlobDispatchcallLog.findByTechnician", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.technician = :technician")
    , @NamedQuery(name = "GlobDispatchcallLog.findByDept", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.dept = :dept")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCancelled", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.cancelled = :cancelled")
    , @NamedQuery(name = "GlobDispatchcallLog.findBySpecInstr", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.specInstr = :specInstr")
    , @NamedQuery(name = "GlobDispatchcallLog.findByRequestedBy", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.requestedBy = :requestedBy")
    , @NamedQuery(name = "GlobDispatchcallLog.findByRequestedTime", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.requestedTime = :requestedTime")
    , @NamedQuery(name = "GlobDispatchcallLog.findByActive", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.active = :active")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCreateBy", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCreateByIp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByLastModBy", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobDispatchcallLog.findByLastModIp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByVersion", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.version = :version")
    , @NamedQuery(name = "GlobDispatchcallLog.findByReportKey", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.reportKey = :reportKey")
    , @NamedQuery(name = "GlobDispatchcallLog.findByServiceDateTmp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.serviceDateTmp = :serviceDateTmp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByRequestedDateTmp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.requestedDateTmp = :requestedDateTmp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByLastModTmp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.lastModTmp = :lastModTmp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCreateDateTmp", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.createDateTmp = :createDateTmp")
    , @NamedQuery(name = "GlobDispatchcallLog.findByRequestedDate", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.requestedDate = :requestedDate")
    , @NamedQuery(name = "GlobDispatchcallLog.findByLastMod", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCreateDate", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobDispatchcallLog.findByPaperworkReceived", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.paperworkReceived = :paperworkReceived")
    , @NamedQuery(name = "GlobDispatchcallLog.findByCertBillingCodeId", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.certBillingCodeId = :certBillingCodeId")
    , @NamedQuery(name = "GlobDispatchcallLog.findByAssignment", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.assignment = :assignment")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_DISPATCHCALL_LOG", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobDispatchcallLog.findAll", query = "SELECT g FROM GlobDispatchcallLog g"),
    @NamedQuery(name = "GlobDispatchcallLog.findById", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.id = :id"),
    @NamedQuery(name = "GlobDispatchcallLog.findByRequestOrigID", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.requestOrigId = :requestOrigId"),
    @NamedQuery(name = "GlobDispatchcallLog.findByProjectIDAndNotCancelled", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.projectId = :projectId AND g.cancelled = 'No'"),
    @NamedQuery(name = "GlobDispatchcallLog.findByWOIDAndNotCancelled", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.woId.id = :woId AND g.cancelled = 'No'"),
    @NamedQuery(name = "GlobDispatchcallLog.findByWoId", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.woId.id = :woId"),
    @NamedQuery(name = "GlobDispatchcallLog.findByInfoId", query = "SELECT g FROM GlobDispatchcallLog g WHERE g.infoId = :infoId")})
public class GlobDispatchcallLog implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_DISPATCHCALL_LOG_ID_SEQ", sequenceName = "GLOB_DISPATCHCALL_LOG_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_DISPATCHCALL_LOG_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date serviceDate;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 4000)
    @Column(name = "SERVICES_REQUESTED")
    private String servicesRequested;
    @Size(max = 4000)
    @Column(name = "TIME_SITE")
    private String timeSite;
    @Column(name = "HOURS")
    private BigDecimal hours;
    @Size(max = 4000)
    @Column(name = "TECHNICIAN")
    private String technician;
    //@Column(name = "WO_ID")
    //private BigInteger woId;
    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "WO_ID", referencedColumnName = "ID")
    private GlobWorkorder woId;
    @Size(max = 4000)
    @Column(name = "DEPT")
    private String dept;
    @Size(max = 3)
    @Column(name = "CANCELLED")
    private String cancelled;
    @Size(max = 4000)
    @Column(name = "SPEC_INSTR")
    private String specInstr;
    @Size(max = 4000)
    @Column(name = "REQUESTED_BY")
    private String requestedBy;
    @Size(max = 50)
    @Column(name = "REQUESTED_TIME")
    private String requestedTime;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 4000)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 4000)
    @Column(name = "REPORT_KEY")
    private String reportKey;
    @Size(max = 50)
    @Column(name = "SERVICE_DATE_TMP")
    private String serviceDateTmp;
    @Size(max = 4000)
    @Column(name = "REQUESTED_DATE_TMP")
    private String requestedDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 50)
    @Column(name = "REQUESTED_DATE")
    private String requestedDate;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "PAPERWORK_RECEIVED")
    private Character paperworkReceived;
    @Column(name = "CERT_BILLING_CODE_ID")
    private BigInteger certBillingCodeId;
    @Size(max = 50)
    @Column(name = "ASSIGNMENT")
    private String assignment;
    @Column(name = "INFO_ID")
    private BigInteger infoId;
    @Column(name = "TECHREFID")
    private BigInteger techRefId;
    @Column(name = "DECISIONFLAG")
    private Long decisionFlag;
    @Column(name = "REQUESTORIGID")
    private BigInteger requestOrigId;
    @Size(max = 50)
    @Column(name = "REQLOCATION")
    private String reqLocation;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Size(max = 25)
    @Column(name = "EMAIL_STATUS")
    private String emailStatus;
    @Size(max = 255)
    @Column(name = "EMAIL_REASON")
    private String emailReason;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 1024)
    @Column(name = "CANCELLED_REASON")
    private String cancelledReason;

    public GlobDispatchcallLog() {
    }

    public GlobDispatchcallLog(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public BigInteger getTechRefId() {
        return techRefId;
    }

    public void setTechRefId(BigInteger techRefId) {
        this.techRefId = techRefId;
    }

    public Long getDecisionFlag() {
        return decisionFlag;
    }

    public void setDecisionFlag(Long decisionFlag) {
        this.decisionFlag = decisionFlag;
    }

    public BigInteger getRequestOrigId() {
        return requestOrigId;
    }

    public void setRequestOrigId(BigInteger requestOrigId) {
        this.requestOrigId = requestOrigId;
    }

    public String getReqLocation() {
        return reqLocation;
    }

    public void setReqLocation(String reqLocation) {
        this.reqLocation = reqLocation;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(String servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public String getTimeSite() {
        return timeSite;
    }

    public void setTimeSite(String timeSite) {
        this.timeSite = timeSite;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
    }

    /*public BigInteger getWoId() {
        return woId;
    }

    public void setWoId(BigInteger woId) {
        this.woId = woId;
    }*/
    public GlobWorkorder getWoId() {
        return woId;
    }

    public void setWoId(GlobWorkorder woId) {
        this.woId = woId;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getCancelled() {
        return cancelled;
    }

    public void setCancelled(String cancelled) {
        this.cancelled = cancelled;
    }

    public String getSpecInstr() {
        return specInstr;
    }

    public void setSpecInstr(String specInstr) {
        this.specInstr = specInstr;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(String requestedTime) {
        this.requestedTime = requestedTime;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String reportKey) {
        this.reportKey = reportKey;
    }

    public String getServiceDateTmp() {
        return serviceDateTmp;
    }

    public void setServiceDateTmp(String serviceDateTmp) {
        this.serviceDateTmp = serviceDateTmp;
    }

    public String getRequestedDateTmp() {
        return requestedDateTmp;
    }

    public void setRequestedDateTmp(String requestedDateTmp) {
        this.requestedDateTmp = requestedDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Character getPaperworkReceived() {
        return paperworkReceived;
    }

    public void setPaperworkReceived(Character paperworkReceived) {
        this.paperworkReceived = paperworkReceived;
    }

    public BigInteger getCertBillingCodeId() {
        return certBillingCodeId;
    }

    public void setCertBillingCodeId(BigInteger certBillingCodeId) {
        this.certBillingCodeId = certBillingCodeId;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }

    public BigInteger getInfoId() {
        return infoId;
    }

    public void setInfoId(BigInteger infoId) {
        this.infoId = infoId;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getEmailReason() {
        return emailReason;
    }

    public void setEmailReason(String emailReason) {
        this.emailReason = emailReason;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(String cancelledReason) {
        this.cancelledReason = cancelledReason;
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
        if (!(object instanceof GlobDispatchcallLog)) {
            return false;
        }
        GlobDispatchcallLog other = (GlobDispatchcallLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobDispatchcallLog[ id=" + id + " ]";
    }

    @Override
    public GlobDispatchcallLog clone() {
        try {
            return (GlobDispatchcallLog) super.clone();
        } catch (CloneNotSupportedException e) {
            return new GlobDispatchcallLog(this.getId());
        }
    }
}
