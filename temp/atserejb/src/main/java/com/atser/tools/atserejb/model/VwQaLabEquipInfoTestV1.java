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
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "VW_QALAB_EQUIPINFOTEST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQaLabEquipInfoTestV1.findAll", query = "SELECT a FROM VwQaLabEquipInfoTestV1 a")})
public class VwQaLabEquipInfoTestV1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "QALAB_EQUIPINFO_ID_SEQ", sequenceName = "QALAB_EQUIPINFO_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QALAB_EQUIPINFO_ID_SEQ")
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "LAB_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobLabs labId;
    @JoinColumn(name = "EQUIP_ID")
    @ManyToOne(optional = false)
    private QalabEquiptypeV1 equipId;
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
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @JsonIgnore
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @JsonIgnore
    @Column(name = "FIELD5")
    private BigInteger field5;
    @JsonIgnore
    @Column(name = "FIELD6")
    private BigInteger field6;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD7")
    private String field7;
    @JsonIgnore
    @Size(max = 50)
    @Column(name = "FIELD8")
    private String field8;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "LOG_DATE_TMP")
    private String logDateTmp;
    @JsonIgnore
    @Size(max = 4000)
    @Column(name = "PURCHASED_DATE_TMP")
    private String purchasedDateTmp;
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
    @Column(name = "EQUIP_ORIG_COST")
    private Double equipOrigCost;
    @Column(name = "EQUIP_RECEIVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date equipReceivedDate;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    

    public VwQaLabEquipInfoTestV1() {
    }

    public VwQaLabEquipInfoTestV1(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public GlobLabs getLabId() {
        return labId;
    }

    public void setLabId(GlobLabs labId) {
        this.labId = labId;
    }

    public QalabEquiptypeV1 getEquipId() {
        return equipId;
    }

    public void setEquipId(QalabEquiptypeV1 equipId) {
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

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

}
