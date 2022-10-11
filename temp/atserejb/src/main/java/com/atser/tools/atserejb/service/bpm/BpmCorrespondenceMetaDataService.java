/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.Bpmcorrespondencemetadata;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface BpmCorrespondenceMetaDataService {

    Bpmcorrespondencemetadata findById(String id);

    Bpmcorrespondencemetadata findByCorrespondenceId(BigDecimal id);

    BigInteger save(Bpmcorrespondencemetadata elem);

    BigDecimal save(ManageITHeader header, Bpmcorrespondencemetadata elem);

    void update(Bpmcorrespondencemetadata elem);

    void update(ManageITHeader header, Bpmcorrespondencemetadata elem);

    void delete(ManageITBodyRequest request);

    List<Bpmcorrespondencemetadata> list(ManageITBodyRequest request);
}
