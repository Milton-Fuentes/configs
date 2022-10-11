/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobStakeholderGroup;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface GlobStakeholderGroupDao extends ICrudDao<BigDecimal, GlobStakeholderGroup> {

    List<GlobStakeholderGroup> getStakeholderListByClientId(BigInteger clientId);
}
