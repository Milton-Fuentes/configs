/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;
import com.atser.tools.atserejb.common.jpa.IViewService;
import com.atser.tools.atserejb.model.DotSsSgT5228;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
/**
  * @author mfuentes
 */
public interface DotSsSgT5228Service extends IViewService<DotSsSgT5228> {
    String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request);
}
