/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmManagementFirm;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmManagementFirmService {

    CmManagementFirm findById(String id);

    void save(CmManagementFirm elem);

    void update(CmManagementFirm elem);

    void delete(String id);

    List<CmManagementFirm> list(ManageITBodyRequest request);
}
