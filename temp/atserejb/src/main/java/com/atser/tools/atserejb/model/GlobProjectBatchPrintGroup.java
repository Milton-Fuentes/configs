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
@Table(name = "GLOB_PROJECT_BATCH_PRINT_GROUP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectBatchPrintGroup.findAll", query = "SELECT g FROM GlobProjectBatchPrintGroup g")
    , @NamedQuery(name = "GlobProjectBatchPrintGroup.findById", query = "SELECT g FROM GlobProjectBatchPrintGroup g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectBatchPrintGroup.findByProjectId", query = "SELECT g FROM GlobProjectBatchPrintGroup g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectBatchPrintGroup.findByGroupId", query = "SELECT g FROM GlobProjectBatchPrintGroup g WHERE g.groupId = :groupId")})
public class GlobProjectBatchPrintGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "GROUP_ID")
    private BigInteger groupId;

    public GlobProjectBatchPrintGroup() {
    }

    public GlobProjectBatchPrintGroup(BigDecimal id) {
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

    public BigInteger getGroupId() {
        return groupId;
    }

    public void setGroupId(BigInteger groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof GlobProjectBatchPrintGroup)) {
            return false;
        }
        GlobProjectBatchPrintGroup other = (GlobProjectBatchPrintGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectBatchPrintGroup[ id=" + id + " ]";
    }
    
}
