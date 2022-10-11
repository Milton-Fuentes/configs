/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper.qm.summaryreport;

import java.awt.image.BufferedImage;

/**
 *
 * @author droldan
 */
public class VwDailyInspPojo {
    
    private String pName;
    private String projectNo;
    private String reportNo;
    private String reportDate;
    private String dateOfTest;
    private String status;
    private String testNo;
    private String inspectorId;
    private String firm;
    private String inspName;
    private String startTime;
    private String endTime;
    private String lunchDuration;
    private String traceNo;
    private String cmLocation;
    private String totalHrs;
    private BufferedImage projectLogo;

    public VwDailyInspPojo() {
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

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(String dateOfTest) {
        this.dateOfTest = dateOfTest;
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

    public String getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(String totalHrs) {
        this.totalHrs = totalHrs;
    }

    public BufferedImage getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(BufferedImage projectLogo) {
        this.projectLogo = projectLogo;
    }
}
