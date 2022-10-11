/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaaspmMixdesignJmfMaster;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignJmfMasterDao extends ICrudDao<BigDecimal, QaaspmMixdesignJmfMaster> {

    Boolean exists(BigInteger mixId, BigInteger jmfno);

    List<QaaspmMixdesignJmfMaster> filterJmfByProject(BigInteger projectId, BigInteger mixId);

    void deactiveMain(BigInteger mixId);

    BigInteger getNextJMFNo(BigInteger mixId);
}
