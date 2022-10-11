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
@Table(name = "dot_labrsoil_t96", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotLabrsoilT96.findAll", query = "SELECT a FROM DotLabrsoilT96 a")})
public class DotLabrsoilT96 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "UNIFORM_HARDNESS_RATIO2")
    private String uniformHardnessRatio2;
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
    @Column(name = "PERCENTLOSS_200")
    private String percentloss200;
    @Size(max = 50)
    @Column(name = "PERCENTLOSS_1000")
    private String percentloss1000;
    @Size(max = 50)
    @Column(name = "TOTALINITIALWT2")
    private String totalinitialwt2;
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
    @Size(max = 350)
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
    @Size(max = 4000)
    @Column(name = "FAR_SUMMARY")
    private String farSummary;
    @Size(max = 100)
    @Column(name = "LA_MACHINE")
    private String laMachine;
    @Size(max = 100)
    @Column(name = "CHARGES")
    private String charges;
    @Size(max = 100)
    @Column(name = "NO12_SIEVE")
    private String no12Sieve;
    @Size(max = 100)
    @Column(name = "SCALE")
    private String scale;
    @Size(max = 100)
    @Column(name = "DRYING_OVEN")
    private String dryingOven;
    @Column(name = "SAMPLE_LOCATION")
    private Character sampleLocation;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 50)
    @Column(name = "TEST_DESIGNATION")
    private String testDesignation;
    @Column(name = "QUANTITY")
    private BigDecimal quantity;
    @Size(max = 50)
    @Column(name = "MATERIAL_TYPE")
    private String materialType;
    @Size(max = 50)
    @Column(name = "COMPSTR_GREATER")
    private String compstrGreater;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "GRADING")
    private String grading;
    @Size(max = 50)
    @Column(name = "SIEVE1")
    private String sieve1;
    @Size(max = 50)
    @Column(name = "SIEVE1_2")
    private String sieve12;
    @Size(max = 50)
    @Column(name = "SIEVE1_4")
    private String sieve14;
    @Size(max = 50)
    @Column(name = "SIEVE3_4")
    private String sieve34;
    @Size(max = 50)
    @Column(name = "SIEVE3_8")
    private String sieve38;
    @Size(max = 50)
    @Column(name = "SIEVE4")
    private String sieve4;
    @Size(max = 50)
    @Column(name = "SIEVE8")
    private String sieve8;
    @Size(max = 50)
    @Column(name = "SIEVE12")
    private String sieve122;
    @Size(max = 50)
    @Column(name = "PERCENTLOSS")
    private String percentloss;
    @Size(max = 50)
    @Column(name = "TOTALINITIALWT")
    private String totalinitialwt;
    @Column(name = "AGGREGATE_ID")
    private BigDecimal aggregateId;
    @Size(max = 50)
    @Column(name = "SIEVE2_1_2")
    private String sieve212;
    @Size(max = 50)
    @Column(name = "SIEVE2")
    private String sieve2;
    @Size(max = 50)
    @Column(name = "SIEVE1_1_2")
    private String sieve112;
    @Size(max = 50)
    @Column(name = "AGG_NAME")
    private String aggName;
    @Size(max = 50)
    @Column(name = "PERCENTLOSS_500")
    private String percentloss500;
    @Size(max = 50)
    @Column(name = "UNIFORM_HARDNESS_RATIO")
    private String uniformHardnessRatio;
    @Size(max = 50)
    @Column(name = "WASHEDMASS_500")
    private String washedmass500;
    @Size(max = 50)
    @Column(name = "UNWASHEDMASS_200")
    private String unwashedmass200;
    @Size(max = 50)
    @Column(name = "WASHEDMASS_1000")
    private String washedmass1000;
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

    public DotLabrsoilT96() {
    }

    public String getUniformHardnessRatio2() {
        return uniformHardnessRatio2;
    }

    public void setUniformHardnessRatio2(String uniformHardnessRatio2) {
        this.uniformHardnessRatio2 = uniformHardnessRatio2;
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

    public String getPercentloss200() {
        return percentloss200;
    }

    public void setPercentloss200(String percentloss200) {
        this.percentloss200 = percentloss200;
    }

    public String getPercentloss1000() {
        return percentloss1000;
    }

    public void setPercentloss1000(String percentloss1000) {
        this.percentloss1000 = percentloss1000;
    }

    public String getTotalinitialwt2() {
        return totalinitialwt2;
    }

    public void setTotalinitialwt2(String totalinitialwt2) {
        this.totalinitialwt2 = totalinitialwt2;
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

    public String getFarSummary() {
        return farSummary;
    }

    public void setFarSummary(String farSummary) {
        this.farSummary = farSummary;
    }

    public String getLaMachine() {
        return laMachine;
    }

    public void setLaMachine(String laMachine) {
        this.laMachine = laMachine;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getNo12Sieve() {
        return no12Sieve;
    }

    public void setNo12Sieve(String no12Sieve) {
        this.no12Sieve = no12Sieve;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getDryingOven() {
        return dryingOven;
    }

    public void setDryingOven(String dryingOven) {
        this.dryingOven = dryingOven;
    }

    public Character getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(Character sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestDesignation() {
        return testDesignation;
    }

    public void setTestDesignation(String testDesignation) {
        this.testDesignation = testDesignation;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getCompstrGreater() {
        return compstrGreater;
    }

    public void setCompstrGreater(String compstrGreater) {
        this.compstrGreater = compstrGreater;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getSieve1() {
        return sieve1;
    }

    public void setSieve1(String sieve1) {
        this.sieve1 = sieve1;
    }

    public String getSieve12() {
        return sieve12;
    }

    public void setSieve12(String sieve12) {
        this.sieve12 = sieve12;
    }

    public String getSieve14() {
        return sieve14;
    }

    public void setSieve14(String sieve14) {
        this.sieve14 = sieve14;
    }

    public String getSieve34() {
        return sieve34;
    }

    public void setSieve34(String sieve34) {
        this.sieve34 = sieve34;
    }

    public String getSieve38() {
        return sieve38;
    }

    public void setSieve38(String sieve38) {
        this.sieve38 = sieve38;
    }

    public String getSieve4() {
        return sieve4;
    }

    public void setSieve4(String sieve4) {
        this.sieve4 = sieve4;
    }

    public String getSieve8() {
        return sieve8;
    }

    public void setSieve8(String sieve8) {
        this.sieve8 = sieve8;
    }

    public String getSieve122() {
        return sieve122;
    }

    public void setSieve122(String sieve122) {
        this.sieve12 = sieve122;
    }

    public String getPercentloss() {
        return percentloss;
    }

    public void setPercentloss(String percentloss) {
        this.percentloss = percentloss;
    }

    public String getTotalinitialwt() {
        return totalinitialwt;
    }

    public void setTotalinitialwt(String totalinitialwt) {
        this.totalinitialwt = totalinitialwt;
    }

    public BigDecimal getAggregateId() {
        return aggregateId;
    }

    public void setAggregateId(BigDecimal aggregateId) {
        this.aggregateId = aggregateId;
    }

    public String getSieve212() {
        return sieve212;
    }

    public void setSieve212(String sieve212) {
        this.sieve212 = sieve212;
    }

    public String getSieve2() {
        return sieve2;
    }

    public void setSieve2(String sieve2) {
        this.sieve2 = sieve2;
    }

    public String getSieve112() {
        return sieve112;
    }

    public void setSieve112(String sieve112) {
        this.sieve112 = sieve112;
    }

    public String getAggName() {
        return aggName;
    }

    public void setAggName(String aggName) {
        this.aggName = aggName;
    }

    public String getPercentloss500() {
        return percentloss500;
    }

    public void setPercentloss500(String percentloss500) {
        this.percentloss500 = percentloss500;
    }

    public String getUniformHardnessRatio() {
        return uniformHardnessRatio;
    }

    public void setUniformHardnessRatio(String uniformHardnessRatio) {
        this.uniformHardnessRatio = uniformHardnessRatio;
    }

    public String getWashedmass500() {
        return washedmass500;
    }

    public void setWashedmass500(String washedmass500) {
        this.washedmass500 = washedmass500;
    }

    public String getUnwashedmass200() {
        return unwashedmass200;
    }

    public void setUnwashedmass200(String unwashedmass200) {
        this.unwashedmass200 = unwashedmass200;
    }

    public String getWashedmass1000() {
        return washedmass1000;
    }

    public void setWashedmass1000(String washedmass1000) {
        this.washedmass1000 = washedmass1000;
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

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
