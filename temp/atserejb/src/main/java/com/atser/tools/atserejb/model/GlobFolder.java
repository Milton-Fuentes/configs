/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobFolder.findByField1", query = "SELECT g FROM GlobFolder g WHERE g.field1 = :field1")
    , @NamedQuery(name = "GlobFolder.findByFDate", query = "SELECT g FROM GlobFolder g WHERE g.fDate = :fDate")
    , @NamedQuery(name = "GlobFolder.findByCreated", query = "SELECT g FROM GlobFolder g WHERE g.created = :created")
    , @NamedQuery(name = "GlobFolder.findByOwner", query = "SELECT g FROM GlobFolder g WHERE g.owner = :owner")
    , @NamedQuery(name = "GlobFolder.findByFName", query = "SELECT g FROM GlobFolder g WHERE g.fName = :fName")
    , @NamedQuery(name = "GlobFolder.findByDefaultId", query = "SELECT g FROM GlobFolder g WHERE g.defaultId = :defaultId")
    , @NamedQuery(name = "GlobFolder.findByFolderTypeId", query = "SELECT g FROM GlobFolder g WHERE g.folderTypeId = :folderTypeId")
    , @NamedQuery(name = "GlobFolder.findByFNumber", query = "SELECT g FROM GlobFolder g WHERE g.fNumber = :fNumber")
    , @NamedQuery(name = "GlobFolder.findByDefaultGroupNum", query = "SELECT g FROM GlobFolder g WHERE g.defaultGroupNum = :defaultGroupNum")
    , @NamedQuery(name = "GlobFolder.findByContractId", query = "SELECT g FROM GlobFolder g WHERE g.contractId = :contractId")
    , @NamedQuery(name = "GlobFolder.findByActive", query = "SELECT g FROM GlobFolder g WHERE g.active = :active")
    , @NamedQuery(name = "GlobFolder.findByReadOnly", query = "SELECT g FROM GlobFolder g WHERE g.readOnly = :readOnly")
    , @NamedQuery(name = "GlobFolder.findByFDateTmp", query = "SELECT g FROM GlobFolder g WHERE g.fDateTmp = :fDateTmp")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_FOLDER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_FOLDER SET ACTIVE = 'N',FIELD1 = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobFolder.findAll", query = "SELECT g FROM GlobFolder g"),
    @NamedQuery(name = "GlobFolder.findById", query = "SELECT g FROM GlobFolder g WHERE g.id = :id"),
    @NamedQuery(name = "GlobFolder.findByParentId", query = "SELECT g FROM GlobFolder g WHERE g.parentId = :parentId ORDER BY g.fDate ASC"),
    @NamedQuery(name = "GlobFolder.findByProjectId", query = "SELECT g FROM GlobFolder g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobFolder.findByFolderName", query = "SELECT g.id FROM GlobFolder g WHERE g.projectId = :projectId AND g.contractId = :contractId AND g.fName = :fName"),
    @NamedQuery(name = "GlobFolder.findByFolderNameAndParentId", query = "SELECT g.id FROM GlobFolder g WHERE g.projectId = :projectId AND g.contractId = :contractId AND g.fName = :fName AND g.parentId = :parentId"),
    @NamedQuery(name = "GlobFolder.findByFolderNameAndProjectId", query = "SELECT g.id FROM GlobFolder g WHERE g.projectId = :projectId AND g.fName = :fName"),
    @NamedQuery(name = "GlobFolder.findByFolderNameAndProjectParentId", query = "SELECT g.id FROM GlobFolder g WHERE g.projectId = :projectId AND g.fName = :fName AND g.parentId = :parentId"),
    @NamedQuery(name = "GlobFolder.findByFNameAndParentId", query = "SELECT g FROM GlobFolder g WHERE g.parentId = :parentId AND g.fName = :fName")})
