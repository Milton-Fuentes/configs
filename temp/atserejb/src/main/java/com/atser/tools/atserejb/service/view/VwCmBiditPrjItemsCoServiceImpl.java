/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserejb.dao.view.VwCmBiditPrjItemsCoDao;
import com.atser.tools.atserejb.model.VwCmBiditPrjItemsCo;
import com.atser.tools.atserejb.service.cm.CmBiditPrjItemsCoService;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITFilter;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class VwCmBiditPrjItemsCoServiceImpl implements VwCmBiditPrjItemsCoService, IBaseEJBException {

    @Inject
    private VwCmBiditPrjItemsCoDao dao;

    @Inject
    private CmBiditPrjItemsCoService cmBiditPrjItemsCoService;

    @Override
    public List<VwCmBiditPrjItemsCo> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwCmBiditPrjItemsCo> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<VwCmBiditPrjItemsCo> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<VwCmBiditPrjItemsCo> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwCmBiditPrjItemsCo> finalList = list(request);
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
    public DataGridWrapper<VwCmBiditPrjItemsCo> dataTreeGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Optional<Object[]> matchParentId = request.getFilter().stream().filter(p -> ((ManageITFilter<Object>) p).getField().equals("parentId")).findFirst();
            if (!matchParentId.isPresent()) {
                request.filter("parentId", "null");
            }
            return new DataGridWrapper<>(list(request), dao.getTotal(request.getFilterWithOutLikes()));
        }
        return null;
    }

    @Override
    public void updateItemBid(VwCmBiditPrjItemsCo value) {
        if (value == null) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            return;
        }
        cmBiditPrjItemsCoService.updateBidQtyAndPrice(value.getId(), value.getFinalQty(), value.getUnitPrice());
    }
}
