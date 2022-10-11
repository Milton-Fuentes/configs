/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.dispatch;

import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public class DispatchCalllogSpecimenTO {

    private BigDecimal calllogId;
    private String specNo;

    public DispatchCalllogSpecimenTO() {
    }

    public DispatchCalllogSpecimenTO(BigDecimal calllogId, String specNo) {
        this.calllogId = calllogId;
        this.specNo = specNo;
    }

    public BigDecimal getCalllogId() {
        return calllogId;
    }

    public void setCalllogId(BigDecimal calllogId) {
        this.calllogId = calllogId;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }
}
