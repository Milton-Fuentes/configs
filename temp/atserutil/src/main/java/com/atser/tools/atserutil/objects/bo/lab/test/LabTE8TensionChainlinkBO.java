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
public class LabTE8TensionChainlinkBO {

    private Long id;
    private String specimenid;
    private String diameter;
    private String ultimateload;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;
}
