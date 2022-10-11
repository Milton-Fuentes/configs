/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa.test;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QasteelWeldListout;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mfuentes
 */
public interface QasteelWeldListoutDao extends ICrudDao<BigDecimal, QasteelWeldListout> {

    Integer getNextTestNo(BigInteger testId);

    QasteelWeldListout findByTestId(BigInteger testId);

}
