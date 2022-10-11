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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "GlobSieveSets.findBySetName", query = "SELECT g FROM GlobSieveSets g WHERE g.setName = :setName"),
    @NamedQuery(name = "GlobSieveSets.findBySieveId", query = "SELECT g FROM GlobSieveSets g WHERE g.sieveId = :sieveId"),
    @NamedQuery(name = "GlobSieveSets.findByDesign", query = "SELECT g FROM GlobSieveSets g WHERE g.design = :design"),
    @NamedQuery(name = "GlobSieveSets.findByField5", query = "SELECT g FROM GlobSieveSets g WHERE g.field5 = :field5"),
    @NamedQuery(name = "GlobSieveSets.findByOrdering", query = "SELECT g FROM GlobSieveSets g WHERE g.ordering = :ordering"),
    @NamedQuery(name = "GlobSieveSets.findByField10", query = "SELECT g FROM GlobSieveSets g WHERE g.field10 = :field10"),
    @NamedQuery(name = "GlobSieveSets.findByField9", query = "SELECT g FROM GlobSieveSets g WHERE g.field9 = :field9"),
    @NamedQuery(name = "GlobSieveSets.findByField8", query = "SELECT g FROM GlobSieveSets g WHERE g.field8 = :field8"),
    @NamedQuery(name = "GlobSieveSets.findByField7", query = "SELECT g FROM GlobSieveSets g WHERE g.field7 = :field7"),
    @NamedQuery(name = "GlobSieveSets.findByField6", query = "SELECT g FROM GlobSieveSets g WHERE g.field6 = :field6"),
    @NamedQuery(name = "GlobSieveSets.findByActionLimit", query = "SELECT g FROM GlobSieveSets g WHERE g.actionLimit = :actionLimit"),
    @NamedQuery(name = "GlobSieveSets.findByField3", query = "SELECT g FROM GlobSieveSets g WHERE g.field3 = :field3"),
    @NamedQuery(name = "GlobSieveSets.findByField2", query = "SELECT g FROM GlobSieveSets g WHERE g.field2 = :field2"),
    @NamedQuery(name = "GlobSieveSets.findByField1", query = "SELECT g FROM GlobSieveSets g WHERE g.field1 = :field1"),
    @NamedQuery(name = "GlobSieveSets.findByFactor", query = "SELECT g FROM GlobSieveSets g WHERE g.factor = :factor"),
    @NamedQuery(name = "GlobSieveSets.findByMaxLimit", query = "SELECT g FROM GlobSieveSets g WHERE g.maxLimit = :maxLimit"),
    @NamedQuery(name = "GlobSieveSets.findByMinLimit", query = "SELECT g FROM GlobSieveSets g WHERE g.minLimit = :minLimit"),
    @NamedQuery(name = "GlobSieveSets.findBySetId", query = "SELECT g FROM GlobSieveSets g WHERE g.setId = :setId"),
    @NamedQuery(name = "GlobSieveSets.findBySuspensionLimit", query = "SELECT g FROM GlobSieveSets g WHERE g.suspensionLimit = :suspensionLimit"),
    @NamedQuery(name = "GlobSieveSets.findByField4", query = "SELECT g FROM GlobSieveSets g WHERE g.field4 = :field4"),
    @NamedQuery(name = "GlobSieveSets.findBySpecCorrFactor", query = "SELECT g FROM GlobSieveSets g WHERE g.specCorrFactor = :specCorrFactor"),
    @NamedQuery(name = "GlobSieveSets.findByContratorCorrFactor", query = "SELECT g FROM GlobSieveSets g WHERE g.contratorCorrFactor = :contratorCorrFactor"),
    @NamedQuery(name = "GlobSieveSets.findByJmfCurrent", query = "SELECT g FROM GlobSieveSets g WHERE g.jmfCurrent = :jmfCurrent"),
    @NamedQuery(name = "GlobSieveSets.findByGradDeviation", query = "SELECT g FROM GlobSieveSets g WHERE g.gradDeviation = :gradDeviation")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SIEVE_SETS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSieveSets.findAll", query = "SELECT g FROM GlobSieveSets g"),
    @NamedQuery(name = "GlobSieveSets.findById", query = "SELECT g FROM GlobSieveSets g WHERE g.id = :id")})
