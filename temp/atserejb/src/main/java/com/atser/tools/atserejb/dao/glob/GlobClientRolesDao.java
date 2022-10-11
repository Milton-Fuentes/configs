/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobClientRoles;
import java.math.BigDecimal;

/**
 *
 * @author dperez
 */
public interface GlobClientRolesDao extends ICrudDao<BigDecimal, GlobClientRoles> {

    String getRoleName(BigDecimal roleId, String moduleName, BigDecimal clientId);
}