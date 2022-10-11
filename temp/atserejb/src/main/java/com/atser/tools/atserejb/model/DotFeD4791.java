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
@Table(name = "dot_fe_d4791", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotFeD4791.findAll", query = "SELECT a FROM DotFeD4791 a")})
public class DotFeD4791 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Column(name = "SIEVE_ORDER")
    private BigInteger sieveOrder;
    @Column(name = "RUN_NO")
    private BigDecimal runNo;
    @Size(max = 50)
    @Column(name = "WTRET")
    private String wtret;
    @Size(max = 50)
    @Column(name = "ACCUMWTRET")
    private String accumwtret;
    @Size(max = 50)
    @Column(name = "PERCENTPASS")
    private String percentpass;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
    @Size(max = 50)
    @Column(name = "GROUP1_NO")
    private String group1No;
    @Size(max = 50)
    @Column(name = "GROUP1_MASS")
    private String group1Mass;
    @Size(max = 50)
    @Column(name = "GROUP2_NO")
    private String group2No;
    @Size(max = 50)
    @Column(name = "GROUP2_MASS")
    private String group2Mass;
    @Size(max = 50)
    @Column(name = "GROUP3_NO")
    private String group3No;
    @Size(max = 50)
    @Column(name = "GROUP3_MASS")
    private String group3Mass;
    @Size(max = 50)
    @Column(name = "GROUP4_NO")
    private String group4No;
    @Size(max = 50)
    @Column(name = "GROUP4_MASS")
    private String group4Mass;
    @Column(name = "INDIVIDUAL_PERCENT")
    private Character individualPercent;
    @Column(name = "INDIVIDUAL_RETAINED")
    private Character individualRetained;
    @Column(name = "PERCENT_FLAT")
    private Character percentFlat;
    @Column(name = "WEIGHT_FLAT")
    private Character weightFlat;
    @Column(name = "WEIGHT_SAMPLE")
    private Character weightSample;
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
    @Size(max = 307)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;
    @Size(max = 50)
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
    @Column(name = "TOTAL_PERCENT_RET")
    private String totalPercentRet;
    @Column(name = "TOTAL_PERCENT_RET38")
    private String totalPercentRet38;
    @Column(name = "TOTAL_WT_AVERAGE")
    private String totalWtAverage;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "TEST_METHOD")
    private String testMethod;
    @Size(max = 100)
    @Column(name = "SOILCLASS")
    private String soilclass;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "IDENTIFICATION")
    private String identification;
    @Size(max = 50)
    @Column(name = "USED_SIEVE_SIZE")
    private String usedSieveSize;
    @Size(max = 50)
    @Column(name = "DIMENSIONAL_RATIO")
    private String dimensionalRatio;
    @Size(max = 50)
    @Column(name = "SUM_NO_PARTICLES")
    private String sumNoParticles;
    @Size(max = 50)
    @Column(name = "SUM_MASS_PARTICLES")
    private String sumMassParticles;
    @Size(max = 50)
    @Column(name = "SUM_TOTAL_WTRET")
    private String sumTotalWtret;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Size(max = 50)
    @Column(name = "TOTAL_PERRET")
    private String totalPerret;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Column(name = "SIEVE_RANGE_ID")
    private BigDecimal sieveRangeId;
    @Size(max = 50)
    @Column(name = "PERCENTRET")
    private String percentret;
    @Size(max = 50)
    @Column(name = "PERCENTRET38")
    private String percentret38;
    @Size(max = 50)
    @Column(name = "TOTAL_WTRET")
    private String totalWtret;
    @Size(max = 50)
    @Column(name = "FLAT_WTRET")
    private String flatWtret;
    @Size(max = 50)
    @Column(name = "FLAT_PERCENT")
    private String flatPercent;
    @Size(max = 50)
    @Column(name = "ELONG_WTRET")
    private String elongWtret;
    @Size(max = 50)
    @Column(name = "ELONG_PERCENT")
    private String elongPercent;
    @Size(max = 50)
    @Column(name = "NOTFE_WTRET")
    private String notfeWtret;
    @Size(max = 50)
    @Column(name = "NOTFE_PERCENT")
    private String notfePercent;
    @Size(max = 50)
    @Column(name = "FLAT_WTAVG_PERCENT")
    private String flatWtavgPercent;
    @Size(max = 50)
    @Column(name = "ELONG_WTAVG_PERCENT")
    private String elongWtavgPercent;
    @Size(max = 50)
    @Column(name = "FE_WTAVG_PERCENT")
    private String feWtavgPercent;
    @Size(max = 50)
    @Column(name = "TOTAL_PERCENT_SIEVE")
    private String totalPercentSieve;
    @Size(max = 50)
    @Column(name = "TOTAL_PERCENT_WTAVG")
    private String totalPercentWtavg;
    @Column(name = "SIEVE_ID")
    private BigDecimal sieveId;

    public DotFeD4791() {
    }

    public String getSieveName() {
        return sieveName;
    }

    public void setSieveName(String sieveName) {
        this.sieveName = sieveName;
    }

    public BigInteger getSieveOrder() {
        return sieveOrder;
    }

    public void setSieveOrder(BigInteger sieveOrder) {
        this.sieveOrder = sieveOrder;
    }

    public BigDecimal getRunNo() {
        return runNo;
    }

    public void setRunNo(BigDecimal runNo) {
        this.runNo = runNo;
    }

    public String getWtret() {
        return wtret;
    }

    public void setWtret(String wtret) {
        this.wtret = wtret;
    }

    public String getAccumwtret() {
        return accumwtret;
    }

    public void setAccumwtret(String accumwtret) {
        this.accumwtret = accumwtret;
    }

    public String getPercentpass() {
        return percentpass;
    }

    public void setPercentpass(String percentpass) {
        this.percentpass = percentpass;
    }

    public String getProjrequire() {
        return projrequire;
    }

    public void setProjrequire(String projrequire) {
        this.projrequire = projrequire;
    }

    public String getGroup1No() {
        return group1No;
    }

    public void setGroup1No(String group1No) {
        this.group1No = group1No;
    }

    public String getGroup1Mass() {
        return group1Mass;
    }

    public void setGroup1Mass(String group1Mass) {
        this.group1Mass = group1Mass;
    }

    public String getGroup2No() {
        return group2No;
    }

    public void setGroup2No(String group2No) {
        this.group2No = group2No;
    }

    public String getGroup2Mass() {
        return group2Mass;
    }

    public void setGroup2Mass(String group2Mass) {
        this.group2Mass = group2Mass;
    }

    public String getGroup3No() {
        return group3No;
    }

    public void setGroup3No(String group3No) {
        this.group3No = group3No;
    }

    public String getGroup3Mass() {
        return group3Mass;
    }

    public void setGroup3Mass(String group3Mass) {
        this.group3Mass = group3Mass;
    }

    public String getGroup4No() {
        return group4No;
    }

    public void setGroup4No(String group4No) {
        this.group4No = group4No;
    }

    public String getGroup4Mass() {
        return group4Mass;
    }

    public void setGroup4Mass(String group4Mass) {
        this.group4Mass = group4Mass;
    }

    public Character getIndividualPercent() {
        return individualPercent;
    }

    public void setIndividualPercent(Character individualPercent) {
        this.individualPercent = individualPercent;
    }

    public Character getIndividualRetained() {
        return individualRetained;
    }

    public void setIndividualRetained(Character individualRetained) {
        this.individualRetained = individualRetained;
    }

    public Character getPercentFlat() {
        return percentFlat;
    }

    public void setPercentFlat(Character percentFlat) {
        this.percentFlat = percentFlat;
    }

    public Character getWeightFlat() {
        return weightFlat;
    }

    public void setWeightFlat(Character weightFlat) {
        this.weightFlat = weightFlat;
    }

    public Character getWeightSample() {
        return weightSample;
    }

    public void setWeightSample(Character weightSample) {
        this.weightSample = weightSample;
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

    public String getTotalPercentRet() {
        return totalPercentRet;
    }

    public void setTotalPercentRet(String totalPercentRet) {
        this.totalPercentRet = totalPercentRet;
    }

    public String getTotalPercentRet38() {
        return totalPercentRet38;
    }

    public void setTotalPercentRet38(String totalPercentRet38) {
        this.totalPercentRet38 = totalPercentRet38;
    }

    public String getTotalWtAverage() {
        return totalWtAverage;
    }

    public void setTotalWtAverage(String totalWtAverage) {
        this.totalWtAverage = totalWtAverage;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getSoilclass() {
        return soilclass;
    }

    public void setSoilclass(String soilclass) {
        this.soilclass = soilclass;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getUsedSieveSize() {
        return usedSieveSize;
    }

    public void setUsedSieveSize(String usedSieveSize) {
        this.usedSieveSize = usedSieveSize;
    }

    public String getDimensionalRatio() {
        return dimensionalRatio;
    }

    public void setDimensionalRatio(String dimensionalRatio) {
        this.dimensionalRatio = dimensionalRatio;
    }

    public String getSumNoParticles() {
        return sumNoParticles;
    }

    public void setSumNoParticles(String sumNoParticles) {
        this.sumNoParticles = sumNoParticles;
    }

    public String getSumMassParticles() {
        return sumMassParticles;
    }

    public void setSumMassParticles(String sumMassParticles) {
        this.sumMassParticles = sumMassParticles;
    }

    public String getSumTotalWtret() {
        return sumTotalWtret;
    }

    public void setSumTotalWtret(String sumTotalWtret) {
        this.sumTotalWtret = sumTotalWtret;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public String getTotalPerret() {
        return totalPerret;
    }

    public void setTotalPerret(String totalPerret) {
        this.totalPerret = totalPerret;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public BigDecimal getSieveRangeId() {
        return sieveRangeId;
    }

    public void setSieveRangeId(BigDecimal sieveRangeId) {
        this.sieveRangeId = sieveRangeId;
    }

    public String getPercentret() {
        return percentret;
    }

    public void setPercentret(String percentret) {
        this.percentret = percentret;
    }

    public String getPercentret38() {
        return percentret38;
    }

    public void setPercentret38(String percentret38) {
        this.percentret38 = percentret38;
    }

    public String getTotalWtret() {
        return totalWtret;
    }

    public void setTotalWtret(String totalWtret) {
        this.totalWtret = totalWtret;
    }

    public String getFlatWtret() {
        return flatWtret;
    }

    public void setFlatWtret(String flatWtret) {
        this.flatWtret = flatWtret;
    }

    public String getFlatPercent() {
        return flatPercent;
    }

    public void setFlatPercent(String flatPercent) {
        this.flatPercent = flatPercent;
    }

    public String getElongWtret() {
        return elongWtret;
    }

    public void setElongWtret(String elongWtret) {
        this.elongWtret = elongWtret;
    }

    public String getElongPercent() {
        return elongPercent;
    }

    public void setElongPercent(String elongPercent) {
        this.elongPercent = elongPercent;
    }

    public String getNotfeWtret() {
        return notfeWtret;
    }

    public void setNotfeWtret(String notfeWtret) {
        this.notfeWtret = notfeWtret;
    }

    public String getNotfePercent() {
        return notfePercent;
    }

    public void setNotfePercent(String notfePercent) {
        this.notfePercent = notfePercent;
    }

    public String getFlatWtavgPercent() {
        return flatWtavgPercent;
    }

    public void setFlatWtavgPercent(String flatWtavgPercent) {
        this.flatWtavgPercent = flatWtavgPercent;
    }

    public String getElongWtavgPercent() {
        return elongWtavgPercent;
    }

    public void setElongWtavgPercent(String elongWtavgPercent) {
        this.elongWtavgPercent = elongWtavgPercent;
    }

    public String getFeWtavgPercent() {
        return feWtavgPercent;
    }

    public void setFeWtavgPercent(String feWtavgPercent) {
        this.feWtavgPercent = feWtavgPercent;
    }

    public String getTotalPercentSieve() {
        return totalPercentSieve;
    }

    public void setTotalPercentSieve(String totalPercentSieve) {
        this.totalPercentSieve = totalPercentSieve;
    }

    public String getTotalPercentWtavg() {
        return totalPercentWtavg;
    }

    public void setTotalPercentWtavg(String totalPercentWtavg) {
        this.totalPercentWtavg = totalPercentWtavg;
    }

    public BigDecimal getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigDecimal sieveId) {
        this.sieveId = sieveId;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
