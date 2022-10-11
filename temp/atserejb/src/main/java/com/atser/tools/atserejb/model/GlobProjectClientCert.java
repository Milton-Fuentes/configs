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

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_CLIENT_CERT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectClientCert.findAll", query = "SELECT g FROM GlobProjectClientCert g")
    , @NamedQuery(name = "GlobProjectClientCert.findById", query = "SELECT g FROM GlobProjectClientCert g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectClientCert.findByProjectClientId", query = "SELECT g FROM GlobProjectClientCert g WHERE g.projectClientId = :projectClientId")
    , @NamedQuery(name = "GlobProjectClientCert.findByCertification", query = "SELECT g FROM GlobProjectClientCert g WHERE g.certification = :certification")
    , @NamedQuery(name = "GlobProjectClientCert.findByListOrder", query = "SELECT g FROM GlobProjectClientCert g WHERE g.listOrder = :listOrder")})
public class GlobProjectClientCert implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_CLIENT_ID")
    private BigInteger projectClientId;
    @Size(max = 4000)
    @Column(name = "CERTIFICATION")
    private String certification;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobProjectClientCert() {
    }

    public GlobProjectClientCert(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectClientId() {
        return projectClientId;
    }

    public void setProjectClientId(BigInteger projectClientId) {
        this.projectClientId = projectClientId;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
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
        if (!(object instanceof GlobProjectClientCert)) {
            return false;
        }
        GlobProjectClientCert other = (GlobProjectClientCert) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectClientCert[ id=" + id + " ]";
    }
    
}
