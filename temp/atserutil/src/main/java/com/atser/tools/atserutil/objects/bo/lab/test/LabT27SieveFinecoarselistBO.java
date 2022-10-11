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
public class LabT27SieveFinecoarselistBO {

    private Long id;
    private String sievename;
    private String sievevalue;
    private String sieveaccu;
    private Integer sieveorder;
    private String oraId;
    private String status;
    private BigInteger creationdate;
    private String rejectReason;
    private String equipSerialNo;

    public LabT27SieveFinecoarselistBO(Long id, String sievename, String sievevalue, Integer sieveorder, String oraId) {
        this.id = id;
        this.sievename = sievename;
        this.sievevalue = sievevalue;
        this.sieveorder = sieveorder;
        this.oraId = oraId;
    }
}
