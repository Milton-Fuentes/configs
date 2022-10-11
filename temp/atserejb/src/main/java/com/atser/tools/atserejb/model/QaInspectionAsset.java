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
import java.util.Date;
import java.util.Objects;
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
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaInspectionAsset.findByAssetNo", query = "SELECT q FROM QaInspectionAsset q WHERE q.assetNo = :assetNo"),
    @NamedQuery(name = "QaInspectionAsset.findByGpsLatitude", query = "SELECT q FROM QaInspectionAsset q WHERE q.gpsLatitude = :gpsLatitude"),
    @NamedQuery(name = "QaInspectionAsset.findByGpsLongitude", query = "SELECT q FROM QaInspectionAsset q WHERE q.gpsLongitude = :gpsLongitude"),
    @NamedQuery(name = "QaInspectionAsset.findByGpsAltitude", query = "SELECT q FROM QaInspectionAsset q WHERE q.gpsAltitude = :gpsAltitude"),
    @NamedQuery(name = "QaInspectionAsset.findByCreated", query = "SELECT q FROM QaInspectionAsset q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspectionAsset.findByCreatedBy", query = "SELECT q FROM QaInspectionAsset q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspectionAsset.findByCreatedByIp", query = "SELECT q FROM QaInspectionAsset q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspectionAsset.findByLastMod", query = "SELECT q FROM QaInspectionAsset q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspectionAsset.findByLastModIp", query = "SELECT q FROM QaInspectionAsset q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspectionAsset.findByLastModBy", query = "SELECT q FROM QaInspectionAsset q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspectionAsset.findByDeleted", query = "SELECT q FROM QaInspectionAsset q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionAsset.findByActive", query = "SELECT q FROM QaInspectionAsset q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspectionAsset.findByVersion", query = "SELECT q FROM QaInspectionAsset q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_ASSET_AUD")
@Table(name = "QA_INSPECTION_ASSET", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_ASSET SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionAsset.findAll", query = "SELECT q FROM QaInspectionAsset q"),
    @NamedQuery(name = "QaInspectionAsset.findById", query = "SELECT q FROM QaInspectionAsset q WHERE q.id = :id")})
public class QaInspectionAsset implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_ASSET_SEQ", sequenceName = "QA_INSPECTION_ASSET_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_ASSET_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "ASSET_NO")
    private String assetNo;
    @Size(max = 50)
    @Column(name = "GPS_LATITUDE")
    private String gpsLatitude;
    @Size(max = 50)
    @Column(name = "GPS_LONGITUDE")
    private String gpsLongitude;
    @Size(max = 50)
    @Column(name = "GPS_ALTITUDE")
    private String gpsAltitude;
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Size(max = 255)
    @Column(name = "CREATED_BY")
    private String createdBy;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "CREATED_BY_IP")
    private String createdByIp;
    @Column(name = "LAST_MOD")
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
    @JoinColumn(name = "INSPECTION_ID", referencedColumnName = "ID")
    @ManyToOne
    private QaInspection inspectionId;

    public QaInspectionAsset() {
    }

    public QaInspectionAsset(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(String gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(String gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getGpsAltitude() {
        return gpsAltitude;
    }

    public void setGpsAltitude(String gpsAltitude) {
        this.gpsAltitude = gpsAltitude;
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

    public QaInspection getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(QaInspection inspectionId) {
        this.inspectionId = inspectionId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.assetNo);
        hash = 17 * hash + Objects.hashCode(this.gpsLatitude);
        hash = 17 * hash + Objects.hashCode(this.gpsLongitude);
        hash = 17 * hash + Objects.hashCode(this.gpsAltitude);
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
        final QaInspectionAsset other = (QaInspectionAsset) obj;
        if (!Objects.equals(this.assetNo, other.assetNo)) {
            return false;
        }
        if (!Objects.equals(this.gpsLatitude, other.gpsLatitude)) {
            return false;
        }
        if (!Objects.equals(this.gpsLongitude, other.gpsLongitude)) {
            return false;
        }
        if (!Objects.equals(this.gpsAltitude, other.gpsAltitude)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionAsset[ id=" + id + " ]";
    }

}
