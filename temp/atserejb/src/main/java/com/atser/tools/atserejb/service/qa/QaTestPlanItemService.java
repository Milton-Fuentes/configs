/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaTestPlanItem;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaTestPlanItemService {

    QaTestPlanItem findById(String id);
    
    QaTestPlanItem findById(BigDecimal id);

    BigInteger save(QaTestPlanItem elem);

    void update(QaTestPlanItem elem);

    void delete(String id);

    List<QaTestPlanItem> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    BigDecimal existItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId);
    
    BigDecimal existItemByTestplanIdAndItemIdUnderStandardItemNo(BigInteger testplanId, BigInteger itemId, String itemNo);
    
    BigDecimal existWbsItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId);
    
    BigDecimal existWbsItemByTestplanIdAndItemNo(BigInteger testplanId, String itemNo);

    void batchSaveItemFromBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId);

    void batchSaveSubItemFromSubBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId);
    
    void batchUpdateItem(QaTestPlanItem elem);
    
    void batchUpdateWbsItem(QaTestPlanItem elem);
    
    void batchUpdateIncreaseVersion(QaTestPlanItem elem);
    
    void updateWbsId(BigInteger itemId);
}