public class GlobFolder implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_FOLDER_ID_SEQ", sequenceName = "GLOB_FOLDER_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_FOLDER_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Size(max = 50)
    @Column(name = "FIELD1")
    private String field1;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "PLAN_PROJECT_ID")
    private BigInteger planProjectId;
    @Column(name = "F_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fDate;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "OWNER")
    private BigInteger owner;
    @Size(max = 255)
    @Column(name = "F_NAME")
    private String fName;
    @Column(name = "DEFAULT_ID")
    private BigInteger defaultId;
    @Column(name = "FOLDER_TYPE_ID")
    private BigInteger folderTypeId;
    @Size(max = 512)
    @Column(name = "F_NUMBER")
    private String fNumber;
    @Column(name = "DEFAULT_GROUP_NUM")
    private BigInteger defaultGroupNum;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACTIVE", insertable = false, updatable = false)
    private Character active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "READ_ONLY")
    private Character readOnly;
    @Size(max = 4000)
    @Column(name = "F_DATE_TMP")
    private String fDateTmp;
    @Lob
    @Column(name = "METADATA")
    private String metadata;
    @Size(max = 1)
    @Column(name = "VISIBLE")
    private String visible;
    @Where(clause = "ACTIVE = 'Y'")
    @OneToMany(mappedBy = "folderId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GlobFile> globFileList;
    @OneToMany(mappedBy = "requestedFolderId")
    private List<GlobCorrespd> globCorrespdList;
    @Transient
    private BigInteger cantOfChild;

    public GlobFolder() {
    }

    public GlobFolder(BigDecimal id) {
        this.id = id;
    }

    public GlobFolder(BigDecimal id, Character active, Character readOnly) {
        this.id = id;
        this.active = active;
        this.readOnly = readOnly;
    }

    public String getFullName() {
        String fullName = "";
        if (StringSupport.isNotNullAndNotEmpty(fNumber)) {
            fullName += fNumber;
        }
        if (StringSupport.isNotNullAndNotEmpty(fName)) {
            if (!fullName.isEmpty()) {
                fullName += " ";
            }
            fullName += fName;
        }
        return fullName;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getPlanProjectId() {
        return planProjectId;
    }

    public void setPlanProjectId(BigInteger planProjectId) {
        this.planProjectId = planProjectId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    @JsonGetter(value = "fDate")
    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BigInteger getOwner() {
        return owner;
    }

    public void setOwner(BigInteger owner) {
        this.owner = owner;
    }

    @JsonGetter("fName")
    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public BigInteger getDefaultId() {
        return defaultId;
    }

    public void setDefaultId(BigInteger defaultId) {
        this.defaultId = defaultId;
    }

    public BigInteger getFolderTypeId() {
        return folderTypeId;
    }

    public void setFolderTypeId(BigInteger folderTypeId) {
        this.folderTypeId = folderTypeId;
    }

    @JsonGetter("fNumber")
    public String getFNumber() {
        return fNumber;
    }

    public void setFNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    public BigInteger getDefaultGroupNum() {
        return defaultGroupNum;
    }

    public void setDefaultGroupNum(BigInteger defaultGroupNum) {
        this.defaultGroupNum = defaultGroupNum;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Character readOnly) {
        this.readOnly = readOnly;
    }

    public String getFDateTmp() {
        return fDateTmp;
    }

    public void setFDateTmp(String fDateTmp) {
        this.fDateTmp = fDateTmp;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    @XmlTransient
    public List<GlobFile> getGlobFileList() {
        return globFileList;
    }

    public void setGlobFileList(List<GlobFile> globFileList) {
        this.globFileList = globFileList;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    @JsonGetter("cantOfChild")
    public BigInteger getCantOfChild() {
        return cantOfChild;
    }

    public void setCantOfChild(BigInteger cantOfChild) {
        this.cantOfChild = cantOfChild;
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
        if (!(object instanceof GlobFolder)) {
            return false;
        }
        GlobFolder other = (GlobFolder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobFolder[ id=" + id + " ]";
    }

    @XmlTransient
    public List<GlobCorrespd> getGlobCorrespdList() {
        return globCorrespdList;
    }

    public void setGlobCorrespdList(List<GlobCorrespd> globCorrespdList) {
        this.globCorrespdList = globCorrespdList;
    }

}
