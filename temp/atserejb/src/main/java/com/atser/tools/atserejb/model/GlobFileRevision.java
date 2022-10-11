/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.number.NumberSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
, @NamedQuery(name = "GlobFileRevision.findByFolderId", query = "SELECT g FROM GlobFileRevision g WHERE g.folderId = :folderId")
    , @NamedQuery(name = "GlobFileRevision.findByFDate", query = "SELECT g FROM GlobFileRevision g WHERE g.fDate = :fDate")
    , @NamedQuery(name = "GlobFileRevision.findByExtension", query = "SELECT g FROM GlobFileRevision g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobFileRevision.findBySourcePath", query = "SELECT g FROM GlobFileRevision g WHERE g.sourcePath = :sourcePath")
    , @NamedQuery(name = "GlobFileRevision.findByOwner", query = "SELECT g FROM GlobFileRevision g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobFileRevision.findByFTitle", query = "SELECT g FROM GlobFileRevision g WHERE g.fTitle = :fTitle")
    , @NamedQuery(name = "GlobFileRevision.findByFName", query = "SELECT g FROM GlobFileRevision g WHERE g.fName = :fName")
    , @NamedQuery(name = "GlobFileRevision.findByServerPath", query = "SELECT g FROM GlobFileRevision g WHERE g.serverPath = :serverPath")
    , @NamedQuery(name = "GlobFileRevision.findByProjectId", query = "SELECT g FROM GlobFileRevision g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobFileRevision.findBySourceName", query = "SELECT g FROM GlobFileRevision g WHERE g.sourceName = :sourceName")
    , @NamedQuery(name = "GlobFileRevision.findByKeywords", query = "SELECT g FROM GlobFileRevision g WHERE g.keywords = :keywords")
    , @NamedQuery(name = "GlobFileRevision.findByVersion", query = "SELECT g FROM GlobFileRevision g WHERE g.version = :version")
    , @NamedQuery(name = "GlobFileRevision.findByFSize", query = "SELECT g FROM GlobFileRevision g WHERE g.fSize = :fSize")
    , @NamedQuery(name = "GlobFileRevision.findByArchived", query = "SELECT g FROM GlobFileRevision g WHERE g.archived = :archived")
    , @NamedQuery(name = "GlobFileRevision.findBySystemKeywords", query = "SELECT g FROM GlobFileRevision g WHERE g.systemKeywords = :systemKeywords")
    , @NamedQuery(name = "GlobFileRevision.findByDcn", query = "SELECT g FROM GlobFileRevision g WHERE g.dcn = :dcn")
    , @NamedQuery(name = "GlobFileRevision.findByFFrom", query = "SELECT g FROM GlobFileRevision g WHERE g.fFrom = :fFrom")
    , @NamedQuery(name = "GlobFileRevision.findByFTo", query = "SELECT g FROM GlobFileRevision g WHERE g.fTo = :fTo")
    , @NamedQuery(name = "GlobFileRevision.findBySubject", query = "SELECT g FROM GlobFileRevision g WHERE g.subject = :subject")
    , @NamedQuery(name = "GlobFileRevision.findByDistributedTo", query = "SELECT g FROM GlobFileRevision g WHERE g.distributedTo = :distributedTo")
    , @NamedQuery(name = "GlobFileRevision.findByContractId", query = "SELECT g FROM GlobFileRevision g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobFileRevision.findByUploaded", query = "SELECT g FROM GlobFileRevision g WHERE g.uploaded = :uploaded")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE_REVISION", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFileRevision.findAll", query = "SELECT g FROM GlobFileRevision g"),
    @NamedQuery(name = "GlobFileRevision.findById", query = "SELECT g FROM GlobFileRevision g WHERE g.id = :id")})
