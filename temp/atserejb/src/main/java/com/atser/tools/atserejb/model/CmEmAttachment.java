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
, @NamedQuery(name = "CmEmAttachment.findByEmailId", query = "SELECT c FROM CmEmAttachment c WHERE c.emailId = :emailId")
    , @NamedQuery(name = "CmEmAttachment.findBySourcePath", query = "SELECT c FROM CmEmAttachment c WHERE c.sourcePath = :sourcePath")
    , @NamedQuery(name = "CmEmAttachment.findByFileTitle", query = "SELECT c FROM CmEmAttachment c WHERE c.fileTitle = :fileTitle")
    , @NamedQuery(name = "CmEmAttachment.findByFileExtension", query = "SELECT c FROM CmEmAttachment c WHERE c.fileExtension = :fileExtension")
    , @NamedQuery(name = "CmEmAttachment.findByFName", query = "SELECT c FROM CmEmAttachment c WHERE c.fName = :fName")
    , @NamedQuery(name = "CmEmAttachment.findByStatus", query = "SELECT c FROM CmEmAttachment c WHERE c.status = :status")
    , @NamedQuery(name = "CmEmAttachment.findByServerPath", query = "SELECT c FROM CmEmAttachment c WHERE c.serverPath = :serverPath")
    , @NamedQuery(name = "CmEmAttachment.findByReferId", query = "SELECT c FROM CmEmAttachment c WHERE c.referId = :referId")
    , @NamedQuery(name = "CmEmAttachment.findByFileSize", query = "SELECT c FROM CmEmAttachment c WHERE c.fileSize = :fileSize")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_EM_ATTACHMENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmEmAttachment.findAll", query = "SELECT c FROM CmEmAttachment c")
    , @NamedQuery(name = "CmEmAttachment.findById", query = "SELECT c FROM CmEmAttachment c WHERE c.id = :id")})
public class CmEmAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EMAIL_ID")
    private BigInteger emailId;
    @Size(max = 500)
    @Column(name = "SOURCE_PATH")
    private String sourcePath;
    @Size(max = 100)
    @Column(name = "FILE_TITLE")
    private String fileTitle;
    @Size(max = 50)
    @Column(name = "FILE_EXTENSION")
    private String fileExtension;
    @Size(max = 100)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 4000)
    @Column(name = "SERVER_PATH")
    private String serverPath;
    @Column(name = "REFER_ID")
    private BigInteger referId;
    @Column(name = "FILE_SIZE")
    private BigInteger fileSize;

    public CmEmAttachment() {
    }

    public CmEmAttachment(BigDecimal id) {
        this.id = id;
    }

    public CmEmAttachment(BigDecimal id, BigInteger emailId) {
        this.id = id;
        this.emailId = emailId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getEmailId() {
        return emailId;
    }

    public void setEmailId(BigInteger emailId) {
        this.emailId = emailId;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public BigInteger getReferId() {
        return referId;
    }

    public void setReferId(BigInteger referId) {
        this.referId = referId;
    }

    public BigInteger getFileSize() {
        return fileSize;
    }

    public void setFileSize(BigInteger fileSize) {
        this.fileSize = fileSize;
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
        if (!(object instanceof CmEmAttachment)) {
            return false;
        }
        CmEmAttachment other = (CmEmAttachment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmEmAttachment[ id=" + id + " ]";
    }
    
}
