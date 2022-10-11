/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaInspectionSimpleCatDao;
import com.atser.tools.atserejb.model.QaInspectionSimpleCat;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QaInspectionSimpleCatServiceImpl implements QaInspectionSimpleCatService, IBaseEJBException {

    @Inject
    private QaInspectionSimpleCatDao dao;

    @Override
    public QaInspectionSimpleCat findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    @Override
    public QaInspectionSimpleCat findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QaInspectionSimpleCat elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaInspectionSimpleCat elem) {
        if (elem != null) {
            QaInspectionSimpleCat model = findById(elem.getId());
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
    public List<QaInspectionSimpleCat> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

}
