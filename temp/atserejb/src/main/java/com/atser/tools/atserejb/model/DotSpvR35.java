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
@Table(name = "DOT_SPV_R35", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSpvR35.findAll", query = "SELECT a FROM DotSpvR35 a")})
public class DotSpvR35 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "VFA")
    private String vfa;
    @Size(max = 50)
    @Column(name = "VFA_RESULT")
    private String vfaResult;
    @Size(max = 255)
    @Column(name = "VFA_REASON")
    private String vfaReason;
    @Size(max = 4)
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
    @Size(max = 381)
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
    @Column(name = "AGG_SPEC_GRAV")
    private String aggSpecGrav;
    @Size(max = 50)
    @Column(name = "BINDER_SPEC_GRAV")
    private String binderSpecGrav;
    @Size(max = 50)
    @Column(name = "PCT_PG_BINDER")
    private String pctPgBinder;
    @Size(max = 50)
    @Column(name = "PCT_PASSING_NO200")
    private String pctPassingNo200;
    @Size(max = 50)
    @Column(name = "GMM")
    private String gmm;
    @Size(max = 50)
    @Column(name = "VOIDS_LOWER_ENG_LIMIT")
    private String voidsLowerEngLimit;
    @Size(max = 50)
    @Column(name = "VOIDS_LOWER_SPEC_LIMIT")
    private String voidsLowerSpecLimit;
    @Size(max = 50)
    @Column(name = "VOIDS_UPPER_SPEC_LIMIT")
    private String voidsUpperSpecLimit;
    @Size(max = 50)
    @Column(name = "VOIDS_UPPER_ENG_LIMIT")
    private String voidsUpperEngLimit;
    @Size(max = 50)
    @Column(name = "VMA_LOWER_ENG_LIMIT")
    private String vmaLowerEngLimit;
    @Size(max = 50)
    @Column(name = "VMA_LOWER_SPEC_LIMIT")
    private String vmaLowerSpecLimit;
    @Size(max = 50)
    @Column(name = "VMA_UPPER_SPEC_LIMIT")
    private String vmaUpperSpecLimit;
    @Size(max = 50)
    @Column(name = "VMA_UPPER_ENG_LIMIT")
    private String vmaUpperEngLimit;
    @Size(max = 50)
    @Column(name = "VFA_LOWER_ENG_LIMIT")
    private String vfaLowerEngLimit;
    @Size(max = 50)
    @Column(name = "VFA_LOWER_SPEC_LIMIT")
    private String vfaLowerSpecLimit;
    @Size(max = 50)
    @Column(name = "VFA_UPPER_SPEC_LIMIT")
    private String vfaUpperSpecLimit;
    @Size(max = 50)
    @Column(name = "VFA_UPPER_ENG_LIMIT")
    private String vfaUpperEngLimit;
    @Size(max = 50)
    @Column(name = "EFFECTIVE_SPEC_GRAV_AGG")
    private String effectiveSpecGravAgg;
    @Size(max = 50)
    @Column(name = "PCT_ABSORBED_ASPHALT")
    private String pctAbsorbedAsphalt;
    @Size(max = 50)
    @Column(name = "PCT_EFFECTIVE_ASPHALT")
    private String pctEffectiveAsphalt;
    @Size(max = 50)
    @Column(name = "DUST_BINDER_RATIO")
    private String dustBinderRatio;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "GMB")
    private String gmb;
    @Size(max = 50)
    @Column(name = "AIR_VOIDS")
    private String airVoids;
    @Size(max = 50)
    @Column(name = "VOIDS_RESULT")
    private String voidsResult;
    @Size(max = 255)
    @Column(name = "VOIDS_REASON")
    private String voidsReason;
    @Size(max = 50)
    @Column(name = "VMA")
    private String vma;
    @Size(max = 50)
    @Column(name = "VMA_RESULT")
    private String vmaResult;
    @Size(max = 255)
    @Column(name = "VMA_REASON")
    private String vmaReason;
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

    public DotSpvR35() {
    }

    public String getVfa() {
        return vfa;
    }

    public void setVfa(String vfa) {
        this.vfa = vfa;
    }

    public String getVfaResult() {
        return vfaResult;
    }

    public void setVfaResult(String vfaResult) {
        this.vfaResult = vfaResult;
    }

    public String getVfaReason() {
        return vfaReason;
    }

    public void setVfaReason(String vfaReason) {
        this.vfaReason = vfaReason;
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

    public String getAggSpecGrav() {
        return aggSpecGrav;
    }

    public void setAggSpecGrav(String aggSpecGrav) {
        this.aggSpecGrav = aggSpecGrav;
    }

    public String getBinderSpecGrav() {
        return binderSpecGrav;
    }

    public void setBinderSpecGrav(String binderSpecGrav) {
        this.binderSpecGrav = binderSpecGrav;
    }

    public String getPctPgBinder() {
        return pctPgBinder;
    }

    public void setPctPgBinder(String pctPgBinder) {
        this.pctPgBinder = pctPgBinder;
    }

    public String getPctPassingNo200() {
        return pctPassingNo200;
    }

    public void setPctPassingNo200(String pctPassingNo200) {
        this.pctPassingNo200 = pctPassingNo200;
    }

    public String getGmm() {
        return gmm;
    }

    public void setGmm(String gmm) {
        this.gmm = gmm;
    }

    public String getVoidsLowerEngLimit() {
        return voidsLowerEngLimit;
    }

    public void setVoidsLowerEngLimit(String voidsLowerEngLimit) {
        this.voidsLowerEngLimit = voidsLowerEngLimit;
    }

    public String getVoidsLowerSpecLimit() {
        return voidsLowerSpecLimit;
    }

    public void setVoidsLowerSpecLimit(String voidsLowerSpecLimit) {
        this.voidsLowerSpecLimit = voidsLowerSpecLimit;
    }

    public String getVoidsUpperSpecLimit() {
        return voidsUpperSpecLimit;
    }

    public void setVoidsUpperSpecLimit(String voidsUpperSpecLimit) {
        this.voidsUpperSpecLimit = voidsUpperSpecLimit;
    }

    public String getVoidsUpperEngLimit() {
        return voidsUpperEngLimit;
    }

    public void setVoidsUpperEngLimit(String voidsUpperEngLimit) {
        this.voidsUpperEngLimit = voidsUpperEngLimit;
    }

    public String getVmaLowerEngLimit() {
        return vmaLowerEngLimit;
    }

    public void setVmaLowerEngLimit(String vmaLowerEngLimit) {
        this.vmaLowerEngLimit = vmaLowerEngLimit;
    }

    public String getVmaLowerSpecLimit() {
        return vmaLowerSpecLimit;
    }

    public void setVmaLowerSpecLimit(String vmaLowerSpecLimit) {
        this.vmaLowerSpecLimit = vmaLowerSpecLimit;
    }

    public String getVmaUpperSpecLimit() {
        return vmaUpperSpecLimit;
    }

    public void setVmaUpperSpecLimit(String vmaUpperSpecLimit) {
        this.vmaUpperSpecLimit = vmaUpperSpecLimit;
    }

    public String getVmaUpperEngLimit() {
        return vmaUpperEngLimit;
    }

    public void setVmaUpperEngLimit(String vmaUpperEngLimit) {
        this.vmaUpperEngLimit = vmaUpperEngLimit;
    }

    public String getVfaLowerEngLimit() {
        return vfaLowerEngLimit;
    }

    public void setVfaLowerEngLimit(String vfaLowerEngLimit) {
        this.vfaLowerEngLimit = vfaLowerEngLimit;
    }

    public String getVfaLowerSpecLimit() {
        return vfaLowerSpecLimit;
    }

    public void setVfaLowerSpecLimit(String vfaLowerSpecLimit) {
        this.vfaLowerSpecLimit = vfaLowerSpecLimit;
    }

    public String getVfaUpperSpecLimit() {
        return vfaUpperSpecLimit;
    }

    public void setVfaUpperSpecLimit(String vfaUpperSpecLimit) {
        this.vfaUpperSpecLimit = vfaUpperSpecLimit;
    }

    public String getVfaUpperEngLimit() {
        return vfaUpperEngLimit;
    }

    public void setVfaUpperEngLimit(String vfaUpperEngLimit) {
        this.vfaUpperEngLimit = vfaUpperEngLimit;
    }

    public String getEffectiveSpecGravAgg() {
        return effectiveSpecGravAgg;
    }

    public void setEffectiveSpecGravAgg(String effectiveSpecGravAgg) {
        this.effectiveSpecGravAgg = effectiveSpecGravAgg;
    }

    public String getPctAbsorbedAsphalt() {
        return pctAbsorbedAsphalt;
    }

    public void setPctAbsorbedAsphalt(String pctAbsorbedAsphalt) {
        this.pctAbsorbedAsphalt = pctAbsorbedAsphalt;
    }

    public String getPctEffectiveAsphalt() {
        return pctEffectiveAsphalt;
    }

    public void setPctEffectiveAsphalt(String pctEffectiveAsphalt) {
        this.pctEffectiveAsphalt = pctEffectiveAsphalt;
    }

    public String getDustBinderRatio() {
        return dustBinderRatio;
    }

    public void setDustBinderRatio(String dustBinderRatio) {
        this.dustBinderRatio = dustBinderRatio;
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

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getGmb() {
        return gmb;
    }

    public void setGmb(String gmb) {
        this.gmb = gmb;
    }

    public String getAirVoids() {
        return airVoids;
    }

    public void setAirVoids(String airVoids) {
        this.airVoids = airVoids;
    }

    public String getVoidsResult() {
        return voidsResult;
    }

    public void setVoidsResult(String voidsResult) {
        this.voidsResult = voidsResult;
    }

    public String getVoidsReason() {
        return voidsReason;
    }

    public void setVoidsReason(String voidsReason) {
        this.voidsReason = voidsReason;
    }

    public String getVma() {
        return vma;
    }

    public void setVma(String vma) {
        this.vma = vma;
    }

    public String getVmaResult() {
        return vmaResult;
    }

    public void setVmaResult(String vmaResult) {
        this.vmaResult = vmaResult;
    }

    public String getVmaReason() {
        return vmaReason;
    }

    public void setVmaReason(String vmaReason) {
        this.vmaReason = vmaReason;
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
