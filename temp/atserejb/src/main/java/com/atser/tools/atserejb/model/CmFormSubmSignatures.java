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

/*
@NamedQuery(name = "CmFormSubmSignatures.findBySubmId", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.submId = :submId"),
    @NamedQuery(name = "CmFormSubmSignatures.findByImageTimestamp", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.imageTimestamp = :imageTimestamp"),
    @NamedQuery(name = "CmFormSubmSignatures.findByContractorSigId", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.contractorSigId = :contractorSigId"),
    @NamedQuery(name = "CmFormSubmSignatures.findByContractorSigDate", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.contractorSigDate = :contractorSigDate"),
    @NamedQuery(name = "CmFormSubmSignatures.findByResengConsultSigId", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.resengConsultSigId = :resengConsultSigId"),
    @NamedQuery(name = "CmFormSubmSignatures.findByResengConsultSigDate", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.resengConsultSigDate = :resengConsultSigDate"),
    @NamedQuery(name = "CmFormSubmSignatures.findByEngSigId", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.engSigId = :engSigId"),
    @NamedQuery(name = "CmFormSubmSignatures.findByEngSigDate", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.engSigDate = :engSigDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_SUBM_SIGNATURES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormSubmSignatures.findAll", query = "SELECT c FROM CmFormSubmSignatures c"),
    @NamedQuery(name = "CmFormSubmSignatures.findById", query = "SELECT c FROM CmFormSubmSignatures c WHERE c.id = :id")})
public class CmFormSubmSignatures implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SUBM_ID")
    private BigInteger submId;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Lob
    @Column(name = "CONTRACTOR_SIG")
    private Serializable contractorSig;
    @Column(name = "CONTRACTOR_SIG_ID")
    private BigInteger contractorSigId;
    @Column(name = "CONTRACTOR_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractorSigDate;
    @Lob
    @Column(name = "RESENG_CONSULT_SIG")
    private Serializable resengConsultSig;
    @Column(name = "RESENG_CONSULT_SIG_ID")
    private BigInteger resengConsultSigId;
    @Column(name = "RESENG_CONSULT_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resengConsultSigDate;
    @Lob
    @Column(name = "ENG_SIG")
    private Serializable engSig;
    @Column(name = "ENG_SIG_ID")
    private BigInteger engSigId;
    @Column(name = "ENG_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date engSigDate;

    public CmFormSubmSignatures() {
    }

    public CmFormSubmSignatures(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSubmId() {
        return submId;
    }

    public void setSubmId(BigInteger submId) {
        this.submId = submId;
    }

    public Date getImageTimestamp() {
        return imageTimestamp;
    }

    public void setImageTimestamp(Date imageTimestamp) {
        this.imageTimestamp = imageTimestamp;
    }

    public Serializable getContractorSig() {
        return contractorSig;
    }

    public void setContractorSig(Serializable contractorSig) {
        this.contractorSig = contractorSig;
    }

    public BigInteger getContractorSigId() {
        return contractorSigId;
    }

    public void setContractorSigId(BigInteger contractorSigId) {
        this.contractorSigId = contractorSigId;
    }

    public Date getContractorSigDate() {
        return contractorSigDate;
    }

    public void setContractorSigDate(Date contractorSigDate) {
        this.contractorSigDate = contractorSigDate;
    }

    public Serializable getResengConsultSig() {
        return resengConsultSig;
    }

    public void setResengConsultSig(Serializable resengConsultSig) {
        this.resengConsultSig = resengConsultSig;
    }

    public BigInteger getResengConsultSigId() {
        return resengConsultSigId;
    }

    public void setResengConsultSigId(BigInteger resengConsultSigId) {
        this.resengConsultSigId = resengConsultSigId;
    }

    public Date getResengConsultSigDate() {
        return resengConsultSigDate;
    }

    public void setResengConsultSigDate(Date resengConsultSigDate) {
        this.resengConsultSigDate = resengConsultSigDate;
    }

    public Serializable getEngSig() {
        return engSig;
    }

    public void setEngSig(Serializable engSig) {
        this.engSig = engSig;
    }

    public BigInteger getEngSigId() {
        return engSigId;
    }

    public void setEngSigId(BigInteger engSigId) {
        this.engSigId = engSigId;
    }

    public Date getEngSigDate() {
        return engSigDate;
    }

    public void setEngSigDate(Date engSigDate) {
        this.engSigDate = engSigDate;
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
        if (!(object instanceof CmFormSubmSignatures)) {
            return false;
        }
        CmFormSubmSignatures other = (CmFormSubmSignatures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormSubmSignatures[ id=" + id + " ]";
    }
    
}
