/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
@NamedQuery(name = "CmFormAttach.findByFTitle", query = "SELECT c FROM CmFormAttach c WHERE c.fTitle = :fTitle"),
    @NamedQuery(name = "CmFormAttach.findByFName", query = "SELECT c FROM CmFormAttach c WHERE c.fName = :fName"),
    @NamedQuery(name = "CmFormAttach.findByFDate", query = "SELECT c FROM CmFormAttach c WHERE c.fDate = :fDate"),
    @NamedQuery(name = "CmFormAttach.findByExtension", query = "SELECT c FROM CmFormAttach c WHERE c.extension = :extension"),
    @NamedQuery(name = "CmFormAttach.findBySourcePath", query = "SELECT c FROM CmFormAttach c WHERE c.sourcePath = :sourcePath"),
    @NamedQuery(name = "CmFormAttach.findByOwner", query = "SELECT c FROM CmFormAttach c WHERE c.owner = :owner")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_FORM_ATTACH", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmFormAttach.findAll", query = "SELECT c FROM CmFormAttach c"),
    @NamedQuery(name = "CmFormAttach.findById", query = "SELECT c FROM CmFormAttach c WHERE c.id = :id")})
public class CmFormAttach implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "F_TITLE")
    private String fTitle;
    @Size(max = 50)
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "F_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Size(max = 10)
    @Column(name = "EXTENSION")
    private String extension;
    @Size(max = 250)
    @Column(name = "SOURCE_PATH")
    private String sourcePath;
    @Column(name = "OWNER")
    private BigInteger owner;
    @JoinColumn(name = "CM_FORM_ID", referencedColumnName = "ID")
    @ManyToOne
    private CmForm cmFormId;

    public CmFormAttach() {
    }

    public CmFormAttach(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFTitle() {
        return fTitle;
    }

    public void setFTitle(String fTitle) {
        this.fTitle = fTitle;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    public CmForm getCmFormId() {
        return cmFormId;
    }

    public void setCmFormId(CmForm cmFormId) {
        this.cmFormId = cmFormId;
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
        if (!(object instanceof CmFormAttach)) {
            return false;
        }
        CmFormAttach other = (CmFormAttach) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmFormAttach[ id=" + id + " ]";
    }
    
}
