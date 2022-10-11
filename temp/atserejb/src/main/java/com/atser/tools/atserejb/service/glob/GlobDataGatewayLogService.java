/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobDataGatewayLog;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobDataGatewayLogService {

    GlobDataGatewayLog findById(String id);

    void save(GlobDataGatewayLog elem);

    void update(GlobDataGatewayLog elem);

    void delete(String id);

    List<GlobDataGatewayLog> list(ManageITBodyRequest request);

    DataGridWrapper<GlobDataGatewayLog> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<GlobDataGatewayLog> dataTableList(ManageITBodyRequest request);
}
