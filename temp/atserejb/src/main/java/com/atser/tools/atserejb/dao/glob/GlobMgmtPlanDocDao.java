/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobMgmtPlanDoc;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobMgmtPlanDocDao extends ICrudDao<BigDecimal, GlobMgmtPlanDoc> {

    void deactiveMain(BigInteger planId);

    BigInteger getNextGlobalSequenceNo(BigInteger planId);
}
