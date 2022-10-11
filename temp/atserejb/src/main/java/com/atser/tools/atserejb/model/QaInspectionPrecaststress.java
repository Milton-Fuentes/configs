/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserejb.common.converter.JsonToMapConverter;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaInspectionPrecaststress.findByGpsLatitude", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.gpsLatitude = :gpsLatitude"),
    @NamedQuery(name = "QaInspectionPrecaststress.findByGpsLongitude", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.gpsLongitude = :gpsLongitude"),
    @NamedQuery(name = "QaInspectionPrecaststress.findByGpsAltitude", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.gpsAltitude = :gpsAltitude"),
    @NamedQuery(name = "QaInspectionPrecaststress.findByRemarks", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaInspectionPrecaststress.findByDeleted", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionPrecaststress.findByVersion", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_PRECASTSTRESS_AUD")
@Table(name = "QA_INSPECTION_PRECASTSTRESS", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_PRECASTSTRESS SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionPrecaststress.findAll", query = "SELECT q FROM QaInspectionPrecaststress q"),
    @NamedQuery(name = "QaInspectionPrecaststress.findById", query = "SELECT q FROM QaInspectionPrecaststress q WHERE q.id = :id")})
public class QaInspectionPrecaststress implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @JsonBackReference
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private QaInspection id;
    @Column(name = "WBSITEM_ID")
    private BigInteger wbsitemId;
    @Transient
    private String wbsitemFullName;
    @Column(name = "BIDITEM_ID")
    private BigInteger biditemId;
    @Transient
    private String biditemFullName;
    @Column(name = "SUB_BIDITEM_ID")
    private BigInteger subBiditemId;
    @Transient
    private String subBiditemFullName;
    @Column(name = "SUPPLIER_ID")
    private BigInteger supplierId;
    @Transient
    private String supplierFullName;
    @Column(name = "SUPPLIER_LOCATION_ID")
    private BigInteger supplierLocationId;
    @Transient
    private String supplierLocationName;
    @Column(name = "MIX_ID")
    private BigInteger mixId;
    @Transient
    private String mixName;
    @Column(name = "CAST_DATE")
    @Temporal(TemporalType.DATE)
    private Date castDate;
    @Column(name = "CATEGORY_ID")
    private BigInteger categoryId;
    @Transient
    private String categoryName;
    @Column(name = "CURING_ID")
    private BigInteger curingId;
    @Transient
    private String curingName;
    @Size(max = 4000)
    @Column(name = "ASSET_ADDINFO")
    private String assetAddinfo;
    @Column(name = "INSPECTED_BY")
    private BigInteger inspectedBy;
    @Size(max = 255)
    @Column(name = "INSPECTED_BY_NAME")
    private String inspectedByName;
    @Size(max = 512)
    @Column(name = "INSPECTED_BY_JOBTITLE")
    private String inspectedByJobtitle;
    @Size(max = 512)
    @Column(name = "INSPECTED_LOCATION")
    private String inspectedLocation;
    @Column(name = "INSPECTED_DATE")
    @Temporal(TemporalType.DATE)
    private Date inspectedDate;
    @Size(max = 512)
    @Column(name = "CITYTOWN")
    private String citytown;
    @Size(max = 512)
    @Column(name = "INSPECTION_ENTITY")
    private String inspectionEntity;
    @Size(max = 512)
    @Column(name = "ENTITY_LOCATION")
    private String entityLocation;
    @Column(name = "INSPECTOR_SUPERVISOR_ID")
    private BigInteger inspectorSupervisorId;
    @Transient
    private String inspectorSupervisorFullName;
    @Size(max = 50)
    @Column(name = "GPS_LATITUDE")
    private String gpsLatitude;
    @Size(max = 50)
    @Column(name = "GPS_LONGITUDE")
    private String gpsLongitude;
    @Size(max = 50)
    @Column(name = "GPS_ALTITUDE")
    private String gpsAltitude;
    @Size(max = 4000)
    @Column(name = "INSP_ADDINFO")
    private String inspAddinfo;
    @Lob
    @Convert(converter = JsonToMapConverter.class)
    @Column(name = "MQCA_INSP_ACTIVITIES")
    private Map<String, Object> mqcaInspActivities;
    @Lob
    @Convert(converter = JsonToMapConverter.class)
    @Column(name = "DEFECT_IDENT")
    private Map<String, Object> defectIdent;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaInspectionPrecaststress() {
    }

    public QaInspectionPrecaststress(QaInspection id) {
        this.id = id;
    }

    public QaInspection getId() {
        return id;
    }

    public void setId(QaInspection id) {
        this.id = id;
    }

    public BigInteger getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigInteger biditemId) {
        this.biditemId = biditemId;
    }

    public BigInteger getSubBiditemId() {
        return subBiditemId;
    }

    public void setSubBiditemId(BigInteger subBiditemId) {
        this.subBiditemId = subBiditemId;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    public BigInteger getSupplierLocationId() {
        return supplierLocationId;
    }

    public void setSupplierLocationId(BigInteger supplierLocationId) {
        this.supplierLocationId = supplierLocationId;
    }

    public BigInteger getMixId() {
        return mixId;
    }

    public void setMixId(BigInteger mixId) {
        this.mixId = mixId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCastDate() {
        return castDate;
    }

    public void setCastDate(Date castDate) {
        this.castDate = castDate;
    }

    public BigInteger getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigInteger categoryId) {
        this.categoryId = categoryId;
    }

    public BigInteger getCuringId() {
        return curingId;
    }

    public void setCuringId(BigInteger curingId) {
        this.curingId = curingId;
    }

    public String getAssetAddinfo() {
        return assetAddinfo;
    }

    public void setAssetAddinfo(String assetAddinfo) {
        this.assetAddinfo = assetAddinfo;
    }

    public BigInteger getInspectedBy() {
        return inspectedBy;
    }

    public void setInspectedBy(BigInteger inspectedBy) {
        this.inspectedBy = inspectedBy;
    }

    public String getInspectedByName() {
        return inspectedByName;
    }

    public void setInspectedByName(String inspectedByName) {
        this.inspectedByName = inspectedByName;
    }

    public String getInspectedByJobtitle() {
        return inspectedByJobtitle;
    }

    public void setInspectedByJobtitle(String inspectedByJobtitle) {
        this.inspectedByJobtitle = inspectedByJobtitle;
    }

    public String getInspectedLocation() {
        return inspectedLocation;
    }

    public void setInspectedLocation(String inspectedLocation) {
        this.inspectedLocation = inspectedLocation;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public String getCitytown() {
        return citytown;
    }

    public void setCitytown(String citytown) {
        this.citytown = citytown;
    }

    public String getInspectionEntity() {
        return inspectionEntity;
    }

    public void setInspectionEntity(String inspectionEntity) {
        this.inspectionEntity = inspectionEntity;
    }

    public String getEntityLocation() {
        return entityLocation;
    }

    public void setEntityLocation(String entityLocation) {
        this.entityLocation = entityLocation;
    }

    public BigInteger getInspectorSupervisorId() {
        return inspectorSupervisorId;
    }

    public void setInspectorSupervisorId(BigInteger inspectorSupervisorId) {
        this.inspectorSupervisorId = inspectorSupervisorId;
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

    public String getInspAddinfo() {
        return inspAddinfo;
    }

    public void setInspAddinfo(String inspAddinfo) {
        this.inspAddinfo = inspAddinfo;
    }

    public Map<String, Object> getMqcaInspActivities() {
        return mqcaInspActivities;
    }

    public void setMqcaInspActivities(Map<String, Object> mqcaInspActivities) {
        this.mqcaInspActivities = mqcaInspActivities;
    }

    public Map<String, Object> getDefectIdent() {
        return defectIdent;
    }

    public void setDefectIdent(Map<String, Object> defectIdent) {
        this.defectIdent = defectIdent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getDeleted() {
        return deleted;
    }

    public void setDeleted(Character deleted) {
        this.deleted = deleted;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.wbsitemId);
        hash = 29 * hash + Objects.hashCode(this.biditemId);
        hash = 29 * hash + Objects.hashCode(this.subBiditemId);
        hash = 29 * hash + Objects.hashCode(this.supplierId);
        hash = 29 * hash + Objects.hashCode(this.supplierLocationId);
        hash = 29 * hash + Objects.hashCode(this.mixId);
        hash = 29 * hash + Objects.hashCode(this.castDate);
        hash = 29 * hash + Objects.hashCode(this.categoryId);
        hash = 29 * hash + Objects.hashCode(this.curingId);
        hash = 29 * hash + Objects.hashCode(this.assetAddinfo);
        hash = 29 * hash + Objects.hashCode(this.inspectedBy);
        hash = 29 * hash + Objects.hashCode(this.inspectedByName);
        hash = 29 * hash + Objects.hashCode(this.inspectedByJobtitle);
        hash = 29 * hash + Objects.hashCode(this.inspectedLocation);
        hash = 29 * hash + Objects.hashCode(this.inspectedDate);
        hash = 29 * hash + Objects.hashCode(this.citytown);
        hash = 29 * hash + Objects.hashCode(this.inspectionEntity);
        hash = 29 * hash + Objects.hashCode(this.entityLocation);
        hash = 29 * hash + Objects.hashCode(this.inspectorSupervisorId);
        hash = 29 * hash + Objects.hashCode(this.gpsLatitude);
        hash = 29 * hash + Objects.hashCode(this.gpsLongitude);
        hash = 29 * hash + Objects.hashCode(this.gpsAltitude);
        hash = 29 * hash + Objects.hashCode(this.inspAddinfo);
        hash = 29 * hash + Objects.hashCode(this.mqcaInspActivities);
        hash = 29 * hash + Objects.hashCode(this.defectIdent);
        hash = 29 * hash + Objects.hashCode(this.remarks);
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
        final QaInspectionPrecaststress other = (QaInspectionPrecaststress) obj;
        if (!Objects.equals(this.assetAddinfo, other.assetAddinfo)) {
            return false;
        }
        if (!Objects.equals(this.inspectedByName, other.inspectedByName)) {
            return false;
        }
        if (!Objects.equals(this.inspectedByJobtitle, other.inspectedByJobtitle)) {
            return false;
        }
        if (!Objects.equals(this.inspectedLocation, other.inspectedLocation)) {
            return false;
        }
        if (!Objects.equals(this.citytown, other.citytown)) {
            return false;
        }
        if (!Objects.equals(this.inspectionEntity, other.inspectionEntity)) {
            return false;
        }
        if (!Objects.equals(this.entityLocation, other.entityLocation)) {
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
        if (!Objects.equals(this.inspAddinfo, other.inspAddinfo)) {
            return false;
        }
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        if (!Objects.equals(this.wbsitemId, other.wbsitemId)) {
            return false;
        }
        if (!Objects.equals(this.biditemId, other.biditemId)) {
            return false;
        }
        if (!Objects.equals(this.subBiditemId, other.subBiditemId)) {
            return false;
        }
        if (!Objects.equals(this.supplierId, other.supplierId)) {
            return false;
        }
        if (!Objects.equals(this.supplierLocationId, other.supplierLocationId)) {
            return false;
        }
        if (!Objects.equals(this.mixId, other.mixId)) {
            return false;
        }
        if (!Objects.equals(this.castDate, other.castDate)) {
            return false;
        }
        if (!Objects.equals(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!Objects.equals(this.curingId, other.curingId)) {
            return false;
        }
        if (!Objects.equals(this.inspectedBy, other.inspectedBy)) {
            return false;
        }
        if (!Objects.equals(this.inspectedDate, other.inspectedDate)) {
            return false;
        }
        if (!Objects.equals(this.inspectorSupervisorId, other.inspectorSupervisorId)) {
            return false;
        }
        if (!Objects.equals(this.mqcaInspActivities, other.mqcaInspActivities)) {
            return false;
        }
        if (!Objects.equals(this.defectIdent, other.defectIdent)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionPrecaststress[ id=" + id + " ]";
    }

    @JsonGetter(value = "biditemFullName")
    public String getBiditemFullName() {
        return biditemFullName;
    }

    public void setBiditemFullName(String biditemFullName) {
        this.biditemFullName = biditemFullName;
    }

    @JsonGetter(value = "subBiditemFullName")
    public String getSubBiditemFullName() {
        return subBiditemFullName;
    }

    public void setSubBiditemFullName(String subBiditemFullName) {
        this.subBiditemFullName = subBiditemFullName;
    }

    @JsonGetter(value = "supplierFullName")
    public String getSupplierFullName() {
        return supplierFullName;
    }

    public void setSupplierFullName(String supplierFullName) {
        this.supplierFullName = supplierFullName;
    }

    @JsonGetter(value = "supplierLocationName")
    public String getSupplierLocationName() {
        return supplierLocationName;
    }

    public void setSupplierLocationName(String supplierLocationName) {
        this.supplierLocationName = supplierLocationName;
    }

    @JsonGetter(value = "mixName")
    public String getMixName() {
        return mixName;
    }

    public void setMixName(String mixName) {
        this.mixName = mixName;
    }

    @JsonGetter(value = "categoryName")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @JsonGetter(value = "curingName")
    public String getCuringName() {
        return curingName;
    }

    public void setCuringName(String curingName) {
        this.curingName = curingName;
    }

    @JsonGetter(value = "inspectorSupervisorFullName")
    public String getInspectorSupervisorFullName() {
        return inspectorSupervisorFullName;
    }

    public void setInspectorSupervisorFullName(String inspectorSupervisorFullName) {
        this.inspectorSupervisorFullName = inspectorSupervisorFullName;
    }

    public BigInteger getWbsitemId() {
        return wbsitemId;
    }

    public void setWbsitemId(BigInteger wbsitemId) {
        this.wbsitemId = wbsitemId;
    }

    @JsonGetter(value = "wbsitemFullName")
    public String getWbsitemFullName() {
        return wbsitemFullName;
    }

    public void setWbsitemFullName(String wbsitemFullName) {
        this.wbsitemFullName = wbsitemFullName;
    }
}
