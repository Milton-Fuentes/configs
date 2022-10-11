/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaaspmMixdesigns;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignsService {

    QaaspmMixdesigns findById(String id);

    QaaspmMixdesigns findById(BigDecimal id);

    QaaspmMixdesigns findById(ManageITHeader header, String id);

    QaaspmMixdesigns findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, QaaspmMixdesigns elem);

    void update(ManageITHeader header, QaaspmMixdesigns elem);

    void delete(String id);

    List<QaaspmMixdesigns> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QaaspmMixdesigns> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    Boolean exists(BigInteger projectId, String name);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    void changeStatusByMasterId(Character status, BigInteger masterId);
}
