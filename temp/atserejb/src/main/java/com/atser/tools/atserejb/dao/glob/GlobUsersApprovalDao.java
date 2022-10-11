/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobUsersApproval;
import java.math.BigDecimal;
import java.util.Optional;

/**
 *
 * @author droldan
 */
public interface GlobUsersApprovalDao extends ICrudDao<BigDecimal, GlobUsersApproval> {

    Boolean existsGlobalByUsername(String username);

    Boolean existsGlobalByEmail(String email);

    Optional<GlobUsersApproval> findByUsername(String username);
}
