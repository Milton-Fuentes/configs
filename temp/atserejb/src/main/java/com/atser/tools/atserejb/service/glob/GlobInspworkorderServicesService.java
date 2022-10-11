/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobInspworkorderServices;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobInspworkorderServicesService {

    GlobInspworkorderServices findById(String id);

    BigInteger save(GlobInspworkorderServices elem);

    void saveAll(List<GlobInspworkorderServices> elems);

    void update(GlobInspworkorderServices elem);

    void delete(String id);

    List<GlobInspworkorderServices> list(ManageITBodyRequest request);

    /* Particular Querys */
    List<GlobInspworkorderServices> findByWOId(BigInteger id);

    void deleteAllByWOId(BigInteger id);

    Integer getCountWORecords(BigInteger id);
}
