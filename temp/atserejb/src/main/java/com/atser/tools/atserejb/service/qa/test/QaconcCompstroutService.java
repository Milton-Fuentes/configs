/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.model.QaconcCompstrout;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaconcCompstroutService {

    QaconcCompstrout findById(String id);
    
    QaconcCompstrout findByTestIdAndNo(BigInteger testId, String no);

    void save(QaconcCompstrout elem);

    void update(QaconcCompstrout elem);

    void delete(String id);

    List<QaconcCompstrout> list(ManageITBodyRequest request);
}
