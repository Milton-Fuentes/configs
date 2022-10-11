/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.QalabEquipinfoProjectV1;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface QalabEquipinfoProjectV1Dao extends ICrudDao<BigDecimal, QalabEquipinfoProjectV1> {

    Boolean exists(BigInteger equipId, BigInteger projectId);
}
