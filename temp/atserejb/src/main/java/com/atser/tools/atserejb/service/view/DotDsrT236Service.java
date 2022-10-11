package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.jpa.IViewService;
import com.atser.tools.atserejb.model.DotDsrT236;
import com.atser.tools.atserutil.objects.to.ReportGridColumnsTO;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 * * @author mfuentes
 */
public interface DotDsrT236Service extends IViewService<DotDsrT236> {

    String generateReport(String docpathsegment, String docType, List<ReportGridColumnsTO> columns, String clientId, ManageITBodyRequest request);
}