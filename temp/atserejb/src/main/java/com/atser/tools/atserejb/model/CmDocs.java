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
, @NamedQuery(name = "CmDocs.findByDocId", query = "SELECT c FROM CmDocs c WHERE c.docId = :docId")
    , @NamedQuery(name = "CmDocs.findByCmTypeName", query = "SELECT c FROM CmDocs c WHERE c.cmTypeName = :cmTypeName")
    , @NamedQuery(name = "CmDocs.findBySourcePath", query = "SELECT c FROM CmDocs c WHERE c.sourcePath = :sourcePath")
    , @NamedQuery(name = "CmDocs.findByFTitle", query = "SELECT c FROM CmDocs c WHERE c.fTitle = :fTitle")
    , @NamedQuery(name = "CmDocs.findByExtension", query = "SELECT c FROM CmDocs c WHERE c.extension = :extension")
    , @NamedQuery(name = "CmDocs.findByFName", query = "SELECT c FROM CmDocs c WHERE c.fName = :fName")
    , @NamedQuery(name = "CmDocs.findByNote1", query = "SELECT c FROM CmDocs c WHERE c.note1 = :note1")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_DOCS", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmDocs.findAll", query = "SELECT c FROM CmDocs c")
    , @NamedQuery(name = "CmDocs.findById", query = "SELECT c FROM CmDocs c WHERE c.id = :id")})
public class CmDocs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DOC_ID")
    private BigInteger docId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CM_TYPE_NAME")
    private String cmTypeName;
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

    public CmDocs() {
    }

    public CmDocs(BigDecimal id) {
        this.id = id;
    }

    public CmDocs(BigDecimal id, String cmTypeName) {
        this.id = id;
        this.cmTypeName = cmTypeName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getDocId() {
        return docId;
    }

    public void setDocId(BigInteger docId) {
        this.docId = docId;
    }

    public String getCmTypeName() {
        return cmTypeName;
    }

    public void setCmTypeName(String cmTypeName) {
        this.cmTypeName = cmTypeName;
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
        if (!(object instanceof CmDocs)) {
            return false;
        }
        CmDocs other = (CmDocs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmDocs[ id=" + id + " ]";
    }
    
}
