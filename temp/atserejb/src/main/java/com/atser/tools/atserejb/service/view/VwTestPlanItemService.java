/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface VwTestPlanItemService {

    VwTestPlanItem findById(String id);

    VwTestPlanItem findById(BigDecimal id);
    
    VwTestPlanItem findById(BigInteger id);

    List<VwTestPlanItem> list(ManageITBodyRequest request);

    DataGridWrapper<VwTestPlanItem> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<VwTestPlanItem> dataTableList(ManageITBodyRequest request);

    List<DataSelectWrapper> getItemsNotAddedInspection(ManageITBodyRequest<Object> body);
    
    List<VwTestPlanItem> getRootWbsItems(ManageITBodyRequest<Object> body);

    List<VwTestPlanItem> getItemsByRms(ManageITBodyRequest<Object> body);

    List<VwTestPlanItem> getSubItemsByRms(ManageITBodyRequest<Object> body);
    
    BigInteger countTotalItemByRMSNumber(ManageITBodyRequest<Object> body);
}
