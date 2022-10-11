/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QalabEquipAlertDao;
import com.atser.tools.atserejb.model.QalabEquipAlert;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataGridWrapper;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.common.ManageITHeader;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

@Stateless
public class QalabEquipAlertServiceImpl implements QalabEquipAlertService, IBaseEJBException {

    @Inject
    private QalabEquipAlertDao dao;

    @Override
    public QalabEquipAlert findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QalabEquipAlert findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public BigInteger save(ManageITHeader header, QalabEquipAlert elem) {
        if (elem != null) {
            if (!dao.exists(NumberSupport.getBigInteger(header.getClientid()), elem.getAlertType())) {
                elem.setClientId(NumberSupport.getBigInteger(header.getClientid()));
                elem.setCreated(new Date());
                elem.setCreatedBy(header.getUser());
                elem.setCreatedByIp(header.getModIp());
                elem.setLastMod(new Date());
                elem.setLastModIp(header.getModIp());
                elem.setLastModBy(header.getUser());
                elem.setActive('Y');
                return dao.save(elem).getId().toBigInteger();
            } else {
                throwBaseException(Response.Status.CONFLICT, "This Alert already exists.");
            }
        }
        return BigInteger.ZERO;
    }

    @Override
    public void update(ManageITHeader header, QalabEquipAlert elem) {
        if (elem != null) {
            QalabEquipAlert model = findById(elem.getId());
            if (!model.equals(elem)) {
                if (!model.getAlertType().equals(elem.getAlertType()) && dao.exists(NumberSupport.getBigInteger(header.getClientid()), elem.getAlertType())) {
                    throwBaseException(Response.Status.CONFLICT, "This Alert already exists.");
                }
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
    private QalabEquipAlert populate(QalabEquipAlert model, QalabEquipAlert elem) {
        model.setAlertType(elem.getAlertType());
        model.setAlertAtDays(elem.getAlertAtDays());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QalabEquipAlert> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public DataGridWrapper<QalabEquipAlert> dataGridList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            List<QalabEquipAlert> finalList = list(request);
            return new DataGridWrapper<>(finalList, count);
        }
        return null;
    }

    @Override
    public DataTableWrapper<QalabEquipAlert> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QalabEquipAlert> finalList = list(request);
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
