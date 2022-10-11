/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QaInspectionSignflowdef;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QaInspectionSignflowdefService {

    QaInspectionSignflowdef findById(String id);

    QaInspectionSignflowdef findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QaInspectionSignflowdef elem);

    void update(ManageITHeader header, QaInspectionSignflowdef elem);

    void delete(String id);

    List<QaInspectionSignflowdef> list(ManageITBodyRequest request);

    DataGridWrapper<QaInspectionSignflowdef> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<QaInspectionSignflowdef> dataTableList(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
}
