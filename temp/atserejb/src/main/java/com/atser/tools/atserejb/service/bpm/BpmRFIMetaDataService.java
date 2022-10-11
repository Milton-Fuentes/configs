/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpmrfimetadata;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface BpmRFIMetaDataService {

    Bpmrfimetadata findById(String id);

    Bpmrfimetadata findByRfiId(BigDecimal id);

    BigInteger save(Bpmrfimetadata elem);

    BigDecimal save(ManageITHeader header, Bpmrfimetadata elem);

    void update(Bpmrfimetadata elem);

    void update(ManageITHeader header, Bpmrfimetadata elem);

    void delete(ManageITBodyRequest request);

    void delete(String id);

    List<Bpmrfimetadata> list(ManageITBodyRequest request);
}
