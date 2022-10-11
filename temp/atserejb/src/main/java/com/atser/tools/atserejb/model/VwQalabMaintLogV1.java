/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "VW_QALAB_MAINT_LOG", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwQalabMaintLogV1.findAll", query = "SELECT a FROM VwQalabMaintLogV1 a")})
public class VwQalabMaintLogV1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ROW_ID")
    private BigDecimal rowId;
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "LAB_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private GlobLabs labId;
    @Column(name = "EQUIP_ID")
    private BigInteger equipId;
    @Column(name = "TYPE_ITEM")
    @Size(max = 255)
    private String typeItem;
    @Column(name = "TYPE_CATG_ID")
    private BigInteger typeCatgId;
    @Column(name = "TYPE_PROCEDURE")
    @Size(max = 512)
    private String typeProcedure;
    @Column(name = "PART_EQUIPPART_NAME")
    @Size(max = 255)
    private String partEquipPartName;
    @Column(name = "PART_INTERVAL_M")
    private BigInteger partIntervalM;
    @Column(name = "LOG_MAINT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logMaintDate;
    @Column(name = "LOG_MAINT_DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logMaintDueDate;
    @Column(name = "INF_ACTIVE")
    @Size(max = 10)
    private String infActive;
    @Column(name = "INF_MANUFACT")
    @Size(max = 200)
    private String infManufact;
    @Column(name = "INF_MODEL")
    @Size(max = 200)
    private String infModel;
    @Column(name = "SERIAL_NO")
    @Size(max = 200)
    private String serialNo;
    @Column(name = "INF_CONDITION_RECEIVED")
    @Size(max = 200)
    private String infConditionReceived;
    @Column(name = "INF_PURCHASED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infPurchasedDate;
    @Column(name = "INF_INSERVICE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infInserviceDate;
    @Column(name = "INF_EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infExpirationDate;
    @Column(name = "INF_EQUIP_ELECTRONICTAG")
    @Size(max = 150)
    private String infEquipElectronictag;
    @Column(name = "INF_EQUIP_RMSTAG")
    @Size(max = 150)
    private String infEquipRmstag;
    @Column(name = "INF_EQUIP_ROOM")
    @Size(max = 50)
    private String infEquipRoom;
    @Column(name = "INF_EQUIP_ITEM_DESCRIP")
    @Lob
    private String infEquipItemDescrip;
    @Column(name = "INF_EQUIP_ORIG_COST")
    private Double infEquipOrigCost;
    @Column(name = "INF_EQUIP_RECEIVED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date infEquipReceivedDate;

    public VwQalabMaintLogV1() {
    }

    public BigDecimal getRowId() {
        return rowId;
    }

    public void setRowId(BigDecimal rowId) {
        this.rowId = rowId;
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

    public BigInteger getEquipId() {
        return equipId;
    }

    public void setEquipId(BigInteger equipId) {
        this.equipId = equipId;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }

    public BigInteger getTypeCatgId() {
        return typeCatgId;
    }

    public void setTypeCatgId(BigInteger typeCatgId) {
        this.typeCatgId = typeCatgId;
    }

    public String getTypeProcedure() {
        return typeProcedure;
    }

    public void setTypeProcedure(String typeProcedure) {
        this.typeProcedure = typeProcedure;
    }

    public BigInteger getPartIntervalM() {
        return partIntervalM;
    }

    public void setPartIntervalM(BigInteger partIntervalM) {
        this.partIntervalM = partIntervalM;
    }

    public String getPartEquipPartName() {
        return partEquipPartName;
    }

    public void setPartEquipPartName(String partEquipPartName) {
        this.partEquipPartName = partEquipPartName;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLogMaintDate() {
        return logMaintDate;
    }

    public void setLogMaintDate(Date logMaintDate) {
        this.logMaintDate = logMaintDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getLogMaintDueDate() {
        return logMaintDueDate;
    }

    public void setLogMaintDueDate(Date logMaintDueDate) {
        this.logMaintDueDate = logMaintDueDate;
    }

    public String getInfActive() {
        return infActive;
    }

    public void setInfActive(String infActive) {
        this.infActive = infActive;
    }

    public String getInfManufact() {
        return infManufact;
    }

    public void setInfManufact(String infManufact) {
        this.infManufact = infManufact;
    }

    public String getInfModel() {
        return infModel;
    }

    public void setInfModel(String infModel) {
        this.infModel = infModel;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getInfConditionReceived() {
        return infConditionReceived;
    }

    public void setInfConditionReceived(String infConditionReceived) {
        this.infConditionReceived = infConditionReceived;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInfPurchasedDate() {
        return infPurchasedDate;
    }

    public void setInfPurchasedDate(Date infPurchasedDate) {
        this.infPurchasedDate = infPurchasedDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInfInserviceDate() {
        return infInserviceDate;
    }

    public void setInfInserviceDate(Date infInserviceDate) {
        this.infInserviceDate = infInserviceDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInfExpirationDate() {
        return infExpirationDate;
    }

    public void setInfExpirationDate(Date infExpirationDate) {
        this.infExpirationDate = infExpirationDate;
    }

    public String getInfEquipElectronictag() {
        return infEquipElectronictag;
    }

    public void setInfEquipElectronictag(String infEquipElectronictag) {
        this.infEquipElectronictag = infEquipElectronictag;
    }

    public String getInfEquipRmstag() {
        return infEquipRmstag;
    }

    public void setInfEquipRmstag(String infEquipRmstag) {
        this.infEquipRmstag = infEquipRmstag;
    }

    public String getInfEquipRoom() {
        return infEquipRoom;
    }

    public void setInfEquipRoom(String infEquipRoom) {
        this.infEquipRoom = infEquipRoom;
    }

    public String getInfEquipItemDescrip() {
        return infEquipItemDescrip;
    }

    public void setInfEquipItemDescrip(String infEquipItemDescrip) {
        this.infEquipItemDescrip = infEquipItemDescrip;
    }

    public Double getInfEquipOrigCost() {
        return infEquipOrigCost;
    }

    public void setInfEquipOrigCost(Double infEquipOrigCost) {
        this.infEquipOrigCost = infEquipOrigCost;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getInfEquipReceivedDate() {
        return infEquipReceivedDate;
    }

    public void setInfEquipReceivedDate(Date infEquipReceivedDate) {
        this.infEquipReceivedDate = infEquipReceivedDate;
    }

}
