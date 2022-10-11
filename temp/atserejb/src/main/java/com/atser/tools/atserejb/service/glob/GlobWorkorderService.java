/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobWorkorder;
import com.atser.tools.atserutil.objects.pojo.glob.GlobSheduleSearchDefParam;
import com.atser.tools.atserutil.objects.to.dispatch.WorkOrderTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobWorkorderService {

    GlobWorkorder findById(String id);
    
    GlobWorkorder findById(BigInteger id);
    
    GlobWorkorder findById(BigDecimal id);
    
    GlobWorkorder findByWoToken(String tk);

    BigInteger save(GlobWorkorder elem);
    
    BigInteger save(ManageITHeader header, GlobWorkorder elem);

    void update(GlobWorkorder elem);
    
    void updateWoToken(GlobWorkorder elem);
    
    void frontUpdate(GlobWorkorder elem);
    
    void frontUpdate(ManageITHeader header, GlobWorkorder elem);

    void delete(String id);

    List<GlobWorkorder> list(ManageITBodyRequest request);

    // Particular Querys
    String getNextWorkOrderNumber(BigInteger projectId);
    
    Map<String, String> getNextWorkOrderNumbers(BigInteger projectId);
    
    List<String> getListActivityNo(BigInteger projectId);
    
    List<WorkOrderTO> filterAndGetWorkOrderTO(GlobSheduleSearchDefParam filters);
    
    Boolean validateWoToken(String token);
}
