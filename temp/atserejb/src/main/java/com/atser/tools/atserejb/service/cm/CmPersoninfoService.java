/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmPersoninfo;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmPersoninfoService {

    CmPersoninfo findById(String id);
    
    CmPersoninfo findById(BigDecimal id);

    BigInteger save(CmPersoninfo elem);

    void update(CmPersoninfo elem);

    void delete(ManageITBodyRequest request);

    List<CmPersoninfo> list(ManageITBodyRequest request);
    
    List<Object[]> getCmTitles(BigInteger clientId);
    
    List<Object[]> getCmFirm(BigInteger clientId);
    
    List<DataSelectWrapper> getCmTitlesForSelect(BigInteger clientId);
    
    List<DataSelectWrapper> getCmFirmForSelect(BigInteger clientId);
}
