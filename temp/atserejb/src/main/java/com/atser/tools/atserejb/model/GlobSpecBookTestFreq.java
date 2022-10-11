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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobSpecBookTestFreq.findBySpecBookTestId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.specBookTestId = :specBookTestId"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByFreqQc", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.freqQc = :freqQc"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByQcUomId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.qcUomId = :qcUomId"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByFreqQa", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.freqQa = :freqQa"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByFreqOvt", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.freqOvt = :freqOvt"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByFreqIat", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.freqIat = :freqIat"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByQaUomId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.qaUomId = :qaUomId"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByOvtUomId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.ovtUomId = :ovtUomId"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByIatUomId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.iatUomId = :iatUomId"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findByUomId", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.uomId = :uomId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_BOOK_TEST_FREQ", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookTestFreq.findAll", query = "SELECT g FROM GlobSpecBookTestFreq g"),
    @NamedQuery(name = "GlobSpecBookTestFreq.findById", query = "SELECT g FROM GlobSpecBookTestFreq g WHERE g.id = :id")})
public class GlobSpecBookTestFreq implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SPEC_BOOK_TEST_ID")
    private BigInteger specBookTestId;
    @Column(name = "FREQ_QC")
    private BigInteger freqQc;
    @Column(name = "QC_UOM_ID")
    private BigInteger qcUomId;
    @Column(name = "FREQ_QA")
    private BigInteger freqQa;
    @Column(name = "FREQ_OVT")
    private BigInteger freqOvt;
    @Column(name = "FREQ_IAT")
    private BigInteger freqIat;
    @Column(name = "QA_UOM_ID")
    private BigInteger qaUomId;
    @Column(name = "OVT_UOM_ID")
    private BigInteger ovtUomId;
    @Column(name = "IAT_UOM_ID")
    private BigInteger iatUomId;
    @Column(name = "UOM_ID")
    private BigInteger uomId;

    public GlobSpecBookTestFreq() {
    }

    public GlobSpecBookTestFreq(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecBookTestId() {
        return specBookTestId;
    }

    public void setSpecBookTestId(BigInteger specBookTestId) {
        this.specBookTestId = specBookTestId;
    }

    public BigInteger getFreqQc() {
        return freqQc;
    }

    public void setFreqQc(BigInteger freqQc) {
        this.freqQc = freqQc;
    }

    public BigInteger getQcUomId() {
        return qcUomId;
    }

    public void setQcUomId(BigInteger qcUomId) {
        this.qcUomId = qcUomId;
    }

    public BigInteger getFreqQa() {
        return freqQa;
    }

    public void setFreqQa(BigInteger freqQa) {
        this.freqQa = freqQa;
    }

    public BigInteger getFreqOvt() {
        return freqOvt;
    }

    public void setFreqOvt(BigInteger freqOvt) {
        this.freqOvt = freqOvt;
    }

    public BigInteger getFreqIat() {
        return freqIat;
    }

    public void setFreqIat(BigInteger freqIat) {
        this.freqIat = freqIat;
    }

    public BigInteger getQaUomId() {
        return qaUomId;
    }

    public void setQaUomId(BigInteger qaUomId) {
        this.qaUomId = qaUomId;
    }

    public BigInteger getOvtUomId() {
        return ovtUomId;
    }

    public void setOvtUomId(BigInteger ovtUomId) {
        this.ovtUomId = ovtUomId;
    }

    public BigInteger getIatUomId() {
        return iatUomId;
    }

    public void setIatUomId(BigInteger iatUomId) {
        this.iatUomId = iatUomId;
    }

    public BigInteger getUomId() {
        return uomId;
    }

    public void setUomId(BigInteger uomId) {
        this.uomId = uomId;
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
        if (!(object instanceof GlobSpecBookTestFreq)) {
            return false;
        }
        GlobSpecBookTestFreq other = (GlobSpecBookTestFreq) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookTestFreq[ id=" + id + " ]";
    }
    
}
