/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.common.jpa.ICrudService;
import com.atser.tools.atserejb.model.QalabEquiptypeV2;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface QalabEquiptypeV2Service extends ICrudService<BigDecimal, QalabEquiptypeV2> {

    void save(QalabEquiptypeV2 elem);

    void update(QalabEquiptypeV2 elem);

    List<QalabEquiptypeV2> list(ManageITHeader header, ManageITBodyRequest body);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<QalabEquiptypeV2> dataTableList(ManageITHeader header, ManageITBodyRequest body);

    void changeStatus(ManageITBodyRequest request);
}
