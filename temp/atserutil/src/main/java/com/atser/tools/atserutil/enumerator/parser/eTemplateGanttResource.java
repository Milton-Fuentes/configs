/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.atser.tools.atserutil.enumerator.parser;

/**
 *
 * @author droldan
 */
public enum eTemplateGanttResource {
    AtserResourceTpl("AtserResourceTpl",1),
    PrimaveraResourceTpl("PrimaveraResourceTpl",2);

    private final String name;
    private final int value;

    private eTemplateGanttResource(String s, int value) {
        this.name = s;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public boolean equalsName(String otherName) {
        return (otherName == null) ? false : name.equals(otherName);
    }

    @Override
    public String toString() {
        return name;
    }
}
