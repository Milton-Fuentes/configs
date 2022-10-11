/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.BpmProcessTracking;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface BpmProcessTrackingService extends ICrudService<BigDecimal, BpmProcessTracking> {

    BpmProcessTracking saveAndGet(ManageITHeader header, BpmProcessTracking elem);

    BpmProcessTracking saveAndGet(ManageITHeader header, ManageITBodyRequest request);
}
