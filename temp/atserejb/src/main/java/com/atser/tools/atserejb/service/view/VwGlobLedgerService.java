/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwGlobLedger;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface VwGlobLedgerService {

    List<VwGlobLedger> list(ManageITBodyRequest request);

    DataTableWrapper<VwGlobLedger> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwGlobLedger> dataGridList(ManageITBodyRequest request);
    
    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);
}
