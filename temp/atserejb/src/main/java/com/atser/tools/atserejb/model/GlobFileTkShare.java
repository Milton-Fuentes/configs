/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "GLOB_FILE_TK_SHARE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileTkShare.findAll", query = "SELECT g FROM GlobFileTkShare g")
    , @NamedQuery(name = "GlobFileTkShare.findById", query = "SELECT g FROM GlobFileTkShare g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileTkShare.findByToStkId", query = "SELECT g FROM GlobFileTkShare g WHERE g.toStkId = :toStkId")
    , @NamedQuery(name = "GlobFileTkShare.findByToStkGroupId", query = "SELECT g FROM GlobFileTkShare g WHERE g.toStkGroupId = :toStkGroupId")
    , @NamedQuery(name = "GlobFileTkShare.findByToUserId", query = "SELECT g FROM GlobFileTkShare g WHERE g.toUserId = :toUserId")
    , @NamedQuery(name = "GlobFileTkShare.findByToUserGroupId", query = "SELECT g FROM GlobFileTkShare g WHERE g.toUserGroupId = :toUserGroupId")})
public class GlobFileTkShare implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 255)
    @Column(name = "TO_STK_ID")
    private String toStkId;
    @Size(max = 255)
    @Column(name = "TO_STK_GROUP_ID")
    private String toStkGroupId;
    @Size(max = 255)
    @Column(name = "TO_USER_ID")
    private String toUserId;
    @Size(max = 255)
    @Column(name = "TO_USER_GROUP_ID")
    private String toUserGroupId;
    @JoinColumn(name = "FILE_TK_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobFileTk fileTkId;

    public GlobFileTkShare() {
    }

    public GlobFileTkShare(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getToStkId() {
        return toStkId;
    }

    public void setToStkId(String toStkId) {
        this.toStkId = toStkId;
    }

    public String getToStkGroupId() {
        return toStkGroupId;
    }

    public void setToStkGroupId(String toStkGroupId) {
        this.toStkGroupId = toStkGroupId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getToUserGroupId() {
        return toUserGroupId;
    }

    public void setToUserGroupId(String toUserGroupId) {
        this.toUserGroupId = toUserGroupId;
    }

    public GlobFileTk getFileTkId() {
        return fileTkId;
    }

    public void setFileTkId(GlobFileTk fileTkId) {
        this.fileTkId = fileTkId;
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
        if (!(object instanceof GlobFileTkShare)) {
            return false;
        }
        GlobFileTkShare other = (GlobFileTkShare) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileTkShare[ id=" + id + " ]";
    }
    
}
