/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobClientTest;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobClientTestDao extends ICrudDao<BigDecimal, GlobClientTest> {

    public GlobClientTest findByTestId(BigInteger clientId, BigInteger testId);

    public GlobClientTest findBySampleTestId(BigInteger clientId, BigInteger sampleTesttId);
}
