/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.qa;

/**
 *
 * @author droldan
 */
public class QaconcMixdesignsBO {

    private String mixDesign;
    private String specSlumpMin;
    private String specSlumpMax;
    private String specAircontMin;
    private String specAircontMax;

    public QaconcMixdesignsBO() {
    }

    public QaconcMixdesignsBO(String mixDesign, String specSlumpMin, String specSlumpMax, String specAircontMin, String specAircontMax) {
        this.mixDesign = mixDesign;
        this.specSlumpMin = specSlumpMin;
        this.specSlumpMax = specSlumpMax;
        this.specAircontMin = specAircontMin;
        this.specAircontMax = specAircontMax;
    }

    public String getMixDesign() {
        return mixDesign;
    }

    public void setMixDesign(String mixDesign) {
        this.mixDesign = mixDesign;
    }

    public String getSpecSlumpMin() {
        return specSlumpMin;
    }

    public void setSpecSlumpMin(String specSlumpMin) {
        this.specSlumpMin = specSlumpMin;
    }

    public String getSpecSlumpMax() {
        return specSlumpMax;
    }

    public void setSpecSlumpMax(String specSlumpMax) {
        this.specSlumpMax = specSlumpMax;
    }

    public String getSpecAircontMin() {
        return specAircontMin;
    }

    public void setSpecAircontMin(String specAircontMin) {
        this.specAircontMin = specAircontMin;
    }

    public String getSpecAircontMax() {
        return specAircontMax;
    }

    public void setSpecAircontMax(String specAircontMax) {
        this.specAircontMax = specAircontMax;
    }
}
