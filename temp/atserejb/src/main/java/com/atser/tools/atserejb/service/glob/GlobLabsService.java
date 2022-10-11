/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobLabsService {

    GlobLabs findById(String id);

    GlobLabs findById(BigDecimal id);

    GlobLabs findById(ManageITHeader header, String id);

    GlobLabs findById(ManageITHeader header, BigDecimal id);
    
    GlobLabs findById(BigInteger clientId, BigInteger labId, BigInteger functionId);

    void save(ManageITHeader header, GlobLabs elem);
    
    void save(List<GlobLabs> elem);

    void update(ManageITHeader header, GlobLabs elem);
    
    void updateLabId(GlobLabs elem);

    void delete(String id);
    
    Boolean exists(BigInteger clientId, BigInteger labId, BigInteger functionId);

    List<GlobLabs> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobLabs> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    Object getLabFunctionList(ManageITHeader header, ManageITBodyRequest<Object> body);
}
