/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.pojo.qa.labcompliance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipInfoBarcodePojo {

    private String equipType;
    private String bcode;
    private String labLocation;
    private String serialNo;
    private String manufacturer;
    private String model;
    private String prevCalibDate;
    private String nextCalibDate;
}
