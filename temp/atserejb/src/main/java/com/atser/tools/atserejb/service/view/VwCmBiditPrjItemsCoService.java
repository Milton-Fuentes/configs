/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.jpa.IViewService;
import com.atser.tools.atserejb.model.VwCmBiditPrjItemsCo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;

/**
 *
 * @author droldan
 */
public interface VwCmBiditPrjItemsCoService extends IViewService<VwCmBiditPrjItemsCo> {

    DataGridWrapper<VwCmBiditPrjItemsCo> dataTreeGridList(ManageITBodyRequest request);

    void updateItemBid(VwCmBiditPrjItemsCo value);
}
