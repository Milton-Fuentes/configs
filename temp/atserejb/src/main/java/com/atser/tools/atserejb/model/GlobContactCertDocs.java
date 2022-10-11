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

/*
, @NamedQuery(name = "GlobContactCertDocs.findByContactCertId", query = "SELECT g FROM GlobContactCertDocs g WHERE g.contactCertId = :contactCertId")
    , @NamedQuery(name = "GlobContactCertDocs.findBySourcePath", query = "SELECT g FROM GlobContactCertDocs g WHERE g.sourcePath = :sourcePath")
    , @NamedQuery(name = "GlobContactCertDocs.findByFTitle", query = "SELECT g FROM GlobContactCertDocs g WHERE g.fTitle = :fTitle")
    , @NamedQuery(name = "GlobContactCertDocs.findByExtension", query = "SELECT g FROM GlobContactCertDocs g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobContactCertDocs.findByFName", query = "SELECT g FROM GlobContactCertDocs g WHERE g.fName = :fName")
    , @NamedQuery(name = "GlobContactCertDocs.findByNote1", query = "SELECT g FROM GlobContactCertDocs g WHERE g.note1 = :note1")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTACT_CERT_DOCS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContactCertDocs.findAll", query = "SELECT g FROM GlobContactCertDocs g"),
    @NamedQuery(name = "GlobContactCertDocs.findById", query = "SELECT g FROM GlobContactCertDocs g WHERE g.id = :id")})
public class GlobContactCertDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACT_CERT_ID")
    private BigInteger contactCertId;
    @Size(max = 255)
    @Column(name = "SOURCE_PATH")
    private String sourcePath;
    @Size(max = 255)
    @Column(name = "F_TITLE")
    private String fTitle;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 4000)
    @Column(name = "NOTE1")
    private String note1;

    public GlobContactCertDocs() {
    }

    public GlobContactCertDocs(BigDecimal id) {
        this.id = id;
    }

    public GlobContactCertDocs(BigDecimal id, BigInteger contactCertId) {
        this.id = id;
        this.contactCertId = contactCertId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContactCertId() {
        return contactCertId;
    }

    public void setContactCertId(BigInteger contactCertId) {
        this.contactCertId = contactCertId;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFTitle() {
        return fTitle;
    }

    public void setFTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
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
        if (!(object instanceof GlobContactCertDocs)) {
            return false;
        }
        GlobContactCertDocs other = (GlobContactCertDocs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContactCertDocs[ id=" + id + " ]";
    }

}
