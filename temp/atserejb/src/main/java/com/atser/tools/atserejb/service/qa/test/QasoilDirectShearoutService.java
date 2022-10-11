/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.model.QasoilDirectShearout;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QasoilDirectShearoutService {

    QasoilDirectShearout findById(String id);

    QasoilDirectShearout findBySampleAndSampleTestId(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);

    void save(QasoilDirectShearout elem);

    void update(QasoilDirectShearout elem);

    void delete(String id);

    Boolean existsQasoilDirectShearout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);

    List<QasoilDirectShearout> list(ManageITBodyRequest request);
}
