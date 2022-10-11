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
@Table(name = "dot_dsr_t236", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotDsrT236.findAll", query = "SELECT a FROM DotDsrT236 a")})
public class DotDsrT236 implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Size(max = 362)
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
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_LL")
    private String waterContentLl;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_PL")
    private String waterContentPl;
    @Size(max = 50)
    @Column(name = "WATER_CONTENT_PI")
    private String waterContentPi;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "ANGLE_INTERNAL_FRICTION")
    private String angleInternalFriction;
    @Size(max = 50)
    @Column(name = "COHESION")
    private String cohesion;
    @Size(max = 50)
    @Column(name = "SHEAR_STRENGTH")
    private String shearStrength;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "BORING_NO")
    private String boringNo;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 50)
    @Column(name = "DATE_TEST")
    private String dateTest;
    @Size(max = 50)
    @Column(name = "SPECIMEN_TYPE")
    private String specimenType;
    @Size(max = 50)
    @Column(name = "PREP")
    private String prep;
    @Size(max = 50)
    @Column(name = "SPECIFIC_GRAVITY")
    private String specificGravity;
    @Size(max = 50)
    @Column(name = "USCS_CLASS")
    private String uscsClass;
    @Size(max = 50)
    @Column(name = "AASHTO_CLASS")
    private String aashtoClass;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_DIAMETER")
    private String beforeTestDiameter;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_HEIGHT")
    private String beforeTestHeight;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_WATER_CONTENT")
    private String beforeTestWaterContent;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_AREA")
    private String beforeTestArea;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOLUME")
    private String beforeTestVolume;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_WET_DENSITY")
    private String beforeTestWetDensity;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_DRY_DENSITY")
    private String beforeTestDryDensity;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOLUME_SOLIDS")
    private String beforeTestVolumeSolids;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_VOID_RATIO")
    private String beforeTestVoidRatio;
    @Size(max = 50)
    @Column(name = "BEFORE_TEST_SATURATION")
    private String beforeTestSaturation;
    @Size(max = 50)
    @Column(name = "CONSOLIDATION_NO_STAGES")
    private String consolidationNoStages;
    @Size(max = 50)
    @Column(name = "CONSOLIDATION_SETTLEMENT")
    private String consolidationSettlement;
    @Size(max = 50)
    @Column(name = "SHEAR_NO_STAGES")
    private String shearNoStages;
    @Size(max = 50)
    @Column(name = "SHEAR_AVG_NORMAL_STRESS")
    private String shearAvgNormalStress;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_SHEAR_STRESS")
    private String shearMaxShearStress;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_SHEAR_FORCE")
    private String shearMaxShearForce;
    @Size(max = 50)
    @Column(name = "SHEAR_MAX_DISPLACEMENT")
    private String shearMaxDisplacement;
    @Size(max = 50)
    @Column(name = "SHEAR_TRAVEL")
    private String shearTravel;
    @Size(max = 50)
    @Column(name = "SHEAR_AVG_RATE")
    private String shearAvgRate;
    @Size(max = 50)
    @Column(name = "SHEAR_HEIGHT_CHANGE")
    private String shearHeightChange;
    @Size(max = 50)
    @Column(name = "SHEAR_FINAL_HEIGHT")
    private String shearFinalHeight;
    @Size(max = 50)
    @Column(name = "SHEAR_FINAL_VOLUME")
    private String shearFinalVolume;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_WATER_CONTENT")
    private String afterTestWaterContent;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_DRY_DENSITY")
    private String afterTestDryDensity;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_WET_DENSITY")
    private String afterTestWetDensity;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_VOID_RATIO")
    private String afterTestVoidRatio;
    @Size(max = 50)
    @Column(name = "AFTER_TEST_SATURATION")
    private String afterTestSaturation;

    public DotDsrT236() {
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

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getWaterContentLl() {
        return waterContentLl;
    }

    public void setWaterContentLl(String waterContentLl) {
        this.waterContentLl = waterContentLl;
    }

    public String getWaterContentPl() {
        return waterContentPl;
    }

    public void setWaterContentPl(String waterContentPl) {
        this.waterContentPl = waterContentPl;
    }

    public String getWaterContentPi() {
        return waterContentPi;
    }

    public void setWaterContentPi(String waterContentPi) {
        this.waterContentPi = waterContentPi;
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

    public String getAngleInternalFriction() {
        return angleInternalFriction;
    }

    public void setAngleInternalFriction(String angleInternalFriction) {
        this.angleInternalFriction = angleInternalFriction;
    }

    public String getCohesion() {
        return cohesion;
    }

    public void setCohesion(String cohesion) {
        this.cohesion = cohesion;
    }

    public String getShearStrength() {
        return shearStrength;
    }

    public void setShearStrength(String shearStrength) {
        this.shearStrength = shearStrength;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getBoringNo() {
        return boringNo;
    }

    public void setBoringNo(String boringNo) {
        this.boringNo = boringNo;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateTest() {
        return dateTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public String getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getPrep() {
        return prep;
    }

    public void setPrep(String prep) {
        this.prep = prep;
    }

    public String getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(String specificGravity) {
        this.specificGravity = specificGravity;
    }

    public String getUscsClass() {
        return uscsClass;
    }

    public void setUscsClass(String uscsClass) {
        this.uscsClass = uscsClass;
    }

    public String getAashtoClass() {
        return aashtoClass;
    }

    public void setAashtoClass(String aashtoClass) {
        this.aashtoClass = aashtoClass;
    }

    public String getBeforeTestDiameter() {
        return beforeTestDiameter;
    }

    public void setBeforeTestDiameter(String beforeTestDiameter) {
        this.beforeTestDiameter = beforeTestDiameter;
    }

    public String getBeforeTestHeight() {
        return beforeTestHeight;
    }

    public void setBeforeTestHeight(String beforeTestHeight) {
        this.beforeTestHeight = beforeTestHeight;
    }

    public String getBeforeTestWaterContent() {
        return beforeTestWaterContent;
    }

    public void setBeforeTestWaterContent(String beforeTestWaterContent) {
        this.beforeTestWaterContent = beforeTestWaterContent;
    }

    public String getBeforeTestArea() {
        return beforeTestArea;
    }

    public void setBeforeTestArea(String beforeTestArea) {
        this.beforeTestArea = beforeTestArea;
    }

    public String getBeforeTestVolume() {
        return beforeTestVolume;
    }

    public void setBeforeTestVolume(String beforeTestVolume) {
        this.beforeTestVolume = beforeTestVolume;
    }

    public String getBeforeTestWetDensity() {
        return beforeTestWetDensity;
    }

    public void setBeforeTestWetDensity(String beforeTestWetDensity) {
        this.beforeTestWetDensity = beforeTestWetDensity;
    }

    public String getBeforeTestDryDensity() {
        return beforeTestDryDensity;
    }

    public void setBeforeTestDryDensity(String beforeTestDryDensity) {
        this.beforeTestDryDensity = beforeTestDryDensity;
    }

    public String getBeforeTestVolumeSolids() {
        return beforeTestVolumeSolids;
    }

    public void setBeforeTestVolumeSolids(String beforeTestVolumeSolids) {
        this.beforeTestVolumeSolids = beforeTestVolumeSolids;
    }

    public String getBeforeTestVoidRatio() {
        return beforeTestVoidRatio;
    }

    public void setBeforeTestVoidRatio(String beforeTestVoidRatio) {
        this.beforeTestVoidRatio = beforeTestVoidRatio;
    }

    public String getBeforeTestSaturation() {
        return beforeTestSaturation;
    }

    public void setBeforeTestSaturation(String beforeTestSaturation) {
        this.beforeTestSaturation = beforeTestSaturation;
    }

    public String getConsolidationNoStages() {
        return consolidationNoStages;
    }

    public void setConsolidationNoStages(String consolidationNoStages) {
        this.consolidationNoStages = consolidationNoStages;
    }

    public String getConsolidationSettlement() {
        return consolidationSettlement;
    }

    public void setConsolidationSettlement(String consolidationSettlement) {
        this.consolidationSettlement = consolidationSettlement;
    }

    public String getShearNoStages() {
        return shearNoStages;
    }

    public void setShearNoStages(String shearNoStages) {
        this.shearNoStages = shearNoStages;
    }

    public String getShearAvgNormalStress() {
        return shearAvgNormalStress;
    }

    public void setShearAvgNormalStress(String shearAvgNormalStress) {
        this.shearAvgNormalStress = shearAvgNormalStress;
    }

    public String getShearMaxShearStress() {
        return shearMaxShearStress;
    }

    public void setShearMaxShearStress(String shearMaxShearStress) {
        this.shearMaxShearStress = shearMaxShearStress;
    }

    public String getShearMaxShearForce() {
        return shearMaxShearForce;
    }

    public void setShearMaxShearForce(String shearMaxShearForce) {
        this.shearMaxShearForce = shearMaxShearForce;
    }

    public String getShearMaxDisplacement() {
        return shearMaxDisplacement;
    }

    public void setShearMaxDisplacement(String shearMaxDisplacement) {
        this.shearMaxDisplacement = shearMaxDisplacement;
    }

    public String getShearTravel() {
        return shearTravel;
    }

    public void setShearTravel(String shearTravel) {
        this.shearTravel = shearTravel;
    }

    public String getShearAvgRate() {
        return shearAvgRate;
    }

    public void setShearAvgRate(String shearAvgRate) {
        this.shearAvgRate = shearAvgRate;
    }

    public String getShearHeightChange() {
        return shearHeightChange;
    }

    public void setShearHeightChange(String shearHeightChange) {
        this.shearHeightChange = shearHeightChange;
    }

    public String getShearFinalHeight() {
        return shearFinalHeight;
    }

    public void setShearFinalHeight(String shearFinalHeight) {
        this.shearFinalHeight = shearFinalHeight;
    }

    public String getShearFinalVolume() {
        return shearFinalVolume;
    }

    public void setShearFinalVolume(String shearFinalVolume) {
        this.shearFinalVolume = shearFinalVolume;
    }

    public String getAfterTestWaterContent() {
        return afterTestWaterContent;
    }

    public void setAfterTestWaterContent(String afterTestWaterContent) {
        this.afterTestWaterContent = afterTestWaterContent;
    }

    public String getAfterTestDryDensity() {
        return afterTestDryDensity;
    }

    public void setAfterTestDryDensity(String afterTestDryDensity) {
        this.afterTestDryDensity = afterTestDryDensity;
    }

    public String getAfterTestWetDensity() {
        return afterTestWetDensity;
    }

    public void setAfterTestWetDensity(String afterTestWetDensity) {
        this.afterTestWetDensity = afterTestWetDensity;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getAfterTestVoidRatio() {
        return afterTestVoidRatio;
    }

    public void setAfterTestVoidRatio(String afterTestVoidRatio) {
        this.afterTestVoidRatio = afterTestVoidRatio;
    }

    public String getAfterTestSaturation() {
        return afterTestSaturation;
    }

    public void setAfterTestSaturation(String afterTestSaturation) {
        this.afterTestSaturation = afterTestSaturation;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
