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
@Table(name = "CM_TI_FOLDER_MAP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmTiFolderMap.findAll", query = "SELECT c FROM CmTiFolderMap c"),
    @NamedQuery(name = "CmTiFolderMap.findById", query = "SELECT c FROM CmTiFolderMap c WHERE c.id = :id"),
    @NamedQuery(name = "CmTiFolderMap.findByCmTypeName", query = "SELECT c FROM CmTiFolderMap c WHERE c.cmTypeName = :cmTypeName"),
    @NamedQuery(name = "CmTiFolderMap.findByTiDefaultId", query = "SELECT c FROM CmTiFolderMap c WHERE c.tiDefaultId = :tiDefaultId"),
    @NamedQuery(name = "CmTiFolderMap.findByTiParentId", query = "SELECT c FROM CmTiFolderMap c WHERE c.tiParentId = :tiParentId"),
    @NamedQuery(name = "CmTiFolderMap.findByTiDefaultGroupNum", query = "SELECT c FROM CmTiFolderMap c WHERE c.tiDefaultGroupNum = :tiDefaultGroupNum"),
    @NamedQuery(name = "CmTiFolderMap.findByCmFncId", query = "SELECT c FROM CmTiFolderMap c WHERE c.cmFncId = :cmFncId")})
public class CmTiFolderMap implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CM_TYPE_NAME")
    private String cmTypeName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TI_DEFAULT_ID")
    private BigInteger tiDefaultId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TI_PARENT_ID")
    private BigInteger tiParentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TI_DEFAULT_GROUP_NUM")
    private BigInteger tiDefaultGroupNum;
    @Column(name = "CM_FNC_ID")
    private BigInteger cmFncId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;

    public CmTiFolderMap() {
    }

    public CmTiFolderMap(BigDecimal id) {
        this.id = id;
    }

    public CmTiFolderMap(BigDecimal id, String cmTypeName, BigInteger tiDefaultId, BigInteger tiParentId, BigInteger tiDefaultGroupNum) {
        this.id = id;
        this.cmTypeName = cmTypeName;
        this.tiDefaultId = tiDefaultId;
        this.tiParentId = tiParentId;
        this.tiDefaultGroupNum = tiDefaultGroupNum;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCmTypeName() {
        return cmTypeName;
    }

    public void setCmTypeName(String cmTypeName) {
        this.cmTypeName = cmTypeName;
    }

    public BigInteger getTiDefaultId() {
        return tiDefaultId;
    }

    public void setTiDefaultId(BigInteger tiDefaultId) {
        this.tiDefaultId = tiDefaultId;
    }

    public BigInteger getTiParentId() {
        return tiParentId;
    }

    public void setTiParentId(BigInteger tiParentId) {
        this.tiParentId = tiParentId;
    }

    public BigInteger getTiDefaultGroupNum() {
        return tiDefaultGroupNum;
    }

    public void setTiDefaultGroupNum(BigInteger tiDefaultGroupNum) {
        this.tiDefaultGroupNum = tiDefaultGroupNum;
    }

    public BigInteger getCmFncId() {
        return cmFncId;
    }

    public void setCmFncId(BigInteger cmFncId) {
        this.cmFncId = cmFncId;
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
        if (!(object instanceof CmTiFolderMap)) {
            return false;
        }
        CmTiFolderMap other = (CmTiFolderMap) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmTiFolderMap[ id=" + id + " ]";
    }
    
}
