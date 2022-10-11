/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobFile.findByField1", query = "SELECT g FROM GlobFile g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobFile.findByField2", query = "SELECT g FROM GlobFile g WHERE g.field2 = :field2")
    , @NamedQuery(name = "GlobFile.findByFDate", query = "SELECT g FROM GlobFile g WHERE g.fDate = :fDate")
    , @NamedQuery(name = "GlobFile.findByExtension", query = "SELECT g FROM GlobFile g WHERE g.extension = :extension")
    , @NamedQuery(name = "GlobFile.findBySourcePath", query = "SELECT g FROM GlobFile g WHERE g.sourcePath = :sourcePath")
    , @NamedQuery(name = "GlobFile.findByOwner", query = "SELECT g FROM GlobFile g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobFile.findByFTitle", query = "SELECT g FROM GlobFile g WHERE g.fTitle = :fTitle")
    , @NamedQuery(name = "GlobFile.findByFName", query = "SELECT g FROM GlobFile g WHERE g.fName = :fName")
    , @NamedQuery(name = "GlobFile.findByServerPath", query = "SELECT g FROM GlobFile g WHERE g.serverPath = :serverPath")
    , @NamedQuery(name = "GlobFile.findByProjectId", query = "SELECT g FROM GlobFile g WHERE g.projectId = :projectId")
    , @NamedQuery(name = "GlobFile.findBySourceName", query = "SELECT g FROM GlobFile g WHERE g.sourceName = :sourceName")
    , @NamedQuery(name = "GlobFile.findByKeywords", query = "SELECT g FROM GlobFile g WHERE g.keywords = :keywords")
    , @NamedQuery(name = "GlobFile.findByFSize", query = "SELECT g FROM GlobFile g WHERE g.fSize = :fSize")
    , @NamedQuery(name = "GlobFile.findByVersion", query = "SELECT g FROM GlobFile g WHERE g.version = :version")
    , @NamedQuery(name = "GlobFile.findByCheckoutId", query = "SELECT g FROM GlobFile g WHERE g.checkoutId = :checkoutId")
    , @NamedQuery(name = "GlobFile.findByCheckoutTime", query = "SELECT g FROM GlobFile g WHERE g.checkoutTime = :checkoutTime")
    , @NamedQuery(name = "GlobFile.findByFileStatus", query = "SELECT g FROM GlobFile g WHERE g.fileStatus = :fileStatus")
    , @NamedQuery(name = "GlobFile.findByDcn", query = "SELECT g FROM GlobFile g WHERE g.dcn = :dcn")
    , @NamedQuery(name = "GlobFile.findBySystemKeywords", query = "SELECT g FROM GlobFile g WHERE g.systemKeywords = :systemKeywords")
    , @NamedQuery(name = "GlobFile.findByFFrom", query = "SELECT g FROM GlobFile g WHERE g.fFrom = :fFrom")
    , @NamedQuery(name = "GlobFile.findByFTo", query = "SELECT g FROM GlobFile g WHERE g.fTo = :fTo")
    , @NamedQuery(name = "GlobFile.findBySubject", query = "SELECT g FROM GlobFile g WHERE g.subject = :subject")
    , @NamedQuery(name = "GlobFile.findByDistributedTo", query = "SELECT g FROM GlobFile g WHERE g.distributedTo = :distributedTo")
    , @NamedQuery(name = "GlobFile.findByContractId", query = "SELECT g FROM GlobFile g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobFile.findByUploaded", query = "SELECT g FROM GlobFile g WHERE g.uploaded = :uploaded")
    , @NamedQuery(name = "GlobFile.findByActive", query = "SELECT g FROM GlobFile g WHERE g.active = :active")
    , @NamedQuery(name = "GlobFile.findByFDateTmp", query = "SELECT g FROM GlobFile g WHERE g.fDateTmp = :fDateTmp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FILE", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_FILE SET ACTIVE = 'N',FIELD1 = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFile.findAll", query = "SELECT g FROM GlobFile g"),
    @NamedQuery(name = "GlobFile.findById", query = "SELECT g FROM GlobFile g WHERE g.id = :id"),
    @NamedQuery(name = "GlobFile.findByFolder", query = "SELECT g FROM GlobFile g WHERE g.folderId.id = :folderId ORDER BY g.id ASC")})
