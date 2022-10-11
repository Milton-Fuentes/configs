/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.calendar.report;

import java.time.LocalDateTime;

/**
 *
 * @author dperez
 */
public class CalendarWorkOrderTO {

    private LocalDateTime time;
    private String hour;
    private String woDescription;
    private String traceabilityNo;
    private String location;
    private String projectName;
    private String servicesRequested;
    private String clientName;
    private String labName;
    private String projectAddress;

    public CalendarWorkOrderTO() {
    }

    public CalendarWorkOrderTO(LocalDateTime time, String hour, String woDescription, String traceabilityNo, String location) {
        this.time = time;
        this.hour = hour;
        this.woDescription = woDescription;
        this.traceabilityNo = traceabilityNo;
        this.location = location;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWoDescription() {
        return woDescription;
    }

    public void setWoDescription(String woDescription) {
        this.woDescription = woDescription;
    }

    public String getTraceabilityNo() {
        return traceabilityNo;
    }

    public void setTraceabilityNo(String traceabilityNo) {
        this.traceabilityNo = traceabilityNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getServicesRequested() {
        return servicesRequested;
    }

    public void setServicesRequested(String servicesRequested) {
        this.servicesRequested = servicesRequested;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }
}
