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
@Table(name = "dot_dnx_t210", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotDnxT210.findAll", query = "SELECT a FROM DotDnxT210 a")})
public class DotDnxT210 implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Size(max = 319)
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
    @Size(max = 50)
    @Column(name = "TEST_PROCEDURE_USED")
    private String testProcedureUsed;
    @Size(max = 50)
    @Column(name = "PROCEDURE_OPTION")
    private String procedureOption;
    @Size(max = 50)
    @Column(name = "AIR_DRIED_WEIGHT_34_TO_12")
    private String airDriedWeight34To12;
    @Size(max = 50)
    @Column(name = "AIR_DRIED_WEIGHT_12_TO_38")
    private String airDriedWeight12To38;
    @Size(max = 50)
    @Column(name = "AIR_DRIED_WEIGHT_38_TO_NO_4")
    private String airDriedWeight38ToNo4;
    @Size(max = 50)
    @Column(name = "TOTAL_AIR_DRIED_WEIGHT")
    private String totalAirDriedWeight;
    @Size(max = 50)
    @Column(name = "HEIGHT_SEDIMENT")
    private String heightSediment;
    @Size(max = 50)
    @Column(name = "DURABILITY_INDEX")
    private String durabilityIndex;
    @Column(name = "QUANTITY")
    private BigInteger quantity;
    @Size(max = 50)
    @Column(name = "TEMP_CONTROL_MAINTAIN")
    private String tempControlMaintain;
    @Size(max = 50)
    @Column(name = "TYPE_OF_WATER")
    private String typeOfWater;
    @Size(max = 50)
    @Column(name = "SAND_READING")
    private String sandReading;
    @Size(max = 50)
    @Column(name = "CLAY_READING")
    private String clayReading;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "PERCENT_PRESENT_34_TO_12")
    private String percentPresent34To12;
    @Size(max = 50)
    @Column(name = "PERCENT_PRESENT_12_TO_38")
    private String percentPresent12To38;
    @Size(max = 50)
    @Column(name = "PERCENT_PRESENT_38_TO_NO_4")
    private String percentPresent38ToNo4;
    @Size(max = 50)
    @Column(name = "AGG_MASS_VOLUME_WATER_ADJUSTED")
    private String aggMassVolumeWaterAdjusted;
    @Size(max = 50)
    @Column(name = "WATER_ABSORBTION")
    private String waterAbsorbtion;
    @Size(max = 50)
    @Column(name = "AGG_SPECIFIC_GRAVITY")
    private String aggSpecificGravity;
    @Size(max = 50)
    @Column(name = "MASS_OVEN_DRIED")
    private String massOvenDried;
    @Size(max = 50)
    @Column(name = "ADJUSTED_WATER_VOLUME")
    private String adjustedWaterVolume;
    @Size(max = 50)
    @Column(name = "ADJUSTED_MASS")
    private String adjustedMass;
    @Size(max = 50)
    @Column(name = "TOP_CLAY_SUSPENSION")
    private String topClaySuspension;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Column(name = "RUN_NO")
    private BigInteger runNo;
    @Size(max = 50)
    @Column(name = "WTRET")
    private String wtret;
    @Size(max = 50)
    @Column(name = "ACCUMWTRET")
    private String accumwtret;
    @Size(max = 50)
    @Column(name = "PERCENTRET")
    private String percentret;
    @Size(max = 50)
    @Column(name = "PERCENTPASS")
    private String percentpass;
    @Size(max = 50)
    @Column(name = "PP_JMF")
    private String ppJmf;
    @Size(max = 50)
    @Column(name = "PP_DEV")
    private String ppDev;
    @Size(max = 50)
    @Column(name = "TOLERANCE")
    private String tolerance;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;

    public DotDnxT210() {
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

    public String getTestProcedureUsed() {
        return testProcedureUsed;
    }

    public void setTestProcedureUsed(String testProcedureUsed) {
        this.testProcedureUsed = testProcedureUsed;
    }

    public String getProcedureOption() {
        return procedureOption;
    }

    public void setProcedureOption(String procedureOption) {
        this.procedureOption = procedureOption;
    }

    public String getAirDriedWeight34To12() {
        return airDriedWeight34To12;
    }

    public void setAirDriedWeight34To12(String airDriedWeight34To12) {
        this.airDriedWeight34To12 = airDriedWeight34To12;
    }

    public String getAirDriedWeight12To38() {
        return airDriedWeight12To38;
    }

    public void setAirDriedWeight12To38(String airDriedWeight12To38) {
        this.airDriedWeight12To38 = airDriedWeight12To38;
    }

    public String getAirDriedWeight38ToNo4() {
        return airDriedWeight38ToNo4;
    }

    public void setAirDriedWeight38ToNo4(String airDriedWeight38ToNo4) {
        this.airDriedWeight38ToNo4 = airDriedWeight38ToNo4;
    }

    public String getTotalAirDriedWeight() {
        return totalAirDriedWeight;
    }

    public void setTotalAirDriedWeight(String totalAirDriedWeight) {
        this.totalAirDriedWeight = totalAirDriedWeight;
    }

    public String getHeightSediment() {
        return heightSediment;
    }

    public void setHeightSediment(String heightSediment) {
        this.heightSediment = heightSediment;
    }

    public String getDurabilityIndex() {
        return durabilityIndex;
    }

    public void setDurabilityIndex(String durabilityIndex) {
        this.durabilityIndex = durabilityIndex;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }

    public String getTempControlMaintain() {
        return tempControlMaintain;
    }

    public void setTempControlMaintain(String tempControlMaintain) {
        this.tempControlMaintain = tempControlMaintain;
    }

    public String getTypeOfWater() {
        return typeOfWater;
    }

    public void setTypeOfWater(String typeOfWater) {
        this.typeOfWater = typeOfWater;
    }

    public String getSandReading() {
        return sandReading;
    }

    public void setSandReading(String sandReading) {
        this.sandReading = sandReading;
    }

    public String getClayReading() {
        return clayReading;
    }

    public void setClayReading(String clayReading) {
        this.clayReading = clayReading;
    }

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getPercentPresent34To12() {
        return percentPresent34To12;
    }

    public void setPercentPresent34To12(String percentPresent34To12) {
        this.percentPresent34To12 = percentPresent34To12;
    }

    public String getPercentPresent12To38() {
        return percentPresent12To38;
    }

    public void setPercentPresent12To38(String percentPresent12To38) {
        this.percentPresent12To38 = percentPresent12To38;
    }

    public String getPercentPresent38ToNo4() {
        return percentPresent38ToNo4;
    }

    public void setPercentPresent38ToNo4(String percentPresent38ToNo4) {
        this.percentPresent38ToNo4 = percentPresent38ToNo4;
    }

    public String getAggMassVolumeWaterAdjusted() {
        return aggMassVolumeWaterAdjusted;
    }

    public void setAggMassVolumeWaterAdjusted(String aggMassVolumeWaterAdjusted) {
        this.aggMassVolumeWaterAdjusted = aggMassVolumeWaterAdjusted;
    }

    public String getWaterAbsorbtion() {
        return waterAbsorbtion;
    }

    public void setWaterAbsorbtion(String waterAbsorbtion) {
        this.waterAbsorbtion = waterAbsorbtion;
    }

    public String getAggSpecificGravity() {
        return aggSpecificGravity;
    }

    public void setAggSpecificGravity(String aggSpecificGravity) {
        this.aggSpecificGravity = aggSpecificGravity;
    }

    public String getMassOvenDried() {
        return massOvenDried;
    }

    public void setMassOvenDried(String massOvenDried) {
        this.massOvenDried = massOvenDried;
    }

    public String getAdjustedWaterVolume() {
        return adjustedWaterVolume;
    }

    public void setAdjustedWaterVolume(String adjustedWaterVolume) {
        this.adjustedWaterVolume = adjustedWaterVolume;
    }

    public String getAdjustedMass() {
        return adjustedMass;
    }

    public void setAdjustedMass(String adjustedMass) {
        this.adjustedMass = adjustedMass;
    }

    public String getTopClaySuspension() {
        return topClaySuspension;
    }

    public void setTopClaySuspension(String topClaySuspension) {
        this.topClaySuspension = topClaySuspension;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public String getSieveName() {
        return sieveName;
    }

    public void setSieveName(String sieveName) {
        this.sieveName = sieveName;
    }

    public BigInteger getRunNo() {
        return runNo;
    }

    public void setRunNo(BigInteger runNo) {
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

    public String getPercentret() {
        return percentret;
    }

    public void setPercentret(String percentret) {
        this.percentret = percentret;
    }

    public String getPercentpass() {
        return percentpass;
    }

    public void setPercentpass(String percentpass) {
        this.percentpass = percentpass;
    }

    public String getPpJmf() {
        return ppJmf;
    }

    public void setPpJmf(String ppJmf) {
        this.ppJmf = ppJmf;
    }

    public String getPpDev() {
        return ppDev;
    }

    public void setPpDev(String ppDev) {
        this.ppDev = ppDev;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance;
    }

    public String getProjrequire() {
        return projrequire;
    }

    public void setProjrequire(String projrequire) {
        this.projrequire = projrequire;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
