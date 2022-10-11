/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobFunctions;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFunctionsService {

    GlobFunctions findById(String id);

    GlobFunctions findById(BigDecimal id);

    void save(GlobFunctions elem);

    void update(GlobFunctions elem);

    void delete(String id);

    List<GlobFunctions> list(ManageITBodyRequest request);
    
    List<DataSelectWrapper> filterByProject(String projectId, String labId);
}
