/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobLabsMaster;
import com.atser.tools.atserutil.objects.bo.glob.contractorcontract.GlobContractorContractBO;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobLabsMasterService {

    GlobLabsMaster findById(String id);

    GlobLabsMaster findById(BigDecimal id);

    GlobLabsMaster findById(ManageITHeader header, String id);

    GlobLabsMaster findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, GlobLabsMaster elem);

    void update(ManageITHeader header, GlobLabsMaster elem);

    void delete(String id);

    List<GlobLabsMaster> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobLabsMaster> dataTableList(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    void assignLabFunction(ManageITHeader header, GlobContractorContractBO elem);
}
