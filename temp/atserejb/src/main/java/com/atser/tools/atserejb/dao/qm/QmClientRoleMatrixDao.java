/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QmClientRoleMatrix;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface QmClientRoleMatrixDao extends ICrudDao<BigDecimal, QmClientRoleMatrix>{
    
    Boolean getRoleRightMatrixList(BigInteger clientId, String currentRole, String ruleName);
    Map<String, Boolean> getRoleRightsMatrixList(BigInteger clientId, String currentRole, List<String> rulesNames);
}
