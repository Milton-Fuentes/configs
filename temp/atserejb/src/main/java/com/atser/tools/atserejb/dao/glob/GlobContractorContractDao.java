/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobContractorContract;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobContractorContractDao extends ICrudDao<BigDecimal, GlobContractorContract>{

    Boolean exists(BigInteger clientId, BigInteger projectId, BigInteger labId, BigInteger functionId);

    BigDecimal findInfoId(BigInteger projectId, String functionName);
    
    GlobContractorContract findByIdAndExtend(BigDecimal id, String extend);    
    
}
