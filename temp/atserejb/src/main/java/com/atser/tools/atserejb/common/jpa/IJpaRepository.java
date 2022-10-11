/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.common.jpa;

import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITPaging;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITSorted;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author droldan
 * @param <PK>
 * @param <T>
 */
public interface IJpaRepository<PK extends Serializable, T> {

    T findById(PK id);

    List<T> findAll();

    List<T> filter(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted);

    List<T> filter(List<ManageITFilter<?>> filter, List<ManageITSorted> sorted, ManageITPaging paging);

    Long getTotal(List<ManageITFilter<?>> filter);
}
