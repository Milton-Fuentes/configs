/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
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
@Table(name = "VW_PLIST", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwPList.findAll", query = "SELECT a FROM VwPList a")})
public class VwPList implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "ITEM_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date itemDate;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "STRUCT_ID")
    private BigInteger structId;
    @Column(name = "ITEM_TYPE_ID")
    private BigInteger itemTypeId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId; 
    @Size(max = 10)
    @Column(name = "ITEM_DATE1")
    private String itemDate1;
    @Size(max = 101)
    @Column(name = "REV_APPV")
    private String revAppv;
    @Size(max = 101)
    @Column(name = "QCINSP_APPV")
    private String qcinspAppv;
    @Size(max = 101)
    @Column(name = "QAINSP_APPV")
    private String qainspAppv;
    @Size(max = 173)
    @Column(name = "DOC_ATTACH")
    private String docAttach;
    @Size(max = 174)
    @Column(name = "PHOTO_ATTACH")
    private String photoAttach;
    @Size(max = 20)
    @Column(name = "INSP1_APPV")
    private String insp1Appv;
    @Size(max = 20)
    @Column(name = "INSP2_APPV")
    private String insp2Appv;
    @Size(max = 20)
    @Column(name = "INSP3_APPV")
    private String insp3Appv;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;
    @Size(max = 200)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 200)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Size(max = 200)
    @Column(name = "STRUCT_TYPE")
    private String structType;
    @Size(max = 200)
    @Column(name = "SEGMENT")
    private String segment;
    @Size(max = 2000)
    @Column(name = "DETAIL_LOCATION")
    private String detailLocation;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "SPEC_PLAN_REF")
    private String specPlanRef;
    @Size(max = 255)
    @Column(name = "RFI_REF")
    private String rfiRef;
    @Size(max = 255)
    @Column(name = "NCR_REF")
    private String ncrRef;
    @Size(max = 255)
    @Column(name = "SCC_NCR_REF")
    private String sccNcrRef;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "SUB_REF")
    private String subRef;
    @Size(max = 3)
    @Column(name = "HAS_UPDATE")
    private String hasUpdate;
    @Size(max = 3000)
    @Column(name = "ITEM_DESCRIPT")
    private String itemDescript;
    @Size(max = 50)
    @Column(name = "ITEM_STATUS")
    private String itemStatus;
    @Size(max = 500)
    @Column(name = "RESPONSIBILITY")
    private String responsibility;
    @Size(max = 500)
    @Column(name = "ITEM_LOCATION")
    private String itemLocation;
    @JsonSkipXssSerialization
    @Size(max = 589)
    @Column(name = "ITEM_NO_LINK")
    private String itemNoLink;

    public VwPList() {
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

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getItemNoLink() {
        return itemNoLink;
    }

    public void setItemNoLink(String itemNoLink) {
        this.itemNoLink = itemNoLink;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getItemDate1() {
        return itemDate1;
    }

    public void setItemDate1(String itemDate1) {
        this.itemDate1 = itemDate1;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescript() {
        return itemDescript;
    }

    public void setItemDescript(String itemDescript) {
        this.itemDescript = itemDescript;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(String itemLocation) {
        this.itemLocation = itemLocation;
    }

    public String getDetailLocation() {
        return detailLocation;
    }

    public void setDetailLocation(String detailLocation) {
        this.detailLocation = detailLocation;
    }

    public String getInsp1Appv() {
        return insp1Appv;
    }

    public void setInsp1Appv(String insp1Appv) {
        this.insp1Appv = insp1Appv;
    }

    public String getInsp2Appv() {
        return insp2Appv;
    }

    public void setInsp2Appv(String insp2Appv) {
        this.insp2Appv = insp2Appv;
    }

    public String getInsp3Appv() {
        return insp3Appv;
    }

    public void setInsp3Appv(String insp3Appv) {
        this.insp3Appv = insp3Appv;
    }

    public String getQcinspAppv() {
        return qcinspAppv;
    }

    public void setQcinspAppv(String qcinspAppv) {
        this.qcinspAppv = qcinspAppv;
    }

    public String getQainspAppv() {
        return qainspAppv;
    }

    public void setQainspAppv(String qainspAppv) {
        this.qainspAppv = qainspAppv;
    }

    public String getRevAppv() {
        return revAppv;
    }

    public void setRevAppv(String revAppv) {
        this.revAppv = revAppv;
    }

    public String getHasUpdate() {
        return hasUpdate;
    }

    public void setHasUpdate(String hasUpdate) {
        this.hasUpdate = hasUpdate;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public BigInteger getStructId() {
        return structId;
    }

    public void setStructId(BigInteger structId) {
        this.structId = structId;
    }

    public BigInteger getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(BigInteger itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getDocAttach() {
        return docAttach;
    }

    public void setDocAttach(String docAttach) {
        this.docAttach = docAttach;
    }

    public String getPhotoAttach() {
        return photoAttach;
    }

    public void setPhotoAttach(String photoAttach) {
        this.photoAttach = photoAttach;
    }

    public String getStructType() {
        return structType;
    }

    public void setStructType(String structType) {
        this.structType = structType;
    }

    public String getSpecPlanRef() {
        return specPlanRef;
    }

    public void setSpecPlanRef(String specPlanRef) {
        this.specPlanRef = specPlanRef;
    }

    public String getRfiRef() {
        return rfiRef;
    }

    public void setRfiRef(String rfiRef) {
        this.rfiRef = rfiRef;
    }

    public String getNcrRef() {
        return ncrRef;
    }

    public void setNcrRef(String ncrRef) {
        this.ncrRef = ncrRef;
    }

    public String getSccNcrRef() {
        return sccNcrRef;
    }

    public void setSccNcrRef(String sccNcrRef) {
        this.sccNcrRef = sccNcrRef;
    }

    public String getSubRef() {
        return subRef;
    }

    public void setSubRef(String subRef) {
        this.subRef = subRef;
    }    

}
