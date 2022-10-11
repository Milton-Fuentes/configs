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
@Table(name = "GLOB_FOLDER_TYPE", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderType.findAll", query = "SELECT g FROM GlobFolderType g")
    , @NamedQuery(name = "GlobFolderType.findById", query = "SELECT g FROM GlobFolderType g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFolderType.findByEntityName", query = "SELECT g FROM GlobFolderType g WHERE g.entityName = :entityName")
    , @NamedQuery(name = "GlobFolderType.findByEntityType", query = "SELECT g FROM GlobFolderType g WHERE g.entityType = :entityType")
    , @NamedQuery(name = "GlobFolderType.findByFolderType", query = "SELECT g FROM GlobFolderType g WHERE g.folderType = :folderType")
    , @NamedQuery(name = "GlobFolderType.findByDefaultGroupNum", query = "SELECT g FROM GlobFolderType g WHERE g.defaultGroupNum = :defaultGroupNum")})
public class GlobFolderType implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 512)
    @Column(name = "ENTITY_NAME")
    private String entityName;
    @Size(max = 50)
    @Column(name = "ENTITY_TYPE")
    private String entityType;
    @Size(max = 256)
    @Column(name = "FOLDER_TYPE")
    private String folderType;
    @Column(name = "DEFAULT_GROUP_NUM")
    private BigInteger defaultGroupNum;
    @JoinColumn(name = "CLIENT_ID", referencedColumnName = "ID")
    @ManyToOne
    private GlobClient clientId;

    public GlobFolderType() {
    }

    public GlobFolderType(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getFolderType() {
        return folderType;
    }

    public void setFolderType(String folderType) {
        this.folderType = folderType;
    }

    public BigInteger getDefaultGroupNum() {
        return defaultGroupNum;
    }

    public void setDefaultGroupNum(BigInteger defaultGroupNum) {
        this.defaultGroupNum = defaultGroupNum;
    }

    public GlobClient getClientId() {
        return clientId;
    }

    public void setClientId(GlobClient clientId) {
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
        if (!(object instanceof GlobFolderType)) {
            return false;
        }
        GlobFolderType other = (GlobFolderType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderType[ id=" + id + " ]";
    }
    
}
