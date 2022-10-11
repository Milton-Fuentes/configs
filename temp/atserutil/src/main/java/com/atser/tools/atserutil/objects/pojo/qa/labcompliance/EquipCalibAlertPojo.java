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
public class EquipCalibAlertPojo {

    private String equipType;
    private String equipDescription;
    private String electronicTag;
    private String serialNo;
    private String equipNo;
    private String calibDate;
    private String expirationDate;

    public EquipCalibAlertPojo() {
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

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getEquipDescription() {
        return equipDescription;
    }

    public void setEquipDescription(String equipDescription) {
        this.equipDescription = equipDescription;
    }

    public String getElectronicTag() {
        return electronicTag;
    }

    public void setElectronicTag(String electronicTag) {
        this.electronicTag = electronicTag;
    }

    public String getCalibDate() {
        return calibDate;
    }

    public void setCalibDate(String calibDate) {
        this.calibDate = calibDate;
    }
}
