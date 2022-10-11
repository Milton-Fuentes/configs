/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.dao.view;

import com.atser.tools.atserejb.common.jpa.IViewDao;
import com.atser.tools.atserejb.model.VwBpmSubmittalAll;
import java.math.BigDecimal;

/**
 *
 * @author dperez
 */
public interface VwBpmSubmittalAllDao extends IViewDao<BigDecimal, VwBpmSubmittalAll> {

    BigDecimal getTotalOverdue(BigDecimal clientId, BigDecimal projectId, Integer fromOverdueDays, Integer toOverdueDays);
}