/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.glob;

import com.atser.tools.atserejb.common.jpa.ICrudDao;
import com.atser.tools.atserejb.model.GlobContact;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author droldan
 */
public interface GlobContactDao extends ICrudDao<BigDecimal, GlobContact> {

    GlobContact findByFirstAndLastName(BigInteger clientId, String firstname, String lastname);

    BigDecimal findByContactIdByEmail(BigInteger clientId, String email);
    
    Boolean existByEmail(String email);
}
