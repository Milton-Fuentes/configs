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
@NamedQuery(name = "CmFormRfiSignatures.findByRfiId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.rfiId = :rfiId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByImageTimestamp", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.imageTimestamp = :imageTimestamp"),
    @NamedQuery(name = "CmFormRfiSignatures.findByContractorSigId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.contractorSigId = :contractorSigId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByContractorSigDate", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.contractorSigDate = :contractorSigDate"),
    @NamedQuery(name = "CmFormRfiSignatures.findByTechSigId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.techSigId = :techSigId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByTechSigDate", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.techSigDate = :techSigDate"),
    @NamedQuery(name = "CmFormRfiSignatures.findByCostSigId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.costSigId = :costSigId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByCostSigDate", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.costSigDate = :costSigDate"),
    @NamedQuery(name = "CmFormRfiSignatures.findByResengConsultSigId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.resengConsultSigId = :resengConsultSigId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByResengConsultSigDate", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.resengConsultSigDate = :resengConsultSigDate"),
    @NamedQuery(name = "CmFormRfiSignatures.findByEngSigId", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.engSigId = :engSigId"),
    @NamedQuery(name = "CmFormRfiSignatures.findByEngSigDate", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.engSigDate = :engSigDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_RFI_SIGNATURES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormRfiSignatures.findAll", query = "SELECT c FROM CmFormRfiSignatures c"),
    @NamedQuery(name = "CmFormRfiSignatures.findById", query = "SELECT c FROM CmFormRfiSignatures c WHERE c.id = :id")})
public class CmFormRfiSignatures implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RFI_ID")
    private BigInteger rfiId;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Lob
    @Column(name = "CONTRACTOR_SIG")
    private Serializable contractorSig;
    @Lob
    @Column(name = "TECH_SIG")
    private Serializable techSig;
    @Lob
    @Column(name = "COST_SIG")
    private Serializable costSig;
    @Column(name = "CONTRACTOR_SIG_ID")
    private BigInteger contractorSigId;
    @Column(name = "CONTRACTOR_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date contractorSigDate;
    @Column(name = "TECH_SIG_ID")
    private BigInteger techSigId;
    @Column(name = "TECH_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date techSigDate;
    @Column(name = "COST_SIG_ID")
    private BigInteger costSigId;
    @Column(name = "COST_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date costSigDate;
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

    public CmFormRfiSignatures() {
    }

    public CmFormRfiSignatures(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRfiId() {
        return rfiId;
    }

    public void setRfiId(BigInteger rfiId) {
        this.rfiId = rfiId;
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

    public Serializable getTechSig() {
        return techSig;
    }

    public void setTechSig(Serializable techSig) {
        this.techSig = techSig;
    }

    public Serializable getCostSig() {
        return costSig;
    }

    public void setCostSig(Serializable costSig) {
        this.costSig = costSig;
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

    public BigInteger getTechSigId() {
        return techSigId;
    }

    public void setTechSigId(BigInteger techSigId) {
        this.techSigId = techSigId;
    }

    public Date getTechSigDate() {
        return techSigDate;
    }

    public void setTechSigDate(Date techSigDate) {
        this.techSigDate = techSigDate;
    }

    public BigInteger getCostSigId() {
        return costSigId;
    }

    public void setCostSigId(BigInteger costSigId) {
        this.costSigId = costSigId;
    }

    public Date getCostSigDate() {
        return costSigDate;
    }

    public void setCostSigDate(Date costSigDate) {
        this.costSigDate = costSigDate;
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
        if (!(object instanceof CmFormRfiSignatures)) {
            return false;
        }
        CmFormRfiSignatures other = (CmFormRfiSignatures) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormRfiSignatures[ id=" + id + " ]";
    }
    
}
