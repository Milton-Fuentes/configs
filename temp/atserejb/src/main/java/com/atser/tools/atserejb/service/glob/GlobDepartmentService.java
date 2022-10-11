/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobDepartment;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobDepartmentService {

    GlobDepartment findById(String id);

    void save(GlobDepartment elem);

    void update(GlobDepartment elem);

    void delete(String id);

    List<GlobDepartment> list(ManageITBodyRequest request);
}
