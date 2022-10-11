/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabMainttypeV1;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QalabMainttypeV1Service extends ICrudService<BigDecimal, QalabMainttypeV1> {

    void save(QalabMainttypeV1 elem);

    void update(QalabMainttypeV1 elem);

    Long getTotal(ManageITBodyRequest request);
}
