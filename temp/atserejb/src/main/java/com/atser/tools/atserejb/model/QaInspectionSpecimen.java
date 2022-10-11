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
@NamedQuery(name = "QaInspectionSpecimen.findBySno", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.sno = :sno"),
    @NamedQuery(name = "QaInspectionSpecimen.findBySpecNo", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.specNo = :specNo"),
    @NamedQuery(name = "QaInspectionSpecimen.findByGpsLatitude", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.gpsLatitude = :gpsLatitude"),
    @NamedQuery(name = "QaInspectionSpecimen.findByGpsLongitude", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.gpsLongitude = :gpsLongitude"),
    @NamedQuery(name = "QaInspectionSpecimen.findByGpsAltitude", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.gpsAltitude = :gpsAltitude"),
    @NamedQuery(name = "QaInspectionSpecimen.findByCreated", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspectionSpecimen.findByCreatedBy", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspectionSpecimen.findByCreatedByIp", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspectionSpecimen.findByLastMod", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspectionSpecimen.findByLastModIp", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspectionSpecimen.findByLastModBy", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspectionSpecimen.findByDeleted", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionSpecimen.findByActive", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspectionSpecimen.findByVersion", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_SPECIMEN_AUD")
@Table(name = "QA_INSPECTION_SPECIMEN", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_SPECIMEN SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionSpecimen.findAll", query = "SELECT q FROM QaInspectionSpecimen q"),
    @NamedQuery(name = "QaInspectionSpecimen.findById", query = "SELECT q FROM QaInspectionSpecimen q WHERE q.id = :id")})
public class QaInspectionSpecimen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_SPECIMEN_SEQ", sequenceName = "QA_INSPECTION_SPECIMEN_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_SPECIMEN_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "SNO")
    private String sno;
    @Size(max = 50)
    @Column(name = "SPEC_NO")
    private String specNo;
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

    public QaInspectionSpecimen() {
    }

    public QaInspectionSpecimen(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
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
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        hash = 31 * hash + Objects.hashCode(this.specNo);
        hash = 31 * hash + Objects.hashCode(this.gpsLatitude);
        hash = 31 * hash + Objects.hashCode(this.gpsLongitude);
        hash = 31 * hash + Objects.hashCode(this.gpsAltitude);
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
        final QaInspectionSpecimen other = (QaInspectionSpecimen) obj;
        if (!Objects.equals(this.specNo, other.specNo)) {
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionSpecimen[ id=" + id + " ]";
    }

}
