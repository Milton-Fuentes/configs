/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.lab;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author droldan
 */
public class LabMachineStatus {

    private String Identifier;
    private String Status;
    private String Description;
    private Map<String, String> Fields;

    public LabMachineStatus() {
        this.Status = "OK";
        Fields = new HashMap<>();
    }

    public LabMachineStatus(String identifier, String status, String description) {
        this.Identifier = identifier;
        this.Status = status;
        this.Description = description;
    }

    public LabMachineStatus(String identifier, String status, String description, Map<String, String> fields) {
        this.Identifier = identifier;
        this.Status = status;
        this.Description = description;
        this.Fields = fields;
    }

    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Map<String, String> getFields() {
        return Fields;
    }

    public void setFields(Map<String, String> Fields) {
        this.Fields = Fields;
    }
    
    public void addField(String key, String value) {
        this.Fields.put(key, value);
    }
}
