/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobProjectClient;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobProjectClientDao extends ICrudDao<BigDecimal, GlobProjectClient>{
    
    List<GlobProjectClient> getFrontEndProjectClientListByCurrentProfile(String userId, String clientId, boolean isAdmin,boolean uses_global_profiles, String functionId);
}