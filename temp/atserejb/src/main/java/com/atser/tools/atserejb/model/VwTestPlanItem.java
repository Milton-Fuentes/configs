/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
@Table(name = "VW_TEST_PLAN_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwTestPlanItem.findAll", query = "SELECT a FROM VwTestPlanItem a"),
    @NamedQuery(name = "VwTestPlanItem.findById", query = "SELECT q FROM VwTestPlanItem q WHERE q.id = :id")})
public class VwTestPlanItem implements Serializable {

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;    
    @Column(name = "WBS_ID")
    private BigInteger wbsId;
    @Column(name = "WBS_TYPE")
    private BigInteger wbsType;
    @Size(max = 200)
    @Column(name = "WBS_NO")
    private String wbsNo;    
    @Column(name = "TEST_PLAN_ID")
    private BigInteger testPlanId;
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Column(name = "SUB_ITEM_ID")
    private BigInteger subItemId;
    @Size(max = 200)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Size(max = 200)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 100)
    @Column(name = "SR_TYPE")
    private String srType;
    @Column(name = "FLAG_NEWITEM")
    private Character flagNewitem;
    @Size(max = 5)
    @Column(name = "BACKCOLOR")
    private String backcolor;
    @Column(name = "SPEC_PID")
    private BigInteger specPid;
    @Column(name = "IA_CATG_ID")
    private BigInteger iaCatgId;
    @Size(max = 255)
    @Column(name = "IA_CATG")
    private String iaCatg;
    @JsonIgnore
    @Size(max = 499)
    @Column(name = "ITEM_NO_LINK")
    private String itemNoLink;
    @Size(max = 500)
    @Column(name = "ITEM_DESCRIPT")
    private String itemDescript;
    @Size(max = 500)
    @Column(name = "ITEM_DESCRIPT_V")
    private String itemDescriptV;
    @Size(max = 1000)
    @Column(name = "ITEM_DESCRIPT_COM")
    private String itemDescriptCom;
    @Column(name = "ESTM_QTY")
    private Double estmQty;
    @Size(max = 100)
    @Column(name = "UNIT")
    private String unit;
    @Size(max = 100)
    @Column(name = "ITEM_NU")
    private String itemNu;
    @Size(max = 100)
    @Column(name = "ITEM_SA")
    private String itemSa;
    @Size(max = 2000)
    @Column(name = "SOURCE_LOCATION")
    private String sourceLocation;
    @Size(max = 2000)
    @Column(name = "NOTES")
    private String notes;
    @Size(max = 500)
    @Column(name = "ACC_FREQ")
    private String accFreq;
    @Size(max = 500)
    @Column(name = "NCR_STATUS")
    private String ncrStatus;
    @Size(max = 200)
    @Column(name = "RMS_1")
    private String rms1;
    @Size(max = 200)
    @Column(name = "RMS_2")
    private String rms2;
    @Size(max = 200)
    @Column(name = "RMS_3")
    private String rms3;
    @Size(max = 200)
    @Column(name = "RMS_D")
    private String rmsD;
    @Size(max = 100)
    @Column(name = "CERTC")
    private String certc;
    @Size(max = 2000)
    @Column(name = "OTHER_NOTE")
    private String otherNote;
    @Size(max = 1000)
    @Column(name = "MAT_SPEC")
    private String matSpec;
    @Size(max = 100)
    @Column(name = "CONST_SECT")
    private String constSect;
    @Size(max = 100)
    @Column(name = "MAT_CATG")
    private String matCatg;
    @Size(max = 200)
    @Column(name = "SAMPLE_SIZE")
    private String sampleSize;
    @Size(max = 1000)
    @Column(name = "POINT_SAMPLE")
    private String pointSample;
    @Size(max = 500)
    @Column(name = "ACC_LOT_SIZE")
    private String accLotSize;
    @Size(max = 100)
    @Column(name = "ACC_SUBLOT_SIZE")
    private String accSublotSize;
    @Size(max = 100)
    @Column(name = "QC_LOT_SIZE")
    private String qcLotSize;
    @Size(max = 100)
    @Column(name = "QC_SUBLOT_SIZE")
    private String qcSublotSize;
    @Size(max = 500)
    @Column(name = "QC_FREQ")
    private String qcFreq;
    @Size(max = 500)
    @Column(name = "SAMPLE_PREP_METHOD")
    private String samplePrepMethod;
    @Size(max = 500)
    @Column(name = "SPEC_PREP_METHOD")
    private String specPrepMethod;
    @Size(max = 500)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 500)
    @Column(name = "INSPECTION")
    private String inspection;
    @Size(max = 500)
    @Column(name = "SOURCE_VERF")
    private String sourceVerf;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_1")
    private String testMethod1;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_2")
    private String testMethod2;
    @Size(max = 500)
    @Column(name = "TEST_METHOD_3")
    private String testMethod3;
    @Column(name = "PLAN_QTY")
    private Double planQty;
    @Column(name = "PROJECTED_QTY")
    private Double projectedQty;
    @Column(name = "TODATE_QTY")
    private Double todateQty;
    @Size(max = 100)
    @Column(name = "IA_TYPE")
    private String iaType;
    @JsonIgnore
    @Size(max = 577)
    @Column(name = "RMS_1_LINK")
    private String rms1Link;
    @JsonIgnore
    @Size(max = 577)
    @Column(name = "RMS_2_LINK")
    private String rms2Link;
    @JsonIgnore
    @Size(max = 577)
    @Column(name = "RMS_3_LINK")
    private String rms3Link;
    @JsonIgnore
    @Size(max = 577)
    @Column(name = "RMS_D_LINK")
    private String rmsDLink;
    @Size(max = 50)
    @Column(name = "STATUS_RE")
    private String statusRe;
    @Size(max = 50)
    @Column(name = "STATUS_DME")
    private String statusDme;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE")
    private Character active;
    @Size(max = 20)
    @Column(name = "VERSION")
    private String version;

    public VwTestPlanItem() {
    }

    public VwTestPlanItem(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getWbsId() {
        return wbsId;
    }

    public void setWbsId(BigInteger wbsId) {
        this.wbsId = wbsId;
    }

    public BigInteger getWbsType() {
        return wbsType;
    }

    public void setWbsType(BigInteger wbsType) {
        this.wbsType = wbsType;
    }

    public String getWbsNo() {
        return wbsNo;
    }

    public void setWbsNo(String wbsNo) {
        this.wbsNo = wbsNo;
    }

    public BigInteger getTestPlanId() {
        return testPlanId;
    }

    public void setTestPlanId(BigInteger testPlanId) {
        this.testPlanId = testPlanId;
    }

    public BigInteger getParentId() {
        return parentId;
    }

    public void setParentId(BigInteger parentId) {
        this.parentId = parentId;
    }

    public BigInteger getItemId() {
        return itemId;
    }

    public void setItemId(BigInteger itemId) {
        this.itemId = itemId;
    }

    public BigInteger getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(BigInteger subItemId) {
        this.subItemId = subItemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getSrType() {
        return srType;
    }

    public void setSrType(String srType) {
        this.srType = srType;
    }

    public Character getFlagNewitem() {
        return flagNewitem;
    }

    public void setFlagNewitem(Character flagNewitem) {
        this.flagNewitem = flagNewitem;
    }

    public String getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor;
    }

    public BigInteger getSpecPid() {
        return specPid;
    }

    public void setSpecPid(BigInteger specPid) {
        this.specPid = specPid;
    }

    public BigInteger getIaCatgId() {
        return iaCatgId;
    }

    public void setIaCatgId(BigInteger iaCatgId) {
        this.iaCatgId = iaCatgId;
    }

    public String getIaCatg() {
        return iaCatg;
    }

    public void setIaCatg(String iaCatg) {
        this.iaCatg = iaCatg;
    }

    public String getItemNoLink() {
        return itemNoLink;
    }

    public void setItemNoLink(String itemNoLink) {
        this.itemNoLink = itemNoLink;
    }

    public String getItemDescript() {
        return itemDescript;
    }

    public void setItemDescript(String itemDescript) {
        this.itemDescript = itemDescript;
    }

    public String getItemDescriptV() {
        return itemDescriptV;
    }

    public void setItemDescriptV(String itemDescriptV) {
        this.itemDescriptV = itemDescriptV;
    }

    public String getItemDescriptCom() {
        return itemDescriptCom;
    }

    public void setItemDescriptCom(String itemDescriptCom) {
        this.itemDescriptCom = itemDescriptCom;
    }

    public Double getEstmQty() {
        return estmQty;
    }

    public void setEstmQty(Double estmQty) {
        this.estmQty = estmQty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getItemNu() {
        return itemNu;
    }

    public void setItemNu(String itemNu) {
        this.itemNu = itemNu;
    }

    public String getItemSa() {
        return itemSa;
    }

    public void setItemSa(String itemSa) {
        this.itemSa = itemSa;
    }

    public String getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(String sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAccFreq() {
        return accFreq;
    }

    public void setAccFreq(String accFreq) {
        this.accFreq = accFreq;
    }

    public String getNcrStatus() {
        return ncrStatus;
    }

    public void setNcrStatus(String ncrStatus) {
        this.ncrStatus = ncrStatus;
    }

    public String getRms1() {
        return rms1;
    }

    public void setRms1(String rms1) {
        this.rms1 = rms1;
    }

    public String getRms2() {
        return rms2;
    }

    public void setRms2(String rms2) {
        this.rms2 = rms2;
    }

    public String getRms3() {
        return rms3;
    }

    public void setRms3(String rms3) {
        this.rms3 = rms3;
    }

    public String getRmsD() {
        return rmsD;
    }

    public void setRmsD(String rmsD) {
        this.rmsD = rmsD;
    }

    public String getCertc() {
        return certc;
    }

    public void setCertc(String certc) {
        this.certc = certc;
    }

    public String getOtherNote() {
        return otherNote;
    }

    public void setOtherNote(String otherNote) {
        this.otherNote = otherNote;
    }

    public String getMatSpec() {
        return matSpec;
    }

    public void setMatSpec(String matSpec) {
        this.matSpec = matSpec;
    }

    public String getConstSect() {
        return constSect;
    }

    public void setConstSect(String constSect) {
        this.constSect = constSect;
    }

    public String getMatCatg() {
        return matCatg;
    }

    public void setMatCatg(String matCatg) {
        this.matCatg = matCatg;
    }

    public String getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(String sampleSize) {
        this.sampleSize = sampleSize;
    }

    public String getPointSample() {
        return pointSample;
    }

    public void setPointSample(String pointSample) {
        this.pointSample = pointSample;
    }

    public String getAccLotSize() {
        return accLotSize;
    }

    public void setAccLotSize(String accLotSize) {
        this.accLotSize = accLotSize;
    }

    public String getAccSublotSize() {
        return accSublotSize;
    }

    public void setAccSublotSize(String accSublotSize) {
        this.accSublotSize = accSublotSize;
    }

    public String getQcLotSize() {
        return qcLotSize;
    }

    public void setQcLotSize(String qcLotSize) {
        this.qcLotSize = qcLotSize;
    }

    public String getQcSublotSize() {
        return qcSublotSize;
    }

    public void setQcSublotSize(String qcSublotSize) {
        this.qcSublotSize = qcSublotSize;
    }

    public String getQcFreq() {
        return qcFreq;
    }

    public void setQcFreq(String qcFreq) {
        this.qcFreq = qcFreq;
    }

    public String getSamplePrepMethod() {
        return samplePrepMethod;
    }

    public void setSamplePrepMethod(String samplePrepMethod) {
        this.samplePrepMethod = samplePrepMethod;
    }

    public String getSpecPrepMethod() {
        return specPrepMethod;
    }

    public void setSpecPrepMethod(String specPrepMethod) {
        this.specPrepMethod = specPrepMethod;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getInspection() {
        return inspection;
    }

    public void setInspection(String inspection) {
        this.inspection = inspection;
    }

    public String getSourceVerf() {
        return sourceVerf;
    }

    public void setSourceVerf(String sourceVerf) {
        this.sourceVerf = sourceVerf;
    }

    public String getTestMethod1() {
        return testMethod1;
    }

    public void setTestMethod1(String testMethod1) {
        this.testMethod1 = testMethod1;
    }

    public String getTestMethod2() {
        return testMethod2;
    }

    public void setTestMethod2(String testMethod2) {
        this.testMethod2 = testMethod2;
    }

    public String getTestMethod3() {
        return testMethod3;
    }

    public void setTestMethod3(String testMethod3) {
        this.testMethod3 = testMethod3;
    }

    public Double getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Double planQty) {
        this.planQty = planQty;
    }

    public Double getProjectedQty() {
        return projectedQty;
    }

    public void setProjectedQty(Double projectedQty) {
        this.projectedQty = projectedQty;
    }

    public Double getTodateQty() {
        return todateQty;
    }

    public void setTodateQty(Double todateQty) {
        this.todateQty = todateQty;
    }

    public String getIaType() {
        return iaType;
    }

    public void setIaType(String iaType) {
        this.iaType = iaType;
    }

    public String getRms1Link() {
        return rms1Link;
    }

    public void setRms1Link(String rms1Link) {
        this.rms1Link = rms1Link;
    }

    public String getRms2Link() {
        return rms2Link;
    }

    public void setRms2Link(String rms2Link) {
        this.rms2Link = rms2Link;
    }

    public String getRms3Link() {
        return rms3Link;
    }

    public void setRms3Link(String rms3Link) {
        this.rms3Link = rms3Link;
    }

    public String getRmsDLink() {
        return rmsDLink;
    }

    public void setRmsDLink(String rmsDLink) {
        this.rmsDLink = rmsDLink;
    }

    public String getStatusRe() {
        return statusRe;
    }

    public void setStatusRe(String statusRe) {
        this.statusRe = statusRe;
    }

    public String getStatusDme() {
        return statusDme;
    }

    public void setStatusDme(String statusDme) {
        this.statusDme = statusDme;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getItemNoDescription() {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ").append(this.itemNo).append(" ] ");
        if (StringSupport.isNotNullAndNotEmpty(this.itemDescript)) {
            builder.append(this.itemDescript);
        }
        return builder.toString();
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
        if (!(object instanceof VwTestPlanItem)) {
            return false;
        }
        VwTestPlanItem other = (VwTestPlanItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
