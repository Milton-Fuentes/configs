/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmDailyLocation;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmDailyLocationService {

    CmDailyLocation findById(String id);

    void save(CmDailyLocation elem);

    void update(CmDailyLocation elem);

    void delete(String id);

    List<CmDailyLocation> list(ManageITBodyRequest request);

    String getDailyLocation(String locationId);

    String getDailyLocation(BigInteger locationId);
}
