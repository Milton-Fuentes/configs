/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.gateway;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import java.math.BigInteger;


/*  private Object contract_id;
    private Object orig_plan;
    private Object bid_item_id;
    private Object item_no;
    private Object item_desc;
    private Object item_rb;
    private Object category;
    private Object description;
    private Object unit;
    private Object plan;
    private Object unit_price;
    private Object totalqt1;
    private BigDecimal totalamt1;
    private Object totalqtd2;
    private BigDecimal totalamt2;
    private Object comp;
    private Object red_flag;
    private Object overrun;
    private Object underrun;
    private Object qty_underrun;
    private Object qty_overrun;
    private BigDecimal cost_delta;
    private Object qty_delta;*/
/**
 *
 * @author droldan
 */
public class EstimateAnalysisTO {

    private BigInteger itemNo;
    private String descriptionCode;
    private String description;
    private String unit;
    private BigDecimal originalQty;
    private BigDecimal currentQty;
    private BigDecimal unitPrice;
    private BigDecimal rangeQty;
    private BigDecimal rangeAmount;
    private BigDecimal qtyEarnedToDate;
    private BigDecimal amountEarnedToDate;
    private BigDecimal percentComp;
    private BigDecimal totalQtyDifference;
    private BigDecimal totalCostDifference;
    private BigDecimal totalamt1;
    private BigDecimal totalamt2;
    private BigDecimal cost_delta;

    public EstimateAnalysisTO() {
    }

    public BigInteger getItemNo() {
        return itemNo;
    }

    public void setItemNo(BigInteger itemNo) {
        this.itemNo = itemNo;
    }

    public String getDescriptionCode() {
        return descriptionCode;
    }

    public void setDescriptionCode(String descriptionCode) {
        this.descriptionCode = descriptionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getOriginalQty() {
        return originalQty;
    }

    public void setOriginalQty(BigDecimal originalQty) {
        this.originalQty = originalQty;
    }

    public BigDecimal getCurrentQty() {
        return currentQty;
    }

    public void setCurrentQty(BigDecimal currentQty) {
        this.currentQty = currentQty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getRangeQty() {
        return rangeQty;
    }

    public void setRangeQty(BigDecimal rangeQty) {
        this.rangeQty = rangeQty;
    }

    public BigDecimal getRangeAmount() {
        return rangeAmount;
    }

    public void setRangeAmount(BigDecimal rangeAmount) {
        this.rangeAmount = rangeAmount;
    }

    public BigDecimal getQtyEarnedToDate() {
        return qtyEarnedToDate;
    }

    public void setQtyEarnedToDate(BigDecimal qtyEarnedToDate) {
        this.qtyEarnedToDate = qtyEarnedToDate;
    }

    public BigDecimal getAmountEarnedToDate() {
        return amountEarnedToDate;
    }

    public void setAmountEarnedToDate(BigDecimal amountEarnedToDate) {
        this.amountEarnedToDate = amountEarnedToDate;
    }

    public BigDecimal getPercentComp() {
        return percentComp;
    }

    public void setPercentComp(BigDecimal percentComp) {
        this.percentComp = percentComp;
    }

    public BigDecimal getTotalQtyDifference() {
        return totalQtyDifference;
    }

    public void setTotalQtyDifference(BigDecimal totalQtyDifference) {
        this.totalQtyDifference = totalQtyDifference;
    }

    public BigDecimal getTotalCostDifference() {
        return totalCostDifference;
    }

    public void setTotalCostDifference(BigDecimal totalCostDifference) {
        this.totalCostDifference = totalCostDifference;
    }

    @JsonIgnore
    public BigDecimal getTotalamt1() {
        return totalamt1;
    }

    public void setTotalamt1(BigDecimal totalamt1) {
        this.totalamt1 = totalamt1;
    }

    @JsonIgnore
    public BigDecimal getTotalamt2() {
        return totalamt2;
    }

    public void setTotalamt2(BigDecimal totalamt2) {
        this.totalamt2 = totalamt2;
    }

    @JsonIgnore
    public BigDecimal getCost_delta() {
        return cost_delta;
    }

    public void setCost_delta(BigDecimal cost_delta) {
        this.cost_delta = cost_delta;
    }
}
