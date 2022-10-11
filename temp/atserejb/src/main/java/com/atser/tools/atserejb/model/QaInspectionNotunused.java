/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

/*
@NamedQuery(name = "QaInspectionNotunused.findByVerifiedBy", query = "SELECT q FROM QaInspectionNotunused q WHERE q.verifiedBy = :verifiedBy"),
    @NamedQuery(name = "QaInspectionNotunused.findByVerifiedDate", query = "SELECT q FROM QaInspectionNotunused q WHERE q.verifiedDate = :verifiedDate"),
    @NamedQuery(name = "QaInspectionNotunused.findByUnusedItemsNo", query = "SELECT q FROM QaInspectionNotunused q WHERE q.unusedItemsNo = :unusedItemsNo"),
    @NamedQuery(name = "QaInspectionNotunused.findByRemarks", query = "SELECT q FROM QaInspectionNotunused q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaInspectionNotunused.findByDeleted", query = "SELECT q FROM QaInspectionNotunused q WHERE q.deleted = :deleted"),
    @NamedQuery(name = "QaInspectionNotunused.findByVersion", query = "SELECT q FROM QaInspectionNotunused q WHERE q.version = :version")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@AuditTable(value = "QA_INSP_NOTUNUSED_AUD")
@Table(name = "QA_INSPECTION_NOTUNUSED", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QA_INSPECTION_NOTUNUSED SET deleted = 'Y' WHERE id = ? and version = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaInspectionNotunused.findAll", query = "SELECT q FROM QaInspectionNotunused q"),
    @NamedQuery(name = "QaInspectionNotunused.findById", query = "SELECT q FROM QaInspectionNotunused q WHERE q.id = :id")})
public class QaInspectionNotunused implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @JsonBackReference
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private QaInspection id;
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
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "DELETED", insertable = false)
    private Character deleted;
    @Version
    @Column(name = "VERSION")
    private Integer version;

    public QaInspectionNotunused() {
    }

    public QaInspectionNotunused(QaInspection id) {
        this.id = id;
    }

    public QaInspection getId() {
        return id;
    }

    public void setId(QaInspection id) {
        this.id = id;
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
        hash = 59 * hash + Objects.hashCode(this.verifiedBy);
        hash = 59 * hash + Objects.hashCode(this.verifiedDate);
        hash = 59 * hash + Objects.hashCode(this.remarks);
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
        final QaInspectionNotunused other = (QaInspectionNotunused) obj;
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        if (!Objects.equals(this.verifiedBy, other.verifiedBy)) {
            return false;
        }
        if (!DateSupport.compareEqualDates(this.verifiedDate, other.verifiedDate)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaInspectionNotunused[ id=" + id + " ]";
    }

}
