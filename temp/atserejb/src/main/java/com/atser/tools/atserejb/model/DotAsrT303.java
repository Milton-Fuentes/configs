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
@Table(name = "DOT_ASR_T303", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotAsrT303.findAll", query = "SELECT a FROM DotAsrT303 a")})
public class DotAsrT303 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Column(name = "A1")
    private String a1;
    @Size(max = 50)
    @Column(name = "A0")
    private String a0;
    @Size(max = 50)
    @Column(name = "R2")
    private String r2;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
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
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "CLASSIFICATION")
    private String classification;
    @Size(max = 50)
    @Column(name = "PCT_EXPANSION")
    private String pctExpansion;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_1")
    private String bestfitTime1;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_1")
    private String bestfitPctExp1;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_2")
    private String bestfitTime2;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_2")
    private String bestfitPctExp2;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_3")
    private String bestfitTime3;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_3")
    private String bestfitPctExp3;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_4")
    private String bestfitTime4;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_4")
    private String bestfitPctExp4;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_5")
    private String bestfitTime5;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_5")
    private String bestfitPctExp5;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_6")
    private String bestfitTime6;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_6")
    private String bestfitPctExp6;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_7")
    private String bestfitTime7;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_7")
    private String bestfitPctExp7;
    @Size(max = 50)
    @Column(name = "BESTFIT_TIME_8")
    private String bestfitTime8;
    @Size(max = 50)
    @Column(name = "BESTFIT_PCT_EXP_8")
    private String bestfitPctExp8;
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
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
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
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 323)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 71)
    @Column(name = "SAMPLE_TESTNO")
    private String sampleTestno;
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
    @Size(max = 173)
    @Column(name = "FINE_AGG_INFO")
    private String fineAggInfo;
    @Size(max = 173)
    @Column(name = "COARSE_AGG_INFO")
    private String coarseAggInfo;
    @Size(max = 173)
    @Column(name = "CEMENT_INFO")
    private String cementInfo;
    @Size(max = 173)
    @Column(name = "FLY_ASH_INFO")
    private String flyAshInfo;
    @Size(max = 173)
    @Column(name = "SLAG_INFO")
    private String slagInfo;
    @Size(max = 173)
    @Column(name = "SILICA_FUME_INFO")
    private String silicaFumeInfo;
    @Size(max = 12)
    @Column(name = "CEMENT")
    private String cement;
    @Size(max = 12)
    @Column(name = "FLY_ASH")
    private String flyAsh;
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

    public DotAsrT303() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
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

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
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

    public String getBestfitTime1() {
        return bestfitTime1;
    }

    public void setBestfitTime1(String bestfitTime1) {
        this.bestfitTime1 = bestfitTime1;
    }

    public String getBestfitPctExp1() {
        return bestfitPctExp1;
    }

    public void setBestfitPctExp1(String bestfitPctExp1) {
        this.bestfitPctExp1 = bestfitPctExp1;
    }

    public String getBestfitTime2() {
        return bestfitTime2;
    }

    public void setBestfitTime2(String bestfitTime2) {
        this.bestfitTime2 = bestfitTime2;
    }

    public String getBestfitPctExp2() {
        return bestfitPctExp2;
    }

    public void setBestfitPctExp2(String bestfitPctExp2) {
        this.bestfitPctExp2 = bestfitPctExp2;
    }

    public String getBestfitTime3() {
        return bestfitTime3;
    }

    public void setBestfitTime3(String bestfitTime3) {
        this.bestfitTime3 = bestfitTime3;
    }

    public String getBestfitPctExp3() {
        return bestfitPctExp3;
    }

    public void setBestfitPctExp3(String bestfitPctExp3) {
        this.bestfitPctExp3 = bestfitPctExp3;
    }

    public String getBestfitTime4() {
        return bestfitTime4;
    }

    public void setBestfitTime4(String bestfitTime4) {
        this.bestfitTime4 = bestfitTime4;
    }

    public String getBestfitPctExp4() {
        return bestfitPctExp4;
    }

    public void setBestfitPctExp4(String bestfitPctExp4) {
        this.bestfitPctExp4 = bestfitPctExp4;
    }

    public String getBestfitTime5() {
        return bestfitTime5;
    }

    public void setBestfitTime5(String bestfitTime5) {
        this.bestfitTime5 = bestfitTime5;
    }

    public String getBestfitPctExp5() {
        return bestfitPctExp5;
    }

    public void setBestfitPctExp5(String bestfitPctExp5) {
        this.bestfitPctExp5 = bestfitPctExp5;
    }

    public String getBestfitTime6() {
        return bestfitTime6;
    }

    public void setBestfitTime6(String bestfitTime6) {
        this.bestfitTime6 = bestfitTime6;
    }

    public String getBestfitPctExp6() {
        return bestfitPctExp6;
    }

    public void setBestfitPctExp6(String bestfitPctExp6) {
        this.bestfitPctExp6 = bestfitPctExp6;
    }

    public String getBestfitTime7() {
        return bestfitTime7;
    }

    public void setBestfitTime7(String bestfitTime7) {
        this.bestfitTime7 = bestfitTime7;
    }

    public String getBestfitPctExp7() {
        return bestfitPctExp7;
    }

    public void setBestfitPctExp7(String bestfitPctExp7) {
        this.bestfitPctExp7 = bestfitPctExp7;
    }

    public String getBestfitTime8() {
        return bestfitTime8;
    }

    public void setBestfitTime8(String bestfitTime8) {
        this.bestfitTime8 = bestfitTime8;
    }

    public String getBestfitPctExp8() {
        return bestfitPctExp8;
    }

    public void setBestfitPctExp8(String bestfitPctExp8) {
        this.bestfitPctExp8 = bestfitPctExp8;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
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

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
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

    public String getFineAggInfo() {
        return fineAggInfo;
    }

    public void setFineAggInfo(String fineAggInfo) {
        this.fineAggInfo = fineAggInfo;
    }

    public String getCoarseAggInfo() {
        return coarseAggInfo;
    }

    public void setCoarseAggInfo(String coarseAggInfo) {
        this.coarseAggInfo = coarseAggInfo;
    }

    public String getCementInfo() {
        return cementInfo;
    }

    public void setCementInfo(String cementInfo) {
        this.cementInfo = cementInfo;
    }

    public String getFlyAshInfo() {
        return flyAshInfo;
    }

    public void setFlyAshInfo(String flyAshInfo) {
        this.flyAshInfo = flyAshInfo;
    }

    public String getSlagInfo() {
        return slagInfo;
    }

    public void setSlagInfo(String slagInfo) {
        this.slagInfo = slagInfo;
    }

    public String getSilicaFumeInfo() {
        return silicaFumeInfo;
    }

    public void setSilicaFumeInfo(String silicaFumeInfo) {
        this.silicaFumeInfo = silicaFumeInfo;
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

    @JsonSkipXssSerialization
    public String getTestno() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
