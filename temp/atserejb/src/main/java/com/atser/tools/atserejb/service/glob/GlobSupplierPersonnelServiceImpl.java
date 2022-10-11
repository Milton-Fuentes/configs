/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserejb.service.glob;

import com.atser.tools.atserejb.dao.glob.GlobSupplierPersonnelDao;
import com.atser.tools.atserejb.model.GlobSupplierPersonnel;
import com.atser.tools.atserejb.common.util.IBaseEJBException;
import com.atser.tools.atserutil.number.NumberSupport;
import com.atser.tools.atserutil.objects.to.DataTableWrapper;
import com.atser.tools.atserutil.rest.interceptor.manageit.request.ManageITBodyRequest;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class GlobSupplierPersonnelServiceImpl implements GlobSupplierPersonnelService, IBaseEJBException {

    @Inject
    private GlobSupplierPersonnelDao dao;

    @Override
    public GlobSupplierPersonnel findById(String id) {
        return dao.findById(NumberSupport.getBigDecimal(id));
    }

    public GlobSupplierPersonnel findById(BigDecimal id) {
        return dao.findById(id);
    }

    @Override
    public void save(GlobSupplierPersonnel elem) {
        if (elem != null) {
            dao.save(elem);
        }
    }

    @Override
    public void update(GlobSupplierPersonnel elem) {
        if (elem != null) {
            GlobSupplierPersonnel model = findById(elem.getId());
            if (!model.equals(elem)) {
                model = populateForUpdate(elem, model);
                dao.update(model);
            }
        }
    }

    private GlobSupplierPersonnel populateForUpdate(GlobSupplierPersonnel elem, GlobSupplierPersonnel model) {
        model.setContactName(elem.getContactName());
        model.setPhone(elem.getPhone());
        model.setCell(elem.getCell());
        model.setFax(elem.getFax());
        model.setAddress(elem.getAddress());
        model.setCity(elem.getCity());
        model.setState(elem.getState());
        model.setZip(elem.getZip());
        model.setEmail(elem.getEmail());
        model.setContactTitle(elem.getContactTitle());        
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
    public List<GlobSupplierPersonnel> list(ManageITBodyRequest request) {
        List<GlobSupplierPersonnel> list;
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
    public DataTableWrapper<GlobSupplierPersonnel> dataTableList(ManageITBodyRequest request) {
        if (request != null && (request.getFilter() != null || request.getSorted() != null)) {
            Long count = dao.getTotal(request.getFilterWithOutLikes());
            Long filtered;
            List<GlobSupplierPersonnel> finalList = list(request);
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
