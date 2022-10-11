/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobClientEquipcatg;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobClientEquipcatgService {

    GlobClientEquipcatg findById(String id);

    void save(GlobClientEquipcatg elem);

    void update(GlobClientEquipcatg elem);

    void delete(String id);

    List<GlobClientEquipcatg> list(ManageITBodyRequest request);
}
