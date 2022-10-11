/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobSpecItemMat;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobSpecItemMatService {

    GlobSpecItemMat findById(String id);
    
    GlobSpecItemMat findById(BigDecimal id);

    void save(GlobSpecItemMat elem);

    void update(GlobSpecItemMat elem);

    void delete(String id);

    List<GlobSpecItemMat> list(ManageITBodyRequest request);
    
    List<GlobSpecItemMat> getSpecItemMatByItemNo(BigInteger projectId, String itemType, String specItemNo);
    
    String getSpecItemMatNameByItemNo(BigInteger projectId, String itemType, String specItemNo);
}
