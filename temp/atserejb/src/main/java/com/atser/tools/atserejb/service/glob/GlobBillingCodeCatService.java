/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobBillingCodeCat;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author mfuentes
 */
public interface GlobBillingCodeCatService extends ICrudService<BigDecimal, GlobBillingCodeCat> {

    List<GlobBillingCodeCat> listByProjectId(ManageITHeader header, String projectId);
}
