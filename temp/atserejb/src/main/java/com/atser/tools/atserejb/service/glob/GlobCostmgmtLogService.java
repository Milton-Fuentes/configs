/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobCostmgmtLog;
import com.atser.tools.atserutil.objects.bo.glob.costmgmt.CostMgmtKeyPerformanceIndicatorsBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobCostmgmtLogSearchDefParam;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCostmgmtLogService extends ICrudService<BigDecimal, GlobCostmgmtLog> {

    GlobCostmgmtLog findById(ManageITHeader header, String id);

    GlobCostmgmtLog findById(ManageITHeader header, BigDecimal id);

    Object getFrontEndSearch(ManageITHeader header, GlobCostmgmtLogSearchDefParam defParam);

    void changeStatus(ManageITBodyRequest body);

    String generateReport(String tplbasePath, String docpathsegment, ManageITHeader header, GlobCostmgmtLogSearchDefParam defParam);
    
    List<CostMgmtKeyPerformanceIndicatorsBO> generateKeyPerformanceIndicators(ManageITHeader header, GlobCostmgmtLogSearchDefParam defParam);
}
