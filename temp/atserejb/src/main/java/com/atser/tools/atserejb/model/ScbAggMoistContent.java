/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.model;

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
@Table(name = "SCB_AGG_MOISTCONTENT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbAggMoistContent.findAll", query = "SELECT a FROM ScbAggMoistContent a")})
public class ScbAggMoistContent implements Serializable {

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
    @Size(max = 184)
    @Column(name = "TESTNO_BORINGNO")
    private String testNoBoringno;
    @Size(max = 71)
    @Column(name = "TESTNO_BORINGNO1")
    private String testNoBoringno1;
    @Size(max = 50)
    @Column(name = "OVEN")
    private String oven;
    @Size(max = 50)
    @Column(name = "SIEVES")
    private String sieves;
    @Size(max = 50)
    @Column(name = "BALANCESCALE")
    private String balanceScale;
    @Size(max = 50)
    @Column(name = "BORINGNO")
    private String boringno;
    @Size(max = 50)
    @Column(name = "DEPTH")
    private String depth;
    @Size(max = 50)
    @Column(name = "SAMPLENO")
    private String sampleNo;
    @Size(max = 50)
    @Column(name = "DESCRIP_MAT")
    private String descripMat;
    @Size(max = 50)
    @Column(name = "CANNO")
    private String canNo;
    @Size(max = 50)
    @Column(name = "WETWTTARE")
    private String wetwttare;
    @Size(max = 50)
    @Column(name = "DRYWTTARE")
    private String drywttare;
    @Size(max = 50)
    @Column(name = "TAREWT")
    private String tarewt;
    @Size(max = 50)
    @Column(name = "DRYWT")
    private String drywt;
    @Size(max = 50)
    @Column(name = "WATERWT")
    private String waterwt;
    @Size(max = 50)
    @Column(name = "MOISTCONTENT")
    private String moistContent;
    @Size(max = 4000)
    @Column(name = "REMARKS")
    private String remarks;

    public ScbAggMoistContent() {
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

    public String getTestNoBoringno() {
        return testNoBoringno;
    }

    public void setTestNoBoringno(String testNoBoringno) {
        this.testNoBoringno = testNoBoringno;
    }

    public String getTestNoBoringno1() {
        return testNoBoringno1;
    }

    public void setTestNoBoringno1(String testNoBoringno1) {
        this.testNoBoringno1 = testNoBoringno1;
    }

    public String getOven() {
        return oven;
    }

    public void setOven(String oven) {
        this.oven = oven;
    }

    public String getSieves() {
        return sieves;
    }

    public void setSieves(String sieves) {
        this.sieves = sieves;
    }

    public String getBalanceScale() {
        return balanceScale;
    }

    public void setBalanceScale(String balanceScale) {
        this.balanceScale = balanceScale;
    }

    public String getBoringno() {
        return boringno;
    }

    public void setBoringno(String boringno) {
        this.boringno = boringno;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getDescripMat() {
        return descripMat;
    }

    public void setDescripMat(String descripMat) {
        this.descripMat = descripMat;
    }

    public String getCanNo() {
        return canNo;
    }

    public void setCanNo(String canNo) {
        this.canNo = canNo;
    }

    public String getWetwttare() {
        return wetwttare;
    }

    public void setWetwttare(String wetwttare) {
        this.wetwttare = wetwttare;
    }

    public String getDrywttare() {
        return drywttare;
    }

    public void setDrywttare(String drywttare) {
        this.drywttare = drywttare;
    }

    public String getTarewt() {
        return tarewt;
    }

    public void setTarewt(String tarewt) {
        this.tarewt = tarewt;
    }

    public String getDrywt() {
        return drywt;
    }

    public void setDrywt(String drywt) {
        this.drywt = drywt;
    }

    public String getWaterwt() {
        return waterwt;
    }

    public void setWaterwt(String waterwt) {
        this.waterwt = waterwt;
    }

    public String getMoistContent() {
        return moistContent;
    }

    public void setMoistContent(String moistContent) {
        this.moistContent = moistContent;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
