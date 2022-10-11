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
@Table(name = "GLOB_PROJECT_FREQ_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectFreqType.findAll", query = "SELECT g FROM GlobProjectFreqType g")
    , @NamedQuery(name = "GlobProjectFreqType.findById", query = "SELECT g FROM GlobProjectFreqType g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectFreqType.findByProjectId", query = "SELECT g FROM GlobProjectFreqType g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectFreqType.findByTypeId", query = "SELECT g FROM GlobProjectFreqType g WHERE g.typeId = :typeId")
    , @NamedQuery(name = "GlobProjectFreqType.findByCategory", query = "SELECT g FROM GlobProjectFreqType g WHERE g.category = :category")})
public class GlobProjectFreqType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "TYPE_ID")
    private BigInteger typeId;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;

    public GlobProjectFreqType() {
    }

    public GlobProjectFreqType(BigDecimal id) {
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

    public BigInteger getTypeId() {
        return typeId;
    }

    public void setTypeId(BigInteger typeId) {
        this.typeId = typeId;
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
        if (!(object instanceof GlobProjectFreqType)) {
            return false;
        }
        GlobProjectFreqType other = (GlobProjectFreqType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectFreqType[ id=" + id + " ]";
    }
    
}
