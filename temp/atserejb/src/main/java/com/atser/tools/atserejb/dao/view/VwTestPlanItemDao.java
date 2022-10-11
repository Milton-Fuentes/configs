/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.IViewDao;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwTestPlanItemDao extends IViewDao<BigDecimal, VwTestPlanItem>{

    List<VwTestPlanItem> getItemsNotAddedInspection(BigInteger inspectionId, BigInteger wbsId, Boolean excludeAdded);

    List<VwTestPlanItem> getRootWbsItems(BigInteger projectId, String clientName, String itemFilter);
    
    List<VwTestPlanItem> getItemsByRms(BigInteger projectId, String clientName, String itemFilter, BigInteger wbsId);

    List<VwTestPlanItem> getSubItemsByRms(BigInteger projectId, BigInteger itemId, String clientName, String itemFilter, BigInteger wbsId);
    
    BigInteger countTotalItemByRMSNumber(BigInteger projectId, String rmsItem);
}
