/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobCertificationAgency.findByClientId", query = "SELECT g FROM GlobCertificationAgency g WHERE g.clientId = :clientId")
    , @NamedQuery(name = "GlobCertificationAgency.findByQualifyingAgency", query = "SELECT g FROM GlobCertificationAgency g WHERE g.qualifyingAgency = :qualifyingAgency")
    , @NamedQuery(name = "GlobCertificationAgency.findByLastModBy", query = "SELECT g FROM GlobCertificationAgency g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobCertificationAgency.findByLastModIp", query = "SELECT g FROM GlobCertificationAgency g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobCertificationAgency.findByLastMod", query = "SELECT g FROM GlobCertificationAgency g WHERE g.lastMod = :lastMod")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CERTIFICATION_AGENCY", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_CERTIFICATION_AGENCY SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCertificationAgency.findAll", query = "SELECT g FROM GlobCertificationAgency g"),
    @NamedQuery(name = "GlobCertificationAgency.findById", query = "SELECT g FROM GlobCertificationAgency g WHERE g.id = :id")})
public class GlobCertificationAgency implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_certification_agen_id_seq", sequenceName = "glob_certification_agen_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_certification_agen_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "QUALIFYING_AGENCY")
    private String qualifyingAgency;
    @Basic(optional = false)
    @Column(name = "CREATED", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Basic(optional = false)
    @Column(name = "LAST_MOD", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastMod;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 10)
    @Column(name = "ACTIVE")
    private String active;
    @Transient
    @JsonProperty("canBeDeleted")
    private String canbeDeleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agencyId", fetch = FetchType.LAZY)
    private List<GlobCertification> globCertificationList;

    public GlobCertificationAgency() {
        canbeDeleted = "true";
    }

    public GlobCertificationAgency(BigDecimal id) {
        canbeDeleted = "true";
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

    public String getQualifyingAgency() {
        return qualifyingAgency;
    }

    public void setQualifyingAgency(String qualifyingAgency) {
        this.qualifyingAgency = qualifyingAgency;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLastMod() {
        return lastMod;
    }

    public void setLastMod(Date lastMod) {
        this.lastMod = lastMod;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
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

    public String getCanbeDeleted() {
        return canbeDeleted;
    }

    public void setCanbeDeleted(String canbeDeleted) {
        this.canbeDeleted = canbeDeleted;
    }

    @XmlTransient
    public List<GlobCertification> getGlobCertificationList() {
        return globCertificationList;
    }

    public void setGlobCertificationList(List<GlobCertification> globCertificationList) {
        this.globCertificationList = globCertificationList;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(clientId)
                .append(qualifyingAgency)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobCertificationAgency)) {
            return false;
        }
        GlobCertificationAgency other = (GlobCertificationAgency) object;

        return new EqualsBuilder()
                .append(this.clientId, other.clientId)
                .append(this.qualifyingAgency, other.qualifyingAgency)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCertificationAgency[ id=" + id + " ]";
    }

}
