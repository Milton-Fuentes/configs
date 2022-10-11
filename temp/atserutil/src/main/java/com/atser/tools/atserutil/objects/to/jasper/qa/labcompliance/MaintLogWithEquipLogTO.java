/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.labcompliance;

import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.MaintLogPojo;

/**
 *
 * @author droldan
 */
public class MaintLogWithEquipLogTO {
    
    private EquipLogPojo equipment;
    private MaintLogPojo maintPart;

    public MaintLogWithEquipLogTO() {
    }

    public EquipLogPojo getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipLogPojo equipment) {
        this.equipment = equipment;
    }

    public MaintLogPojo getMaintPart() {
        return maintPart;
    }

    public void setMaintPart(MaintLogPojo maintPart) {
        this.maintPart = maintPart;
    }
}
