/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabMainttypeV2;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QalabMainttypeV2Service extends ICrudService<BigDecimal, QalabMainttypeV2> {

    void save(QalabMainttypeV2 elem);

    void update(QalabMainttypeV2 elem);

    Long getTotal(ManageITBodyRequest request);
}
