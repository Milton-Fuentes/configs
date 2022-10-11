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
@Table(name = "VW_DAILY_INSP", catalog = "", schema = "ORACLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwDailyInsp.findAll", query = "SELECT a FROM VwDailyInsp a")})
public class VwDailyInsp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @NotNull
    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;
    @Column(name = "PROJECT_ID")
    private BigInteger projectId;
    @Column(name = "CLIENT_ID")
    private BigInteger clientId;
    @Size(max = 255)
    @Column(name = "P_NAME")
    private String pName;
    @Size(max = 25)
    @Column(name = "PROJECT_NO")
    private String projectNo;
    @Size(max = 255)
    @Column(name = "REPORT_NO")
    private String reportNo;
    @NotNull
    @Column(name = "REPORT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reportDate;
    @NotNull
    @Column(name = "DATEOFTEST")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfTest;
    @Column(name = "LEADINSP_ID")
    private BigInteger leadInspId;
    @JsonSkipXssSerialization
    @Size(max = 430)
    @Column(name = "REPORT_NO_LINK")
    private String reportNoLink;
    @Size(max = 8)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "TEST_NO")
    private String testNo;
    @Size(max = 50)
    @Column(name = "INSPECTOR_ID")
    private String inspectorId;
    @Size(max = 200)
    @Column(name = "FIRM")
    private String firm;
    @Size(max = 101)
    @Column(name = "INSP_NAME")
    private String inspName;
    @Size(max = 4000)
    @Column(name = "STARTTIME")
    private String startTime;
    @Size(max = 4000)
    @Column(name = "ENDTIME")
    private String endTime;
    @Size(max = 50)
    @Column(name = "LUNCH_DURATION")
    private String lunchDuration;
    @Size(max = 4000)
    @Column(name = "TRACE_NO")
    private String traceNo;
    @Size(max = 4000)
    @Column(name = "CM_LOCATION")
    private String cmLocation;
    @Column(name = "TOTAL_HRS")
    private BigDecimal totalHrs;

    public VwDailyInsp() {
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getContractId() {
        return contractId;
    }

    public void setContractId(BigInteger contractId) {
        this.contractId = contractId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserialize.class)
    public Date getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(Date dateOfTest) {
        this.dateOfTest = dateOfTest;
    }

    public BigInteger getLeadInspId() {
        return leadInspId;
    }

    public void setLeadInspId(BigInteger leadInspId) {
        this.leadInspId = leadInspId;
    }

    public String getReportNoLink() {
        return reportNoLink;
    }

    public void setReportNoLink(String reportNoLink) {
        this.reportNoLink = reportNoLink;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getInspName() {
        return inspName;
    }

    public void setInspName(String inspName) {
        this.inspName = inspName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLunchDuration() {
        return lunchDuration;
    }

    public void setLunchDuration(String lunchDuration) {
        this.lunchDuration = lunchDuration;
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

    public BigDecimal getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(BigDecimal totalHrs) {
        this.totalHrs = totalHrs;
    }
}
