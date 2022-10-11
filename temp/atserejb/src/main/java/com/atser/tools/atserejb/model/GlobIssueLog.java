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
@SQLDelete(sql = "UPDATE GLOB_ISSUE_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_ISSUE_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobIssueLog.findAll", query = "SELECT g FROM GlobIssueLog g"),
    @NamedQuery(name = "GlobIssueLog.findById", query = "SELECT g FROM GlobIssueLog g WHERE g.id = :id")})
public class GlobIssueLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_ISSUE_LOG_SEQ", sequenceName = "GLOB_ISSUE_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_ISSUE_LOG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID", nullable = false)
    private BigInteger clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECT_ID", nullable = false)
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Size(max = 150)
    @Column(name = "SPATTERN", length = 150)
    private String spattern;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "ILPCN", length = 50)
    private String ilpcn;
    @Size(max = 150)
    @Column(name = "ISSUE_NO", length = 150)
    private String issueNo;
    @Size(max = 150)
    @Column(name = "REF_ID", length = 150)
    private String refId;
    @Column(name = "IDENTIFIED_BY")
    private BigInteger identifiedBy;
    @Transient
    private String identifiedByName;
    @Column(name = "ISSUE_TYPE")
    private BigInteger issueType;
    @Transient
    private String issueTypeName;
    @Column(name = "DATE_FOUND")
    @Temporal(TemporalType.DATE)
    private Date dateFound;
    @Column(name = "DATE_SUBMITTED")
    @Temporal(TemporalType.DATE)
    private Date dateSubmitted;
    @Column(name = "DATE_RESOLVED")
    @Temporal(TemporalType.DATE)
    private Date dateResolved;
    @Size(max = 1024)
    @Column(name = "DESCRIPTION", length = 1024)
    private String description;
    @Size(max = 512)
    @Column(name = "REMARKS", length = 512)
    private String remarks;
    @Size(max = 255)
    @Column(name = "ASSIGNED_TO", length = 255)
    private String assignedTo;
    @Column(name = "STATUS_ID")
    private BigInteger statusId;
    @Transient
    private String statusName;
    @Column(name = "PROJECT_PHASE")
    private BigInteger projectPhase;
    @Transient
    private String projectPhaseName;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "CREATED")
    @Temporal(TemporalType.DATE)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY", length = 255)
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP", length = 50)
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.DATE)
    private Date lastMod;
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP", length = 50)
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY", length = 255)
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED")
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public GlobIssueLog() {
    }

    public GlobIssueLog(BigDecimal id) {
        this.id = id;
    }

    public GlobIssueLog(BigDecimal id, BigInteger clientId, BigInteger projectId) {
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

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
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

    public String getIlpcn() {
        return ilpcn;
    }

    public void setIlpcn(String ilpcn) {
        this.ilpcn = ilpcn;
    }

    public String getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(String issueNo) {
        this.issueNo = issueNo;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public BigInteger getIdentifiedBy() {
        return identifiedBy;
    }

    public void setIdentifiedBy(BigInteger identifiedBy) {
        this.identifiedBy = identifiedBy;
    }

    @JsonGetter(value = "identifiedByName")
    public String getIdentifiedByName() {
        return identifiedByName;
    }

    public void setIdentifiedByName(String identifiedByName) {
        this.identifiedByName = identifiedByName;
    }

    public BigInteger getIssueType() {
        return issueType;
    }

    public void setIssueType(BigInteger issueType) {
        this.issueType = issueType;
    }

    @JsonGetter(value = "issueTypeName")
    public String getIssueTypeName() {
        return issueTypeName;
    }

    public void setIssueTypeName(String issueTypeName) {
        this.issueTypeName = issueTypeName;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateFound() {
        return dateFound;
    }

    public void setDateFound(Date dateFound) {
        this.dateFound = dateFound;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateResolved() {
        return dateResolved;
    }

    public void setDateResolved(Date dateResolved) {
        this.dateResolved = dateResolved;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public BigInteger getStatusId() {
        return statusId;
    }

    public void setStatusId(BigInteger statusId) {
        this.statusId = statusId;
    }

    @JsonGetter(value = "statusName")
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public BigInteger getProjectPhase() {
        return projectPhase;
    }

    public void setProjectPhase(BigInteger projectPhase) {
        this.projectPhase = projectPhase;
    }

    @JsonGetter(value = "projectPhaseName")
    public String getProjectPhaseName() {
        return projectPhaseName;
    }

    public void setProjectPhaseName(String projectPhaseName) {
        this.projectPhaseName = projectPhaseName;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.refId);
        hash = 29 * hash + Objects.hashCode(this.identifiedBy);
        hash = 29 * hash + Objects.hashCode(this.issueType);
        hash = 29 * hash + Objects.hashCode(this.dateFound);
        hash = 29 * hash + Objects.hashCode(this.dateSubmitted);
        hash = 29 * hash + Objects.hashCode(this.dateResolved);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.remarks);
        hash = 29 * hash + Objects.hashCode(this.assignedTo);
        hash = 29 * hash + Objects.hashCode(this.statusId);
        hash = 29 * hash + Objects.hashCode(this.projectPhase);
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
        final GlobIssueLog other = (GlobIssueLog) obj;
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        if (!Objects.equals(this.assignedTo, other.assignedTo)) {
            return false;
        }
        if (!Objects.equals(this.identifiedBy, other.identifiedBy)) {
            return false;
        }
        if (!Objects.equals(this.issueType, other.issueType)) {
            return false;
        }
        if (!Objects.equals(this.dateFound, other.dateFound)) {
            return false;
        }
        if (!Objects.equals(this.dateSubmitted, other.dateSubmitted)) {
            return false;
        }
        if (!Objects.equals(this.dateResolved, other.dateResolved)) {
            return false;
        }
        if (!Objects.equals(this.statusId, other.statusId)) {
            return false;
        }
        if (!Objects.equals(this.projectPhase, other.projectPhase)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GlobIssueLog{" + "id=" + id + '}';
    }

}
