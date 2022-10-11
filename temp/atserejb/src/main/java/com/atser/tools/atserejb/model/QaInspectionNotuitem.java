/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.objects.pojo.jasper.qa.inspection.InspectionUnusedItemPojo;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
@NamedQuery(name = "QaInspectionNotuitem.findByBiditemId", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.biditemId = :biditemId"),
    @NamedQuery(name = "QaInspectionNotuitem.findByReason", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.reason = :reason"),
    @NamedQuery(name = "QaInspectionNotuitem.findByCreated", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.created = :created"),
    @NamedQuery(name = "QaInspectionNotuitem.findByCreatedBy", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.createdBy = :createdBy"),
    @NamedQuery(name = "QaInspectionNotuitem.findByCreatedByIp", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.createdByIp = :createdByIp"),
    @NamedQuery(name = "QaInspectionNotuitem.findByLastMod", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaInspectionNotuitem.findByLastModIp", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaInspectionNotuitem.findByLastModBy", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaInspectionNotuitem.findByDeleted", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionNotuitem.findByActive", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.active = :active"),
    @NamedQuery(name = "QaInspectionNotuitem.findByVersion", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_NOTUITEM_AUD")
@SQLDelete(sql = "UPDATE QA_INSPECTION_NOTUITEM SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@Table(name = "QA_INSPECTION_NOTUITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionNotuitem.findAll", query = "SELECT q FROM QaInspectionNotuitem q"),
    @NamedQuery(name = "QaInspectionNotuitem.findById", query = "SELECT q FROM QaInspectionNotuitem q WHERE q.id = :id")})
public class QaInspectionNotuitem implements Serializable, Cloneable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QA_INSPECTION_NOTUITEM_SEQ", sequenceName = "QA_INSPECTION_NOTUITEM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QA_INSPECTION_NOTUITEM_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "WBSITEM_ID")
    @ManyToOne(optional = true)
    private VwTestPlanItem wbsitemId;
    @NotNull
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "BIDITEM_ID")
    @ManyToOne(optional = false)
    private VwTestPlanItem biditemId;
    @Size(max = 4000)
    @Column(name = "REASON")
    private String reason;
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
    @ManyToOne(optional = false)
    private QaInspection inspectionId;
    @JsonIgnore
    @Transient
    private List<String> biditemIdList;

    public QaInspectionNotuitem() {
    }

    public QaInspectionNotuitem(BigDecimal id) {
        this.id = id;
    }

    public QaInspectionNotuitem(BigDecimal id, VwTestPlanItem biditemId) {
        this.id = id;
        this.biditemId = biditemId;
    }

    public QaInspectionNotuitem(QaInspection inspectionId, VwTestPlanItem biditemId, String reason) {
        this.biditemId = biditemId;
        this.reason = reason;
        this.inspectionId = inspectionId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public VwTestPlanItem getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(VwTestPlanItem biditemId) {
        this.biditemId = biditemId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public VwTestPlanItem getWbsitemId() {
        return wbsitemId;
    }

    public void setWbsitemId(VwTestPlanItem wbsitemId) {
        this.wbsitemId = wbsitemId;
    }

    @JsonGetter(value = "biditemIdList")
    public List<String> getBiditemIdList() {
        return biditemIdList;
    }

    public void setBiditemIdList(List<String> biditemIdList) {
        this.biditemIdList = biditemIdList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.wbsitemId);
        hash = 67 * hash + Objects.hashCode(this.biditemId);
        hash = 67 * hash + Objects.hashCode(this.reason);
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
        final QaInspectionNotuitem other = (QaInspectionNotuitem) obj;
        if (!Objects.equals(this.reason, other.reason)) {
            return false;
        }
        if (!Objects.equals(this.wbsitemId, other.wbsitemId)) {
            return false;
        }
        if (!Objects.equals(this.biditemId, other.biditemId)) {
            return false;
        }
        return true;
    }

    @Override
    public QaInspectionNotuitem clone() {
        try {
            return (QaInspectionNotuitem) super.clone();
        } catch (CloneNotSupportedException e) {
            return new QaInspectionNotuitem(this.getInspectionId(), this.getBiditemId(), this.getReason());
        }
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionNotuitem[ id=" + id + " ]";
    }

    public InspectionUnusedItemPojo generateInspectionUnusedItemPojo() {
        InspectionUnusedItemPojo elem = new InspectionUnusedItemPojo();
        elem.setItemNo(this.biditemId.getItemNo());
        elem.setItemDescription(this.biditemId.getItemDescript());
        elem.setReason(this.reason);
        if(wbsitemId != null) {
            elem.setWbsItemNo(this.wbsitemId.getItemNo());
            elem.setWbsItemDescription(this.wbsitemId.getItemDescript());
        }
        return elem;
    }

}
