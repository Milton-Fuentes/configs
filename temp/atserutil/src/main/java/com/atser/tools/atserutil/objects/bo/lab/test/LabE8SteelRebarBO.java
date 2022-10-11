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
public class LabE8SteelRebarBO {

    private Long id;
    private String specimenid;
    private String barsize;
    private String gramsPerFoot;
    private String gramsPerFootPercentoff;
    private String ultimateloadlbf;
    private String ultimatestresspsi;
    private String yieldStresspsi;
    private String elongationpercent;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;
}
