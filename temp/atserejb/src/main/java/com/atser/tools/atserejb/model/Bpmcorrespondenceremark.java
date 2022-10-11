/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMCORRESPONDENCEREMARK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpmcorrespondenceremark.findAll", query = "SELECT b FROM Bpmcorrespondenceremark b"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByPersistenceid", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.persistenceid = :persistenceid"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByCreated", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.created = :created"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByPersistenceversion", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.persistenceversion = :persistenceversion"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByRemark", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.remark = :remark"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByReviewerId", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.reviewerId = :reviewerId"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByReviewerName", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.reviewerName = :reviewerName"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByReviewerRole", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.reviewerRole = :reviewerRole"),
    @NamedQuery(name = "Bpmcorrespondenceremark.findByRemarksOrder", query = "SELECT b FROM Bpmcorrespondenceremark b WHERE b.remarksOrder = :remarksOrder")})
public class Bpmcorrespondenceremark implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "BPMCORRESPONDENCEREMARK_SEQ", sequenceName = "BPMCORRESPONDENCEREMARK_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPMCORRESPONDENCEREMARK_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Size(max = 255)
    @Column(name = "CREATED")
    private String created;
    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "REMARK")
    private String remark;
    @Size(max = 255)
    @Column(name = "REVIEWER_ID")
    private String reviewerId;
    @Size(max = 255)
    @Column(name = "REVIEWER_NAME")
    private String reviewerName;
    @Size(max = 255)
    @Column(name = "REVIEWER_ROLE")
    private String reviewerRole;
    @Column(name = "REMARKS_ORDER")
    private Long remarksOrder;
    @JoinColumn(name = "BPMCORRESPONDENCEBO_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne(optional = false)
    private Bpmcorrespondencebo bpmcorrespondenceboPid;
    @JoinColumn(name = "TASK_INSTANCE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private BpmTaskInstance taskInstanceId;

    public Bpmcorrespondenceremark() {
    }

    public Bpmcorrespondenceremark(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public Bpmcorrespondenceremark(BigDecimal persistenceid, String remark) {
        this.persistenceid = persistenceid;
        this.remark = remark;
    }

    public BigDecimal getPersistenceid() {
        return persistenceid;
    }

    public void setPersistenceid(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public BigInteger getPersistenceversion() {
        return persistenceversion;
    }

    public void setPersistenceversion(BigInteger persistenceversion) {
        this.persistenceversion = persistenceversion;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(String reviewerId) {
        this.reviewerId = reviewerId;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getReviewerRole() {
        return reviewerRole;
    }

    public void setReviewerRole(String reviewerRole) {
        this.reviewerRole = reviewerRole;
    }

    public Long getRemarksOrder() {
        return remarksOrder;
    }

    public void setRemarksOrder(Long remarksOrder) {
        this.remarksOrder = remarksOrder;
    }

    public Bpmcorrespondencebo getBpmcorrespondenceboPid() {
        return bpmcorrespondenceboPid;
    }

    public void setBpmcorrespondenceboPid(Bpmcorrespondencebo bpmcorrespondenceboPid) {
        this.bpmcorrespondenceboPid = bpmcorrespondenceboPid;
    }

    public BpmTaskInstance getTaskInstanceId() {
        return taskInstanceId;
    }

    public void setTaskInstanceId(BpmTaskInstance taskInstanceId) {
        this.taskInstanceId = taskInstanceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persistenceid != null ? persistenceid.hashCode() : 0);
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
        final Bpmcorrespondenceremark other = (Bpmcorrespondenceremark) obj;
        if (!Objects.equals(this.remark, other.remark)) {
            return false;
        }
        if (!Objects.equals(this.persistenceid, other.persistenceid)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpmcorrespondenceremark[ persistenceid=" + persistenceid + " ]";
    }

}
