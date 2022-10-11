/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.jasper;

/**
 *
 * @author droldan
 */
public class DispatchWOPojo {

    private String woNumber;
    private String requestedServices;
    private String serviceDate;
    private String timeAtsite;
    private String techAssigned;
    private String contactNumber;

    public DispatchWOPojo() {
    }

    public DispatchWOPojo(String woNumber, String requestedServices, String serviceDate, String timeAtsite, String techAssigned, String contactNumber) {
        this.woNumber = woNumber;
        this.requestedServices = requestedServices;
        this.serviceDate = serviceDate;
        this.timeAtsite = timeAtsite;
        this.techAssigned = techAssigned;
        this.contactNumber = contactNumber;
    }

    public String getWoNumber() {
        return woNumber;
    }

    public void setWoNumber(String woNumber) {
        this.woNumber = woNumber;
    }

    public String getRequestedServices() {
        return requestedServices;
    }

    public void setRequestedServices(String requestedServices) {
        this.requestedServices = requestedServices;
    }

    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getTimeAtsite() {
        return timeAtsite;
    }

    public void setTimeAtsite(String timeAtsite) {
        this.timeAtsite = timeAtsite;
    }

    public String getTechAssigned() {
        return techAssigned;
    }

    public void setTechAssigned(String techAssigned) {
        this.techAssigned = techAssigned;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
