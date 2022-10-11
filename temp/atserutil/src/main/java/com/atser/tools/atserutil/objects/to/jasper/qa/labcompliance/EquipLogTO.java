/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.jasper.qa.labcompliance;

import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.CalibLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.EquipLogPojo;
import com.atser.tools.atserutil.objects.pojo.qa.labcompliance.MaintLogPojo;
import java.util.List;

/**
 *
 * @author droldan
 */
public class EquipLogTO {

    private EquipLogPojo equipment;
    private CalibLogPojo calib;
    private List<MaintLogPojo> maintListByPart;

    public EquipLogTO() {
    }

    public EquipLogPojo getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipLogPojo equipment) {
        this.equipment = equipment;
    }

    public CalibLogPojo getCalib() {
        return calib;
    }

    public void setCalib(CalibLogPojo calib) {
        this.calib = calib;
    }

    public List<MaintLogPojo> getMaintListByPart() {
        return maintListByPart;
    }

    public void setMaintListByPart(List<MaintLogPojo> maintListByPart) {
        this.maintListByPart = maintListByPart;
    }
}
