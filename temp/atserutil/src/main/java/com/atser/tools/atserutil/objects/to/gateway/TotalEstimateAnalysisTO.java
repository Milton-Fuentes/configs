/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.gateway;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public class TotalEstimateAnalysisTO {
    private List<EstimateAnalysisTO> list;
    private BigDecimal rangeAmountTotal;
    private BigDecimal amountEarnedTotal;
    private BigDecimal costTotal;

    public TotalEstimateAnalysisTO() {
    }

    public TotalEstimateAnalysisTO(List<EstimateAnalysisTO> list, BigDecimal rangeAmountTotal, BigDecimal amountEarnedTotal, BigDecimal costTotal) {
        this.list = list;
        this.rangeAmountTotal = rangeAmountTotal;
        this.amountEarnedTotal = amountEarnedTotal;
        this.costTotal = costTotal;
    }

    public List<EstimateAnalysisTO> getList() {
        return list;
    }

    public void setList(List<EstimateAnalysisTO> list) {
        this.list = list;
    }

    public BigDecimal getRangeAmountTotal() {
        return rangeAmountTotal;
    }

    public void setRangeAmountTotal(BigDecimal rangeAmountTotal) {
        this.rangeAmountTotal = rangeAmountTotal;
    }

    public BigDecimal getAmountEarnedTotal() {
        return amountEarnedTotal;
    }

    public void setAmountEarnedTotal(BigDecimal amountEarnedTotal) {
        this.amountEarnedTotal = amountEarnedTotal;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }
}
