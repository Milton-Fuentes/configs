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
import javax.persistence.Cacheable;
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
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author droldan
 */
@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "GlobSystemProperties")
@Table(name = "GLOB_SYSTEM_PROPERTIES", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSystemProperties.findAll", query = "SELECT g FROM GlobSystemProperties g"),
    @NamedQuery(name = "GlobSystemProperties.findById", query = "SELECT g FROM GlobSystemProperties g WHERE g.id = :id")})
public class GlobSystemProperties implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "GLOB_SYSTEM_PROPERTIES_SEQ", sequenceName = "GLOB_SYSTEM_PROPERTIES_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SYSTEM_PROPERTIES_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "PKEY")
    private String pkey;
    @Size(max = 255)
    @Column(name = "PVALUE")
    private String pvalue;
    @Size(max = 255)
    @Column(name = "REMARKS")
    private String remarks;

    public GlobSystemProperties() {
    }

    public GlobSystemProperties(BigDecimal id, BigInteger clientId, String pkey, String pvalue) {
        this.id = id;
        this.clientId = clientId;
        this.pkey = pkey;
        this.pvalue = pvalue;
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getPkey() {
        return pkey;
    }

    public void setPkey(String pkey) {
        this.pkey = pkey;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
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
        hash = 97 * hash + Objects.hashCode(this.clientId);
        hash = 97 * hash + Objects.hashCode(this.projectId);
        hash = 97 * hash + Objects.hashCode(this.pkey);
        hash = 97 * hash + Objects.hashCode(this.pvalue);
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
        final GlobSystemProperties other = (GlobSystemProperties) obj;
        if (!Objects.equals(this.pkey, other.pkey)) {
            return false;
        }
        if (!Objects.equals(this.pvalue, other.pvalue)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GlobSystemProperties{" + "id=" + id + ", clientId=" + clientId + ", pkey=" + pkey + ", pvalue=" + pvalue + '}';
    }
}
