/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "JOB_INSTANCE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JobInstance.findAll", query = "SELECT j FROM JobInstance j")
    , @NamedQuery(name = "JobInstance.findByJobinstanceid", query = "SELECT j FROM JobInstance j WHERE j.jobinstanceid = :jobinstanceid")
    , @NamedQuery(name = "JobInstance.findByVersion", query = "SELECT j FROM JobInstance j WHERE j.version = :version")
    , @NamedQuery(name = "JobInstance.findByJobname", query = "SELECT j FROM JobInstance j WHERE j.jobname = :jobname")
    , @NamedQuery(name = "JobInstance.findByApplicationname", query = "SELECT j FROM JobInstance j WHERE j.applicationname = :applicationname")})
public class JobInstance implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOBINSTANCEID")
    private BigDecimal jobinstanceid;
    @Column(name = "VERSION")
    private BigInteger version;
    @Size(max = 512)
    @Column(name = "JOBNAME")
    private String jobname;
    @Size(max = 512)
    @Column(name = "APPLICATIONNAME")
    private String applicationname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobinstanceid", fetch = FetchType.LAZY)
    private List<JobExecution> jobExecutionList;

    public JobInstance() {
    }

    public JobInstance(BigDecimal jobinstanceid) {
        this.jobinstanceid = jobinstanceid;
    }

    public BigDecimal getJobinstanceid() {
        return jobinstanceid;
    }

    public void setJobinstanceid(BigDecimal jobinstanceid) {
        this.jobinstanceid = jobinstanceid;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getApplicationname() {
        return applicationname;
    }

    public void setApplicationname(String applicationname) {
        this.applicationname = applicationname;
    }

    @XmlTransient
    public List<JobExecution> getJobExecutionList() {
        return jobExecutionList;
    }

    public void setJobExecutionList(List<JobExecution> jobExecutionList) {
        this.jobExecutionList = jobExecutionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobinstanceid != null ? jobinstanceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JobInstance)) {
            return false;
        }
        JobInstance other = (JobInstance) object;
        if ((this.jobinstanceid == null && other.jobinstanceid != null) || (this.jobinstanceid != null && !this.jobinstanceid.equals(other.jobinstanceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.JobInstance[ jobinstanceid=" + jobinstanceid + " ]";
    }
    
}
