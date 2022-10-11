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
public enum eCarrier implements BaseEnum {
    att("att", "txt.att.net"),
    tmobile("tmobile", "tmomail.net"),
    sprint("sprint", "messaging.sprintpcs.com"),
    verizon("verizon", "vtext.com"),
    boost("boost", "sms.myboostmobile.com"),
    cricket("cricket", "mms.cricketwireless.net"),
    metro("metro", "mymetropcs.com"),
    nextel("nextel", "messaging.nextel.com"),
    virgin("virgin", "vmobl.com");

    private final String name;
    private final String value;

    private eCarrier(String s, String value) {
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

    public boolean equalsName(eCarrier otherName) {
        return (otherName == null) ? false : name.equals(otherName.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
