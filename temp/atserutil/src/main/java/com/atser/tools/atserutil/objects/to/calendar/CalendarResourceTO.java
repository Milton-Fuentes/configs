/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.calendar;

/**
 *
 * @author droldan
 */
public class CalendarResourceTO {

    private String id;
    private String text;

    public CalendarResourceTO(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public CalendarResourceTO() {
        this.id = null;
        this.text = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
