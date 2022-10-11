/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa.mixdesign;

import com.atser.tools.atserutil.string.StringSupport;

/**
 *
 * @author droldan
 */
public class GradationPojo {

    private String sieveSize;
    private String ltmfGradation;
    private String masterMinLimit;
    private String masterMaxLimit;
    private String jmfTolerance;

    public GradationPojo() {
        this.sieveSize = StringSupport.STRING_EMPTY;
        this.ltmfGradation = StringSupport.STRING_EMPTY;
        this.masterMinLimit = StringSupport.STRING_EMPTY;
        this.masterMaxLimit = StringSupport.STRING_EMPTY;
        this.jmfTolerance = StringSupport.STRING_EMPTY;
    }

    public GradationPojo(String sieveSize, String ltmfGradation, String masterMinLimit, String masterMaxLimit, String jmfTolerance) {
        this.sieveSize = sieveSize;
        this.ltmfGradation = ltmfGradation;
        this.masterMinLimit = masterMinLimit;
        this.masterMaxLimit = masterMaxLimit;
        this.jmfTolerance = jmfTolerance;
    }

    public String getSieveSize() {
        return sieveSize;
    }

    public void setSieveSize(String sieveSize) {
        this.sieveSize = sieveSize;
    }

    public String getLtmfGradation() {
        return ltmfGradation;
    }

    public void setLtmfGradation(String ltmfGradation) {
        this.ltmfGradation = ltmfGradation;
    }

    public String getMasterMinLimit() {
        return masterMinLimit;
    }

    public void setMasterMinLimit(String masterMinLimit) {
        this.masterMinLimit = masterMinLimit;
    }

    public String getMasterMaxLimit() {
        return masterMaxLimit;
    }

    public void setMasterMaxLimit(String masterMaxLimit) {
        this.masterMaxLimit = masterMaxLimit;
    }

    public String getJmfTolerance() {
        return jmfTolerance;
    }

    public void setJmfTolerance(String jmfTolerance) {
        this.jmfTolerance = jmfTolerance;
    }

}
