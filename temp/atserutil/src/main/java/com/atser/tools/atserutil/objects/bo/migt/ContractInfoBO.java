/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.migt;

import java.io.Serializable;

/**
 *
 * @author droldan
 */
public class ContractInfoBO implements Serializable {

    private Long id;
    private String contractNo;
    private String projectNo;
    private String location;
    private String contractDescription;
    private String contractStatus;
    private String contractType;
    private String federalAidNumber;
    private String parsNumbers;
    private String ntpDate;
    private String estimatedCompetionDate;
    private String vendor;
    private String residentEngineer;
    private String residentEngineerEmail;
    private Long residentEngineerId;
    private String district;
    private String contractTotalValue;
    private String fieldOfficePhone;
    private String fieldOfficeAddress;
    private String fieldOfficeCityStateZip;
    private String status;
    private String rejectReason;
    private String projectType;

    public ContractInfoBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getNtpDate() {
        return ntpDate;
    }

    public void setNtpDate(String ntpDate) {
        this.ntpDate = ntpDate;
    }

    public String getContractDescription() {
        return contractDescription;
    }

    public void setContractDescription(String contractDescription) {
        this.contractDescription = contractDescription;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getParsNumbers() {
        return parsNumbers;
    }

    public void setParsNumbers(String parsNumbers) {
        this.parsNumbers = parsNumbers;
    }

    public String getFederalAidNumber() {
        return federalAidNumber;
    }

    public void setFederalAidNumber(String federalAidNumber) {
        this.federalAidNumber = federalAidNumber;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getResidentEngineer() {
        return residentEngineer;
    }

    public void setResidentEngineer(String residentEngineer) {
        this.residentEngineer = residentEngineer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getContractTotalValue() {
        return contractTotalValue;
    }

    public void setContractTotalValue(String contractTotalValue) {
        this.contractTotalValue = contractTotalValue;
    }

    public String getFieldOfficePhone() {
        return fieldOfficePhone;
    }

    public void setFieldOfficePhone(String fieldOfficePhone) {
        this.fieldOfficePhone = fieldOfficePhone;
    }

    public String getFieldOfficeAddress() {
        return fieldOfficeAddress;
    }

    public void setFieldOfficeAddress(String fieldOfficeAddress) {
        this.fieldOfficeAddress = fieldOfficeAddress;
    }

    public String getFieldOfficeCityStateZip() {
        return fieldOfficeCityStateZip;
    }

    public void setFieldOfficeCityStateZip(String fieldOfficeCityStateZip) {
        this.fieldOfficeCityStateZip = fieldOfficeCityStateZip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getEstimatedCompetionDate() {
        return estimatedCompetionDate;
    }

    public void setEstimatedCompetionDate(String estimatedCompetionDate) {
        this.estimatedCompetionDate = estimatedCompetionDate;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getResidentEngineerEmail() {
        return residentEngineerEmail;
    }

    public void setResidentEngineerEmail(String residentEngineerEmail) {
        this.residentEngineerEmail = residentEngineerEmail;
    }

    public Long getResidentEngineerId() {
        return residentEngineerId;
    }

    public void setResidentEngineerId(Long residentEngineerId) {
        this.residentEngineerId = residentEngineerId;
    }

    @Override
    public String toString() {
        return "ContractInfoBO{" + "id=" + id + ", contractNo=" + contractNo + '}';
    }
    
    
}
