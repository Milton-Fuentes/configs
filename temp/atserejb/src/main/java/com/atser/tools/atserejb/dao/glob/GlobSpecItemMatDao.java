/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobSpecItemMat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobSpecItemMatDao extends ICrudDao<BigDecimal, GlobSpecItemMat>{
    
    List<GlobSpecItemMat> getSpecItemMatByItemNo(BigInteger projectId, String itemType, String specItemNo);

    String getSpecItemMatNameByItemNo(BigInteger projectId, String itemType, String specItemNo);
}
