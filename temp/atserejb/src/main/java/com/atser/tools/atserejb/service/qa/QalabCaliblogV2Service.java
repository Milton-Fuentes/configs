/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabCaliblogV2;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QalabCaliblogV2Service extends ICrudService<BigDecimal, QalabCaliblogV2> {

    QalabCaliblogV2 findById(ManageITHeader header, String id);

    QalabCaliblogV2 findById(ManageITHeader header, BigDecimal id);

    void update(QalabCaliblogV2 elem);

    Long getTotal(ManageITBodyRequest request);

    QalabCaliblogV2 getLastCalibrationLog(BigDecimal eqId);
}
