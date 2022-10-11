/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobModule;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobModuleService {

    GlobModule findById(String id);

    GlobModule findById(BigDecimal id);

    void save(GlobModule elem);

    void update(GlobModule elem);

    void delete(String id);

    List<GlobModule> list(ManageITBodyRequest request);
    
    GlobModule findByModuleName(String moduleName);
}
