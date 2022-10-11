/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpmsubmittalmetadata;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface BpmSubmittalMetaDataService {

    Bpmsubmittalmetadata findById(String id);

    Bpmsubmittalmetadata findBySubmittalId(BigDecimal id);

    BigInteger save(Bpmsubmittalmetadata elem);

    BigDecimal save(ManageITHeader header, Bpmsubmittalmetadata elem);

    void update(Bpmsubmittalmetadata elem);

    void update(ManageITHeader header, Bpmsubmittalmetadata elem);

    void delete(ManageITBodyRequest request);

    List<Bpmsubmittalmetadata> list(ManageITBodyRequest request);
}