public class GlobSieveSets implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @JoinColumn(name = "SIEVE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobSievelist sieveId;
    @Column(name = "DESIGN")
    private Double design;
    @Size(max = 255)
    @Column(name = "FIELD5")
    private String field5;
    @Column(name = "ORDERING")
    private BigInteger ordering;
    @Size(max = 50)
    @Column(name = "FIELD10")
    private String field10;
    @Size(max = 50)
    @Column(name = "FIELD9")
    private String field9;
    @Column(name = "FIELD8")
    private BigInteger field8;
    @Column(name = "FIELD7")
    private BigInteger field7;
    @Size(max = 255)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "ACTION_LIMIT")
    private Double actionLimit;
    @Size(max = 255)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Column(name = "FACTOR")
    private BigInteger factor;
    @Column(name = "MAX_LIMIT")
    private Double maxLimit;
    @Column(name = "MIN_LIMIT")
    private Double minLimit;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Column(name = "SUSPENSION_LIMIT")
    private Double suspensionLimit;
    @Size(max = 255)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "SPEC_CORR_FACTOR")
    private Double specCorrFactor;
    @Column(name = "CONTRATOR_CORR_FACTOR")
    private Double contratorCorrFactor;
    @Column(name = "JMF_CURRENT")
    private Double jmfCurrent;
    @Column(name = "GRAD_DEVIATION")
    private Double gradDeviation;

    public GlobSieveSets() {
    }

    public GlobSieveSets(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public GlobSievelist getSieveId() {
        return sieveId;
    }

    public void setSieveId(GlobSievelist sieveId) {
        this.sieveId = sieveId;
    }

    public Double getDesign() {
        return design;
    }

    public void setDesign(Double design) {
        this.design = design;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public BigInteger getField8() {
        return field8;
    }

    public void setField8(BigInteger field8) {
        this.field8 = field8;
    }

    public BigInteger getField7() {
        return field7;
    }

    public void setField7(BigInteger field7) {
        this.field7 = field7;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public Double getActionLimit() {
        return actionLimit;
    }

    public void setActionLimit(Double actionLimit) {
        this.actionLimit = actionLimit;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public BigInteger getFactor() {
        return factor;
    }

    public void setFactor(BigInteger factor) {
        this.factor = factor;
    }

    public Double getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(Double maxLimit) {
        this.maxLimit = maxLimit;
    }

    public Double getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Double minLimit) {
        this.minLimit = minLimit;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public Double getSuspensionLimit() {
        return suspensionLimit;
    }

    public void setSuspensionLimit(Double suspensionLimit) {
        this.suspensionLimit = suspensionLimit;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getSpecCorrFactor() {
        return specCorrFactor;
    }

    public void setSpecCorrFactor(Double specCorrFactor) {
        this.specCorrFactor = specCorrFactor;
    }

    public Double getContratorCorrFactor() {
        return contratorCorrFactor;
    }

    public void setContratorCorrFactor(Double contratorCorrFactor) {
        this.contratorCorrFactor = contratorCorrFactor;
    }

    public Double getJmfCurrent() {
        return jmfCurrent;
    }

    public void setJmfCurrent(Double jmfCurrent) {
        this.jmfCurrent = jmfCurrent;
    }

    public Double getGradDeviation() {
        return gradDeviation;
    }

    public void setGradDeviation(Double gradDeviation) {
        this.gradDeviation = gradDeviation;
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
        if (!(object instanceof GlobSieveSets)) {
            return false;
        }
        GlobSieveSets other = (GlobSieveSets) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSieveSets[ id=" + id + " ]";
    }

}
