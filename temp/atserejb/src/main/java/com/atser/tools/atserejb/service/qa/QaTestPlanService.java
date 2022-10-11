/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaTestPlan;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaTestPlanService {

    QaTestPlan findById(String id);

    BigInteger save(QaTestPlan elem);

    void update(QaTestPlan elem);

    void delete(String id);

    List<QaTestPlan> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    QaTestPlan batchGetTestPlan(BigInteger projectId);
    
    void setBatchExecutionFlag(String test_plan_id);
    
    String getInitApproverEmail(BigInteger testplanid);
}
