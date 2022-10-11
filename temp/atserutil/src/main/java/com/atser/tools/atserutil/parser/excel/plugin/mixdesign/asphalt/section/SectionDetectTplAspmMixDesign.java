/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.mixdesign.asphalt.section;

import com.atser.tools.atserutil.parser.excel.annotations.ExcelField;
import com.atser.tools.atserutil.parser.excel.annotations.ExcelObject;
import com.atser.tools.atserutil.parser.excel.annotations.ParseType;
import com.atser.tools.atserutil.string.StringSupport;
import java.lang.reflect.Field;

/**
 *
 * @author droldan
 */
@ExcelObject(parseType = ParseType.ROW, start = 4, end = 4)
public class SectionDetectTplAspmMixDesign {

    @ExcelField(position = 1)
    private String mixId;
    @ExcelField(position = 2)
    private String producer;
    @ExcelField(position = 3)
    private String plantLocation;
    @ExcelField(position = 5)
    private String gyrations;
    @ExcelField(position = 7)
    private String trafficLevel;
    @ExcelField(position = 8)
    private String pgBinderGrade;
    @ExcelField(position = 9)
    private String pgBinderAdditive;
    @ExcelField(position = 11)
    private String recycleType;
    @ExcelField(position = 14)
    private String wmaTechnology;
    @ExcelField(position = 19)
    private String target;

    public SectionDetectTplAspmMixDesign() {
    }

    public String getMixId() {
        return mixId;
    }

    public void setMixId(String mixId) {
        this.mixId = mixId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getPlantLocation() {
        return plantLocation;
    }

    public void setPlantLocation(String plantLocation) {
        this.plantLocation = plantLocation;
    }

    public String getGyrations() {
        return gyrations;
    }

    public void setGyrations(String gyrations) {
        this.gyrations = gyrations;
    }

    public String getTrafficLevel() {
        return trafficLevel;
    }

    public void setTrafficLevel(String trafficLevel) {
        this.trafficLevel = trafficLevel;
    }

    public String getPgBinderGrade() {
        return pgBinderGrade;
    }

    public void setPgBinderGrade(String pgBinderGrade) {
        this.pgBinderGrade = pgBinderGrade;
    }

    public String getPgBinderAdditive() {
        return pgBinderAdditive;
    }

    public void setPgBinderAdditive(String pgBinderAdditive) {
        this.pgBinderAdditive = pgBinderAdditive;
    }

    public String getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(String recycleType) {
        this.recycleType = recycleType;
    }

    public String getWmaTechnology() {
        return wmaTechnology;
    }

    public void setWmaTechnology(String wmaTechnology) {
        this.wmaTechnology = wmaTechnology;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Boolean isValid() throws IllegalArgumentException, IllegalAccessException {
        for (Field it : this.getClass().getDeclaredFields()) {
            if (it.get(this) == null) {
                return Boolean.FALSE;
            } else if (!it.getName().toLowerCase().equals(StringSupport.sanitizeString(it.get(this).toString(), "\\s+", 0))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
