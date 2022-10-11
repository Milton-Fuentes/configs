/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.rest.interceptor.syncfusion;

/**
 *
 * @author droldan
 */
public class SyncFusionSorted {
    //sorted:[{name: "id", direction: "ascending"}]
    //sorted:[{name: "clientId", direction: "ascending"}, {name: "id", direction: "descending"}]
    private String name;
    private String direction;

    public SyncFusionSorted() {
    }

    public SyncFusionSorted(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirection() {
        if(direction!= null && direction.equals("ascending")) {
            return "ASC";
        }
        
        if(direction!= null && direction.equals("descending")) {
            return "DESC";
        }
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
