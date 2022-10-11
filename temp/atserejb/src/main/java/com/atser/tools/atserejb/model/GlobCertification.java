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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
, @NamedQuery(name = "GlobCertification.findByAgencyId", query = "SELECT g FROM GlobCertification g WHERE g.agencyId = :agencyId")
    , @NamedQuery(name = "GlobCertification.findByQualification", query = "SELECT g FROM GlobCertification g WHERE g.qualification = :qualification")
    , @NamedQuery(name = "GlobCertification.findByLastModBy", query = "SELECT g FROM GlobCertification g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobCertification.findByLastModIp", query = "SELECT g FROM GlobCertification g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobCertification.findByLastMod", query = "SELECT g FROM GlobCertification g WHERE g.lastMod = :lastMod")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CERTIFICATION", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_CERTIFICATION SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobCertification.findAll", query = "SELECT g FROM GlobCertification g"),
    @NamedQuery(name = "GlobCertification.findById", query = "SELECT g FROM GlobCertification g WHERE g.id = :id")})
public class GlobCertification implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_certification_id_seq", sequenceName = "glob_certification_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_certification_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @JoinColumn(name = "AGENCY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobCertificationAgency agencyId;
    @Size(max = 255)
    @Column(name = "QUALIFICATION")
    private String qualification;
    @Size(max = 50)
    @Column(name = "QUALIFICATION_ACRONYM")
    private String acronym;
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
    /*@Version
    @Column(name = "VERSION")
    private Long version;*/
    @Transient
    @JsonProperty("canBeDeleted")
    private String canbeDeleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "qualificationId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GlobCertificationTest> globCertificationTestList;

    public GlobCertification() {
        canbeDeleted = "true";
    }

    public GlobCertification(BigDecimal id) {
        canbeDeleted = "true";
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobCertificationAgency getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(GlobCertificationAgency agencyId) {
        this.agencyId = agencyId;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
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

   /* public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }*/

    @XmlTransient
    public List<GlobCertificationTest> getGlobCertificationTestList() {
        return globCertificationTestList;
    }

    public void setGlobCertificationTestList(List<GlobCertificationTest> globCertificationTestList) {
        this.globCertificationTestList = globCertificationTestList;
    }
    
    public String getCanbeDeleted() {
        return canbeDeleted;
    }

    public void setCanbeDeleted(String canbeDeleted) {
        this.canbeDeleted = canbeDeleted;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(agencyId)
                .append(qualification)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobCertification)) {
            return false;
        }
        GlobCertification other = (GlobCertification) object;

        return new EqualsBuilder()
                .append(this.agencyId, other.agencyId)
                .append(this.qualification, other.qualification)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobCertification[ id=" + id + " ]";
    }

}
