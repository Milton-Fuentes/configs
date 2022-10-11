/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.reports;

/**
 *
 * @author droldan
 */
public class ReportPieDoughnutTO implements IReportSyncfusion {

    private String x;
    private String text;
    private Long y;

    public ReportPieDoughnutTO() {
    }

    public ReportPieDoughnutTO(String x, String text, Long y) {
        this.x = x;
        this.text = text;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}
