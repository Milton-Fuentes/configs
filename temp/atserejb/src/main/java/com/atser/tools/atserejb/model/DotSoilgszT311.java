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
@Table(name = "dot_soilgsz_t311", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSoilgszT311.findAll", query = "SELECT a FROM DotSoilgszT311 a")})
public class DotSoilgszT311 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "PERCENTPASS")
    private String percentpass;
    @Size(max = 50)
    @Column(name = "PROJREQUIRE")
    private String projrequire;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
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
    @Column(name = "WTDRY_PLUS_AFTER_SEPARATION")
    private String wtdryPlusAfterSeparation;
    @Size(max = 50)
    @Column(name = "WT_PAN_MATERIAL_FROM_PLUS")
    private String wtPanMaterialFromPlus;
    @Size(max = 50)
    @Column(name = "WTDRY_PLUS_MATERIAL")
    private String wtdryPlusMaterial;
    @Size(max = 50)
    @Column(name = "WTMOIST_MINUS_MATERIAL")
    private String wtmoistMinusMaterial;
    @Size(max = 50)
    @Column(name = "WTDRY_MINUS")
    private String wtdryMinus;
    @Size(max = 50)
    @Column(name = "WTTOTAL_DRY_SAMPLE")
    private String wttotalDrySample;
    @Size(max = 50)
    @Column(name = "CONTAINER_NUMBER")
    private String containerNumber;
    @Size(max = 50)
    @Column(name = "WTSAMPLE_CONTAINER_BEFORE_DRY")
    private String wtsampleContainerBeforeDry;
    @Size(max = 50)
    @Column(name = "WTSAMPLE_CONTAINER_AFTER_DRY")
    private String wtsampleContainerAfterDry;
    @Size(max = 50)
    @Column(name = "WTCONTAINER")
    private String wtcontainer;
    @Size(max = 50)
    @Column(name = "WTWATER")
    private String wtwater;
    @Size(max = 50)
    @Column(name = "WTDRY_SAMPLE")
    private String wtdrySample;
    @Size(max = 50)
    @Column(name = "MOISTURE_CONTENT")
    private String moistureContent;
    @Size(max = 50)
    @Column(name = "WTDRY_MINUS_BEFORE_WASH")
    private String wtdryMinusBeforeWash;
    @Size(max = 50)
    @Column(name = "WTDRY_MINUS_AFTER_WASH")
    private String wtdryMinusAfterWash;
    @Size(max = 50)
    @Column(name = "TOTAL")
    private String total;
    @Size(max = 50)
    @Column(name = "PAN")
    private String pan;
    @Size(max = 50)
    @Column(name = "TOTAL_CA")
    private String totalCa;
    @Column(name = "SPLITSIEVE_ID")
    private BigDecimal splitsieveId;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "SUM_PERCENTRET_CA")
    private String sumPercentretCa;
    @Size(max = 50)
    @Column(name = "SUM_PERCENTRET")
    private String sumPercentret;
    @Column(name = "SET_ID")
    private BigDecimal setId;
    @Column(name = "SPLITRUN_NO")
    private BigDecimal splitrunNo;
    @Size(max = 50)
    @Column(name = "SIEVE_LOSS")
    private String sieveLoss;
    @Column(name = "RUN_NO")
    private BigDecimal runNo;
    @Column(name = "AGG_TYPE")
    private Character aggType;
    @Column(name = "SIEVE_ID")
    private BigDecimal sieveId;
    @Size(max = 50)
    @Column(name = "SIEVE_NAME")
    private String sieveName;
    @Size(max = 50)
    @Column(name = "WTRET")
    private String wtret;
    @Size(max = 50)
    @Column(name = "PERCENTRET")
    private String percentret;
    @Size(max = 50)
    @Column(name = "COMBPCT")
    private String combpct;
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

    public DotSoilgszT311() {
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

    public String getWtdryPlusAfterSeparation() {
        return wtdryPlusAfterSeparation;
    }

    public void setWtdryPlusAfterSeparation(String wtdryPlusAfterSeparation) {
        this.wtdryPlusAfterSeparation = wtdryPlusAfterSeparation;
    }

    public String getWtPanMaterialFromPlus() {
        return wtPanMaterialFromPlus;
    }

    public void setWtPanMaterialFromPlus(String wtPanMaterialFromPlus) {
        this.wtPanMaterialFromPlus = wtPanMaterialFromPlus;
    }

    public String getWtdryPlusMaterial() {
        return wtdryPlusMaterial;
    }

    public void setWtdryPlusMaterial(String wtdryPlusMaterial) {
        this.wtdryPlusMaterial = wtdryPlusMaterial;
    }

    public String getWtmoistMinusMaterial() {
        return wtmoistMinusMaterial;
    }

    public void setWtmoistMinusMaterial(String wtmoistMinusMaterial) {
        this.wtmoistMinusMaterial = wtmoistMinusMaterial;
    }

    public String getWtdryMinus() {
        return wtdryMinus;
    }

    public void setWtdryMinus(String wtdryMinus) {
        this.wtdryMinus = wtdryMinus;
    }

    public String getWttotalDrySample() {
        return wttotalDrySample;
    }

    public void setWttotalDrySample(String wttotalDrySample) {
        this.wttotalDrySample = wttotalDrySample;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public String getWtsampleContainerBeforeDry() {
        return wtsampleContainerBeforeDry;
    }

    public void setWtsampleContainerBeforeDry(String wtsampleContainerBeforeDry) {
        this.wtsampleContainerBeforeDry = wtsampleContainerBeforeDry;
    }

    public String getWtsampleContainerAfterDry() {
        return wtsampleContainerAfterDry;
    }

    public void setWtsampleContainerAfterDry(String wtsampleContainerAfterDry) {
        this.wtsampleContainerAfterDry = wtsampleContainerAfterDry;
    }

    public String getWtcontainer() {
        return wtcontainer;
    }

    public void setWtcontainer(String wtcontainer) {
        this.wtcontainer = wtcontainer;
    }

    public String getWtwater() {
        return wtwater;
    }

    public void setWtwater(String wtwater) {
        this.wtwater = wtwater;
    }

    public String getWtdrySample() {
        return wtdrySample;
    }

    public void setWtdrySample(String wtdrySample) {
        this.wtdrySample = wtdrySample;
    }

    public String getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(String moistureContent) {
        this.moistureContent = moistureContent;
    }

    public String getWtdryMinusBeforeWash() {
        return wtdryMinusBeforeWash;
    }

    public void setWtdryMinusBeforeWash(String wtdryMinusBeforeWash) {
        this.wtdryMinusBeforeWash = wtdryMinusBeforeWash;
    }

    public String getWtdryMinusAfterWash() {
        return wtdryMinusAfterWash;
    }

    public void setWtdryMinusAfterWash(String wtdryMinusAfterWash) {
        this.wtdryMinusAfterWash = wtdryMinusAfterWash;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getTotalCa() {
        return totalCa;
    }

    public void setTotalCa(String totalCa) {
        this.totalCa = totalCa;
    }

    public BigDecimal getSplitsieveId() {
        return splitsieveId;
    }

    public void setSplitsieveId(BigDecimal splitsieveId) {
        this.splitsieveId = splitsieveId;
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

    public String getSumPercentretCa() {
        return sumPercentretCa;
    }

    public void setSumPercentretCa(String sumPercentretCa) {
        this.sumPercentretCa = sumPercentretCa;
    }

    public String getSumPercentret() {
        return sumPercentret;
    }

    public void setSumPercentret(String sumPercentret) {
        this.sumPercentret = sumPercentret;
    }

    public BigDecimal getSetId() {
        return setId;
    }

    public void setSetId(BigDecimal setId) {
        this.setId = setId;
    }

    public BigDecimal getSplitrunNo() {
        return splitrunNo;
    }

    public void setSplitrunNo(BigDecimal splitrunNo) {
        this.splitrunNo = splitrunNo;
    }

    public String getSieveLoss() {
        return sieveLoss;
    }

    public void setSieveLoss(String sieveLoss) {
        this.sieveLoss = sieveLoss;
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

    public String getWtret() {
        return wtret;
    }

    public void setWtret(String wtret) {
        this.wtret = wtret;
    }

    public String getPercentret() {
        return percentret;
    }

    public void setPercentret(String percentret) {
        this.percentret = percentret;
    }

    public String getCombpct() {
        return combpct;
    }

    public void setCombpct(String combpct) {
        this.combpct = combpct;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
