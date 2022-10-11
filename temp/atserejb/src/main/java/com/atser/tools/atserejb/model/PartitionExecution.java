/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "PARTITION_EXECUTION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartitionExecution.findAll", query = "SELECT p FROM PartitionExecution p")
    , @NamedQuery(name = "PartitionExecution.findByPartitionexecutionid", query = "SELECT p FROM PartitionExecution p WHERE p.partitionExecutionPK.partitionexecutionid = :partitionexecutionid")
    , @NamedQuery(name = "PartitionExecution.findByStepexecutionid", query = "SELECT p FROM PartitionExecution p WHERE p.partitionExecutionPK.stepexecutionid = :stepexecutionid")
    , @NamedQuery(name = "PartitionExecution.findByVersion", query = "SELECT p FROM PartitionExecution p WHERE p.version = :version")
    , @NamedQuery(name = "PartitionExecution.findByBatchstatus", query = "SELECT p FROM PartitionExecution p WHERE p.batchstatus = :batchstatus")
    , @NamedQuery(name = "PartitionExecution.findByExitstatus", query = "SELECT p FROM PartitionExecution p WHERE p.exitstatus = :exitstatus")
    , @NamedQuery(name = "PartitionExecution.findByExecutionexception", query = "SELECT p FROM PartitionExecution p WHERE p.executionexception = :executionexception")})
public class PartitionExecution implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PartitionExecutionPK partitionExecutionPK;
    @Column(name = "VERSION")
    private BigInteger version;
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
    @Lob
    @Column(name = "READERCHECKPOINTINFO")
    private String readercheckpointinfo;
    @Lob
    @Column(name = "WRITERCHECKPOINTINFO")
    private String writercheckpointinfo;
    @JoinColumn(name = "STEPEXECUTIONID", referencedColumnName = "STEPEXECUTIONID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StepExecution stepExecution;

    public PartitionExecution() {
    }

    public PartitionExecution(PartitionExecutionPK partitionExecutionPK) {
        this.partitionExecutionPK = partitionExecutionPK;
    }

    public PartitionExecution(BigInteger partitionexecutionid, BigInteger stepexecutionid) {
        this.partitionExecutionPK = new PartitionExecutionPK(partitionexecutionid, stepexecutionid);
    }

    public PartitionExecutionPK getPartitionExecutionPK() {
        return partitionExecutionPK;
    }

    public void setPartitionExecutionPK(PartitionExecutionPK partitionExecutionPK) {
        this.partitionExecutionPK = partitionExecutionPK;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
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

    public Serializable getPersistentuserdata() {
        return persistentuserdata;
    }

    public void setPersistentuserdata(String persistentuserdata) {
        this.persistentuserdata = persistentuserdata;
    }

    public String getReadercheckpointinfo() {
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

    public StepExecution getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partitionExecutionPK != null ? partitionExecutionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartitionExecution)) {
            return false;
        }
        PartitionExecution other = (PartitionExecution) object;
        if ((this.partitionExecutionPK == null && other.partitionExecutionPK != null) || (this.partitionExecutionPK != null && !this.partitionExecutionPK.equals(other.partitionExecutionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.PartitionExecution[ partitionExecutionPK=" + partitionExecutionPK + " ]";
    }
    
}
