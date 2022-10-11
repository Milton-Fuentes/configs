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
@Table(name = "DOT_SPG_T166", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSpgT166.findAll", query = "SELECT a FROM DotSpgT166 a")})
public class DotSpgT166 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "TRIAL_NO")
    private String trialNo;
    @Size(max = 50)
    @Column(name = "VFA")
    private String vfa;
    @Size(max = 50)
    @Column(name = "VOLUME")
    private String volume;
    @Size(max = 50)
    @Column(name = "ABSORPTION")
    private String absorption;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "CORRECTED_BSG")
    private String correctedBsg;
    @Size(max = 50)
    @Column(name = "PCT_REL_COMPACTION")
    private String pctRelCompaction;
    @Size(max = 50)
    @Column(name = "AIRVOIDS")
    private String airvoids;
    @Size(max = 50)
    @Column(name = "VMA")
    private String vma;
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
    @Size(max = 242)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 122)
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
    @Size(max = 100)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "MIX_DESIGNATION")
    private String mixDesignation;
    @Size(max = 50)
    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;
    @Size(max = 50)
    @Column(name = "THEOMAX")
    private String theomax;
    @Size(max = 50)
    @Column(name = "BULKSPECGRAV")
    private String bulkspecgrav;
    @Size(max = 50)
    @Column(name = "AGGPERCENTWT")
    private String aggpercentwt;
    @Size(max = 50)
    @Column(name = "AVG_CORRECTED")
    private String avgCorrected;
    @Size(max = 50)
    @Column(name = "AVG_CORRECTED_BSG")
    private String avgCorrectedBsg;
    @Size(max = 50)
    @Column(name = "AVG_PCT_REL_COMPACTION")
    private String avgPctRelCompaction;
    @Size(max = 50)
    @Column(name = "AVG_AIRVOIDS")
    private String avgAirvoids;
    @Size(max = 50)
    @Column(name = "AVG_VMA")
    private String avgVma;
    @Size(max = 100)
    @Column(name = "MATERIALDESC")
    private String materialdesc;
    @Size(max = 4000)
    @Column(name = "GRADE")
    private String grade;
    @Size(max = 22)
    @Column(name = "LOTTMAN")
    private String lottman;
    @Size(max = 22)
    @Column(name = "LOTTMAN_SPEC_MIN")
    private String lottmanSpecMin;
    @Size(max = 22)
    @Column(name = "HVEEM")
    private String hveem;
    @Size(max = 22)
    @Column(name = "HVEEM_SPEC_MIN")
    private String hveemSpecMin;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "SPLITNO")
    private String splitno;
    @Column(name = "SPLITSAMPLE")
    private Character splitsample;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Size(max = 50)
    @Column(name = "MASS_SAMPLE")
    private String massSample;
    @Size(max = 50)
    @Column(name = "MASS_SFCDRY")
    private String massSfcdry;
    @Size(max = 50)
    @Column(name = "MASS_SAMP_WATER")
    private String massSampWater;
    @Size(max = 50)
    @Column(name = "BULK_SPECGRAV")
    private String bulkSpecgrav;
    @Size(max = 50)
    @Column(name = "CORRECTION")
    private String correction;

    public DotSpgT166() {
    }

    public String getTrialNo() {
        return trialNo;
    }

    public void setTrialNo(String trialNo) {
        this.trialNo = trialNo;
    }

    public String getVfa() {
        return vfa;
    }

    public void setVfa(String vfa) {
        this.vfa = vfa;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getAbsorption() {
        return absorption;
    }

    public void setAbsorption(String absorption) {
        this.absorption = absorption;
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

    public String getCorrectedBsg() {
        return correctedBsg;
    }

    public void setCorrectedBsg(String correctedBsg) {
        this.correctedBsg = correctedBsg;
    }

    public String getPctRelCompaction() {
        return pctRelCompaction;
    }

    public void setPctRelCompaction(String pctRelCompaction) {
        this.pctRelCompaction = pctRelCompaction;
    }

    public String getAirvoids() {
        return airvoids;
    }

    public void setAirvoids(String airvoids) {
        this.airvoids = airvoids;
    }

    public String getVma() {
        return vma;
    }

    public void setVma(String vma) {
        this.vma = vma;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMixDesignation() {
        return mixDesignation;
    }

    public void setMixDesignation(String mixDesignation) {
        this.mixDesignation = mixDesignation;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getTheomax() {
        return theomax;
    }

    public void setTheomax(String theomax) {
        this.theomax = theomax;
    }

    public String getBulkspecgrav() {
        return bulkspecgrav;
    }

    public void setBulkspecgrav(String bulkspecgrav) {
        this.bulkspecgrav = bulkspecgrav;
    }

    public String getAggpercentwt() {
        return aggpercentwt;
    }

    public void setAggpercentwt(String aggpercentwt) {
        this.aggpercentwt = aggpercentwt;
    }

    public String getAvgCorrected() {
        return avgCorrected;
    }

    public void setAvgCorrected(String avgCorrected) {
        this.avgCorrected = avgCorrected;
    }

    public String getAvgCorrectedBsg() {
        return avgCorrectedBsg;
    }

    public void setAvgCorrectedBsg(String avgCorrectedBsg) {
        this.avgCorrectedBsg = avgCorrectedBsg;
    }

    public String getAvgPctRelCompaction() {
        return avgPctRelCompaction;
    }

    public void setAvgPctRelCompaction(String avgPctRelCompaction) {
        this.avgPctRelCompaction = avgPctRelCompaction;
    }

    public String getAvgAirvoids() {
        return avgAirvoids;
    }

    public void setAvgAirvoids(String avgAirvoids) {
        this.avgAirvoids = avgAirvoids;
    }

    public String getAvgVma() {
        return avgVma;
    }

    public void setAvgVma(String avgVma) {
        this.avgVma = avgVma;
    }

    public String getMaterialdesc() {
        return materialdesc;
    }

    public void setMaterialdesc(String materialdesc) {
        this.materialdesc = materialdesc;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getLottman() {
        return lottman;
    }

    public void setLottman(String lottman) {
        this.lottman = lottman;
    }

    public String getLottmanSpecMin() {
        return lottmanSpecMin;
    }

    public void setLottmanSpecMin(String lottmanSpecMin) {
        this.lottmanSpecMin = lottmanSpecMin;
    }

    public String getHveem() {
        return hveem;
    }

    public void setHveem(String hveem) {
        this.hveem = hveem;
    }

    public String getHveemSpecMin() {
        return hveemSpecMin;
    }

    public void setHveemSpecMin(String hveemSpecMin) {
        this.hveemSpecMin = hveemSpecMin;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getSplitno() {
        return splitno;
    }

    public void setSplitno(String splitno) {
        this.splitno = splitno;
    }

    public Character getSplitsample() {
        return splitsample;
    }

    public void setSplitsample(Character splitsample) {
        this.splitsample = splitsample;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public String getMassSample() {
        return massSample;
    }

    public void setMassSample(String massSample) {
        this.massSample = massSample;
    }

    public String getMassSfcdry() {
        return massSfcdry;
    }

    public void setMassSfcdry(String massSfcdry) {
        this.massSfcdry = massSfcdry;
    }

    public String getMassSampWater() {
        return massSampWater;
    }

    public void setMassSampWater(String massSampWater) {
        this.massSampWater = massSampWater;
    }

    public String getBulkSpecgrav() {
        return bulkSpecgrav;
    }

    public void setBulkSpecgrav(String bulkSpecgrav) {
        this.bulkSpecgrav = bulkSpecgrav;
    }

    public String getCorrection() {
        return correction;
    }

    public void setCorrection(String correction) {
        this.correction = correction;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
