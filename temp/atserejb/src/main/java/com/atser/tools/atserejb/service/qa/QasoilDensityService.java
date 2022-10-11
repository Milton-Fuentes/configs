/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QasoilDensity;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QasoilDensityService {

    QasoilDensity findById(String id);

    QasoilDensity findById(BigDecimal id);

    QasoilDensity findBySampleTestId(BigInteger id);

    void save(ManageITHeader header, QasoilDensity elem);

    void update(ManageITHeader header, QasoilDensity elem);

    void delete(String id);

    List<QasoilDensity> list(ManageITBodyRequest request);
}
