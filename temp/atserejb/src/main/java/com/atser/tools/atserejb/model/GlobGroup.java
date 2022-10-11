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
@Table(name = "GLOB_GROUP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobGroup.findAll", query = "SELECT g FROM GlobGroup g")
    , @NamedQuery(name = "GlobGroup.findById", query = "SELECT g FROM GlobGroup g WHERE g.id = :id")
    , @NamedQuery(name = "GlobGroup.findByParentId", query = "SELECT g FROM GlobGroup g WHERE g.parentId = :parentId")
    , @NamedQuery(name = "GlobGroup.findByGName", query = "SELECT g FROM GlobGroup g WHERE g.gName = :gName")
    , @NamedQuery(name = "GlobGroup.findByDescription", query = "SELECT g FROM GlobGroup g WHERE g.description = :description")
    , @NamedQuery(name = "GlobGroup.findByHasrootfolder", query = "SELECT g FROM GlobGroup g WHERE g.hasrootfolder = :hasrootfolder")
    , @NamedQuery(name = "GlobGroup.findBySystem", query = "SELECT g FROM GlobGroup g WHERE g.system = :system")
    , @NamedQuery(name = "GlobGroup.findByContractId", query = "SELECT g FROM GlobGroup g WHERE g.contractId = :contractId")})
public class GlobGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "G_NAME")
    private String gName;
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HASROOTFOLDER")
    private Character hasrootfolder;
    @Column(name = "SYSTEM")
    private Character system;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;

    public GlobGroup() {
    }

    public GlobGroup(BigDecimal id) {
        this.id = id;
    }

    public GlobGroup(BigDecimal id, String gName) {
        this.id = id;
        this.gName = gName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getHasrootfolder() {
        return hasrootfolder;
    }

    public void setHasrootfolder(Character hasrootfolder) {
        this.hasrootfolder = hasrootfolder;
    }

    public Character getSystem() {
        return system;
    }

    public void setSystem(Character system) {
        this.system = system;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
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
        if (!(object instanceof GlobGroup)) {
            return false;
        }
        GlobGroup other = (GlobGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobGroup[ id=" + id + " ]";
    }
    
}
