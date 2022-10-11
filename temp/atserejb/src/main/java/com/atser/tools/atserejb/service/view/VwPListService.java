/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwPList;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwPListService {

    List<VwPList> list(ManageITBodyRequest request);

    DataGridWrapper<VwPList> dataGridList(ManageITBodyRequest request);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String projectId, String clientId, ManageITBodyRequest request);
}
