/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwQaLabEquipInfoTestV1;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwQaLabEquipInfoTestV1Service {

    List<VwQaLabEquipInfoTestV1> list(ManageITBodyRequest request);

    DataGridWrapper<VwQaLabEquipInfoTestV1> dataGridList(ManageITBodyRequest request);
}
