/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwWorkOrder;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mdelabat
 */
public interface VwWorkOrderService {

    VwWorkOrder findById(String id);

    VwWorkOrder findById(BigDecimal id);

    List<VwWorkOrder> list(ManageITBodyRequest request);

    DataGridWrapper<VwWorkOrder> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<VwWorkOrder> dataTableList(ManageITBodyRequest request);
    
    Long getTotal(ManageITBodyRequest request);
}
