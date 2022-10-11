/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.model;

import com.atser.tools.atserutil.date.DateSupport;
import com.atser.tools.atserutil.parser.excel.plugin.sample.concrete.section.nysdot.SectionConcSample;
import com.atser.tools.atserutil.string.StringSupport;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
public class ConcSampleDef implements Serializable {

    @Expose
    private String sampleNumber;
    @Expose
    private Date sampleDate;
    @Expose
    private Date loggedDate;
    @Expose
    private String projectNo;
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
    private String mixDesignNo;
    @Expose
    private String specStrength;
    @Expose
    private String mixTemp;
    @Expose
    private String airTemp;
    @Expose
    private String slump1;
    @Expose
    private String station;
    @Expose
    private String readyMixSupplier;
    private String supplierId;
    @Expose
    private String approvedBy;
    @Expose
    private Date approvedDate;
    @Expose
    private String sampleStatus;
    @Expose
    private String status;

    public ConcSampleDef() {
        this.status = "PENDING";
    }

    public ConcSampleDef(SectionConcSample sectionConcSample) {
        this.sampleNumber = sectionConcSample.getSmpl_id();
        try {
            if (StringSupport.isNotNullAndNotEmpty(sectionConcSample.getSmpl_dt()) && !sectionConcSample.getSmpl_dt().equals("0")) {
                this.sampleDate = DateSupport.parseString(sectionConcSample.getSmpl_dt(), DateSupport.factorySimpleDateFormat("yyyyMMdd"));
            } else {
                this.sampleDate = null;
            }
        } catch (ParseException ex) {
            this.sampleDate = null;
        }
        try {
            if (StringSupport.isNotNullAndNotEmpty(sectionConcSample.getLog_dt()) && !sectionConcSample.getLog_dt().equals("0")) {
                this.loggedDate = DateSupport.parseString(sectionConcSample.getLog_dt(), DateSupport.factorySimpleDateFormat("yyyyMMdd"));
            } else {
                this.loggedDate = null;
            }
        } catch (ParseException ex) {
            this.loggedDate = null;
        }
        try {
            if (StringSupport.isNotNullAndNotEmpty(sectionConcSample.getAuth_dt()) && !sectionConcSample.getAuth_dt().equals("0")) {
                this.approvedDate = DateSupport.parseString(sectionConcSample.getAuth_dt(), DateSupport.factorySimpleDateFormat("yyyyMMdd"));
            } else {
                this.approvedDate = null;
            }
        } catch (ParseException ex) {
            this.approvedDate = null;
        }
        this.projectNo = sectionConcSample.getCont_id();
        this.specItem = StringSupport.splitDecimal(sectionConcSample.getItm_cd());
        this.supplierId = sectionConcSample.getProdr_supp_cd();
        this.approvedBy = sectionConcSample.getAuth_by_cms_uid();
        this.sampleStatus = sectionConcSample.getStat_t();
        this.material = sectionConcSample.getMatl_cd();
        this.airTemp = sectionConcSample.getAir();
        this.slump1 = sectionConcSample.getSlump();
        this.mixDesignNo = sectionConcSample.getSmpl_mix_id();
        this.status = "PENDING";
    }
}
