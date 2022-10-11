/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.CmBiditItemMaster;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface CmBiditItemMasterDao extends ICrudDao<BigDecimal, CmBiditItemMaster> {

    Boolean hasChilds(BigInteger parentId);
    
    void deleteChilds(BigInteger parentId);
    
    void disableChilds(BigInteger parentId);
    
    void setParent(BigInteger id);
}
