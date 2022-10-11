/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.model.QaaspmFractureScbout;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmFractureScboutService {

    QaaspmFractureScbout findById(String id);

    QaaspmFractureScbout findBySampleIdAndSpecimenNo(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);

    void save(QaaspmFractureScbout elem);

    void update(QaaspmFractureScbout elem);

    void delete(String id);

    Boolean existsQaaspmFractureScbout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);

    List<QaaspmFractureScbout> list(ManageITBodyRequest request);
}
