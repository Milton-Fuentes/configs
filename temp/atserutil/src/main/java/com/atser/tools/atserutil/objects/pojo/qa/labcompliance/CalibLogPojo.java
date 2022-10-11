/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa.labcompliance;

/**
 *
 * @author droldan
 */
public class CalibLogPojo {

    private String calibMethod;
    private String calibProcedure;
    private String calibFreqMonths;
    private String calibDate;
    private String calibPerformedBy;
    private String calibDueDate;

    public CalibLogPojo() {
    }

    public CalibLogPojo(String calibMethod, String calibFreqMonths, String calibDate, String calibPerformedBy, String calibDueDate, String calibProcedure) {
        this.calibMethod = calibMethod;
        this.calibFreqMonths = calibFreqMonths;
        this.calibDate = calibDate;
        this.calibPerformedBy = calibPerformedBy;
        this.calibDueDate = calibDueDate;
        this.calibProcedure = calibProcedure;
    }

    public String getCalibMethod() {
        return calibMethod;
    }

    public void setCalibMethod(String calibMethod) {
        this.calibMethod = calibMethod;
    }

    public String getCalibFreqMonths() {
        return calibFreqMonths;
    }

    public void setCalibFreqMonths(String calibFreqMonths) {
        this.calibFreqMonths = calibFreqMonths;
    }

    public String getCalibDate() {
        return calibDate;
    }

    public void setCalibDate(String calibDate) {
        this.calibDate = calibDate;
    }

    public String getCalibPerformedBy() {
        return calibPerformedBy;
    }

    public void setCalibPerformedBy(String calibPerformedBy) {
        this.calibPerformedBy = calibPerformedBy;
    }

    public String getCalibDueDate() {
        return calibDueDate;
    }

    public void setCalibDueDate(String calibDueDate) {
        this.calibDueDate = calibDueDate;
    }

    public String getCalibProcedure() {
        return calibProcedure;
    }

    public void setCalibProcedure(String calibProcedure) {
        this.calibProcedure = calibProcedure;
    }
}
