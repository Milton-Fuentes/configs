/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobClientInfoDefaults;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mfuentes
 */

public interface GlobClientInfoDefaultsService extends ICrudService<BigDecimal, GlobClientInfoDefaults>{                 

    public GlobClientInfoDefaults findByClientId(BigInteger id);
    
}
