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
@Table(name = "DOT_WP_FM5", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotWpFm5.findAll", query = "SELECT a FROM DotWpFm5 a")})
public class DotWpFm5 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "TEMPERATURE_WATER_WHOLE")
    private String temperatureWaterWhole;
    @Size(max = 50)
    @Column(name = "TEMPERATURE_WATER_REMAIN")
    private String temperatureWaterRemain;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Size(max = 323)
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
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "HEIGHT_TOP_UPPER_TIMING_MARK")
    private String heightTopUpperTimingMark;
    @Size(max = 50)
    @Column(name = "HEIGHT_TOP_LOWER_TIMING_MARK")
    private String heightTopLowerTimingMark;
    @Size(max = 50)
    @Column(name = "INSIDE_DIAMETER_GRAD_CYL1")
    private String insideDiameterGradCyl1;
    @Size(max = 50)
    @Column(name = "INSIDE_DIAMETER_GRAD_CYL2")
    private String insideDiameterGradCyl2;
    @Size(max = 50)
    @Column(name = "INSIDE_AREA_GRAD_CYL")
    private String insideAreaGradCyl;
    @Size(max = 50)
    @Column(name = "HEIGHT_TEST_SPECIMEN1")
    private String heightTestSpecimen1;
    @Size(max = 50)
    @Column(name = "HEIGHT_TEST_SPECIMEN2")
    private String heightTestSpecimen2;
    @Size(max = 50)
    @Column(name = "HEIGHT_TEST_SPECIMEN3")
    private String heightTestSpecimen3;
    @Size(max = 50)
    @Column(name = "DIFF_HEIGHT_MEASUREMENTS")
    private String diffHeightMeasurements;
    @Size(max = 50)
    @Column(name = "AVG_THICKNESS_TEST_SPECIMEN")
    private String avgThicknessTestSpecimen;
    @Size(max = 50)
    @Column(name = "DIAMETER_TEST_SPECIMEN1")
    private String diameterTestSpecimen1;
    @Size(max = 50)
    @Column(name = "DIAMETER_TEST_SPECIMEN2")
    private String diameterTestSpecimen2;
    @Size(max = 50)
    @Column(name = "AVG_AREA_TEST_SPECIMEN")
    private String avgAreaTestSpecimen;
    @Size(max = 50)
    @Column(name = "INITIAL_HEAD_ACROSS_SPECIMEN")
    private String initialHeadAcrossSpecimen;
    @Size(max = 50)
    @Column(name = "FINAL_HEAD_ACROSS_SPECIMEN")
    private String finalHeadAcrossSpecimen;
    @Size(max = 50)
    @Column(name = "ELAPSED_TIME1")
    private String elapsedTime1;
    @Size(max = 50)
    @Column(name = "ELAPSED_TIME2")
    private String elapsedTime2;
    @Size(max = 50)
    @Column(name = "ELAPSED_TIME3")
    private String elapsedTime3;
    @Size(max = 50)
    @Column(name = "DIFF_BETWEEN_RUN_1_AND_3")
    private String diffBetweenRun1And3;
    @Size(max = 50)
    @Column(name = "TEMPERATURE_WATER")
    private String temperatureWater;
    @Size(max = 50)
    @Column(name = "TEMP_CORR_VISCOCITY_WATER")
    private String tempCorrViscocityWater;
    @Size(max = 50)
    @Column(name = "COEFFICIENT_PERMEABILITY1")
    private String coefficientPermeability1;
    @Size(max = 50)
    @Column(name = "COEFFICIENT_PERMEABILITY2")
    private String coefficientPermeability2;
    @Size(max = 50)
    @Column(name = "COEFFICIENT_PERMEABILITY3")
    private String coefficientPermeability3;
    @Size(max = 50)
    @Column(name = "AVG_COEFFICIENT_PERMEABILITY")
    private String avgCoefficientPermeability;
    @Size(max = 50)
    @Column(name = "SPECIFICATION")
    private String specification;
    @Size(max = 50)
    @Column(name = "PERMEABILITY_REQUIREMENT")
    private String permeabilityRequirement;
    @Size(max = 50)
    @Column(name = "RESULT")
    private String result;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
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

    public DotWpFm5() {
    }

    public String getTemperatureWaterWhole() {
        return temperatureWaterWhole;
    }

    public void setTemperatureWaterWhole(String temperatureWaterWhole) {
        this.temperatureWaterWhole = temperatureWaterWhole;
    }

    public String getTemperatureWaterRemain() {
        return temperatureWaterRemain;
    }

    public void setTemperatureWaterRemain(String temperatureWaterRemain) {
        this.temperatureWaterRemain = temperatureWaterRemain;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getHeightTopUpperTimingMark() {
        return heightTopUpperTimingMark;
    }

    public void setHeightTopUpperTimingMark(String heightTopUpperTimingMark) {
        this.heightTopUpperTimingMark = heightTopUpperTimingMark;
    }

    public String getHeightTopLowerTimingMark() {
        return heightTopLowerTimingMark;
    }

    public void setHeightTopLowerTimingMark(String heightTopLowerTimingMark) {
        this.heightTopLowerTimingMark = heightTopLowerTimingMark;
    }

    public String getInsideDiameterGradCyl1() {
        return insideDiameterGradCyl1;
    }

    public void setInsideDiameterGradCyl1(String insideDiameterGradCyl1) {
        this.insideDiameterGradCyl1 = insideDiameterGradCyl1;
    }

    public String getInsideDiameterGradCyl2() {
        return insideDiameterGradCyl2;
    }

    public void setInsideDiameterGradCyl2(String insideDiameterGradCyl2) {
        this.insideDiameterGradCyl2 = insideDiameterGradCyl2;
    }

    public String getInsideAreaGradCyl() {
        return insideAreaGradCyl;
    }

    public void setInsideAreaGradCyl(String insideAreaGradCyl) {
        this.insideAreaGradCyl = insideAreaGradCyl;
    }

    public String getHeightTestSpecimen1() {
        return heightTestSpecimen1;
    }

    public void setHeightTestSpecimen1(String heightTestSpecimen1) {
        this.heightTestSpecimen1 = heightTestSpecimen1;
    }

    public String getHeightTestSpecimen2() {
        return heightTestSpecimen2;
    }

    public void setHeightTestSpecimen2(String heightTestSpecimen2) {
        this.heightTestSpecimen2 = heightTestSpecimen2;
    }

    public String getHeightTestSpecimen3() {
        return heightTestSpecimen3;
    }

    public void setHeightTestSpecimen3(String heightTestSpecimen3) {
        this.heightTestSpecimen3 = heightTestSpecimen3;
    }

    public String getDiffHeightMeasurements() {
        return diffHeightMeasurements;
    }

    public void setDiffHeightMeasurements(String diffHeightMeasurements) {
        this.diffHeightMeasurements = diffHeightMeasurements;
    }

    public String getAvgThicknessTestSpecimen() {
        return avgThicknessTestSpecimen;
    }

    public void setAvgThicknessTestSpecimen(String avgThicknessTestSpecimen) {
        this.avgThicknessTestSpecimen = avgThicknessTestSpecimen;
    }

    public String getDiameterTestSpecimen1() {
        return diameterTestSpecimen1;
    }

    public void setDiameterTestSpecimen1(String diameterTestSpecimen1) {
        this.diameterTestSpecimen1 = diameterTestSpecimen1;
    }

    public String getDiameterTestSpecimen2() {
        return diameterTestSpecimen2;
    }

    public void setDiameterTestSpecimen2(String diameterTestSpecimen2) {
        this.diameterTestSpecimen2 = diameterTestSpecimen2;
    }

    public String getAvgAreaTestSpecimen() {
        return avgAreaTestSpecimen;
    }

    public void setAvgAreaTestSpecimen(String avgAreaTestSpecimen) {
        this.avgAreaTestSpecimen = avgAreaTestSpecimen;
    }

    public String getInitialHeadAcrossSpecimen() {
        return initialHeadAcrossSpecimen;
    }

    public void setInitialHeadAcrossSpecimen(String initialHeadAcrossSpecimen) {
        this.initialHeadAcrossSpecimen = initialHeadAcrossSpecimen;
    }

    public String getFinalHeadAcrossSpecimen() {
        return finalHeadAcrossSpecimen;
    }

    public void setFinalHeadAcrossSpecimen(String finalHeadAcrossSpecimen) {
        this.finalHeadAcrossSpecimen = finalHeadAcrossSpecimen;
    }

    public String getElapsedTime1() {
        return elapsedTime1;
    }

    public void setElapsedTime1(String elapsedTime1) {
        this.elapsedTime1 = elapsedTime1;
    }

    public String getElapsedTime2() {
        return elapsedTime2;
    }

    public void setElapsedTime2(String elapsedTime2) {
        this.elapsedTime2 = elapsedTime2;
    }

    public String getElapsedTime3() {
        return elapsedTime3;
    }

    public void setElapsedTime3(String elapsedTime3) {
        this.elapsedTime3 = elapsedTime3;
    }

    public String getDiffBetweenRun1And3() {
        return diffBetweenRun1And3;
    }

    public void setDiffBetweenRun1And3(String diffBetweenRun1And3) {
        this.diffBetweenRun1And3 = diffBetweenRun1And3;
    }

    public String getTemperatureWater() {
        return temperatureWater;
    }

    public void setTemperatureWater(String temperatureWater) {
        this.temperatureWater = temperatureWater;
    }

    public String getTempCorrViscocityWater() {
        return tempCorrViscocityWater;
    }

    public void setTempCorrViscocityWater(String tempCorrViscocityWater) {
        this.tempCorrViscocityWater = tempCorrViscocityWater;
    }

    public String getCoefficientPermeability1() {
        return coefficientPermeability1;
    }

    public void setCoefficientPermeability1(String coefficientPermeability1) {
        this.coefficientPermeability1 = coefficientPermeability1;
    }

    public String getCoefficientPermeability2() {
        return coefficientPermeability2;
    }

    public void setCoefficientPermeability2(String coefficientPermeability2) {
        this.coefficientPermeability2 = coefficientPermeability2;
    }

    public String getCoefficientPermeability3() {
        return coefficientPermeability3;
    }

    public void setCoefficientPermeability3(String coefficientPermeability3) {
        this.coefficientPermeability3 = coefficientPermeability3;
    }

    public String getAvgCoefficientPermeability() {
        return avgCoefficientPermeability;
    }

    public void setAvgCoefficientPermeability(String avgCoefficientPermeability) {
        this.avgCoefficientPermeability = avgCoefficientPermeability;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getPermeabilityRequirement() {
        return permeabilityRequirement;
    }

    public void setPermeabilityRequirement(String permeabilityRequirement) {
        this.permeabilityRequirement = permeabilityRequirement;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
