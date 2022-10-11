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

/*
@NamedQuery(name = "GlobSpecBookCat.findByCategory", query = "SELECT g FROM GlobSpecBookCat g WHERE g.category = :category"),
    @NamedQuery(name = "GlobSpecBookCat.findBySpecCatOrder", query = "SELECT g FROM GlobSpecBookCat g WHERE g.specCatOrder = :specCatOrder")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPEC_BOOK_CAT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookCat.findAll", query = "SELECT g FROM GlobSpecBookCat g"),
    @NamedQuery(name = "GlobSpecBookCat.findById", query = "SELECT g FROM GlobSpecBookCat g WHERE g.id = :id")})
public class GlobSpecBookCat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "SPEC_CAT_ORDER")
    private BigInteger specCatOrder;

    public GlobSpecBookCat() {
    }

    public GlobSpecBookCat(BigDecimal id) {
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

    public BigInteger getSpecCatOrder() {
        return specCatOrder;
    }

    public void setSpecCatOrder(BigInteger specCatOrder) {
        this.specCatOrder = specCatOrder;
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
        if (!(object instanceof GlobSpecBookCat)) {
            return false;
        }
        GlobSpecBookCat other = (GlobSpecBookCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookCat[ id=" + id + " ]";
    }
    
}
