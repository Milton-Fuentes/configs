/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobProfiles;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProfilesDao extends ICrudDao<BigDecimal, GlobProfiles>{
    
    List<GlobProfiles> findByUserId(BigInteger id);
    
    List<String> getEmailListByRole(String role_name, BigInteger clientId);
}
