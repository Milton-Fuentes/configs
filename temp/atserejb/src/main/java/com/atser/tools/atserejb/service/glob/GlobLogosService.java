/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobLogos;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobLogosService {

    GlobLogos findById(String id);
    
    void save(GlobLogos elem);

    void update(GlobLogos elem);

    void delete(String id);

    List<GlobLogos> list(ManageITBodyRequest request);
    
    List<GlobLogos> findSystemLogoByFilter(BigInteger clientid, BigInteger projectid, BigInteger contractid, BigInteger contractorid, BigInteger labid, BigInteger functionid, BigInteger disciplineid);
}
