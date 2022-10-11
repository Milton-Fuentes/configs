package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.math.BigInteger;
import java.math.BigDecimal;
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
@Table(name = "dot_snds_t104", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSndsT104.findAll", query = "SELECT a FROM DotSndsT104 a")})
public class DotSndsT104 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "NI_PCT_RETAINED")
    private String niPctRetained;
    @Size(max = 50)
    @Column(name = "ORIG_PCT_RETAINED")
    private String origPctRetained;
    @Size(max = 50)
    @Column(name = "MASS_PCT_LOSS")
    private String massPctLoss;
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
    @Size(max = 30)
    @Column(name = "MIX_DESIGN_NO")
    private String mixDesignNo;
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
    @Size(max = 305)
    @Column(name = "TESTNO")
    private String testNoLink;
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
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Column(name = "SET_ID")
    private BigDecimal setId;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 255)
    @Column(name = "CURRENT_GRADE")
    private String currentGrade;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Column(name = "AGGREGATE_ID")
    private BigDecimal aggregateId;
    @Size(max = 50)
    @Column(name = "PAN")
    private String pan;
    @Size(max = 50)
    @Column(name = "TOTALAGGGRADING")
    private String totalagggrading;
    @Size(max = 50)
    @Column(name = "TOTALWTSAMPLE")
    private String totalwtsample;
    @Size(max = 50)
    @Column(name = "TOTALPERCENTPASS")
    private String totalpercentpass;
    @Size(max = 50)
    @Column(name = "TOTALPERCENTLOSS")
    private String totalpercentloss;
    @Size(max = 50)
    @Column(name = "TOTAL_NI_PCT_RETAINED")
    private String totalNiPctRetained;
    @Size(max = 50)
    @Column(name = "SOUNDNESS_LOSS")
    private String soundnessLoss;
    @Size(max = 255)
    @Column(name = "AGG_CURRENT_GRADE")
    private String aggCurrentGrade;
    @Size(max = 50)
    @Column(name = "SOLUTION1")
    private String solution1;
    @Size(max = 50)
    @Column(name = "SOLUTION2")
    private String solution2;
    @Size(max = 50)
    @Column(name = "TEMP1")
    private String temp1;
    @Size(max = 50)
    @Column(name = "TEMP2")
    private String temp2;
    @Size(max = 50)
    @Column(name = "NEW_SOLUTION1")
    private String newSolution1;
    @Size(max = 50)
    @Column(name = "NEW_SOLUTION2")
    private String newSolution2;
    @Size(max = 50)
    @Column(name = "TOTAL_MASS_PCT_LOSS")
    private String totalMassPctLoss;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "AGG_NAME")
    private String aggName;
    @Size(max = 50)
    @Column(name = "AGGGRADING")
    private String agggrading;
    @Size(max = 50)
    @Column(name = "WTSAMPLE")
    private String wtsample;
    @Size(max = 50)
    @Column(name = "PERCENTPASSING")
    private String percentpassing;
    @Size(max = 50)
    @Column(name = "WTPERCENTLOSS")
    private String wtpercentloss;
    @Column(name = "AGGREGATE_TEST_ID")
    private BigDecimal aggregateTestId;
    @Column(name = "SIEVE_ID")
    private BigDecimal sieveId;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Column(name = "RUN_NO")
    private BigDecimal runNo;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
    @Column(name = "RETAINED_SIEVE_ID")
    private BigDecimal retainedSieveId;
    @Size(max = 50)
    @Column(name = "RET_SIEVE_NAME")
    private String retSieveName;
    @Size(max = 50)
    @Column(name = "LOSS_OF_WEIGHT")
    private String lossOfWeight;

    public DotSndsT104() {
    }

    public String getNiPctRetained() {
        return niPctRetained;
    }

    public void setNiPctRetained(String niPctRetained) {
        this.niPctRetained = niPctRetained;
    }

    public String getOrigPctRetained() {
        return origPctRetained;
    }

    public void setOrigPctRetained(String origPctRetained) {
        this.origPctRetained = origPctRetained;
    }

    public String getMassPctLoss() {
        return massPctLoss;
    }

    public void setMassPctLoss(String massPctLoss) {
        this.massPctLoss = massPctLoss;
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

    public String getMixDesignNo() {
        return mixDesignNo;
    }

    public void setMixDesignNo(String mixDesignNo) {
        this.mixDesignNo = mixDesignNo;
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

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getSetId() {
        return setId;
    }

    public void setSetId(BigDecimal setId) {
        this.setId = setId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
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

    public BigDecimal getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(BigDecimal aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTotalagggrading() {
        return totalagggrading;
    }

    public void setTotalagggrading(String totalagggrading) {
        this.totalagggrading = totalagggrading;
    }

    public String getTotalwtsample() {
        return totalwtsample;
    }

    public void setTotalwtsample(String totalwtsample) {
        this.totalwtsample = totalwtsample;
    }

    public String getTotalpercentpass() {
        return totalpercentpass;
    }

    public void setTotalpercentpass(String totalpercentpass) {
        this.totalpercentpass = totalpercentpass;
    }

    public String getTotalpercentloss() {
        return totalpercentloss;
    }

    public void setTotalpercentloss(String totalpercentloss) {
        this.totalpercentloss = totalpercentloss;
    }

    public String getTotalNiPctRetained() {
        return totalNiPctRetained;
    }

    public void setTotalNiPctRetained(String totalNiPctRetained) {
        this.totalNiPctRetained = totalNiPctRetained;
    }

    public String getSoundnessLoss() {
        return soundnessLoss;
    }

    public void setSoundnessLoss(String soundnessLoss) {
        this.soundnessLoss = soundnessLoss;
    }

    public String getAggCurrentGrade() {
        return aggCurrentGrade;
    }

    public void setAggCurrentGrade(String aggCurrentGrade) {
        this.aggCurrentGrade = aggCurrentGrade;
    }

    public String getSolution1() {
        return solution1;
    }

    public void setSolution1(String solution1) {
        this.solution1 = solution1;
    }

    public String getSolution2() {
        return solution2;
    }

    public void setSolution2(String solution2) {
        this.solution2 = solution2;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getNewSolution1() {
        return newSolution1;
    }

    public void setNewSolution1(String newSolution1) {
        this.newSolution1 = newSolution1;
    }

    public String getNewSolution2() {
        return newSolution2;
    }

    public void setNewSolution2(String newSolution2) {
        this.newSolution2 = newSolution2;
    }

    public String getTotalMassPctLoss() {
        return totalMassPctLoss;
    }

    public void setTotalMassPctLoss(String totalMassPctLoss) {
        this.totalMassPctLoss = totalMassPctLoss;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getAggName() {
        return aggName;
    }

    public void setAggName(String aggName) {
        this.aggName = aggName;
    }

    public String getAgggrading() {
        return agggrading;
    }

    public void setAgggrading(String agggrading) {
        this.agggrading = agggrading;
    }

    public String getWtsample() {
        return wtsample;
    }

    public void setWtsample(String wtsample) {
        this.wtsample = wtsample;
    }

    public String getPercentpassing() {
        return percentpassing;
    }

    public void setPercentpassing(String percentpassing) {
        this.percentpassing = percentpassing;
    }

    public String getWtpercentloss() {
        return wtpercentloss;
    }

    public void setWtpercentloss(String wtpercentloss) {
        this.wtpercentloss = wtpercentloss;
    }

    public BigDecimal getAggregateTestId() {
        return aggregateTestId;
    }

    public void setAggregateTestId(BigDecimal aggregateTestId) {
        this.aggregateTestId = aggregateTestId;
    }

    public BigDecimal getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigDecimal sieveId) {
        this.sieveId = sieveId;
    }

    public String getSieveName() {
        return sieveName;
    }

    public void setSieveName(String sieveName) {
        this.sieveName = sieveName;
    }

    public BigDecimal getRunNo() {
        return runNo;
    }

    public void setRunNo(BigDecimal runNo) {
        this.runNo = runNo;
    }

    public String getProjrequire() {
        return projrequire;
    }

    public void setProjrequire(String projrequire) {
        this.projrequire = projrequire;
    }

    public BigDecimal getRetainedSieveId() {
        return retainedSieveId;
    }

    public void setRetainedSieveId(BigDecimal retainedSieveId) {
        this.retainedSieveId = retainedSieveId;
    }

    public String getRetSieveName() {
        return retSieveName;
    }

    public void setRetSieveName(String retSieveName) {
        this.retSieveName = retSieveName;
    }

    public String getLossOfWeight() {
        return lossOfWeight;
    }

    public void setLossOfWeight(String lossOfWeight) {
        this.lossOfWeight = lossOfWeight;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
