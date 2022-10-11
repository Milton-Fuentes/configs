/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaSampleTestBillingItem;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface QaSampleTestBillingItemDao extends ICrudDao<BigDecimal, QaSampleTestBillingItem> {

    public List<QaSampleTestBillingItem> listBySampleTestId(BigInteger sampleTestId);

}
