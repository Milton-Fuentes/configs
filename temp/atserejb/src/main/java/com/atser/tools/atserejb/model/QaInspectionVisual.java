/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@NamedQuery(name = "QaInspectionVisual.findByInspectedDate", query = "SELECT q FROM QaInspectionVisual q WHERE q.inspectedDate = :inspectedDate"),
    @NamedQuery(name = "QaInspectionVisual.findByGpsLatitude", query = "SELECT q FROM QaInspectionVisual q WHERE q.gpsLatitude = :gpsLatitude"),
    @NamedQuery(name = "QaInspectionVisual.findByGpsLongitude", query = "SELECT q FROM QaInspectionVisual q WHERE q.gpsLongitude = :gpsLongitude"),
    @NamedQuery(name = "QaInspectionVisual.findByGpsAltitude", query = "SELECT q FROM QaInspectionVisual q WHERE q.gpsAltitude = :gpsAltitude"),
    @NamedQuery(name = "QaInspectionVisual.findByRemarks", query = "SELECT q FROM QaInspectionVisual q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaInspectionVisual.findByDeleted", query = "SELECT q FROM QaInspectionVisual q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionVisual.findByVersion", query = "SELECT q FROM QaInspectionVisual q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_VISUAL_AUD")
@Table(name = "QA_INSPECTION_VISUAL", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_VISUAL SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionVisual.findAll", query = "SELECT q FROM QaInspectionVisual q"),
    @NamedQuery(name = "QaInspectionVisual.findById", query = "SELECT q FROM QaInspectionVisual q WHERE q.id = :id")})
public class QaInspectionVisual implements Serializable {

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
    @Size(max = 512)
    @Column(name = "SUPPLIER_NAME")
    private String supplierName;
    @Size(max = 512)
    @Column(name = "SUPPLIER_LOCATION")
    private String supplierLocation;
    @Size(max = 10)
    @Column(name = "SUPPLIER_TYPE")
    private String supplierType;
    @Size(max = 50)
    @Column(name = "PROPOSED_USE")
    private String proposedUse;
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
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaInspectionVisual() {
    }

    public QaInspectionVisual(QaInspection id) {
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

    public String getProposedUse() {
        return proposedUse;
    }

    public void setProposedUse(String proposedUse) {
        this.proposedUse = proposedUse;
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

    public String getCitytown() {
        return citytown;
    }

    public void setCitytown(String citytown) {
        this.citytown = citytown;
    }

    public String getInspAddinfo() {
        return inspAddinfo;
    }

    public void setInspAddinfo(String inspAddinfo) {
        this.inspAddinfo = inspAddinfo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInspectedDate() {
        return inspectedDate;
    }

    public void setInspectedDate(Date inspectedDate) {
        this.inspectedDate = inspectedDate;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierLocation() {
        return supplierLocation;
    }

    public void setSupplierLocation(String supplierLocation) {
        this.supplierLocation = supplierLocation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.wbsitemId);
        hash = 17 * hash + Objects.hashCode(this.biditemId);
        hash = 17 * hash + Objects.hashCode(this.subBiditemId);
        hash = 17 * hash + Objects.hashCode(this.supplierId);
        hash = 17 * hash + Objects.hashCode(this.supplierLocationId);
        hash = 17 * hash + Objects.hashCode(this.supplierName);
        hash = 17 * hash + Objects.hashCode(this.supplierLocation);
        hash = 17 * hash + Objects.hashCode(this.proposedUse);
        hash = 17 * hash + Objects.hashCode(this.assetAddinfo);
        hash = 17 * hash + Objects.hashCode(this.inspectedBy);
        hash = 17 * hash + Objects.hashCode(this.inspectedByName);
        hash = 17 * hash + Objects.hashCode(this.inspectedByJobtitle);
        hash = 17 * hash + Objects.hashCode(this.inspectedLocation);
        hash = 17 * hash + Objects.hashCode(this.inspectedDate);
        hash = 17 * hash + Objects.hashCode(this.citytown);
        hash = 17 * hash + Objects.hashCode(this.gpsLatitude);
        hash = 17 * hash + Objects.hashCode(this.gpsLongitude);
        hash = 17 * hash + Objects.hashCode(this.gpsAltitude);
        hash = 17 * hash + Objects.hashCode(this.inspAddinfo);
        hash = 17 * hash + Objects.hashCode(this.remarks);
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
        final QaInspectionVisual other = (QaInspectionVisual) obj;
        if (!Objects.equals(this.proposedUse, other.proposedUse)) {
            return false;
        }
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
        if (!Objects.equals(this.supplierName, other.supplierName)) {
            return false;
        }
        if (!Objects.equals(this.supplierLocation, other.supplierLocation)) {
            return false;
        }
        if (!Objects.equals(this.inspectedBy, other.inspectedBy)) {
            return false;
        }
        if (!Objects.equals(this.inspectedDate, other.inspectedDate)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionVisual[ id=" + id + " ]";
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

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
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
