/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaSampleTestEquip;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaSampleTestEquipService extends ICrudService<BigDecimal, QaSampleTestEquip> {

    BigDecimal save(QaSampleTestEquip elem);
    
    Boolean exists(BigInteger sampleTestId, BigInteger equipId);
}
