/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserutil.objects.to.cm.bidit;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author droldan
 */
@NoArgsConstructor
@Getter
@Setter
public class CmBidItAnalysis {

    List<CmBidCompanySummary> companySummary;
    Map<BigInteger, CmBidItemSummary> bidItemSummary;

    public void addBidderItems(Map<BigInteger, CmBidItemSummary> bidderMap, CmBidCompanySummary companyId) {
        if (bidderMap != null && !bidderMap.isEmpty() && companyId != null) {
            bidderMap.forEach((key, value) -> {
                if (bidItemSummary.containsKey(key)) {
                    bidItemSummary.get(key).addBidder(companyId.getContractorName(), value.getQty(), value.getUnitPrice(), value.getTotalPrice(), value.getUnit());
                }
            });
        }
    }

}
