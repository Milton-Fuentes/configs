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
@Table(name = "GLOB_SERVICES_LAB_CAT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobServicesLabCat.findAll", query = "SELECT g FROM GlobServicesLabCat g")
    , @NamedQuery(name = "GlobServicesLabCat.findById", query = "SELECT g FROM GlobServicesLabCat g WHERE g.id = :id")
    , @NamedQuery(name = "GlobServicesLabCat.findByCategory", query = "SELECT g FROM GlobServicesLabCat g WHERE g.category = :category")
    , @NamedQuery(name = "GlobServicesLabCat.findByClientId", query = "SELECT g FROM GlobServicesLabCat g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobServicesLabCat.findByListOrder", query = "SELECT g FROM GlobServicesLabCat g WHERE g.listOrder = :listOrder")})
public class GlobServicesLabCat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 4000)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobServicesLabCat() {
    }

    public GlobServicesLabCat(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobServicesLabCat)) {
            return false;
        }
        GlobServicesLabCat other = (GlobServicesLabCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobServicesLabCat[ id=" + id + " ]";
    }
    
}
