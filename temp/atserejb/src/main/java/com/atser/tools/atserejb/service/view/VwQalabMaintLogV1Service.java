/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwQalabMaintLogV1;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwQalabMaintLogV1Service {

    List<VwQalabMaintLogV1> list(ManageITBodyRequest request);

    DataTableWrapper<VwQalabMaintLogV1> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwQalabMaintLogV1> dataGridList(ManageITBodyRequest request);
}
