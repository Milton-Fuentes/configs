/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobLabs;
import com.atser.tools.atserutil.objects.bo.glob.lab.GlobLabsBO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobLabsDao extends ICrudDao<BigDecimal, GlobLabs>{
    
    GlobLabs findById(BigInteger clientId, BigInteger labId, BigInteger functionId);

    Boolean exists(BigInteger clientId, BigInteger labId, BigInteger functionId);
    
    String getLabFunctionFilterByUser(String userId, String clientId, boolean isAdmin, String projectId);
    
    List<GlobLabsBO> getLabFunctionListModel(String userId, String clientId, boolean isAdmin, BigInteger projectId);
}
