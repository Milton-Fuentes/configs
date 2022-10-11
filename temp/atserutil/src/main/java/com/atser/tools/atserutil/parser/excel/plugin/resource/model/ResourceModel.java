/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.parser.excel.plugin.resource.model;

import com.atser.tools.atserutil.parser.excel.plugin.resource.section.SectionGanttResource;
import com.google.gson.annotations.Expose;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class ResourceModel implements Serializable {
    
    @Expose
    private List<ResourceDef> resources;

    public ResourceModel() {
        resources = new ArrayList<>();
    }

    public List<ResourceDef> getResources() {
        return resources;
    }

    public void setResources(List<ResourceDef> resources) {
        this.resources = resources;
    }
    
    public void addNewResource(SectionGanttResource rs) {
        if (rs != null) {
            resources.add(new ResourceDef(rs.getCode(), rs.getFirstname(), rs.getLastname(), rs.getTitle()));
        }
    }
    
    
    
}
