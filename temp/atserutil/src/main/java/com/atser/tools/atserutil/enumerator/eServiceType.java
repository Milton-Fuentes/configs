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
public enum eServiceType implements BaseEnum {
    eEng("Eng", "1"),
    eField("Field", "2"),
    eLab("Lab", "3");

    private final String name;
    private final String value;

    private eServiceType(String s, String value) {
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

    public boolean equalsName(eServiceType otherName) {
        return (otherName == null) ? false : name.equals(otherName.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
