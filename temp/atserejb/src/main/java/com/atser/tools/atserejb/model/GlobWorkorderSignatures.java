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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_WORKORDER_SIGNATURES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobWorkorderSignatures.findAll", query = "SELECT g FROM GlobWorkorderSignatures g")
    , @NamedQuery(name = "GlobWorkorderSignatures.findById", query = "SELECT g FROM GlobWorkorderSignatures g WHERE g.id = :id")
    , @NamedQuery(name = "GlobWorkorderSignatures.findByWorkorderId", query = "SELECT g FROM GlobWorkorderSignatures g WHERE g.workorderId = :workorderId")
    , @NamedQuery(name = "GlobWorkorderSignatures.findByImageTimestamp", query = "SELECT g FROM GlobWorkorderSignatures g WHERE g.imageTimestamp = :imageTimestamp")})
public class GlobWorkorderSignatures implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WORKORDER_ID")
    private BigInteger workorderId;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Lob
    @Column(name = "INSPECTOR_SIG")
    private Serializable inspectorSig;
    @Lob
    @Column(name = "CONTRACTOR_SIG")
    private Serializable contractorSig;

    public GlobWorkorderSignatures() {
    }

    public GlobWorkorderSignatures(BigDecimal id) {
        this.id = id;
    }

    public GlobWorkorderSignatures(BigDecimal id, BigInteger workorderId) {
        this.id = id;
        this.workorderId = workorderId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(BigInteger workorderId) {
        this.workorderId = workorderId;
    }

    public Date getImageTimestamp() {
        return imageTimestamp;
    }

    public void setImageTimestamp(Date imageTimestamp) {
        this.imageTimestamp = imageTimestamp;
    }

    public Serializable getInspectorSig() {
        return inspectorSig;
    }

    public void setInspectorSig(Serializable inspectorSig) {
        this.inspectorSig = inspectorSig;
    }

    public Serializable getContractorSig() {
        return contractorSig;
    }

    public void setContractorSig(Serializable contractorSig) {
        this.contractorSig = contractorSig;
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
        if (!(object instanceof GlobWorkorderSignatures)) {
            return false;
        }
        GlobWorkorderSignatures other = (GlobWorkorderSignatures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobWorkorderSignatures[ id=" + id + " ]";
    }
    
}
