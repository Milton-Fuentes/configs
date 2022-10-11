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
public class InspWorkOrderTO {

    private BigInteger woId;
    private String wonumber;
    private String serviceDate;
    private String inspectorFullName;
    private String timeatoffice;
    private String timeatsite;
    private BigDecimal hours;
    private BigInteger contactrefId;
    private String contactperson;
    private String contacttelephone;
    private String specialinstruction;
    private String paperworkReceived;
    private String assigment;
    private Boolean iscancel;
    private BigInteger inspRefId;
    private BigInteger inspFuncId;
    private BigInteger decisionFlag;
    private List<EngServiceTO> engService;
    private List<FieldServiceTO> fieldService;
    private List<LabServiceTO> labService;
    private String serviceList;
    private String traceDescription;
    private String rlocation;

    public InspWorkOrderTO() {
        engService = new ArrayList<>();
        fieldService = new ArrayList<>();
        labService = new ArrayList<>();
    }

    public BigInteger getWoId() {
        return woId;
    }

    public void setWoId(BigInteger woId) {
        this.woId = woId;
    }

    public String getWonumber() {
        return wonumber;
    }

    public void setWonumber(String wonumber) {
        this.wonumber = wonumber;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getInspectorFullName() {
        return inspectorFullName;
    }

    public void setInspectorFullName(String inspectorFullName) {
        this.inspectorFullName = inspectorFullName;
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

    public String getSpecialinstruction() {
        return specialinstruction;
    }

    public void setSpecialinstruction(String specialinstruction) {
        this.specialinstruction = specialinstruction;
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

    public Boolean getIscancel() {
        return iscancel;
    }

    public void setIscancel(Boolean iscancel) {
        this.iscancel = iscancel;
    }

    public BigInteger getInspRefId() {
        return inspRefId;
    }

    public void setInspRefId(BigInteger inspRefId) {
        this.inspRefId = inspRefId;
    }

    public BigInteger getInspFuncId() {
        return inspFuncId;
    }

    public void setInspFuncId(BigInteger inspFuncId) {
        this.inspFuncId = inspFuncId;
    }

    public BigInteger getDecisionFlag() {
        return decisionFlag;
    }

    public void setDecisionFlag(BigInteger decisionFlag) {
        this.decisionFlag = decisionFlag;
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

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
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
}
