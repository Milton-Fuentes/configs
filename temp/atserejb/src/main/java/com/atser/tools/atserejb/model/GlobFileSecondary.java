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
@Table(name = "GLOB_FILE_SECONDARY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileSecondary.findAll", query = "SELECT g FROM GlobFileSecondary g")
    , @NamedQuery(name = "GlobFileSecondary.findById", query = "SELECT g FROM GlobFileSecondary g WHERE g.id = :id")
    , @NamedQuery(name = "GlobFileSecondary.findByFileId", query = "SELECT g FROM GlobFileSecondary g WHERE g.fileId = :fileId")
    , @NamedQuery(name = "GlobFileSecondary.findByFName", query = "SELECT g FROM GlobFileSecondary g WHERE g.fName = :fName")
    , @NamedQuery(name = "GlobFileSecondary.findByExtension", query = "SELECT g FROM GlobFileSecondary g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobFileSecondary.findByServerPath", query = "SELECT g FROM GlobFileSecondary g WHERE g.serverPath = :serverPath")
    , @NamedQuery(name = "GlobFileSecondary.findByStatus", query = "SELECT g FROM GlobFileSecondary g WHERE g.status = :status")})
public class GlobFileSecondary implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "FILE_ID")
    private BigInteger fileId;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 255)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 255)
    @Column(name = "SERVER_PATH")
    private String serverPath;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;

    public GlobFileSecondary() {
    }

    public GlobFileSecondary(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        if (!(object instanceof GlobFileSecondary)) {
            return false;
        }
        GlobFileSecondary other = (GlobFileSecondary) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileSecondary[ id=" + id + " ]";
    }
    
}
