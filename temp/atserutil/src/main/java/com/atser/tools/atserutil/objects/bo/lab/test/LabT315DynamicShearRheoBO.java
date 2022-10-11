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
public class LabT315DynamicShearRheoBO {

    private Long id;
    private String sampleid;
    private String temp;
    private String gsin;
    private String angle;
    private String status;
    private Long testId;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;

    public String getCutSampleId() {
        try {
            return this.sampleid.substring(0, 11);
        } catch (StringIndexOutOfBoundsException ex) {
            return "";
        }
    }

    public String getCutSerialNo() {
        try {
            return this.sampleid.substring(12);
        } catch (StringIndexOutOfBoundsException ex) {
            return "";
        }
    }
}
