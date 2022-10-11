/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.model.QmPersonnel;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QmPersonnelService {

    QmPersonnel findById(String id);

    void save(QmPersonnel elem);

    void update(QmPersonnel elem);

    void delete(String id);

    List<QmPersonnel> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QmPersonnel> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
    
    Boolean checkMain(BigDecimal contractId);
}
