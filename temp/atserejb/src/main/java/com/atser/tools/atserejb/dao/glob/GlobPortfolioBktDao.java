/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobPortfolioBkt;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobPortfolioBktDao extends ICrudDao<BigDecimal, GlobPortfolioBkt> {

    Boolean exists(BigInteger portfolioId, BigInteger projectId, String projectType);
}
