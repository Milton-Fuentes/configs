/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaTestPlanTests;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaTestPlanTestsDao extends ICrudDao<BigDecimal, QaTestPlanTests> {

    void batchSaveItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId);

    void batchSaveSubItemTestFromMaster(BigInteger testplanId, BigInteger itemId, String createdBy, BigInteger wbsId);
}
