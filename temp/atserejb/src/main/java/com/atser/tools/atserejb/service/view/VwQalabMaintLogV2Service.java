/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwQalabMaintLogV2;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface VwQalabMaintLogV2Service {

    List<VwQalabMaintLogV2> list(ManageITBodyRequest request);
    
    DataTableWrapper<VwQalabMaintLogV2> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwQalabMaintLogV2> dataGridList(ManageITBodyRequest request);
}
