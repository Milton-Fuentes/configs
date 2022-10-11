/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.dispatch;

import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public class LabServiceTO {

    private BigInteger testCategoryId;
    private String testCatName;
    private BigInteger testTypeId;
    private String testTypeName;

    public LabServiceTO() {
    }

    public LabServiceTO(BigInteger testTypeId, BigInteger testCategoryId) {
        this.testTypeId = testTypeId;
        this.testCategoryId = testCategoryId;
    }

    public LabServiceTO(BigInteger testCategoryId, String testCatName, BigInteger testTypeId, String testTypeName) {
        this.testCategoryId = testCategoryId;
        this.testCatName = testCatName;
        this.testTypeId = testTypeId;
        this.testTypeName = testTypeName;
    }

    public BigInteger getTestTypeId() {
        return testTypeId;
    }

    public void setTestTypeId(BigInteger testTypeId) {
        this.testTypeId = testTypeId;
    }

    public BigInteger getTestCategoryId() {
        return testCategoryId;
    }

    public void setTestCategoryId(BigInteger testCategoryId) {
        this.testCategoryId = testCategoryId;
    }

    public String getTestCatName() {
        return testCatName;
    }

    public void setTestCatName(String testCatName) {
        this.testCatName = testCatName;
    }

    public String getTestTypeName() {
        return testTypeName;
    }

    public void setTestTypeName(String testTypeName) {
        this.testTypeName = testTypeName;
    }
}
