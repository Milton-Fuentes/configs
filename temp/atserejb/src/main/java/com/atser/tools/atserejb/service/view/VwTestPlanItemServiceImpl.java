/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.view;

import com.atser.tools.atserejb.dao.view.VwTestPlanItemDao;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class VwTestPlanItemServiceImpl implements VwTestPlanItemService, IBaseEJBException {

    @Inject
    private VwTestPlanItemDao dao;

    @Override
    public VwTestPlanItem findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public VwTestPlanItem findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public VwTestPlanItem findById(BigInteger id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public List<VwTestPlanItem> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<VwTestPlanItem> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwTestPlanItem> finalList = list(request);
            if (request.isSearchFilterActive()) {
                filtered = dao.getTotal(request.getFilter());
            } else {
                filtered = count;
            }
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<VwTestPlanItem> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<VwTestPlanItem> finalList = list(request);
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
    public List<DataSelectWrapper> getItemsNotAddedInspection(ManageITBodyRequest<Object> body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("inspectionId"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        Boolean includeModel = (StringSupport.isNullOrEmpty(body.getParams().get("imod"))) ? Boolean.FALSE : StringSupport.getBoolean(body.getParams().get("imod"));
        Boolean excludeAdded = (StringSupport.isNullOrEmpty(body.getParams().get("excludeadded"))) ? Boolean.FALSE : StringSupport.getBoolean(body.getParams().get("excludeadded"));
        // Get WBS
        BigInteger wbsId = BigInteger.ZERO;
        if (StringSupport.isNotNullAndNotEmpty(body.getParams().get("wbsId"))) {
            wbsId = NumberSupport.getBigInteger(body.getParams().get("wbsId"));
        }

        List<VwTestPlanItem> ds = dao.getItemsNotAddedInspection(NumberSupport.getBigInteger(body.getParams().get("inspectionId")), wbsId, excludeAdded);
        if (ds == null || ds.isEmpty()) {
            return new ArrayList<>();
        }
        return ds.stream().map(p -> new DataSelectWrapper(p.getId(), p.getItemNoDescription(), (includeModel ? p : null))).collect(Collectors.toList());
    }

    @Override
    public List<VwTestPlanItem> getRootWbsItems(ManageITBodyRequest<Object> body) {
        // Add Project Type
        if (StringSupport.isNullOrEmpty(body.getParams().get("projectId"), body.getParams().get("clientName"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.getRootWbsItems(NumberSupport.getBigInteger(body.getParams().get("projectId")), StringSupport.getString(body.getParams().get("clientName")), StringSupport.getString(body.getParams().get("rmsFilter")));
    }

    @Override
    public List<VwTestPlanItem> getItemsByRms(ManageITBodyRequest<Object> body) {
        // Add Project Type
        if (StringSupport.isNullOrEmpty(body.getParams().get("projectId"), body.getParams().get("clientName"), body.getParams().get("rmsFilter"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger wbsId = BigInteger.ZERO;
        if (StringSupport.isNotNullAndNotEmpty(body.getParams().get("wbsId"))) {
            wbsId = NumberSupport.getBigInteger(body.getParams().get("wbsId"));
        }
        return dao.getItemsByRms(NumberSupport.getBigInteger(body.getParams().get("projectId")), StringSupport.getString(body.getParams().get("clientName")), StringSupport.getString(body.getParams().get("rmsFilter")), wbsId);
    }

    @Override
    public List<VwTestPlanItem> getSubItemsByRms(ManageITBodyRequest<Object> body) {
        if (StringSupport.isNullOrEmpty(body.getParams().get("projectId"), body.getParams().get("itemId"), body.getParams().get("clientName"), body.getParams().get("rmsFilter"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        BigInteger wbsId = BigInteger.ZERO;
        if (StringSupport.isNotNullAndNotEmpty(body.getParams().get("wbsId"))) {
            wbsId = NumberSupport.getBigInteger(body.getParams().get("wbsId"));
        }
        return dao.getSubItemsByRms(NumberSupport.getBigInteger(body.getParams().get("projectId")), NumberSupport.getBigInteger(body.getParams().get("itemId")), StringSupport.getString(body.getParams().get("clientName")), StringSupport.getString(body.getParams().get("rmsFilter")), wbsId);
    }

    @Override
    public BigInteger countTotalItemByRMSNumber(ManageITBodyRequest<Object> body) {
        // Add Project Type
        if (StringSupport.isNullOrEmpty(body.getParams().get("projectId"), body.getParams().get("rmsItem"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        return dao.countTotalItemByRMSNumber(NumberSupport.getBigInteger(body.getParams().get("projectId")), StringSupport.getString(body.getParams().get("rmsItem")));
    }
}
