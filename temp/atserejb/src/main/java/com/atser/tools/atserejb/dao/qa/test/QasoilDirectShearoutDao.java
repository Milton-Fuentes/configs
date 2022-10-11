/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QasoilDirectShearout;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QasoilDirectShearoutDao extends ICrudDao<BigDecimal, QasoilDirectShearout> {

    QasoilDirectShearout findBySampleAndSampleTestId(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);

    Boolean existsQasoilDirectShearout(BigInteger sampleId, BigInteger sampletestId, BigInteger specNo);
}
