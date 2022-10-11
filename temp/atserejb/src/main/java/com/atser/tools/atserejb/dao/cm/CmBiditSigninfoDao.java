/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.cm;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.CmBiditSigninfo;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author mdelabat
 */
public interface CmBiditSigninfoDao extends ICrudDao<BigDecimal,CmBiditSigninfo> {

    Boolean isSignedOff(BigInteger clientId, BigInteger refId, BigInteger typeId);
}
