/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.qa;

import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigInteger;
import java.util.Map;

/**
 *
 * @author droldan
 */
public class QaSampleTestSearchBO {

    private BigInteger id;
    private String testName;
    private String jspPage;
    private String projectNumber;
    private String woNo;
    private BigInteger woShort;
    private String sampleNumber;
    private Integer testNo;
    private String serviceDate;
    private String approvedby;
    private String approvedDate;
    private String engApprovedby;
    private String engApprovedDate;
    private String version;
    private String unapproved;
    private String unapprovedBy;
    private String pendingapproved;
    private String pendingapprovedBy;
    private String acknowledgedby;
    private String reviewed;
    private String reviewedBy;
    private String alerted;
    private String alertedBy;
    private String rejected;
    private String rejectedBy;
    private String sampleId;
    private String active;
    private String testTable;
    private BigInteger testId;
    private String testDate;
    private String dateCompleted;
    private String officeLocation;
    private BigInteger deparmentId;
    private String projectCode;
    private String reportNo;
    private String contractorReportNo;
    private String approvalFlag;
    private String testNoHyperLink;
    private String reportPage;
    private BigInteger tableId;
    private String testClosed;
    private String techName;
    private String traceNo;
    private String docAttach;
    private String mixDesignNo;
    private String classification;
    private String concTestDays;
    private String peReview;
    private String testResultDeterm;
    private String materialUse;
    private String authorization;
    private String status;
    private String testResultDetermDisplay;
    private String hasTestData;

