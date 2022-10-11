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
@NamedQuery(name = "QaInspectionSimpleCat.findByClientId", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.clientId = :clientId"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByCode", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.code = :code"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByShortName", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.shortName = :shortName"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByName", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.name = :name"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByCreated", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByCreatedBy", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByCreatedByIp", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByLastMod", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByLastModIp", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByLastModBy", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByDeleted", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByActive", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspectionSimpleCat.findByVersion", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_SIMPLE_CAT_AUD")
@SQLDelete(sql = "UPDATE QA_INSPECTION_SIMPLE_CAT SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "QA_INSPECTION_SIMPLE_CAT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionSimpleCat.findAll", query = "SELECT q FROM QaInspectionSimpleCat q"),
    @NamedQuery(name = "QaInspectionSimpleCat.findById", query = "SELECT q FROM QaInspectionSimpleCat q WHERE q.id = :id")})
public class QaInspectionSimpleCat implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_SIMPLE_CAT_SEQ", sequenceName = "QA_INSPECTION_SIMPLE_CAT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_SIMPLE_CAT_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "CODE")
    private String code;
    @Size(max = 50)
    @Column(name = "SHORT_NAME")
    private String shortName;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Column(name = "CAT_ORDER")
    private Integer catOrder;
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
    @JsonIgnore
    @OneToMany(mappedBy = "simplecatId", fetch = FetchType.LAZY)
    private List<QaInspection> qaInspectionList;
    @JsonIgnore
    @OneToMany(mappedBy = "simplecatId", fetch = FetchType.LAZY)
    private List<QaInspectionSignflowdef> qaInspectionSignflowdefList;
    @JsonIgnore
    @JoinColumn(name = "INSPECTION_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private QaInspectionType inspectionTypeId;

    public QaInspectionSimpleCat() {
    }

    public QaInspectionSimpleCat(BigDecimal id) {
        this.id = id;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCatOrder() {
        return catOrder;
    }

    public void setCatOrder(Integer catOrder) {
        this.catOrder = catOrder;
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

    @XmlTransient
    public List<QaInspection> getQaInspectionList() {
        return qaInspectionList;
    }

    public void setQaInspectionList(List<QaInspection> qaInspectionList) {
        this.qaInspectionList = qaInspectionList;
    }

    @XmlTransient
    public List<QaInspectionSignflowdef> getQaInspectionSignflowdefList() {
        return qaInspectionSignflowdefList;
    }

    public void setQaInspectionSignflowdefList(List<QaInspectionSignflowdef> qaInspectionSignflowdefList) {
        this.qaInspectionSignflowdefList = qaInspectionSignflowdefList;
    }

    public QaInspectionType getInspectionTypeId() {
        return inspectionTypeId;
    }

    public void setInspectionTypeId(QaInspectionType inspectionTypeId) {
        this.inspectionTypeId = inspectionTypeId;
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
        if (!(object instanceof QaInspectionSimpleCat)) {
            return false;
        }
        QaInspectionSimpleCat other = (QaInspectionSimpleCat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionSimpleCat[ id=" + id + " ]";
    }

}
