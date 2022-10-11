/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.DotConfreezeAT166;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface DotConfreezeAT166Service {

    List<DotConfreezeAT166> list(ManageITBodyRequest request);

    DataGridWrapper<DotConfreezeAT166> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<DotConfreezeAT166> dataTableList(ManageITBodyRequest request);

    String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request);
}
