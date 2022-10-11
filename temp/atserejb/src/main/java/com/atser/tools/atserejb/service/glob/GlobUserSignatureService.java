/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobUserSignature;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobUserSignatureService {

    GlobUserSignature findById(String id);

    GlobUserSignature findByUserId(String id);

    BigInteger save(GlobUserSignature elem);

    void update(GlobUserSignature elem);

    void delete(ManageITBodyRequest request);

    List<GlobUserSignature> list(ManageITBodyRequest request);
}
