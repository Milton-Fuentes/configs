/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaInspectionSignflowdefDao;
import com.atser.tools.atserejb.model.QaInspectionSignflowdef;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import com.atser.tools.atserutil.string.StringSupport;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QaInspectionSignflowdefServiceImpl implements QaInspectionSignflowdefService, IBaseEJBException {

    @Inject
    private QaInspectionSignflowdefDao dao;

    @Override
    public QaInspectionSignflowdef findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspectionSignflowdef findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QaInspectionSignflowdef elem) {
        if (elem != null) {
            elem.setCreated(new Date());
            elem.setCreatedBy(header.getUser());
            elem.setCreatedByIp(header.getModIp());
            elem.setLastMod(new Date());
            elem.setLastModIp(header.getModIp());
            elem.setLastModBy(header.getUser());
            elem.setActive('Y');
            return dao.save(elem).getId().toBigInteger();
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QaInspectionSignflowdef elem) {
        if (elem != null) {
            QaInspectionSignflowdef model = findById(elem.getId());
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
     * @param model
     * @param elem
     * @return 
     */
    private QaInspectionSignflowdef populate(QaInspectionSignflowdef model, QaInspectionSignflowdef elem) {
        model.setInspectionTypeId(elem.getInspectionTypeId());
        model.setSimplecatId(elem.getSimplecatId());
        model.setSignOrder(elem.getSignOrder());
        model.setSignRuleName(elem.getSignRuleName());
        return null;
    }
    
    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QaInspectionSignflowdef> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QaInspectionSignflowdef> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QaInspectionSignflowdef> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QaInspectionSignflowdef> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QaInspectionSignflowdef> finalList = list(request);
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
        QaInspectionSignflowdef model = findById(request.getParams().get("id").toString());
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
