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
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
    , @NamedQuery(name = "QalabCaliblogV2.findByLabEquipId", query = "SELECT q FROM QalabCaliblogV2 q WHERE q.labEquipId = :labEquipId")
    , @NamedQuery(name = "QalabCaliblogV2.findByComments", query = "SELECT q FROM QalabCaliblogV2 q WHERE q.comments = :comments")
    , @NamedQuery(name = "QalabCaliblogV2.findByCalibDateTmp", query = "SELECT q FROM QalabCaliblogV2 q WHERE q.calibDateTmp = :calibDateTmp")
    , @NamedQuery(name = "QalabCaliblogV2.findByCalibDate", query = "SELECT q FROM QalabCaliblogV2 q WHERE q.calibDate = :calibDate")
*/

/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_CALIBLOG", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_CALIBLOG SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabCaliblogV2.findAll", query = "SELECT q FROM QalabCaliblogV2 q")
    , @NamedQuery(name = "QalabCaliblogV2.findById", query = "SELECT q FROM QalabCaliblogV2 q WHERE q.id = :id")})
public class QalabCaliblogV2 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "QALAB_CALIBLOG_ID_SEQ", sequenceName = "QALAB_CALIBLOG_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_CALIBLOG_ID_SEQ")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "LAB_EQUIP_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private QalabEquipinfoV2 labEquipId;
    //@Column(name = "LAB_EQUIP_ID")
    //private BigInteger labEquipId;
    @Size(max = 200)
    @Column(name = "COMMENTS")
    private String comments;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @NotAudited
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD5")
    private BigInteger field5;
    @NotAudited
    @JsonIgnore
    @Column(name = "FIELD6")
    private BigInteger field6;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @NotAudited
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @NotAudited
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "CALIB_DATE_TMP")
    private String calibDateTmp;
    @Column(name = "CALIB_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calibDate;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 255)
    @Column(name = "PERFORMEDBY")
    private String performedby;
    @Column(name = "FOLDER_ID")
    private BigInteger folderId;

    public QalabCaliblogV2() {
    }

    public QalabCaliblogV2(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public QalabEquipinfoV2 getLabEquipId() {
        return labEquipId;
    }

    public void setLabEquipId(QalabEquipinfoV2 labEquipId) {
        this.labEquipId = labEquipId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public BigInteger getField5() {
        return field5;
    }

    public void setField5(BigInteger field5) {
        this.field5 = field5;
    }

    public BigInteger getField6() {
        return field6;
    }

    public void setField6(BigInteger field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getCalibDateTmp() {
        return calibDateTmp;
    }

    public void setCalibDateTmp(String calibDateTmp) {
        this.calibDateTmp = calibDateTmp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getCalibDate() {
        return calibDate;
    }

    public void setCalibDate(Date calibDate) {
        this.calibDate = calibDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QalabCaliblogV2)) {
            return false;
        }
        QalabCaliblogV2 other = (QalabCaliblogV2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabCaliblogV2[ id=" + id + " ]";
    }
}
