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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author mfuentes
 */
@Entity
@Table(name = "GLOB_BILLING_RATE_TABLE_DETAIL", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_BILLING_RATE_TABLE_DETAIL SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobBillingRateTableDetail.findAll", query = "SELECT q FROM GlobBillingRateTableDetail q"),
    @NamedQuery(name = "GlobBillingRateTableDetail.findById", query = "SELECT q FROM GlobBillingRateTableDetail q WHERE q.id = :id")})
public class GlobBillingRateTableDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "GLOB_BILLING_RATE_TAB_DTL_ID_SEQ", sequenceName = "GLOB_BILLING_RATE_TAB_DTL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_BILLING_RATE_TAB_DTL_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "RATE_TABLE_ID")
    private BigInteger rateTableId;
    @JoinColumn(name = "BILLING_CODE_ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private QaSampleTestBillingItem billingCodeId;
    @Size(max = 20)
    @Column(name = "UNITPRICE")
    private String unitprice;

    public GlobBillingRateTableDetail() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getRateTableId() {
        return rateTableId;
    }

    public void setRateTableId(BigInteger rateTableId) {
        this.rateTableId = rateTableId;
    }

    public QaSampleTestBillingItem getBillingCodeId() {
        return billingCodeId;
    }

    public void setBillingCodeId(QaSampleTestBillingItem billingCodeId) {
        this.billingCodeId = billingCodeId;
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
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
        if (!(object instanceof GlobBillingRateTableDetail)) {
            return false;
        }
        GlobBillingRateTableDetail other = (GlobBillingRateTableDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobBillingRateTableDetail[ id=" + id + " ]";
    }

}
