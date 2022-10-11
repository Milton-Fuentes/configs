/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobServicesField;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;

/**
 *
 * @author droldan
 */
public interface GlobServicesFieldService extends ICrudService<BigDecimal, GlobServicesField>{

    void save(GlobServicesField elem);

    void update(GlobServicesField elem);
    
    GlobServicesField findByAbbrvAndClientId(String serviceAbbrv, BigInteger clientId);
    
    DataTableWrapper<GlobServicesField> dataTableList(ManageITBodyRequest request);
    
    GlobServicesField findById(ManageITHeader header, String id);
    
    void update(ManageITHeader header, GlobServicesField elem);
}
