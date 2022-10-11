/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.model.WsReport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface WsReportService {

    WsReport findById(String id);

    void save(WsReport elem);

    void update(WsReport elem);

    void delete(String id);

    List<WsReport> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<WsReport> dataTableList(ManageITBodyRequest request);
    
    WsReport findReport(BigInteger clientId, String functionality, String code);
}
