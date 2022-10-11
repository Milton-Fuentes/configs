/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabEquiptypeV1;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QalabEquiptypeV1Service extends ICrudService<BigDecimal, QalabEquiptypeV1> {

    void save(QalabEquiptypeV1 elem);

    void update(QalabEquiptypeV1 elem);

    List<QalabEquiptypeV1> list(ManageITHeader header, ManageITBodyRequest body);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QalabEquiptypeV1> dataTableList(ManageITHeader header, ManageITBodyRequest body);

    void changeStatus(ManageITBodyRequest request);
}
