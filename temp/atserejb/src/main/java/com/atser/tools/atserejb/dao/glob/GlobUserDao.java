/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobUsers;
import java.math.BigDecimal;

/**
 *
 * @author dperez
 */
public interface GlobUserDao extends ICrudDao<BigDecimal, GlobUsers> {

    Boolean existByUserName(String username);

    GlobUsers findBySSO(String username, String passwd);

    void unlockUserAccounts();

    GlobUsers findByPersonInfoId(BigDecimal piId);

    String getUserEmail(BigDecimal userId);
}
