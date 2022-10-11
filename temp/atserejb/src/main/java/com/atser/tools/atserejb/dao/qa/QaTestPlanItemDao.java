/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QaTestPlanItem;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QaTestPlanItemDao extends ICrudDao<BigDecimal, QaTestPlanItem> {

    BigDecimal existItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId);
    
    BigDecimal existItemByTestplanIdAndItemIdUnderStandardItemNo(BigInteger testplanId, BigInteger itemId, String itemNo);
    
    BigDecimal existWbsItemByTestplanIdAndItemId(BigInteger testplanId, BigInteger itemId);
    
    BigDecimal existWbsItemByTestplanIdAndItemNo(BigInteger testplanId, String itemNo);

    void batchSaveItemFromBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId);

    void batchSaveSubItemFromSubBiditemMaster(BigInteger clientId, BigInteger testplanId, BigInteger itemId, String createdBy, String lastmodBy, String itemStatusType, BigInteger wbsId);
    
    void batchUpdateItem(QaTestPlanItem elem);
    
    void batchUpdateWbsItem(QaTestPlanItem elem);

    void updateWbsId(BigInteger itemId);

}
