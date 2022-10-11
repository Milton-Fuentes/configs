/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.cm.bidit;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CmBidderSummary {
    private String devPct;
    private String companyName;
    private BigDecimal qty;
    private BigDecimal unitPrice;
    private String unitPriceDisplay;
    private BigDecimal totalPrice;
    private String totalPriceDisplay;
    private String unit;
    private BigDecimal deviation;
    private String deviationDisplay;
}
