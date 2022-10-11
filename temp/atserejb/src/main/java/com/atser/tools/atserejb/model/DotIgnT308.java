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
@Table(name = "DOT_IGN_T308", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotIgnT308.findAll", query = "SELECT a FROM DotIgnT308 a")})
public class DotIgnT308 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "BEGINNING_OVEN_WEIGHT")
    private String beginningOvenWeight;
    @Size(max = 50)
    @Column(name = "DIFFERENCE")
    private String difference;
    @Size(max = 50)
    @Column(name = "MAX_ALLOWABLE_DIFFERENCE_5")
    private String maxAllowableDifference5;
    @Size(max = 50)
    @Column(name = "TEST_TIME")
    private String testTime;
    @Size(max = 50)
    @Column(name = "PG_BINDER_MASS")
    private String pgBinderMass;
    @Size(max = 50)
    @Column(name = "FINAL_SAMPLE_MASS")
    private String finalSampleMass;
    @Size(max = 50)
    @Column(name = "AGGREGATE_CORRECTION_FACTOR")
    private String aggregateCorrectionFactor;
    @Size(max = 50)
    @Column(name = "TEMPERATURE_CORRECTION_FACTOR")
    private String temperatureCorrectionFactor;
    @Size(max = 50)
    @Column(name = "PCT_PG_BINDER")
    private String pctPgBinder;
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
    @Size(max = 309)
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
    @Column(name = "PCT_MOISTURE")
    private String pctMoisture;
    @Size(max = 50)
    @Column(name = "PG_BINDER_JMF")
    private String pgBinderJmf;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 100)
    @Column(name = "REASON")
    private String reason;
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "AVG_PCT_PG_BINDER")
    private String avgPctPgBinder;
    @Size(max = 50)
    @Column(name = "LOWER_SPEC_LIMIT")
    private String lowerSpecLimit;
    @Size(max = 50)
    @Column(name = "UPPER_SPEC_LIMIT")
    private String upperSpecLimit;
    @Size(max = 50)
    @Column(name = "LOWER_ENG_LIMIT")
    private String lowerEngLimit;
    @Size(max = 50)
    @Column(name = "UPPER_ENG_LIMIT")
    private String upperEngLimit;
    @Size(max = 50)
    @Column(name = "SPECIMEN_NO")
    private String specimenNo;
    @Size(max = 50)
    @Column(name = "OVEN_SET_POINT")
    private String ovenSetPoint;
    @Size(max = 50)
    @Column(name = "BASKET_TARE_MASS")
    private String basketTareMass;
    @Size(max = 50)
    @Column(name = "INITIAL_SAMPLE_MASS")
    private String initialSampleMass;
    @Size(max = 50)
    @Column(name = "CORRECTED_SAMPLE_MASS")
    private String correctedSampleMass;

    public DotIgnT308() {
    }

    public String getBeginningOvenWeight() {
        return beginningOvenWeight;
    }

    public void setBeginningOvenWeight(String beginningOvenWeight) {
        this.beginningOvenWeight = beginningOvenWeight;
    }

    public String getDifference() {
        return difference;
    }

    public void setDifference(String difference) {
        this.difference = difference;
    }

    public String getMaxAllowableDifference5() {
        return maxAllowableDifference5;
    }

    public void setMaxAllowableDifference5(String maxAllowableDifference5) {
        this.maxAllowableDifference5 = maxAllowableDifference5;
    }

    public String getTestTime() {
        return testTime;
    }

    public void setTestTime(String testTime) {
        this.testTime = testTime;
    }

    public String getPgBinderMass() {
        return pgBinderMass;
    }

    public void setPgBinderMass(String pgBinderMass) {
        this.pgBinderMass = pgBinderMass;
    }

    public String getFinalSampleMass() {
        return finalSampleMass;
    }

    public void setFinalSampleMass(String finalSampleMass) {
        this.finalSampleMass = finalSampleMass;
    }

    public String getAggregateCorrectionFactor() {
        return aggregateCorrectionFactor;
    }

    public void setAggregateCorrectionFactor(String aggregateCorrectionFactor) {
        this.aggregateCorrectionFactor = aggregateCorrectionFactor;
    }

    public String getTemperatureCorrectionFactor() {
        return temperatureCorrectionFactor;
    }

    public void setTemperatureCorrectionFactor(String temperatureCorrectionFactor) {
        this.temperatureCorrectionFactor = temperatureCorrectionFactor;
    }

    public String getPctPgBinder() {
        return pctPgBinder;
    }

    public void setPctPgBinder(String pctPgBinder) {
        this.pctPgBinder = pctPgBinder;
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

    public String getPctMoisture() {
        return pctMoisture;
    }

    public void setPctMoisture(String pctMoisture) {
        this.pctMoisture = pctMoisture;
    }

    public String getPgBinderJmf() {
        return pgBinderJmf;
    }

    public void setPgBinderJmf(String pgBinderJmf) {
        this.pgBinderJmf = pgBinderJmf;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public String getAvgPctPgBinder() {
        return avgPctPgBinder;
    }

    public void setAvgPctPgBinder(String avgPctPgBinder) {
        this.avgPctPgBinder = avgPctPgBinder;
    }

    public String getLowerSpecLimit() {
        return lowerSpecLimit;
    }

    public void setLowerSpecLimit(String lowerSpecLimit) {
        this.lowerSpecLimit = lowerSpecLimit;
    }

    public String getUpperSpecLimit() {
        return upperSpecLimit;
    }

    public void setUpperSpecLimit(String upperSpecLimit) {
        this.upperSpecLimit = upperSpecLimit;
    }

    public String getLowerEngLimit() {
        return lowerEngLimit;
    }

    public void setLowerEngLimit(String lowerEngLimit) {
        this.lowerEngLimit = lowerEngLimit;
    }

    public String getUpperEngLimit() {
        return upperEngLimit;
    }

    public void setUpperEngLimit(String upperEngLimit) {
        this.upperEngLimit = upperEngLimit;
    }

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getOvenSetPoint() {
        return ovenSetPoint;
    }

    public void setOvenSetPoint(String ovenSetPoint) {
        this.ovenSetPoint = ovenSetPoint;
    }

    public String getBasketTareMass() {
        return basketTareMass;
    }

    public void setBasketTareMass(String basketTareMass) {
        this.basketTareMass = basketTareMass;
    }

    public String getInitialSampleMass() {
        return initialSampleMass;
    }

    public void setInitialSampleMass(String initialSampleMass) {
        this.initialSampleMass = initialSampleMass;
    }

    public String getCorrectedSampleMass() {
        return correctedSampleMass;
    }

    public void setCorrectedSampleMass(String correctedSampleMass) {
        this.correctedSampleMass = correctedSampleMass;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
