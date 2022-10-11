/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobClientTest;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobClientTestService extends ICrudService<BigDecimal, GlobClientTest> {

    void save(GlobClientTest elem);

    void update(GlobClientTest elem);

    GlobClientTest findByTestId(String clientId, String testId);

    Long getTotal(ManageITBodyRequest request);

    List<DataSelectWrapper> listForSelect(ManageITBodyRequest request);

    public GlobClientTest findBySampleTestId(String clientId, String testId);
}
