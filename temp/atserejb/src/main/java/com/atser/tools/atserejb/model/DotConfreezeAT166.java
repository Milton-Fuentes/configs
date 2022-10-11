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
@Table(name = "DOT_CONFREEZE_A_T166", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConfreezeAT166.findAll", query = "SELECT a FROM DotConfreezeAT166 a")})
public class DotConfreezeAT166 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "SUBBIDITEM_ID")
    private Integer subbiditemId;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "MIX_DESIGN_ID")
    private Integer mixDesignId;
    @Column(name = "TEST_ID")
    private Integer testId;
    @Column(name = "LAB_ID")
    private Integer labId;
    @Column(name = "QA_SAMPLE_ID")
    private Integer qaSampleId;
    @Column(name = "BIDITEM_ID")
    private Integer biditemId;
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 323)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 50)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "DELTAM2_RESULT")
    private String deltam2Result;
    @Size(max = 50)
    @Column(name = "DELTAM1_RESULT")
    private String deltam1Result;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "CURING_DURATION")
    private String curingDuration;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "DURABILITY_FACTOR_AVG")
    private String durabilityFactorAvg;
    @Size(max = 50)
    @Column(name = "DURABILITY_FACTOR2")
    private String durabilityFactor2;
    @Size(max = 50)
    @Column(name = "RELATIVE_DYNAMIC_MODULUS2")
    private String relativeDynamicModulus2;
    @Size(max = 50)
    @Column(name = "DURABILITY_FACTOR")
    private String durabilityFactor;
    @Size(max = 50)
    @Column(name = "SPECIFIED_CYCLE_EXP_TERMINATED")
    private String specifiedCycleExpTerminated;
    @Size(max = 50)
    @Column(name = "RELATIVE_DYNAMIC_MODULUS")
    private String relativeDynamicModulus;
    @Size(max = 50)
    @Column(name = "CYCLES_EXPOSURE_TERMINATED2")
    private String cyclesExposureTerminated2;
    @Size(max = 50)
    @Column(name = "DATE_14DAY_CURE_PERIOD")
    private String date14dayCurePeriod;
    @Size(max = 50)
    @Column(name = "HUMIDITY_PCT")
    private String humidityPct;
    @Size(max = 50)
    @Column(name = "TEMPERATURE")
    private String temperature;
    @Size(max = 50)
    @Column(name = "SAMPLE_DIMENSIONS")
    private String sampleDimensions;
    @Size(max = 50)
    @Column(name = "FREEZE_TEMP")
    private String freezeTemp;
    @Size(max = 50)
    @Column(name = "THAW_TEMP")
    private String thawTemp;
    @Size(max = 50)
    @Column(name = "TIME_TO_FREEZE")
    private String timeToFreeze;
    @Size(max = 50)
    @Column(name = "HOLD_TIME")
    private String holdTime;
    @Size(max = 50)
    @Column(name = "TIME_TO_THAW")
    private String timeToThaw;
    @Size(max = 50)
    @Column(name = "NUMBER_OF_CYCLES")
    private String numberOfCycles;
    @Size(max = 50)
    @Column(name = "DURATION_PER_CYCLE")
    private String durationPerCycle;
    @Size(max = 50)
    @Column(name = "TOTAL_DURATION")
    private String totalDuration;
    @Size(max = 50)
    @Column(name = "LS")
    private String ls;
    @Size(max = 50)
    @Column(name = "CYCLES_EXPOSURE_TERMINATED")
    private String cyclesExposureTerminated;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TESTNO")
    private String sampleTestno;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotConfreezeAT166() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public Integer getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(Integer subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(Integer mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(Integer qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public Integer getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(Integer biditemId) {
        this.biditemId = biditemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
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

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getDeltam2Result() {
        return deltam2Result;
    }

    public void setDeltam2Result(String deltam2Result) {
        this.deltam2Result = deltam2Result;
    }

    public String getDeltam1Result() {
        return deltam1Result;
    }

    public void setDeltam1Result(String deltam1Result) {
        this.deltam1Result = deltam1Result;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getCuringDuration() {
        return curingDuration;
    }

    public void setCuringDuration(String curingDuration) {
        this.curingDuration = curingDuration;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getDurabilityFactorAvg() {
        return durabilityFactorAvg;
    }

    public void setDurabilityFactorAvg(String durabilityFactorAvg) {
        this.durabilityFactorAvg = durabilityFactorAvg;
    }

    public String getDurabilityFactor2() {
        return durabilityFactor2;
    }

    public void setDurabilityFactor2(String durabilityFactor2) {
        this.durabilityFactor2 = durabilityFactor2;
    }

    public String getRelativeDynamicModulus2() {
        return relativeDynamicModulus2;
    }

    public void setRelativeDynamicModulus2(String relativeDynamicModulus2) {
        this.relativeDynamicModulus2 = relativeDynamicModulus2;
    }

    public String getDurabilityFactor() {
        return durabilityFactor;
    }

    public void setDurabilityFactor(String durabilityFactor) {
        this.durabilityFactor = durabilityFactor;
    }

    public String getSpecifiedCycleExpTerminated() {
        return specifiedCycleExpTerminated;
    }

    public void setSpecifiedCycleExpTerminated(String specifiedCycleExpTerminated) {
        this.specifiedCycleExpTerminated = specifiedCycleExpTerminated;
    }

    public String getRelativeDynamicModulus() {
        return relativeDynamicModulus;
    }

    public void setRelativeDynamicModulus(String relativeDynamicModulus) {
        this.relativeDynamicModulus = relativeDynamicModulus;
    }

    public String getCyclesExposureTerminated2() {
        return cyclesExposureTerminated2;
    }

    public void setCyclesExposureTerminated2(String cyclesExposureTerminated2) {
        this.cyclesExposureTerminated2 = cyclesExposureTerminated2;
    }

    public String getDate14dayCurePeriod() {
        return date14dayCurePeriod;
    }

    public void setDate14dayCurePeriod(String date14dayCurePeriod) {
        this.date14dayCurePeriod = date14dayCurePeriod;
    }

    public String getHumidityPct() {
        return humidityPct;
    }

    public void setHumidityPct(String humidityPct) {
        this.humidityPct = humidityPct;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getSampleDimensions() {
        return sampleDimensions;
    }

    public void setSampleDimensions(String sampleDimensions) {
        this.sampleDimensions = sampleDimensions;
    }

    public String getFreezeTemp() {
        return freezeTemp;
    }

    public void setFreezeTemp(String freezeTemp) {
        this.freezeTemp = freezeTemp;
    }

    public String getThawTemp() {
        return thawTemp;
    }

    public void setThawTemp(String thawTemp) {
        this.thawTemp = thawTemp;
    }

    public String getTimeToFreeze() {
        return timeToFreeze;
    }

    public void setTimeToFreeze(String timeToFreeze) {
        this.timeToFreeze = timeToFreeze;
    }

    public String getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(String holdTime) {
        this.holdTime = holdTime;
    }

    public String getTimeToThaw() {
        return timeToThaw;
    }

    public void setTimeToThaw(String timeToThaw) {
        this.timeToThaw = timeToThaw;
    }

    public String getNumberOfCycles() {
        return numberOfCycles;
    }

    public void setNumberOfCycles(String numberOfCycles) {
        this.numberOfCycles = numberOfCycles;
    }

    public String getDurationPerCycle() {
        return durationPerCycle;
    }

    public void setDurationPerCycle(String durationPerCycle) {
        this.durationPerCycle = durationPerCycle;
    }

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getLs() {
        return ls;
    }

    public void setLs(String ls) {
        this.ls = ls;
    }

    public String getCyclesExposureTerminated() {
        return cyclesExposureTerminated;
    }

    public void setCyclesExposureTerminated(String cyclesExposureTerminated) {
        this.cyclesExposureTerminated = cyclesExposureTerminated;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public void setSubbiditemDescript(String subbiditemDescript) {
        this.subbiditemDescript = subbiditemDescript;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public void setBiditemDescript(String biditemDescript) {
        this.biditemDescript = biditemDescript;
    }

    public String getSampleTestno() {
        return sampleTestno;
    }

    public void setSampleTestno(String sampleTestno) {
        this.sampleTestno = sampleTestno;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }

}
