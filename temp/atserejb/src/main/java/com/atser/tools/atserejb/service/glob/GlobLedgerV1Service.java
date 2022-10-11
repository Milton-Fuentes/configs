/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobLedgerV1;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;

/**
 *
 * @author mfuentes
 */
public interface GlobLedgerV1Service extends ICrudService<BigDecimal, GlobLedgerV1> {

    GlobLedgerV1 findById(ManageITHeader header, String id);

    GlobLedgerV1 findById(ManageITHeader header, BigDecimal id);

    void changeStatus(ManageITBodyRequest body);
}
