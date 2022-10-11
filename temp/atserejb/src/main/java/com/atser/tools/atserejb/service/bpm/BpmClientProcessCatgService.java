/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.bpm;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.BpmClientProcessCatg;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface BpmClientProcessCatgService extends ICrudService<BigDecimal, BpmClientProcessCatg> {

    List<BpmClientProcessCatg> getProcessByFunctionality(BigInteger functionalityId);
}
