/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectClient;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectClientService {

    GlobProjectClient findById(String id);

    void save(GlobProjectClient elem);

    void update(GlobProjectClient elem);

    void delete(String id);

    List<GlobProjectClient> list(ManageITBodyRequest request);
    
    Object getFrontEndProjectClientListByCurrentProfile(ManageITHeader header, ManageITBodyRequest body);
}
