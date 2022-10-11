/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwCompanyList;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author dperez
 */
public interface VwCompanyListService {

    VwCompanyList findById(String id);

    VwCompanyList findById(BigDecimal id);

    List<VwCompanyList> list(ManageITBodyRequest request);

    List<String> listNamesByClient(BigInteger clientId);

    DataGridWrapper<VwCompanyList> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<VwCompanyList> dataTableList(ManageITBodyRequest request);

}
