/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobUsersApproval;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.Optional;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author droldan
 */
public interface GlobUsersApprovalService extends ICrudService<BigDecimal, GlobUsersApproval> {

    void approveUser(ManageITHeader header, ManageITBodyRequest<Object> request, TemplateEngine engine);

    Optional<GlobUsersApproval> findByUsername(String username);
}
