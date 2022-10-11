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
@Table(name = "SCB_CROSSHOLESONIC", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbCrossHoleSonic.findAll", query = "SELECT a FROM ScbCrossHoleSonic a")})
public class ScbCrossHoleSonic implements Serializable {

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
    @Size(max = 109)
    @Column(name = "TEST_DOC")
    private String testDoc;
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
    @Size(max = 184)
    @Column(name = "TESTNO_LINK")
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
    @Column(name = "NO_TUBES")
    private String noTubes;
    @Size(max = 50)
    @Column(name = "DRILLED_SHAFT_NO")
    private String drilledShaftNo;
    @Size(max = 50)
    @Column(name = "GRADE")
    private String grade;
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Size(max = 61)
    @Column(name = "TCN_TRIALNO")
    private String tcnTrialNo;
    @Size(max = 255)
    @Column(name = "PILE")
    private String pile;
    @Size(max = 255)
    @Column(name = "PROF")
    private String prof;
    @Size(max = 255)
    @Column(name = "DISTANCE")
    private String distance;
    @Size(max = 255)
    @Column(name = "AVG_AT")
    private String avgAt;
    @Size(max = 255)
    @Column(name = "AVG_WS")
    private String avgWs;
    @Size(max = 255)
    @Column(name = "STANDARD_DEV")
    private String standardDev;
    @Size(max = 255)
    @Column(name = "DISCRETE_COEFF")
    private String discreteCoeff;
    @Size(max = 255)
    @Column(name = "MAX_PSD")
    private String maxPsd;
    @Size(max = 4000)
    @Column(name = "TEST_REMARKS")
    private String testRemarks;

    public ScbCrossHoleSonic() {
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

    public String getTestDoc() {
        return testDoc;
    }

    public void setTestDoc(String testDoc) {
        this.testDoc = testDoc;
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

    public String getNoTubes() {
        return noTubes;
    }

    public void setNoTubes(String noTubes) {
        this.noTubes = noTubes;
    }

    public String getDrilledShaftNo() {
        return drilledShaftNo;
    }

    public void setDrilledShaftNo(String drilledShaftNo) {
        this.drilledShaftNo = drilledShaftNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getTcnTrialNo() {
        return tcnTrialNo;
    }

    public void setTcnTrialNo(String tcnTrialNo) {
        this.tcnTrialNo = tcnTrialNo;
    }

    public String getPile() {
        return pile;
    }

    public void setPile(String pile) {
        this.pile = pile;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAvgAt() {
        return avgAt;
    }

    public void setAvgAt(String avgAt) {
        this.avgAt = avgAt;
    }

    public String getAvgWs() {
        return avgWs;
    }

    public void setAvgWs(String avgWs) {
        this.avgWs = avgWs;
    }

    public String getStandardDev() {
        return standardDev;
    }

    public void setStandardDev(String standardDev) {
        this.standardDev = standardDev;
    }

    public String getDiscreteCoeff() {
        return discreteCoeff;
    }

    public void setDiscreteCoeff(String discreteCoeff) {
        this.discreteCoeff = discreteCoeff;
    }

    public String getMaxPsd() {
        return maxPsd;
    }

    public void setMaxPsd(String maxPsd) {
        this.maxPsd = maxPsd;
    }

    public String getTestRemarks() {
        return testRemarks;
    }

    public void setTestRemarks(String testRemarks) {
        this.testRemarks = testRemarks;
    }

}
