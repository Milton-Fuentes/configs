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
@NamedQuery(name = "QaInspectionQcml.findByProductBarchNo", query = "SELECT q FROM QaInspectionQcml q WHERE q.productBarchNo = :productBarchNo"),
    @NamedQuery(name = "QaInspectionQcml.findByProductIdentificationNo", query = "SELECT q FROM QaInspectionQcml q WHERE q.productIdentificationNo = :productIdentificationNo"),
    @NamedQuery(name = "QaInspectionQcml.findByCastingDate", query = "SELECT q FROM QaInspectionQcml q WHERE q.castingDate = :castingDate"),
    @NamedQuery(name = "QaInspectionQcml.findByExpirationDate", query = "SELECT q FROM QaInspectionQcml q WHERE q.expirationDate = :expirationDate"),
    @NamedQuery(name = "QaInspectionQcml.findByRemarks", query = "SELECT q FROM QaInspectionQcml q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaInspectionQcml.findByDeleted", query = "SELECT q FROM QaInspectionQcml q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionQcml.findByVersion", query = "SELECT q FROM QaInspectionQcml q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_QCML_AUD")
@Table(name = "QA_INSPECTION_QCML", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_QCML SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionQcml.findAll", query = "SELECT q FROM QaInspectionQcml q"),
    @NamedQuery(name = "QaInspectionQcml.findById", query = "SELECT q FROM QaInspectionQcml q WHERE q.id = :id")})
public class QaInspectionQcml implements Serializable {

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
    @Column(name = "QCML_CATEGORY_ID")
    private BigInteger qcmlCategoryId;
    @Transient
    private String qcmlCategoryName;
    @Size(max = 512)
    @Column(name = "PRODUCT_TYPE")
    private String productType;
    @Size(max = 50)
    @Column(name = "PRODUCT_BARCH_NO")
    private String productBarchNo;
    @Size(max = 50)
    @Column(name = "PRODUCT_IDENTIFICATION_NO")
    private String productIdentificationNo;
    @Column(name = "VERIFIED_BY")
    private BigInteger verifiedBy;
    @Size(max = 255)
    @Column(name = "VERIFIED_BY_NAME")
    private String verifiedByName;
    @Size(max = 512)
    @Column(name = "VERIFIED_BY_JOBTITLE")
    private String verifiedByJobtitle;
    @Column(name = "VERIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date verifiedDate;
    @Column(name = "CASTING_DATE")
    @Temporal(TemporalType.DATE)
    private Date castingDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;
    @Column(name = "APPROVED_DATE")
    @Temporal(TemporalType.DATE)
    private Date approvedDate;
    @Size(max = 4000)
    @Column(name = "QCML_ADDINFO")
    private String qcmlAddinfo;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaInspectionQcml() {
    }

    public QaInspectionQcml(QaInspection id) {
        this.id = id;
    }

    public QaInspection getId() {
        return id;
    }

    public void setId(QaInspection id) {
        this.id = id;
    }

    public String getProductBarchNo() {
        return productBarchNo;
    }

    public void setProductBarchNo(String productBarchNo) {
        this.productBarchNo = productBarchNo;
    }

    public String getProductIdentificationNo() {
        return productIdentificationNo;
    }

    public void setProductIdentificationNo(String productIdentificationNo) {
        this.productIdentificationNo = productIdentificationNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCastingDate() {
        return castingDate;
    }

    public void setCastingDate(Date castingDate) {
        this.castingDate = castingDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

    public BigInteger getQcmlCategoryId() {
        return qcmlCategoryId;
    }

    public void setQcmlCategoryId(BigInteger qcmlCategoryId) {
        this.qcmlCategoryId = qcmlCategoryId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigInteger getVerifiedBy() {
        return verifiedBy;
    }

    public void setVerifiedBy(BigInteger verifiedBy) {
        this.verifiedBy = verifiedBy;
    }

    public String getVerifiedByName() {
        return verifiedByName;
    }

    public void setVerifiedByName(String verifiedByName) {
        this.verifiedByName = verifiedByName;
    }

    public String getVerifiedByJobtitle() {
        return verifiedByJobtitle;
    }

    public void setVerifiedByJobtitle(String verifiedByJobtitle) {
        this.verifiedByJobtitle = verifiedByJobtitle;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getVerifiedDate() {
        return verifiedDate;
    }

    public void setVerifiedDate(Date verifiedDate) {
        this.verifiedDate = verifiedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getQcmlAddinfo() {
        return qcmlAddinfo;
    }

    public void setQcmlAddinfo(String qcmlAddinfo) {
        this.qcmlAddinfo = qcmlAddinfo;
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
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.wbsitemId);
        hash = 67 * hash + Objects.hashCode(this.biditemId);
        hash = 67 * hash + Objects.hashCode(this.subBiditemId);
        hash = 67 * hash + Objects.hashCode(this.supplierId);
        hash = 67 * hash + Objects.hashCode(this.supplierLocationId);
        hash = 67 * hash + Objects.hashCode(this.supplierName);
        hash = 67 * hash + Objects.hashCode(this.supplierLocation);
        hash = 67 * hash + Objects.hashCode(this.qcmlCategoryId);
        hash = 67 * hash + Objects.hashCode(this.productType);
        hash = 67 * hash + Objects.hashCode(this.productBarchNo);
        hash = 67 * hash + Objects.hashCode(this.productIdentificationNo);
        hash = 67 * hash + Objects.hashCode(this.verifiedBy);
        hash = 67 * hash + Objects.hashCode(this.verifiedByName);
        hash = 67 * hash + Objects.hashCode(this.verifiedByJobtitle);
        hash = 67 * hash + Objects.hashCode(this.verifiedDate);
        hash = 67 * hash + Objects.hashCode(this.castingDate);
        hash = 67 * hash + Objects.hashCode(this.expirationDate);
        hash = 67 * hash + Objects.hashCode(this.approvedDate);
        hash = 67 * hash + Objects.hashCode(this.qcmlAddinfo);
        hash = 67 * hash + Objects.hashCode(this.remarks);
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
        final QaInspectionQcml other = (QaInspectionQcml) obj;
        if (!Objects.equals(this.productType, other.productType)) {
            return false;
        }
        if (!Objects.equals(this.productBarchNo, other.productBarchNo)) {
            return false;
        }
        if (!Objects.equals(this.productIdentificationNo, other.productIdentificationNo)) {
            return false;
        }
        if (!Objects.equals(this.verifiedByName, other.verifiedByName)) {
            return false;
        }
        if (!Objects.equals(this.verifiedByJobtitle, other.verifiedByJobtitle)) {
            return false;
        }
        if (!Objects.equals(this.qcmlAddinfo, other.qcmlAddinfo)) {
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
        if (!Objects.equals(this.qcmlCategoryId, other.qcmlCategoryId)) {
            return false;
        }
        if (!Objects.equals(this.verifiedBy, other.verifiedBy)) {
            return false;
        }
        if (!Objects.equals(this.verifiedDate, other.verifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.castingDate, other.castingDate)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        if (!Objects.equals(this.approvedDate, other.approvedDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionQcml[ id=" + id + " ]";
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

    @JsonGetter(value = "qcmlCategoryName")
    public String getQcmlCategoryName() {
        return qcmlCategoryName;
    }

    public void setQcmlCategoryName(String qcmlCategoryName) {
        this.qcmlCategoryName = qcmlCategoryName;
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
