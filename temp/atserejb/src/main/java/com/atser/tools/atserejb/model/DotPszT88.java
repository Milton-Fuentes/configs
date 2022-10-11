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
@Table(name = "dot_psz_t88", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotPszT88.findAll", query = "SELECT a FROM DotPszT88 a")})
public class DotPszT88 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "WTPASSED")
    private String wtpassed;
    @Size(max = 50)
    @Column(name = "PERCENTRET")
    private String percentret;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 50)
    @Column(name = "MC_DRY_WT_SOIL_TARE")
    private String mcDryWtSoilTare;
    @Size(max = 50)
    @Column(name = "MC_WT_TARE")
    private String mcWtTare;
    @Size(max = 50)
    @Column(name = "MC_WT_WATER")
    private String mcWtWater;
    @Size(max = 50)
    @Column(name = "MC_WTDRY_SOIL")
    private String mcWtdrySoil;
    @Size(max = 50)
    @Column(name = "MC_WATER_CONTENT")
    private String mcWaterContent;
    @Size(max = 50)
    @Column(name = "MC_MENISCUS_CORR_FACTOR")
    private String mcMeniscusCorrFactor;
    @Size(max = 50)
    @Column(name = "MC_SPECIFIC_GRAVITY")
    private String mcSpecificGravity;
    @Size(max = 50)
    @Column(name = "MC_SOLUTION_USED")
    private String mcSolutionUsed;
    @Size(max = 50)
    @Column(name = "COARSE_MASS_TOTAL_AIRDRIED")
    private String coarseMassTotalAirdried;
    @Size(max = 50)
    @Column(name = "COARSE_MASS_FRAC_RET_NO10")
    private String coarseMassFracRetNo10;
    @Size(max = 50)
    @Column(name = "COARSE_PERC_RET_NO10")
    private String coarsePercRetNo10;
    @Size(max = 50)
    @Column(name = "COARSE_PERC_PASSING_NO10")
    private String coarsePercPassingNo10;
    @Size(max = 50)
    @Column(name = "HM_CONTAINER_NO")
    private String hmContainerNo;
    @Size(max = 50)
    @Column(name = "HM_MASS_CONTAINER_AIRDRIED")
    private String hmMassContainerAirdried;
    @Size(max = 50)
    @Column(name = "HM_MASS_CONTAINER_OVENDRIED")
    private String hmMassContainerOvendried;
    @Size(max = 50)
    @Column(name = "HM_MASS_CONTAINER")
    private String hmMassContainer;
    @Size(max = 50)
    @Column(name = "HM_MASS_WATER")
    private String hmMassWater;
    @Size(max = 50)
    @Column(name = "HM_MASS_AIRDRIED")
    private String hmMassAirdried;
    @Size(max = 50)
    @Column(name = "HM_MASS_OVENDRIED")
    private String hmMassOvendried;
    @Size(max = 50)
    @Column(name = "HM_HYGROSCOPIC_MOIST")
    private String hmHygroscopicMoist;
    @Size(max = 50)
    @Column(name = "FINE_CONTAINER_NO")
    private String fineContainerNo;
    @Size(max = 50)
    @Column(name = "FINE_MASS_CONTAINER_AIRDRIED")
    private String fineMassContainerAirdried;
    @Size(max = 50)
    @Column(name = "FINE_MASS_CONTAINER")
    private String fineMassContainer;
    @Size(max = 50)
    @Column(name = "FINE_MASS_AIRDRIED_SOIL")
    private String fineMassAirdriedSoil;
    @Size(max = 50)
    @Column(name = "FINE_MASS_OVENDRIED")
    private String fineMassOvendried;
    @Size(max = 50)
    @Column(name = "FINE_CALC_MASS_TOTAL")
    private String fineCalcMassTotal;
    @Size(max = 50)
    @Column(name = "FINE_TOTAL_PERCENT_PASSED")
    private String fineTotalPercentPassed;
    @Size(max = 50)
    @Column(name = "AMOUNT_TYPE_DISP_AGENT_USED")
    private String amountTypeDispAgentUsed;
    @Size(max = 50)
    @Column(name = "HM_HYGROSCOPIC_MOIST_CORR_FACT")
    private String hmHygroscopicMoistCorrFact;
    @Column(name = "SET_ID")
    private BigDecimal setId;
    @Column(name = "RUN_NO")
    private BigDecimal runNo;
    @Column(name = "AGG_TYPE")
    private Character aggType;
    @Size(max = 6)
    @Column(name = "SA_TYPE")
    private String saType;
    @Column(name = "SIEVE_ID")
    private BigDecimal sieveId;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Size(max = 50)
    @Column(name = "PERCENTPASS")
    private String percentpass;
    @Size(max = 50)
    @Column(name = "WTRET")
    private String wtret;
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
    @Size(max = 313)
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
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 50)
    @Column(name = "PARTICLE_LARGER_THAN_2MM_PCT")
    private String particleLargerThan2mmPct;
    @Size(max = 50)
    @Column(name = "COARSE_SAND_2_TO_42MM_PCT")
    private String coarseSand2To42mmPct;
    @Size(max = 50)
    @Column(name = "FINE_SAND_42_TO_074MM_PCT")
    private String fineSand42To074mmPct;
    @Column(name = "PASSFAIL")
    private Character passfail;
    @Size(max = 50)
    @Column(name = "SILT_074_TO_002MM_PCT")
    private String silt074To002mmPct;
    @Size(max = 50)
    @Column(name = "CLAY_SMALLER_THAN_002MM_PCT")
    private String claySmallerThan002mmPct;
    @Size(max = 50)
    @Column(name = "COLLOID_SMALLER_THAN_001MM_PCT")
    private String colloidSmallerThan001mmPct;
    @Size(max = 50)
    @Column(name = "SMALLER_THAN_02MM_PERCENT")
    private String smallerThan02mmPercent;
    @Size(max = 50)
    @Column(name = "SMALLER_THAN_002MM_PERCENT")
    private String smallerThan002mmPercent;
    @Size(max = 50)
    @Column(name = "SMALLER_THAN_001MM_PERCENT")
    private String smallerThan001mmPercent;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "WT_SAMPLE_PASS_NO10_TAKEN_TEST")
    private String wtSamplePassNo10TakenTest;
    @Size(max = 50)
    @Column(name = "PERPASS_NO10_WHOLE_SAMPLE")
    private String perpassNo10WholeSample;
    @Size(max = 50)
    @Column(name = "HYDROMETER_NO")
    private String hydrometerNo;
    @Size(max = 50)
    @Column(name = "MC_WET_WT_SOIL_TARE")
    private String mcWetWtSoilTare;

    public DotPszT88() {
    }

    public String getWtpassed() {
        return wtpassed;
    }

    public void setWtpassed(String wtpassed) {
        this.wtpassed = wtpassed;
    }

    public String getPercentret() {
        return percentret;
    }

    public void setPercentret(String percentret) {
        this.percentret = percentret;
    }

    public String getProjrequire() {
        return projrequire;
    }

    public void setProjrequire(String projrequire) {
        this.projrequire = projrequire;
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

    public String getMcDryWtSoilTare() {
        return mcDryWtSoilTare;
    }

    public void setMcDryWtSoilTare(String mcDryWtSoilTare) {
        this.mcDryWtSoilTare = mcDryWtSoilTare;
    }

    public String getMcWtTare() {
        return mcWtTare;
    }

    public void setMcWtTare(String mcWtTare) {
        this.mcWtTare = mcWtTare;
    }

    public String getMcWtWater() {
        return mcWtWater;
    }

    public void setMcWtWater(String mcWtWater) {
        this.mcWtWater = mcWtWater;
    }

    public String getMcWtdrySoil() {
        return mcWtdrySoil;
    }

    public void setMcWtdrySoil(String mcWtdrySoil) {
        this.mcWtdrySoil = mcWtdrySoil;
    }

    public String getMcWaterContent() {
        return mcWaterContent;
    }

    public void setMcWaterContent(String mcWaterContent) {
        this.mcWaterContent = mcWaterContent;
    }

    public String getMcMeniscusCorrFactor() {
        return mcMeniscusCorrFactor;
    }

    public void setMcMeniscusCorrFactor(String mcMeniscusCorrFactor) {
        this.mcMeniscusCorrFactor = mcMeniscusCorrFactor;
    }

    public String getMcSpecificGravity() {
        return mcSpecificGravity;
    }

    public void setMcSpecificGravity(String mcSpecificGravity) {
        this.mcSpecificGravity = mcSpecificGravity;
    }

    public String getMcSolutionUsed() {
        return mcSolutionUsed;
    }

    public void setMcSolutionUsed(String mcSolutionUsed) {
        this.mcSolutionUsed = mcSolutionUsed;
    }

    public String getCoarseMassTotalAirdried() {
        return coarseMassTotalAirdried;
    }

    public void setCoarseMassTotalAirdried(String coarseMassTotalAirdried) {
        this.coarseMassTotalAirdried = coarseMassTotalAirdried;
    }

    public String getCoarseMassFracRetNo10() {
        return coarseMassFracRetNo10;
    }

    public void setCoarseMassFracRetNo10(String coarseMassFracRetNo10) {
        this.coarseMassFracRetNo10 = coarseMassFracRetNo10;
    }

    public String getCoarsePercRetNo10() {
        return coarsePercRetNo10;
    }

    public void setCoarsePercRetNo10(String coarsePercRetNo10) {
        this.coarsePercRetNo10 = coarsePercRetNo10;
    }

    public String getCoarsePercPassingNo10() {
        return coarsePercPassingNo10;
    }

    public void setCoarsePercPassingNo10(String coarsePercPassingNo10) {
        this.coarsePercPassingNo10 = coarsePercPassingNo10;
    }

    public String getHmContainerNo() {
        return hmContainerNo;
    }

    public void setHmContainerNo(String hmContainerNo) {
        this.hmContainerNo = hmContainerNo;
    }

    public String getHmMassContainerAirdried() {
        return hmMassContainerAirdried;
    }

    public void setHmMassContainerAirdried(String hmMassContainerAirdried) {
        this.hmMassContainerAirdried = hmMassContainerAirdried;
    }

    public String getHmMassContainerOvendried() {
        return hmMassContainerOvendried;
    }

    public void setHmMassContainerOvendried(String hmMassContainerOvendried) {
        this.hmMassContainerOvendried = hmMassContainerOvendried;
    }

    public String getHmMassContainer() {
        return hmMassContainer;
    }

    public void setHmMassContainer(String hmMassContainer) {
        this.hmMassContainer = hmMassContainer;
    }

    public String getHmMassWater() {
        return hmMassWater;
    }

    public void setHmMassWater(String hmMassWater) {
        this.hmMassWater = hmMassWater;
    }

    public String getHmMassAirdried() {
        return hmMassAirdried;
    }

    public void setHmMassAirdried(String hmMassAirdried) {
        this.hmMassAirdried = hmMassAirdried;
    }

    public String getHmMassOvendried() {
        return hmMassOvendried;
    }

    public void setHmMassOvendried(String hmMassOvendried) {
        this.hmMassOvendried = hmMassOvendried;
    }

    public String getHmHygroscopicMoist() {
        return hmHygroscopicMoist;
    }

    public void setHmHygroscopicMoist(String hmHygroscopicMoist) {
        this.hmHygroscopicMoist = hmHygroscopicMoist;
    }

    public String getFineContainerNo() {
        return fineContainerNo;
    }

    public void setFineContainerNo(String fineContainerNo) {
        this.fineContainerNo = fineContainerNo;
    }

    public String getFineMassContainerAirdried() {
        return fineMassContainerAirdried;
    }

    public void setFineMassContainerAirdried(String fineMassContainerAirdried) {
        this.fineMassContainerAirdried = fineMassContainerAirdried;
    }

    public String getFineMassContainer() {
        return fineMassContainer;
    }

    public void setFineMassContainer(String fineMassContainer) {
        this.fineMassContainer = fineMassContainer;
    }

    public String getFineMassAirdriedSoil() {
        return fineMassAirdriedSoil;
    }

    public void setFineMassAirdriedSoil(String fineMassAirdriedSoil) {
        this.fineMassAirdriedSoil = fineMassAirdriedSoil;
    }

    public String getFineMassOvendried() {
        return fineMassOvendried;
    }

    public void setFineMassOvendried(String fineMassOvendried) {
        this.fineMassOvendried = fineMassOvendried;
    }

    public String getFineCalcMassTotal() {
        return fineCalcMassTotal;
    }

    public void setFineCalcMassTotal(String fineCalcMassTotal) {
        this.fineCalcMassTotal = fineCalcMassTotal;
    }

    public String getFineTotalPercentPassed() {
        return fineTotalPercentPassed;
    }

    public void setFineTotalPercentPassed(String fineTotalPercentPassed) {
        this.fineTotalPercentPassed = fineTotalPercentPassed;
    }

    public String getAmountTypeDispAgentUsed() {
        return amountTypeDispAgentUsed;
    }

    public void setAmountTypeDispAgentUsed(String amountTypeDispAgentUsed) {
        this.amountTypeDispAgentUsed = amountTypeDispAgentUsed;
    }

    public String getHmHygroscopicMoistCorrFact() {
        return hmHygroscopicMoistCorrFact;
    }

    public void setHmHygroscopicMoistCorrFact(String hmHygroscopicMoistCorrFact) {
        this.hmHygroscopicMoistCorrFact = hmHygroscopicMoistCorrFact;
    }

    public BigDecimal getSetId() {
        return setId;
    }

    public void setSetId(BigDecimal setId) {
        this.setId = setId;
    }

    public BigDecimal getRunNo() {
        return runNo;
    }

    public void setRunNo(BigDecimal runNo) {
        this.runNo = runNo;
    }

    public Character getAggType() {
        return aggType;
    }

    public void setAggType(Character aggType) {
        this.aggType = aggType;
    }

    public String getSaType() {
        return saType;
    }

    public void setSaType(String saType) {
        this.saType = saType;
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

    public String getPercentpass() {
        return percentpass;
    }

    public void setPercentpass(String percentpass) {
        this.percentpass = percentpass;
    }

    public String getWtret() {
        return wtret;
    }

    public void setWtret(String wtret) {
        this.wtret = wtret;
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

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getParticleLargerThan2mmPct() {
        return particleLargerThan2mmPct;
    }

    public void setParticleLargerThan2mmPct(String particleLargerThan2mmPct) {
        this.particleLargerThan2mmPct = particleLargerThan2mmPct;
    }

    public String getCoarseSand2To42mmPct() {
        return coarseSand2To42mmPct;
    }

    public void setCoarseSand2To42mmPct(String coarseSand2To42mmPct) {
        this.coarseSand2To42mmPct = coarseSand2To42mmPct;
    }

    public String getFineSand42To074mmPct() {
        return fineSand42To074mmPct;
    }

    public void setFineSand42To074mmPct(String fineSand42To074mmPct) {
        this.fineSand42To074mmPct = fineSand42To074mmPct;
    }

    public Character getPassfail() {
        return passfail;
    }

    public void setPassfail(Character passfail) {
        this.passfail = passfail;
    }

    public String getSilt074To002mmPct() {
        return silt074To002mmPct;
    }

    public void setSilt074To002mmPct(String silt074To002mmPct) {
        this.silt074To002mmPct = silt074To002mmPct;
    }

    public String getClaySmallerThan002mmPct() {
        return claySmallerThan002mmPct;
    }

    public void setClaySmallerThan002mmPct(String claySmallerThan002mmPct) {
        this.claySmallerThan002mmPct = claySmallerThan002mmPct;
    }

    public String getColloidSmallerThan001mmPct() {
        return colloidSmallerThan001mmPct;
    }

    public void setColloidSmallerThan001mmPct(String colloidSmallerThan001mmPct) {
        this.colloidSmallerThan001mmPct = colloidSmallerThan001mmPct;
    }

    public String getSmallerThan02mmPercent() {
        return smallerThan02mmPercent;
    }

    public void setSmallerThan02mmPercent(String smallerThan02mmPercent) {
        this.smallerThan02mmPercent = smallerThan02mmPercent;
    }

    public String getSmallerThan002mmPercent() {
        return smallerThan002mmPercent;
    }

    public void setSmallerThan002mmPercent(String smallerThan002mmPercent) {
        this.smallerThan002mmPercent = smallerThan002mmPercent;
    }

    public String getSmallerThan001mmPercent() {
        return smallerThan001mmPercent;
    }

    public void setSmallerThan001mmPercent(String smallerThan001mmPercent) {
        this.smallerThan001mmPercent = smallerThan001mmPercent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWtSamplePassNo10TakenTest() {
        return wtSamplePassNo10TakenTest;
    }

    public void setWtSamplePassNo10TakenTest(String wtSamplePassNo10TakenTest) {
        this.wtSamplePassNo10TakenTest = wtSamplePassNo10TakenTest;
    }

    public String getPerpassNo10WholeSample() {
        return perpassNo10WholeSample;
    }

    public void setPerpassNo10WholeSample(String perpassNo10WholeSample) {
        this.perpassNo10WholeSample = perpassNo10WholeSample;
    }

    public String getHydrometerNo() {
        return hydrometerNo;
    }

    public void setHydrometerNo(String hydrometerNo) {
        this.hydrometerNo = hydrometerNo;
    }

    public String getMcWetWtSoilTare() {
        return mcWetWtSoilTare;
    }

    public void setMcWetWtSoilTare(String mcWetWtSoilTare) {
        this.mcWetWtSoilTare = mcWetWtSoilTare;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
