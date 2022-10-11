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
public class LabT350AspmMscrDsrBO {

    private Long id;
    private String sampleid;
    private String avgPctRecov01;
    private String avgPctRecov32;
    private String pctDiff;
    private String avgNoncoverCreepCompl01;
    private String avgNoncoverCreepCompl32;
    private String pctDiff2;
    private String status;
    private Long testId;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;

    public String getCutSampleId() {
        return this.sampleid.substring(0, 11);
    }
    
    public String getCutSerialNo() {
        return this.sampleid.substring(12);
    }
}
