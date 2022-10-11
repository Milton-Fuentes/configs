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
public class LabD638TensilepropPlasticslistBO {

    private Long id;
    private Long parentid;
    private String specimenid;
    private String operator;
    private String thickness;
    private String strainAtBreak;
    private String stressAtMaxload;
    private String crossheadSpeed;
    private String spectype;
    private String gaugeLength;
    private String strainAtMaxload;
    private String tensilestressAtBreak;
    private String loadAtBreak;
    private String area;
    private String width;
    private String oraid;
    private String sampleid;
    private String status;
    private BigInteger creationdate;
    private String rejectedReason;
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
