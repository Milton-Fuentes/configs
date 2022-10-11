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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    , @NamedQuery(name = "StepExecution.findByVersion", query = "SELECT s FROM StepExecution s WHERE s.version = :version")
    , @NamedQuery(name = "StepExecution.findByStepname", query = "SELECT s FROM StepExecution s WHERE s.stepname = :stepname")
    , @NamedQuery(name = "StepExecution.findByStarttime", query = "SELECT s FROM StepExecution s WHERE s.starttime = :starttime")
    , @NamedQuery(name = "StepExecution.findByEndtime", query = "SELECT s FROM StepExecution s WHERE s.endtime = :endtime")
    , @NamedQuery(name = "StepExecution.findByBatchstatus", query = "SELECT s FROM StepExecution s WHERE s.batchstatus = :batchstatus")
    , @NamedQuery(name = "StepExecution.findByExitstatus", query = "SELECT s FROM StepExecution s WHERE s.exitstatus = :exitstatus")
    , @NamedQuery(name = "StepExecution.findByExecutionexception", query = "SELECT s FROM StepExecution s WHERE s.executionexception = :executionexception")
    , @NamedQuery(name = "StepExecution.findByReadcount", query = "SELECT s FROM StepExecution s WHERE s.readcount = :readcount")
    , @NamedQuery(name = "StepExecution.findByWritecount", query = "SELECT s FROM StepExecution s WHERE s.writecount = :writecount")
    , @NamedQuery(name = "StepExecution.findByCommitcount", query = "SELECT s FROM StepExecution s WHERE s.commitcount = :commitcount")
    , @NamedQuery(name = "StepExecution.findByRollbackcount", query = "SELECT s FROM StepExecution s WHERE s.rollbackcount = :rollbackcount")
    , @NamedQuery(name = "StepExecution.findByReadskipcount", query = "SELECT s FROM StepExecution s WHERE s.readskipcount = :readskipcount")
    , @NamedQuery(name = "StepExecution.findByProcessskipcount", query = "SELECT s FROM StepExecution s WHERE s.processskipcount = :processskipcount")
    , @NamedQuery(name = "StepExecution.findByFiltercount", query = "SELECT s FROM StepExecution s WHERE s.filtercount = :filtercount")
    , @NamedQuery(name = "StepExecution.findByWriteskipcount", query = "SELECT s FROM StepExecution s WHERE s.writeskipcount = :writeskipcount")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "STEP_EXECUTION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StepExecution.findAll", query = "SELECT s FROM StepExecution s"),
    @NamedQuery(name = "StepExecution.findByStepexecutionid", query = "SELECT s FROM StepExecution s WHERE s.stepexecutionid = :stepexecutionid")})
