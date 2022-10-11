/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sampletest.soil.t310.section.nysdot;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 1, end = 1)
public class SectionDetectTplT310Test {

    @ExcelField(position = 1)
    private String sampleid;
    @ExcelField(position = 2)
    private String sampledate;
    @ExcelField(position = 3)
    private String prodrsuppcd;
    @ExcelField(position = 4)
    private String contractid;
    @ExcelField(position = 5)
    private String item;
    @ExcelField(position = 6)
    private String materialcode;
    @ExcelField(position = 7)
    private String testno;
    @ExcelField(position = 8)
    private String compactionmethod;
    @ExcelField(position = 62)
    private String standardcountdensity;
    @ExcelField(position = 63)
    private String standardcountmoisture;
    @ExcelField(position = 64)
    private String probedepthin;
    @ExcelField(position = 85)
    private String moisturecontentin;
    @ExcelField(position = 86)
    private String wetdensfieldinpcf;
    @ExcelField(position = 87)
    private String drydensfieldinpcf;
    @ExcelField(position = 93)
    private String maxdrydensityinpcf;
    @ExcelField(position = 94)
    private String optimummoisturecontent;
    @ExcelField(position = 95)
    private String ofmaxdensityobtained;

    public SectionDetectTplT310Test() {
    }

    public String getSampleid() {
        return sampleid;
    }

    public void setSampleid(String sampleid) {
        this.sampleid = sampleid;
    }

    public String getSampledate() {
        return sampledate;
    }

    public void setSampledate(String sampledate) {
        this.sampledate = sampledate;
    }

    public String getProdrsuppcd() {
        return prodrsuppcd;
    }

    public void setProdrsuppcd(String prodrsuppcd) {
        this.prodrsuppcd = prodrsuppcd;
    }

    public String getContractid() {
        return contractid;
    }

    public void setContractid(String contractid) {
        this.contractid = contractid;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMaterialcode() {
        return materialcode;
    }

    public void setMaterialcode(String materialcode) {
        this.materialcode = materialcode;
    }

    public String getTestno() {
        return testno;
    }

    public void setTestno(String testno) {
        this.testno = testno;
    }

    public String getCompactionmethod() {
        return compactionmethod;
    }

    public void setCompactionmethod(String compactionmethod) {
        this.compactionmethod = compactionmethod;
    }

    public String getStandardcountdensity() {
        return standardcountdensity;
    }

    public void setStandardcountdensity(String standardcountdensity) {
        this.standardcountdensity = standardcountdensity;
    }

    public String getStandardcountmoisture() {
        return standardcountmoisture;
    }

    public void setStandardcountmoisture(String standardcountmoisture) {
        this.standardcountmoisture = standardcountmoisture;
    }

    public String getProbedepthin() {
        return probedepthin;
    }

    public void setProbedepthin(String probedepthin) {
        this.probedepthin = probedepthin;
    }

    public String getMoisturecontentin() {
        return moisturecontentin;
    }

    public void setMoisturecontentin(String moisturecontentin) {
        this.moisturecontentin = moisturecontentin;
    }

    public String getWetdensfieldinpcf() {
        return wetdensfieldinpcf;
    }

    public void setWetdensfieldinpcf(String wetdensfieldinpcf) {
        this.wetdensfieldinpcf = wetdensfieldinpcf;
    }

    public String getDrydensfieldinpcf() {
        return drydensfieldinpcf;
    }

    public void setDrydensfieldinpcf(String drydensfieldinpcf) {
        this.drydensfieldinpcf = drydensfieldinpcf;
    }

    public String getMaxdrydensityinpcf() {
        return maxdrydensityinpcf;
    }

    public void setMaxdrydensityinpcf(String maxdrydensityinpcf) {
        this.maxdrydensityinpcf = maxdrydensityinpcf;
    }

    public String getOptimummoisturecontent() {
        return optimummoisturecontent;
    }

    public void setOptimummoisturecontent(String optimummoisturecontent) {
        this.optimummoisturecontent = optimummoisturecontent;
    }

    public String getOfmaxdensityobtained() {
        return ofmaxdensityobtained;
    }

    public void setOfmaxdensityobtained(String ofmaxdensityobtained) {
        this.ofmaxdensityobtained = ofmaxdensityobtained;
    }

    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        int count = 1;
        for (Field it : this.getClass().getDeclaredFields()) {
            if (it.get(this) == null) {
                return Boolean.FALSE;
            } else if (!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "[^A-Za-z]+", 0))) {
                return Boolean.FALSE;
            }
            if (count++ == 10) {
                return Boolean.TRUE;
            }
        }
        return Boolean.TRUE;
    }
}
