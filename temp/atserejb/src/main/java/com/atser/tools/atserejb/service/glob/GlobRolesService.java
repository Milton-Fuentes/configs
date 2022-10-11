/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobRoles;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dperez
 */
public interface GlobRolesService {

    GlobRoles findById(String id);

    BigInteger save(GlobRoles elem);

    void update(GlobRoles elem);

    void delete(ManageITBodyRequest request);

    List<GlobRoles> list(ManageITBodyRequest request);
    
    List<GlobRoles> listAll();
    
    List<Object[]> getModuleRoles(BigInteger clientId);    
    
    List<DataSelectWrapper> getModuleRolesForSelect(BigInteger clientId);

    Optional<GlobRoles> findByRoleName(String roleName);

}
