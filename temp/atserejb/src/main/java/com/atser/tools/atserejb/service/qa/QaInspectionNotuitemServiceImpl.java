/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaInspectionNotuitemDao;
import com.atser.tools.atserejb.model.QaInspection;
import com.atser.tools.atserejb.model.QaInspectionNotuitem;
import com.atser.tools.atserejb.model.VwTestPlanItem;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaInspectionNotuitemServiceImpl implements QaInspectionNotuitemService, IBaseEJBException {

    @Inject
    private QaInspectionNotuitemDao dao;

    @Inject
    private QaInspectionService qaInspectionService;

    @Override
    public QaInspectionNotuitem findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspectionNotuitem findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigDecimal save(ManageITHeader header, QaInspectionNotuitem elem) {
        if (elem != null) {
            if (StringSupport.isNullOrEmpty(header.getClientid()) || elem.getInspectionId() == null || elem.getBiditemIdList() == null || elem.getBiditemIdList().isEmpty()) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            // Load Inspection
            QaInspection inspId = qaInspectionService.findById(elem.getInspectionId().getId());
            if (inspId == null) {
                throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
            }
            List<QaInspectionNotuitem> batchSaveItems = new ArrayList<>();
            elem.setInspectionId(inspId);
            elem.setCreated(new Date());
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastMod(new Date());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setActive('Y');
            elem.setDeleted('N');
            elem.getBiditemIdList().forEach(it -> {
                elem.setBiditemId(new VwTestPlanItem(NumberSupport.getBigDecimal(it)));
                batchSaveItems.add(elem.clone());
            });
            dao.save(batchSaveItems);
        }
        return BigDecimal.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaInspectionNotuitem elem) {
        if (elem != null) {
            QaInspectionNotuitem model = findById(elem.getId());
            if (!model.equals(elem)) {
                elem.setLastMod(new Date());
                elem.setLastModBy(header.getUser());
                elem.setLastModIp(header.getModIp());
                model = populate(model, elem);
                if (model != null) {
                    dao.update(model);
                }
            }
        }
    }

    /**
     * Populate Parent
     *
     * @param model
     * @param elem
     * @return
     */
    private QaInspectionNotuitem populate(QaInspectionNotuitem model, QaInspectionNotuitem elem) {
        model.setWbsitemId(elem.getWbsitemId());
        model.setBiditemId(elem.getBiditemId());
        model.setReason(elem.getReason());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }
    
    @Override
    public void delete(BigDecimal id) {
        if (id != null) {
            dao.delete(id);
        }
    }

    @Override
    public List<QaInspectionNotuitem> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaInspectionNotuitem> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaInspectionNotuitem> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaInspectionNotuitem> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaInspectionNotuitem> finalList = list(request);
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
    public void changeStatus(ManageITBodyRequest request) {
        if (StringSupport.isNullOrEmpty(request.getParams().get("id")) || StringSupport.isNullOrEmpty(request.getParams().get("status"))) {
            throwBaseException(Response.Status.BAD_REQUEST, "Wrong Parameters.");
        }
        QaInspectionNotuitem model = findById(request.getParams().get("id").toString());
        model.setActive(request.getParams().get("status").toString().trim().toLowerCase().equals("true") ? 'Y' : 'N');
        dao.update(model);
    }

    @Override
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }
}
