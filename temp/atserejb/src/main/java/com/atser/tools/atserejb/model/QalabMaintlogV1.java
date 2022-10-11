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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
    , @NamedQuery(name = "QalabMaintlogV1.findByPerformedby", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.performedby = :performedby")
    , @NamedQuery(name = "QalabMaintlogV1.findByFolderId", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.folderId = :folderId")
    , @NamedQuery(name = "QalabMaintlogV1.findByMaintDate", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.maintDate = :maintDate")
    , @NamedQuery(name = "QalabMaintlogV1.findByMaintDueDate", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.maintDueDate = :maintDueDate")
    , @NamedQuery(name = "QalabMaintlogV1.findByEquipInfoid", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.equipInfoid = :equipInfoid")
    , @NamedQuery(name = "QalabMaintlogV1.findByDeleted", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.deleted = :deleted")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_MAINTLOG", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_MAINTLOG SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabMaintlogV1.findAll", query = "SELECT q FROM QalabMaintlogV1 q")
    , @NamedQuery(name = "QalabMaintlogV1.findById", query = "SELECT q FROM QalabMaintlogV1 q WHERE q.id = :id")})
public class QalabMaintlogV1 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "QALAB_MAINTLOG_SEQ", sequenceName = "QALAB_MAINTLOG_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_MAINTLOG_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Lob
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 150)
    @Column(name = "PERFORMEDBY")
    private String performedby;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;
    @Column(name = "MAINT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maintDate;
    @Column(name = "MAINT_DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maintDueDate;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "EQUIP_INFOID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QalabEquipinfoV1 equipInfoid;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "EQUIP_MAINTTYPEID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QalabMainttypeV1 equipMaintTypeid;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;

    public QalabMaintlogV1() {
    }

    public QalabMaintlogV1(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerformedby() {
        return performedby;
    }

    public void setPerformedby(String performedby) {
        this.performedby = performedby;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getMaintDate() {
        return maintDate;
    }

    public void setMaintDate(Date maintDate) {
        this.maintDate = maintDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getMaintDueDate() {
        return maintDueDate;
    }

    public void setMaintDueDate(Date maintDueDate) {
        this.maintDueDate = maintDueDate;
    }

    public QalabEquipinfoV1 getEquipInfoid() {
        return equipInfoid;
    }

    public void setEquipInfoid(QalabEquipinfoV1 equipInfoid) {
        this.equipInfoid = equipInfoid;
    }

    public QalabMainttypeV1 getEquipMaintTypeid() {
        return equipMaintTypeid;
    }

    public void setEquipMaintTypeid(QalabMainttypeV1 equipMaintTypeid) {
        this.equipMaintTypeid = equipMaintTypeid;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
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
        if (!(object instanceof QalabMaintlogV1)) {
            return false;
        }
        QalabMaintlogV1 other = (QalabMaintlogV1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabMaintlogV1[ id=" + id + " ]";
    }

}
