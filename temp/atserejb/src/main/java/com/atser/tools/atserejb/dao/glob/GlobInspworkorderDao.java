/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobInspworkorder;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobInspworkorderDao extends ICrudDao<BigDecimal, GlobInspworkorder>{
    
    GlobInspworkorder findByWoToken(String tk);
    
    List<GlobInspworkorder> findByInspDispatchID(BigDecimal id);

    List<GlobInspworkorder> findByProjectID(BigInteger id);
    
    String getNextWorkOrderNumber(BigInteger projectId);
    
    List<String> getListActivityNo(BigInteger projectId);
}
