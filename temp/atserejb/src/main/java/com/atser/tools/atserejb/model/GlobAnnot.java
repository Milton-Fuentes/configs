/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "GlobAnnot.findByUserId", query = "SELECT g FROM GlobAnnot g WHERE g.userId = :userId"),
    @NamedQuery(name = "GlobAnnot.findByClientId", query = "SELECT g FROM GlobAnnot g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobAnnot.findByProjectId", query = "SELECT g FROM GlobAnnot g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobAnnot.findByContractId", query = "SELECT g FROM GlobAnnot g WHERE g.contractId = :contractId"),
    @NamedQuery(name = "GlobAnnot.findByFileId", query = "SELECT g FROM GlobAnnot g WHERE g.fileId = :fileId"),
    @NamedQuery(name = "GlobAnnot.findByLastEditedTime", query = "SELECT g FROM GlobAnnot g WHERE g.lastEditedTime = :lastEditedTime"),
    @NamedQuery(name = "GlobAnnot.findByCreateDate", query = "SELECT g FROM GlobAnnot g WHERE g.createDate = :createDate"),
    @NamedQuery(name = "GlobAnnot.findByModifyDate", query = "SELECT g FROM GlobAnnot g WHERE g.modifyDate = :modifyDate"),
    @NamedQuery(name = "GlobAnnot.findByRemarks", query = "SELECT g FROM GlobAnnot g WHERE g.remarks = :remarks"),
    @NamedQuery(name = "GlobAnnot.findBySubject", query = "SELECT g FROM GlobAnnot g WHERE g.subject = :subject"),
    @NamedQuery(name = "GlobAnnot.findByTitle", query = "SELECT g FROM GlobAnnot g WHERE g.title = :title"),
    @NamedQuery(name = "GlobAnnot.findByType", query = "SELECT g FROM GlobAnnot g WHERE g.type = :type"),
    @NamedQuery(name = "GlobAnnot.findBySubType", query = "SELECT g FROM GlobAnnot g WHERE g.subType = :subType"),
    @NamedQuery(name = "GlobAnnot.findByActive", query = "SELECT g FROM GlobAnnot g WHERE g.active = :active"),
    @NamedQuery(name = "GlobAnnot.findByVersion", query = "SELECT g FROM GlobAnnot g WHERE g.version = :version"),
    @NamedQuery(name = "GlobAnnot.findByPageNumber", query = "SELECT g FROM GlobAnnot g WHERE g.pageNumber = :pageNumber"),
    @NamedQuery(name = "GlobAnnot.findByName", query = "SELECT g FROM GlobAnnot g WHERE g.name = :name")
 */
/**
 *
 * @author dperez
 */
@Entity
@Table(name = "GLOB_ANNOT", catalog = "", schema = "ORACLE")
@Where(clause = "ACTIVE = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobAnnot.findAll", query = "SELECT g FROM GlobAnnot g"),
    @NamedQuery(name = "GlobAnnot.findById", query = "SELECT g FROM GlobAnnot g WHERE g.id = :id")
})
public class GlobAnnot implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "GLOB_ANNOT_SEQ", sequenceName = "GLOB_ANNOT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_ANNOT_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "USER_ID")
    private BigInteger userId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "FILE_ID")
    private BigInteger fileId;
    @Column(name = "LAST_EDITED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastEditedTime;
    @Column(name = "CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 250)
    @Column(name = "SUBJECT")
    private String subject;
    @Size(max = 100)
    @Column(name = "TITLE")
    private String title;
    @Size(max = 100)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 100)
    @Column(name = "SUB_TYPE")
    private String subType;
    @Size(max = 1)
    @Column(name = "ACTIVE")
    private String active;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @JsonSkipXssSerialization
    @Lob
    @Column(name = "DATA_OBJ")
    private String dataObj;
    @Column(name = "PAGE_NUMBER")
    private BigInteger pageNumber;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    public GlobAnnot() {
    }

    public GlobAnnot(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDataObj() {
        return dataObj;
    }

    public void setDataObj(String dataObj) {
        this.dataObj = dataObj;
    }

    public BigInteger getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(BigInteger pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof GlobAnnot)) {
            return false;
        }
        GlobAnnot other = (GlobAnnot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobAnnot[ id=" + id + " ]";
    }

}
