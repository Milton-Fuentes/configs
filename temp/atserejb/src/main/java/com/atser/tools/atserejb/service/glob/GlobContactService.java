/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobContact;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobContactService {

    GlobContact findById(String id);
    
    GlobContact findById(BigInteger id);
    
    GlobContact findByFirstAndLastName(BigInteger clientId, String firstname, String lastname);
    
    BigDecimal findByContactIdByEmail(BigInteger clientId, String email);

    void save(GlobContact elem);

    void update(GlobContact elem);

    void delete(String id);

    List<GlobContact> list(ManageITBodyRequest request);
}
