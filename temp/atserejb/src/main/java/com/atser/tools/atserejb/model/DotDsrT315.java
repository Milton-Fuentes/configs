/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author mfuentes
 */
@Entity
@Immutable
@Table(name = "DOT_DSR_T315", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotDsrT315.findAll", query = "SELECT a FROM DotDsrT315 a")})
public class DotDsrT315 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_RESULT")
    private String pressureAgingResult;
    @Size(max = 50)
    @Column(name = "SERIAL_NO")
    private String serialNo;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TEST_ID")
    private BigDecimal testId;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Column(name = "CLIENT_ID")
    private BigDecimal clientId;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigDecimal labId;
    @Column(name = "QA_SAMPLE_ID")
    private BigDecimal qaSampleId;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Column(name = "MIX_DESIGN_ID")
    private BigDecimal mixDesignId;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "SAMPLETEST_ID")
    private BigDecimal sampletestId;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 20)
    @Column(name = "ASPHALTCEMENT")
    private String asphaltcement;
    @Size(max = 80)
    @Column(name = "ADDITIVE")
    private String additive;
    @Size(max = 327)
    @Column(name = "TESTNO")
    private String testno;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Column(name = "BIDITEM_ID")
    private BigDecimal biditemId;
    @Column(name = "SUBBIDITEM_ID")
    private BigInteger subbiditemId;
    @Column(name = "WBS_ID")
    private BigInteger wbsId;
    @Size(max = 200)
    @Column(name = "WBS_NO")
    private String wbsNo;
    @Size(max = 500)
    @Column(name = "WBS_DESCRIPT")
    private String wbsDescript;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Column(name = "BINDER_GRADE_ID")
    private BigInteger binderGradeId;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "ORIG_G_SIN")
    private String origGSin;
    @Size(max = 50)
    @Column(name = "ORIG_TEST_TEMP")
    private String origTestTemp;
    @Size(max = 50)
    @Column(name = "ORIG_PHASE_ANGLE")
    private String origPhaseAngle;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_G_SIN")
    private String rollThinGSin;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_TEST_TEMP")
    private String rollThinTestTemp;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_PHASE_ANGLE")
    private String rollThinPhaseAngle;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_G_SIN")
    private String pressureAgingGSin;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_TEST_TEMP")
    private String pressureAgingTestTemp;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_PHASE_ANGLE")
    private String pressureAgingPhaseAngle;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "ORIG_SPEC_MIN")
    private String origSpecMin;
    @Size(max = 50)
    @Column(name = "ORIG_SPEC_MAX")
    private String origSpecMax;
    @Size(max = 50)
    @Column(name = "ORIG_RESULT")
    private String origResult;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_SPEC_MIN")
    private String rollThinSpecMin;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_SPEC_MAX")
    private String rollThinSpecMax;
    @Size(max = 50)
    @Column(name = "ROLL_THIN_RESULT")
    private String rollThinResult;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_SPEC_MIN")
    private String pressureAgingSpecMin;
    @Size(max = 50)
    @Column(name = "PRESSURE_AGING_SPEC_MAX")
    private String pressureAgingSpecMax;

    public DotDsrT315() {
    }

    public String getPressureAgingResult() {
        return pressureAgingResult;
    }

    public void setPressureAgingResult(String pressureAgingResult) {
        this.pressureAgingResult = pressureAgingResult;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getTestId() {
        return testId;
    }

    public void setTestId(BigDecimal testId) {
        this.testId = testId;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public BigDecimal getClientId() {
        return clientId;
    }

    public void setClientId(BigDecimal clientId) {
        this.clientId = clientId;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigDecimal getLabId() {
        return labId;
    }

    public void setLabId(BigDecimal labId) {
        this.labId = labId;
    }

    public BigDecimal getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(BigDecimal qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public BigDecimal getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(BigDecimal mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public BigDecimal getSampletestId() {
        return sampletestId;
    }

    public void setSampletestId(BigDecimal sampletestId) {
        this.sampletestId = sampletestId;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getAsphaltcement() {
        return asphaltcement;
    }

    public void setAsphaltcement(String asphaltcement) {
        this.asphaltcement = asphaltcement;
    }

    public String getAdditive() {
        return additive;
    }

    public void setAdditive(String additive) {
        this.additive = additive;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public BigDecimal getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(BigDecimal biditemId) {
        this.biditemId = biditemId;
    }

    public BigInteger getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(BigInteger subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public BigInteger getWbsId() {
        return wbsId;
    }

    public void setWbsId(BigInteger wbsId) {
        this.wbsId = wbsId;
    }

    public String getWbsNo() {
        return wbsNo;
    }

    public void setWbsNo(String wbsNo) {
        this.wbsNo = wbsNo;
    }

    public String getWbsDescript() {
        return wbsDescript;
    }

    public void setWbsDescript(String wbsDescript) {
        this.wbsDescript = wbsDescript;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public void setBiditemDescript(String biditemDescript) {
        this.biditemDescript = biditemDescript;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public void setSubbiditemDescript(String subbiditemDescript) {
        this.subbiditemDescript = subbiditemDescript;
    }

    public BigInteger getBinderGradeId() {
        return binderGradeId;
    }

    public void setBinderGradeId(BigInteger binderGradeId) {
        this.binderGradeId = binderGradeId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getOrigGSin() {
        return origGSin;
    }

    public void setOrigGSin(String origGSin) {
        this.origGSin = origGSin;
    }

    public String getOrigTestTemp() {
        return origTestTemp;
    }

    public void setOrigTestTemp(String origTestTemp) {
        this.origTestTemp = origTestTemp;
    }

    public String getOrigPhaseAngle() {
        return origPhaseAngle;
    }

    public void setOrigPhaseAngle(String origPhaseAngle) {
        this.origPhaseAngle = origPhaseAngle;
    }

    public String getRollThinGSin() {
        return rollThinGSin;
    }

    public void setRollThinGSin(String rollThinGSin) {
        this.rollThinGSin = rollThinGSin;
    }

    public String getRollThinTestTemp() {
        return rollThinTestTemp;
    }

    public void setRollThinTestTemp(String rollThinTestTemp) {
        this.rollThinTestTemp = rollThinTestTemp;
    }

    public String getRollThinPhaseAngle() {
        return rollThinPhaseAngle;
    }

    public void setRollThinPhaseAngle(String rollThinPhaseAngle) {
        this.rollThinPhaseAngle = rollThinPhaseAngle;
    }

    public String getPressureAgingGSin() {
        return pressureAgingGSin;
    }

    public void setPressureAgingGSin(String pressureAgingGSin) {
        this.pressureAgingGSin = pressureAgingGSin;
    }

    public String getPressureAgingTestTemp() {
        return pressureAgingTestTemp;
    }

    public void setPressureAgingTestTemp(String pressureAgingTestTemp) {
        this.pressureAgingTestTemp = pressureAgingTestTemp;
    }

    public String getPressureAgingPhaseAngle() {
        return pressureAgingPhaseAngle;
    }

    public void setPressureAgingPhaseAngle(String pressureAgingPhaseAngle) {
        this.pressureAgingPhaseAngle = pressureAgingPhaseAngle;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOrigSpecMin() {
        return origSpecMin;
    }

    public void setOrigSpecMin(String origSpecMin) {
        this.origSpecMin = origSpecMin;
    }

    public String getOrigSpecMax() {
        return origSpecMax;
    }

    public void setOrigSpecMax(String origSpecMax) {
        this.origSpecMax = origSpecMax;
    }

    public String getOrigResult() {
        return origResult;
    }

    public void setOrigResult(String origResult) {
        this.origResult = origResult;
    }

    public String getRollThinSpecMin() {
        return rollThinSpecMin;
    }

    public void setRollThinSpecMin(String rollThinSpecMin) {
        this.rollThinSpecMin = rollThinSpecMin;
    }

    public String getRollThinSpecMax() {
        return rollThinSpecMax;
    }

    public void setRollThinSpecMax(String rollThinSpecMax) {
        this.rollThinSpecMax = rollThinSpecMax;
    }

    public String getRollThinResult() {
        return rollThinResult;
    }

    public void setRollThinResult(String rollThinResult) {
        this.rollThinResult = rollThinResult;
    }

    public String getPressureAgingSpecMin() {
        return pressureAgingSpecMin;
    }

    public void setPressureAgingSpecMin(String pressureAgingSpecMin) {
        this.pressureAgingSpecMin = pressureAgingSpecMin;
    }

    public String getPressureAgingSpecMax() {
        return pressureAgingSpecMax;
    }

    public void setPressureAgingSpecMax(String pressureAgingSpecMax) {
        this.pressureAgingSpecMax = pressureAgingSpecMax;
    }

    @JsonSkipXssSerialization
    public String getTestno() {
        if (StringSupport.isNotNullAndNotEmpty(testno) && testno.contains("../../")) {
            return testno.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testno;
    }
}
