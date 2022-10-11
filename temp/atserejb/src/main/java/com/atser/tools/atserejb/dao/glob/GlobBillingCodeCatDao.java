/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobBillingCodeCat;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface GlobBillingCodeCatDao extends ICrudDao<BigDecimal, GlobBillingCodeCat> {

    public List<GlobBillingCodeCat> listByProjectId(BigInteger clientId, BigInteger projectId);

}
