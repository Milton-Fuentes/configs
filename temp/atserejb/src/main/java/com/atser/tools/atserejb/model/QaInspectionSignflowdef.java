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
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaInspectionSignflowdef.findByClientId", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByCreated", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByCreatedBy", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByCreatedByIp", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByLastMod", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByLastModIp", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByLastModBy", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByDeleted", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByActive", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspectionSignflowdef.findByVersion", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.version = :version")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_SIGNFLOWDEF_AUD")
@Table(name = "QA_INSPECTION_SIGNFLOWDEF", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_SIGNFLOWDEF SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionSignflowdef.findAll", query = "SELECT q FROM QaInspectionSignflowdef q"),
    @NamedQuery(name = "QaInspectionSignflowdef.findById", query = "SELECT q FROM QaInspectionSignflowdef q WHERE q.id = :id")})
public class QaInspectionSignflowdef implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_SIGNFLOWDEF_SEQ", sequenceName = "QA_INSPECTION_SIGNFLOWDEF_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_SIGNFLOWDEF_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @NotNull
    @Size(max = 255)
    @Column(name = "SIGN_RULE_NAME")
    private String signRuleName;
    @Column(name = "SIGN_ORDER")
    private Integer signOrder;
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
    @JoinColumn(name = "SIMPLECAT_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private QaInspectionSimpleCat simplecatId;
    @JoinColumn(name = "INSPECTION_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private QaInspectionType inspectionTypeId;
    @JsonIgnore
    @OneToMany(mappedBy = "signflowId", fetch = FetchType.LAZY)
    private List<QaInspectionSigninfo> qaInspectionSigninfoList;

    public QaInspectionSignflowdef() {
    }

    public QaInspectionSignflowdef(BigDecimal id, String signRuleName) {
        this.id = id;
        this.signRuleName = signRuleName;
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

    public String getSignRuleName() {
        return signRuleName;
    }

    public void setSignRuleName(String signRuleName) {
        this.signRuleName = signRuleName;
    }

    public Integer getSignOrder() {
        return signOrder;
    }

    public void setSignOrder(Integer signOrder) {
        this.signOrder = signOrder;
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

    public QaInspectionSimpleCat getSimplecatId() {
        return simplecatId;
    }

    public void setSimplecatId(QaInspectionSimpleCat simplecatId) {
        this.simplecatId = simplecatId;
    }

    public QaInspectionType getInspectionTypeId() {
        return inspectionTypeId;
    }

    public void setInspectionTypeId(QaInspectionType inspectionTypeId) {
        this.inspectionTypeId = inspectionTypeId;
    }

    @XmlTransient
    public List<QaInspectionSigninfo> getQaInspectionSigninfoList() {
        return qaInspectionSigninfoList;
    }

    public void setQaInspectionSigninfoList(List<QaInspectionSigninfo> qaInspectionSigninfoList) {
        this.qaInspectionSigninfoList = qaInspectionSigninfoList;
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
        if (!(object instanceof QaInspectionSignflowdef)) {
            return false;
        }
        QaInspectionSignflowdef other = (QaInspectionSignflowdef) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionSignflowdef[ id=" + id + " ]";
    }
    
}
