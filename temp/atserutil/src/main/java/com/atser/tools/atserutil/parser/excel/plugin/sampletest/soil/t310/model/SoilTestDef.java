/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.section.nysdot.SectionT310Test;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author droldan
 */
public class SoilTestDef implements Serializable {

    @Expose
    private String sampleNumber;
    @Expose
    private String projectNo;
    @Expose
    private Date sampleDate;
    @Expose
    private Date loggedDate;
    @Expose
    private String labFunction;
    @Expose
    private String sampleBy;
    @Expose
    private String specItem;
    @Expose
    private String material;
    @Expose
    private String classType;
    @Expose
    private String sampleLocation;
    @Expose
    private String sampleOf;
    @Expose
    private String supplierId;
    @Expose
    private String standardCountDensity;
    @Expose
    private String depth;
    @Expose
    private String standardCountMoisture;
    @Expose
    private String testNo;
    @Expose
    private String maxDryDensity;
    @Expose
    private String optimunMoistureContent;
    @Expose
    private String wetDensity;
    @Expose
    private String dryDensity;
    @Expose
    private String moistureContent;
    @Expose
    private String pctCompaction;
    @Expose
    private String compactionMethod;
    private String location;
    private String station;
    private String offset;
    private String compactionSpecificationMin;
    private Date dateCalibration;
    private String make;
    private String modelNo;
    private String gaugeNo;
    @Expose
    private String passfail;
    @Expose
    private String approvedBy;
    @Expose
    private Date approvedDate;
    @Expose
    private String sampleStatus;
    @Expose
    private String status;

    public SoilTestDef() {
        this.status = "PENDING";
    }

    public SoilTestDef(SectionT310Test model) {
        this.sampleNumber = model.getSampleid();
        
        try {
            if (StringSupport.isNotNullAndNotEmpty(model.getSampledate()) && !model.getSampledate().equals("0")) {
                this.sampleDate = DateSupport.parseString(model.getSampledate(), DateSupport.FORMAT_US);
            } else {
                this.sampleDate = null;
            }
        } catch (ParseException ex) {
            this.sampleDate = null;
        }
        this.supplierId = model.getProdrsuppcd();
        this.loggedDate = this.sampleDate;
        this.projectNo = model.getContractid();
        this.specItem = StringSupport.splitDecimal(model.getItem());
        this.material = model.getMaterialcode();
        this.testNo = model.getTestno();
        this.compactionMethod = model.getCompactionmethod();
        this.standardCountDensity = model.getStandardcountdensity();
        this.standardCountMoisture = model.getStandardcountmoisture();
        this.depth = model.getProbedepthin();
        this.moistureContent = model.getMoisturecontentin();
        this.wetDensity = model.getWetdensfieldinpcf();
        this.dryDensity = model.getDrydensfieldinpcf();
        this.maxDryDensity = model.getMaxdrydensityinpcf();
        this.optimunMoistureContent = model.getOptimummoisturecontent();
        this.pctCompaction = model.getOfmaxdensityobtained();
        this.status = "PENDING";
    }

    public String getSampleNumber() {
        return sampleNumber;
    }

    public void setSampleNumber(String sampleNumber) {
        this.sampleNumber = sampleNumber;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public Date getLoggedDate() {
        return loggedDate;
    }

    public void setLoggedDate(Date loggedDate) {
        this.loggedDate = loggedDate;
    }

    public String getLabFunction() {
        return labFunction;
    }

    public void setLabFunction(String labFunction) {
        this.labFunction = labFunction;
    }

    public String getSampleBy() {
        return sampleBy;
    }

    public void setSampleBy(String sampleBy) {
        this.sampleBy = sampleBy;
    }

    public String getSpecItem() {
        return specItem;
    }

    public void setSpecItem(String specItem) {
        this.specItem = specItem;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getSampleOf() {
        return sampleOf;
    }

    public void setSampleOf(String sampleOf) {
        this.sampleOf = sampleOf;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getStandardCountDensity() {
        return standardCountDensity;
    }

    public void setStandardCountDensity(String standardCountDensity) {
        this.standardCountDensity = standardCountDensity;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getStandardCountMoisture() {
        return standardCountMoisture;
    }

    public void setStandardCountMoisture(String standardCountMoisture) {
        this.standardCountMoisture = standardCountMoisture;
    }

    public String getTestNo() {
        return testNo;
    }

    public void setTestNo(String testNo) {
        this.testNo = testNo;
    }

    public String getMaxDryDensity() {
        return maxDryDensity;
    }

    public void setMaxDryDensity(String maxDryDensity) {
        this.maxDryDensity = maxDryDensity;
    }

    public String getOptimunMoistureContent() {
        return optimunMoistureContent;
    }

    public void setOptimunMoistureContent(String optimunMoistureContent) {
        this.optimunMoistureContent = optimunMoistureContent;
    }

    public String getWetDensity() {
        return wetDensity;
    }

    public void setWetDensity(String wetDensity) {
        this.wetDensity = wetDensity;
    }

    public String getDryDensity() {
        return dryDensity;
    }

    public void setDryDensity(String dryDensity) {
        this.dryDensity = dryDensity;
    }

    public String getMoistureContent() {
        return moistureContent;
    }

    public void setMoistureContent(String moistureContent) {
        this.moistureContent = moistureContent;
    }

    public String getPctCompaction() {
        return pctCompaction;
    }

    public void setPctCompaction(String pctCompaction) {
        this.pctCompaction = pctCompaction;
    }

    public String getCompactionMethod() {
        return compactionMethod;
    }

    public void setCompactionMethod(String compactionMethod) {
        this.compactionMethod = compactionMethod;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getCompactionSpecificationMin() {
        return compactionSpecificationMin;
    }

    public void setCompactionSpecificationMin(String compactionSpecificationMin) {
        this.compactionSpecificationMin = compactionSpecificationMin;
    }

    public Date getDateCalibration() {
        return dateCalibration;
    }

    public void setDateCalibration(Date dateCalibration) {
        this.dateCalibration = dateCalibration;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModelNo() {
        return modelNo;
    }

    public void setModelNo(String modelNo) {
        this.modelNo = modelNo;
    }

    public String getGaugeNo() {
        return gaugeNo;
    }

    public void setGaugeNo(String gaugeNo) {
        this.gaugeNo = gaugeNo;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(String sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
