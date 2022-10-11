/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QalabEquipcondDao;
import com.atser.tools.atserejb.model.QalabEquipcond;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QalabEquipcondServiceImpl implements QalabEquipcondService, IBaseEJBException {

    @Inject
    private QalabEquipcondDao dao;

    @Override
    public QalabEquipcond findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QalabEquipcond findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QalabEquipcond elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QalabEquipcond elem) {
        if (elem != null) {
            QalabEquipcond model = findById(elem.getId());
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
    public List<QalabEquipcond> list(ManageITBodyRequest request) {
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
    public Object getVersion(Integer number) {
        return dao.getVersion(number);
    }

    @Override
    public List getRevisions(String id) {
        return dao.getRevisions(NumberSupport.getBigDecimal(id));
    }

}
