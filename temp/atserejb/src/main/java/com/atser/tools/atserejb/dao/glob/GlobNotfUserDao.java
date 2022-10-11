/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobNotfUser;
import com.atser.tools.atserejb.model.GlobNotfUserModel;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobNotfUserDao extends ICrudDao<BigDecimal, GlobNotfUser>{

    GlobNotfUser findByUserName(String username);

    List<GlobNotfUserModel> findAllUserModelInPendingStatus(String module, String functionality, BigInteger clientId, BigInteger userId);
    
    void updateUserModelStatus(String module, String functionality, BigInteger clientId, BigInteger userId);
}
