/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

/*
    , @NamedQuery(name = "QalabEquipinfoV2.findByLabId", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.labId.id = :labId")
    , @NamedQuery(name = "QalabEquipinfoV2.findByEquipId", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.equipId.id = :equipId")
    , @NamedQuery(name = "QalabEquipinfoV2.findByManufact", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.manufact = :manufact")
    , @NamedQuery(name = "QalabEquipinfoV2.findByModel", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.model = :model")
    , @NamedQuery(name = "QalabEquipinfoV2.findBySerialNo", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.serialNo = :serialNo")
    , @NamedQuery(name = "QalabEquipinfoV2.findByEquipNo", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.equipNo = :equipNo")
    , @NamedQuery(name = "QalabEquipinfoV2.findByConditionReceived", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.conditionReceived = :conditionReceived")
    , @NamedQuery(name = "QalabEquipinfoV2.findByStatus", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.status = :status")
    , @NamedQuery(name = "QalabEquipinfoV2.findByLogDateTmp", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.logDateTmp = :logDateTmp")
    , @NamedQuery(name = "QalabEquipinfoV2.findByPurchasedDateTmp", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.purchasedDateTmp = :purchasedDateTmp")
    , @NamedQuery(name = "QalabEquipinfoV2.findByInserviceDateTmp", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.inserviceDateTmp = :inserviceDateTmp")
    , @NamedQuery(name = "QalabEquipinfoV2.findByLogDate", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.logDate = :logDate")
    , @NamedQuery(name = "QalabEquipinfoV2.findByPurchasedDate", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.purchasedDate = :purchasedDate")
    , @NamedQuery(name = "QalabEquipinfoV2.findByInserviceDate", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.inserviceDate = :inserviceDate")
 */
/**
 *
 * @author droldan
 */
@Entity
@Audited
@Table(name = "QALAB_EQUIPINFO", catalog = "", schema = "ORACLE")
@SQLDelete(sql = "UPDATE QALAB_EQUIPINFO SET deleted = 'Y' WHERE id = ?", check = ResultCheckStyle.COUNT)
@Where(clause = "deleted = 'N'")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QalabEquipinfoV2.findAll", query = "SELECT q FROM QalabEquipinfoV2 q"),
    @NamedQuery(name = "QalabEquipinfoV2.findById", query = "SELECT q FROM QalabEquipinfoV2 q WHERE q.id = :id")})
