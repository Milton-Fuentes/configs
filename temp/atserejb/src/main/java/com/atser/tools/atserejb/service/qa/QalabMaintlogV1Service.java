/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabMaintlogV1;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QalabMaintlogV1Service extends ICrudService<BigDecimal, QalabMaintlogV1> {

    QalabMaintlogV1 findById(ManageITHeader header, String id);

    QalabMaintlogV1 findById(ManageITHeader header, BigDecimal id);

    void update(QalabMaintlogV1 elem);

    Long getTotal(ManageITBodyRequest request);
}
