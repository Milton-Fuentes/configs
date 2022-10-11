/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.model.GlobCatgColorList;
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
public interface GlobCatgColorListService {

    GlobCatgColorList findById(String id);

    GlobCatgColorList findById(BigDecimal id);

    void save(ManageITHeader header, GlobCatgColorList elem);

    void update(GlobCatgColorList elem);

    void update(ManageITHeader header, GlobCatgColorList elem);

    void delete(String id);

    List<GlobCatgColorList> list(ManageITBodyRequest request);

    Long getTotal(ManageITBodyRequest request);

    DataTableWrapper<GlobCatgColorList> dataTableList(ManageITBodyRequest request);
    
    DataGridWrapper<GlobCatgColorList> dataGridList(ManageITBodyRequest request);

    void changeStatus(ManageITBodyRequest request);

    Object getVersion(Integer number);

    List getRevisions(String id);
}
