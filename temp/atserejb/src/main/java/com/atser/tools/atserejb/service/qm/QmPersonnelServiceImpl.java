/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.qm;

import com.atser.tools.atserejb.dao.qm.QmPersonnelDao;
import com.atser.tools.atserejb.model.QmPersonnel;
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
public class QmPersonnelServiceImpl implements QmPersonnelService, IBaseEJBException {

    @Inject
    private QmPersonnelDao dao;

    @Override
    public QmPersonnel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public QmPersonnel findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(QmPersonnel elem) {
        if (elem != null) {
            if (elem.getMain() == 'Y' || elem.getMain() == 'y') {
                updateMainPersonnelList(elem.getContractorPersonnelId());
            }
            dao.save(elem);
        }
    }

    @Override
    public void update(QmPersonnel elem) {
        if (elem != null) {
            if (elem.getMain() == 'Y' || elem.getMain() == 'y') {
                updateMainPersonnelList(elem.getContractorPersonnelId());
            }
            QmPersonnel model = findById(elem.getId());
            if (!model.equals(elem)) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private QmPersonnel populateForUpdate(QmPersonnel elem, QmPersonnel model) {
        model.setFirstname(elem.getFirstname());
        model.setMiddlename(elem.getMiddlename());
        model.setLastname(elem.getLastname());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setZip(elem.getZip());
        model.setTitle(elem.getTitle());
        model.setEmail(elem.getEmail());
        model.setMain(elem.getMain());
        model.setFax(elem.getFax());
        return model;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            dao.delete(NumberSupport.getBigDecimal(id));
        }
    }

    @Override
    public List<QmPersonnel> list(ManageITBodyRequest request) {
        List<QmPersonnel> list;
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
    public DataTableWrapper<QmPersonnel> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<QmPersonnel> finalList = list(request);
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
        List<QmPersonnel> list = list(new ManageITBodyRequest(0, 1).filter("contractorPersonnelId", contractId).filter("main", "Y").filter("active", "Y"));
        return !list.isEmpty();
    }

    private void updateMainPersonnelList(BigInteger contractId) {
        List<QmPersonnel> list = list(new ManageITBodyRequest(0, 0).filter("contractorPersonnelId", contractId).filter("main", "Y").filter("active", "Y"));
        list.forEach(it -> {
            it.setMain('N');
            dao.update(it);
        });

    }
}
