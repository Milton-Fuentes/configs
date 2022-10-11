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
public class LabT22ConcreteCprsnStrBO {

    private Long id;
    private String specimenid;
    private Integer age;
    private String ageUnittime;
    private String ratedpsi;
    private String testDatetime;
    private String breaktype;
    private String technician;
    private String breakdistance;
    private String weight;
    private String ultimateForce;
    private String diameter;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;
}
