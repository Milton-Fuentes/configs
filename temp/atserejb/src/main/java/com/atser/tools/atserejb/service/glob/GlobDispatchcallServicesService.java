/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobDispatchcallServices;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobDispatchcallServicesService {

    GlobDispatchcallServices findById(String id);

    BigInteger save(GlobDispatchcallServices elem);
    
    void saveAll(List<GlobDispatchcallServices> elems);

    void update(GlobDispatchcallServices elem);

    void delete(String id);

    List<GlobDispatchcallServices> list(ManageITBodyRequest request);

    /* Particular Querys */
    
    List<GlobDispatchcallServices> findByCallLogId(BigInteger id);
    
    void deleteAllByCallLogId(BigInteger id);
    
    Integer getCountCallLogRecords(BigInteger id);
}
