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
@Table(name = "GLOB_PROJECT_CONTRACT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectContract.findAll", query = "SELECT g FROM GlobProjectContract g")
    , @NamedQuery(name = "GlobProjectContract.findById", query = "SELECT g FROM GlobProjectContract g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectContract.findByProjectId", query = "SELECT g FROM GlobProjectContract g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectContract.findByContractName", query = "SELECT g FROM GlobProjectContract g WHERE g.contractName = :contractName")
    , @NamedQuery(name = "GlobProjectContract.findByListOrder", query = "SELECT g FROM GlobProjectContract g WHERE g.listOrder = :listOrder")})
public class GlobProjectContract implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "CONTRACT_NAME")
    private String contractName;
    @Column(name = "LIST_ORDER")
    private BigInteger listOrder;

    public GlobProjectContract() {
    }

    public GlobProjectContract(BigDecimal id) {
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
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
        if (!(object instanceof GlobProjectContract)) {
            return false;
        }
        GlobProjectContract other = (GlobProjectContract) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectContract[ id=" + id + " ]";
    }
    
}
