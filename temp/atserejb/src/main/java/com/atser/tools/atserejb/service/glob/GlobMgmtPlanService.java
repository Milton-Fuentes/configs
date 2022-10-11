/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobMgmtPlan;
import com.atser.tools.atserutil.objects.pojo.glob.GlobMgmtPlanSearchDefParam;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface GlobMgmtPlanService extends ICrudService<BigDecimal, GlobMgmtPlan> {

    GlobMgmtPlan findById(ManageITHeader header, String id);

    GlobMgmtPlan findById(ManageITHeader header, BigDecimal id);

    Object getFrontEndSearch(ManageITHeader header, GlobMgmtPlanSearchDefParam defParam);

    void changeStatus(ManageITBodyRequest body);

    String generateReport(String tplbasePath, String docpathsegment, ManageITHeader header, GlobMgmtPlanSearchDefParam defParam);
}
