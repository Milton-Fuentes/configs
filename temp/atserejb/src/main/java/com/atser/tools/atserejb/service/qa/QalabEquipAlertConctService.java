/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.model.QalabEquipAlertConct;
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
public interface QalabEquipAlertConctService {

    QalabEquipAlertConct findById(String id);

    QalabEquipAlertConct findById(BigDecimal id);

    BigInteger save(ManageITHeader header, QalabEquipAlertConct elem);

    void update(ManageITHeader header, QalabEquipAlertConct elem);

    void delete(String id);

    List<QalabEquipAlertConct> list(ManageITBodyRequest request);

    DataGridWrapper<QalabEquipAlertConct> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<QalabEquipAlertConct> dataTableList(ManageITBodyRequest request);
}
