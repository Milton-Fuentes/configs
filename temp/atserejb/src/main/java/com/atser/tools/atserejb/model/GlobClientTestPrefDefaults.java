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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CLIENT_TEST_PREF_DEFAULTS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobClientTestPrefDefaults.findAll", query = "SELECT g FROM GlobClientTestPrefDefaults g")
    , @NamedQuery(name = "GlobClientTestPrefDefaults.findById", query = "SELECT g FROM GlobClientTestPrefDefaults g WHERE g.id = :id")
    , @NamedQuery(name = "GlobClientTestPrefDefaults.findByClientId", query = "SELECT g FROM GlobClientTestPrefDefaults g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobClientTestPrefDefaults.findByTestPrefId", query = "SELECT g FROM GlobClientTestPrefDefaults g WHERE g.testPrefId = :testPrefId")
    , @NamedQuery(name = "GlobClientTestPrefDefaults.findByUsesPreference", query = "SELECT g FROM GlobClientTestPrefDefaults g WHERE g.usesPreference = :usesPreference")})
public class GlobClientTestPrefDefaults implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "TEST_PREF_ID")
    private BigInteger testPrefId;
    @Column(name = "USES_PREFERENCE")
    private Character usesPreference;

    public GlobClientTestPrefDefaults() {
    }

    public GlobClientTestPrefDefaults(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getTestPrefId() {
        return testPrefId;
    }

    public void setTestPrefId(BigInteger testPrefId) {
        this.testPrefId = testPrefId;
    }

    public Character getUsesPreference() {
        return usesPreference;
    }

    public void setUsesPreference(Character usesPreference) {
        this.usesPreference = usesPreference;
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
        if (!(object instanceof GlobClientTestPrefDefaults)) {
            return false;
        }
        GlobClientTestPrefDefaults other = (GlobClientTestPrefDefaults) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobClientTestPrefDefaults[ id=" + id + " ]";
    }
    
}
