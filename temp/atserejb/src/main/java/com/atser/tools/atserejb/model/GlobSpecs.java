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
, @NamedQuery(name = "GlobSpecs.findByCategory", query = "SELECT g FROM GlobSpecs g WHERE g.category = :category")
    , @NamedQuery(name = "GlobSpecs.findByName", query = "SELECT g FROM GlobSpecs g WHERE g.name = :name")
    , @NamedQuery(name = "GlobSpecs.findByDatatyping", query = "SELECT g FROM GlobSpecs g WHERE g.datatyping = :datatyping")
    , @NamedQuery(name = "GlobSpecs.findByDescription", query = "SELECT g FROM GlobSpecs g WHERE g.description = :description")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SPECS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSpecs.findAll", query = "SELECT g FROM GlobSpecs g")
    , @NamedQuery(name = "GlobSpecs.findById", query = "SELECT g FROM GlobSpecs g WHERE g.id = :id")})
public class GlobSpecs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATATYPING")
    private BigInteger datatyping;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;

    public GlobSpecs() {
    }

    public GlobSpecs(BigDecimal id) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getDatatyping() {
        return datatyping;
    }

    public void setDatatyping(BigInteger datatyping) {
        this.datatyping = datatyping;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof GlobSpecs)) {
            return false;
        }
        GlobSpecs other = (GlobSpecs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSpecs[ id=" + id + " ]";
    }
    
}
