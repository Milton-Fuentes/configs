/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QaTicket;
import java.math.BigDecimal;

/**
 *
 * @author droldan
 */
public interface QaTicketService extends ICrudService<BigDecimal, QaTicket> {

    String getNextDCN(String clientId, String projectId);
}