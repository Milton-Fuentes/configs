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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "QA_SAMPLE_TEST_EQUIP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleTestEquip.findAll", query = "SELECT q FROM QaSampleTestEquip q"),
    @NamedQuery(name = "QaSampleTestEquip.findById", query = "SELECT q FROM QaSampleTestEquip q WHERE q.id = :id")})
public class QaSampleTestEquip implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_SAMPLE_TEST_EQUIP_id_seq", sequenceName = "QA_SAMPLE_TEST_EQUIP_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_SAMPLE_TEST_EQUIP_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLE_TEST_ID")
    private BigInteger sampleTestId;
    @Column(name = "EQUIP_ID")
    private BigInteger equipId;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;

    public QaSampleTestEquip() {
    }

    public QaSampleTestEquip(BigDecimal id) {
        this.id = id;
    }

    public QaSampleTestEquip(BigInteger sampleTestId, BigInteger equipId) {
        this.sampleTestId = sampleTestId;
        this.equipId = equipId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(BigInteger sampleTestId) {
        this.sampleTestId = sampleTestId;
    }

    public BigInteger getEquipId() {
        return equipId;
    }

    public void setEquipId(BigInteger equipId) {
        this.equipId = equipId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.sampleTestId);
        hash = 17 * hash + Objects.hashCode(this.equipId);
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
        final QaSampleTestEquip other = (QaSampleTestEquip) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.sampleTestId, other.sampleTestId)) {
            return false;
        }
        if (!Objects.equals(this.equipId, other.equipId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QaSampleTestEquip{" + "id=" + id + ", sampleTestId=" + sampleTestId + ", equipId=" + equipId + '}';
    }
}