public class GlobFile implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_FILE_ID_SEQ", sequenceName = "GLOB_FILE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_FILE_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 50)
    @Column(name = "FIELD2")
    private String field2;
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
    @Size(max = 4000)
    @Column(name = "SYSTEM_PATH")
    private String systemPath;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Size(max = 255)
    @Column(name = "SOURCE_NAME")
    private String sourceName;
    @Size(max = 4000)
    @Column(name = "KEYWORDS")
    private String keywords;
    @Column(name = "F_SIZE")
    private BigInteger fSize;
    @Column(name = "VERSION")
    private BigInteger version;
    @Column(name = "CHECKOUT_ID")
    private BigInteger checkoutId;
    @Column(name = "CHECKOUT_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkoutTime;
    @Size(max = 50)
    @Column(name = "FILE_STATUS")
    private String fileStatus;
    @Size(max = 10)
    @Column(name = "DCN")
    private String dcn;
    @Size(max = 4000)
    @Column(name = "SYSTEM_KEYWORDS")
    private String systemKeywords;
    @Size(max = 128)
    @Column(name = "F_FROM")
    private String fFrom;
    @Size(max = 128)
    @Column(name = "F_TO")
    private String fTo;
    @Size(max = 1000)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 2000)
    @Column(name = "DISTRIBUTED_TO")
    private String distributedTo;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "UPLOADED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date uploaded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE", insertable = false, updatable = false)
    private Character active;
    @Size(max = 4000)
    @Column(name = "F_DATE_TMP")
    private String fDateTmp;
    @JoinColumn(name = "FOLDER_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobFolder folderId;
    /*@Lob
    @Column(name = "METADATA")
    private String metadata;*/
    //@OneToMany(mappedBy = "fileId")
    // private List<GlobCorrespd> globCorrespdList;

    @JoinColumn(name = "CORRESPD_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GlobCorrespd correspdId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fileId", fetch = FetchType.LAZY)
    private List<GlobFileRevision> globFileRevisionList;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 50)
    @Column(name = "FIELD4")
    private String field4;
    @Size(max = 50)
    @Column(name = "FIELD5")
    private String field5;
    @Size(max = 50)
    @Column(name = "FIELD6")
    private String field6;
    @Column(name = "PLAN_PROJECT_ID")
    private BigInteger planProjectId;

    public GlobFile() {

    }

    public GlobFile(BigDecimal id) {
        this.id = id;
    }

    public GlobFile(BigDecimal id, Character active) {
        this.id = id;
        this.active = active;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @JsonGetter("fDate")
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

    @JsonGetter("fTitle")
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

    public String getSystemPath() {
        return systemPath;
    }

    public void setSystemPath(String systemPath) {
        this.systemPath = systemPath;
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

    @JsonGetter("fSize")
    public BigInteger getFSize() {
        return fSize;
    }

    public void setFSize(BigInteger fSize) {
        this.fSize = fSize;
    }

    public BigInteger getVersion() {
        return version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    public BigInteger getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(BigInteger checkoutId) {
        this.checkoutId = checkoutId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(Date checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }

    public String getDcn() {
        return dcn;
    }

    public void setDcn(String dcn) {
        this.dcn = dcn;
    }

    public String getSystemKeywords() {
        return systemKeywords;
    }

    public void setSystemKeywords(String systemKeywords) {
        this.systemKeywords = systemKeywords;
    }

    @JsonGetter("fFrom")
    public String getFFrom() {
        return fFrom;
    }

    public void setFFrom(String fFrom) {
        this.fFrom = fFrom;
    }

    @JsonGetter("fTo")
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getFDateTmp() {
        return fDateTmp;
    }

    public void setFDateTmp(String fDateTmp) {
        this.fDateTmp = fDateTmp;
    }

    public GlobFolder getFolderId() {
        return folderId;
    }

    public void setFolderId(GlobFolder folderId) {
        this.folderId = folderId;
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
        if (!(object instanceof GlobFile)) {
            return false;
        }
        GlobFile other = (GlobFile) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFile[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobFileRevision> getGlobFileRevisionList() {
        return globFileRevisionList;
    }

    public void setGlobFileRevisionList(List<GlobFileRevision> globFileRevisionList) {
        this.globFileRevisionList = globFileRevisionList;
    }

//    @XmlTransient
//    public List<GlobCorrespd> getGlobCorrespdList() {
//        return globCorrespdList;
//    }
//
//    public void setGlobCorrespdList(List<GlobCorrespd> globCorrespdList) {
//        this.globCorrespdList = globCorrespdList;
//    }
    public GlobCorrespd getCorrespdId() {
        return correspdId;
    }

    public void setCorrespdId(GlobCorrespd correspdId) {
        this.correspdId = correspdId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public BigInteger getPlanProjectId() {
        return planProjectId;
    }

    public void setPlanProjectId(BigInteger planProjectId) {
        this.planProjectId = planProjectId;
    }

    @Override
    public GlobFile clone() {
        try {
            return (GlobFile) super.clone();
        } catch (CloneNotSupportedException e) {
            return new GlobFile(this.getId());
        }
    }

}
