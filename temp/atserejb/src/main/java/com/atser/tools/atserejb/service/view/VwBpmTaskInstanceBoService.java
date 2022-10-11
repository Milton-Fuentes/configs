/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwBpmTaskInstanceBo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwBpmTaskInstanceBoService {

    VwBpmTaskInstanceBo findById(String id);

    VwBpmTaskInstanceBo findById(BigDecimal id);

    List<VwBpmTaskInstanceBo> list(ManageITBodyRequest request);

    DataTableWrapper<VwBpmTaskInstanceBo> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwBpmTaskInstanceBo> dataGridList(ManageITBodyRequest request);

}
