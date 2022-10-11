/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.lab;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author droldan
 */
public class LabTestMachine {
    @JsonProperty("HostName")
    private String HostName;
    @JsonProperty("SerialNumber")
    private String SerialNumber;
    @JsonProperty("ModelNumber")
    private String ModelNumber;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("Facility")
    private String Facility;
    @JsonProperty("Lab")
    private String Lab;
    @JsonProperty("RoomNumber")
    private String RoomNumber;

    public LabTestMachine(String HostName, String SerialNumber, String ModelNumber, String Description, String Facility, String Lab, String RoomNumber) {
        this.HostName = HostName;
        this.SerialNumber = SerialNumber;
        this.ModelNumber = ModelNumber;
        this.Description = Description;
        this.Facility = Facility;
        this.Lab = Lab;
        this.RoomNumber = RoomNumber;
    }

    public LabTestMachine() {
    }

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String HostName) {
        this.HostName = HostName;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public String getModelNumber() {
        return ModelNumber;
    }

    public void setModelNumber(String ModelNumber) {
        this.ModelNumber = ModelNumber;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String Facility) {
        this.Facility = Facility;
    }

    public String getLab() {
        return Lab;
    }

    public void setLab(String Lab) {
        this.Lab = Lab;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public void setRoomNumber(String RoomNumber) {
        this.RoomNumber = RoomNumber;
    }
}
