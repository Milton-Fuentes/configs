/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QasoilDensityout;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QasoilDensityoutDao extends ICrudDao<BigDecimal, QasoilDensityout> {

    QasoilDensityout findByTestIdAndNo(BigInteger testId, String no);

}
