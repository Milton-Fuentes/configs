/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaTestMethods;
import com.atser.tools.atserutil.objects.bo.qa.QaTestMethodsBO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaTestMethodsDao extends ICrudDao<BigDecimal, QaTestMethods> {

    List<QaTestMethodsBO> getTestMethodsByCatg(String clientId, String catgId);

    List<QaTestMethods> getTestMethodsByCatgAndTestTable(BigInteger clientId, String catg, String testTable);

    public QaTestMethods findBySampleTestId(BigInteger sampleTestId);
}
