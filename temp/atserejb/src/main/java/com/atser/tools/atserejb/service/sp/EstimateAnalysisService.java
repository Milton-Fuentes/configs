/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.sp;

import com.atser.tools.atserutil.objects.to.gateway.TotalEstimateAnalysisTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;

/**
 *
 * @author droldan
 */
public interface EstimateAnalysisService {

    TotalEstimateAnalysisTO filter(ManageITBodyRequest request);
}
