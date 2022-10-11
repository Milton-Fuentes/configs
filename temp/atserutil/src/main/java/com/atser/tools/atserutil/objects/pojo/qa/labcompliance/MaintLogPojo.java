/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa.labcompliance;

import com.atser.tools.atserutil.string.StringSupport;

/**
 *
 * @author droldan
 */
public class MaintLogPojo {

    private String maintPartName;
    private String maintDescription;
    private String maintFreqDays;
    private String maintDate;
    private String maintPerformedBy;
    private String maintDueDate;

    public MaintLogPojo(String maintPartName, String maintDescription, String maintFreqDays, String maintDate, String maintPerformedBy, String maintDueDate) {
        this.maintPartName = maintPartName;
        this.maintDescription = maintDescription;
        this.maintFreqDays = maintFreqDays;
        this.maintDate = maintDate;
        this.maintPerformedBy = maintPerformedBy;
        this.maintDueDate = maintDueDate;
    }

    public MaintLogPojo(String maintPartName) {
        this.maintPartName = maintPartName;
        this.maintDescription = StringSupport.STRING_EMPTY;
        this.maintFreqDays = StringSupport.STRING_EMPTY;
        this.maintDate = "-";
        this.maintPerformedBy = StringSupport.STRING_EMPTY;
        this.maintDueDate = "-";
    }

    public MaintLogPojo() {
    }

    public String getMaintPartName() {
        return maintPartName;
    }

    public void setMaintPartName(String maintPartName) {
        this.maintPartName = maintPartName;
    }

    public String getMaintDescription() {
        return maintDescription;
    }

    public void setMaintDescription(String maintDescription) {
        this.maintDescription = maintDescription;
    }

    public String getMaintFreqDays() {
        return maintFreqDays;
    }

    public void setMaintFreqDays(String maintFreqDays) {
        this.maintFreqDays = maintFreqDays;
    }

    public String getMaintDate() {
        return maintDate;
    }

    public void setMaintDate(String maintDate) {
        this.maintDate = maintDate;
    }

    public String getMaintPerformedBy() {
        return maintPerformedBy;
    }

    public void setMaintPerformedBy(String maintPerformedBy) {
        this.maintPerformedBy = maintPerformedBy;
    }

    public String getMaintDueDate() {
        return maintDueDate;
    }

    public void setMaintDueDate(String maintDueDate) {
        this.maintDueDate = maintDueDate;
    }
}
