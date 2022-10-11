/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipinfoProjectV1;
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
public interface QalabEquipinfoProjectV1Service {

    QalabEquipinfoProjectV1 findById(String id);

    QalabEquipinfoProjectV1 findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QalabEquipinfoProjectV1 elem);

    void update(ManageITHeader header, QalabEquipinfoProjectV1 elem);

    void delete(String id);

    List<QalabEquipinfoProjectV1> list(ManageITBodyRequest request);

    DataGridWrapper<QalabEquipinfoProjectV1> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<QalabEquipinfoProjectV1> dataTableList(ManageITBodyRequest request);

    Boolean exists(BigInteger equipId, BigInteger projectId);

    String generateReport(String reportId, String tplbasePath, String docpathsegment, String docType, String clientId, ManageITBodyRequest request);
}
