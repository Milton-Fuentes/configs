/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobIaSpec;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobIaSpecService {

    GlobIaSpec findById(String id);

    void save(GlobIaSpec elem);

    void update(GlobIaSpec elem);

    void delete(String id);

    List<GlobIaSpec> list(ManageITBodyRequest request);

    BigDecimal getMaxSpecIdByTypeAndClient(String specType, BigInteger clientId);
}