public class StepExecution implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPEXECUTIONID")
    private BigDecimal stepexecutionid;
    @Column(name = "VERSION")
    private BigInteger version;
    @Size(max = 255)
    @Column(name = "STEPNAME")
    private String stepname;
    @Column(name = "STARTTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date starttime;
    @Column(name = "ENDTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endtime;
    @Size(max = 30)
    @Column(name = "BATCHSTATUS")
    private String batchstatus;
    @Size(max = 512)
    @Column(name = "EXITSTATUS")
    private String exitstatus;
    @Size(max = 2048)
    @Column(name = "EXECUTIONEXCEPTION")
    private String executionexception;
    @Lob
    @Column(name = "PERSISTENTUSERDATA")
    private String persistentuserdata;
    @Column(name = "READCOUNT")
    private BigInteger readcount;
    @Column(name = "WRITECOUNT")
    private BigInteger writecount;
    @Column(name = "COMMITCOUNT")
    private BigInteger commitcount;
    @Column(name = "ROLLBACKCOUNT")
    private BigInteger rollbackcount;
    @Column(name = "READSKIPCOUNT")
    private BigInteger readskipcount;
    @Column(name = "PROCESSSKIPCOUNT")
    private BigInteger processskipcount;
    @Column(name = "FILTERCOUNT")
    private BigInteger filtercount;
    @Column(name = "WRITESKIPCOUNT")
    private BigInteger writeskipcount;
    @Lob
    @Column(name = "READERCHECKPOINTINFO")
    private String readercheckpointinfo;
    @Lob
    @Column(name = "WRITERCHECKPOINTINFO")
    private String writercheckpointinfo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stepExecution")
    private List<PartitionExecution> partitionExecutionList;
    @JoinColumn(name = "JOBEXECUTIONID", referencedColumnName = "JOBEXECUTIONID")
    @ManyToOne(optional = false)
    private JobExecution jobexecutionid;

    public StepExecution() {
    }

    public StepExecution(BigDecimal stepexecutionid) {
        this.stepexecutionid = stepexecutionid;
    }

    public BigDecimal getStepexecutionid() {
        return stepexecutionid;
    }

    public void setStepexecutionid(BigDecimal stepexecutionid) {
        this.stepexecutionid = stepexecutionid;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public String getStepname() {
        return stepname;
    }

    public void setStepname(String stepname) {
        this.stepname = stepname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
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

    public String getExecutionexception() {
        return executionexception;
    }

    public void setExecutionexception(String executionexception) {
        this.executionexception = executionexception;
    }

    public String getPersistentuserdata() {
        return persistentuserdata;
    }

    public void setPersistentuserdata(String persistentuserdata) {
        this.persistentuserdata = persistentuserdata;
    }

    public BigInteger getReadcount() {
        return readcount;
    }

    public void setReadcount(BigInteger readcount) {
        this.readcount = readcount;
    }

    public BigInteger getWritecount() {
        return writecount;
    }

    public void setWritecount(BigInteger writecount) {
        this.writecount = writecount;
    }

    public BigInteger getCommitcount() {
        return commitcount;
    }

    public void setCommitcount(BigInteger commitcount) {
        this.commitcount = commitcount;
    }

    public BigInteger getRollbackcount() {
        return rollbackcount;
    }

    public void setRollbackcount(BigInteger rollbackcount) {
        this.rollbackcount = rollbackcount;
    }

    public BigInteger getReadskipcount() {
        return readskipcount;
    }

    public void setReadskipcount(BigInteger readskipcount) {
        this.readskipcount = readskipcount;
    }

    public BigInteger getProcessskipcount() {
        return processskipcount;
    }

    public void setProcessskipcount(BigInteger processskipcount) {
        this.processskipcount = processskipcount;
    }

    public BigInteger getFiltercount() {
        return filtercount;
    }

    public void setFiltercount(BigInteger filtercount) {
        this.filtercount = filtercount;
    }

    public BigInteger getWriteskipcount() {
        return writeskipcount;
    }

    public void setWriteskipcount(BigInteger writeskipcount) {
        this.writeskipcount = writeskipcount;
    }

    public Serializable getReadercheckpointinfo() {
        return readercheckpointinfo;
    }

    public void setReadercheckpointinfo(String readercheckpointinfo) {
        this.readercheckpointinfo = readercheckpointinfo;
    }

    public String getWritercheckpointinfo() {
        return writercheckpointinfo;
    }

    public void setWritercheckpointinfo(String writercheckpointinfo) {
        this.writercheckpointinfo = writercheckpointinfo;
    }

    @XmlTransient
    public List<PartitionExecution> getPartitionExecutionList() {
        return partitionExecutionList;
    }

    public void setPartitionExecutionList(List<PartitionExecution> partitionExecutionList) {
        this.partitionExecutionList = partitionExecutionList;
    }

    public JobExecution getJobexecutionid() {
        return jobexecutionid;
    }

    public void setJobexecutionid(JobExecution jobexecutionid) {
        this.jobexecutionid = jobexecutionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepexecutionid != null ? stepexecutionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StepExecution)) {
            return false;
        }
        StepExecution other = (StepExecution) object;
        if ((this.stepexecutionid == null && other.stepexecutionid != null) || (this.stepexecutionid != null && !this.stepexecutionid.equals(other.stepexecutionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.StepExecution[ stepexecutionid=" + stepexecutionid + " ]";
    }

}
