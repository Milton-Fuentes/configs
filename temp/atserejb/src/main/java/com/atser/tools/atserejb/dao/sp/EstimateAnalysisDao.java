/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.sp;

import com.atser.tools.atserutil.objects.to.gateway.TotalEstimateAnalysisTO;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface EstimateAnalysisDao {

    TotalEstimateAnalysisTO filter(BigDecimal contractId, String startdate, String enddate);
}
