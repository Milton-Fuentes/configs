/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobMgmtPlanDoc;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobMgmtPlanDocService extends ICrudService<BigDecimal, GlobMgmtPlanDoc> {

    GlobMgmtPlanDoc findById(ManageITHeader header, String id);

    GlobMgmtPlanDoc findById(ManageITHeader header, BigDecimal id);

    void changeStatus(ManageITBodyRequest body);

    void uploadDocument(Map<String, Object> metaDataFile, Map<String, Object> params);
}