public class GlobFileRevision implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_FILE_REVISION_ID_SEQ", sequenceName = "GLOB_FILE_REVISION_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_FILE_REVISION_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
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
    @Size(max = 255)
    @Column(name = "F_TITLE")
    private String fTitle;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Size(max = 4000)
    @Column(name = "SERVER_PATH")
    private String serverPath;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "SOURCE_NAME")
    private String sourceName;
    @Size(max = 4000)
    @Column(name = "KEYWORDS")
    private String keywords;
    @Column(name = "VERSION")
    private BigInteger version;
    @Column(name = "F_SIZE")
    private BigInteger fSize;
    @Column(name = "ARCHIVED", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date archived;
    @Size(max = 4000)
    @Column(name = "SYSTEM_KEYWORDS")
    private String systemKeywords;
    @Size(max = 10)
    @Column(name = "DCN")
    private String dcn;
    @Size(max = 128)
    @Column(name = "F_FROM")
    private String fFrom;
    @Size(max = 128)
    @Column(name = "F_TO")
    private String fTo;
    @Size(max = 256)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 256)
    @Column(name = "DISTRIBUTED_TO")
    private String distributedTo;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "CHECKOUT_ID")
    private BigInteger checkoutId;
    @Column(name = "CHECKOUT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutTime;
    @Column(name = "UPLOADED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;
    /*@Size(max = 20)
    @Column(name = "DESCRIPTION")
    private String description;*/
    @JoinColumn(name = "FILE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobFile fileId;

    public GlobFileRevision() {
    }

    public GlobFileRevision(GlobFile fileId) {
        if (fileId != null) {
            this.fileId = fileId;
            if (fileId.getFolderId() != null) {
                this.folderId = NumberSupport.getBigInteger(fileId.getFolderId().getId());
            }
            this.fDate = fileId.getFDate();
            this.extension = fileId.getExtension();
            this.sourcePath = fileId.getSourcePath();
            this.owner = fileId.getOwner();
            this.fTitle = fileId.getFTitle();
            this.fName = fileId.getFName();
            this.serverPath = fileId.getServerPath();
            this.projectId = fileId.getProjectId();
            this.sourceName = fileId.getSourceName();
            this.keywords = fileId.getKeywords();
            this.fSize = fileId.getFSize();
            this.systemKeywords = fileId.getSystemKeywords();
            this.dcn = fileId.getDcn();
            this.fFrom = fileId.getFFrom();
            this.fTo = fileId.getFTo();
            this.subject = fileId.getSubject();
            this.distributedTo = fileId.getDistributedTo();
            this.contractId = fileId.getContractId();
            this.uploaded = fileId.getUploaded();
            this.version = fileId.getVersion();
        }
    }

    public GlobFileRevision(BigDecimal id) {
        this.id = id;
    }

    public GlobFileRevision(BigDecimal id, BigInteger folderId) {
        this.id = id;
        this.folderId = folderId;
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

    public String getServerPath() {
        return serverPath;
    }

    public void setServerPath(String serverPath) {
        this.serverPath = serverPath;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getFSize() {
        return fSize;
    }

    public void setFSize(BigInteger fSize) {
        this.fSize = fSize;
    }

    public Date getArchived() {
        return archived;
    }

    public void setArchived(Date archived) {
        this.archived = archived;
    }

    public String getSystemKeywords() {
        return systemKeywords;
    }

    public void setSystemKeywords(String systemKeywords) {
        this.systemKeywords = systemKeywords;
    }

    public String getDcn() {
        return dcn;
    }

    public void setDcn(String dcn) {
        this.dcn = dcn;
    }

    public String getFFrom() {
        return fFrom;
    }

    public void setFFrom(String fFrom) {
        this.fFrom = fFrom;
    }

    public String getFTo() {
        return fTo;
    }

    public void setFTo(String fTo) {
        this.fTo = fTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDistributedTo() {
        return distributedTo;
    }

    public void setDistributedTo(String distributedTo) {
        this.distributedTo = distributedTo;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public GlobFile getFileId() {
        return fileId;
    }

    public void setFileId(GlobFile fileId) {
        this.fileId = fileId;
    }

    public BigInteger getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(BigInteger checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
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
        if (!(object instanceof GlobFileRevision)) {
            return false;
        }
        GlobFileRevision other = (GlobFileRevision) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFileRevision[ id=" + id + " ]";
    }

}
