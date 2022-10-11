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
@Table(name = "DOT_CONCALKASR_T380", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConcalkasrT380.findAll", query = "SELECT a FROM DotConcalkasrT380 a")})
public class DotConcalkasrT380 implements Serializable {

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
    @Column(name = "PASSFAIL")
    private Character passfail;
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
    @Column(name = "QUANTITY")
    private Integer quantity;
    @Size(max = 12)
    @Column(name = "CEMENT")
    private String cement;
    @Size(max = 12)
    @Column(name = "FLY_ASH")
    private String flyAsh;
    @Size(max = 122)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 173)
    @Column(name = "CEMENT_INFO")
    private String cementInfo;
    @Size(max = 173)
    @Column(name = "COARSE_AGG_INFO")
    private String coarseAggInfo;
    @Size(max = 173)
    @Column(name = "FLY_ASH_INFO")
    private String flyAshInfo;
    @Size(max = 173)
    @Column(name = "FINE_AGG_INFO")
    private String fineAggInfo;
    @Size(max = 173)
    @Column(name = "SILICA_FUME_INFO")
    private String silicaFumeInfo;
    @Size(max = 173)
    @Column(name = "SLAG_INFO")
    private String slagInfo;
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
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 321)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "SST_A")
    private String sstA;
    @Size(max = 50)
    @Column(name = "SST_B")
    private String sstB;
    @Size(max = 50)
    @Column(name = "SST_C")
    private String sstC;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME")
    private String bestfitTime;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP")
    private String bestfitPctExp;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "SLAG")
    private String slag;
    @Size(max = 50)
    @Column(name = "SILICA_FUME")
    private String silicaFume;
    @Size(max = 50)
    @Column(name = "FINE_AGG_SOURCE")
    private String fineAggSource;
    @Size(max = 50)
    @Column(name = "FINE_AGG_LOCATION")
    private String fineAggLocation;
    @Size(max = 50)
    @Column(name = "FINE_AGG_TYPE")
    private String fineAggType;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_SOURCE")
    private String coarseAggSource;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_LOCATION")
    private String coarseAggLocation;
    @Size(max = 50)
    @Column(name = "COARSE_AGG_TYPE")
    private String coarseAggType;
    @Size(max = 50)
    @Column(name = "CEMENT_SOURCE")
    private String cementSource;
    @Size(max = 50)
    @Column(name = "CEMENT_LOCATION")
    private String cementLocation;
    @Size(max = 50)
    @Column(name = "CEMENT_TYPE")
    private String cementType;
    @Size(max = 50)
    @Column(name = "FLY_ASH_SOURCE")
    private String flyAshSource;
    @Size(max = 50)
    @Column(name = "FLY_ASH_LOCATION")
    private String flyAshLocation;
    @Size(max = 50)
    @Column(name = "FLY_ASH_TYPE")
    private String flyAshType;
    @Size(max = 50)
    @Column(name = "SLAG_SOURCE")
    private String slagSource;
    @Size(max = 50)
    @Column(name = "SLAG_LOCATION")
    private String slagLocation;
    @Size(max = 50)
    @Column(name = "SLAG_TYPE")
    private String slagType;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_SOURCE")
    private String silicaFumeSource;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_LOCATION")
    private String silicaFumeLocation;
    @Size(max = 50)
    @Column(name = "SILICA_FUME_TYPE")
    private String silicaFumeType;
    @Size(max = 50)
    @Column(name = "GAUGE_LENGTH")
    private String gaugeLength;
    @Size(max = 50)
    @Column(name = "A2")
    private String a2;
    @Size(max = 50)
    @Column(name = "A1")
    private String a1;
    @Size(max = 50)
    @Column(name = "A0")
    private String a0;
    @Size(max = 50)
    @Column(name = "R2")
    private String r2;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "PCT_EXPANSION_DAYS")
    private String pctExpansionDays;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 50)
    @Column(name = "CLASSIFICATION")
    private String classification;
    @Size(max = 50)
    @Column(name = "PCT_EXPANSION")
    private String pctExpansion;
    @Size(max = 50)
    @Column(name = "TIME1")
    private String time1;
    @Size(max = 50)
    @Column(name = "LENGTH_A")
    private String lengthA;
    @Size(max = 50)
    @Column(name = "LENGTH_B")
    private String lengthB;
    @Size(max = 50)
    @Column(name = "LENGTH_C")
    private String lengthC;
    @Size(max = 50)
    @Column(name = "TIME2")
    private String time2;
    @Size(max = 50)
    @Column(name = "PCT_A")
    private String pctA;
    @Size(max = 50)
    @Column(name = "PCT_B")
    private String pctB;
    @Size(max = 50)
    @Column(name = "PCT_C")
    private String pctC;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Size(max = 50)
    @Column(name = "BESTFIT_A")
    private String bestfitA;
    @Size(max = 50)
    @Column(name = "BESTFIT_B")
    private String bestfitB;
    @Size(max = 50)
    @Column(name = "BESTFIT_C")
    private String bestfitC;
    @Size(max = 50)
    @Column(name = "SSE_A")
    private String sseA;
    @Size(max = 50)
    @Column(name = "SSE_B")
    private String sseB;
    @Size(max = 50)
    @Column(name = "SSE_C")
    private String sseC;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TESTNO")
    private String sampleTestno;

    public DotConcalkasrT380() {
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

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCement() {
        return cement;
    }

    public void setCement(String cement) {
        this.cement = cement;
    }

    public String getFlyAsh() {
        return flyAsh;
    }

    public void setFlyAsh(String flyAsh) {
        this.flyAsh = flyAsh;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    public String getCementInfo() {
        return cementInfo;
    }

    public void setCementInfo(String cementInfo) {
        this.cementInfo = cementInfo;
    }

    public String getCoarseAggInfo() {
        return coarseAggInfo;
    }

    public void setCoarseAggInfo(String coarseAggInfo) {
        this.coarseAggInfo = coarseAggInfo;
    }

    public String getFlyAshInfo() {
        return flyAshInfo;
    }

    public void setFlyAshInfo(String flyAshInfo) {
        this.flyAshInfo = flyAshInfo;
    }

    public String getFineAggInfo() {
        return fineAggInfo;
    }

    public void setFineAggInfo(String fineAggInfo) {
        this.fineAggInfo = fineAggInfo;
    }

    public String getSilicaFumeInfo() {
        return silicaFumeInfo;
    }

    public void setSilicaFumeInfo(String silicaFumeInfo) {
        this.silicaFumeInfo = silicaFumeInfo;
    }

    public String getSlagInfo() {
        return slagInfo;
    }

    public void setSlagInfo(String slagInfo) {
        this.slagInfo = slagInfo;
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

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSstA() {
        return sstA;
    }

    public void setSstA(String sstA) {
        this.sstA = sstA;
    }

    public String getSstB() {
        return sstB;
    }

    public void setSstB(String sstB) {
        this.sstB = sstB;
    }

    public String getSstC() {
        return sstC;
    }

    public void setSstC(String sstC) {
        this.sstC = sstC;
    }

    public String getBestfitTime() {
        return bestfitTime;
    }

    public void setBestfitTime(String bestfitTime) {
        this.bestfitTime = bestfitTime;
    }

    public String getBestfitPctExp() {
        return bestfitPctExp;
    }

    public void setBestfitPctExp(String bestfitPctExp) {
        this.bestfitPctExp = bestfitPctExp;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getSlag() {
        return slag;
    }

    public void setSlag(String slag) {
        this.slag = slag;
    }

    public String getSilicaFume() {
        return silicaFume;
    }

    public void setSilicaFume(String silicaFume) {
        this.silicaFume = silicaFume;
    }

    public String getFineAggSource() {
        return fineAggSource;
    }

    public void setFineAggSource(String fineAggSource) {
        this.fineAggSource = fineAggSource;
    }

    public String getFineAggLocation() {
        return fineAggLocation;
    }

    public void setFineAggLocation(String fineAggLocation) {
        this.fineAggLocation = fineAggLocation;
    }

    public String getFineAggType() {
        return fineAggType;
    }

    public void setFineAggType(String fineAggType) {
        this.fineAggType = fineAggType;
    }

    public String getCoarseAggSource() {
        return coarseAggSource;
    }

    public void setCoarseAggSource(String coarseAggSource) {
        this.coarseAggSource = coarseAggSource;
    }

    public String getCoarseAggLocation() {
        return coarseAggLocation;
    }

    public void setCoarseAggLocation(String coarseAggLocation) {
        this.coarseAggLocation = coarseAggLocation;
    }

    public String getCoarseAggType() {
        return coarseAggType;
    }

    public void setCoarseAggType(String coarseAggType) {
        this.coarseAggType = coarseAggType;
    }

    public String getCementSource() {
        return cementSource;
    }

    public void setCementSource(String cementSource) {
        this.cementSource = cementSource;
    }

    public String getCementLocation() {
        return cementLocation;
    }

    public void setCementLocation(String cementLocation) {
        this.cementLocation = cementLocation;
    }

    public String getCementType() {
        return cementType;
    }

    public void setCementType(String cementType) {
        this.cementType = cementType;
    }

    public String getFlyAshSource() {
        return flyAshSource;
    }

    public void setFlyAshSource(String flyAshSource) {
        this.flyAshSource = flyAshSource;
    }

    public String getFlyAshLocation() {
        return flyAshLocation;
    }

    public void setFlyAshLocation(String flyAshLocation) {
        this.flyAshLocation = flyAshLocation;
    }

    public String getFlyAshType() {
        return flyAshType;
    }

    public void setFlyAshType(String flyAshType) {
        this.flyAshType = flyAshType;
    }

    public String getSlagSource() {
        return slagSource;
    }

    public void setSlagSource(String slagSource) {
        this.slagSource = slagSource;
    }

    public String getSlagLocation() {
        return slagLocation;
    }

    public void setSlagLocation(String slagLocation) {
        this.slagLocation = slagLocation;
    }

    public String getSlagType() {
        return slagType;
    }

    public void setSlagType(String slagType) {
        this.slagType = slagType;
    }

    public String getSilicaFumeSource() {
        return silicaFumeSource;
    }

    public void setSilicaFumeSource(String silicaFumeSource) {
        this.silicaFumeSource = silicaFumeSource;
    }

    public String getSilicaFumeLocation() {
        return silicaFumeLocation;
    }

    public void setSilicaFumeLocation(String silicaFumeLocation) {
        this.silicaFumeLocation = silicaFumeLocation;
    }

    public String getSilicaFumeType() {
        return silicaFumeType;
    }

    public void setSilicaFumeType(String silicaFumeType) {
        this.silicaFumeType = silicaFumeType;
    }

    public String getGaugeLength() {
        return gaugeLength;
    }

    public void setGaugeLength(String gaugeLength) {
        this.gaugeLength = gaugeLength;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA0() {
        return a0;
    }

    public void setA0(String a0) {
        this.a0 = a0;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getPctExpansionDays() {
        return pctExpansionDays;
    }

    public void setPctExpansionDays(String pctExpansionDays) {
        this.pctExpansionDays = pctExpansionDays;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getPctExpansion() {
        return pctExpansion;
    }

    public void setPctExpansion(String pctExpansion) {
        this.pctExpansion = pctExpansion;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getLengthA() {
        return lengthA;
    }

    public void setLengthA(String lengthA) {
        this.lengthA = lengthA;
    }

    public String getLengthB() {
        return lengthB;
    }

    public void setLengthB(String lengthB) {
        this.lengthB = lengthB;
    }

    public String getLengthC() {
        return lengthC;
    }

    public void setLengthC(String lengthC) {
        this.lengthC = lengthC;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getPctA() {
        return pctA;
    }

    public void setPctA(String pctA) {
        this.pctA = pctA;
    }

    public String getPctB() {
        return pctB;
    }

    public void setPctB(String pctB) {
        this.pctB = pctB;
    }

    public String getPctC() {
        return pctC;
    }

    public void setPctC(String pctC) {
        this.pctC = pctC;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getBestfitA() {
        return bestfitA;
    }

    public void setBestfitA(String bestfitA) {
        this.bestfitA = bestfitA;
    }

    public String getBestfitB() {
        return bestfitB;
    }

    public void setBestfitB(String bestfitB) {
        this.bestfitB = bestfitB;
    }

    public String getBestfitC() {
        return bestfitC;
    }

    public void setBestfitC(String bestfitC) {
        this.bestfitC = bestfitC;
    }

    public String getSseA() {
        return sseA;
    }

    public void setSseA(String sseA) {
        this.sseA = sseA;
    }

    public String getSseB() {
        return sseB;
    }

    public void setSseB(String sseB) {
        this.sseB = sseB;
    }

    public String getSseC() {
        return sseC;
    }

    public void setSseC(String sseC) {
        this.sseC = sseC;
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

    public String getSampleTestno() {
        return sampleTestno;
    }

    public void setSampleTestno(String sampleTestno) {
        this.sampleTestno = sampleTestno;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
