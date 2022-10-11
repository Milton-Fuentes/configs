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
@NamedQuery(name = "GlobProjectSpecsConcmolds.findByProjectId", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findByMoldType", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.moldType = :moldType"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findByNumSets", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.numSets = :numSets"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findByEvery", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.every = :every"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findByListOrder", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.listOrder = :listOrder"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findByCategory", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.category = :category")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_PROJECT_SPECS_CONCMOLDS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findAll", query = "SELECT g FROM GlobProjectSpecsConcmolds g"),
    @NamedQuery(name = "GlobProjectSpecsConcmolds.findById", query = "SELECT g FROM GlobProjectSpecsConcmolds g WHERE g.id = :id")})
public class GlobProjectSpecsConcmolds implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 20)
    @Column(name = "MOLD_TYPE")
    private String moldType;
    @Size(max = 20)
    @Column(name = "NUM_SETS")
    private String numSets;
    @Size(max = 255)
    @Column(name = "EVERY")
    private String every;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;

    public GlobProjectSpecsConcmolds() {
    }

    public GlobProjectSpecsConcmolds(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getMoldType() {
        return moldType;
    }

    public void setMoldType(String moldType) {
        this.moldType = moldType;
    }

    public String getNumSets() {
        return numSets;
    }

    public void setNumSets(String numSets) {
        this.numSets = numSets;
    }

    public String getEvery() {
        return every;
    }

    public void setEvery(String every) {
        this.every = every;
    }

    public BigInteger getListOrder() {
        return listOrder;
    }

    public void setListOrder(BigInteger listOrder) {
        this.listOrder = listOrder;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        if (!(object instanceof GlobProjectSpecsConcmolds)) {
            return false;
        }
        GlobProjectSpecsConcmolds other = (GlobProjectSpecsConcmolds) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectSpecsConcmolds[ id=" + id + " ]";
    }
    
}
