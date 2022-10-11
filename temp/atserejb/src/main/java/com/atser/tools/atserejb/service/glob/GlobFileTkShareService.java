/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobFileTkShare;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface GlobFileTkShareService {

    GlobFileTkShare findById(String id);

    BigInteger save(GlobFileTkShare elem);

    void update(GlobFileTkShare elem);

    void delete(ManageITBodyRequest request);

    List<GlobFileTkShare> list(ManageITBodyRequest request);
    
}
