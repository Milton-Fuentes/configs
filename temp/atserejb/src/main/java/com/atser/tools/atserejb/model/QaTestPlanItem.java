/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/*
    @NamedQuery(name = "QaTestPlanItem.findByTestPlanId", query = "SELECT q FROM QaTestPlanItem q WHERE q.testPlanId = :testPlanId"),
    @NamedQuery(name = "QaTestPlanItem.findByParentId", query = "SELECT q FROM QaTestPlanItem q WHERE q.parentId = :parentId"),
    @NamedQuery(name = "QaTestPlanItem.findByItemId", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemId = :itemId"),
    @NamedQuery(name = "QaTestPlanItem.findBySubItemId", query = "SELECT q FROM QaTestPlanItem q WHERE q.subItemId = :subItemId"),
    @NamedQuery(name = "QaTestPlanItem.findByItemType", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemType = :itemType"),
    @NamedQuery(name = "QaTestPlanItem.findByItemNo", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemNo = :itemNo"),
    @NamedQuery(name = "QaTestPlanItem.findByItemDescript", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemDescript = :itemDescript"),
    @NamedQuery(name = "QaTestPlanItem.findByItemDescriptV", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemDescriptV = :itemDescriptV"),
    @NamedQuery(name = "QaTestPlanItem.findByEstmQty", query = "SELECT q FROM QaTestPlanItem q WHERE q.estmQty = :estmQty"),
    @NamedQuery(name = "QaTestPlanItem.findByUnit", query = "SELECT q FROM QaTestPlanItem q WHERE q.unit = :unit"),
    @NamedQuery(name = "QaTestPlanItem.findByItemNu", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemNu = :itemNu"),
    @NamedQuery(name = "QaTestPlanItem.findByItemSa", query = "SELECT q FROM QaTestPlanItem q WHERE q.itemSa = :itemSa"),
    @NamedQuery(name = "QaTestPlanItem.findBySourceLocation", query = "SELECT q FROM QaTestPlanItem q WHERE q.sourceLocation = :sourceLocation"),
    @NamedQuery(name = "QaTestPlanItem.findByNotes", query = "SELECT q FROM QaTestPlanItem q WHERE q.notes = :notes"),
    @NamedQuery(name = "QaTestPlanItem.findByAccFreq", query = "SELECT q FROM QaTestPlanItem q WHERE q.accFreq = :accFreq"),
    @NamedQuery(name = "QaTestPlanItem.findByNcrStatus", query = "SELECT q FROM QaTestPlanItem q WHERE q.ncrStatus = :ncrStatus"),
    @NamedQuery(name = "QaTestPlanItem.findByRms1", query = "SELECT q FROM QaTestPlanItem q WHERE q.rms1 = :rms1"),
    @NamedQuery(name = "QaTestPlanItem.findByRms2", query = "SELECT q FROM QaTestPlanItem q WHERE q.rms2 = :rms2"),
    @NamedQuery(name = "QaTestPlanItem.findByRms3", query = "SELECT q FROM QaTestPlanItem q WHERE q.rms3 = :rms3"),
    @NamedQuery(name = "QaTestPlanItem.findByRmsD", query = "SELECT q FROM QaTestPlanItem q WHERE q.rmsD = :rmsD"),
    @NamedQuery(name = "QaTestPlanItem.findByCertc", query = "SELECT q FROM QaTestPlanItem q WHERE q.certc = :certc"),
    @NamedQuery(name = "QaTestPlanItem.findByOtherNote", query = "SELECT q FROM QaTestPlanItem q WHERE q.otherNote = :otherNote"),
    @NamedQuery(name = "QaTestPlanItem.findByStatusRe", query = "SELECT q FROM QaTestPlanItem q WHERE q.statusRe = :statusRe"),
    @NamedQuery(name = "QaTestPlanItem.findByStatusDme", query = "SELECT q FROM QaTestPlanItem q WHERE q.statusDme = :statusDme"),
    @NamedQuery(name = "QaTestPlanItem.findByRemarks", query = "SELECT q FROM QaTestPlanItem q WHERE q.remarks = :remarks"),
    @NamedQuery(name = "QaTestPlanItem.findByActive", query = "SELECT q FROM QaTestPlanItem q WHERE q.active = :active"),
    @NamedQuery(name = "QaTestPlanItem.findByField1", query = "SELECT q FROM QaTestPlanItem q WHERE q.field1 = :field1"),
    @NamedQuery(name = "QaTestPlanItem.findByField2", query = "SELECT q FROM QaTestPlanItem q WHERE q.field2 = :field2"),
    @NamedQuery(name = "QaTestPlanItem.findByField3", query = "SELECT q FROM QaTestPlanItem q WHERE q.field3 = :field3"),
    @NamedQuery(name = "QaTestPlanItem.findByField4", query = "SELECT q FROM QaTestPlanItem q WHERE q.field4 = :field4"),
    @NamedQuery(name = "QaTestPlanItem.findByField5", query = "SELECT q FROM QaTestPlanItem q WHERE q.field5 = :field5"),
    @NamedQuery(name = "QaTestPlanItem.findByField6", query = "SELECT q FROM QaTestPlanItem q WHERE q.field6 = :field6"),
    @NamedQuery(name = "QaTestPlanItem.findByCreateBy", query = "SELECT q FROM QaTestPlanItem q WHERE q.createBy = :createBy"),
    @NamedQuery(name = "QaTestPlanItem.findByCreateByIp", query = "SELECT q FROM QaTestPlanItem q WHERE q.createByIp = :createByIp"),
    @NamedQuery(name = "QaTestPlanItem.findByLastModBy", query = "SELECT q FROM QaTestPlanItem q WHERE q.lastModBy = :lastModBy"),
    @NamedQuery(name = "QaTestPlanItem.findByLastMod", query = "SELECT q FROM QaTestPlanItem q WHERE q.lastMod = :lastMod"),
    @NamedQuery(name = "QaTestPlanItem.findByLastModIp", query = "SELECT q FROM QaTestPlanItem q WHERE q.lastModIp = :lastModIp"),
    @NamedQuery(name = "QaTestPlanItem.findByVersion", query = "SELECT q FROM QaTestPlanItem q WHERE q.version = :version"),
    @NamedQuery(name = "QaTestPlanItem.findByMatSpec", query = "SELECT q FROM QaTestPlanItem q WHERE q.matSpec = :matSpec"),
    @NamedQuery(name = "QaTestPlanItem.findByConstSect", query = "SELECT q FROM QaTestPlanItem q WHERE q.constSect = :constSect"),
    @NamedQuery(name = "QaTestPlanItem.findByMatCatg", query = "SELECT q FROM QaTestPlanItem q WHERE q.matCatg = :matCatg"),
    @NamedQuery(name = "QaTestPlanItem.findBySampleSize", query = "SELECT q FROM QaTestPlanItem q WHERE q.sampleSize = :sampleSize"),
    @NamedQuery(name = "QaTestPlanItem.findByPointSample", query = "SELECT q FROM QaTestPlanItem q WHERE q.pointSample = :pointSample"),
    @NamedQuery(name = "QaTestPlanItem.findByAccLotSize", query = "SELECT q FROM QaTestPlanItem q WHERE q.accLotSize = :accLotSize"),
    @NamedQuery(name = "QaTestPlanItem.findByAccSublotSize", query = "SELECT q FROM QaTestPlanItem q WHERE q.accSublotSize = :accSublotSize"),
    @NamedQuery(name = "QaTestPlanItem.findByQcLotSize", query = "SELECT q FROM QaTestPlanItem q WHERE q.qcLotSize = :qcLotSize"),
    @NamedQuery(name = "QaTestPlanItem.findByQcSublotSize", query = "SELECT q FROM QaTestPlanItem q WHERE q.qcSublotSize = :qcSublotSize"),
    @NamedQuery(name = "QaTestPlanItem.findByQcFreq", query = "SELECT q FROM QaTestPlanItem q WHERE q.qcFreq = :qcFreq"),
    @NamedQuery(name = "QaTestPlanItem.findBySamplePrepMethod", query = "SELECT q FROM QaTestPlanItem q WHERE q.samplePrepMethod = :samplePrepMethod"),
    @NamedQuery(name = "QaTestPlanItem.findBySpecPrepMethod", query = "SELECT q FROM QaTestPlanItem q WHERE q.specPrepMethod = :specPrepMethod"),
    @NamedQuery(name = "QaTestPlanItem.findByTestMethod", query = "SELECT q FROM QaTestPlanItem q WHERE q.testMethod = :testMethod"),
    @NamedQuery(name = "QaTestPlanItem.findByInspection", query = "SELECT q FROM QaTestPlanItem q WHERE q.inspection = :inspection"),
    @NamedQuery(name = "QaTestPlanItem.findBySourceVerf", query = "SELECT q FROM QaTestPlanItem q WHERE q.sourceVerf = :sourceVerf"),
    @NamedQuery(name = "QaTestPlanItem.findByTestMethod1", query = "SELECT q FROM QaTestPlanItem q WHERE q.testMethod1 = :testMethod1"),
    @NamedQuery(name = "QaTestPlanItem.findByTestMethod2", query = "SELECT q FROM QaTestPlanItem q WHERE q.testMethod2 = :testMethod2"),
    @NamedQuery(name = "QaTestPlanItem.findByTestMethod3", query = "SELECT q FROM QaTestPlanItem q WHERE q.testMethod3 = :testMethod3"),
    @NamedQuery(name = "QaTestPlanItem.findByProjectedQty", query = "SELECT q FROM QaTestPlanItem q WHERE q.projectedQty = :projectedQty"),
    @NamedQuery(name = "QaTestPlanItem.findByTodateQty", query = "SELECT q FROM QaTestPlanItem q WHERE q.todateQty = :todateQty"),
    @NamedQuery(name = "QaTestPlanItem.findByIaType", query = "SELECT q FROM QaTestPlanItem q WHERE q.iaType = :iaType"),
    @NamedQuery(name = "QaTestPlanItem.findByPlanQty", query = "SELECT q FROM QaTestPlanItem q WHERE q.planQty = :planQty"),
    @NamedQuery(name = "QaTestPlanItem.findByIaCatgId", query = "SELECT q FROM QaTestPlanItem q WHERE q.iaCatgId = :iaCatgId"),
    @NamedQuery(name = "QaTestPlanItem.findBySrType", query = "SELECT q FROM QaTestPlanItem q WHERE q.srType = :srType")
*/

