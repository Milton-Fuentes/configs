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
@Table(name = "SCB_DAILY_REPORT", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ScbDailyReport.findAll", query = "SELECT a FROM ScbDailyReport a")})
public class ScbDailyReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Column(name = "SAMPLETEST_ID")
    private BigInteger sampleTestId;
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
    @Size(max = 4000)
    @Column(name = "WO_START_TIME")
    private String woStartTime;
    @Size(max = 6)
    @Column(name = "WO_END_TIME")
    private String woEndTime;
    @Size(max = 50)
    @Column(name = "LABNAME")
    private String labname;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 50)
    @Column(name = "DEPART_LAB")
    private String departLab;
    @Size(max = 50)
    @Column(name = "ARRIVE_SITE")
    private String arriveSite;
    @Size(max = 50)
    @Column(name = "LUNCH_HOURS")
    private String lunchHours;
    @Size(max = 50)
    @Column(name = "LUNCH_MINS")
    private String lunchMins;
    @Size(max = 101)
    @Column(name = "LUNCH")
    private String lunch;
    @Size(max = 50)
    @Column(name = "DEPART_SITE")
    private String departSite;
    @Size(max = 50)
    @Column(name = "ARRIVE_LAB")
    private String arriveLab;
    @Size(max = 50)
    @Column(name = "TOTAL_HOURS")
    private String totalHours;
    @Column(name = "MINIMUM_CHARGE")
    private Character minimumCharge;
    @Column(name = "TECHNICIAN_HOURS_OVERTIME")
    private BigDecimal technicianHoursOvertime;
    @Column(name = "TECH_ID")
    private BigInteger techId;
    @Size(max = 50)
    @Column(name = "LAB_FUNCTION")
    private String labFunction;
    @Size(max = 140)
    @Column(name = "TESTNO")
    private String testNo;
    @Size(max = 20)
    @Column(name = "TEST_NO")
    private String testNo1;
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
    @Size(max = 50)
    @Column(name = "REPORT_TYPE")
    private String reportType;
    @Size(max = 50)
    @Column(name = "SPECIFICATION")
    private String specification;
    @Size(max = 359)
    @Column(name = "TESTING_TECH")
    private String testingTech;
    @Column(name = "NONCERTIFIED")
    private Character nonCertified;

    public ScbDailyReport() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getSampleTestId() {
        return sampleTestId;
    }

    public void setSampleTestId(BigInteger sampleTestId) {
        this.sampleTestId = sampleTestId;
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

    public String getWoStartTime() {
        return woStartTime;
    }

    public void setWoStartTime(String woStartTime) {
        this.woStartTime = woStartTime;
    }

    public String getWoEndTime() {
        return woEndTime;
    }

    public void setWoEndTime(String woEndTime) {
        this.woEndTime = woEndTime;
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

    public String getDepartLab() {
        return departLab;
    }

    public void setDepartLab(String departLab) {
        this.departLab = departLab;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    public void setArriveSite(String arriveSite) {
        this.arriveSite = arriveSite;
    }

    public String getLunchHours() {
        return lunchHours;
    }

    public void setLunchHours(String lunchHours) {
        this.lunchHours = lunchHours;
    }

    public String getLunchMins() {
        return lunchMins;
    }

    public void setLunchMins(String lunchMins) {
        this.lunchMins = lunchMins;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDepartSite() {
        return departSite;
    }

    public void setDepartSite(String departSite) {
        this.departSite = departSite;
    }

    public String getArriveLab() {
        return arriveLab;
    }

    public void setArriveLab(String arriveLab) {
        this.arriveLab = arriveLab;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public Character getMinimumCharge() {
        return minimumCharge;
    }

    public void setMinimumCharge(Character minimumCharge) {
        this.minimumCharge = minimumCharge;
    }

    public BigDecimal getTechnicianHoursOvertime() {
        return technicianHoursOvertime;
    }

    public void setTechnicianHoursOvertime(BigDecimal technicianHoursOvertime) {
        this.technicianHoursOvertime = technicianHoursOvertime;
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

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getTestNo1() {
        return testNo1;
    }

    public void setTestNo1(String testNo1) {
        this.testNo1 = testNo1;
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

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getTestingTech() {
        return testingTech;
    }

    public void setTestingTech(String testingTech) {
        this.testingTech = testingTech;
    }

    public Character getNonCertified() {
        return nonCertified;
    }

    public void setNonCertified(Character nonCertified) {
        this.nonCertified = nonCertified;
    }
}
