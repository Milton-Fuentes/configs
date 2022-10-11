/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_CONTRACTMGMT_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_CONTRACTMGMT_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContractmgmtLog.findAll", query = "SELECT g FROM GlobContractmgmtLog g"),
    @NamedQuery(name = "GlobContractmgmtLog.findById", query = "SELECT g FROM GlobContractmgmtLog g WHERE g.id = :id")})
public class GlobContractmgmtLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_CONTRACTMGMT_LOG_SEQ", sequenceName = "GLOB_CONTRACTMGMT_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_CONTRACTMGMT_LOG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN")
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "CMPCN")
    private String cmpcn;
    @Size(max = 150)
    @Column(name = "REQ_NO")
    private String reqNo;
    @Size(max = 150)
    @Column(name = "REF_ID")
    private String refId;
    @Column(name = "CATEGORY_ID")
    private BigInteger categoryId;
    @Transient
    private String categoryName;
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "VERSION_NO")
    private String versionNo;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public GlobContractmgmtLog() {
    }

    public GlobContractmgmtLog(BigDecimal id) {
        this.id = id;
    }

    public GlobContractmgmtLog(BigDecimal id, BigInteger clientId, BigInteger projectId) {
        this.id = id;
        this.clientId = clientId;
        this.projectId = projectId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public String getSpattern() {
        return spattern;
    }

    public void setSpattern(String spattern) {
        this.spattern = spattern;
    }

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
    }

    public String getCmpcn() {
        return cmpcn;
    }

    public void setCmpcn(String cmpcn) {
        this.cmpcn = cmpcn;
    }

    public String getReqNo() {
        return reqNo;
    }

    public void setReqNo(String reqNo) {
        this.reqNo = reqNo;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    @JsonGetter(value = "categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedByIp() {
        return createdByIp;
    }

    public void setCreatedByIp(String createdByIp) {
        this.createdByIp = createdByIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.refId);
        //hash = 53 * hash + Objects.hashCode(this.categoryId);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Objects.hashCode(this.versionNo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GlobContractmgmtLog other = (GlobContractmgmtLog) obj;
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.versionNo, other.versionNo)) {
            return false;
        }
        /*if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }*/
        return true;
    }

    @Override
    public String toString() {
        return "GlobContractmgmtLog{" + "id=" + id + ", clientId=" + clientId + ", projectId=" + projectId + '}';
    }
}
