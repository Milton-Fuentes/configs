/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to;

import com.atser.tools.atserutil.objects.bo.bpm.BpmUserBO;
import com.atser.tools.atserutil.objects.bo.bpm.RoleMappingBO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author droldan
 */
public class BpmRoleMappingTO {
    private RoleMappingBO roleMapping;
    private List<BpmUserBO> listBpmUser;

    public BpmRoleMappingTO() {
        roleMapping = null;
        listBpmUser = new ArrayList<>();
    }

    public RoleMappingBO getRoleMapping() {
        return roleMapping;
    }

    public void setRoleMapping(RoleMappingBO roleMapping) {
        this.roleMapping = roleMapping;
    }

    public List<BpmUserBO> getListBpmUser() {
        return listBpmUser;
    }

    public void setListBpmUser(List<BpmUserBO> listBpmUser) {
        this.listBpmUser = listBpmUser;
    }
    
}
