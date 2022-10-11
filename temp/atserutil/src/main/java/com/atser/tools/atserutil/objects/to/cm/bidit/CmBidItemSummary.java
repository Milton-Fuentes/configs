/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.cm.bidit;

import com.atser.tools.atserutil.number.CurrencySupport;
import com.atser.tools.atserutil.number.NumberSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@Getter
@Setter
@EqualsAndHashCode
public class CmBidItemSummary {

    @EqualsAndHashCode.Include
    private BigInteger id;
    @EqualsAndHashCode.Include
    private String itemNo;
    @EqualsAndHashCode.Include
    private String description;
    @EqualsAndHashCode.Include
    private BigDecimal qty;
    @EqualsAndHashCode.Include
    private BigDecimal unitPrice;
    private String unitPriceDisplay;
    @EqualsAndHashCode.Include
    private BigDecimal totalPrice;
    private String totalPriceDisplay;
    @EqualsAndHashCode.Include
    private String unit;
    private List<CmBidderSummary> bidderSummary;

    public CmBidItemSummary() {
        this.bidderSummary = new ArrayList<>();
    }

    public CmBidItemSummary(String itemNo, String description, BigDecimal qty, BigDecimal unitPrice, BigDecimal totalPrice, String unit) {
        this.itemNo = itemNo;
        this.description = description;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.unitPriceDisplay = CurrencySupport.formatBigDecimalToString(this.unitPrice, 2);
        this.totalPrice = totalPrice;
        this.totalPriceDisplay = CurrencySupport.formatBigDecimalToString(this.totalPrice, 2);
        this.unit = unit;
        this.bidderSummary = new ArrayList<>();
    }

    public void addBidder(String companyName, BigDecimal qty, BigDecimal unitPrice, BigDecimal totalPrice, String unit) {
        CmBidderSummary bs = new CmBidderSummary();
        bs.setCompanyName(companyName);
        bs.setQty(qty);
        bs.setUnitPrice(unitPrice);
        bs.setUnitPriceDisplay(CurrencySupport.formatBigDecimalToString(bs.getUnitPrice(), 2));
        bs.setTotalPrice(totalPrice);
        bs.setTotalPriceDisplay(CurrencySupport.formatBigDecimalToString(bs.getTotalPrice(), 2));
        bs.setUnit(unit);
        if (this.totalPrice != null && totalPrice != null) {
            bs.setDeviation(totalPrice.subtract(this.totalPrice));
            bs.setDeviationDisplay(CurrencySupport.formatBigDecimalToString(bs.getDeviation(), 2));
            BigDecimal pct1 = bs.getDeviation().multiply(new BigDecimal("100"));
            BigDecimal pctf = pct1.divide(this.totalPrice, 2, RoundingMode.HALF_UP);
            bs.setDevPct(pctf.toString() + " %");
        }
        this.bidderSummary.add(bs);
    }
}
