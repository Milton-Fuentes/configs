/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.cm;

import com.atser.tools.atserejb.dao.cm.CmContractActivityDao;
import com.atser.tools.atserejb.model.CmContractActivity;
import com.atser.tools.atserejb.service.glob.GlobInspworkorderService;
import com.atser.tools.atserejb.service.glob.GlobWorkorderService;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CmContractActivityServiceImpl implements CmContractActivityService, IBaseEJBException {

    @Inject
    private CmContractActivityDao dao;

    @Inject
    private GlobWorkorderService woService;

    @Inject
    private GlobInspworkorderService inspWoService;

    @Override
    public CmContractActivity findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public CmContractActivity findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(CmContractActivity elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(CmContractActivity elem) {
        if (elem != null) {
            CmContractActivity model = findById(elem.getId());
            dao.update(model);
        }
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<CmContractActivity> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<CmContractActivity> listByWorkOrder(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            List<String> inList = woService.getListActivityNo(NumberSupport.getBigInteger(request.getParams().get("projectId")));
            List<String> inInspList = inspWoService.getListActivityNo(NumberSupport.getBigInteger(request.getParams().get("projectId")));
            inList.addAll(inInspList);
            request.filter("id", inList, ":=");
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public String getActivityName(String id, String format) {
        if (id != null && !id.isEmpty() && !id.equals("-1")) {
            return dao.getActivityName(NumberSupport.getBigDecimal(id), format);
        }
        return "N/A";
    }

    @Override
    public String getActivityName(BigInteger id, String format) {
        if (id == null) {
            return "N/A";
        }
        return getActivityName(id.toString(), format);

    }

    @Override
    public DataTableWrapper<CmContractActivity> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<CmContractActivity> finalList = list(request);
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
    public DataGridWrapper<CmContractActivity> dataGridList(ManageITBodyRequest request) {
         if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<CmContractActivity> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }
}
