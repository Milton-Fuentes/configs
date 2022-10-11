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
@Table(name = "GLOB_SPEC_BOOK_INFO_SPECS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecBookInfoSpecs.findAll", query = "SELECT g FROM GlobSpecBookInfoSpecs g")
    , @NamedQuery(name = "GlobSpecBookInfoSpecs.findById", query = "SELECT g FROM GlobSpecBookInfoSpecs g WHERE g.id = :id")
    , @NamedQuery(name = "GlobSpecBookInfoSpecs.findBySpecBookId", query = "SELECT g FROM GlobSpecBookInfoSpecs g WHERE g.specBookId = :specBookId")
    , @NamedQuery(name = "GlobSpecBookInfoSpecs.findBySpecificationId", query = "SELECT g FROM GlobSpecBookInfoSpecs g WHERE g.specificationId = :specificationId")})
public class GlobSpecBookInfoSpecs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SPEC_BOOK_ID")
    private BigInteger specBookId;
    @Column(name = "SPECIFICATION_ID")
    private BigInteger specificationId;

    public GlobSpecBookInfoSpecs() {
    }

    public GlobSpecBookInfoSpecs(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSpecBookId() {
        return specBookId;
    }

    public void setSpecBookId(BigInteger specBookId) {
        this.specBookId = specBookId;
    }

    public BigInteger getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(BigInteger specificationId) {
        this.specificationId = specificationId;
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
        if (!(object instanceof GlobSpecBookInfoSpecs)) {
            return false;
        }
        GlobSpecBookInfoSpecs other = (GlobSpecBookInfoSpecs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecBookInfoSpecs[ id=" + id + " ]";
    }
    
}
