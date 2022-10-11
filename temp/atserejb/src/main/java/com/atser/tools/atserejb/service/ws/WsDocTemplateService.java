/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface WsDocTemplateService {

    WsDocTemplate findById(String id);

    void save(WsDocTemplate elem);

    void update(WsDocTemplate elem);

    void delete(String id);

    List<WsDocTemplate> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<WsDocTemplate> dataTableList(ManageITBodyRequest request);

    WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type);

    WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type, String docCode);
}
