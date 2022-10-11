/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobCertificationAgency;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCertificationAgencyService {

    GlobCertificationAgency findById(String id);
    
    GlobCertificationAgency findById(BigDecimal id);

    void save(ManageITHeader header, GlobCertificationAgency elem);

    void update(GlobCertificationAgency elem);

    void update(ManageITHeader header, GlobCertificationAgency elem);

    void delete(String id);

    List<GlobCertificationAgency> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobCertificationAgency> dataTableList(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
}
