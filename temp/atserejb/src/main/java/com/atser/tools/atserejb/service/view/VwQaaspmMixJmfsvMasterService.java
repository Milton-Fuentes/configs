/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwQaaspmMixJmfsvMaster;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwQaaspmMixJmfsvMasterService {

    List<VwQaaspmMixJmfsvMaster> list(ManageITBodyRequest request);

    DataTableWrapper<VwQaaspmMixJmfsvMaster> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwQaaspmMixJmfsvMaster> dataGridList(ManageITBodyRequest request);
}
