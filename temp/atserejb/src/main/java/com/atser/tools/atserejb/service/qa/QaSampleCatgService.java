/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaSampleCatg;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaSampleCatgService {

    QaSampleCatg findById(String id);

    QaSampleCatg findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaSampleCatg elem);

    void update(ManageITHeader header, QaSampleCatg elem);

    void delete(String id);

    List<QaSampleCatg> list(ManageITBodyRequest request);

    Object getsampleCatgListByClient(ManageITHeader header, ManageITBodyRequest<Object> body);
}
