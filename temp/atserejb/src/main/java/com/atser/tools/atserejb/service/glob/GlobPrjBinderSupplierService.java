/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobPrjBinderSupplier;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface GlobPrjBinderSupplierService {

    GlobPrjBinderSupplier findById(String id);

    void save(GlobPrjBinderSupplier elem);

    void update(GlobPrjBinderSupplier elem);

    void delete(String id);

    List<GlobPrjBinderSupplier> list(ManageITBodyRequest request);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);
}
