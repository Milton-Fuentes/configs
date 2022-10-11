/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.project;

import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class ProjectBO {

    private BigInteger id;
    private String number;
    private String name;
    private String type;
    private String programName;
    private String status;
    private String location;
    private BigInteger locationId;
    private String description;
    private String phase;
    private String projectNo;
    private String contratorName;
    private String endDate;
    private String region;
    private BigInteger contractorId;
    private BigInteger regionId;
    private String division;
    private BigInteger divisionId;
    private BigInteger projectClientId;
    private String departmentId;
    private BigInteger personProjectManager;

    public ProjectBO() {
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BigInteger getLocationId() {
        return locationId;
    }

    public void setLocationId(BigInteger locationId) {
        this.locationId = locationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getContratorName() {
        return contratorName;
    }

    public void setContratorName(String contratorName) {
        this.contratorName = contratorName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public BigInteger getContractorId() {
        return contractorId;
    }

    public void setContractorId(BigInteger contractorId) {
        this.contractorId = contractorId;
    }

    public BigInteger getRegionId() {
        return regionId;
    }

    public void setRegionId(BigInteger regionId) {
        this.regionId = regionId;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public BigInteger getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(BigInteger divisionId) {
        this.divisionId = divisionId;
    }

    public BigInteger getProjectClientId() {
        return projectClientId;
    }

    public void setProjectClientId(BigInteger projectClientId) {
        this.projectClientId = projectClientId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public BigInteger getPersonProjectManager() {
        return personProjectManager;
    }

    public void setPersonProjectManager(BigInteger personProjectManager) {
        this.personProjectManager = personProjectManager;
    }

    public String getProjectFullName() {
        if(StringSupport.isNotNullAndNotEmpty(this.number)) {
            if(StringSupport.isNotNullAndNotEmpty(this.name)) {
                return "[ " + this.number + " ] " + this.name;
            } else {
                return "[ " + this.number + " ] " + this.description;
            }
        } else {
            if(StringSupport.isNotNullAndNotEmpty(this.name)) {
                return this.name;
            } else {
                return this.description;
            }
        }
    }
}
