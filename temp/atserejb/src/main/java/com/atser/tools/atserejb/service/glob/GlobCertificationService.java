/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobCertification;
import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCertificationService extends ICrudService<BigDecimal, GlobCertification>{
    
    Long getTotal(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);
    
    List<VwClientTests> findAllPendingTest(String clientId, String certificationId);
}
