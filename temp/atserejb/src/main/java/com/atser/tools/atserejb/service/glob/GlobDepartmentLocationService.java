/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobDepartmentLocation;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobDepartmentLocationService {

    GlobDepartmentLocation findById(String id);

    void save(GlobDepartmentLocation elem);

    void update(GlobDepartmentLocation elem);

    void delete(String id);

    List<GlobDepartmentLocation> list(ManageITBodyRequest request);
}
