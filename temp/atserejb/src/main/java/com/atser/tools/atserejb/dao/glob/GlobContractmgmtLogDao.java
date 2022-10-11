/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobContractmgmtLog;
import com.atser.tools.atserutil.objects.bo.glob.contractmgmt.GlobContractmgmtLogBO;
import com.atser.tools.atserutil.objects.pojo.glob.GlobContractmgmtLogSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobContractmgmtLogDao extends ICrudDao<BigDecimal, GlobContractmgmtLog> {

    DataTableWrapper<GlobContractmgmtLogBO> getFrontEndSearch(GlobContractmgmtLogSearchDefParam filters);

    BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern);

    String getNextProjectSequenceNo(BigInteger clientId, BigInteger projectId);
}
