/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwProctorAttLimit;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwProctorAttLimitService {

    List<VwProctorAttLimit> list(ManageITBodyRequest request);

    DataGridWrapper<VwProctorAttLimit> dataGridList(ManageITBodyRequest request);
}
