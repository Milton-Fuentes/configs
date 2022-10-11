/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwBpmRfiAll;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dperez
 */
public interface VwBpmRfiAllService {

    VwBpmRfiAll findById(String id);

    VwBpmRfiAll findById(BigDecimal id);

    List<VwBpmRfiAll> list(ManageITBodyRequest request);

    DataTableWrapper<VwBpmRfiAll> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<VwBpmRfiAll> dataGridList(ManageITBodyRequest request);

    Map<String, Integer> getTotalByStatus(BigDecimal clientId, BigDecimal projectId);

    Map<String, BigDecimal> getTotalOverdue(BigDecimal clientId, BigDecimal projectId);

    Map<String, Long> getDaysByProcess(ManageITBodyRequest request);

    String generateReport(String reportId, String funcId, String tplbasePath, String docpathsegment, String docType, ManageITHeader header, ManageITBodyRequest request);

}
