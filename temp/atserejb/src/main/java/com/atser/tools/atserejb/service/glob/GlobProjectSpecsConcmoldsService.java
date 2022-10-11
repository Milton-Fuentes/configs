/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobProjectSpecsConcmolds;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectSpecsConcmoldsService {

    GlobProjectSpecsConcmolds findById(String id);

    void save(GlobProjectSpecsConcmolds elem);

    void update(GlobProjectSpecsConcmolds elem);

    void delete(String id);

    List<GlobProjectSpecsConcmolds> list(ManageITBodyRequest request);
}
