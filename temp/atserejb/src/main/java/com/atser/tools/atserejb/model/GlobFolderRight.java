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

/*
, @NamedQuery(name = "GlobFolderRight.findByFolderId", query = "SELECT g FROM GlobFolderRight g WHERE g.folderId = :folderId")
    , @NamedQuery(name = "GlobFolderRight.findByTrusteeType", query = "SELECT g FROM GlobFolderRight g WHERE g.trusteeType = :trusteeType")
    , @NamedQuery(name = "GlobFolderRight.findByTrusteeId", query = "SELECT g FROM GlobFolderRight g WHERE g.trusteeId = :trusteeId")
    , @NamedQuery(name = "GlobFolderRight.findByRDelete", query = "SELECT g FROM GlobFolderRight g WHERE g.rDelete = :rDelete")
    , @NamedQuery(name = "GlobFolderRight.findByRUpload", query = "SELECT g FROM GlobFolderRight g WHERE g.rUpload = :rUpload")
    , @NamedQuery(name = "GlobFolderRight.findByRBrowse", query = "SELECT g FROM GlobFolderRight g WHERE g.rBrowse = :rBrowse")
    , @NamedQuery(name = "GlobFolderRight.findByRDnload", query = "SELECT g FROM GlobFolderRight g WHERE g.rDnload = :rDnload")
    , @NamedQuery(name = "GlobFolderRight.findByRCreate", query = "SELECT g FROM GlobFolderRight g WHERE g.rCreate = :rCreate")
    , @NamedQuery(name = "GlobFolderRight.findByRModify", query = "SELECT g FROM GlobFolderRight g WHERE g.rModify = :rModify")
    , @NamedQuery(name = "GlobFolderRight.findByROwner", query = "SELECT g FROM GlobFolderRight g WHERE g.rOwner = :rOwner")
    , @NamedQuery(name = "GlobFolderRight.findBySystem", query = "SELECT g FROM GlobFolderRight g WHERE g.system = :system")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FOLDER_RIGHT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderRight.findAll", query = "SELECT g FROM GlobFolderRight g")
    , @NamedQuery(name = "GlobFolderRight.findById", query = "SELECT g FROM GlobFolderRight g WHERE g.id = :id")})
public class GlobFolderRight implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "TRUSTEE_TYPE")
    private BigInteger trusteeType;
    @Column(name = "TRUSTEE_ID")
    private BigInteger trusteeId;
    @Column(name = "R_DELETE")
    private Character rDelete;
    @Column(name = "R_UPLOAD")
    private Character rUpload;
    @Column(name = "R_BROWSE")
    private Character rBrowse;
    @Column(name = "R_DNLOAD")
    private Character rDnload;
    @Column(name = "R_CREATE")
    private Character rCreate;
    @Column(name = "R_MODIFY")
    private Character rModify;
    @Column(name = "R_OWNER")
    private Character rOwner;
    @Column(name = "SYSTEM")
    private Character system;

    public GlobFolderRight() {
    }

    public GlobFolderRight(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    public BigInteger getTrusteeType() {
        return trusteeType;
    }

    public void setTrusteeType(BigInteger trusteeType) {
        this.trusteeType = trusteeType;
    }

    public BigInteger getTrusteeId() {
        return trusteeId;
    }

    public void setTrusteeId(BigInteger trusteeId) {
        this.trusteeId = trusteeId;
    }

    public Character getRDelete() {
        return rDelete;
    }

    public void setRDelete(Character rDelete) {
        this.rDelete = rDelete;
    }

    public Character getRUpload() {
        return rUpload;
    }

    public void setRUpload(Character rUpload) {
        this.rUpload = rUpload;
    }

    public Character getRBrowse() {
        return rBrowse;
    }

    public void setRBrowse(Character rBrowse) {
        this.rBrowse = rBrowse;
    }

    public Character getRDnload() {
        return rDnload;
    }

    public void setRDnload(Character rDnload) {
        this.rDnload = rDnload;
    }

    public Character getRCreate() {
        return rCreate;
    }

    public void setRCreate(Character rCreate) {
        this.rCreate = rCreate;
    }

    public Character getRModify() {
        return rModify;
    }

    public void setRModify(Character rModify) {
        this.rModify = rModify;
    }

    public Character getROwner() {
        return rOwner;
    }

    public void setROwner(Character rOwner) {
        this.rOwner = rOwner;
    }

    public Character getSystem() {
        return system;
    }

    public void setSystem(Character system) {
        this.system = system;
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
        if (!(object instanceof GlobFolderRight)) {
            return false;
        }
        GlobFolderRight other = (GlobFolderRight) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderRight[ id=" + id + " ]";
    }
    
}
