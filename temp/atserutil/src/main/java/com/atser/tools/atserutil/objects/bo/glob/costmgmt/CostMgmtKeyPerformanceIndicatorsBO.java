/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.bo.glob.costmgmt;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class CostMgmtKeyPerformanceIndicatorsBO {

    private BigDecimal schedulePerformanceIndex;
    private BigDecimal scheduleVariance;
    private BigDecimal costPerformanceIndex;
    private BigDecimal costVariance;
    private BigDecimal varianceAtCompletion;

    public CostMgmtKeyPerformanceIndicatorsBO() {
        this.schedulePerformanceIndex = BigDecimal.ZERO;
        this.scheduleVariance = BigDecimal.ZERO;
        this.costPerformanceIndex = BigDecimal.ZERO;
        this.costVariance = BigDecimal.ZERO;
        this.varianceAtCompletion = BigDecimal.ZERO;
    }
}
