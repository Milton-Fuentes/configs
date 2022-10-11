/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwClientTests;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwClientTestsService {
    
    VwClientTests findById(String id);

    VwClientTests findById(BigDecimal id);

    List<VwClientTests> list(ManageITBodyRequest request);

    DataGridWrapper<VwClientTests> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<VwClientTests> dataTableList(ManageITBodyRequest request);
}
