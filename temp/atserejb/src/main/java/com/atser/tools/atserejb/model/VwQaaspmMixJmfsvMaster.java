/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.objects.pojo.qa.mixdesign.GradationPojo;
import com.atser.tools.atserutil.string.StringSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "VW_QAASPM_MIXJMFSV_MASTER", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQaaspmMixJmfsvMaster.findAll", query = "SELECT a FROM VwQaaspmMixJmfsvMaster a")})
public class VwQaaspmMixJmfsvMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "JMF_ID")
    private BigInteger jmfId;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Size(max = 50)
    @Column(name = "SIEVESIZE")
    private String sieveSize;
    @Column(name = "ORDERING")
    private BigInteger ordering;
    @Column(name = "JMF_PERC_PASSING")
    private BigDecimal jfmPercPassing;
    @Column(name = "MIN_LIMIT")
    private BigDecimal minLimit;
    @Column(name = "MAX_LIMIT")
    private BigDecimal maxLimit;
    @Column(name = "GRAD_DEVIATION")
    private BigDecimal gradDeviation;
    @Column(name = "VERSION")
    private Long version;

    public VwQaaspmMixJmfsvMaster() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getJmfId() {
        return jmfId;
    }

    public void setJmfId(BigInteger jmfId) {
        this.jmfId = jmfId;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public String getSieveSize() {
        return sieveSize;
    }

    public void setSieveSize(String sieveSize) {
        this.sieveSize = sieveSize;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
    }

    public BigDecimal getJfmPercPassing() {
        return jfmPercPassing;
    }

    public void setJfmPercPassing(BigDecimal jfmPercPassing) {
        this.jfmPercPassing = jfmPercPassing;
    }

    public BigDecimal getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(BigDecimal minLimit) {
        this.minLimit = minLimit;
    }

    public BigDecimal getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }

    public BigDecimal getGradDeviation() {
        return gradDeviation;
    }

    public void setGradDeviation(BigDecimal gradDeviation) {
        this.gradDeviation = gradDeviation;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
    
    public GradationPojo generateGradationPojo() {
        return new GradationPojo(getSieveSize(), StringSupport.getString(getJfmPercPassing()), StringSupport.getString(getMinLimit()), StringSupport.getString(getMaxLimit()), StringSupport.getString(getGradDeviation()));
    }
}
