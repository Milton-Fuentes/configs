/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonBooleanCharacterDeserialize;
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

/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_CERTOFSRC_AUD")
@Table(name = "QA_INSPECTION_CERTOFSRC", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_CERTOFSRC SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionCertofsrc.findAll", query = "SELECT q FROM QaInspectionCertofsrc q"),
    @NamedQuery(name = "QaInspectionCertofsrc.findById", query = "SELECT q FROM QaInspectionCertofsrc q WHERE q.id = :id")})
public class QaInspectionCertofsrc implements Serializable {

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
    @Size(max = 512)
    @Column(name = "FABRICATOR_NAME")
    private String fabricatorName;
    @Size(max = 512)
    @Column(name = "FABRICATOR_LOCATION")
    private String fabricatorLocation;
    @Column(name = "TOTAL_ITEM_ON_CONTRACT")
    private BigInteger totalItemOnContract;
    @Size(max = 512)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    @Size(max = 512)
    @Column(name = "APPLICATION")
    private String application;
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
    @Size(max = 4000)
    @Column(name = "INSP_ADDINFO")
    private String inspAddinfo;
    @JsonDeserialize(using = JsonBooleanCharacterDeserialize.class)
    @Column(name = "SRC_HAS_BEEN_VERIFIED")
    private Character srcHasBeenVerified;
    @JsonDeserialize(using = JsonBooleanCharacterDeserialize.class)
    @Column(name = "CERT_OF_COMPLIANCE")
    private Character certOfCompliance;
    @JsonDeserialize(using = JsonBooleanCharacterDeserialize.class)
    @Column(name = "DO_NOT_USE")
    private Character doNotUse;
    @JsonDeserialize(using = JsonBooleanCharacterDeserialize.class)
    @Column(name = "SAMPLE_TEST")
    private Character sampleTest;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaInspectionCertofsrc() {
    }

    public QaInspectionCertofsrc(QaInspection id) {
        this.id = id;
    }

    public QaInspection getId() {
        return id;
    }

    public void setId(QaInspection id) {
        this.id = id;
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

    public BigInteger getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigInteger biditemId) {
        this.biditemId = biditemId;
    }

    @JsonGetter(value = "biditemFullName")
    public String getBiditemFullName() {
        return biditemFullName;
    }

    public void setBiditemFullName(String biditemFullName) {
        this.biditemFullName = biditemFullName;
    }

    public BigInteger getSubBiditemId() {
        return subBiditemId;
    }

    public void setSubBiditemId(BigInteger subBiditemId) {
        this.subBiditemId = subBiditemId;
    }

    @JsonGetter(value = "subBiditemFullName")
    public String getSubBiditemFullName() {
        return subBiditemFullName;
    }

    public void setSubBiditemFullName(String subBiditemFullName) {
        this.subBiditemFullName = subBiditemFullName;
    }

    public BigInteger getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(BigInteger supplierId) {
        this.supplierId = supplierId;
    }

    @JsonGetter(value = "supplierFullName")
    public String getSupplierFullName() {
        return supplierFullName;
    }

    public void setSupplierFullName(String supplierFullName) {
        this.supplierFullName = supplierFullName;
    }

    public BigInteger getSupplierLocationId() {
        return supplierLocationId;
    }

    public void setSupplierLocationId(BigInteger supplierLocationId) {
        this.supplierLocationId = supplierLocationId;
    }

    @JsonGetter(value = "supplierLocationName")
    public String getSupplierLocationName() {
        return supplierLocationName;
    }

