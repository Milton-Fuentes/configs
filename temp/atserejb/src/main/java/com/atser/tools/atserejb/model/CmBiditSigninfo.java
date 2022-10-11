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

/*
@NamedQuery(name = "CmBiditSigninfo.findByClientId", query = "SELECT c FROM CmBiditSigninfo c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignOrder", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signOrder = :signOrder"),
    @NamedQuery(name = "CmBiditSigninfo.findBySigned", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signed = :signed"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignedBy", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signedBy = :signedBy"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignedByName", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signedByName = :signedByName"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignedByJobtitle", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signedByJobtitle = :signedByJobtitle"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignedDate", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signedDate = :signedDate"),
    @NamedQuery(name = "CmBiditSigninfo.findBySignedFromIp", query = "SELECT c FROM CmBiditSigninfo c WHERE c.signedFromIp = :signedFromIp"),
    @NamedQuery(name = "CmBiditSigninfo.findByVersion", query = "SELECT c FROM CmBiditSigninfo c WHERE c.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "CM_BIDIT_SIGNINFO", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CmBiditSigninfo.findAll", query = "SELECT c FROM CmBiditSigninfo c"),
    @NamedQuery(name = "CmBiditSigninfo.findById", query = "SELECT c FROM CmBiditSigninfo c WHERE c.id = :id")})
public class CmBiditSigninfo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "CM_BIDIT_SIGNINFO_SEQ", sequenceName = "CM_BIDIT_SIGNINFO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CM_BIDIT_SIGNINFO_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Column(name = "SIGN_ORDER")
    private BigInteger signOrder;
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date signedDate;
    @Size(max = 50)
    @Column(name = "SIGNED_FROM_IP")
    private String signedFromIp;
    @Version
    @Column(name = "VERSION")
    private Integer version;
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GlobSystemSimpleCat typeId;
    @Column(name = "REF_ID")
    private BigInteger refId;
    @JoinColumn(name = "SIGNFLOW_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private CmBiditSignflowdef signflowId;
    @Transient
    private Boolean allowToSign;
    @Transient
    private Boolean enabledToSign;
    @Transient
    private Boolean enabledToUnapprove;
    @Transient
    private Boolean isLastSign;

    public CmBiditSigninfo() {
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
    }

    public CmBiditSigninfo(BigDecimal id) {
        this.id = id;
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
    }

    public CmBiditSigninfo(BigInteger clientId, BigInteger signOrder, BigInteger refId, CmBiditSignflowdef signflowId, GlobSystemSimpleCat typeId) {
        this.clientId = clientId;
        this.signOrder = signOrder;
        this.refId = refId;
        this.signflowId = signflowId;
        this.signed = 'N';
        this.allowToSign = false;
        this.enabledToSign = false;
        this.enabledToUnapprove = false;
        this.isLastSign = false;
        this.typeId = typeId;
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

    public BigInteger getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(BigInteger signOrder) {
        this.signOrder = signOrder;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public GlobSystemSimpleCat getTypeId() {
        return typeId;
    }

    public void setTypeId(GlobSystemSimpleCat typeId) {
        this.typeId = typeId;
    }

    public BigInteger getRefId() {
        return refId;
    }

    public void setRefId(BigInteger refId) {
        this.refId = refId;
    }

    public CmBiditSignflowdef getSignflowId() {
        return signflowId;
    }

    public void setSignflowId(CmBiditSignflowdef signflowId) {
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
        if (!(object instanceof CmBiditSigninfo)) {
            return false;
        }
        CmBiditSigninfo other = (CmBiditSigninfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.CmBiditSigninfo[ id=" + id + " ]";
    }
    
}
