/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobClientModules;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author droldan
 */
public interface GlobClientModulesService {

    GlobClientModules findById(String id);

    void save(GlobClientModules elem);

    void update(GlobClientModules elem);

    void delete(String id);

    List<GlobClientModules> list(ManageITBodyRequest request);

    Optional<GlobClientModules> findByClientAndModuleName(BigDecimal clientId, String moduleName);
}
