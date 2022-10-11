/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "GlobCostmgmtLog.findByClientId", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobCostmgmtLog.findByProgramId", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.programId = :programId"),
    @NamedQuery(name = "GlobCostmgmtLog.findByProjectId", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobCostmgmtLog.findBySpattern", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.spattern = :spattern"),
    @NamedQuery(name = "GlobCostmgmtLog.findBySno", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobCostmgmtLog.findByCmpcn", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.cmpcn = :cmpcn"),
    @NamedQuery(name = "GlobCostmgmtLog.findByReqNo", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.reqNo = :reqNo"),
    @NamedQuery(name = "GlobCostmgmtLog.findByWorkPackage", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.workPackage = :workPackage"),
    @NamedQuery(name = "GlobCostmgmtLog.findByApprovedControlBudget", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.approvedControlBudget = :approvedControlBudget"),
    @NamedQuery(name = "GlobCostmgmtLog.findByPlanedValue", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.planedValue = :planedValue"),
    @NamedQuery(name = "GlobCostmgmtLog.findByForecastFinalCost", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.forecastFinalCost = :forecastFinalCost"),
    @NamedQuery(name = "GlobCostmgmtLog.findByCommittedCost", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.committedCost = :committedCost"),
    @NamedQuery(name = "GlobCostmgmtLog.findByEarned", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.earned = :earned"),
    @NamedQuery(name = "GlobCostmgmtLog.findByActualCost", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.actualCost = :actualCost"),
    @NamedQuery(name = "GlobCostmgmtLog.findByInvoiced", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.invoiced = :invoiced"),
    @NamedQuery(name = "GlobCostmgmtLog.findByPaid", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.paid = :paid"),
    @NamedQuery(name = "GlobCostmgmtLog.findByRemaining", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.remaining = :remaining"),
    @NamedQuery(name = "GlobCostmgmtLog.findByRemark", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.remark = :remark"),
    @NamedQuery(name = "GlobCostmgmtLog.findByFolderId", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobCostmgmtLog.findByCreated", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.created = :created"),
    @NamedQuery(name = "GlobCostmgmtLog.findByCreatedBy", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobCostmgmtLog.findByCreatedByIp", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobCostmgmtLog.findByLastMod", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobCostmgmtLog.findByLastModIp", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobCostmgmtLog.findByLastModBy", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobCostmgmtLog.findByDeleted", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobCostmgmtLog.findByActive", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.active = :active"),
    @NamedQuery(name = "GlobCostmgmtLog.findByVersion", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_COSTMGMT_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_COSTMGMT_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCostmgmtLog.findAll", query = "SELECT g FROM GlobCostmgmtLog g"),
    @NamedQuery(name = "GlobCostmgmtLog.findById", query = "SELECT g FROM GlobCostmgmtLog g WHERE g.id = :id")})
public class GlobCostmgmtLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_COSTMGMT_LOG_SEQ", sequenceName = "GLOB_COSTMGMT_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_COSTMGMT_LOG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Transient
    private String programFullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN")
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "CMPCN")
    private String cmpcn;
    @Size(max = 150)
    @Column(name = "REQ_NO")
    private String reqNo;
    @Size(max = 1024)
    @Column(name = "WORK_PACKAGE")
    private String workPackage;
    @Column(name = "APPROVED_CONTROL_BUDGET")
    private BigDecimal approvedControlBudget;
    @Column(name = "PLANED_VALUE")
    private BigDecimal planedValue;
    @Column(name = "FORECAST_FINAL_COST")
    private BigDecimal forecastFinalCost;
    @Column(name = "COMMITTED_COST")
    private BigDecimal committedCost;
    @Column(name = "EARNED")
    private BigDecimal earned;
    @Column(name = "ACTUAL_COST")
    private BigDecimal actualCost;
    @Column(name = "INVOICED")
    private BigDecimal invoiced;
    @Column(name = "PAID")
    private BigDecimal paid;
    @Column(name = "REMAINING")
    private BigDecimal remaining;
    @Size(max = 1024)
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public GlobCostmgmtLog() {
    }

    public GlobCostmgmtLog(BigDecimal id) {
        this.id = id;
    }

    public GlobCostmgmtLog(BigDecimal id, BigInteger clientId, BigInteger programId, BigInteger projectId) {
        this.id = id;
        this.clientId = clientId;
        this.programId = programId;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    @JsonGetter(value = "programFullName")
    public String getProgramFullName() {
        return programFullName;
    }

    public void setProgramFullName(String programFullName) {
        this.programFullName = programFullName;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
    }

    public String getSpattern() {
        return spattern;
    }

    public void setSpattern(String spattern) {
        this.spattern = spattern;
    }

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
    }

    public String getCmpcn() {
        return cmpcn;
    }

    public void setCmpcn(String cmpcn) {
        this.cmpcn = cmpcn;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getWorkPackage() {
        return workPackage;
    }

    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    public BigDecimal getApprovedControlBudget() {
        return approvedControlBudget;
    }

    public void setApprovedControlBudget(BigDecimal approvedControlBudget) {
        this.approvedControlBudget = approvedControlBudget;
    }

    public BigDecimal getPlanedValue() {
        return planedValue;
    }

    public void setPlanedValue(BigDecimal planedValue) {
        this.planedValue = planedValue;
    }

    public BigDecimal getForecastFinalCost() {
        return forecastFinalCost;
    }

    public void setForecastFinalCost(BigDecimal forecastFinalCost) {
        this.forecastFinalCost = forecastFinalCost;
    }

    public BigDecimal getCommittedCost() {
        return committedCost;
    }

    public void setCommittedCost(BigDecimal committedCost) {
        this.committedCost = committedCost;
    }

    public BigDecimal getEarned() {
        return earned;
    }

    public void setEarned(BigDecimal earned) {
        this.earned = earned;
    }

    public BigDecimal getActualCost() {
        return actualCost;
    }

    public void setActualCost(BigDecimal actualCost) {
        this.actualCost = actualCost;
    }

    public BigDecimal getInvoiced() {
        return invoiced;
    }

    public void setInvoiced(BigDecimal invoiced) {
        this.invoiced = invoiced;
    }

    public BigDecimal getPaid() {
        return paid;
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.workPackage);
        hash = 29 * hash + Objects.hashCode(this.approvedControlBudget);
        hash = 29 * hash + Objects.hashCode(this.planedValue);
        hash = 29 * hash + Objects.hashCode(this.forecastFinalCost);
        hash = 29 * hash + Objects.hashCode(this.committedCost);
        hash = 29 * hash + Objects.hashCode(this.earned);
        hash = 29 * hash + Objects.hashCode(this.actualCost);
        hash = 29 * hash + Objects.hashCode(this.invoiced);
        hash = 29 * hash + Objects.hashCode(this.paid);
        hash = 29 * hash + Objects.hashCode(this.remaining);
        hash = 29 * hash + Objects.hashCode(this.remark);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GlobCostmgmtLog other = (GlobCostmgmtLog) obj;
        if (!Objects.equals(this.workPackage, other.workPackage)) {
            return false;
        }
        if (!Objects.equals(this.remark, other.remark)) {
            return false;
        }
        if (!Objects.equals(this.approvedControlBudget, other.approvedControlBudget)) {
            return false;
        }
        if (!Objects.equals(this.planedValue, other.planedValue)) {
            return false;
        }
        if (!Objects.equals(this.forecastFinalCost, other.forecastFinalCost)) {
            return false;
        }
        if (!Objects.equals(this.committedCost, other.committedCost)) {
            return false;
        }
        if (!Objects.equals(this.earned, other.earned)) {
            return false;
        }
        if (!Objects.equals(this.actualCost, other.actualCost)) {
            return false;
        }
        if (!Objects.equals(this.invoiced, other.invoiced)) {
            return false;
        }
        if (!Objects.equals(this.paid, other.paid)) {
            return false;
        }
        if (!Objects.equals(this.remaining, other.remaining)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCostmgmtLog[ id=" + id + " ]";
    }
    
}