    public void setSupplierLocationName(String supplierLocationName) {
        this.supplierLocationName = supplierLocationName;
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

    public String getSupplierType() {
        return supplierType;
    }

    public void setSupplierType(String supplierType) {
        this.supplierType = supplierType;
    }

    public String getFabricatorName() {
        return fabricatorName;
    }

    public void setFabricatorName(String fabricatorName) {
        this.fabricatorName = fabricatorName;
    }

    public String getFabricatorLocation() {
        return fabricatorLocation;
    }

    public void setFabricatorLocation(String fabricatorLocation) {
        this.fabricatorLocation = fabricatorLocation;
    }

    public BigInteger getTotalItemOnContract() {
        return totalItemOnContract;
    }

    public void setTotalItemOnContract(BigInteger totalItemOnContract) {
        this.totalItemOnContract = totalItemOnContract;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
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

    public String getInspAddinfo() {
        return inspAddinfo;
    }

    public void setInspAddinfo(String inspAddinfo) {
        this.inspAddinfo = inspAddinfo;
    }

    public Character getSrcHasBeenVerified() {
        return srcHasBeenVerified;
    }

    public void setSrcHasBeenVerified(Character srcHasBeenVerified) {
        this.srcHasBeenVerified = srcHasBeenVerified;
    }

    public Character getCertOfCompliance() {
        return certOfCompliance;
    }

    public void setCertOfCompliance(Character certOfCompliance) {
        this.certOfCompliance = certOfCompliance;
    }

    public Character getDoNotUse() {
        return doNotUse;
    }

    public void setDoNotUse(Character doNotUse) {
        this.doNotUse = doNotUse;
    }

    public Character getSampleTest() {
        return sampleTest;
    }

    public void setSampleTest(Character sampleTest) {
        this.sampleTest = sampleTest;
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
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.wbsitemId);
        hash = 23 * hash + Objects.hashCode(this.biditemId);
        hash = 23 * hash + Objects.hashCode(this.subBiditemId);
        hash = 23 * hash + Objects.hashCode(this.supplierId);
        hash = 23 * hash + Objects.hashCode(this.supplierLocationId);
        hash = 23 * hash + Objects.hashCode(this.supplierName);
        hash = 23 * hash + Objects.hashCode(this.supplierLocation);
        hash = 23 * hash + Objects.hashCode(this.fabricatorName);
        hash = 23 * hash + Objects.hashCode(this.fabricatorLocation);
        hash = 23 * hash + Objects.hashCode(this.totalItemOnContract);
        hash = 23 * hash + Objects.hashCode(this.productName);
        hash = 23 * hash + Objects.hashCode(this.application);
        hash = 23 * hash + Objects.hashCode(this.verifiedBy);
        hash = 23 * hash + Objects.hashCode(this.verifiedByName);
        hash = 23 * hash + Objects.hashCode(this.verifiedByJobtitle);
        hash = 23 * hash + Objects.hashCode(this.verifiedDate);
        hash = 23 * hash + Objects.hashCode(this.inspAddinfo);
        hash = 23 * hash + Objects.hashCode(this.srcHasBeenVerified);
        hash = 23 * hash + Objects.hashCode(this.certOfCompliance);
        hash = 23 * hash + Objects.hashCode(this.doNotUse);
        hash = 23 * hash + Objects.hashCode(this.sampleTest);
        hash = 23 * hash + Objects.hashCode(this.remarks);
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
        final QaInspectionCertofsrc other = (QaInspectionCertofsrc) obj;
        if (!Objects.equals(this.supplierName, other.supplierName)) {
            return false;
        }
        if (!Objects.equals(this.supplierLocation, other.supplierLocation)) {
            return false;
        }
        if (!Objects.equals(this.fabricatorName, other.fabricatorName)) {
            return false;
        }
        if (!Objects.equals(this.fabricatorLocation, other.fabricatorLocation)) {
            return false;
        }
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.application, other.application)) {
            return false;
        }
        if (!Objects.equals(this.verifiedByName, other.verifiedByName)) {
            return false;
        }
        if (!Objects.equals(this.verifiedByJobtitle, other.verifiedByJobtitle)) {
            return false;
        }
        if (!Objects.equals(this.inspAddinfo, other.inspAddinfo)) {
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
        if (!Objects.equals(this.totalItemOnContract, other.totalItemOnContract)) {
            return false;
        }
        if (!Objects.equals(this.verifiedBy, other.verifiedBy)) {
            return false;
        }
        if (!Objects.equals(this.verifiedDate, other.verifiedDate)) {
            return false;
        }
        if (!Objects.equals(this.srcHasBeenVerified, other.srcHasBeenVerified)) {
            return false;
        }
        if (!Objects.equals(this.certOfCompliance, other.certOfCompliance)) {
            return false;
        }
        if (!Objects.equals(this.doNotUse, other.doNotUse)) {
            return false;
        }
        if (!Objects.equals(this.sampleTest, other.sampleTest)) {
            return false;
        }
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "QaInspectionCertofsrc{" + "id=" + id + '}';
    }

}
