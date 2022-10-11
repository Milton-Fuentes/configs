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
@Table(name = "SCB_AGG_SV", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbAggSv.findAll", query = "SELECT a FROM ScbAggSv a")})
public class ScbAggSv implements Serializable {

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
    @Size(max = 130)
    @Column(name = "TESTNO_LINK")
    private String testNoLink;
    @Size(max = 50)
    @Column(name = "TOTALWT")
    private String totalwt;
    @Column(name = "SET_ID")
    private BigInteger setId;
    @Column(name = "SIEVE_ID")
    private BigInteger sieveId;
    @Size(max = 50)
    @Column(name = "SET_NAME")
    private String setName;
    @Size(max = 50)
    @Column(name = "SV_NAME")
    private String svName;
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
    @Column(name = "PROJREQUIRE")
    private String projRequire;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;

    public ScbAggSv() {
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

    public String getTotalwt() {
        return totalwt;
    }

    public void setTotalwt(String totalwt) {
        this.totalwt = totalwt;
    }

    public BigInteger getSetId() {
        return setId;
    }

    public void setSetId(BigInteger setId) {
        this.setId = setId;
    }

    public BigInteger getSieveId() {
        return sieveId;
    }

    public void setSieveId(BigInteger sieveId) {
        this.sieveId = sieveId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getSvName() {
        return svName;
    }

    public void setSvName(String svName) {
        this.svName = svName;
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

    public String getProjRequire() {
        return projRequire;
    }

    public void setProjRequire(String projRequire) {
        this.projRequire = projRequire;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
