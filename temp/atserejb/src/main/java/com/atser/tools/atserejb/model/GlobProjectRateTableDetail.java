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
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author mfuentes
 */
@Entity
@Table(name = "GLOB_PROJECT_RATE_TABLE_DETAIL", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_PROJECT_RATE_TABLE_DETAIL SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectRateTableDetail.findAll", query = "SELECT q FROM GlobProjectRateTableDetail q"),
    @NamedQuery(name = "GlobProjectRateTableDetail.findById", query = "SELECT q FROM GlobProjectRateTableDetail q WHERE q.id = :id")})
public class GlobProjectRateTableDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "GLOB_PROJECT_RT_DETAIL_ID_SEQ", sequenceName = "GLOB_PROJECT_RT_DETAIL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PROJECT_RT_DETAIL_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "RATE_TABLE_ID")
    private BigInteger rateTableId;
    @JoinColumn(name = "BILLING_CODE_ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private QaSampleTestBillingItem billingCodeId;

    public GlobProjectRateTableDetail() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobProjectRateTableDetail)) {
            return false;
        }
        GlobProjectRateTableDetail other = (GlobProjectRateTableDetail) object;
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
