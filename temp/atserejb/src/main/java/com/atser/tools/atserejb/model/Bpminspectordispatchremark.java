/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "BPMINSPECTORDISPATCHREMARK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bpminspectordispatchremark.findAll", query = "SELECT b FROM Bpminspectordispatchremark b")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByPersistenceid", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.persistenceid = :persistenceid")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByCreated", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.created = :created")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByPersistenceversion", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.persistenceversion = :persistenceversion")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByReviewerId", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.reviewerId = :reviewerId")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByReviewerName", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.reviewerName = :reviewerName")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByReviewerRole", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.reviewerRole = :reviewerRole")
    , @NamedQuery(name = "Bpminspectordispatchremark.findByRemarksOrder", query = "SELECT b FROM Bpminspectordispatchremark b WHERE b.remarksOrder = :remarksOrder")})
public class Bpminspectordispatchremark implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSISTENCEID")
    private BigDecimal persistenceid;
    @Size(max = 255)
    @Column(name = "CREATED")
    private String created;
    @Column(name = "PERSISTENCEVERSION")
    private BigInteger persistenceversion;
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
    @JoinColumn(name = "BPMINSPECTORDISPATCHBO_PID", referencedColumnName = "PERSISTENCEID")
    @ManyToOne(optional = false)
    private Bpminspectordispatchbo bpminspectordispatchboPid;

    public Bpminspectordispatchremark() {
    }

    public Bpminspectordispatchremark(BigDecimal persistenceid) {
        this.persistenceid = persistenceid;
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

    public Bpminspectordispatchbo getBpminspectordispatchboPid() {
        return bpminspectordispatchboPid;
    }

    public void setBpminspectordispatchboPid(Bpminspectordispatchbo bpminspectordispatchboPid) {
        this.bpminspectordispatchboPid = bpminspectordispatchboPid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persistenceid != null ? persistenceid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bpminspectordispatchremark)) {
            return false;
        }
        Bpminspectordispatchremark other = (Bpminspectordispatchremark) object;
        if ((this.persistenceid == null && other.persistenceid != null) || (this.persistenceid != null && !this.persistenceid.equals(other.persistenceid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.Bpminspectordispatchremark[ persistenceid=" + persistenceid + " ]";
    }
    
}
