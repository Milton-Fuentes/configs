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
public enum eDocExtension implements BaseEnum {
    pdf("pdf", "pdf"),
    doc("doc", "doc"),
    csv("csv", "csv"),
    excel("excel", "xlsx");

    private final String name;
    private final String value;

    private eDocExtension(String s, String value) {
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

    public boolean equalsName(eDocExtension otherName) {
        return (otherName == null) ? false : name.equals(otherName.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
