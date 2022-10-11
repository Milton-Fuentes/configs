/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaaspmMixdesignJmfsvMaster;
import com.atser.tools.atserejb.model.VwQaaspmMixJmfsvMaster;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaaspmMixdesignJmfsvMasterService {

    QaaspmMixdesignJmfsvMaster findById(String id);

    QaaspmMixdesignJmfsvMaster findById(BigDecimal id);

    QaaspmMixdesignJmfsvMaster findById(ManageITHeader header, String id);

    QaaspmMixdesignJmfsvMaster findById(ManageITHeader header, BigDecimal id);

    void save(ManageITHeader header, QaaspmMixdesignJmfsvMaster elem);

    void update(ManageITHeader header, QaaspmMixdesignJmfsvMaster elem);

    void delete(String id);

    List<QaaspmMixdesignJmfsvMaster> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QaaspmMixdesignJmfsvMaster> dataTableList(ManageITBodyRequest request);

    DataGridWrapper<QaaspmMixdesignJmfsvMaster> dataGridList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);

    void updateBatch(ManageITHeader header, List<VwQaaspmMixJmfsvMaster> data);
}
