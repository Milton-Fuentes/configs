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
@Table(name = "GLOB_FILE_EXTENSION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileExtension.findAll", query = "SELECT g FROM GlobFileExtension g")
    , @NamedQuery(name = "GlobFileExtension.findById", query = "SELECT g FROM GlobFileExtension g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileExtension.findByExtension", query = "SELECT g FROM GlobFileExtension g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobFileExtension.findByIconFile", query = "SELECT g FROM GlobFileExtension g WHERE g.iconFile = :iconFile")
    , @NamedQuery(name = "GlobFileExtension.findByContentType", query = "SELECT g FROM GlobFileExtension g WHERE g.contentType = :contentType")
    , @NamedQuery(name = "GlobFileExtension.findByInSearchList", query = "SELECT g FROM GlobFileExtension g WHERE g.inSearchList = :inSearchList")})
public class GlobFileExtension implements Serializable {

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
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 50)
    @Column(name = "ICON_FILE")
    private String iconFile;
    @Size(max = 50)
    @Column(name = "CONTENT_TYPE")
    private String contentType;
    @Size(max = 1)
    @Column(name = "IN_SEARCH_LIST")
    private String inSearchList;

    public GlobFileExtension() {
    }

    public GlobFileExtension(BigDecimal id) {
        this.id = id;
    }

    public GlobFileExtension(BigDecimal id, String extension) {
        this.id = id;
        this.extension = extension;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getIconFile() {
        return iconFile;
    }

    public void setIconFile(String iconFile) {
        this.iconFile = iconFile;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getInSearchList() {
        return inSearchList;
    }

    public void setInSearchList(String inSearchList) {
        this.inSearchList = inSearchList;
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
        if (!(object instanceof GlobFileExtension)) {
            return false;
        }
        GlobFileExtension other = (GlobFileExtension) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileExtension[ id=" + id + " ]";
    }
    
}
