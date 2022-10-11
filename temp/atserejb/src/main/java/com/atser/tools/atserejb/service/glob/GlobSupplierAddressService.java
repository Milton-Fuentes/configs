/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobSupplierAddress;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobSupplierAddressService {

    GlobSupplierAddress findById(String id);

    void save(GlobSupplierAddress elem);

    void update(GlobSupplierAddress elem);
    
    void updateMainLocationBySupplierId(BigInteger supplierId, String location);

    void delete(String id);

    List<GlobSupplierAddress> list(ManageITBodyRequest request);

    GlobSupplierAddress getMainLocationBySupplierId(BigInteger supplierId);
}
