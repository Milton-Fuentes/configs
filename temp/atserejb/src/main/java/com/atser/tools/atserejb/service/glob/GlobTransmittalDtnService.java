/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobTransmittalDtn;
import java.math.BigDecimal;

/**
 *
 * @author mfuentes
 */
public interface GlobTransmittalDtnService extends ICrudService<BigDecimal, GlobTransmittalDtn> {

    public void update(GlobTransmittalDtn elem);

}
