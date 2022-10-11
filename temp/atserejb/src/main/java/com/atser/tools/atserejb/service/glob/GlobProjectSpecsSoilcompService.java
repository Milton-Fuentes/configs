/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectSpecsSoilcomp;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectSpecsSoilcompService {

    GlobProjectSpecsSoilcomp findById(String id);

    void save(GlobProjectSpecsSoilcomp elem);

    void update(GlobProjectSpecsSoilcomp elem);

    void delete(String id);

    List<GlobProjectSpecsSoilcomp> list(ManageITBodyRequest request);
}
