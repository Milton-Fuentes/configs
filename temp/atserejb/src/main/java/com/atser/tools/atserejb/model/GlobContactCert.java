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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/*
, @NamedQuery(name = "GlobContactCert.findByContactId", query = "SELECT g FROM GlobContactCert g WHERE g.contactId = :contactId")
    , @NamedQuery(name = "GlobContactCert.findByQualifyingAgencyId", query = "SELECT g FROM GlobContactCert g WHERE g.qualifyingAgencyId.id = :qualifyingAgencyId")
    , @NamedQuery(name = "GlobContactCert.findByQualificationId", query = "SELECT g FROM GlobContactCert g WHERE g.qualificationId.id = :qualificationId")
    , @NamedQuery(name = "GlobContactCert.findByAuthorizedDate", query = "SELECT g FROM GlobContactCert g WHERE g.authorizedDate = :authorizedDate")
    , @NamedQuery(name = "GlobContactCert.findByExpirationDate", query = "SELECT g FROM GlobContactCert g WHERE g.expirationDate = :expirationDate")
    , @NamedQuery(name = "GlobContactCert.findByOverride", query = "SELECT g FROM GlobContactCert g WHERE g.override = :override")
    , @NamedQuery(name = "GlobContactCert.findByIgnoreProficiency", query = "SELECT g FROM GlobContactCert g WHERE g.ignoreProficiency = :ignoreProficiency")
    , @NamedQuery(name = "GlobContactCert.findByComments", query = "SELECT g FROM GlobContactCert g WHERE g.comments = :comments")
    , @NamedQuery(name = "GlobContactCert.findByLastModBy", query = "SELECT g FROM GlobContactCert g WHERE g.lastModBy = :lastModBy")
    , @NamedQuery(name = "GlobContactCert.findByLastModIp", query = "SELECT g FROM GlobContactCert g WHERE g.lastModIp = :lastModIp")
    , @NamedQuery(name = "GlobContactCert.findByLastMod", query = "SELECT g FROM GlobContactCert g WHERE g.lastMod = :lastMod")
    , @NamedQuery(name = "GlobContactCert.findByCertNo", query = "SELECT g FROM GlobContactCert g WHERE g.certNo = :certNo")
    , @NamedQuery(name = "GlobContactCert.findByCreateDate", query = "SELECT g FROM GlobContactCert g WHERE g.createDate = :createDate")
    , @NamedQuery(name = "GlobContactCert.findByCreateBy", query = "SELECT g FROM GlobContactCert g WHERE g.createBy = :createBy")
    , @NamedQuery(name = "GlobContactCert.findByCreateByIp", query = "SELECT g FROM GlobContactCert g WHERE g.createByIp = :createByIp")
    , @NamedQuery(name = "GlobContactCert.findByVersion", query = "SELECT g FROM GlobContactCert g WHERE g.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Table(name = "GLOB_CONTACT_CERT", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE GLOB_CONTACT_CERT SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GlobContactCert.findAll", query = "SELECT g FROM GlobContactCert g"),
    @NamedQuery(name = "GlobContactCert.findById", query = "SELECT g FROM GlobContactCert g WHERE g.id = :id")})
public class GlobContactCert implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "glob_contact_cert_id_seq", sequenceName = "glob_contact_cert_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "glob_contact_cert_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobContact contactId;
    @JoinColumn(name = "QUALIFYING_AGENCY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobCertificationAgency qualifyingAgencyId;
    @JoinColumn(name = "QUALIFICATION_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobCertification qualificationId;
    @Column(name = "AUTHORIZED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date authorizedDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @Column(name = "OVERRIDE")
    private Character override;
    @Column(name = "IGNORE_PROFICIENCY")
    private Character ignoreProficiency;
    @Size(max = 4000)
    @Column(name = "COMMENTS")
    private String comments;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 255)
    @Column(name = "CERT_NO")
    private String certNo;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 20)
    @Column(name = "ACTIVE")
    private String active;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;

    public GlobContactCert() {
    }

    public GlobContactCert(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobContact getContactId() {
        return contactId;
    }

    public void setContactId(GlobContact contactId) {
        this.contactId = contactId;
    }

    public String getCertificationName() {
        StringBuilder rp = new StringBuilder();
        if (getQualifyingAgencyId() != null) {
            rp.append(getQualifyingAgencyId().getQualifyingAgency()).append(" ");
        }
        if (getQualificationId() != null) {
            rp.append(getQualificationId().getQualification());
        }
        return rp.toString();
    }

    public GlobCertificationAgency getQualifyingAgencyId() {
        return qualifyingAgencyId;
    }

    public void setQualifyingAgencyId(GlobCertificationAgency qualifyingAgencyId) {
        this.qualifyingAgencyId = qualifyingAgencyId;
    }

    public GlobCertification getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(GlobCertification qualificationId) {
        this.qualificationId = qualificationId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getAuthorizedDate() {
        return authorizedDate;
    }

    public void setAuthorizedDate(Date authorizedDate) {
        this.authorizedDate = authorizedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Character getOverride() {
        return override;
    }

    public void setOverride(Character override) {
        this.override = override;
    }

    public Character getIgnoreProficiency() {
        return ignoreProficiency;
    }

    public void setIgnoreProficiency(Character ignoreProficiency) {
        this.ignoreProficiency = ignoreProficiency;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getCertNo() {
        return certNo;
    }

    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(contactId)
                .append(qualifyingAgencyId)
                .append(qualificationId)
                .append(authorizedDate)
                .append(expirationDate)
                .append(override)
                .append(ignoreProficiency)
                .append(comments)
                .append(certNo)
                .toHashCode();
    }

    @Override
    public boolean equals(Object object) {        
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlobContactCert)) {
            return false;
        }
        GlobContactCert other = (GlobContactCert) object;

        return new EqualsBuilder()
                .append(this.contactId, other.contactId)
                .append(this.qualifyingAgencyId, other.qualifyingAgencyId)
                .append(this.qualificationId, other.qualificationId)
                .append(this.authorizedDate, other.authorizedDate)
                .append(this.expirationDate, other.expirationDate)
                .append(this.override, other.override)
                .append(this.ignoreProficiency, other.ignoreProficiency)
                .append(this.comments, other.comments)
                .append(this.certNo, other.certNo)
                .isEquals();
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.GlobContactCert[ id=" + id + " ]";
    }

}
