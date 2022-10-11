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
@Table(name = "GLOB_SPEC_BOOK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBook.findAll", query = "SELECT g FROM GlobSpecBook g")
    , @NamedQuery(name = "GlobSpecBook.findById", query = "SELECT g FROM GlobSpecBook g WHERE g.id = :id")
    , @NamedQuery(name = "GlobSpecBook.findBySpecBookCatId", query = "SELECT g FROM GlobSpecBook g WHERE g.specBookCatId = :specBookCatId")
    , @NamedQuery(name = "GlobSpecBook.findBySpecName", query = "SELECT g FROM GlobSpecBook g WHERE g.specName = :specName")
    , @NamedQuery(name = "GlobSpecBook.findBySpecOrder", query = "SELECT g FROM GlobSpecBook g WHERE g.specOrder = :specOrder")})
public class GlobSpecBook implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SPEC_BOOK_CAT_ID")
    private BigInteger specBookCatId;
    @Size(max = 255)
    @Column(name = "SPEC_NAME")
    private String specName;
    @Column(name = "SPEC_ORDER")
    private BigInteger specOrder;

    public GlobSpecBook() {
    }

    public GlobSpecBook(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecBookCatId() {
        return specBookCatId;
    }

    public void setSpecBookCatId(BigInteger specBookCatId) {
        this.specBookCatId = specBookCatId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public BigInteger getSpecOrder() {
        return specOrder;
    }

    public void setSpecOrder(BigInteger specOrder) {
        this.specOrder = specOrder;
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
        if (!(object instanceof GlobSpecBook)) {
            return false;
        }
        GlobSpecBook other = (GlobSpecBook) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBook[ id=" + id + " ]";
    }
    
}
