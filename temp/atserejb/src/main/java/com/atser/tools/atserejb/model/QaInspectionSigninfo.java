/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateTimeUSDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateTimeUSSerializer;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
 @NamedQuery(name = "QaInspectionSigninfo.findByClientId", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaInspectionSigninfo.findBySigned", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.signed = :signed"),
    @NamedQuery(name = "QaInspectionSigninfo.findBySignedBy", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.signedBy = :signedBy"),
    @NamedQuery(name = "QaInspectionSigninfo.findBySignedByName", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.signedByName = :signedByName"),
    @NamedQuery(name = "QaInspectionSigninfo.findBySignedDate", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.signedDate = :signedDate"),
    @NamedQuery(name = "QaInspectionSigninfo.findBySignedFromIp", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.signedFromIp = :signedFromIp"),
    @NamedQuery(name = "QaInspectionSigninfo.findByVersion", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_SIGNINFO_AUD")
@Table(name = "QA_INSPECTION_SIGNINFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionSigninfo.findAll", query = "SELECT q FROM QaInspectionSigninfo q"),
    @NamedQuery(name = "QaInspectionSigninfo.findById", query = "SELECT q FROM QaInspectionSigninfo q WHERE q.id = :id")})
public class QaInspectionSigninfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_SIGNINFO_SEQ", sequenceName = "QA_INSPECTION_SIGNINFO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_SIGNINFO_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "SIGNED")
    private Character signed;
    @Column(name = "SIGNED_BY")
    private BigInteger signedBy;
    @Size(max = 255)
    @Column(name = "SIGNED_BY_NAME")
    private String signedByName;
    @Size(max = 512)
    @Column(name = "SIGNED_BY_JOBTITLE")
    private String signedByJobtitle;
    @Column(name = "SIGNED_DATE")
    @Temporal(TemporalType.DATE)
    private Date signedDate;
    @Size(max = 50)
    @Column(name = "SIGNED_FROM_IP")
    private String signedFromIp;
    @Column(name = "SIGN_ORDER")
    private Integer signOrder;
    @Version
    @Column(name = "VERSION")
    private Integer version;
    @JoinColumn(name = "INSPECTION_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private QaInspection inspectionId;
    @JoinColumn(name = "SIGNFLOW_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private QaInspectionSignflowdef signflowId;
    @Transient
    private Boolean allowToSign;
    @Transient
    private Boolean enabledToSign;
    @Transient
    private Boolean enabledToUnapprove;
    @Transient
    private Boolean isLastSign;

    public QaInspectionSigninfo() {
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
    }

    public QaInspectionSigninfo(BigDecimal id) {
        this.id = id;
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
    }

    public QaInspectionSigninfo(BigInteger clientId, QaInspection inspectionId, QaInspectionSignflowdef signflowId, Integer signOrder) {
        this.clientId = clientId;
        this.inspectionId = inspectionId;
        this.signflowId = signflowId;
        this.signOrder = signOrder;
        this.signed = 'N';
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public Character getSigned() {
        return signed;
    }

    public void setSigned(Character signed) {
        this.signed = signed;
    }

    public BigInteger getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(BigInteger signedBy) {
        this.signedBy = signedBy;
    }

    public String getSignedByName() {
        return signedByName;
    }

    public void setSignedByName(String signedByName) {
        this.signedByName = signedByName;
    }

    public String getSignedByJobtitle() {
        return signedByJobtitle;
    }

    public void setSignedByJobtitle(String signedByJobtitle) {
        this.signedByJobtitle = signedByJobtitle;
    }

    @JsonSerialize(using = JsonDateTimeUSSerializer.class)
    @JsonDeserialize(using = JsonDateTimeUSDeserialize.class)
    public Date getSignedDate() {
        return signedDate;
    }

    public void setSignedDate(Date signedDate) {
        this.signedDate = signedDate;
    }

    public String getSignedFromIp() {
        return signedFromIp;
    }

    public void setSignedFromIp(String signedFromIp) {
        this.signedFromIp = signedFromIp;
    }

    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
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

    public QaInspectionSignflowdef getSignflowId() {
        return signflowId;
    }

    public void setSignflowId(QaInspectionSignflowdef signflowId) {
        this.signflowId = signflowId;
    }

    @JsonGetter(value = "allowToSign")
    public Boolean getAllowToSign() {
        return allowToSign;
    }

    public void setAllowToSign(Boolean allowToSign) {
        this.allowToSign = allowToSign;
    }

    @JsonGetter(value = "enabledToSign")
    public Boolean getEnabledToSign() {
        return enabledToSign;
    }

    public void setEnabledToSign(Boolean enabledToSign) {
        this.enabledToSign = enabledToSign;
    }

    @JsonGetter(value = "enabledToUnapprove")
    public Boolean getEnabledToUnapprove() {
        return enabledToUnapprove;
    }

    public void setEnabledToUnapprove(Boolean enabledToUnapprove) {
        this.enabledToUnapprove = enabledToUnapprove;
    }

    @JsonGetter(value = "isLastSign")
    public Boolean getIsLastSign() {
        return isLastSign;
    }

    public void setIsLastSign(Boolean isLastSign) {
        this.isLastSign = isLastSign;
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
        if (!(object instanceof QaInspectionSigninfo)) {
            return false;
        }
        QaInspectionSigninfo other = (QaInspectionSigninfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionSigninfo[ id=" + id + " ]";
    }

}
