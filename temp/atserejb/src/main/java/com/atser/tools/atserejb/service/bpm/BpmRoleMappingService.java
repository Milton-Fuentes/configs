/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.model.BpmRoleMapping;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface BpmRoleMappingService {

    BpmRoleMapping findById(String id);

    BpmRoleMapping findByManageItRoleAndClientID(String role, BigInteger id);

    void save(BpmRoleMapping elem);

    void update(BpmRoleMapping elem);

    void delete(String id);

    List<BpmRoleMapping> list(ManageITBodyRequest request);
}
