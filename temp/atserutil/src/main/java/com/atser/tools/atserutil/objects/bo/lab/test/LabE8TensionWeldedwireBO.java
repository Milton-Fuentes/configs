/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.lab.test;

import java.math.BigInteger;
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
public class LabE8TensionWeldedwireBO {

    private Long id;
    private String specimenid;
    private String wireCode;
    private String wireSizeSpecmin;
    private String wireSizeSpecmax;
    private String horizontalVertical;
    private String meshsize;
    private String diameter;
    private String ultimateforcelbf;
    private String ultimatestresspsi;
    private String areareductionpercent;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;
}