/**
 *
 * @author droldan
 */
@Entity
@Table(name = "QA_TEST_PLAN_ITEM", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QaTestPlanItem.findAll", query = "SELECT q FROM QaTestPlanItem q"),
    @NamedQuery(name = "QaTestPlanItem.findById", query = "SELECT q FROM QaTestPlanItem q WHERE q.id = :id")})
public class QaTestPlanItem implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "qa_test_plan_item_id_seq", sequenceName = "qa_test_plan_item_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "qa_test_plan_item_id_seq")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEST_PLAN_ID")
    private BigInteger testPlanId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PARENT_ID")
    private BigInteger parentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ITEM_ID")
    private BigInteger itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SUB_ITEM_ID")
    private BigInteger subItemId;
    @Size(max = 200)
    @Column(name = "ITEM_TYPE")
    private String itemType;
    @Size(max = 200)
    @Column(name = "ITEM_NO")
    private String itemNo;
    @Size(max = 500)
    @Column(name = "ITEM_DESCRIPT")
    private String itemDescript;
    @Size(max = 500)
    @Column(name = "ITEM_DESCRIPT_V")
    private String itemDescriptV;
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
    @Size(max = 50)
    @Column(name = "STATUS_RE")
    private String statusRe;
    @Size(max = 50)
    @Column(name = "STATUS_DME")
    private String statusDme;
    @Size(max = 1000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "ACTIVE", insertable = false)
    private Character active;
    @Size(max = 200)
    @Column(name = "FIELD1")
    private String field1;
    @Size(max = 200)
    @Column(name = "FIELD2")
    private String field2;
    @Size(max = 200)
    @Column(name = "FIELD3")
    private String field3;
    @Size(max = 200)
    @Column(name = "FIELD4")
    private String field4;
    @Column(name = "FIELD5")
    private Double field5;
    @Column(name = "FIELD6")
    @Temporal(TemporalType.TIMESTAMP)
    private Date field6;
    @Size(max = 100)
    @Column(name = "CREATE_BY")
    private String createBy;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "CREATE_BY_IP")
    private String createByIp;
    @Size(max = 100)
    @Column(name = "LAST_MOD_BY")
    private String lastModBy;
    @Size(max = 20)
    @Column(name = "LAST_MOD")
    private String lastMod;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "LAST_MOD_IP")
    private String lastModIp;
    @Size(max = 20)
    @Column(name = "VERSION", insertable = false)
    private String version;
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
    @Column(name = "PROJECTED_QTY")
    private Double projectedQty;
    @Column(name = "TODATE_QTY")
    private Double todateQty;
    @Size(max = 100)
    @Column(name = "IA_TYPE")
    private String iaType;
    @Column(name = "PLAN_QTY")
    private Double planQty;
    @Column(name = "IA_CATG_ID")
    private BigInteger iaCatgId;
    @Size(max = 100)
    @Column(name = "SR_TYPE")
    private String srType;
    @Column(name = "WBS_ID")
    private BigInteger wbsId;
    @Column(name = "WBS_TYPE")
    private BigInteger wbsType;

    public QaTestPlanItem() {
    }

    public QaTestPlanItem(BigDecimal id) {
        this.id = id;
    }

    public QaTestPlanItem(BigDecimal id, BigInteger testPlanId, BigInteger parentId, BigInteger itemId, BigInteger subItemId) {
        this.id = id;
        this.testPlanId = testPlanId;
        this.parentId = parentId;
        this.itemId = itemId;
        this.subItemId = subItemId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
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

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public Date getField6() {
        return field6;
    }

    public void setField6(Date field6) {
        this.field6 = field6;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateByIp() {
        return createByIp;
    }

    public void setCreateByIp(String createByIp) {
        this.createByIp = createByIp;
    }

    public String getLastModBy() {
        return lastModBy;
    }

    public void setLastModBy(String lastModBy) {
        this.lastModBy = lastModBy;
    }

    public String getLastMod() {
        return lastMod;
    }

    public void setLastMod(String lastMod) {
        this.lastMod = lastMod;
    }

    public String getLastModIp() {
        return lastModIp;
    }

    public void setLastModIp(String lastModIp) {
        this.lastModIp = lastModIp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public Double getPlanQty() {
        return planQty;
    }

    public void setPlanQty(Double planQty) {
        this.planQty = planQty;
    }

    public BigInteger getIaCatgId() {
        return iaCatgId;
    }

    public void setIaCatgId(BigInteger iaCatgId) {
        this.iaCatgId = iaCatgId;
    }

    public String getSrType() {
        return srType;
    }

    public void setSrType(String srType) {
        this.srType = srType;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QaTestPlanItem)) {
            return false;
        }
        QaTestPlanItem other = (QaTestPlanItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.atser.tools.atserejb.model.QaTestPlanItem[ id=" + id + ", testPlanId= " + testPlanId + ", itemId= " + itemId +" ]";
    }
    
}
