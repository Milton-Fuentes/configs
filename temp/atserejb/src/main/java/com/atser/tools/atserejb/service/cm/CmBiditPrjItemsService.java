/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditPrjItems;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author mdelabat
 */
public interface CmBiditPrjItemsService extends ICrudService<BigDecimal, CmBiditPrjItems> {

    void changeStatus(ManageITBodyRequest request);

    DataGridWrapper<CmBiditPrjItems> dataTreeGridList(ManageITBodyRequest request);

    void copyItemFromMaster(ManageITHeader header, ManageITBodyRequest request);
}
