/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.dao.qm.QmProjContrPersDao;
import com.atser.tools.atserejb.model.QmProjContrPers;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QmProjContrPersServiceImpl implements QmProjContrPersService, IBaseEJBException {

    @Inject
    private QmProjContrPersDao dao;

    @Override
    public QmProjContrPers findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QmProjContrPers findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QmProjContrPers elem) {
        if (elem != null) {
            if (elem.getMain() == 'Y' || elem.getMain() == 'y') {
                updateMainSelect(elem.getProjContrPersId().getId());
            }
            dao.save(elem);
        }
    }

    @Override
    public void update(QmProjContrPers elem) {
        if (elem != null) {
            if (elem.getMain() == 'Y' || elem.getMain() == 'y') {
                updateMainSelect(elem.getProjContrPersId().getId());
            }
            QmProjContrPers model = findById(elem.getId());
            if (!model.equals(elem)) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private QmProjContrPers populateForUpdate(QmProjContrPers elem, QmProjContrPers model) {
        model.setPersonnelId(elem.getPersonnelId());
        model.setProjContrPersId(elem.getProjContrPersId());
        model.setMain(elem.getMain());
        
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QmProjContrPers> list(ManageITBodyRequest request) {
        List<QmProjContrPers> list;
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            list = dao.filter(request.getFilter(), request.getSorted(), request.getPaging());
        } else {
            list = dao.findAll();
        }
        return list;
    }

    @Override
    public Long getTotal(ManageITBodyRequest request) {
        if (request != null && request.getFilter() != null) {
            return dao.getTotal(request.getFilter());
        }
        return -1L;
    }

    @Override
    public DataTableWrapper<QmProjContrPers> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QmProjContrPers> finalList = list(request);
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

    @Override
    public Boolean checkMain(BigDecimal contractId) {
        List<QmProjContrPers> list = list(new ManageITBodyRequest(0, 1).filter("projContrPersId.id", contractId).filter("main", "Y").filter("active", "Y"));
        return !list.isEmpty();
    }

    private void updateMainSelect(BigDecimal contractId) {
        List<QmProjContrPers> list = list(new ManageITBodyRequest(0, 0).filter("projContrPersId.id", contractId).filter("main", "Y").filter("active", "Y"));
        list.forEach(it -> {
            it.setMain('N');
            dao.update(it);
        });

    }

}
