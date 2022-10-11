/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditPrjItemsCo;
import java.math.BigDecimal;

/**
 *
 * @author mdelabat
 */
public interface CmBiditPrjItemsCoService extends ICrudService<BigDecimal, CmBiditPrjItemsCo> {

    void updateBidQtyAndPrice(BigDecimal id, BigDecimal qty, BigDecimal price);
}
