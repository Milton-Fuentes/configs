/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.interceptor.annotation.LatencyLogger;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.VwBpmTaskInstanceBoDao;
import com.atser.tools.atserejb.model.VwBpmTaskInstanceBo;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VwBpmTaskInstanceBoServiceImpl implements VwBpmTaskInstanceBoService, IBaseEJBException {

    @Inject
    private VwBpmTaskInstanceBoDao dao;

    @Override
    public VwBpmTaskInstanceBo findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public VwBpmTaskInstanceBo findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public DataTableWrapper<VwBpmTaskInstanceBo> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwBpmTaskInstanceBo> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataTableWrapper<>(count, filtered, finalList);
        }
        return null;
    }

    @Override
    public DataGridWrapper<VwBpmTaskInstanceBo> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @LatencyLogger
    @Override
    public List<VwBpmTaskInstanceBo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
