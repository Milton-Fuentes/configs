/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectSupplier;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectSupplierService {

    GlobProjectSupplier findById(String id);

    void save(GlobProjectSupplier elem);

    void update(GlobProjectSupplier elem);

    void delete(String id);

    List<GlobProjectSupplier> list(ManageITBodyRequest request);

    BigInteger getProjectSupplierId(ManageITBodyRequest request);
    
    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);

    Boolean exists(BigInteger projectId, BigInteger supplierId);
}
