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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
@NamedQuery(name = "GlobSystemSimpleCat.findByClientId", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByCode", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.code = :code"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByShortName", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.shortName = :shortName"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByName", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.name = :name"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByCatOrder", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.catOrder = :catOrder"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByCreated", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.created = :created"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByCreatedBy", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByCreatedByIp", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.createdByIp = :createdByIp"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByLastMod", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.lastMod = :lastMod"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByLastModIp", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.lastModIp = :lastModIp"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByLastModBy", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.lastModBy = :lastModBy"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByDeleted", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByActive", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.active = :active"),
    @NamedQuery(name = "GlobSystemSimpleCat.findByVersion", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_SYSTEM_SIMPLE_CAT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_SYSTEM_SIMPLE_CAT SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobSystemSimpleCat.findAll", query = "SELECT c FROM GlobSystemSimpleCat c"),
    @NamedQuery(name = "GlobSystemSimpleCat.findById", query = "SELECT c FROM GlobSystemSimpleCat c WHERE c.id = :id")})
public class GlobSystemSimpleCat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "GLOB_SYSTEM_SIMPLE_CAT_SEQ", sequenceName = "GLOB_SYSTEM_SIMPLE_CAT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GLOB_SYSTEM_SIMPLE_CAT_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "CODE")
    private String code;
    @Size(max = 50)
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAT_ORDER")
    private BigInteger catOrder;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
    @Temporal(TemporalType.TIMESTAMP)
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

    public GlobSystemSimpleCat() {
    }

    public GlobSystemSimpleCat(BigDecimal id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getCatOrder() {
        return catOrder;
    }

    public void setCatOrder(BigInteger catOrder) {
        this.catOrder = catOrder;
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
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobSystemSimpleCat)) {
            return false;
        }
        GlobSystemSimpleCat other = (GlobSystemSimpleCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobSystemSimpleCat[ id=" + id + " ]";
    }
    
}
