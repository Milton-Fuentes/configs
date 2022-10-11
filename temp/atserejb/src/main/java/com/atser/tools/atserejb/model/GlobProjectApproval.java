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
@Table(name = "GLOB_PROJECT_APPROVAL", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobProjectApproval.findAll", query = "SELECT g FROM GlobProjectApproval g")
    , @NamedQuery(name = "GlobProjectApproval.findById", query = "SELECT g FROM GlobProjectApproval g WHERE g.id = :id")
    , @NamedQuery(name = "GlobProjectApproval.findByProjectId", query = "SELECT g FROM GlobProjectApproval g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobProjectApproval.findByUserId", query = "SELECT g FROM GlobProjectApproval g WHERE g.userId = :userId")
    , @NamedQuery(name = "GlobProjectApproval.findByApprovalType", query = "SELECT g FROM GlobProjectApproval g WHERE g.approvalType = :approvalType")})
public class GlobProjectApproval implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Size(max = 20)
    @Column(name = "APPROVAL_TYPE")
    private String approvalType;

    public GlobProjectApproval() {
    }

    public GlobProjectApproval(BigDecimal id) {
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

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getApprovalType() {
        return approvalType;
    }

    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
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
        if (!(object instanceof GlobProjectApproval)) {
            return false;
        }
        GlobProjectApproval other = (GlobProjectApproval) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobProjectApproval[ id=" + id + " ]";
    }
    
}
