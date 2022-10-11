/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.dispatch;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class WorkOrderTO {

    private BigInteger logId;
    private BigInteger woId;
    private BigDecimal hours;
    private BigInteger techRefId;
    private Boolean iscancel;
    private Long decisionFlag;
    private String serviceDate;
    private String paperworkReceived;
    private String assigment;
    private BigInteger info_id;
    private String wonumber;
    private BigInteger contactrefId;
    private String contactperson;
    private String contacttelephone;
    private String timeatoffice;
    private String timeatsite;
    private String specialinstruction;
    private List<EngServiceTO> engService;
    private List<FieldServiceTO> fieldService;
    private List<LabServiceTO> labService;
    private String techFullName;
    private String serviceList;
    private String certification;
    private String traceDescription;
    private String rlocation;
    private BigInteger projectId;
    private String projectName;
    private String projectNumber;
    private String functionName;
    private String labName;
    private BigInteger labId;
    private String requestedBy;
    private BigInteger regionId;
    private String travelTime;
    private String emailStatus;
    private BigInteger regionCatgColorId;
    private String isWoCompleted;
    private Integer unanswcount;
    private Integer answcount;
    private Integer submReport;
    private String testNameList;
    private BigInteger materialUseId;
    private String status;
    private String cancelledReason;

    public WorkOrderTO() {
        engService = new ArrayList<>();
        fieldService = new ArrayList<>();
        labService = new ArrayList<>();
        this.unanswcount = 0;
        this.submReport = 0;
    }

    public BigInteger getLogId() {
        return logId;
    }

    public void setLogId(BigInteger logId) {
        this.logId = logId;
    }

    public BigInteger getWoId() {
        return woId;
    }

    public void setWoId(BigInteger woId) {
        this.woId = woId;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getPaperworkReceived() {
        return paperworkReceived;
    }

    public void setPaperworkReceived(String paperworkReceived) {
        this.paperworkReceived = paperworkReceived;
    }

    public String getAssigment() {
        return assigment;
    }

    public void setAssigment(String assigment) {
        this.assigment = assigment;
    }

    public String getWonumber() {
        return wonumber;
    }

    public void setWonumber(String wonumber) {
        this.wonumber = wonumber;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getContacttelephone() {
        return contacttelephone;
    }

    public void setContacttelephone(String contacttelephone) {
        this.contacttelephone = contacttelephone;
    }

    public String getTimeatoffice() {
        return timeatoffice;
    }

    public void setTimeatoffice(String timeatoffice) {
        this.timeatoffice = timeatoffice;
    }

    public String getTimeatsite() {
        return timeatsite;
    }

    public void setTimeatsite(String timeatsite) {
        this.timeatsite = timeatsite;
    }

    public BigDecimal getHours() {
        return hours;
    }

    public void setHours(BigDecimal hours) {
        this.hours = hours;
    }

    public BigInteger getTechRefId() {
        return techRefId;
    }

    public void setTechRefId(BigInteger techRefId) {
        this.techRefId = techRefId;
    }

    public Long getDecisionFlag() {
        return decisionFlag;
    }

    public void setDecisionFlag(Long decisionFlag) {
        this.decisionFlag = decisionFlag;
    }

    public BigInteger getInfo_id() {
        return info_id;
    }

    public void setInfo_id(BigInteger info_id) {
        this.info_id = info_id;
    }

    public List<EngServiceTO> getEngService() {
        return engService;
    }

    public void setEngService(List<EngServiceTO> engService) {
        this.engService = engService;
    }

    public List<FieldServiceTO> getFieldService() {
        return fieldService;
    }

    public void setFieldService(List<FieldServiceTO> fieldService) {
        this.fieldService = fieldService;
    }

    public List<LabServiceTO> getLabService() {
        return labService;
    }

    public void setLabService(List<LabServiceTO> labService) {
        this.labService = labService;
    }

    public String getSpecialinstruction() {
        return specialinstruction;
    }

    public void setSpecialinstruction(String specialinstruction) {
        this.specialinstruction = specialinstruction;
    }

    public void addEngService(EngServiceTO item) {
        this.engService.add(item);
    }

    public void addFieldService(FieldServiceTO item) {
        this.fieldService.add(item);
    }

    public void addLabService(LabServiceTO item) {
        this.labService.add(item);
    }

    public Boolean getIscancel() {
        return iscancel;
    }

    public void setIscancel(Boolean iscancel) {
        this.iscancel = iscancel;
    }

    public String getTechFullName() {
        return techFullName;
    }

    public void setTechFullName(String techFullName) {
        this.techFullName = techFullName;
    }

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public BigInteger getContactrefId() {
        return contactrefId;
    }

    public void setContactrefId(BigInteger contactrefId) {
        this.contactrefId = contactrefId;
    }

    public String getTraceDescription() {
        return traceDescription;
    }

    public void setTraceDescription(String traceDescription) {
        this.traceDescription = traceDescription;
    }

    public String getRlocation() {
        return rlocation;
    }

    public void setRlocation(String rlocation) {
        this.rlocation = rlocation;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public BigInteger getLabId() {
        return labId;
    }

    public void setLabId(BigInteger labId) {
        this.labId = labId;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public BigInteger getRegionCatgColorId() {
        return regionCatgColorId;
    }

    public void setRegionCatgColorId(BigInteger regionCatgColorId) {
        this.regionCatgColorId = regionCatgColorId;
    }

    public String getIsWoCompleted() {
        return isWoCompleted;
    }

    public void setIsWoCompleted(String isWoCompleted) {
        this.isWoCompleted = isWoCompleted;
    }

    public Integer getUnanswcount() {
        return unanswcount;
    }

    public void setUnanswcount(Integer unanswcount) {
        this.unanswcount = unanswcount;
    }

    public Integer getAnswcount() {
        return answcount;
    }

    public void setAnswcount(Integer answcount) {
        this.answcount = answcount;
    }

    public Integer getSubmReport() {
        return submReport;
    }

    public void setSubmReport(Integer submReport) {
        this.submReport = submReport;
    }

    public String getTestNameList() {
        return testNameList;
    }

    public void setTestNameList(String testNameList) {
        this.testNameList = testNameList;
    }

    public BigInteger getMaterialUseId() {
        return materialUseId;
    }

    public void setMaterialUseId(BigInteger materialUseId) {
        this.materialUseId = materialUseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCancelledReason() {
        return cancelledReason;
    }

    public void setCancelledReason(String cancelledReason) {
        this.cancelledReason = cancelledReason;
    }
}
