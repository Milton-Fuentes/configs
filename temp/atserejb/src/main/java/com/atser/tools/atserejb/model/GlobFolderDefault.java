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
@Table(name = "GLOB_FOLDER_DEFAULT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolderDefault.findAll", query = "SELECT g FROM GlobFolderDefault g"),
    @NamedQuery(name = "GlobFolderDefault.findById", query = "SELECT g FROM GlobFolderDefault g WHERE g.id = :id"),
    @NamedQuery(name = "GlobFolderDefault.findByFName", query = "SELECT g FROM GlobFolderDefault g WHERE g.fName = :fName"),
    @NamedQuery(name = "GlobFolderDefault.findByDescription", query = "SELECT g FROM GlobFolderDefault g WHERE g.description = :description"),
    @NamedQuery(name = "GlobFolderDefault.findByFCode", query = "SELECT g FROM GlobFolderDefault g WHERE g.fCode = :fCode"),
    @NamedQuery(name = "GlobFolderDefault.findByFNumber", query = "SELECT g FROM GlobFolderDefault g WHERE g.fNumber = :fNumber"),
    @NamedQuery(name = "GlobFolderDefault.findByNofilesHidden", query = "SELECT g FROM GlobFolderDefault g WHERE g.nofilesHidden = :nofilesHidden")})
public class GlobFolderDefault implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 512)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 512)
    @Column(name = "F_CODE")
    private String fCode;
    @Size(max = 512)
    @Column(name = "F_NUMBER")
    private String fNumber;
    @Column(name = "NOFILES_HIDDEN")
    private Character nofilesHidden;

    public GlobFolderDefault() {
    }

    public GlobFolderDefault(BigDecimal id) {
        this.id = id;
    }

    public GlobFolderDefault(BigDecimal id, String fName) {
        this.id = id;
        this.fName = fName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFCode() {
        return fCode;
    }

    public void setFCode(String fCode) {
        this.fCode = fCode;
    }

    public String getFNumber() {
        return fNumber;
    }

    public void setFNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public Character getNofilesHidden() {
        return nofilesHidden;
    }

    public void setNofilesHidden(Character nofilesHidden) {
        this.nofilesHidden = nofilesHidden;
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
        if (!(object instanceof GlobFolderDefault)) {
            return false;
        }
        GlobFolderDefault other = (GlobFolderDefault) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolderDefault[ id=" + id + " ]";
    }

}
