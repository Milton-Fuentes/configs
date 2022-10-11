/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobBiditemMaster;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobBiditemMasterService {

    GlobBiditemMaster findById(String id);

    BigInteger save(GlobBiditemMaster elem);

    void update(GlobBiditemMaster elem);

    void delete(String id);

    List<GlobBiditemMaster> list(ManageITBodyRequest request);

    BigDecimal findItemId(String clientId, String itemNo, String projectId);
    
    BigDecimal findItemIdFromBatch(String clientId, String itemNo, String projectId);
}
