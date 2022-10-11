/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwBpmDispatchBo;
import com.atser.tools.atserutil.bpm.BonitaBpmSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import org.bonitasoft.engine.exception.BonitaException;

/**
 *
 * @author droldan
 */
public interface VwBpmDispatchBoService {

    List<VwBpmDispatchBo> list(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    DataGridWrapper<VwBpmDispatchBo> dataGridList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;

    DataTableWrapper<VwBpmDispatchBo> dataTableList(ManageITBodyRequest request, BonitaBpmSupport session) throws BonitaException;
}
