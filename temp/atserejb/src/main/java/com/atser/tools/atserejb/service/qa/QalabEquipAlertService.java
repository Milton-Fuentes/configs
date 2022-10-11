/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipAlert;
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
public interface QalabEquipAlertService {

    QalabEquipAlert findById(String id);

    QalabEquipAlert findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QalabEquipAlert elem);

    void update(ManageITHeader header, QalabEquipAlert elem);

    void delete(String id);

    List<QalabEquipAlert> list(ManageITBodyRequest request);

    DataGridWrapper<QalabEquipAlert> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<QalabEquipAlert> dataTableList(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
}
