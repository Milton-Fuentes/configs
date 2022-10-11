/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobContactCert;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobContactCertService {

    GlobContactCert findById(String id);

    GlobContactCert findById(BigDecimal id);

    GlobContactCert findById(ManageITHeader header, String id);

    GlobContactCert findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, GlobContactCert elem);

    void update(GlobContactCert elem);

    void update(ManageITHeader header, GlobContactCert elem);

    void delete(String id);

    List<GlobContactCert> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobContactCert> dataTableList(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    List<GlobContactCert> filterByProject(String projectId);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);
    
    String generateReportByProject(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, String projectId, ManageITBodyRequest request);
}
