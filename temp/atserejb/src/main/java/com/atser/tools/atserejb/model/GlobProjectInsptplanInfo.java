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
@NamedQuery(name = "GlobProjectInsptplanInfo.findByProjectId", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByPlanName", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.planName = :planName"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByStartDate", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.startDate = :startDate"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByDuration", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.duration = :duration"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByPlanInterval", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.planInterval = :planInterval"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByCreateBy", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.createBy = :createBy"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByCreateByIp", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.createByIp = :createByIp"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByLastModBy", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByLastMod", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByLastModIp", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByVersion", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.version = :version"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findByLabId", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.labId = :labId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_INSPTPLAN_INFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectInsptplanInfo.findAll", query = "SELECT g FROM GlobProjectInsptplanInfo g"),
    @NamedQuery(name = "GlobProjectInsptplanInfo.findById", query = "SELECT g FROM GlobProjectInsptplanInfo g WHERE g.id = :id")})
public class GlobProjectInsptplanInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false, precision = 38, scale = 0)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID", nullable = false)
    private BigInteger projectId;
    @Size(max = 200)
    @Column(name = "PLAN_NAME", length = 200)
    private String planName;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "DURATION")
    private BigInteger duration;
    @Column(name = "PLAN_INTERVAL")
    private BigInteger planInterval;
    @Size(max = 100)
    @Column(name = "CREATE_BY", length = 100)
    private String createBy;
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP", length = 30)
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY", length = 100)
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD", length = 20)
    private String lastMod;
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP", length = 30)
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", length = 20)
    private String version;
    @Column(name = "LAB_ID")
    private BigInteger labId;

    public GlobProjectInsptplanInfo() {
    }

    public GlobProjectInsptplanInfo(BigDecimal id) {
        this.id = id;
    }

    public GlobProjectInsptplanInfo(BigDecimal id, BigInteger projectId) {
        this.id = id;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public BigInteger getDuration() {
        return duration;
    }

    public void setDuration(BigInteger duration) {
        this.duration = duration;
    }

    public BigInteger getPlanInterval() {
        return planInterval;
    }

    public void setPlanInterval(BigInteger planInterval) {
        this.planInterval = planInterval;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
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
        if (!(object instanceof GlobProjectInsptplanInfo)) {
            return false;
        }
        GlobProjectInsptplanInfo other = (GlobProjectInsptplanInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectInsptplanInfo[ id=" + id + " ]";
    }
    
}
