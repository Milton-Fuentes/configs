/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa.labcompliance;

/**
 *
 * @author droldan
 */
public class EquipMaintAlertPojo {

    private String equipType;
    private String electronicTag;
    private String serialNo;
    private String equipNo;
    private String equipPartName;
    private String maintDate;
    private String maintDueDate;

    public EquipMaintAlertPojo() {
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getEquipNo() {
        return equipNo;
    }

    public void setEquipNo(String equipNo) {
        this.equipNo = equipNo;
    }

    public String getEquipPartName() {
        return equipPartName;
    }

    public void setEquipPartName(String equipPartName) {
        this.equipPartName = equipPartName;
    }

    public String getMaintDueDate() {
        return maintDueDate;
    }

    public void setMaintDueDate(String maintDueDate) {
        this.maintDueDate = maintDueDate;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getElectronicTag() {
        return electronicTag;
    }

    public void setElectronicTag(String electronicTag) {
        this.electronicTag = electronicTag;
    }

    public String getMaintDate() {
        return maintDate;
    }

    public void setMaintDate(String maintDate) {
        this.maintDate = maintDate;
    }

}
