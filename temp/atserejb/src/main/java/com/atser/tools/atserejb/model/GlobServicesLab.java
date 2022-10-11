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
, @NamedQuery(name = "GlobServicesLab.findByLabCategoryId", query = "SELECT g FROM GlobServicesLab g WHERE g.labCategoryId = :labCategoryId")
    , @NamedQuery(name = "GlobServicesLab.findByCode", query = "SELECT g FROM GlobServicesLab g WHERE g.code = :code")
    , @NamedQuery(name = "GlobServicesLab.findByDescription", query = "SELECT g FROM GlobServicesLab g WHERE g.description = :description")
    , @NamedQuery(name = "GlobServicesLab.findByClientId", query = "SELECT g FROM GlobServicesLab g WHERE g.clientId = :clientId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SERVICES_LAB", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobServicesLab.findAll", query = "SELECT g FROM GlobServicesLab g")
    , @NamedQuery(name = "GlobServicesLab.findById", query = "SELECT g FROM GlobServicesLab g WHERE g.id = :id")})
public class GlobServicesLab implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "LAB_CATEGORY_ID")
    private BigInteger labCategoryId;
    @Size(max = 4000)
    @Column(name = "CODE")
    private String code;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public GlobServicesLab() {
    }

    public GlobServicesLab(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getLabCategoryId() {
        return labCategoryId;
    }

    public String getLabServiceFullName() {
        return this.description + " - Lab Code: " + this.code;
    }
    
    public void setLabCategoryId(BigInteger labCategoryId) {
        this.labCategoryId = labCategoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
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
        if (!(object instanceof GlobServicesLab)) {
            return false;
        }
        GlobServicesLab other = (GlobServicesLab) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobServicesLab[ id=" + id + " ]";
    }
    
}
