/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobCertificationTest;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCertificationTestService {

    GlobCertificationTest findById(String id);

    void save(GlobCertificationTest elem);
    
    void save(List<GlobCertificationTest> elems);

    void update(GlobCertificationTest elem);

    void delete(String id);

    List<GlobCertificationTest> list(ManageITBodyRequest request);
    
    List<GlobCertificationTest> list(ManageITHeader header, ManageITBodyRequest body);
}
