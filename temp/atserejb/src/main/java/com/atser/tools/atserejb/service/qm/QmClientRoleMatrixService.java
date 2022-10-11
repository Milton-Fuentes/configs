/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.model.QmClientRoleMatrix;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface QmClientRoleMatrixService {

    QmClientRoleMatrix findById(String id);

    QmClientRoleMatrix findById(BigDecimal id);

    void save(QmClientRoleMatrix elem);

    void update(QmClientRoleMatrix elem);

    void delete(String id);

    List<QmClientRoleMatrix> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QmClientRoleMatrix> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    Boolean hasRoleRigth(ManageITHeader header, Boolean isAdmin, String ruleName);

    Boolean hasRoleRigth(String clientId, String current_role, Boolean isAdmin, String ruleName);

    Map<String, Boolean> hasRoleRigths(String clientId, String current_role, Boolean isAdmin, String rulesNames);
}
