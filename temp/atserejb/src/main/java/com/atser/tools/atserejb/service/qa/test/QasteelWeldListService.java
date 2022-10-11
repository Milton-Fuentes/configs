/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa.test;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QasteelWeldList;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mfuentes
 */
public interface QasteelWeldListService extends ICrudService<BigDecimal, QasteelWeldList> {

    QasteelWeldList findByTestId(BigInteger testId);

    void calcTest(QasteelWeldList model);

    void deleteByTestId(String id);
}
