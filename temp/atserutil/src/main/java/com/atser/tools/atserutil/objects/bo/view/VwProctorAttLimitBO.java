/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.view;

/**
 *
 * @author droldan
 */
public class VwProctorAttLimitBO {

    private String description;
    private String source;
    private String structure;
    private String sampleNo;
    private String maxDryDensity;
    private String optMoistContent;
    private String pi;

    public VwProctorAttLimitBO(String description, String source, String structure, String sampleNo, String maxDryDensity, String optMoistContent, String pi) {
        this.description = description;
        this.source = source;
        this.structure = structure;
        this.sampleNo = sampleNo;
        this.maxDryDensity = maxDryDensity;
        this.optMoistContent = optMoistContent;
        this.pi = pi;
    }

    public VwProctorAttLimitBO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getMaxDryDensity() {
        return maxDryDensity;
    }

    public void setMaxDryDensity(String maxDryDensity) {
        this.maxDryDensity = maxDryDensity;
    }

    public String getOptMoistContent() {
        return optMoistContent;
    }

    public void setOptMoistContent(String optMoistContent) {
        this.optMoistContent = optMoistContent;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }
}
