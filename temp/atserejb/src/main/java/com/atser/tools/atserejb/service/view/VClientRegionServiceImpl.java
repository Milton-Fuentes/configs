/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.VClientRegionDao;
import com.atser.tools.atserejb.model.VClientRegion;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class VClientRegionServiceImpl implements VClientRegionService, IBaseEJBException {

    @Inject
    private VClientRegionDao dao;

    @Override
    public List<VClientRegion> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VClientRegion> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VClientRegion> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

}
