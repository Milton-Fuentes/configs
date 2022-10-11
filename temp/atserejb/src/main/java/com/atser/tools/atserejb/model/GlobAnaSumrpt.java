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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_ANA_SUMRPT", catalog = "", schema = "ORACLE")
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobAnaSumrpt.findAll", query = "SELECT g FROM GlobAnaSumrpt g"),
    @NamedQuery(name = "GlobAnaSumrpt.findById", query = "SELECT g FROM GlobAnaSumrpt g WHERE g.id = :id"),
    @NamedQuery(name = "GlobAnaSumrpt.findByReportNo", query = "SELECT g FROM GlobAnaSumrpt g WHERE g.reportNo = :reportNo"),
    @NamedQuery(name = "GlobAnaSumrpt.findByReportName", query = "SELECT g FROM GlobAnaSumrpt g WHERE g.reportName = :reportName"),
    @NamedQuery(name = "GlobAnaSumrpt.findByReportOrder", query = "SELECT g FROM GlobAnaSumrpt g WHERE g.reportOrder = :reportOrder"),
    @NamedQuery(name = "GlobAnaSumrpt.findByActive", query = "SELECT g FROM GlobAnaSumrpt g WHERE g.active = :active")})
public class GlobAnaSumrpt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "REPORT_NO")
    private BigInteger reportNo;
    @Size(max = 200)
    @Column(name = "REPORT_NAME")
    private String reportName;
    @Column(name = "REPORT_ORDER")
    private BigInteger reportOrder;
    @Column(name = "ACTIVE")
    private Character active;

    public GlobAnaSumrpt() {
    }

    public GlobAnaSumrpt(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getReportNo() {
        return reportNo;
    }

    public void setReportNo(BigInteger reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public BigInteger getReportOrder() {
        return reportOrder;
    }

    public void setReportOrder(BigInteger reportOrder) {
        this.reportOrder = reportOrder;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobAnaSumrpt)) {
            return false;
        }
        GlobAnaSumrpt other = (GlobAnaSumrpt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobAnaSumrpt[ id=" + id + " ]";
    }

}
