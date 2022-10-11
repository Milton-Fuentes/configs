/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "GlobMgmtPlanDoc.findByPlanId", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.planId = :planId"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByDescription", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.description = :description"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByVersionNo", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.versionNo = :versionNo"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByAuthorizedBy", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.authorizedBy = :authorizedBy"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByMain", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.main = :main"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByFileId", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.fileId = :fileId"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByCreated", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.created = :created"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByCreatedBy", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByCreatedByIp", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByLastMod", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByLastModIp", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByLastModBy", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByDeleted", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByActive", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.active = :active"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findByVersion", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE GLOB_MGMT_PLAN_DOC SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_MGMT_PLAN_DOC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobMgmtPlanDoc.findAll", query = "SELECT g FROM GlobMgmtPlanDoc g"),
    @NamedQuery(name = "GlobMgmtPlanDoc.findById", query = "SELECT g FROM GlobMgmtPlanDoc g WHERE g.id = :id")})
public class GlobMgmtPlanDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_MGMT_PLAN_DOC_SEQ", sequenceName = "GLOB_MGMT_PLAN_DOC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_MGMT_PLAN_DOC_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAN_ID")
    private BigInteger planId;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 512)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "VERSION_NO")
    private String versionNo;
    @Size(max = 255)
    @Column(name = "AUTHORIZED_BY")
    private String authorizedBy;
    @Column(name = "MAIN")
    private Character main;
    @Column(name = "FILE_ID")
    private BigInteger fileId;
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

    public GlobMgmtPlanDoc() {
    }

    public GlobMgmtPlanDoc(BigDecimal id) {
        this.id = id;
    }

    public GlobMgmtPlanDoc(BigDecimal id, BigInteger planId) {
        this.id = id;
        this.planId = planId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getPlanId() {
        return planId;
    }

    public void setPlanId(BigInteger planId) {
        this.planId = planId;
    }

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
    }

    public BigInteger getFileId() {
        return fileId;
    }

    public void setFileId(BigInteger fileId) {
        this.fileId = fileId;
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
        hash = 67 * hash + Objects.hashCode(this.planId);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.versionNo);
        hash = 67 * hash + Objects.hashCode(this.authorizedBy);
        hash = 67 * hash + Objects.hashCode(this.main);
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
        final GlobMgmtPlanDoc other = (GlobMgmtPlanDoc) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.versionNo, other.versionNo)) {
            return false;
        }
        if (!Objects.equals(this.authorizedBy, other.authorizedBy)) {
            return false;
        }
        if (!Objects.equals(this.planId, other.planId)) {
            return false;
        }
        if (!Objects.equals(this.main, other.main)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobMgmtPlanDoc[ id=" + id + " ]";
    }

}
