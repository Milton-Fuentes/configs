/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.lab;

import com.atser.tools.atserutil.map.AtserLinkedHashMap;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author droldan
 */
public class LabMainObject {

    @JsonProperty("StandardsOrganization")
    private String StandardsOrganization;
    @JsonProperty("Specification")
    private String Specification;
    @JsonProperty("MassDOTUniqueID")
    private String MassDOTUniqueID;
    @JsonProperty("TestMachine")
    private LabTestMachine TestMachine;
    @JsonProperty("TestResults")
    private List<AtserLinkedHashMap<String, Object>> TestResults;

    public LabMainObject() {
    }

    public String getStandardsOrganization() {
        return StandardsOrganization;
    }

    public void setStandardsOrganization(String StandardsOrganization) {
        this.StandardsOrganization = StandardsOrganization;
    }

    public String getSpecification() {
        return Specification;
    }

    public void setSpecification(String Specification) {
        this.Specification = Specification;
    }

    public String getMassDOTUniqueID() {
        return MassDOTUniqueID;
    }

    public void setMassDOTUniqueID(String MassDOTUniqueID) {
        this.MassDOTUniqueID = MassDOTUniqueID;
    }

    public LabTestMachine getTestMachine() {
        return TestMachine;
    }

    public void setTestMachine(LabTestMachine TestMachine) {
        this.TestMachine = TestMachine;
    }

    public List<AtserLinkedHashMap<String, Object>> getTestResults() {
        return TestResults;
    }

    public void setTestResults(List<AtserLinkedHashMap<String, Object>> TestResults) {
        this.TestResults = TestResults;
    }
}
