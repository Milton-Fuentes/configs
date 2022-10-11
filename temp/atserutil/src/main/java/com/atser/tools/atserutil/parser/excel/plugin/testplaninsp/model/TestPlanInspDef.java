/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.model;

import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.parser.excel.plugin.testplaninsp.section.nysdot.SectionTestPlanInsp;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class TestPlanInspDef implements Serializable {

    @Expose
    private BigInteger projectId;
    @Expose
    private BigInteger inspTestId;
    @Expose
    private String lineItem;
    @Expose
    private String itemNo;
    @Expose
    private BigInteger testId;
    @Expose
    private BigInteger methodId;
    @Expose
    private String unit;
    @Expose
    private Double plantQty;
    @Expose
    private Double actualQty;
    @Expose
    private Double testFreq;
    @Expose
    private Double plantTest;
    @Expose
    private Double reqTest;
    @Expose
    private Double diffTest;
    @Expose
    private String comments;

    public TestPlanInspDef(SectionTestPlanInsp model) {
        this.lineItem = model.getLineItem();
        this.itemNo = StringSupport.splitDecimal(model.getItemCode());
        this.unit = model.getUnitOfMeasure();
        this.actualQty = NumberSupport.getDouble(model.getTotalQtyUsedToDate());
    }

    public BigInteger getProjectId() {
        return projectId;
    }

    public void setProjectId(BigInteger projectId) {
        this.projectId = projectId;
    }

    public BigInteger getInspTestId() {
        return inspTestId;
    }

    public void setInspTestId(BigInteger inspTestId) {
        this.inspTestId = inspTestId;
    }

    public String getLineItem() {
        return lineItem;
    }

    public void setLineItem(String lineItem) {
        this.lineItem = lineItem;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public BigInteger getTestId() {
        return testId;
    }

    public void setTestId(BigInteger testId) {
        this.testId = testId;
    }

    public BigInteger getMethodId() {
        return methodId;
    }

    public void setMethodId(BigInteger methodId) {
        this.methodId = methodId;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPlantQty() {
        return plantQty;
    }

    public void setPlantQty(Double plantQty) {
        this.plantQty = plantQty;
    }

    public Double getActualQty() {
        return actualQty;
    }

    public void setActualQty(Double actualQty) {
        this.actualQty = actualQty;
    }

    public Double getTestFreq() {
        return testFreq;
    }

    public void setTestFreq(Double testFreq) {
        this.testFreq = testFreq;
    }

    public Double getPlantTest() {
        return plantTest;
    }

    public void setPlantTest(Double plantTest) {
        this.plantTest = plantTest;
    }

    public Double getReqTest() {
        return reqTest;
    }

    public void setReqTest(Double reqTest) {
        this.reqTest = reqTest;
    }

    public Double getDiffTest() {
        return diffTest;
    }

    public void setDiffTest(Double diffTest) {
        this.diffTest = diffTest;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
