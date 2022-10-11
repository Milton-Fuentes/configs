/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobCustomConfigUser;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface GlobCustomConfigUserService extends ICrudService<BigDecimal, GlobCustomConfigUser> {

    void updateBatch(ManageITHeader header, List<GlobCustomConfigUser> data);
}
