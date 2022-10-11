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

/*
, @NamedQuery(name = "CmChangerequestTask.findByName", query = "SELECT c FROM CmChangerequestTask c WHERE c.name = :name")
    , @NamedQuery(name = "CmChangerequestTask.findByDescription", query = "SELECT c FROM CmChangerequestTask c WHERE c.description = :description")
    , @NamedQuery(name = "CmChangerequestTask.findByTime", query = "SELECT c FROM CmChangerequestTask c WHERE c.time = :time")
    , @NamedQuery(name = "CmChangerequestTask.findByCost", query = "SELECT c FROM CmChangerequestTask c WHERE c.cost = :cost")
    , @NamedQuery(name = "CmChangerequestTask.findByPriority", query = "SELECT c FROM CmChangerequestTask c WHERE c.priority = :priority")
    , @NamedQuery(name = "CmChangerequestTask.findByStatus", query = "SELECT c FROM CmChangerequestTask c WHERE c.status = :status")
    , @NamedQuery(name = "CmChangerequestTask.findByApprovedBy", query = "SELECT c FROM CmChangerequestTask c WHERE c.approvedBy = :approvedBy")
    , @NamedQuery(name = "CmChangerequestTask.findByApprovedDate", query = "SELECT c FROM CmChangerequestTask c WHERE c.approvedDate = :approvedDate")
    , @NamedQuery(name = "CmChangerequestTask.findByTimer", query = "SELECT c FROM CmChangerequestTask c WHERE c.timer = :timer")
    , @NamedQuery(name = "CmChangerequestTask.findByReleasedtotestDate", query = "SELECT c FROM CmChangerequestTask c WHERE c.releasedtotestDate = :releasedtotestDate")
    , @NamedQuery(name = "CmChangerequestTask.findByReleasedtoprodDate", query = "SELECT c FROM CmChangerequestTask c WHERE c.releasedtoprodDate = :releasedtoprodDate")
    , @NamedQuery(name = "CmChangerequestTask.findByInternalStatus", query = "SELECT c FROM CmChangerequestTask c WHERE c.internalStatus = :internalStatus")
    , @NamedQuery(name = "CmChangerequestTask.findByRejectreason", query = "SELECT c FROM CmChangerequestTask c WHERE c.rejectreason = :rejectreason")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_CHANGEREQUEST_TASK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmChangerequestTask.findAll", query = "SELECT c FROM CmChangerequestTask c")
    , @NamedQuery(name = "CmChangerequestTask.findById", query = "SELECT c FROM CmChangerequestTask c WHERE c.id = :id")})
public class CmChangerequestTask implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 150)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "TIME")
    private BigInteger time;
    @Column(name = "COST")
    private BigDecimal cost;
    @Size(max = 50)
    @Column(name = "PRIORITY")
    private String priority;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "APPROVED_BY")
    private BigInteger approvedBy;
    @Size(max = 20)
    @Column(name = "APPROVED_DATE")
    private String approvedDate;
    @Column(name = "TIMER")
    private BigInteger timer;
    @Column(name = "RELEASEDTOTEST_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedtotestDate;
    @Column(name = "RELEASEDTOPROD_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date releasedtoprodDate;
    @Size(max = 50)
    @Column(name = "INTERNAL_STATUS")
    private String internalStatus;
    @Size(max = 512)
    @Column(name = "REJECTREASON")
    private String rejectreason;
    @JoinColumn(name = "CRID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private CmChangerequest crid;

    public CmChangerequestTask() {
    }

    public CmChangerequestTask(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getTime() {
        return time;
    }

    public void setTime(BigInteger time) {
        this.time = time;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigInteger getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(BigInteger approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public BigInteger getTimer() {
        return timer;
    }

    public void setTimer(BigInteger timer) {
        this.timer = timer;
    }

    public Date getReleasedtotestDate() {
        return releasedtotestDate;
    }

    public void setReleasedtotestDate(Date releasedtotestDate) {
        this.releasedtotestDate = releasedtotestDate;
    }

    public Date getReleasedtoprodDate() {
        return releasedtoprodDate;
    }

    public void setReleasedtoprodDate(Date releasedtoprodDate) {
        this.releasedtoprodDate = releasedtoprodDate;
    }

    public String getInternalStatus() {
        return internalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }

    public String getRejectreason() {
        return rejectreason;
    }

    public void setRejectreason(String rejectreason) {
        this.rejectreason = rejectreason;
    }

    public CmChangerequest getCrid() {
        return crid;
    }

    public void setCrid(CmChangerequest crid) {
        this.crid = crid;
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
        if (!(object instanceof CmChangerequestTask)) {
            return false;
        }
        CmChangerequestTask other = (CmChangerequestTask) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmChangerequestTask[ id=" + id + " ]";
    }
    
}
