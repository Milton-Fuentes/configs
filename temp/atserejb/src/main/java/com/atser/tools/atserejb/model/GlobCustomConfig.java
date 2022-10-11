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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
    @NamedQuery(name = "GlobCustomConfig.findByName", query = "SELECT g FROM GlobCustomConfig g WHERE g.name = :name"),
    @NamedQuery(name = "GlobCustomConfig.findByDescription", query = "SELECT g FROM GlobCustomConfig g WHERE g.description = :description"),
    @NamedQuery(name = "GlobCustomConfig.findByCreated", query = "SELECT g FROM GlobCustomConfig g WHERE g.created = :created"),
    @NamedQuery(name = "GlobCustomConfig.findByCreatedBy", query = "SELECT g FROM GlobCustomConfig g WHERE g.createdBy = :createdBy"),
    @NamedQuery(name = "GlobCustomConfig.findByCreatedByIp", query = "SELECT g FROM GlobCustomConfig g WHERE g.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobCustomConfig.findByLastMod", query = "SELECT g FROM GlobCustomConfig g WHERE g.lastMod = :lastMod"),
    @NamedQuery(name = "GlobCustomConfig.findByLastModIp", query = "SELECT g FROM GlobCustomConfig g WHERE g.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobCustomConfig.findByLastModBy", query = "SELECT g FROM GlobCustomConfig g WHERE g.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobCustomConfig.findByDeleted", query = "SELECT g FROM GlobCustomConfig g WHERE g.deleted = :deleted"),
    @NamedQuery(name = "GlobCustomConfig.findByActive", query = "SELECT g FROM GlobCustomConfig g WHERE g.active = :active"),
    @NamedQuery(name = "GlobCustomConfig.findByVersion", query = "SELECT g FROM GlobCustomConfig g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@SQLDelete(sql = "UPDATE GLOB_CUSTOM_CONFIG SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "GLOB_CUSTOM_CONFIG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCustomConfig.findAll", query = "SELECT g FROM GlobCustomConfig g"),
    @NamedQuery(name = "GlobCustomConfig.findById", query = "SELECT g FROM GlobCustomConfig g WHERE g.id = :id")})
public class GlobCustomConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_CUSTOM_CONFIG_SEQ", sequenceName = "GLOB_CUSTOM_CONFIG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_CUSTOM_CONFIG_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 150)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 255)
    @Column(name = "FUNCTIONALITY")
    private String functionality;
    @Lob
    @Column(name = "VALUE")
    private String value;
    @Size(max = 50)
    @Column(name = "DATA_TYPE")
    private String datatype;
    @Size(max = 2048)
    @Column(name = "DATA_URL")
    private String dataurl;
    @Column(name = "LOAD_SESSION", insertable = false)
    private Character loadSession;
    @Column(name = "CUSTOMIZABLE", insertable = false)
    private Character customizable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "CREATED", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 255)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Column(name = "ACTIVE")
    private Character active;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public GlobCustomConfig() {
    }

    public GlobCustomConfig(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public Character getLoadSession() {
        return loadSession;
    }

    public void setLoadSession(Character loadSession) {
        this.loadSession = loadSession;
    }

    public Character getCustomizable() {
        return customizable;
    }

    public void setCustomizable(Character customizable) {
        this.customizable = customizable;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getDataurl() {
        return dataurl;
    }

    public void setDataurl(String dataurl) {
        this.dataurl = dataurl;
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
        if (!(object instanceof GlobCustomConfig)) {
            return false;
        }
        GlobCustomConfig other = (GlobCustomConfig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCustomConfig[ id=" + id + " ]";
    }

}
