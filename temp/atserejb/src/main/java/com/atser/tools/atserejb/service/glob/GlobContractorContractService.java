/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobContractorContract;
import com.atser.tools.atserejb.model.GlobProject;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobContractorContractService extends ICrudService<BigDecimal, GlobContractorContract> {

    void save(GlobContractorContract elem);

    void saveDefault(GlobProject elem);

    void update(GlobContractorContract elem);

    Long getTotal(ManageITBodyRequest request);

    Boolean exists(BigInteger clientId, BigInteger projectId, BigInteger labId, BigInteger functionId);

    BigDecimal findInfoId(BigInteger projectId, String functionName);

    GlobContractorContract findByIdAndExtend(BigDecimal id, String extend);
}
