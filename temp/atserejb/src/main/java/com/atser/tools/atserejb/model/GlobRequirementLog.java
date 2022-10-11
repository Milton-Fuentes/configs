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

/*
@NamedQuery(name = "GlobRequirementLog.findByClientId", query = "SELECT g FROM GlobRequirementLog g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobRequirementLog.findByProjectId", query = "SELECT g FROM GlobRequirementLog g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobRequirementLog.findBySpattern", query = "SELECT g FROM GlobRequirementLog g WHERE g.spattern = :spattern"),
    @NamedQuery(name = "GlobRequirementLog.findBySno", query = "SELECT g FROM GlobRequirementLog g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobRequirementLog.findByRqpcn", query = "SELECT g FROM GlobRequirementLog g WHERE g.rqpcn = :rqpcn"),
    @NamedQuery(name = "GlobRequirementLog.findByReqNo", query = "SELECT g FROM GlobRequirementLog g WHERE g.reqNo = :reqNo"),
    @NamedQuery(name = "GlobRequirementLog.findByRefId", query = "SELECT g FROM GlobRequirementLog g WHERE g.refId = :refId"),
    @NamedQuery(name = "GlobRequirementLog.findByCategoryId", query = "SELECT g FROM GlobRequirementLog g WHERE g.categoryId = :categoryId"),
    @NamedQuery(name = "GlobRequirementLog.findByDescription", query = "SELECT g FROM GlobRequirementLog g WHERE g.description = :description"),
    @NamedQuery(name = "GlobRequirementLog.findByClassificationId", query = "SELECT g FROM GlobRequirementLog g WHERE g.classificationId = :classificationId"),
    @NamedQuery(name = "GlobRequirementLog.findByDesignDocRef", query = "SELECT g FROM GlobRequirementLog g WHERE g.designDocRef = :designDocRef"),
    @NamedQuery(name = "GlobRequirementLog.findByTechSpecRef", query = "SELECT g FROM GlobRequirementLog g WHERE g.techSpecRef = :techSpecRef"),
    @NamedQuery(name = "GlobRequirementLog.findByWbsDeliverablesRef", query = "SELECT g FROM GlobRequirementLog g WHERE g.wbsDeliverablesRef = :wbsDeliverablesRef"),
    @NamedQuery(name = "GlobRequirementLog.findByImplementedIn", query = "SELECT g FROM GlobRequirementLog g WHERE g.implementedIn = :implementedIn"),
    @NamedQuery(name = "GlobRequirementLog.findByStatus", query = "SELECT g FROM GlobRequirementLog g WHERE g.status = :status"),
    @NamedQuery(name = "GlobRequirementLog.findByVerificationDate", query = "SELECT g FROM GlobRequirementLog g WHERE g.verificationDate = :verificationDate"),
    @NamedQuery(name = "GlobRequirementLog.findByFolderId", query = "SELECT g FROM GlobRequirementLog g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobRequirementLog.findByCreated", query = "SELECT g FROM GlobRequirementLog g WHERE g.created = :created"),
    @NamedQuery(name = "GlobRequirementLog.findByCreatedBy", query = "SELECT g FROM GlobRequirementLog g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobRequirementLog.findByCreatedByIp", query = "SELECT g FROM GlobRequirementLog g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobRequirementLog.findByLastMod", query = "SELECT g FROM GlobRequirementLog g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobRequirementLog.findByLastModIp", query = "SELECT g FROM GlobRequirementLog g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobRequirementLog.findByLastModBy", query = "SELECT g FROM GlobRequirementLog g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobRequirementLog.findByDeleted", query = "SELECT g FROM GlobRequirementLog g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobRequirementLog.findByActive", query = "SELECT g FROM GlobRequirementLog g WHERE g.active = :active"),
    @NamedQuery(name = "GlobRequirementLog.findByVersion", query = "SELECT g FROM GlobRequirementLog g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_REQUIREMENT_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_REQUIREMENT_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobRequirementLog.findAll", query = "SELECT g FROM GlobRequirementLog g"),
    @NamedQuery(name = "GlobRequirementLog.findById", query = "SELECT g FROM GlobRequirementLog g WHERE g.id = :id")})
public class GlobRequirementLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_REQUIREMENT_LOG_SEQ", sequenceName = "GLOB_REQUIREMENT_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_REQUIREMENT_LOG_SEQ")
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
    @Column(name = "RQPCN")
    private String rqpcn;
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
    @Column(name = "CLASSIFICATION_ID")
    private BigInteger classificationId;
    @Transient
    private String classificationName;
    @Size(max = 1024)
    @Column(name = "DESIGN_DOC_REF")
    private String designDocRef;
    @Size(max = 1024)
    @Column(name = "TECH_SPEC_REF")
    private String techSpecRef;
    @Size(max = 1024)
    @Column(name = "WBS_DELIVERABLES_REF")
    private String wbsDeliverablesRef;
    @Size(max = 512)
    @Column(name = "IMPLEMENTED_IN")
    private String implementedIn;
    @Column(name = "CLOSED")
    private Character closed;
    @Column(name = "STATUS_ID")
    private BigInteger statusId;
    @Transient
    private String statusName;
    @Column(name = "VERIFICATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date verificationDate;
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

    public GlobRequirementLog() {
    }

    public GlobRequirementLog(BigDecimal id) {
        this.id = id;
    }

    public GlobRequirementLog(BigDecimal id, BigInteger clientId, BigInteger projectId) {
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

    public String getRqpcn() {
        return rqpcn;
    }

    public void setRqpcn(String rqpcn) {
        this.rqpcn = rqpcn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(BigInteger classificationId) {
        this.classificationId = classificationId;
    }

    public String getDesignDocRef() {
        return designDocRef;
    }

    public void setDesignDocRef(String designDocRef) {
        this.designDocRef = designDocRef;
    }

    public String getTechSpecRef() {
        return techSpecRef;
    }

    public void setTechSpecRef(String techSpecRef) {
        this.techSpecRef = techSpecRef;
    }

    public String getWbsDeliverablesRef() {
        return wbsDeliverablesRef;
    }

    public void setWbsDeliverablesRef(String wbsDeliverablesRef) {
        this.wbsDeliverablesRef = wbsDeliverablesRef;
    }

    public String getImplementedIn() {
        return implementedIn;
    }

    public void setImplementedIn(String implementedIn) {
        this.implementedIn = implementedIn;
    }

    public Character getClosed() {
        return closed;
    }

    public void setClosed(Character closed) {
        this.closed = closed;
    }

    public BigInteger getStatusId() {
        return statusId;
    }

    public void setStatusId(BigInteger statusId) {
        this.statusId = statusId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
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

    @JsonGetter(value = "categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonGetter(value = "classificationName")
    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    @JsonGetter(value = "statusName")
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.clientId);
        hash = 29 * hash + Objects.hashCode(this.projectId);
        hash = 29 * hash + Objects.hashCode(this.refId);
        hash = 29 * hash + Objects.hashCode(this.categoryId);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.classificationId);
        hash = 29 * hash + Objects.hashCode(this.designDocRef);
        hash = 29 * hash + Objects.hashCode(this.techSpecRef);
        hash = 29 * hash + Objects.hashCode(this.wbsDeliverablesRef);
        hash = 29 * hash + Objects.hashCode(this.implementedIn);
        hash = 29 * hash + Objects.hashCode(this.closed);
        hash = 29 * hash + Objects.hashCode(this.verificationDate);
        hash = 29 * hash + Objects.hashCode(this.statusId);
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
        final GlobRequirementLog other = (GlobRequirementLog) obj;
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.designDocRef, other.designDocRef)) {
            return false;
        }
        if (!Objects.equals(this.techSpecRef, other.techSpecRef)) {
            return false;
        }
        if (!Objects.equals(this.wbsDeliverablesRef, other.wbsDeliverablesRef)) {
            return false;
        }
        if (!Objects.equals(this.implementedIn, other.implementedIn)) {
            return false;
        }
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.classificationId, other.classificationId)) {
            return false;
        }
        if (!Objects.equals(this.closed, other.closed)) {
            return false;
        }
        if (!Objects.equals(this.verificationDate, other.verificationDate)) {
            return false;
        }
        if (!Objects.equals(this.statusId, other.statusId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobRequirementLog[ id=" + id + " ]";
    }

}
