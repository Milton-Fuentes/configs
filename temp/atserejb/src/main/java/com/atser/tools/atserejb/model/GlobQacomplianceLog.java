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
    @NamedQuery(name = "GlobQacomplianceLog.findByClientId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobQacomplianceLog.findByProjectId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobQacomplianceLog.findBySpattern", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.spattern = :spattern"),
    @NamedQuery(name = "GlobQacomplianceLog.findBySno", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobQacomplianceLog.findByQcpcn", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.qcpcn = :qcpcn"),
    @NamedQuery(name = "GlobQacomplianceLog.findByReqNo", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.reqNo = :reqNo"),
    @NamedQuery(name = "GlobQacomplianceLog.findByRefId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.refId = :refId"),
    @NamedQuery(name = "GlobQacomplianceLog.findByDescription", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.description = :description"),
    @NamedQuery(name = "GlobQacomplianceLog.findByMeetRequirement", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.meetRequirement = :meetRequirement"),
    @NamedQuery(name = "GlobQacomplianceLog.findByResponse", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.response = :response"),
    @NamedQuery(name = "GlobQacomplianceLog.findByQcTypeId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.qcTypeId = :qcTypeId"),
    @NamedQuery(name = "GlobQacomplianceLog.findByScorecard", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.scorecard = :scorecard"),
    @NamedQuery(name = "GlobQacomplianceLog.findByObjective", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.objective = :objective"),
    @NamedQuery(name = "GlobQacomplianceLog.findByQcPeriodId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.qcPeriodId = :qcPeriodId"),
    @NamedQuery(name = "GlobQacomplianceLog.findByThreshold", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.threshold = :threshold"),
    @NamedQuery(name = "GlobQacomplianceLog.findByRange", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.range = :range"),
    @NamedQuery(name = "GlobQacomplianceLog.findByWarning", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.warning = :warning"),
    @NamedQuery(name = "GlobQacomplianceLog.findByFolderId", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobQacomplianceLog.findByCreated", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.created = :created"),
    @NamedQuery(name = "GlobQacomplianceLog.findByCreatedBy", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobQacomplianceLog.findByCreatedByIp", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobQacomplianceLog.findByLastMod", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobQacomplianceLog.findByLastModIp", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobQacomplianceLog.findByLastModBy", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobQacomplianceLog.findByDeleted", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobQacomplianceLog.findByActive", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.active = :active"),
    @NamedQuery(name = "GlobQacomplianceLog.findByVersion", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_QACOMPLIANCE_LOG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_QACOMPLIANCE_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobQacomplianceLog.findAll", query = "SELECT g FROM GlobQacomplianceLog g"),
    @NamedQuery(name = "GlobQacomplianceLog.findById", query = "SELECT g FROM GlobQacomplianceLog g WHERE g.id = :id")})
public class GlobQacomplianceLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_QACOMPLIANCE_LOG_SEQ", sequenceName = "GLOB_QACOMPLIANCE_LOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_QACOMPLIANCE_LOG_SEQ")
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
    @Column(name = "QCPCN")
    private String qcpcn;
    @Size(max = 150)
    @Column(name = "REQ_NO")
    private String reqNo;
    @Size(max = 150)
    @Column(name = "REF_ID")
    private String refId;
    @Size(max = 2048)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MEET_REQUIREMENT")
    private Character meetRequirement;
    @Size(max = 2048)
    @Column(name = "RESPONSE")
    private String response;
    @Column(name = "QC_TYPE_ID")
    private BigInteger qcTypeId;
    @Transient
    private String qcTypeName;
    @Column(name = "SCORECARD")
    private BigDecimal scorecard;
    @Size(max = 1024)
    @Column(name = "OBJECTIVE")
    private String objective;
    @Column(name = "QC_PERIOD_ID")
    private BigInteger qcPeriodId;
    @Transient
    private String qcPeriodName;
    @Size(max = 512)
    @Column(name = "THRESHOLD")
    private String threshold;
    @Size(max = 150)
    @Column(name = "RANGE")
    private String range;
    @Column(name = "WARNING")
    private BigDecimal warning;
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

    public GlobQacomplianceLog() {
    }

    public GlobQacomplianceLog(BigDecimal id) {
        this.id = id;
    }

    public GlobQacomplianceLog(BigDecimal id, BigInteger clientId, BigInteger projectId) {
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

    public String getQcpcn() {
        return qcpcn;
    }

    public void setQcpcn(String qcpcn) {
        this.qcpcn = qcpcn;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Character getMeetRequirement() {
        return meetRequirement;
    }

    public void setMeetRequirement(Character meetRequirement) {
        this.meetRequirement = meetRequirement;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public BigInteger getQcTypeId() {
        return qcTypeId;
    }

    public void setQcTypeId(BigInteger qcTypeId) {
        this.qcTypeId = qcTypeId;
    }

    public BigDecimal getScorecard() {
        return scorecard;
    }

    public void setScorecard(BigDecimal scorecard) {
        this.scorecard = scorecard;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public BigInteger getQcPeriodId() {
        return qcPeriodId;
    }

    public void setQcPeriodId(BigInteger qcPeriodId) {
        this.qcPeriodId = qcPeriodId;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public BigDecimal getWarning() {
        return warning;
    }

    public void setWarning(BigDecimal warning) {
        this.warning = warning;
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

    @JsonGetter(value = "qcTypeName")
    public String getQcTypeName() {
        return qcTypeName;
    }

    public void setQcTypeName(String qcTypeName) {
        this.qcTypeName = qcTypeName;
    }

    @JsonGetter(value = "qcPeriodName")
    public String getQcPeriodName() {
        return qcPeriodName;
    }

    public void setQcPeriodName(String qcPeriodName) {
        this.qcPeriodName = qcPeriodName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.projectId);
        hash = 19 * hash + Objects.hashCode(this.refId);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Objects.hashCode(this.meetRequirement);
        hash = 19 * hash + Objects.hashCode(this.response);
        hash = 19 * hash + Objects.hashCode(this.qcTypeId);
        hash = 19 * hash + Objects.hashCode(this.scorecard);
        hash = 19 * hash + Objects.hashCode(this.objective);
        hash = 19 * hash + Objects.hashCode(this.qcPeriodId);
        hash = 19 * hash + Objects.hashCode(this.threshold);
        hash = 19 * hash + Objects.hashCode(this.range);
        hash = 19 * hash + Objects.hashCode(this.warning);
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
        final GlobQacomplianceLog other = (GlobQacomplianceLog) obj;
        if (!Objects.equals(this.refId, other.refId)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.response, other.response)) {
            return false;
        }
        if (!Objects.equals(this.objective, other.objective)) {
            return false;
        }
        if (!Objects.equals(this.threshold, other.threshold)) {
            return false;
        }
        if (!Objects.equals(this.range, other.range)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.meetRequirement, other.meetRequirement)) {
            return false;
        }
        if (!Objects.equals(this.qcTypeId, other.qcTypeId)) {
            return false;
        }
        if (!Objects.equals(this.scorecard, other.scorecard)) {
            return false;
        }
        if (!Objects.equals(this.qcPeriodId, other.qcPeriodId)) {
            return false;
        }
        if (!Objects.equals(this.warning, other.warning)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobQacomplianceLog[ id=" + id + " ]";
    }
    
}
