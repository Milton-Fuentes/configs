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

/*
    @NamedQuery(name = "GlobMgmtPlan.findByClientId", query = "SELECT g FROM GlobMgmtPlan g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobMgmtPlan.findByProgramId", query = "SELECT g FROM GlobMgmtPlan g WHERE g.programId = :programId"),
    @NamedQuery(name = "GlobMgmtPlan.findByProjectId", query = "SELECT g FROM GlobMgmtPlan g WHERE g.projectId = :projectId"),
    @NamedQuery(name = "GlobMgmtPlan.findByPlanCatgId", query = "SELECT g FROM GlobMgmtPlan g WHERE g.planCatgId = :planCatgId"),
    @NamedQuery(name = "GlobMgmtPlan.findByDescription", query = "SELECT g FROM GlobMgmtPlan g WHERE g.description = :description"),
    @NamedQuery(name = "GlobMgmtPlan.findByFolderId", query = "SELECT g FROM GlobMgmtPlan g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobMgmtPlan.findByCreated", query = "SELECT g FROM GlobMgmtPlan g WHERE g.created = :created"),
    @NamedQuery(name = "GlobMgmtPlan.findByCreatedBy", query = "SELECT g FROM GlobMgmtPlan g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobMgmtPlan.findByCreatedByIp", query = "SELECT g FROM GlobMgmtPlan g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobMgmtPlan.findByLastMod", query = "SELECT g FROM GlobMgmtPlan g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobMgmtPlan.findByLastModIp", query = "SELECT g FROM GlobMgmtPlan g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobMgmtPlan.findByLastModBy", query = "SELECT g FROM GlobMgmtPlan g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobMgmtPlan.findByDeleted", query = "SELECT g FROM GlobMgmtPlan g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobMgmtPlan.findByActive", query = "SELECT g FROM GlobMgmtPlan g WHERE g.active = :active"),
    @NamedQuery(name = "GlobMgmtPlan.findByVersion", query = "SELECT g FROM GlobMgmtPlan g WHERE g.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE GLOB_MGMT_PLAN SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_MGMT_PLAN", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobMgmtPlan.findAll", query = "SELECT g FROM GlobMgmtPlan g"),
    @NamedQuery(name = "GlobMgmtPlan.findById", query = "SELECT g FROM GlobMgmtPlan g WHERE g.id = :id")})
public class GlobMgmtPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_MGMT_PLAN_SEQ", sequenceName = "GLOB_MGMT_PLAN_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_MGMT_PLAN_SEQ")
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
    @Column(name = "PROGRAM_ID")
    private BigInteger programId;
    @Transient
    private String programFullName;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Transient
    private String projectFullName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAN_CATG_ID")
    private BigInteger planCatgId;
    @Transient
    private String planCatgName;
    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;
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

    public GlobMgmtPlan() {
    }

    public GlobMgmtPlan(BigDecimal id) {
        this.id = id;
    }

    public GlobMgmtPlan(BigDecimal id, BigInteger clientId, BigInteger programId, BigInteger planCatgId) {
        this.id = id;
        this.clientId = clientId;
        this.programId = programId;
        this.planCatgId = planCatgId;
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

    public BigInteger getProgramId() {
        return programId;
    }

    public void setProgramId(BigInteger programId) {
        this.programId = programId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getPlanCatgId() {
        return planCatgId;
    }

    public void setPlanCatgId(BigInteger planCatgId) {
        this.planCatgId = planCatgId;
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

    @JsonGetter(value = "programFullName")
    public String getProgramFullName() {
        return programFullName;
    }

    public void setProgramFullName(String programFullName) {
        this.programFullName = programFullName;
    }

    @JsonGetter(value = "projectFullName")
    public String getProjectFullName() {
        return projectFullName;
    }

    public void setProjectFullName(String projectFullName) {
        this.projectFullName = projectFullName;
    }

    @JsonGetter(value = "planCatgName")
    public String getPlanCatgName() {
        return planCatgName;
    }

    public void setPlanCatgName(String planCatgName) {
        this.planCatgName = planCatgName;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.programId);
        hash = 37 * hash + Objects.hashCode(this.projectId);
        hash = 37 * hash + Objects.hashCode(this.planCatgId);
        hash = 37 * hash + Objects.hashCode(this.description);
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
        final GlobMgmtPlan other = (GlobMgmtPlan) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.programId, other.programId)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        if (!Objects.equals(this.planCatgId, other.planCatgId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobMgmtPlan[ id=" + id + " ]";
    }
    
}
