/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwBpmProcessBo;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface VwBpmProcessBoService {

    VwBpmProcessBo findById(String id);

    VwBpmProcessBo findById(BigDecimal id);

    List<VwBpmProcessBo> list(ManageITBodyRequest request);

    DataTableWrapper<VwBpmProcessBo> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwBpmProcessBo> dataGridList(ManageITBodyRequest request);

}
