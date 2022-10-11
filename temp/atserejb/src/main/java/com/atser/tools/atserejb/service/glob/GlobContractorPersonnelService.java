/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobContractorPersonnel;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobContractorPersonnelService {

    GlobContractorPersonnel findById(String id);

    void save(GlobContractorPersonnel elem);

    void update(GlobContractorPersonnel elem);

    void delete(String id);

    List<GlobContractorPersonnel> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobContractorPersonnel> dataTableList(ManageITBodyRequest request);

    void changeEnabled(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    Boolean existItem(String contractor_name, BigInteger clientId);

    public String generateReport(String paramReportId, String tplbasePath, String docpathsegment, String paramDocType, String clientid, ManageITBodyRequest body);


}
