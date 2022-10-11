/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobSievelist;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobSievelistService {

    GlobSievelist findById(String id);

    BigDecimal findIdByCommonName(String commonname);

    void save(GlobSievelist elem);

    void update(GlobSievelist elem);

    void delete(String id);

    List<GlobSievelist> list(ManageITBodyRequest request);
}
