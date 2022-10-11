/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper;

import java.awt.image.BufferedImage;

/**
 *
 * @author droldan
 */
public class InspDispatchPrintWOPojo {

    private String inspector;
    private String serviceDate;
    private String timeReqOffice;
    private String timeReqSite;
    private String requestedBy;
    private String created;
    private String projectManager;
    private String projectNo;
    private String woNo;
    private String contactPerson;
    private String contactTelephone;
    private String projectDescription;
    private String servicesRequested;
    private String specialInstructions;
    private String location;
    private BufferedImage projectLogo;
    private String traceNo;
    private Boolean isCancel;

    public InspDispatchPrintWOPojo() {
    }

    public InspDispatchPrintWOPojo(String inspector, String serviceDate, String timeReqOffice, String timeReqSite, String requestedBy, String created, String projectManager, String projectNo, String woNo, String contactPerson, String contactTelephone, String projectDescription, String servicesRequested, String specialInstructions, BufferedImage projectLogo, String traceNo, Boolean isCancel, String location) {
        this.inspector = inspector;
        this.serviceDate = serviceDate;
        this.timeReqOffice = timeReqOffice;
        this.timeReqSite = timeReqSite;
        this.requestedBy = requestedBy;
        this.created = created;
        this.projectManager = projectManager;
        this.projectNo = projectNo;
        this.woNo = woNo;
        this.contactPerson = contactPerson;
        this.contactTelephone = contactTelephone;
        this.projectDescription = projectDescription;
        this.servicesRequested = servicesRequested;
        this.specialInstructions = specialInstructions;
        this.projectLogo = projectLogo;
        this.traceNo = traceNo;
        this.isCancel = isCancel;
        this.location = location;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getTimeReqOffice() {
        return timeReqOffice;
    }

    public void setTimeReqOffice(String timeReqOffice) {
        this.timeReqOffice = timeReqOffice;
    }

    public String getTimeReqSite() {
        return timeReqSite;
    }

    public void setTimeReqSite(String timeReqSite) {
        this.timeReqSite = timeReqSite;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getWoNo() {
        return woNo;
    }

    public void setWoNo(String woNo) {
        this.woNo = woNo;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(String contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(String servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public BufferedImage getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(BufferedImage projectLogo) {
        this.projectLogo = projectLogo;
    }

    public String getTraceNo() {
        return traceNo;
    }

    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }

    public Boolean getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Boolean isCancel) {
        this.isCancel = isCancel;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
