/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author droldan
 * @param <PK>
 * @param <T>
 */
public interface ICrudService<PK extends Serializable, T> {

    T findById(String id);

    T findById(PK id);
    
    PK save(ManageITHeader header, T elem);

    void update(ManageITHeader header, T elem);

    void delete(String id);
    
    void delete(PK id);

    List<T> list(ManageITBodyRequest request);

    DataGridWrapper<T> dataGridList(ManageITBodyRequest request);

    DataTableWrapper<T> dataTableList(ManageITBodyRequest request);
    
    Object getVersion(Integer number);

    List getRevisions(String id);
}
