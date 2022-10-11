/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.DotSegregaC1610;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface DotSegregaC1610Service {

    List<DotSegregaC1610> list(ManageITBodyRequest request);

    DataGridWrapper<DotSegregaC1610> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<DotSegregaC1610> dataTableList(ManageITBodyRequest request);

    String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request);
}
