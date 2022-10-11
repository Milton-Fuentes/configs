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
@Table(name = "SCB_AGG_SANDEQ", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbAggSandEq.findAll", query = "SELECT a FROM ScbAggSandEq a")})
public class ScbAggSandEq implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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
    @Column(name = "TEST_ID")
    private BigInteger testId;
    @Column(name = "TEST_NO")
    private BigInteger testNo;
    @Size(max = 255)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 255)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Size(max = 30)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "TEST_CLOSED")
    private Character testClosed;
    @Column(name = "PE_REVIEW")
    private Character peReview;
    @Size(max = 50)
    @Column(name = "TEST_REPORT_NO")
    private String testReportNo;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @JsonSkipXssSerialization
    @Size(max = 175)
    @Column(name = "TESTNO_LINK")
    private String testNoLink;
    @Size(max = 61)
    @Column(name = "TCN_TRIALNO")
    private String tcnTrialno;
    @Size(max = 50)
    @Column(name = "TIMESTART")
    private String timestart;
    @Size(max = 50)
    @Column(name = "TEN_MIN")
    private String tenMin;
    @Size(max = 50)
    @Column(name = "TWENTY_MIN")
    private String twentyMin;
    @Size(max = 50)
    @Column(name = "TIMEEND")
    private String timeend;
    @Size(max = 50)
    @Column(name = "TOPSAND")
    private String topsand;
    @Size(max = 50)
    @Column(name = "TOPSOIL")
    private String topsoil;
    @Size(max = 50)
    @Column(name = "SANDEQUIV")
    private String sandequiv;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;

    public ScbAggSandEq() {
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

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getTestNo() {
        return testNo;
    }

    public void setTestNo(BigInteger testNo) {
        this.testNo = testNo;
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

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTestReportNo() {
        return testReportNo;
    }

    public void setTestReportNo(String testReportNo) {
        this.testReportNo = testReportNo;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
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

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public String getTestNoLink() {
        return testNoLink;
    }

    public void setTestNoLink(String testNoLink) {
        this.testNoLink = testNoLink;
    }

    public String getTcnTrialno() {
        return tcnTrialno;
    }

    public void setTcnTrialno(String tcnTrialno) {
        this.tcnTrialno = tcnTrialno;
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTenMin() {
        return tenMin;
    }

    public void setTenMin(String tenMin) {
        this.tenMin = tenMin;
    }

    public String getTwentyMin() {
        return twentyMin;
    }

    public void setTwentyMin(String twentyMin) {
        this.twentyMin = twentyMin;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public String getTopsand() {
        return topsand;
    }

    public void setTopsand(String topsand) {
        this.topsand = topsand;
    }

    public String getTopsoil() {
        return topsoil;
    }

    public void setTopsoil(String topsoil) {
        this.topsoil = topsoil;
    }

    public String getSandequiv() {
        return sandequiv;
    }

    public void setSandequiv(String sandequiv) {
        this.sandequiv = sandequiv;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
