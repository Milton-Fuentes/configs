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
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "GlobPermsModelDoc.findByClientId", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.clientId = :clientId"),
    @NamedQuery(name = "GlobPermsModelDoc.findBySno", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.sno = :sno"),
    @NamedQuery(name = "GlobPermsModelDoc.findByVersionNo", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.versionNo = :versionNo"),
    @NamedQuery(name = "GlobPermsModelDoc.findByDescription", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.description = :description"),
    @NamedQuery(name = "GlobPermsModelDoc.findByAuthorizedBy", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.authorizedBy = :authorizedBy"),
    @NamedQuery(name = "GlobPermsModelDoc.findByAuthorizedDate", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.authorizedDate = :authorizedDate"),
    @NamedQuery(name = "GlobPermsModelDoc.findByMain", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.main = :main"),
    @NamedQuery(name = "GlobPermsModelDoc.findByFolderId", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.folderId = :folderId"),
    @NamedQuery(name = "GlobPermsModelDoc.findByCreated", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.created = :created"),
    @NamedQuery(name = "GlobPermsModelDoc.findByCreatedBy", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobPermsModelDoc.findByCreatedByIp", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobPermsModelDoc.findByLastMod", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobPermsModelDoc.findByLastModIp", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobPermsModelDoc.findByLastModBy", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobPermsModelDoc.findByDeleted", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobPermsModelDoc.findByActive", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.active = :active"),
    @NamedQuery(name = "GlobPermsModelDoc.findByVersion", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.version = :version")
 */

/**
 *
 * @author droldan
 */
@Entity
@Audited
@SQLDelete(sql = "UPDATE GLOB_PERMS_MODEL_DOC SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_PERMS_MODEL_DOC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobPermsModelDoc.findAll", query = "SELECT g FROM GlobPermsModelDoc g"),
    @NamedQuery(name = "GlobPermsModelDoc.findById", query = "SELECT g FROM GlobPermsModelDoc g WHERE g.id = :id")})
public class GlobPermsModelDoc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_PERMS_MODEL_DOC_SEQ", sequenceName = "GLOB_PERMS_MODEL_DOC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_PERMS_MODEL_DOC_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "SNO")
    private BigInteger sno;
    @Size(max = 50)
    @Column(name = "VERSION_NO")
    private String versionNo;
    @Size(max = 4000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "AUTHORIZED_BY")
    private String authorizedBy;
    @Column(name = "AUTHORIZED_DATE")
    @Temporal(TemporalType.DATE)
    private Date authorizedDate;
    @Column(name = "MAIN")
    private Character main;
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

    public GlobPermsModelDoc() {
    }

    public GlobPermsModelDoc(BigDecimal id) {
        this.id = id;
    }

    public GlobPermsModelDoc(BigDecimal id, BigInteger clientId) {
        this.id = id;
        this.clientId = clientId;
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

    public BigInteger getSno() {
        return sno;
    }

    public void setSno(BigInteger sno) {
        this.sno = sno;
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

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Date authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    public Character getMain() {
        return main;
    }

    public void setMain(Character main) {
        this.main = main;
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
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.versionNo);
        hash = 59 * hash + Objects.hashCode(this.description);
        hash = 59 * hash + Objects.hashCode(this.authorizedBy);
        hash = 59 * hash + Objects.hashCode(this.authorizedDate);
        hash = 59 * hash + Objects.hashCode(this.main);
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
        final GlobPermsModelDoc other = (GlobPermsModelDoc) obj;
        if (!Objects.equals(this.versionNo, other.versionNo)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.authorizedBy, other.authorizedBy)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.authorizedDate, other.authorizedDate)) {
            return false;
        }
        if (!Objects.equals(this.main, other.main)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobPermsModelDoc[ id=" + id + " ]";
    }

}
