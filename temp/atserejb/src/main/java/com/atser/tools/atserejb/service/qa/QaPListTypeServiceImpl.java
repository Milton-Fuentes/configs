/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qa;

import com.atser.tools.atserejb.dao.qa.QaPListTypeDao;
import com.atser.tools.atserejb.model.QaPListType;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataSelectWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QaPListTypeServiceImpl implements QaPListTypeService, IBaseEJBException {

    @Inject
    private QaPListTypeDao dao;

    @Override
    public QaPListType findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QaPListType findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QaPListType elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(QaPListType elem) {
        if (elem != null) {
            QaPListType model = findById(elem.getId());
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
    public List<QaPListType> list(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            return dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        }
        return dao.findAll();
    }

    @Override
    public List<DataSelectWrapper> listForSelect(ManageITBodyRequest request) {
        List<DataSelectWrapper> rlist = new ArrayList<>();
        List<QaPListType> list = list(request);
        list.forEach(it -> {
            rlist.add(new DataSelectWrapper(it.getId(), it.getItemType()));
        });
        return rlist;
    }

}
