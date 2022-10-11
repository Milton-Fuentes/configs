/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.enumerator;

/**
 *
 * @author droldan
 */
public enum eManageITFolder implements BaseEnum {
    eFMixDesign("eFMixDesign", "Mix Design"),
    eFLabCompliance("eFLabCompliance", "LabCompliance"),
    eFCorrespondence("eFCorrespondence", "Correspondence"),
    eFSubmittal("eFSubmittal", "Submittals"),
    eFRFI("eFRFI", "Request for Information"),
    eFDispatch("eFDispatch", "Dispatch"),
    eFInspDispatch("eFInspDispatch", "Inspector Dispatch");

    private final String name;
    private final String value;

    private eManageITFolder(String s, String value) {
        this.name = s;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    public boolean equalsName(eManageITFolder otherName) {
        return (otherName == null) ? false : name.equals(otherName.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
