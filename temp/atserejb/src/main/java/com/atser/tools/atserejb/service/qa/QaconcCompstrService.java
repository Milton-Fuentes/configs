/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaSample;
import com.atser.tools.atserejb.model.QaconcCompstr;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaconcCompstrService {

    QaconcCompstr findById(String id);

    QaconcCompstr findById(BigDecimal id);
    
    QaconcCompstr findBySampleTestId(BigInteger id);

    void save(ManageITHeader header, QaconcCompstr elem);

    void update(ManageITHeader header, QaconcCompstr elem);

    void delete(String id);

    List<QaconcCompstr> list(ManageITBodyRequest request);   
    
    QaconcCompstr createEmptyOrGet(ManageITHeader header, QaSample sampleId, BigInteger sampleTestId);
    
}
