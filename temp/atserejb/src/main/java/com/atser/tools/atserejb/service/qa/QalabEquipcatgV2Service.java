/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabEquipcatgV2;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QalabEquipcatgV2Service extends ICrudService<BigDecimal, QalabEquipcatgV2> {

    void save(QalabEquipcatgV2 elem);

    void update(QalabEquipcatgV2 elem);

    Long getTotal(ManageITBodyRequest request);
}
