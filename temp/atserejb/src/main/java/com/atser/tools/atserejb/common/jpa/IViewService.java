/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 * @param <T>
 */
public interface IViewService<T> {

    List<T> list(ManageITBodyRequest request);

    DataGridWrapper<T> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<T> dataTableList(ManageITBodyRequest request);

}
