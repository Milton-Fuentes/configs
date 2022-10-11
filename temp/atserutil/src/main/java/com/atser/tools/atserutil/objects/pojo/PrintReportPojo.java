/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo;

/**
 *
 * @author droldan
 */
public class PrintReportPojo {

    private String reportId;
    private String reportName;
    private Integer order;

    public PrintReportPojo(String reportId, String reportName, Integer order) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.order = order;
    }

    public PrintReportPojo() {
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
