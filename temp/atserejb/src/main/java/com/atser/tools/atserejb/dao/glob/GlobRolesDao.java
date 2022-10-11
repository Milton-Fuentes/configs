/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobRoles;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dperez
 */
public interface GlobRolesDao extends ICrudDao<BigDecimal, GlobRoles>{
    
    List<Object[]> getModuleRoles(BigInteger clientId);
    
    Optional<GlobRoles> findByRoleName(String roleName);
}
