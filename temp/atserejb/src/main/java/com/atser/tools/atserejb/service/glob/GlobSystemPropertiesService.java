/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobSystemProperties;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobSystemPropertiesService extends ICrudService<BigDecimal, GlobSystemProperties> {

    Map<String, String> getSystemPropertiesByClient(BigInteger clientId);

    String getSystemPropertiesByClientIdAndKey(BigInteger clientId, String key);
}
