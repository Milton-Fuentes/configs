/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaSampleTestDaysSpec;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleTestDaysSpecService {

    QaSampleTestDaysSpec findById(String id);

    QaSampleTestDaysSpec findById(BigDecimal id);

    QaSampleTestDaysSpec findBySampleTestIdAndTestAge(BigInteger sampleTestId, String testAge, Boolean isHours);

    void save(ManageITHeader header, QaSampleTestDaysSpec elem);

    void update(ManageITHeader header, QaSampleTestDaysSpec elem);

    void delete(String id);

    List<QaSampleTestDaysSpec> list(ManageITBodyRequest request);
}
