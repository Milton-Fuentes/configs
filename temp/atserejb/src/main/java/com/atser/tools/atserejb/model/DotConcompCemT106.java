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
@Table(name = "dot_concomp_cem_t106", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotConcompCemT106.findAll", query = "SELECT a FROM DotConcompCemT106 a")})
public class DotConcompCemT106 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "RETEST_REQUIRED")
    private String retestRequired;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "AVERAGE")
    private String average;
    @Column(name = "LOT_NO")
    private BigDecimal lotNo;
    @Column(name = "SUBLOT_NO")
    private BigDecimal sublotNo;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "TESTPLAN_ID")
    private BigInteger testplanId;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "MASS_CEMENT")
    private String massCement;
    @Size(max = 50)
    @Column(name = "MASS_STANDARD_SAND")
    private String massStandardSand;
    @Size(max = 50)
    @Column(name = "VOLUME_WATER")
    private String volumeWater;
    @Size(max = 50)
    @Column(name = "SAMPLEIDNO")
    private String sampleidno;
    @Size(max = 50)
    @Column(name = "CYLINDER_NO")
    private String cylinderNo;
    @Size(max = 50)
    @Column(name = "TESTAGE")
    private String testage;
    @Column(name = "DATETEST")
    private Date datetest;
    @Size(max = 50)
    @Column(name = "LENGTH")
    private String length;
    @Size(max = 50)
    @Column(name = "WIDTH")
    private String width;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "MAXIMUMLOAD")
    private String maximumload;
    @Size(max = 50)
    @Column(name = "REQUIREDSTRENGTH")
    private String requiredstrength;
    @Size(max = 50)
    @Column(name = "COMPRESS_STRENGTH")
    private String compressStrength;
    @Size(max = 50)
    @Column(name = "TECH")
    private String tech;
    @Size(max = 50)
    @Column(name = "AREA")
    private String area;
    @Column(name = "DISCARD")
    private Character discard;
    @Size(max = 50)
    @Column(name = "RESULT_TESTAGE")
    private String resultTestage;
    @Size(max = 50)
    @Column(name = "RESULT_SPEC_MIN")
    private String resultSpecMin;
    @Size(max = 50)
    @Column(name = "RESULT_SPEC_MAX")
    private String resultSpecMax;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "REPORT_STAMP_TYPE")
    private String reportStampType;
    @Size(max = 50)
    @Column(name = "RESULT_AVERAGE")
    private String resultAverage;
    @Size(max = 50)
    @Column(name = "RANGE_BETWEEN")
    private String rangeBetween;
    @Size(max = 50)
    @Column(name = "RANGE_SPEC")
    private String rangeSpec;
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
    @Column(name = "MIXDESIGNNO")
    private Character mixdesignno;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 243)
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
    @Size(max = 255)
    @Column(name = "DRAFT")
    private String draft;
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
    @Size(max = 50)
    @Column(name = "SAMPLESPERSET")
    private String samplesperset;
    @Size(max = 10)
    @Column(name = "AVGDAYS")
    private String avgdays;

    public DotConcompCemT106() {
    }

    public String getRetestRequired() {
        return retestRequired;
    }

    public void setRetestRequired(String retestRequired) {
        this.retestRequired = retestRequired;
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

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public BigDecimal getLotNo() {
        return lotNo;
    }

    public void setLotNo(BigDecimal lotNo) {
        this.lotNo = lotNo;
    }

    public BigDecimal getSublotNo() {
        return sublotNo;
    }

    public void setSublotNo(BigDecimal sublotNo) {
        this.sublotNo = sublotNo;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getTestplanId() {
        return testplanId;
    }

    public void setTestplanId(BigInteger testplanId) {
        this.testplanId = testplanId;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getMassCement() {
        return massCement;
    }

    public void setMassCement(String massCement) {
        this.massCement = massCement;
    }

    public String getMassStandardSand() {
        return massStandardSand;
    }

    public void setMassStandardSand(String massStandardSand) {
        this.massStandardSand = massStandardSand;
    }

    public String getVolumeWater() {
        return volumeWater;
    }

    public void setVolumeWater(String volumeWater) {
        this.volumeWater = volumeWater;
    }

    public String getSampleidno() {
        return sampleidno;
    }

    public void setSampleidno(String sampleidno) {
        this.sampleidno = sampleidno;
    }

    public String getCylinderNo() {
        return cylinderNo;
    }

    public void setCylinderNo(String cylinderNo) {
        this.cylinderNo = cylinderNo;
    }

    public String getTestage() {
        return testage;
    }

    public void setTestage(String testage) {
        this.testage = testage;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDatetest() {
        return datetest;
    }

    public void setDatetest(Date datetest) {
        this.datetest = datetest;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getMaximumload() {
        return maximumload;
    }

    public void setMaximumload(String maximumload) {
        this.maximumload = maximumload;
    }

    public String getRequiredstrength() {
        return requiredstrength;
    }

    public void setRequiredstrength(String requiredstrength) {
        this.requiredstrength = requiredstrength;
    }

    public String getCompressStrength() {
        return compressStrength;
    }

    public void setCompressStrength(String compressStrength) {
        this.compressStrength = compressStrength;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Character getDiscard() {
        return discard;
    }

    public void setDiscard(Character discard) {
        this.discard = discard;
    }

    public String getResultTestage() {
        return resultTestage;
    }

    public void setResultTestage(String resultTestage) {
        this.resultTestage = resultTestage;
    }

    public String getResultSpecMin() {
        return resultSpecMin;
    }

    public void setResultSpecMin(String resultSpecMin) {
        this.resultSpecMin = resultSpecMin;
    }

    public String getResultSpecMax() {
        return resultSpecMax;
    }

    public void setResultSpecMax(String resultSpecMax) {
        this.resultSpecMax = resultSpecMax;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getReportStampType() {
        return reportStampType;
    }

    public void setReportStampType(String reportStampType) {
        this.reportStampType = reportStampType;
    }

    public String getResultAverage() {
        return resultAverage;
    }

    public void setResultAverage(String resultAverage) {
        this.resultAverage = resultAverage;
    }

    public String getRangeBetween() {
        return rangeBetween;
    }

    public void setRangeBetween(String rangeBetween) {
        this.rangeBetween = rangeBetween;
    }

    public String getRangeSpec() {
        return rangeSpec;
    }

    public void setRangeSpec(String rangeSpec) {
        this.rangeSpec = rangeSpec;
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

    public Character getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(Character mixdesignno) {
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

    public String getDraft() {
        return draft;
    }

    public void setDraft(String draft) {
        this.draft = draft;
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

    public String getSamplesperset() {
        return samplesperset;
    }

    public void setSamplesperset(String samplesperset) {
        this.samplesperset = samplesperset;
    }

    public String getAvgdays() {
        return avgdays;
    }

    public void setAvgdays(String avgdays) {
        this.avgdays = avgdays;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
