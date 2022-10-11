/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.CmBiditPrjCatg;
import com.atser.tools.atserutil.objects.bo.cm.CmBidITPrjCatgSearchBO;
import com.atser.tools.atserutil.objects.pojo.cm.CmBidITPrjCatgSearchDefParam;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidCompanySummary;
import com.atser.tools.atserutil.objects.to.cm.bidit.CmBidItemSummary;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mdelabat
 */
public interface CmBiditPrjCatgDao extends ICrudDao<BigDecimal, CmBiditPrjCatg> {

    DataTableWrapper<CmBidITPrjCatgSearchBO> getFrontEndSearch(CmBidITPrjCatgSearchDefParam filters);

    BigInteger getNextGlobalSequenceNo(BigInteger clientId, String spattern);

    String getNextProjectSequenceNo(BigInteger clientId, BigInteger projectId);

    List<CmBidCompanySummary> getCompanySummary(BigInteger prjCatgId);

    Map<BigInteger, CmBidItemSummary> getBidItemSummary(BigInteger prjCatgId, Boolean isEngineerEstimation);

    Map<BigInteger, CmBidItemSummary> getBidItemSummary(BigInteger prjCatgId, Boolean isEngineerEstimation, BigInteger companyId);
}
