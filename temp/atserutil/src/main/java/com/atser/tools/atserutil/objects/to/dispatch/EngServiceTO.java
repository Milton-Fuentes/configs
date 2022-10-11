/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.dispatch;

/**
 *
 * @author droldan
 */
public class EngServiceTO {

    private String typeofservice;

    public EngServiceTO() {
    }

    public EngServiceTO(String typeofservice) {
        this.typeofservice = typeofservice;
    }

    public String getTypeofservice() {
        return typeofservice;
    }

    public void setTypeofservice(String typeofservice) {
        this.typeofservice = typeofservice;
    }
}
