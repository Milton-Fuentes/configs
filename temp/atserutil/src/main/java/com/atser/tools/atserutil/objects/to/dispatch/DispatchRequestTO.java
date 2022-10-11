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
public class DispatchRequestTO {

    private BigInteger id;
    private BigInteger woId;
    private String woLong;
    private BigInteger regionId;
    private String departmentId;
    private BigInteger projectId;
    private BigInteger projectClientId;
    private BigInteger techId;
    private String certification;
    private BigInteger labFuncId;
    private String timeatsite;
    private BigDecimal hours;
    private String assigment;
    private String calledInBy;
    private String datetimeCalledIn;
    private String paperwork;
    private List<EngServiceTO> engService;
    private List<FieldServiceTO> fieldService;
    private List<LabServiceTO> labService;
    private String specialinstruction;
    private String serviceList;
    private Boolean dispatchIscancel;
    private Boolean woIscancel;
    private String callServiceDate;
    private String woServiceDate;
    private String wonumber;
    private BigInteger contactrefId;
    private BigInteger activityId;
    private String contactperson;
    private String contacttelephone;
    private String timeatoffice;
    private String techFullName;
    private String travelTime;
    private BigInteger personProjectManager;
    private BigInteger folderId;

    public DispatchRequestTO() {
        engService = new ArrayList<>();
        fieldService = new ArrayList<>();
        labService = new ArrayList<>();
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public BigInteger getActivityId() {
        return activityId;
    }

    public void setActivityId(BigInteger activityId) {
        this.activityId = activityId;
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getProjectClientId() {
        return projectClientId;
    }

    public void setProjectClientId(BigInteger projectClientId) {
        this.projectClientId = projectClientId;
    }

    public BigInteger getTechId() {
        return techId;
    }

    public void setTechId(BigInteger techId) {
        this.techId = techId;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public BigInteger getLabFuncId() {
        return labFuncId;
    }

    public void setLabFuncId(BigInteger labFuncId) {
        this.labFuncId = labFuncId;
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

    public String getAssigment() {
        return assigment;
    }

    public void setAssigment(String assigment) {
        this.assigment = assigment;
    }

    public String getCalledInBy() {
        return calledInBy;
    }

    public void setCalledInBy(String calledInBy) {
        this.calledInBy = calledInBy;
    }

    public String getDatetimeCalledIn() {
        return datetimeCalledIn;
    }

    public void setDatetimeCalledIn(String datetimeCalledIn) {
        this.datetimeCalledIn = datetimeCalledIn;
    }

    public String getPaperwork() {
        return paperwork;
    }

    public void setPaperwork(String paperwork) {
        this.paperwork = paperwork;
    }

    public String getSpecialinstruction() {
        return specialinstruction;
    }

    public void setSpecialinstruction(String specialinstruction) {
        this.specialinstruction = specialinstruction;
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

    public void addEngService(EngServiceTO item) {
        this.engService.add(item);
    }

    public void addFieldService(FieldServiceTO item) {
        this.fieldService.add(item);
    }

    public void addLabService(LabServiceTO item) {
        this.labService.add(item);
    }

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }

    public BigInteger getWoId() {
        return woId;
    }

    public void setWoId(BigInteger woId) {
        this.woId = woId;
    }

    public Boolean getDispatchIscancel() {
        return dispatchIscancel;
    }

    public void setDispatchIscancel(Boolean dispatchIscancel) {
        this.dispatchIscancel = dispatchIscancel;
    }

    public Boolean getWoIscancel() {
        return woIscancel;
    }

    public void setWoIscancel(Boolean woIscancel) {
        this.woIscancel = woIscancel;
    }

    public String getCallServiceDate() {
        return callServiceDate;
    }

    public void setCallServiceDate(String callServiceDate) {
        this.callServiceDate = callServiceDate;
    }

    public String getWoServiceDate() {
        return woServiceDate;
    }

    public void setWoServiceDate(String woServiceDate) {
        this.woServiceDate = woServiceDate;
    }

    public String getWonumber() {
        return wonumber;
    }

    public void setWonumber(String wonumber) {
        this.wonumber = wonumber;
    }

    public BigInteger getContactrefId() {
        return contactrefId;
    }

    public void setContactrefId(BigInteger contactrefId) {
        this.contactrefId = contactrefId;
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

    public String getTechFullName() {
        return techFullName;
    }

    public void setTechFullName(String techFullName) {
        this.techFullName = techFullName;
    }

    public String getWoLong() {
        return woLong;
    }

    public void setWoLong(String woLong) {
        this.woLong = woLong;
    }

    public BigInteger getPersonProjectManager() {
        return personProjectManager;
    }

    public void setPersonProjectManager(BigInteger personProjectManager) {
        this.personProjectManager = personProjectManager;
    }

    public String getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(String travelTime) {
        this.travelTime = travelTime;
    }

    public BigInteger getFolderId() {
        return folderId;
    }

    public void setFolderId(BigInteger folderId) {
        this.folderId = folderId;
    }
}
