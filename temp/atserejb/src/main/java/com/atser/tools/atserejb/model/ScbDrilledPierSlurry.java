/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

import com.atser.tools.atserutil.jackson.annotations.JsonSkipXssSerialization;
import com.atser.tools.atserutil.jackson.deserializer.JsonDateDeserialize;
import com.atser.tools.atserutil.jackson.serializer.JsonDateSerializer;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Immutable;

/**
 *
 * @author droldan
 */
@Entity
@Immutable
@Table(name = "SCB_DRILLEDPIER_SLURRY", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbDrilledPierSlurry.findAll", query = "SELECT a FROM ScbDrilledPierSlurry a")})
public class ScbDrilledPierSlurry implements Serializable {

    private static final long serialVersionUID = 1L;
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampletestid;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "LAB_ID")
    private BigInteger labId;
    @Column(name = "FUNCTION_ID")
    private BigInteger functionId;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Size(max = 50)
    @Column(name = "LAB_FUNCTION")
    private String labFunction;
    @JsonSkipXssSerialization
    @Id
    @Size(max = 188)
    @Column(name = "TESTNO")
    private String testNoLink;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Size(max = 50)
    @Column(name = "TEST_TYPE")
    private String testType;
    @Size(max = 50)
    @Column(name = "NO_SHAFTS")
    private String noShafts;
    @Size(max = 50)
    @Column(name = "PUMP_PRESSURE")
    private String pumpPressure;
    @Size(max = 50)
    @Column(name = "BENTONITE_TYPE")
    private String bentoniteType;
    @Size(max = 50)
    @Column(name = "ACTUAL_SLURRY")
    private String actualSlurry;
    @Size(max = 50)
    @Column(name = "NO")
    private String no;
    @Size(max = 255)
    @Column(name = "DRILLEDPIERLOCATION")
    private String drilledPierLocation;
    @Size(max = 255)
    @Column(name = "SHAFTDIAMETER")
    private String shaftdiameter;
    @Size(max = 255)
    @Column(name = "BELLDIAMETER")
    private String belldiameter;
    @Size(max = 255)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "SAMPLE_DEPTH")
    private String sampleDepth;
    @Size(max = 50)
    @Column(name = "WET_TIME_TAKEN")
    private String wetTimeTaken;
    @Size(max = 50)
    @Column(name = "WET_TEMP")
    private String wetTemp;
    @Size(max = 50)
    @Column(name = "WET_AMB_SAMPLE")
    private String wetAmbSample;
    @Size(max = 50)
    @Column(name = "WET_SG")
    private String wetSg;
    @Size(max = 50)
    @Column(name = "WET_VISCOSITY")
    private String wetViscosity;
    @Size(max = 50)
    @Column(name = "WET_PH")
    private String wetPh;
    @Size(max = 50)
    @Column(name = "WET_SAND_CONTENT")
    private String wetSandContent;
    @Size(max = 4000)
    @Column(name = "TEST_REMARKS")
    private String testRemarks;

    public ScbDrilledPierSlurry() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampletestid() {
        return sampletestid;
    }

    public void setSampletestid(BigInteger sampletestid) {
        this.sampletestid = sampletestid;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public BigInteger getFunctionId() {
        return functionId;
    }

    public void setFunctionId(BigInteger functionId) {
        this.functionId = functionId;
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

    public String getLabname() {
        return labname;
    }

    public void setLabname(String labname) {
        this.labname = labname;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCmLocation() {
        return cmLocation;
    }

    public void setCmLocation(String cmLocation) {
        this.cmLocation = cmLocation;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }

    public String getNoShafts() {
        return noShafts;
    }

    public void setNoShafts(String noShafts) {
        this.noShafts = noShafts;
    }

    public String getPumpPressure() {
        return pumpPressure;
    }

    public void setPumpPressure(String pumpPressure) {
        this.pumpPressure = pumpPressure;
    }

    public String getBentoniteType() {
        return bentoniteType;
    }

    public void setBentoniteType(String bentoniteType) {
        this.bentoniteType = bentoniteType;
    }

    public String getActualSlurry() {
        return actualSlurry;
    }

    public void setActualSlurry(String actualSlurry) {
        this.actualSlurry = actualSlurry;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDrilledPierLocation() {
        return drilledPierLocation;
    }

    public void setDrilledPierLocation(String drilledPierLocation) {
        this.drilledPierLocation = drilledPierLocation;
    }

    public String getShaftdiameter() {
        return shaftdiameter;
    }

    public void setShaftdiameter(String shaftdiameter) {
        this.shaftdiameter = shaftdiameter;
    }

    public String getBelldiameter() {
        return belldiameter;
    }

    public void setBelldiameter(String belldiameter) {
        this.belldiameter = belldiameter;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getSampleDepth() {
        return sampleDepth;
    }

    public void setSampleDepth(String sampleDepth) {
        this.sampleDepth = sampleDepth;
    }

    public String getWetTimeTaken() {
        return wetTimeTaken;
    }

    public void setWetTimeTaken(String wetTimeTaken) {
        this.wetTimeTaken = wetTimeTaken;
    }

    public String getWetTemp() {
        return wetTemp;
    }

    public void setWetTemp(String wetTemp) {
        this.wetTemp = wetTemp;
    }

    public String getWetAmbSample() {
        return wetAmbSample;
    }

    public void setWetAmbSample(String wetAmbSample) {
        this.wetAmbSample = wetAmbSample;
    }

    public String getWetSg() {
        return wetSg;
    }

    public void setWetSg(String wetSg) {
        this.wetSg = wetSg;
    }

    public String getWetViscosity() {
        return wetViscosity;
    }

    public void setWetViscosity(String wetViscosity) {
        this.wetViscosity = wetViscosity;
    }

    public String getWetPh() {
        return wetPh;
    }

    public void setWetPh(String wetPh) {
        this.wetPh = wetPh;
    }

    public String getWetSandContent() {
        return wetSandContent;
    }

    public void setWetSandContent(String wetSandContent) {
        this.wetSandContent = wetSandContent;
    }

    public String getTestRemarks() {
        return testRemarks;
    }

    public void setTestRemarks(String testRemarks) {
        this.testRemarks = testRemarks;
    }

}
