/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.model.CmContractActivity;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author droldan
 */
public interface CmContractActivityService {

    CmContractActivity findById(String id);

    void save(CmContractActivity elem);

    void update(CmContractActivity elem);

    void delete(String id);

    List<CmContractActivity> list(ManageITBodyRequest request);
    
    DataTableWrapper<CmContractActivity> dataTableList(ManageITBodyRequest request);
    
    DataGridWrapper<CmContractActivity> dataGridList(ManageITBodyRequest request);

    /**
     * Get Activity Name
     *
     * @param id
     * @param format : [nd - Number+ Description] [n - Number] [nf - Number +
     * ActivityFullName]
     * @return
     */
    String getActivityName(String id, String format);

    String getActivityName(BigInteger id, String format);
    
    // Review
    List<CmContractActivity> listByWorkOrder(ManageITBodyRequest request);
}
