/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaPlist;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaPlistService {

    QaPlist findById(String id);

    QaPlist findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaPlist elem);

    void update(ManageITHeader header, QaPlist elem);

    void delete(String id);

    List<QaPlist> list(ManageITBodyRequest request);
}