public class QalabEquipinfoV2 implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "QALAB_EQUIPINFO_ID_SEQ", sequenceName = "QALAB_EQUIPINFO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_EQUIPINFO_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "LAB_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    //@JsonIgnoreProperties(value = {"cell", "fax", "email"}, allowSetters = true)
    private GlobLabsMaster labId;
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @JoinColumn(name = "EQUIP_ID")
    @ManyToOne(optional = false)
    private QalabEquiptypeV2 equipId;
    @Size(max = 200)
    @Column(name = "MANUFACT")
    private String manufact;
    @Size(max = 200)
    @Column(name = "MODEL")
    private String model;
    @Size(max = 200)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Size(max = 200)
    @Column(name = "EQUIP_NO")
    private String equipNo;
    @Size(max = 200)
    @Column(name = "CONDITION_RECEIVED")
    private String conditionReceived;
    @Size(max = 200)
    @Column(name = "STATUS")
    private String status;
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
    @Column(name = "LOG_DATE_TMP")
    private String logDateTmp;
    @NotAudited
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "PURCHASED_DATE_TMP")
    private String purchasedDateTmp;
    @NotAudited
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "INSERVICE_DATE_TMP")
    private String inserviceDateTmp;
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @Column(name = "PURCHASED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchasedDate;
    @Column(name = "INSERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inserviceDate;
    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    @JsonIgnore
    @Size(max = 20)
    @Column(name = "DELETED", insertable = false, updatable = false)
    private String deleted;
    @Size(max = 10)
    @Column(name = "ACTIVE")
    private String active;
    @Size(max = 150)
    @Column(name = "EQUIP_ELECTRONICTAG")
    private String equipElectronictag;
    @Size(max = 150)
    @Column(name = "EQUIP_RMSTAG")
    private String equipRmstag;
    @Size(max = 50)
    @Column(name = "EQUIP_ROOM")
    private String equipRoom;
    @Lob
    @Column(name = "EQUIP_ITEM_DESCRIP")
    private String equipItemDescrip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "EQUIP_ORIG_COST")
    private Double equipOrigCost;
    @Column(name = "EQUIP_RECEIVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date equipReceivedDate;
    @Size(max = 255)
    @Column(name = "CURRENT_CONDITION")
    private String currentCondition;
    @NotAudited
    @Where(clause = "deleted = 'N'")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "labEquipId", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QalabCaliblogV2> qalabCaliblogList;
    @NotAudited
    @Where(clause = "deleted = 'N'")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipInfoid", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<QalabMaintlogV2> qalabMaintlogList;
    @NotAudited
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipinfoid", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<QalabEquipclienttestV2> qalabEquipclienttestList;

    public QalabEquipinfoV2() {
    }

    public QalabEquipinfoV2(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobLabsMaster getLabId() {
        return labId;
    }

    public void setLabId(GlobLabsMaster labId) {
        this.labId = labId;
    }

    public QalabEquiptypeV2 getEquipId() {
        return equipId;
    }

    public void setEquipId(QalabEquiptypeV2 equipId) {
        this.equipId = equipId;
    }

    public String getManufact() {
        return manufact;
    }

    public void setManufact(String manufact) {
        this.manufact = manufact;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public String getConditionReceived() {
        return conditionReceived;
    }

    public void setConditionReceived(String conditionReceived) {
        this.conditionReceived = conditionReceived;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getLogDateTmp() {
        return logDateTmp;
    }

    public void setLogDateTmp(String logDateTmp) {
        this.logDateTmp = logDateTmp;
    }

    public String getPurchasedDateTmp() {
        return purchasedDateTmp;
    }

    public void setPurchasedDateTmp(String purchasedDateTmp) {
        this.purchasedDateTmp = purchasedDateTmp;
    }

    public String getInserviceDateTmp() {
        return inserviceDateTmp;
    }

    public void setInserviceDateTmp(String inserviceDateTmp) {
        this.inserviceDateTmp = inserviceDateTmp;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInserviceDate() {
        return inserviceDate;
    }

    public void setInserviceDate(Date inserviceDate) {
        this.inserviceDate = inserviceDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @XmlTransient
    public List<QalabCaliblogV2> getQalabCaliblogList() {
        return qalabCaliblogList;
    }

    public void setQalabCaliblogList(List<QalabCaliblogV2> qalabCaliblogList) {
        this.qalabCaliblogList = qalabCaliblogList;
    }

    @XmlTransient
    public List<QalabMaintlogV2> getQalabMaintlogList() {
        return qalabMaintlogList;
    }

    public void setQalabMaintlogList(List<QalabMaintlogV2> qalabMaintlogList) {
        this.qalabMaintlogList = qalabMaintlogList;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEquipElectronictag() {
        return equipElectronictag;
    }

    public void setEquipElectronictag(String equipElectronictag) {
        this.equipElectronictag = equipElectronictag;
    }

    public String getEquipRmstag() {
        return equipRmstag;
    }

    public void setEquipRmstag(String equipRmstag) {
        this.equipRmstag = equipRmstag;
    }

    public String getEquipRoom() {
        return equipRoom;
    }

    public void setEquipRoom(String equipRoom) {
        this.equipRoom = equipRoom;
    }

    public String getEquipItemDescrip() {
        return equipItemDescrip;
    }

    public void setEquipItemDescrip(String equipItemDescrip) {
        this.equipItemDescrip = equipItemDescrip;
    }

    public Double getEquipOrigCost() {
        return equipOrigCost;
    }

    public void setEquipOrigCost(Double equipOrigCost) {
        this.equipOrigCost = equipOrigCost;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getEquipReceivedDate() {
        return equipReceivedDate;
    }

    public void setEquipReceivedDate(Date equipReceivedDate) {
        this.equipReceivedDate = equipReceivedDate;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @XmlTransient
    public List<QalabEquipclienttestV2> getQalabEquipclienttestList() {
        return qalabEquipclienttestList;
    }

    public void setQalabEquipclienttestList(List<QalabEquipclienttestV2> qalabEquipclienttestList) {
        this.qalabEquipclienttestList = qalabEquipclienttestList;
    }

    public void addQalabEquipclienttestList(QalabEquipclienttestV2 qalabEquipclienttest) {
        qalabEquipclienttestList.add(qalabEquipclienttest);
        qalabEquipclienttest.setEquipinfoid(this);
    }

    public void removeQalabEquipclienttestList(QalabEquipclienttestV2 qalabEquipclienttest) {
        qalabEquipclienttestList.remove(qalabEquipclienttest);
        qalabEquipclienttest.setEquipinfoid(null);
    }

    public void buildReferences() {
        if (qalabEquipclienttestList != null && !qalabEquipclienttestList.isEmpty()) {
            qalabEquipclienttestList.forEach(p -> {
                p.setEquipinfoid(this);
            });
        }
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
        if (!(object instanceof QalabEquipinfoV2)) {
            return false;
        }
        QalabEquipinfoV2 other = (QalabEquipinfoV2) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QalabEquipinfoV2[ id=" + id + " ]";
    }
}
