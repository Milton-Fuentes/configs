/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    , @NamedQuery(name = "JobExecution.findByVersion", query = "SELECT j FROM JobExecution j WHERE j.version = :version")
    , @NamedQuery(name = "JobExecution.findByCreatetime", query = "SELECT j FROM JobExecution j WHERE j.createtime = :createtime")
    , @NamedQuery(name = "JobExecution.findByStarttime", query = "SELECT j FROM JobExecution j WHERE j.starttime = :starttime")
    , @NamedQuery(name = "JobExecution.findByEndtime", query = "SELECT j FROM JobExecution j WHERE j.endtime = :endtime")
    , @NamedQuery(name = "JobExecution.findByLastupdatedtime", query = "SELECT j FROM JobExecution j WHERE j.lastupdatedtime = :lastupdatedtime")
    , @NamedQuery(name = "JobExecution.findByBatchstatus", query = "SELECT j FROM JobExecution j WHERE j.batchstatus = :batchstatus")
    , @NamedQuery(name = "JobExecution.findByExitstatus", query = "SELECT j FROM JobExecution j WHERE j.exitstatus = :exitstatus")
    , @NamedQuery(name = "JobExecution.findByJobparameters", query = "SELECT j FROM JobExecution j WHERE j.jobparameters = :jobparameters")
    , @NamedQuery(name = "JobExecution.findByRestartposition", query = "SELECT j FROM JobExecution j WHERE j.restartposition = :restartposition")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "JOB_EXECUTION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobExecution.findAll", query = "SELECT j FROM JobExecution j")
    , @NamedQuery(name = "JobExecution.findByJobexecutionid", query = "SELECT j FROM JobExecution j WHERE j.jobexecutionid = :jobexecutionid")})
public class JobExecution implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOBEXECUTIONID")
    private BigDecimal jobexecutionid;
    @Column(name = "VERSION")
    private BigInteger version;
    @Column(name = "CREATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createtime;
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Column(name = "LASTUPDATEDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdatedtime;
    @Size(max = 30)
    @Column(name = "BATCHSTATUS")
    private String batchstatus;
    @Size(max = 512)
    @Column(name = "EXITSTATUS")
    private String exitstatus;
    @Size(max = 3000)
    @Column(name = "JOBPARAMETERS")
    private String jobparameters;
    @Size(max = 255)
    @Column(name = "RESTARTPOSITION")
    private String restartposition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobexecutionid")
    private List<StepExecution> stepExecutionList;
    @JoinColumn(name = "JOBINSTANCEID", referencedColumnName = "JOBINSTANCEID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private JobInstance jobinstanceid;

    public JobExecution() {
    }

    public JobExecution(BigDecimal jobexecutionid) {
        this.jobexecutionid = jobexecutionid;
    }

    public BigDecimal getJobexecutionid() {
        return jobexecutionid;
    }

    public void setJobexecutionid(BigDecimal jobexecutionid) {
        this.jobexecutionid = jobexecutionid;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserialize.class)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserialize.class)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserialize.class)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserialize.class)
    public Date getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(Date lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getBatchstatus() {
        return batchstatus;
    }

    public void setBatchstatus(String batchstatus) {
        this.batchstatus = batchstatus;
    }

    public String getExitstatus() {
        return exitstatus;
    }

    public void setExitstatus(String exitstatus) {
        this.exitstatus = exitstatus;
    }

    public String getJobparameters() {
        return jobparameters;
    }

    public void setJobparameters(String jobparameters) {
        this.jobparameters = jobparameters;
    }

    public String getRestartposition() {
        return restartposition;
    }

    public void setRestartposition(String restartposition) {
        this.restartposition = restartposition;
    }

    @XmlTransient
    public List<StepExecution> getStepExecutionList() {
        return stepExecutionList;
    }

    public void setStepExecutionList(List<StepExecution> stepExecutionList) {
        this.stepExecutionList = stepExecutionList;
    }

    public JobInstance getJobinstanceid() {
        return jobinstanceid;
    }

    public void setJobinstanceid(JobInstance jobinstanceid) {
        this.jobinstanceid = jobinstanceid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobexecutionid != null ? jobexecutionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobExecution)) {
            return false;
        }
        JobExecution other = (JobExecution) object;
        if ((this.jobexecutionid == null && other.jobexecutionid != null) || (this.jobexecutionid != null && !this.jobexecutionid.equals(other.jobexecutionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.JobExecution[ jobexecutionid=" + jobexecutionid + " ]";
    }

}
