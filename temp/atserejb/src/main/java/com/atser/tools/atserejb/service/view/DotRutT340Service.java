package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.jpa.IViewService;
import com.atser.tools.atserejb.model.DotRutT340;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 * @author mfuentes
 */
public interface DotRutT340Service extends IViewService<DotRutT340> {

    String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request);
}
