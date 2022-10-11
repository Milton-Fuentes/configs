/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobFileTk;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dperez
 */
public interface GlobFileTkService {

    GlobFileTk findById(String id);

    BigInteger save(GlobFileTk elem);

    void update(GlobFileTk elem);

    void delete(ManageITBodyRequest request);

    List<GlobFileTk> list(ManageITBodyRequest request);
    
    Optional<BigInteger> validateTokenAndGetFileId(String token);
    
}