    public QaSampleTestSearchBO() {
        reportPage = "";
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getJspPage() {
        return jspPage;
    }

    public void setJspPage(String jspPage) {
        this.jspPage = jspPage;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getWoNo() {
        return woNo;
    }

    public void setWoNo(String woNo) {
        this.woNo = woNo;
    }

    public BigInteger getWoShort() {
        return woShort;
    }

    public void setWoShort(BigInteger woShort) {
        this.woShort = woShort;
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public Integer getTestNo() {
        return testNo;
    }

    public void setTestNo(Integer testNo) {
        this.testNo = testNo;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(String approvedby) {
        this.approvedby = approvedby;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUnapproved() {
        return unapproved;
    }

    public void setUnapproved(String unapproved) {
        this.unapproved = unapproved;
    }

    public String getUnapprovedBy() {
        return unapprovedBy;
    }

    public void setUnapprovedBy(String unapprovedBy) {
        this.unapprovedBy = unapprovedBy;
    }

    public String getPendingapproved() {
        return pendingapproved;
    }

    public void setPendingapproved(String pendingapproved) {
        this.pendingapproved = pendingapproved;
    }

    public String getPendingapprovedBy() {
        return pendingapprovedBy;
    }

    public void setPendingapprovedBy(String pendingapprovedBy) {
        this.pendingapprovedBy = pendingapprovedBy;
    }

    public String getAcknowledgedby() {
        return acknowledgedby;
    }

    public void setAcknowledgedby(String acknowledgedby) {
        this.acknowledgedby = acknowledgedby;
    }

    public String getReviewed() {
        return reviewed;
    }

    public void setReviewed(String reviewed) {
        this.reviewed = reviewed;
    }

    public String getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(String reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getAlerted() {
        return alerted;
    }

    public void setAlerted(String alerted) {
        this.alerted = alerted;
    }

    public String getAlertedBy() {
        return alertedBy;
    }

    public void setAlertedBy(String alertedBy) {
        this.alertedBy = alertedBy;
    }

    public String getRejected() {
        return rejected;
    }

    public void setRejected(String rejected) {
        this.rejected = rejected;
    }

    public String getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(String rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getTestTable() {
        return testTable;
    }

    public void setTestTable(String testTable) {
        this.testTable = testTable;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public String getTestDate() {
        return testDate;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public BigInteger getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(BigInteger deparmentId) {
        this.deparmentId = deparmentId;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getContractorReportNo() {
        return contractorReportNo;
    }

    public void setContractorReportNo(String contractorReportNo) {
        this.contractorReportNo = contractorReportNo;
    }

    public void populateExtraVariables(Map<String, String> systemProp) {
        setApprovalFlag();
        setTestNoHyperLink();
        setReportPage();
        setAuthorization(systemProp);
        setStatus(systemProp);
        setTestResultDetermDisplay();
    }

    public String getApprovalFlag() {
        return approvalFlag;
    }

    private void setApprovalFlag() {
        if (StringSupport.isNotNullAndNotEmpty(approvedby) || (StringSupport.isNotNullAndNotEmpty(pendingapproved) && pendingapproved.toLowerCase().equals("y"))) {
            approvalFlag = "true";
        } else {
            approvalFlag = "false";
        }
    }

    public String getTestNoHyperLink() {
        return testNoHyperLink;
    }

    private void setTestNoHyperLink() {
        StringBuilder sbTestNoHyperLink = new StringBuilder();
        sbTestNoHyperLink.append(jspPage).append("?id=").append(id).append("&order=00000.00&sample=").append(sampleNumber)
                .append("&sampletest_id=").append(sampleId).append("&sub=null").append("&approval=").append(approvalFlag);
        testNoHyperLink = sbTestNoHyperLink.toString();
    }

    public BigInteger getTableId() {
        return tableId;
    }

    public void setTableId(BigInteger tableId) {
        this.tableId = tableId;
    }

    public String getReportPage() {
        return reportPage;
    }

    private void setReportPage() {
        if (jspPage.contains("test/")) {
            reportPage = "cr_" + StringSupport.matchAndGetString(jspPage, "test/(.*).jsp", 1) + "_report.jsp";
            reportPage = "test/test_report.jsp?test_table=" + testTable + "&jsp_name=" + reportPage + "&sample_test_id=" + id + "&id="; // + tableId;
        } else {
            reportPage = StringSupport.matchAndGetString(jspPage, "(.*).jsp", 1) + "_report.jsp?id="; // + tableId;
        }
    }

    public String getTestClosed() {
        return testClosed;
    }

    public void setTestClosed(String testClosed) {
        this.testClosed = testClosed;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public String getDocAttach() {
        return docAttach;
    }

    public void setDocAttach(String docAttach) {
        this.docAttach = docAttach;
    }

    public String getMixDesignNo() {
        return mixDesignNo;
    }

    public void setMixDesignNo(String mixDesignNo) {
        this.mixDesignNo = mixDesignNo;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getConcTestDays() {
        return concTestDays;
    }

    public void setConcTestDays(String concTestDays) {
        this.concTestDays = concTestDays;
    }

    public String getPeReview() {
        return peReview;
    }

    public void setPeReview(String peReview) {
        this.peReview = peReview;
    }

    public String getTestResultDeterm() {
        return testResultDeterm;
    }

    public void setTestResultDeterm(String testResultDeterm) {
        this.testResultDeterm = testResultDeterm;
    }

    public String getEngApprovedby() {
        return engApprovedby;
    }

    public void setEngApprovedby(String engApprovedby) {
        this.engApprovedby = engApprovedby;
    }

    public String getEngApprovedDate() {
        return engApprovedDate;
    }

    public void setEngApprovedDate(String engApprovedDate) {
        this.engApprovedDate = engApprovedDate;
    }

    public String getMaterialUse() {
        return materialUse;
    }

    public void setMaterialUse(String materialUse) {
        this.materialUse = materialUse;
    }

    public String getAuthorization() {
        return authorization;
    }

    public String getStatus() {
        return status;
    }

    public String getTestResultDetermDisplay() {
        return testResultDetermDisplay;
    }

    private void setAuthorization(Map<String, String> systemProp) {
        if (StringSupport.isNotNullAndNotEmpty(this.rejected) && this.rejected.toLowerCase().equals("y")) {
            this.authorization = rejectedBy;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.acknowledgedby) && StringSupport.isNotNullAndNotEmpty(this.unapproved) && this.unapproved.toLowerCase().equals("n")) {
            this.authorization = acknowledgedby;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.approvedby)) {
            this.authorization = approvedby;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.alerted) && this.alerted.toLowerCase().equals("y")) {
            this.authorization = alertedBy;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.unapproved) && this.unapproved.toLowerCase().equals("y")) {
            this.authorization = unapprovedBy;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.pendingapproved) && this.pendingapproved.toLowerCase().equals("y")) {
            this.authorization = pendingapprovedBy;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.reviewed) && this.reviewed.toLowerCase().equals("y")) {
            this.authorization = reviewedBy;
            return;
        }

        this.authorization = systemProp.get("sample_test.unsigned");
    }

    private void setStatus(Map<String, String> systemProp) {
        if (StringSupport.isNotNullAndNotEmpty(this.active) && this.active.toLowerCase().equals("n")) {
            this.status = systemProp.get("sample_test.inactive");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.rejected) && this.rejected.toLowerCase().equals("y")) {
            this.status = systemProp.get("sample_test.rejected");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.engApprovedby) && StringSupport.isNotNullAndNotEmpty(this.unapproved) && this.unapproved.toLowerCase().equals("n")) {
            this.status = systemProp.get("sample_test.engineer_approved");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.acknowledgedby) && StringSupport.isNotNullAndNotEmpty(this.unapproved) && this.unapproved.toLowerCase().equals("n")) {
            this.status = systemProp.get("sample_test.acknowledged");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.approvedby)) {
            this.status = systemProp.get("sample_test.approved");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.alerted) && this.alerted.toLowerCase().equals("y")) {
            this.status = systemProp.get("sample_test.alerted");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.unapproved) && this.unapproved.toLowerCase().equals("y")) {
            this.status = systemProp.get("sample_test.unapproved");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.pendingapproved) && this.pendingapproved.toLowerCase().equals("y")) {
            this.status = systemProp.get("sample_test.approvedpending");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.reviewed) && this.reviewed.toLowerCase().equals("y")) {
            this.status = systemProp.get("sample_test.reviewed");
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(this.dateCompleted)) {
            this.status = systemProp.get("sample_test.completed");
            return;
        }

        this.status = systemProp.get("sample_test.new");
    }

    private void setTestResultDetermDisplay() {
        if (StringSupport.isNotNullAndNotEmpty(testTable) && (testTable.equals("qaconc_compstr") || testTable.equals("qaconc_flexstr"))) {
            this.testResultDetermDisplay = null;
            return;
        }

        if (StringSupport.isNotNullAndNotEmpty(testResultDeterm)) {
            this.testResultDetermDisplay = this.testResultDeterm;
            return;
        }
        this.testResultDetermDisplay = "None";
    }

    public String getHasTestData() {
        return hasTestData;
    }

    public void setHasTestData(String hasTestData) {
        this.hasTestData = hasTestData;
    }
}
