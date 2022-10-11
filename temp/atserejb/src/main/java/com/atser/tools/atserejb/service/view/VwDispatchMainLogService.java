/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwDispatchMainLog;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwDispatchMainLogService {

    VwDispatchMainLog findById(String id);

    VwDispatchMainLog findById(BigDecimal id);

    List<VwDispatchMainLog> list(ManageITBodyRequest request);

    DataGridWrapper<VwDispatchMainLog> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<VwDispatchMainLog> dataTableList(ManageITBodyRequest request);
    
    Long getTotal(ManageITBodyRequest request);
}
