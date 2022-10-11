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
@NamedQuery(name = "QaPlistSig.findByItemId", query = "SELECT q FROM QaPlistSig q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaPlistSig.findByImageTimestamp", query = "SELECT q FROM QaPlistSig q WHERE q.imageTimestamp = :imageTimestamp"),
    @NamedQuery(name = "QaPlistSig.findByInsp1SigId", query = "SELECT q FROM QaPlistSig q WHERE q.insp1SigId = :insp1SigId"),
    @NamedQuery(name = "QaPlistSig.findByInsp1SigDate", query = "SELECT q FROM QaPlistSig q WHERE q.insp1SigDate = :insp1SigDate"),
    @NamedQuery(name = "QaPlistSig.findByInsp2SigId", query = "SELECT q FROM QaPlistSig q WHERE q.insp2SigId = :insp2SigId"),
    @NamedQuery(name = "QaPlistSig.findByInsp2SigDate", query = "SELECT q FROM QaPlistSig q WHERE q.insp2SigDate = :insp2SigDate"),
    @NamedQuery(name = "QaPlistSig.findByInsp3SigId", query = "SELECT q FROM QaPlistSig q WHERE q.insp3SigId = :insp3SigId"),
    @NamedQuery(name = "QaPlistSig.findByInsp3SigDate", query = "SELECT q FROM QaPlistSig q WHERE q.insp3SigDate = :insp3SigDate"),
    @NamedQuery(name = "QaPlistSig.findByInsp4SigId", query = "SELECT q FROM QaPlistSig q WHERE q.insp4SigId = :insp4SigId"),
    @NamedQuery(name = "QaPlistSig.findByInsp4SigDate", query = "SELECT q FROM QaPlistSig q WHERE q.insp4SigDate = :insp4SigDate"),
    @NamedQuery(name = "QaPlistSig.findByInsp5SigId", query = "SELECT q FROM QaPlistSig q WHERE q.insp5SigId = :insp5SigId"),
    @NamedQuery(name = "QaPlistSig.findByInsp5SigDate", query = "SELECT q FROM QaPlistSig q WHERE q.insp5SigDate = :insp5SigDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_PLIST_SIG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaPlistSig.findAll", query = "SELECT q FROM QaPlistSig q"),
    @NamedQuery(name = "QaPlistSig.findById", query = "SELECT q FROM QaPlistSig q WHERE q.id = :id")})
public class QaPlistSig implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "IMAGE_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date imageTimestamp;
    @Column(name = "INSP1_SIG_ID")
    private BigInteger insp1SigId;
    @Column(name = "INSP1_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insp1SigDate;
    @SuppressWarnings("unchecked")
    @Lob
    @Column(name = "INSP1_SIG")
    private Serializable insp1Sig;
    @Column(name = "INSP2_SIG_ID")
    private BigInteger insp2SigId;
    @Column(name = "INSP2_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insp2SigDate;
    @SuppressWarnings("unchecked")
    @Lob
    @Column(name = "INSP2_SIG")
    private Serializable insp2Sig;
    @Column(name = "INSP3_SIG_ID")
    private BigInteger insp3SigId;
    @Column(name = "INSP3_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insp3SigDate;
    @SuppressWarnings("unchecked")
    @Lob
    @Column(name = "INSP3_SIG")
    private Serializable insp3Sig;
    @Column(name = "INSP4_SIG_ID")
    private BigInteger insp4SigId;
    @Column(name = "INSP4_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insp4SigDate;
    @SuppressWarnings("unchecked")
    @Lob
    @Column(name = "INSP4_SIG")
    private Serializable insp4Sig;
    @Column(name = "INSP5_SIG_ID")
    private BigInteger insp5SigId;
    @Column(name = "INSP5_SIG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insp5SigDate;
    @SuppressWarnings("unchecked")
    @Lob
    @Column(name = "INSP5_SIG")
    private Serializable insp5Sig;

    public QaPlistSig() {
    }

    public QaPlistSig(BigDecimal id) {
        this.id = id;
    }

    public QaPlistSig(BigDecimal id, BigInteger itemId) {
        this.id = id;
        this.itemId = itemId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public Date getImageTimestamp() {
        return imageTimestamp;
    }

    public void setImageTimestamp(Date imageTimestamp) {
        this.imageTimestamp = imageTimestamp;
    }

    public BigInteger getInsp1SigId() {
        return insp1SigId;
    }

    public void setInsp1SigId(BigInteger insp1SigId) {
        this.insp1SigId = insp1SigId;
    }

    public Date getInsp1SigDate() {
        return insp1SigDate;
    }

    public void setInsp1SigDate(Date insp1SigDate) {
        this.insp1SigDate = insp1SigDate;
    }

    public Serializable getInsp1Sig() {
        return insp1Sig;
    }

    public void setInsp1Sig(Serializable insp1Sig) {
        this.insp1Sig = insp1Sig;
    }

    public BigInteger getInsp2SigId() {
        return insp2SigId;
    }

    public void setInsp2SigId(BigInteger insp2SigId) {
        this.insp2SigId = insp2SigId;
    }

    public Date getInsp2SigDate() {
        return insp2SigDate;
    }

    public void setInsp2SigDate(Date insp2SigDate) {
        this.insp2SigDate = insp2SigDate;
    }

    public Serializable getInsp2Sig() {
        return insp2Sig;
    }

    public void setInsp2Sig(Serializable insp2Sig) {
        this.insp2Sig = insp2Sig;
    }

    public BigInteger getInsp3SigId() {
        return insp3SigId;
    }

    public void setInsp3SigId(BigInteger insp3SigId) {
        this.insp3SigId = insp3SigId;
    }

    public Date getInsp3SigDate() {
        return insp3SigDate;
    }

    public void setInsp3SigDate(Date insp3SigDate) {
        this.insp3SigDate = insp3SigDate;
    }

    public Serializable getInsp3Sig() {
        return insp3Sig;
    }

    public void setInsp3Sig(Serializable insp3Sig) {
        this.insp3Sig = insp3Sig;
    }

    public BigInteger getInsp4SigId() {
        return insp4SigId;
    }

    public void setInsp4SigId(BigInteger insp4SigId) {
        this.insp4SigId = insp4SigId;
    }

    public Date getInsp4SigDate() {
        return insp4SigDate;
    }

    public void setInsp4SigDate(Date insp4SigDate) {
        this.insp4SigDate = insp4SigDate;
    }

    public Serializable getInsp4Sig() {
        return insp4Sig;
    }

    public void setInsp4Sig(Serializable insp4Sig) {
        this.insp4Sig = insp4Sig;
    }

    public BigInteger getInsp5SigId() {
        return insp5SigId;
    }

    public void setInsp5SigId(BigInteger insp5SigId) {
        this.insp5SigId = insp5SigId;
    }

    public Date getInsp5SigDate() {
        return insp5SigDate;
    }

    public void setInsp5SigDate(Date insp5SigDate) {
        this.insp5SigDate = insp5SigDate;
    }

    public Serializable getInsp5Sig() {
        return insp5Sig;
    }

    public void setInsp5Sig(Serializable insp5Sig) {
        this.insp5Sig = insp5Sig;
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
        if (!(object instanceof QaPlistSig)) {
            return false;
        }
        QaPlistSig other = (QaPlistSig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaPlistSig[ id=" + id + " ]";
    }
    
}
