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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_TEST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientTest.findAll", query = "SELECT g FROM GlobClientTest g")
    , @NamedQuery(name = "GlobClientTest.findById", query = "SELECT g FROM GlobClientTest g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientTest.findByClientId", query = "SELECT g FROM GlobClientTest g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientTest.findByTestId", query = "SELECT g FROM GlobClientTest g WHERE g.testId = :testId")
    , @NamedQuery(name = "GlobClientTest.findByReportTitle", query = "SELECT g FROM GlobClientTest g WHERE g.reportTitle = :reportTitle")
    , @NamedQuery(name = "GlobClientTest.findByClientMobile", query = "SELECT g FROM GlobClientTest g WHERE g.clientMobile = :clientMobile")})
public class GlobClientTest implements Serializable {
    
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient clientId;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 255)
    @Column(name = "REPORT_TITLE")
    private String reportTitle;
    @Column(name = "CLIENT_MOBILE")
    private BigInteger clientMobile;
    @Size(max = 255)
    @Column(name = "TEST_REF_ABBR")
    private String testRefAbbr;

    public GlobClientTest() {
    }

    public GlobClientTest(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
        this.clientId = clientId;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public BigInteger getClientMobile() {
        return clientMobile;
    }

    public void setClientMobile(BigInteger clientMobile) {
        this.clientMobile = clientMobile;
    }

    public String getTestRefAbbr() {
        return testRefAbbr;
    }

    public void setTestRefAbbr(String testRefAbbr) {
        this.testRefAbbr = testRefAbbr;
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
        if (!(object instanceof GlobClientTest)) {
            return false;
        }
        GlobClientTest other = (GlobClientTest) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientTest[ id=" + id + " ]";
    }
}
