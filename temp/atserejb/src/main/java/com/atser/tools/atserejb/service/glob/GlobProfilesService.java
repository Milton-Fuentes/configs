/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProfiles;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProfilesService {

    GlobProfiles findById(String id);
    
    List<GlobProfiles> findByUserId(BigInteger id);
    
    List<GlobProfiles> findByUserId(BigDecimal id);

    void save(GlobProfiles elem);

    void update(GlobProfiles elem);

    void delete(String id);

    List<GlobProfiles> list(ManageITBodyRequest request);
    
    List<String> getEmailListByRole(String role_name, BigInteger clientId);
}
