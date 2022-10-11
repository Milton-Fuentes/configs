/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobCustomConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCustomConfigService extends ICrudService<BigDecimal, GlobCustomConfig> {

    String findValueByClientAndFunctionalityAndNameAndUserId(BigInteger clientId, String functionality, String name, BigInteger userId);

    List<GlobCustomConfig> listPendingConfigsByClientAndFunctionalityAndUserId(BigInteger clientId, String functionality, BigInteger userId);
}
