/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper;

import com.atser.tools.atserutil.objects.bo.glob.GlobProjectSpecsSoilCompBO;
import com.atser.tools.atserutil.objects.bo.qa.QaconcMixdesignsBO;
import com.atser.tools.atserutil.objects.bo.view.VwProctorAttLimitBO;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 *
 * @author droldan
 */
public class DispatchPrintWOPojo {

    private String technician;
    // This serviceDate is for the WO
    private String serviceDate;
    private String serviceDateCall;
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
    private String reqQty;
    private String mixDesign;
    private String batchPlant;
    private BufferedImage projectLogo;
    private String traceNo;
    // This isCancel is for the WO
    private Boolean isCancel;
    private Boolean isCallCancel;
    private String techCertification;
    private String location;
    private String hours;
    private String totalhours;
    private String paperwork;
    private String projectClientName;
    private String labFunction;
    private String assigment;
    private String woLong;
    private String projectDirections;
    private String projectAddress;
    private String dateCalledIn;
    private String timeCalledIn;
    private List<GlobProjectSpecsSoilCompBO> soilCompList;
    private List<VwProctorAttLimitBO> proctorList;
    private List<QaconcMixdesignsBO> concMixDesigList;

    public DispatchPrintWOPojo() {
    }

    public DispatchPrintWOPojo(String technician, String serviceDate, String timeReqOffice, String timeReqSite, String requestedBy, String created, String projectManager, String projectNo, String woNo, String contactPerson, String contactTelephone, String projectDescription, String servicesRequested, String specialInstructions, String reqQty, String mixDesign, String batchPlant, BufferedImage projectLogo, String traceNo, Boolean iscancel, String certification, String location) {
        this.technician = technician;
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
        this.reqQty = reqQty;
        this.mixDesign = mixDesign;
        this.batchPlant = batchPlant;
        this.projectLogo = projectLogo;
        this.traceNo = traceNo;
        this.isCancel = iscancel;
        this.techCertification = certification;
        this.location = location;
    }

    public String getProjectDirections() {
        return projectDirections;
    }

    public void setProjectDirections(String projectDirections) {
        this.projectDirections = projectDirections;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getDateCalledIn() {
        return dateCalledIn;
    }

    public void setDateCalledIn(String dateCalledIn) {
        this.dateCalledIn = dateCalledIn;
    }

    public String getTimeCalledIn() {
        return timeCalledIn;
    }

    public void setTimeCalledIn(String timeCalledIn) {
        this.timeCalledIn = timeCalledIn;
    }

    public String getWoLong() {
        return woLong;
    }

    public void setWoLong(String woLong) {
        this.woLong = woLong;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public String getAssigment() {
        return assigment;
    }

    public void setAssigment(String assigment) {
        this.assigment = assigment;
    }

    public String getProjectClientName() {
        return projectClientName;
    }

    public void setProjectClientName(String projectClientName) {
        this.projectClientName = projectClientName;
    }

    public String getServiceDateCall() {
        return serviceDateCall;
    }

    public void setServiceDateCall(String serviceDateCall) {
        this.serviceDateCall = serviceDateCall;
    }

    public Boolean getIsCallCancel() {
        return isCallCancel;
    }

    public void setIsCallCancel(Boolean isCallCancel) {
        this.isCallCancel = isCallCancel;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getTotalhours() {
        return totalhours;
    }

    public void setTotalhours(String totalhours) {
        this.totalhours = totalhours;
    }

    public String getPaperwork() {
        return paperwork;
    }

    public void setPaperwork(String paperwork) {
        this.paperwork = paperwork;
    }

    public String getTechCertification() {
        return techCertification;
    }

    public void setTechCertification(String techCertification) {
        this.techCertification = techCertification;
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

    public String getTechnician() {
        return technician;
    }

    public void setTechnician(String technician) {
        this.technician = technician;
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

    public String getReqQty() {
        return reqQty;
    }

    public void setReqQty(String reqQty) {
        this.reqQty = reqQty;
    }

    public String getMixDesign() {
        return mixDesign;
    }

    public void setMixDesign(String mixDesign) {
        this.mixDesign = mixDesign;
    }

    public String getBatchPlant() {
        return batchPlant;
    }

    public void setBatchPlant(String batchPlant) {
        this.batchPlant = batchPlant;
    }

    public BufferedImage getProjectLogo() {
        return projectLogo;
    }

    public void setProjectLogo(BufferedImage projectLogo) {
        this.projectLogo = projectLogo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<GlobProjectSpecsSoilCompBO> getSoilCompList() {
        return soilCompList;
    }

    public void setSoilCompList(List<GlobProjectSpecsSoilCompBO> soilCompList) {
        this.soilCompList = soilCompList;
    }

    public List<VwProctorAttLimitBO> getProctorList() {
        return proctorList;
    }

    public void setProctorList(List<VwProctorAttLimitBO> proctorList) {
        this.proctorList = proctorList;
    }

    public List<QaconcMixdesignsBO> getConcMixDesigList() {
        return concMixDesigList;
    }

    public void setConcMixDesigList(List<QaconcMixdesignsBO> concMixDesigList) {
        this.concMixDesigList = concMixDesigList;
    }
}
