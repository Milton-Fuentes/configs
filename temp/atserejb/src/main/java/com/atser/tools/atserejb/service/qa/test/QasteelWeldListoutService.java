/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QasteelWeldListout;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mfuentes
 */
public interface QasteelWeldListoutService extends ICrudService<BigDecimal, QasteelWeldListout> {

    QasteelWeldListout findByTestId(BigInteger testId);

    void calcTest(QasteelWeldListout model);

    void deleteByTestId(String id);

}
