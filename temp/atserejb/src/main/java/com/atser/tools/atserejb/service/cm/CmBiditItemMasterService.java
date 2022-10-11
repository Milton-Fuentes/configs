/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditItemMaster;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface CmBiditItemMasterService extends ICrudService<BigDecimal, CmBiditItemMaster> {

    void changeStatus(ManageITBodyRequest request);
    
    DataGridWrapper<CmBiditItemMaster> dataTreeGridList(ManageITBodyRequest request);
    
    Boolean hasChilds(BigInteger parentId);
}
