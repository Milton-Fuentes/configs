/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.view;

/**
 *
 * @author droldan
 */
public class InvoiceSummaryTO {

    private String projectClientNo;
    private String projectClientName;
    private String projectName;
    private String projectNumber;
    private String officeLocation;
    private String invoiceNo;
    private String invoiceDate;
    private String invoiceAmount;
    private String totalToDateAmount;
    private String totalBalanceAmount;
    private String status;

    public InvoiceSummaryTO() {
    }

    public String getProjectClientNo() {
        return projectClientNo;
    }

    public void setProjectClientNo(String projectClientNo) {
        this.projectClientNo = projectClientNo;
    }

    public String getProjectClientName() {
        return projectClientName;
    }

    public void setProjectClientName(String projectClientName) {
        this.projectClientName = projectClientName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getTotalToDateAmount() {
        return totalToDateAmount;
    }

    public void setTotalToDateAmount(String totalToDateAmount) {
        this.totalToDateAmount = totalToDateAmount;
    }

    public String getTotalBalanceAmount() {
        return totalBalanceAmount;
    }

    public void setTotalBalanceAmount(String totalBalanceAmount) {
        this.totalBalanceAmount = totalBalanceAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
}
