/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.glob;

/**
 *
 * @author dperez
 */
public class GlobDocumentChangePojo {

    public String fieldName;
    public String oldValue;
    public String newValue;

    public GlobDocumentChangePojo(String fieldName, String oldValue, String newValue) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

}
