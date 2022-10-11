/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaTestPlanTests;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaTestPlanTestsService {

    QaTestPlanTests findById(String id);

    BigInteger save(QaTestPlanTests elem);

    void update(QaTestPlanTests elem);

    void delete(String id);

    List<QaTestPlanTests> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    void batchSaveItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId);

    void batchSaveSubItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId);
}
