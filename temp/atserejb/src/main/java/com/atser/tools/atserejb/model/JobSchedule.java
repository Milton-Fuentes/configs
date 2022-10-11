/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "JobSchedule.findByJobname", query = "SELECT j FROM JobSchedule j WHERE j.jobname = :jobname"),
    @NamedQuery(name = "JobSchedule.findByHasdelay", query = "SELECT j FROM JobSchedule j WHERE j.hasdelay = :hasdelay"),
    @NamedQuery(name = "JobSchedule.findByTargethour", query = "SELECT j FROM JobSchedule j WHERE j.targethour = :targethour"),
    @NamedQuery(name = "JobSchedule.findByTargetmin", query = "SELECT j FROM JobSchedule j WHERE j.targetmin = :targetmin"),
    @NamedQuery(name = "JobSchedule.findByTargetsec", query = "SELECT j FROM JobSchedule j WHERE j.targetsec = :targetsec"),
    @NamedQuery(name = "JobSchedule.findByPeriod", query = "SELECT j FROM JobSchedule j WHERE j.period = :period"),
    @NamedQuery(name = "JobSchedule.findByActive", query = "SELECT j FROM JobSchedule j WHERE j.active = :active"),
    @NamedQuery(name = "JobSchedule.findByDeleted", query = "SELECT j FROM JobSchedule j WHERE j.deleted = :deleted")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "JOB_SCHEDULE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE JOB_SCHEDULE SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobSchedule.findAll", query = "SELECT j FROM JobSchedule j"),
    @NamedQuery(name = "JobSchedule.findById", query = "SELECT j FROM JobSchedule j WHERE j.id = :id")})
public class JobSchedule implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "JOB_SCHEDULE_SEQ", sequenceName = "JOB_SCHEDULE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "JOB_SCHEDULE_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "JOBNAME")
    private String jobname;
    @JsonSkipXssSerialization
    @JsonRawValue
    @Lob
    @Column(name = "JOBPARAMS")
    private String jobparams;
    @Size(max = 20)
    @Column(name = "HASDELAY")
    private String hasdelay;
    @Column(name = "TARGETHOUR")
    private BigInteger targethour;
    @Column(name = "TARGETMIN")
    private BigInteger targetmin;
    @Column(name = "TARGETSEC")
    private BigInteger targetsec;
    @Column(name = "PERIOD")
    private BigInteger period;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 150)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 20)
    @Column(name = "ACTIVE")
    private String active;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;

    public JobSchedule() {
    }

    public JobSchedule(BigDecimal id) {
        this.id = id;
    }

    public JobSchedule(BigDecimal id, String jobname) {
        this.id = id;
        this.jobname = jobname;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getHasdelay() {
        return hasdelay;
    }

    public void setHasdelay(String hasdelay) {
        this.hasdelay = hasdelay;
    }

    public BigInteger getTargethour() {
        return targethour;
    }

    public void setTargethour(BigInteger targethour) {
        this.targethour = targethour;
    }

    public BigInteger getTargetmin() {
        return targetmin;
    }

    public void setTargetmin(BigInteger targetmin) {
        this.targetmin = targetmin;
    }

    public BigInteger getTargetsec() {
        return targetsec;
    }

    public void setTargetsec(BigInteger targetsec) {
        this.targetsec = targetsec;
    }

    public BigInteger getPeriod() {
        return period;
    }

    public void setPeriod(BigInteger period) {
        this.period = period;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getJobparams() {
        return jobparams;
    }

    public void setJobparams(String jobparams) {
        this.jobparams = jobparams;
    }
    
    public Long getJobDelay() {
        if (getHasdelay() != null && getHasdelay().toLowerCase().equals("y")) {
            return DateSupport.getFromNowDiffSeconds(getTargethour().intValue(), getTargetmin().intValue(), getTargetsec().intValue());
        }
        return 0L;
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
        if (!(object instanceof JobSchedule)) {
            return false;
        }
        JobSchedule other = (JobSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.JobSchedule[ id=" + id + " ]";
    }

}
