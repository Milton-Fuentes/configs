/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobFlags;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobFlagsService {

    GlobFlags findById(String id);
    
    GlobFlags findById(BigDecimal id);

    void save(GlobFlags elem);

    void update(GlobFlags elem);

    void delete(String id);

    List<GlobFlags> list(ManageITBodyRequest request);
}
