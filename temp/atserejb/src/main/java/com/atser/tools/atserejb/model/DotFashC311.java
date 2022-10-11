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
@Table(name = "dot_fash_c311", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotFashC311.findAll", query = "SELECT a FROM DotFashC311 a")})
public class DotFashC311 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "CONTROL_CEMENT_RANGE_BETWEEN")
    private String controlCementRangeBetween;
    @Size(max = 50)
    @Column(name = "CONTROL_CEMENT_RANGE_SPEC")
    private String controlCementRangeSpec;
    @Size(max = 50)
    @Column(name = "CONTROL_CEMENT_RETEST_REQUIRED")
    private String controlCementRetestRequired;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "FLY_ASH_RANGE_BETWEEN")
    private String flyAshRangeBetween;
    @Size(max = 50)
    @Column(name = "FLY_ASH_RANGE_SPEC")
    private String flyAshRangeSpec;
    @Size(max = 50)
    @Column(name = "FLY_ASH_RETEST_REQUIRED")
    private String flyAshRetestRequired;
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
    @Size(max = 303)
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
    @Size(max = 50)
    @Column(name = "SAMPLESPERSET")
    private String samplesperset;
    @Size(max = 10)
    @Column(name = "AVGDAYS")
    private String avgdays;
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
    @Size(max = 50)
    @Column(name = "CCM_MASS_CEMENT")
    private String ccmMassCement;
    @Size(max = 50)
    @Column(name = "CCM_MASS_STANDARD_SAND")
    private String ccmMassStandardSand;
    @Size(max = 50)
    @Column(name = "CCM_VOLUME_WATER")
    private String ccmVolumeWater;
    @Size(max = 50)
    @Column(name = "CCM_INCREASE_DIAMETER_1")
    private String ccmIncreaseDiameter1;
    @Size(max = 50)
    @Column(name = "CCM_INCREASE_DIAMETER_2")
    private String ccmIncreaseDiameter2;
    @Size(max = 50)
    @Column(name = "CCM_INCREASE_DIAMETER_3")
    private String ccmIncreaseDiameter3;
    @Size(max = 50)
    @Column(name = "CCM_INCREASE_DIAMETER_4")
    private String ccmIncreaseDiameter4;
    @Size(max = 50)
    @Column(name = "CCM_FLOW_CEMENT_25_BLOWS")
    private String ccmFlowCement25Blows;
    @Size(max = 50)
    @Column(name = "VOL_MASS_CEMENT")
    private String volMassCement;
    @Size(max = 50)
    @Column(name = "VOL_MASS_FLY_ASH")
    private String volMassFlyAsh;
    @Size(max = 50)
    @Column(name = "VOL_MASS_STANDARD_SAND")
    private String volMassStandardSand;
    @Size(max = 50)
    @Column(name = "VOL_VOLUME_WATER_REQUIRED")
    private String volVolumeWaterRequired;
    @Size(max = 50)
    @Column(name = "VOL_VOLUME_WATER_PCT")
    private String volVolumeWaterPct;
    @Size(max = 50)
    @Column(name = "VOL_INCREASE_DIAMETER_1")
    private String volIncreaseDiameter1;
    @Size(max = 50)
    @Column(name = "VOL_INCREASE_DIAMETER_2")
    private String volIncreaseDiameter2;
    @Size(max = 50)
    @Column(name = "VOL_INCREASE_DIAMETER_3")
    private String volIncreaseDiameter3;
    @Size(max = 50)
    @Column(name = "VOL_INCREASE_DIAMETER_4")
    private String volIncreaseDiameter4;
    @Size(max = 50)
    @Column(name = "VOL_FLOW_FLY_ASH_CEMENT")
    private String volFlowFlyAshCement;
    @Size(max = 50)
    @Column(name = "VOL_SPEC")
    private String volSpec;
    @Size(max = 50)
    @Column(name = "VOL_RETEST_REQUIRED")
    private String volRetestRequired;
    @Size(max = 50)
    @Column(name = "AI_FLY_ASH_AVERAGE")
    private String aiFlyAshAverage;
    @Size(max = 50)
    @Column(name = "AI_CONTROL_CEMENT_AVERAGE")
    private String aiControlCementAverage;
    @Size(max = 50)
    @Column(name = "AI_STRENGTH_ACTIVITY_INDEX")
    private String aiStrengthActivityIndex;
    @Size(max = 50)
    @Column(name = "AI_SPEC_MIN")
    private String aiSpecMin;
    @Size(max = 50)
    @Column(name = "AI_RESULT")
    private String aiResult;
    @Size(max = 50)
    @Column(name = "MC_MASS_FLY_ASH_AS_RECEIVED")
    private String mcMassFlyAshAsReceived;
    @Size(max = 50)
    @Column(name = "MC_MASS_DRIED_FLY_ASH")
    private String mcMassDriedFlyAsh;
    @Size(max = 50)
    @Column(name = "MC_MOISTURE_CONTENT")
    private String mcMoistureContent;
    @Size(max = 50)
    @Column(name = "MC_SPEC_MAX")
    private String mcSpecMax;
    @Size(max = 50)
    @Column(name = "MC_RESULT")
    private String mcResult;
    @Size(max = 50)
    @Column(name = "IGN_MASS_DRIED_FLY_ASH")
    private String ignMassDriedFlyAsh;
    @Size(max = 50)
    @Column(name = "IGN_MASS_IGNITED_FLY_ASH")
    private String ignMassIgnitedFlyAsh;
    @Size(max = 50)
    @Column(name = "IGN_LOSS_ON_IGNITION")
    private String ignLossOnIgnition;
    @Size(max = 50)
    @Column(name = "IGN_SPEC_MAX")
    private String ignSpecMax;
    @Size(max = 50)
    @Column(name = "IGN_RESULT")
    private String ignResult;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;

    public DotFashC311() {
    }

    public String getControlCementRangeBetween() {
        return controlCementRangeBetween;
    }

    public void setControlCementRangeBetween(String controlCementRangeBetween) {
        this.controlCementRangeBetween = controlCementRangeBetween;
    }

    public String getControlCementRangeSpec() {
        return controlCementRangeSpec;
    }

    public void setControlCementRangeSpec(String controlCementRangeSpec) {
        this.controlCementRangeSpec = controlCementRangeSpec;
    }

    public String getControlCementRetestRequired() {
        return controlCementRetestRequired;
    }

    public void setControlCementRetestRequired(String controlCementRetestRequired) {
        this.controlCementRetestRequired = controlCementRetestRequired;
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

    public String getFlyAshRangeBetween() {
        return flyAshRangeBetween;
    }

    public void setFlyAshRangeBetween(String flyAshRangeBetween) {
        this.flyAshRangeBetween = flyAshRangeBetween;
    }

    public String getFlyAshRangeSpec() {
        return flyAshRangeSpec;
    }

    public void setFlyAshRangeSpec(String flyAshRangeSpec) {
        this.flyAshRangeSpec = flyAshRangeSpec;
    }

    public String getFlyAshRetestRequired() {
        return flyAshRetestRequired;
    }

    public void setFlyAshRetestRequired(String flyAshRetestRequired) {
        this.flyAshRetestRequired = flyAshRetestRequired;
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

    public String getCcmMassCement() {
        return ccmMassCement;
    }

    public void setCcmMassCement(String ccmMassCement) {
        this.ccmMassCement = ccmMassCement;
    }

    public String getCcmMassStandardSand() {
        return ccmMassStandardSand;
    }

    public void setCcmMassStandardSand(String ccmMassStandardSand) {
        this.ccmMassStandardSand = ccmMassStandardSand;
    }

    public String getCcmVolumeWater() {
        return ccmVolumeWater;
    }

    public void setCcmVolumeWater(String ccmVolumeWater) {
        this.ccmVolumeWater = ccmVolumeWater;
    }

    public String getCcmIncreaseDiameter1() {
        return ccmIncreaseDiameter1;
    }

    public void setCcmIncreaseDiameter1(String ccmIncreaseDiameter1) {
        this.ccmIncreaseDiameter1 = ccmIncreaseDiameter1;
    }

    public String getCcmIncreaseDiameter2() {
        return ccmIncreaseDiameter2;
    }

    public void setCcmIncreaseDiameter2(String ccmIncreaseDiameter2) {
        this.ccmIncreaseDiameter2 = ccmIncreaseDiameter2;
    }

    public String getCcmIncreaseDiameter3() {
        return ccmIncreaseDiameter3;
    }

    public void setCcmIncreaseDiameter3(String ccmIncreaseDiameter3) {
        this.ccmIncreaseDiameter3 = ccmIncreaseDiameter3;
    }

    public String getCcmIncreaseDiameter4() {
        return ccmIncreaseDiameter4;
    }

    public void setCcmIncreaseDiameter4(String ccmIncreaseDiameter4) {
        this.ccmIncreaseDiameter4 = ccmIncreaseDiameter4;
    }

    public String getCcmFlowCement25Blows() {
        return ccmFlowCement25Blows;
    }

    public void setCcmFlowCement25Blows(String ccmFlowCement25Blows) {
        this.ccmFlowCement25Blows = ccmFlowCement25Blows;
    }

    public String getVolMassCement() {
        return volMassCement;
    }

    public void setVolMassCement(String volMassCement) {
        this.volMassCement = volMassCement;
    }

    public String getVolMassFlyAsh() {
        return volMassFlyAsh;
    }

    public void setVolMassFlyAsh(String volMassFlyAsh) {
        this.volMassFlyAsh = volMassFlyAsh;
    }

    public String getVolMassStandardSand() {
        return volMassStandardSand;
    }

    public void setVolMassStandardSand(String volMassStandardSand) {
        this.volMassStandardSand = volMassStandardSand;
    }

    public String getVolVolumeWaterRequired() {
        return volVolumeWaterRequired;
    }

    public void setVolVolumeWaterRequired(String volVolumeWaterRequired) {
        this.volVolumeWaterRequired = volVolumeWaterRequired;
    }

    public String getVolVolumeWaterPct() {
        return volVolumeWaterPct;
    }

    public void setVolVolumeWaterPct(String volVolumeWaterPct) {
        this.volVolumeWaterPct = volVolumeWaterPct;
    }

    public String getVolIncreaseDiameter1() {
        return volIncreaseDiameter1;
    }

    public void setVolIncreaseDiameter1(String volIncreaseDiameter1) {
        this.volIncreaseDiameter1 = volIncreaseDiameter1;
    }

    public String getVolIncreaseDiameter2() {
        return volIncreaseDiameter2;
    }

    public void setVolIncreaseDiameter2(String volIncreaseDiameter2) {
        this.volIncreaseDiameter2 = volIncreaseDiameter2;
    }

    public String getVolIncreaseDiameter3() {
        return volIncreaseDiameter3;
    }

    public void setVolIncreaseDiameter3(String volIncreaseDiameter3) {
        this.volIncreaseDiameter3 = volIncreaseDiameter3;
    }

    public String getVolIncreaseDiameter4() {
        return volIncreaseDiameter4;
    }

    public void setVolIncreaseDiameter4(String volIncreaseDiameter4) {
        this.volIncreaseDiameter4 = volIncreaseDiameter4;
    }

    public String getVolFlowFlyAshCement() {
        return volFlowFlyAshCement;
    }

    public void setVolFlowFlyAshCement(String volFlowFlyAshCement) {
        this.volFlowFlyAshCement = volFlowFlyAshCement;
    }

    public String getVolSpec() {
        return volSpec;
    }

    public void setVolSpec(String volSpec) {
        this.volSpec = volSpec;
    }

    public String getVolRetestRequired() {
        return volRetestRequired;
    }

    public void setVolRetestRequired(String volRetestRequired) {
        this.volRetestRequired = volRetestRequired;
    }

    public String getAiFlyAshAverage() {
        return aiFlyAshAverage;
    }

    public void setAiFlyAshAverage(String aiFlyAshAverage) {
        this.aiFlyAshAverage = aiFlyAshAverage;
    }

    public String getAiControlCementAverage() {
        return aiControlCementAverage;
    }

    public void setAiControlCementAverage(String aiControlCementAverage) {
        this.aiControlCementAverage = aiControlCementAverage;
    }

    public String getAiStrengthActivityIndex() {
        return aiStrengthActivityIndex;
    }

    public void setAiStrengthActivityIndex(String aiStrengthActivityIndex) {
        this.aiStrengthActivityIndex = aiStrengthActivityIndex;
    }

    public String getAiSpecMin() {
        return aiSpecMin;
    }

    public void setAiSpecMin(String aiSpecMin) {
        this.aiSpecMin = aiSpecMin;
    }

    public String getAiResult() {
        return aiResult;
    }

    public void setAiResult(String aiResult) {
        this.aiResult = aiResult;
    }

    public String getMcMassFlyAshAsReceived() {
        return mcMassFlyAshAsReceived;
    }

    public void setMcMassFlyAshAsReceived(String mcMassFlyAshAsReceived) {
        this.mcMassFlyAshAsReceived = mcMassFlyAshAsReceived;
    }

    public String getMcMassDriedFlyAsh() {
        return mcMassDriedFlyAsh;
    }

    public void setMcMassDriedFlyAsh(String mcMassDriedFlyAsh) {
        this.mcMassDriedFlyAsh = mcMassDriedFlyAsh;
    }

    public String getMcMoistureContent() {
        return mcMoistureContent;
    }

    public void setMcMoistureContent(String mcMoistureContent) {
        this.mcMoistureContent = mcMoistureContent;
    }

    public String getMcSpecMax() {
        return mcSpecMax;
    }

    public void setMcSpecMax(String mcSpecMax) {
        this.mcSpecMax = mcSpecMax;
    }

    public String getMcResult() {
        return mcResult;
    }

    public void setMcResult(String mcResult) {
        this.mcResult = mcResult;
    }

    public String getIgnMassDriedFlyAsh() {
        return ignMassDriedFlyAsh;
    }

    public void setIgnMassDriedFlyAsh(String ignMassDriedFlyAsh) {
        this.ignMassDriedFlyAsh = ignMassDriedFlyAsh;
    }

    public String getIgnMassIgnitedFlyAsh() {
        return ignMassIgnitedFlyAsh;
    }

    public void setIgnMassIgnitedFlyAsh(String ignMassIgnitedFlyAsh) {
        this.ignMassIgnitedFlyAsh = ignMassIgnitedFlyAsh;
    }

    public String getIgnLossOnIgnition() {
        return ignLossOnIgnition;
    }

    public void setIgnLossOnIgnition(String ignLossOnIgnition) {
        this.ignLossOnIgnition = ignLossOnIgnition;
    }

    public String getIgnSpecMax() {
        return ignSpecMax;
    }

    public void setIgnSpecMax(String ignSpecMax) {
        this.ignSpecMax = ignSpecMax;
    }

    public String getIgnResult() {
        return ignResult;
    }

    public void setIgnResult(String ignResult) {
        this.ignResult = ignResult;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
