/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.sampletest.concrete.t22.section.nysdot.SectionT22Test;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author droldan
 */
public class T22TestDef implements Serializable {

    @Expose
    private String sampleNumber;
    @Expose
    private String projectNo;
    @Expose
    private String specimenNo;
    @Expose
    private String serialNo;
    @Expose
    private String testAge;
    @Expose // Days/Hours
    private String testAgeType;
    @Expose
    private Date testDate;
    @Expose
    private String weight;
    @Expose
    private String area;
    @Expose
    private String diameter;
    @Expose
    private String maxLoad;
    @Expose
    private String breakDistance;
    @Expose
    private String testingTechnician;
    @Expose
    private String compressiveStr;
    @Expose
    private String specMin;
    @Expose
    private String specMax;
    @Expose
    private String average;
    @Expose
    private String passfail;
    @Expose
    private String remarks;
    @Expose
    private String status;

    public T22TestDef() {
        this.status = "PENDING";
    }

    // Constructor for NysDOT
    public T22TestDef(SectionT22Test model) {
        this.sampleNumber = model.getSmpasmpl();
        this.projectNo = model.getCont_id();
        this.serialNo = model.getCylssmpl();
        this.testAge = model.getAge();
        this.testAgeType = StringSupport.sanitizeString(model.getDh(), "[\\s+,\\.+]", 0);
        if (StringSupport.isNotNullAndNotEmpty(model.getBreakdate()) && !model.getBreakdate().equals("0")) {
            List<SimpleDateFormat> dateFormats = new ArrayList<>();
            dateFormats.add(DateSupport.FORMAT_REVERSE_MD);
            dateFormats.add(DateSupport.FORMAT_US);
            dateFormats.add(DateSupport.factorySimpleDateFormat("yyyyMMdd"));
            this.testDate = DateSupport.parseDynamicStringToDate(model.getBreakdate(), dateFormats);
        } else {
            this.testDate = null;
        }
        this.compressiveStr = model.getAvestr();
        this.specMin = model.getMinspec();
        this.average = model.getAvestr();
        this.diameter = "6";
        this.passfail = model.getIo();
        if (StringSupport.isNotNullAndNotEmpty(this.diameter)) {
            try {
                Double dcrossSection = (Math.PI * Math.pow(NumberSupport.getDouble(diameter), 2)) / 4;
                this.area = StringSupport.getString(CurrencySupport.formatDouble(dcrossSection, 2));
                if (StringSupport.isNotNullAndNotEmpty(this.compressiveStr)) {
                    Double dmaxLoad = NumberSupport.getDouble(this.compressiveStr) * dcrossSection;
                    this.maxLoad = StringSupport.formatDecimalToString(dmaxLoad, "%.0f");
                }
            } catch (ParseException ex) {
                this.area = "";
            }
        }
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

    public String getSpecimenNo() {
        return specimenNo;
    }

    public void setSpecimenNo(String specimenNo) {
        this.specimenNo = specimenNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getTestAge() {
        return testAge;
    }

    public void setTestAge(String testAge) {
        this.testAge = testAge;
    }

    public String getTestAgeType() {
        return testAgeType;
    }

    public void setTestAgeType(String testAgeType) {
        this.testAgeType = testAgeType;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(String maxLoad) {
        this.maxLoad = maxLoad;
    }

    public String getBreakDistance() {
        return breakDistance;
    }

    public void setBreakDistance(String breakDistance) {
        this.breakDistance = breakDistance;
    }

    public String getTestingTechnician() {
        return testingTechnician;
    }

    public void setTestingTechnician(String testingTechnician) {
        this.testingTechnician = testingTechnician;
    }

    public String getCompressiveStr() {
        return compressiveStr;
    }

    public void setCompressiveStr(String compressiveStr) {
        this.compressiveStr = compressiveStr;
    }

    public String getSpecMin() {
        return specMin;
    }

    public void setSpecMin(String specMin) {
        this.specMin = specMin;
    }

    public String getSpecMax() {
        return specMax;
    }

    public void setSpecMax(String specMax) {
        this.specMax = specMax;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getPassfail() {
        return passfail;
    }

    public void setPassfail(String passfail) {
        this.passfail = passfail;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
