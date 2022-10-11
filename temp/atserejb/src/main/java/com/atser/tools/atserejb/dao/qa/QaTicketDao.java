/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.qa;

import com.atser.tools.atserejb.model.QaTicket;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.atser.tools.atserejb.common.jpa.ICrudDao;

/**
 *
 * @author droldan
 */
public interface QaTicketDao extends ICrudDao<BigDecimal, QaTicket>{

    String getNextDCN(BigInteger clientId, BigInteger projectId);
}
