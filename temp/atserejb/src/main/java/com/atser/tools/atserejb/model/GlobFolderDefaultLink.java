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

/*
@NamedQuery(name = "GlobFolderDefaultLink.findByParentId", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.parentId = :parentId"),
    @NamedQuery(name = "GlobFolderDefaultLink.findByAutoCreate", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.autoCreate = :autoCreate"),
    @NamedQuery(name = "GlobFolderDefaultLink.findByFLink", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.fLink = :fLink"),
    @NamedQuery(name = "GlobFolderDefaultLink.findByGroupNumber", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.groupNumber = :groupNumber"),
    @NamedQuery(name = "GlobFolderDefaultLink.findByParentTypeId", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.parentTypeId = :parentTypeId")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FOLDER_DEFAULT_LINK", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderDefaultLink.findAll", query = "SELECT g FROM GlobFolderDefaultLink g"),
    @NamedQuery(name = "GlobFolderDefaultLink.findById", query = "SELECT g FROM GlobFolderDefaultLink g WHERE g.id = :id")})
public class GlobFolderDefaultLink implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "AUTO_CREATE")
    private Character autoCreate;
    @Size(max = 1000)
    @Column(name = "F_LINK")
    private String fLink;
    @Column(name = "GROUP_NUMBER")
    private BigInteger groupNumber;
    @Column(name = "PARENT_TYPE_ID")
    private BigInteger parentTypeId;
    @JoinColumn(name = "CHILD_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobFolderDefault childId;

    public GlobFolderDefaultLink() {
    }

    public GlobFolderDefaultLink(BigDecimal id) {
        this.id = id;
    }

    public GlobFolderDefaultLink(BigDecimal id, BigInteger parentId) {
        this.id = id;
        this.parentId = parentId;
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

    public Character getAutoCreate() {
        return autoCreate;
    }

    public void setAutoCreate(Character autoCreate) {
        this.autoCreate = autoCreate;
    }

    public String getFLink() {
        return fLink;
    }

    public void setFLink(String fLink) {
        this.fLink = fLink;
    }

    public BigInteger getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(BigInteger groupNumber) {
        this.groupNumber = groupNumber;
    }

    public BigInteger getParentTypeId() {
        return parentTypeId;
    }

    public void setParentTypeId(BigInteger parentTypeId) {
        this.parentTypeId = parentTypeId;
    }

    public GlobFolderDefault getChildId() {
        return childId;
    }

    public void setChildId(GlobFolderDefault childId) {
        this.childId = childId;
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
        if (!(object instanceof GlobFolderDefaultLink)) {
            return false;
        }
        GlobFolderDefaultLink other = (GlobFolderDefaultLink) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderDefaultLink[ id=" + id + " ]";
    }
    
}
