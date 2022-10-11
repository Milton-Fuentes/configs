/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobBinderSupplier;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface GlobBinderSupplierService {

    GlobBinderSupplier findById(String id);

    void save(GlobBinderSupplier elem);

    void update(GlobBinderSupplier elem);

    void delete(String id);

    List<GlobBinderSupplier> list(ManageITBodyRequest request);

    public String generateReport(String paramReportId, String tplbasePath, String docpathsegment, String paramDocType, String clientid, ManageITBodyRequest body);

}
