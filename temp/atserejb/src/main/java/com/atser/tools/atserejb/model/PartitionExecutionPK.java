/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author droldan
 */
@Embeddable
public class PartitionExecutionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PARTITIONEXECUTIONID")
    private BigInteger partitionexecutionid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STEPEXECUTIONID")
    private BigInteger stepexecutionid;

    public PartitionExecutionPK() {
    }

    public PartitionExecutionPK(BigInteger partitionexecutionid, BigInteger stepexecutionid) {
        this.partitionexecutionid = partitionexecutionid;
        this.stepexecutionid = stepexecutionid;
    }

    public BigInteger getPartitionexecutionid() {
        return partitionexecutionid;
    }

    public void setPartitionexecutionid(BigInteger partitionexecutionid) {
        this.partitionexecutionid = partitionexecutionid;
    }

    public BigInteger getStepexecutionid() {
        return stepexecutionid;
    }

    public void setStepexecutionid(BigInteger stepexecutionid) {
        this.stepexecutionid = stepexecutionid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partitionexecutionid != null ? partitionexecutionid.hashCode() : 0);
        hash += (stepexecutionid != null ? stepexecutionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartitionExecutionPK)) {
            return false;
        }
        PartitionExecutionPK other = (PartitionExecutionPK) object;
        if ((this.partitionexecutionid == null && other.partitionexecutionid != null) || (this.partitionexecutionid != null && !this.partitionexecutionid.equals(other.partitionexecutionid))) {
            return false;
        }
        if ((this.stepexecutionid == null && other.stepexecutionid != null) || (this.stepexecutionid != null && !this.stepexecutionid.equals(other.stepexecutionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.PartitionExecutionPK[ partitionexecutionid=" + partitionexecutionid + ", stepexecutionid=" + stepexecutionid + " ]";
    }
    
}
