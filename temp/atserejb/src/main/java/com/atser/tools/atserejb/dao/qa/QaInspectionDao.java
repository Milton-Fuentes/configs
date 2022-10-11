/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserutil.objects.bo.qa.QaInspectionSearchBO;
import com.atser.tools.atserutil.objects.pojo.qa.QaInspectionSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaInspectionDao extends ICrudDao<BigDecimal, QaInspection> {

    BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern);

    String getNextProjectSequenceNo(BigInteger clientId, BigInteger projectId);

    DataTableWrapper<QaInspectionSearchBO> getFrontEndInspectionSearch(QaInspectionSearchDefParam filters);
}
