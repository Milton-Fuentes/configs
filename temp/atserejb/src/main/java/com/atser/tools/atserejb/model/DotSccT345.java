/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
import com.atser.tools.atserutil.string.StringSupport;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
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
@Table(name = "DOT_SCC_T345", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DotSccT345.findAll", query = "SELECT a FROM DotSccT345 a")})
public class DotSccT345 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "ID")
    private BigInteger id;
    @Column(name = "ACTIVE")
    private Character active;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "DATEOFTEST")
    private Date dateoftest;
    @Column(name = "SUBBIDITEM_ID")
    private Integer subbiditemId;
    @Column(name = "PROJECT_ID")
    private Integer projectId;
    @Column(name = "MIX_DESIGN_ID")
    private Integer mixDesignId;
    @Column(name = "TEST_ID")
    private Integer testId;
    @Column(name = "LAB_ID")
    private Integer labId;
    @Column(name = "QA_SAMPLE_ID")
    private Integer qaSampleId;
    @Column(name = "BIDITEM_ID")
    private Integer biditemId;
    @Column(name = "CLIENT_ID")
    private Integer clientId;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testoNo;
    @Size(max = 200)
    @Column(name = "BIDITEM_NO")
    private String biditemNo;
    @Size(max = 25)
    @Column(name = "P_NUMBER")
    private String pNumber;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 255)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @JsonSkipXssSerialization
    @Size(max = 327)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 4000)
    @Column(name = "EQUIP_LIST")
    private String equipList;
    @Size(max = 50)
    @Column(name = "TECH_ID")
    private String techId;
    @Size(max = 50)
    @Column(name = "FUNCTION")
    private String function;
    @Size(max = 50)
    @Column(name = "MIXDESIGNNO")
    private String mixdesignno;
    @Size(max = 50)
    @Column(name = "SAMPLE_NO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "TEST_RESULTS")
    private String testResults;
    @Size(max = 50)
    @Column(name = "PASSFAIL")
    private String passfail;
    @Size(max = 50)
    @Column(name = "SPEC_MAX")
    private String specMax;
    @Size(max = 50)
    @Column(name = "STATUS2")
    private String status2;
    @Size(max = 50)
    @Column(name = "LAB_PREP")
    private String labPrep;
    @Size(max = 50)
    @Column(name = "SPEC_MIN")
    private String specMin;
    @Size(max = 50)
    @Column(name = "J_RING_TEST_VALUE")
    private String jRingTestValue;
    @Size(max = 50)
    @Column(name = "DIFF_H1_HAM")
    private String diffH1Ham;
    @Size(max = 50)
    @Column(name = "DIAMETER_THROUGH_J_RING1")
    private String diameterThroughJRing1;
    @Size(max = 50)
    @Column(name = "DIAMETER_THROUGH_J_RING2")
    private String diameterThroughJRing2;
    @Size(max = 50)
    @Column(name = "J_RING_FLOW")
    private String jRingFlow;
    @Size(max = 50)
    @Column(name = "DIAMETER_WITHOUT_J_RING1")
    private String diameterWithoutJRing1;
    @Size(max = 50)
    @Column(name = "DIAMETER_WITHOUT_J_RING2")
    private String diameterWithoutJRing2;
    @Size(max = 50)
    @Column(name = "SLUMP_FLOW")
    private String slumpFlow;
    @Size(max = 50)
    @Column(name = "PASSING_ABILITY_SCC")
    private String passingAbilityScc;
    @Size(max = 50)
    @Column(name = "HEIGHT_INSIDE_J_RING1")
    private String heightInsideJRing1;
    @Size(max = 50)
    @Column(name = "HEIGHT_INSIDE_J_RING2")
    private String heightInsideJRing2;
    @Size(max = 50)
    @Column(name = "HEIGHT_INSIDE_J_RING3")
    private String heightInsideJRing3;
    @Size(max = 50)
    @Column(name = "HEIGHT_INSIDE_J_RING4")
    private String heightInsideJRing4;
    @Size(max = 50)
    @Column(name = "HAM")
    private String ham;
    @Size(max = 50)
    @Column(name = "HEIGHT_OUTSIDE_J_RING1")
    private String heightOutsideJRing1;
    @Size(max = 50)
    @Column(name = "HEIGHT_OUTSIDE_J_RING2")
    private String heightOutsideJRing2;
    @Size(max = 50)
    @Column(name = "HEIGHT_OUTSIDE_J_RING3")
    private String heightOutsideJRing3;
    @Size(max = 50)
    @Column(name = "HEIGHT_OUTSIDE_J_RING4")
    private String heightOutsideJRing4;
    @Size(max = 50)
    @Column(name = "HBM")
    private String hbm;
    @Size(max = 50)
    @Column(name = "HAB")
    private String hab;
    @Size(max = 50)
    @Column(name = "H1_HEIGHT_SCC_CENTER_RING")
    private String h1HeightSccCenterRing;
    @Size(max = 500)
    @Column(name = "SUBBIDITEM_DESCRIPT")
    private String subbiditemDescript;
    @Size(max = 500)
    @Column(name = "BIDITEM_DESCRIPT")
    private String biditemDescript;
    @Size(max = 71)
    @Column(name = "SAMPLE_TCN")
    private String sampleTcn;

    public DotSccT345() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Character getActive() {
        return active;
    }

    public void setActive(Character active) {
        this.active = active;
    }

    public Character getPeReview() {
        return peReview;
    }

    public void setPeReview(Character peReview) {
        this.peReview = peReview;
    }

    public Character getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(Character testClosed) {
        this.testClosed = testClosed;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateoftest() {
        return dateoftest;
    }

    public void setDateoftest(Date dateoftest) {
        this.dateoftest = dateoftest;
    }

    public Integer getSubbiditemId() {
        return subbiditemId;
    }

    public void setSubbiditemId(Integer subbiditemId) {
        this.subbiditemId = subbiditemId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getMixDesignId() {
        return mixDesignId;
    }

    public void setMixDesignId(Integer mixDesignId) {
        this.mixDesignId = mixDesignId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getQaSampleId() {
        return qaSampleId;
    }

    public void setQaSampleId(Integer qaSampleId) {
        this.qaSampleId = qaSampleId;
    }

    public Integer getBiditemId() {
        return biditemId;
    }

    public void setBiditemId(Integer biditemId) {
        this.biditemId = biditemId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getTestoNo() {
        return testoNo;
    }

    public void setTestoNo(String testoNo) {
        this.testoNo = testoNo;
    }

    public String getBiditemNo() {
        return biditemNo;
    }

    public void setBiditemNo(String biditemNo) {
        this.biditemNo = biditemNo;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEquipList() {
        return equipList;
    }

    public void setEquipList(String equipList) {
        this.equipList = equipList;
    }

    public String getTechId() {
        return techId;
    }

    public void setTechId(String techId) {
        this.techId = techId;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getMixdesignno() {
        return mixdesignno;
    }

    public void setMixdesignno(String mixdesignno) {
        this.mixdesignno = mixdesignno;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getTestResults() {
        return testResults;
    }

    public void setTestResults(String testResults) {
        this.testResults = testResults;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getLabPrep() {
        return labPrep;
    }

    public void setLabPrep(String labPrep) {
        this.labPrep = labPrep;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getjRingTestValue() {
        return jRingTestValue;
    }

    public void setjRingTestValue(String jRingTestValue) {
        this.jRingTestValue = jRingTestValue;
    }

    public String getDiffH1Ham() {
        return diffH1Ham;
    }

    public void setDiffH1Ham(String diffH1Ham) {
        this.diffH1Ham = diffH1Ham;
    }

    public String getDiameterThroughJRing1() {
        return diameterThroughJRing1;
    }

    public void setDiameterThroughJRing1(String diameterThroughJRing1) {
        this.diameterThroughJRing1 = diameterThroughJRing1;
    }

    public String getDiameterThroughJRing2() {
        return diameterThroughJRing2;
    }

    public void setDiameterThroughJRing2(String diameterThroughJRing2) {
        this.diameterThroughJRing2 = diameterThroughJRing2;
    }

    public String getjRingFlow() {
        return jRingFlow;
    }

    public void setjRingFlow(String jRingFlow) {
        this.jRingFlow = jRingFlow;
    }

    public String getDiameterWithoutJRing1() {
        return diameterWithoutJRing1;
    }

    public void setDiameterWithoutJRing1(String diameterWithoutJRing1) {
        this.diameterWithoutJRing1 = diameterWithoutJRing1;
    }

    public String getDiameterWithoutJRing2() {
        return diameterWithoutJRing2;
    }

    public void setDiameterWithoutJRing2(String diameterWithoutJRing2) {
        this.diameterWithoutJRing2 = diameterWithoutJRing2;
    }

    public String getSlumpFlow() {
        return slumpFlow;
    }

    public void setSlumpFlow(String slumpFlow) {
        this.slumpFlow = slumpFlow;
    }

    public String getPassingAbilityScc() {
        return passingAbilityScc;
    }

    public void setPassingAbilityScc(String passingAbilityScc) {
        this.passingAbilityScc = passingAbilityScc;
    }

    public String getHeightInsideJRing1() {
        return heightInsideJRing1;
    }

    public void setHeightInsideJRing1(String heightInsideJRing1) {
        this.heightInsideJRing1 = heightInsideJRing1;
    }

    public String getHeightInsideJRing2() {
        return heightInsideJRing2;
    }

    public void setHeightInsideJRing2(String heightInsideJRing2) {
        this.heightInsideJRing2 = heightInsideJRing2;
    }

    public String getHeightInsideJRing3() {
        return heightInsideJRing3;
    }

    public void setHeightInsideJRing3(String heightInsideJRing3) {
        this.heightInsideJRing3 = heightInsideJRing3;
    }

    public String getHeightInsideJRing4() {
        return heightInsideJRing4;
    }

    public void setHeightInsideJRing4(String heightInsideJRing4) {
        this.heightInsideJRing4 = heightInsideJRing4;
    }

    public String getHam() {
        return ham;
    }

    public void setHam(String ham) {
        this.ham = ham;
    }

    public String getHeightOutsideJRing1() {
        return heightOutsideJRing1;
    }

    public void setHeightOutsideJRing1(String heightOutsideJRing1) {
        this.heightOutsideJRing1 = heightOutsideJRing1;
    }

    public String getHeightOutsideJRing2() {
        return heightOutsideJRing2;
    }

    public void setHeightOutsideJRing2(String heightOutsideJRing2) {
        this.heightOutsideJRing2 = heightOutsideJRing2;
    }

    public String getHeightOutsideJRing3() {
        return heightOutsideJRing3;
    }

    public void setHeightOutsideJRing3(String heightOutsideJRing3) {
        this.heightOutsideJRing3 = heightOutsideJRing3;
    }

    public String getHeightOutsideJRing4() {
        return heightOutsideJRing4;
    }

    public void setHeightOutsideJRing4(String heightOutsideJRing4) {
        this.heightOutsideJRing4 = heightOutsideJRing4;
    }

    public String getHbm() {
        return hbm;
    }

    public void setHbm(String hbm) {
        this.hbm = hbm;
    }

    public String getHab() {
        return hab;
    }

    public void setHab(String hab) {
        this.hab = hab;
    }

    public String getH1HeightSccCenterRing() {
        return h1HeightSccCenterRing;
    }

    public void setH1HeightSccCenterRing(String h1HeightSccCenterRing) {
        this.h1HeightSccCenterRing = h1HeightSccCenterRing;
    }

    public String getSubbiditemDescript() {
        return subbiditemDescript;
    }

    public void setSubbiditemDescript(String subbiditemDescript) {
        this.subbiditemDescript = subbiditemDescript;
    }

    public String getBiditemDescript() {
        return biditemDescript;
    }

    public void setBiditemDescript(String biditemDescript) {
        this.biditemDescript = biditemDescript;
    }

    public String getSampleTcn() {
        return sampleTcn;
    }

    public void setSampleTcn(String sampleTcn) {
        this.sampleTcn = sampleTcn;
    }

    @JsonSkipXssSerialization
    public String getTestNoLinkFix() {
        if (StringSupport.isNotNullAndNotEmpty(testNoLink) && testNoLink.contains("../../")) {
            return testNoLink.replaceAll("\\.\\.\\/\\.\\.\\/", "/cc/qm/");
        }
        return testNoLink;
    }
}
