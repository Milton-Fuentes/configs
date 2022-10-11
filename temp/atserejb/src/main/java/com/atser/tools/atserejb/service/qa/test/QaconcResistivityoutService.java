/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.model.QaconcResistivityout;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaconcResistivityoutService {

    QaconcResistivityout findById(String id);

    QaconcResistivityout findBySampleIdAndCylinderNo(BigInteger sampleId, BigInteger sampletestId, Integer cNo);

    void save(QaconcResistivityout elem);

    void update(QaconcResistivityout elem);

    void delete(String id);

    Boolean existsQaconcResistivityout(BigInteger sampleId, BigInteger sampletestId, Integer cNo);

    List<QaconcResistivityout> list(ManageITBodyRequest request);
}
