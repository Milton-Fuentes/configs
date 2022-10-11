/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.GlobMenu;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author droldan
 */
public interface GlobMenuService extends ICrudService<BigDecimal, GlobMenu> {

    void delete(ManageITBodyRequest request);

    void saveDataFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void updateDataFileDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void saveFileToDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void updateFileDb(Map<String, Object> metaDataFile, Map<String, Object> params);

    void changeStatus(ManageITBodyRequest request);

    Boolean exists(String email);

    List<DataSelectWrapper> listForSelect(ManageITBodyRequest request);

    List<GlobMenu> listByRoleName(String roleName, Boolean isAdmin, BigDecimal parentId, BigDecimal moduleId, BigDecimal clientId);
}
