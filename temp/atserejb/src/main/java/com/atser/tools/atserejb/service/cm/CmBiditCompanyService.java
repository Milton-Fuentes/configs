/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.CmBiditCompany;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Optional;

/**
 *
 * @author droldan
 */
public interface CmBiditCompanyService extends ICrudService<BigDecimal, CmBiditCompany> {

    Optional<CmBiditCompany> findEngineerEstimationCompany(BigInteger clientId);

    Boolean exists(String companyTin);
}
