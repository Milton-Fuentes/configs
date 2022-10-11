/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.ws;

import com.atser.tools.atserejb.dao.ws.WsDocTemplateDao;
import com.atser.tools.atserejb.model.WsDocTemplate;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class WsDocTemplateServiceImpl implements WsDocTemplateService, IBaseEJBException {

    @Inject
    private WsDocTemplateDao dao;

    @Override
    public WsDocTemplate findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public WsDocTemplate findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(WsDocTemplate elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(WsDocTemplate elem) {
        if (elem != null) {
            WsDocTemplate model = findById(elem.getId());
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
    public List<WsDocTemplate> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<WsDocTemplate> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<WsDocTemplate> finalList = list(request);
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
    public WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type) {
        return dao.findDocTemplate(clientId, functionality, type);
    }

    @Override
    public WsDocTemplate findDocTemplate(BigInteger clientId, String functionality, String type, String docCode) {
        return dao.findDocTemplate(clientId, functionality, type, docCode);
    }

}
