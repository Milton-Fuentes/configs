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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByJmfId", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.jmfId = :jmfId"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findBySieveId", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.sieveId = :sieveId"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByOrdering", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.ordering = :ordering"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByJmfPercPassing", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.jmfPercPassing = :jmfPercPassing"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByCreated", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.created = :created"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByCreatedBy", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByCreatedByIp", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByLastMod", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByLastModIp", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByLastModBy", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByDeleted", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByActive", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.active = :active"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findByVersion", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QAASPM_MIX_JMFSV_MASTER_AUD")
@Table(name = "QAASPM_MIXDESIGN_JMFSV_MASTER", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QAASPM_MIXDESIGN_JMFSV_MASTER SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findAll", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q"),
    @NamedQuery(name = "QaaspmMixdesignJmfsvMaster.findById", query = "SELECT q FROM QaaspmMixdesignJmfsvMaster q WHERE q.id = :id")})
public class QaaspmMixdesignJmfsvMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QAASPM_MIX_JMF_SV_MASTER_SEQ", sequenceName = "QAASPM_MIX_JMF_SV_MASTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QAASPM_MIX_JMF_SV_MASTER_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "JMF_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QaaspmMixdesignJmfMaster jmfId;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Column(name = "ORDERING")
    private BigInteger ordering;
    @Column(name = "JMF_PERC_PASSING")
    private BigDecimal jmfPercPassing;
    @Column(name = "CREATED", insertable = false, updatable = false)
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
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE", insertable = false)
    private String active;
    @Version
    @Column(name = "VERSION")
    private Long version;

    public QaaspmMixdesignJmfsvMaster() {
    }

    public QaaspmMixdesignJmfsvMaster(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QaaspmMixdesignJmfMaster getJmfId() {
        return jmfId;
    }

    public void setJmfId(QaaspmMixdesignJmfMaster jmfId) {
        this.jmfId = jmfId;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public BigInteger getOrdering() {
        return ordering;
    }

    public void setOrdering(BigInteger ordering) {
        this.ordering = ordering;
    }

    public BigDecimal getJmfPercPassing() {
        return jmfPercPassing;
    }

    public void setJmfPercPassing(BigDecimal jmfPercPassing) {
        this.jmfPercPassing = jmfPercPassing;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(jmfPercPassing)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaaspmMixdesignJmfsvMaster)) {
            return false;
        }
        QaaspmMixdesignJmfsvMaster other = (QaaspmMixdesignJmfsvMaster) object;

        return new EqualsBuilder()
                .append(this.jmfPercPassing, other.jmfPercPassing)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaaspmMixdesignJmfsvMaster[ id=" + id + " ]";
    }

}
