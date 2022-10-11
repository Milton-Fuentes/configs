/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author mfuentes
 */
@Entity
@Table(name = "QA_SAMPLE_TEST_BILLING_ITEM", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_SAMPLE_TEST_BILLING_ITEM SET active = 'N' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "active = 'Y'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaSampleTestBillingItem.findAll", query = "SELECT q FROM QaSampleTestBillingItem q"),
    @NamedQuery(name = "QaSampleTestBillingItem.findById", query = "SELECT q FROM QaSampleTestBillingItem q WHERE q.id = :id")})
public class QaSampleTestBillingItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "QA_SAMPLE_TEST_BILLING_ITEM_ID_SEQ", sequenceName = "QA_SAMPLE_TEST_BILLING_ITEM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_SAMPLE_TEST_BILLING_ITEM_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLE_TEST_ID")
    private BigInteger sampleTestId;
    @JoinColumn(name = "BILLING_CODE_ID")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private GlobBillingCode billingCodeId;
    @Size(max = 20)
    @Column(name = "UNITS")
    private String units;
    @Column(name = "ITEM_ID")
    private String itemId;
    @Size(max = 4000)
    @Column(name = "CREATE_BY")
    private String createBy;
    @Size(max = 4000)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Column(name = "EXPORTED")
    private Character exported;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "APPROVEDBY")
    private String approvedby;
    @Column(name = "UNAPPROVED")
    private Character unapproved;
    @Size(max = 50)
    @Column(name = "UNAPPROVED_BY")
    private String unapprovedBy;
    @Size(max = 4000)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 4000)
    @Column(name = "CREATE_DATE_TMP")
    private String createDateTmp;
    @Size(max = 4000)
    @Column(name = "LAST_MOD_TMP")
    private String lastModTmp;
    @Size(max = 4000)
    @Column(name = "EXPORTED_DATE_TMP")
    private String exportedDateTmp;
    @Size(max = 4000)
    @Column(name = "APPROVE_DATE_TMP")
    private String approveDateTmp;
    @Column(name = "EXPORTED_DATE")
    private Date exportedDate;
    @Column(name = "APPROVE_DATE")
    private Date approveDate;
    @Size(max = 50)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @Size(max = 50)
    @Column(name = "CREATE_DATE")
    private String createDate;
    @Size(max = 50)
    @Column(name = "OVERRIDE_UNIT_PRICE")
    private String overrideUnit_price;
    @Size(max = 50)
    @Column(name = "OVERRIDE_COMMENTS")
    private String overrideComments;
    @Size(max = 50)
    @Column(name = "OVERRIDE_DESCRIPTION")
    private String overrideDescription;

    public QaSampleTestBillingItem() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(BigInteger sampleTestId) {
        this.sampleTestId = sampleTestId;
    }

    public GlobBillingCode getBillingCodeId() {
        return billingCodeId;
    }

    public void setBillingCodeId(GlobBillingCode billingCodeId) {
        this.billingCodeId = billingCodeId;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Character getExported() {
        return exported;
    }

    public void setExported(Character exported) {
        this.exported = exported;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public Character getUnapproved() {
        return unapproved;
    }

    public void setUnapproved(Character unapproved) {
        this.unapproved = unapproved;
    }

    public String getUnapprovedBy() {
        return unapprovedBy;
    }

    public void setUnapprovedBy(String unapprovedBy) {
        this.unapprovedBy = unapprovedBy;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateDateTmp() {
        return createDateTmp;
    }

    public void setCreateDateTmp(String createDateTmp) {
        this.createDateTmp = createDateTmp;
    }

    public String getLastModTmp() {
        return lastModTmp;
    }

    public void setLastModTmp(String lastModTmp) {
        this.lastModTmp = lastModTmp;
    }

    public String getExportedDateTmp() {
        return exportedDateTmp;
    }

    public void setExportedDateTmp(String exportedDateTmp) {
        this.exportedDateTmp = exportedDateTmp;
    }

    public String getApproveDateTmp() {
        return approveDateTmp;
    }

    public void setApproveDateTmp(String approveDateTmp) {
        this.approveDateTmp = approveDateTmp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExportedDate() {
        return exportedDate;
    }

    public void setExportedDate(Date exportedDate) {
        this.exportedDate = exportedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getOverrideUnit_price() {
        return overrideUnit_price;
    }

    public void setOverrideUnit_price(String overrideUnit_price) {
        this.overrideUnit_price = overrideUnit_price;
    }

    public String getOverrideComments() {
        return overrideComments;
    }

    public void setOverrideComments(String overrideComments) {
        this.overrideComments = overrideComments;
    }

    public String getOverrideDescription() {
        return overrideDescription;
    }

    public void setOverrideDescription(String overrideDescription) {
        this.overrideDescription = overrideDescription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaSampleTest)) {
            return false;
        }
        QaSampleTestBillingItem other = (QaSampleTestBillingItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaSampleTestBillingItem[ id=" + id + " ]";
    }

}
